package net.xdclass.xdvideo.controller.admin;

import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.service.impl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/admin/api/vi/video")
public class VideoAdminController {
    @Autowired
    private VideoServiceImpl videoService;
    /**
     * 根据id删除视频
     * @param videoId
     * @return
     */
    @DeleteMapping("del_by_id")
    public Object delById(@RequestParam(value="video_id")int videoId){
        return videoService.delete(videoId);
    }

    /**
     * 根据id跟新视频
     * @param video
     * @return
     */
    @PutMapping("update_by_id")
    public Object upDate(@RequestBody Video video){

        return videoService.update(video);
    }

    /**
     * 保存视频对象
     * @param video
     * @return
     */
    @PostMapping("save")
    public Object save(@RequestBody Video video){

        return videoService.save(video);
    }
}
