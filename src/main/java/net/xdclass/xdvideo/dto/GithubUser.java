package net.xdclass.xdvideo.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;

}
