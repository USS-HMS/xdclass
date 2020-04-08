package net.xdclass.xdvideo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.service.impl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/api/vi/video")
public class VideoController {
    @Autowired
    private VideoServiceImpl videoService;

    /**
     * 分页接口
     * @param page 当前第几页，默认第一页
     * @param size 每页显示几条
     * @return
     */
    @GetMapping("page")
    public Object pageVideo(@RequestParam(value="page",defaultValue="1") int page,
                            @RequestParam(value="size",defaultValue="10") int size){
        PageHelper.startPage(page, size);
        List<Video> list=videoService.findAll();
        PageInfo<Video> pageInfo = new PageInfo<>(list);
        HashMap<String, Object> data=new HashMap<>();
        data.put("total_size",pageInfo.getTotal());
        data.put("total_page",pageInfo.getPages());
        data.put("current_page",page);
        data.put("data",pageInfo.getList());
        return data;
    }

    /**
     * 根据id查找视频
     * @param videoId
     * @return
     */
    @GetMapping("find_by_id")
    public Object findById(@RequestParam(value="video_id") int videoId){
        return videoService.findById(videoId);
    }



}
