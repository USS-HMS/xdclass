package net.xdclass.xdvideo.controller;

import net.xdclass.xdvideo.domain.User;
import net.xdclass.xdvideo.dto.AccessTokenDTO;
import net.xdclass.xdvideo.dto.GithubUser;
import net.xdclass.xdvideo.provider.GitHubProvider;
import net.xdclass.xdvideo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private GitHubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback ( @RequestParam(name="code") String code,
                             @RequestParam(name="state") String state,
                             HttpServletRequest request){

        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_secret(clientSecret);

        String accessToken=githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser=githubProvider.getUser(accessToken);

        System.out.println("user.getId()：" + githubUser.getId());
        System.out.println("user.getId()：" + githubUser.getName());

        if (githubUser != null && githubUser.getId() != null) {
            User user=new User();
            user.setName(githubUser.getName());
            user.setCreateTime(new Date(System.currentTimeMillis()));
            userServiceImpl.save(user);
        }


            if (githubUser != null) {
                //登录成功 写入cookie和session
                request.getSession().setAttribute("user", githubUser);
                return "redirect:/";
            } else {
                //登录失败  重新登录
                return "redirect:/";
            }
        }
        @RequestMapping("/")
        public String index () {
            return "login";
        }
    }
