package com.pg.bbs.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.pg.bbs.handler.BusinessException;
import com.pg.bbs.handler.BusinessStatus;
import com.pg.bbs.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Component
public class JwtGetUserInterceptor {

    @Value("${jwt.secretkey}")
    private String jwtSecretkey;

    public static String getUserId() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        String userid;
        try {
            userid = JWT.decode(token).getAudience().get(0);
        } catch (JWTVerificationException e) {
            throw new BusinessException(BusinessStatus.NO_USER_INVALID);
        }
        return userid;
    }

}
