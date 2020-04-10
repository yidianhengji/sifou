package com.pg.bbs.service.impl;

import com.pg.bbs.dao.UsersMapper;
import com.pg.bbs.dto.UsersSignIn;
import com.pg.bbs.dto.UsersSignUp;
import com.pg.bbs.entity.Users;
import com.pg.bbs.handler.BusinessException;
import com.pg.bbs.handler.BusinessStatus;
import com.pg.bbs.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public int signUp(UsersSignUp usersSignUp) {
        if (usersSignUp.getPhone() == null || usersSignUp.getPhone().isEmpty()) {
            throw new BusinessException(BusinessStatus.PARAMETER_ERROR);
        }
        if (usersSignUp.getNickname() == null || usersSignUp.getNickname().isEmpty()) {
            throw new BusinessException(BusinessStatus.PARAMETER_ERROR);
        }
        if (usersSignUp.getPassword() == null || usersSignUp.getPassword().isEmpty()) {
            throw new BusinessException(BusinessStatus.PARAMETER_ERROR);
        }
        int count = usersMapper.getUserPhone(usersSignUp.getPhone());
        if (count > 0) {
            throw new BusinessException(BusinessStatus.MOBILE_ERROR);
        }
        usersSignUp.setUuid(UUID.randomUUID().toString().replace("-", ""));
        usersSignUp.setPassword(DigestUtils.md5DigestAsHex(usersSignUp.getPassword().getBytes()));
        usersSignUp.setCreateTime(new Date());
        usersSignUp.setModifyTime(new Date());
        return usersMapper.signUp(usersSignUp);
    }

    @Override
    public Users signIn(UsersSignIn usersSignIn) {
        if (usersSignIn.getPhone() == null || usersSignIn.getPhone().isEmpty()) {
            throw new BusinessException(BusinessStatus.PARAMETER_ERROR);
        }
        if (usersSignIn.getPassword() == null || usersSignIn.getPassword().isEmpty()) {
            throw new BusinessException(BusinessStatus.PARAMETER_ERROR);
        }
        Users users = usersMapper.signIn(usersSignIn.getPhone());
        if (users == null) {
            throw new BusinessException(BusinessStatus.USER_ERROR);
        }
        String usedPassword = users.getPassword();
        String newPassword = DigestUtils.md5DigestAsHex(usersSignIn.getPassword().getBytes());
        // 比较密码是否一致
        if (!usedPassword.equals(newPassword)) {
            throw new BusinessException(BusinessStatus.PASSWORD_ERROR);
        }
        return users;
    }
}
