package net.xdclass.xdvideo.mapper;

import net.xdclass.xdvideo.domain.User;
import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.provider.VideoProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(int id);

    @UpdateProvider(type=VideoProvider.class,method="updateVideo")
    int update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    int delete(int id);

    @Insert("insert user (name,create_time) value(#{name},#{createTime})")
    int save(User user);

}
