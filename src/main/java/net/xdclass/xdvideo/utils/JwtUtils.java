package net.xdclass.xdvideo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.xdclass.xdvideo.domain.User;

import java.util.Date;

/**
 * jwt工具类
 */
public class JwtUtils {
    private static final String SUBJECT="xdclass";

    private static final long EXPIRE=1000*60*60*24*7; //过期时间，一周

    private static final String APPSECRET="xs666";

    /**
     * 生成token
     * @param user
     * @return
     */
    public static String grnrJsonWebToken( User user ){
    if (user ==null || user.getId() == null || user.getName() == null
            || user.getHeadImg() ==null){
        return null;
    }

        String token=Jwts.builder().setSubject(SUBJECT)
                .claim("id", user.getId())
                .claim("name", user.getName())
                .claim("img", user.getHeadImg())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();

        return token;
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static Claims checkJwt(String token){
        try{
            Claims claims=Jwts.parser().setSigningKey(APPSECRET).parseClaimsJwt(token).getBody();
            return claims;
        }catch (Exception e){}
        return null;
    }
}
