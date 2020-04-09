package net.xdclass.xdvideo.service;

import net.xdclass.xdvideo.domain.User;
import net.xdclass.xdvideo.domain.Video;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();

    User findById(int id);

    int update(User user);

    int delete(int id);

    int save(User user);
}
