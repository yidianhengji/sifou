package com.pg.bbs.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.pg.bbs.entity.Users;
import com.pg.bbs.handler.BusinessException;
import com.pg.bbs.handler.BusinessStatus;
import com.pg.bbs.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Value("${jwt.secretkey}")
    private String jwtSecretkey;

    @Value("${jwt.path}")
    private String jwtPath;

    @Autowired
    private UsersService usersService;

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
        // 获取token
        String token = httpServletRequest.getHeader("token");
        // 获取调用的地址
        String requestURI = httpServletRequest.getRequestURI();
        // 获取要校验的地址
        String[] strArray = jwtPath.split(",");
        for (String path : strArray) {
            if (path.equals(requestURI)) {
                // 判断是否存在token
                if (token == null) {
                    throw new BusinessException(BusinessStatus.NO_TOKEN);
                }
                // 判断token是否有效
                JWTVerifier verifier = JWT.require(Algorithm.HMAC256(jwtSecretkey)).build();
                try {
                    verifier.verify(token);
                } catch (JWTVerificationException j) {
                    throw new BusinessException(BusinessStatus.NO_TOKEN_INVALID);
                }
                // 判断用户是否存在
                String userid;
                try {
                    userid = JWT.decode(token).getAudience().get(0);
                } catch (JWTVerificationException e) {
                    throw new BusinessException(BusinessStatus.NO_USER_INVALID);
                }
                Users user = usersService.findUserById(userid);
                if (user == null) {
                    throw new BusinessException(BusinessStatus.NO_USER_INVALID);
                }
            }
        }
        return true;
    }
}
