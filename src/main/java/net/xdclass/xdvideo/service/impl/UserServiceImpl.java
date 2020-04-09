package net.xdclass.xdvideo.service.impl;

import net.xdclass.xdvideo.domain.User;
import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.mapper.UserMapper;
import net.xdclass.xdvideo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll ( ){
        return userMapper.findAll();
    }

    @Override
    public User findById ( int id ){
        return userMapper.findById(id);
    }

    @Override
    public int update ( User user){
        return userMapper.update(user);
    }

    @Override
    public int delete ( int id ){
        return userMapper.delete(id);
    }

    @Override
    public int save ( User user ){
        return userMapper.save(user);
    }


}
