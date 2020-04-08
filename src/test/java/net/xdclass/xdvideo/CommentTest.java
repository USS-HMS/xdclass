package net.xdclass.xdvideo;

import io.jsonwebtoken.Claims;
import net.xdclass.xdvideo.domain.User;
import net.xdclass.xdvideo.utils.JwtUtils;
import org.junit.Test;

public class CommentTest {
    @Test
    public void testGeneToken(){
        User user=new User();
        user.setId(909);
        user.setName("xs");
        user.setHeadImg("www.xdclass.net");

        String token=JwtUtils.grnrJsonWebToken(user);
        System.out.println(token);
    }
    @Test
    public void testCheck(){
        String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZGNsYXNzIiwiaWQiOjkwOSwibmFtZSI6InhzIiwiaW1nIjoid3d3LnhkY2xhc3MubmV0IiwiaWF0IjoxNTg2MzY1Mzk0LCJleHAiOjE1ODY5NzAxOTR9.uFthV3Tyyn1mp95zGm6dI2CmL78GZaoIqa_cLwdhbVU";
        Claims claims=JwtUtils.checkJwt(token);
        if (claims!=null){
            String name=(String) claims.get("name");
            int id=(Integer) claims.get("id");
            String img=(String) claims.get("img");
            System.out.println(name);
            System.out.println(id);
            System.out.println(img);
        }else {
            System.out.println("wu");
        }
    }
}
