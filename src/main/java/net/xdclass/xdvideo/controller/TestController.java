package net.xdclass.xdvideo.controller;

import net.xdclass.xdvideo.config.WeChatConfig;

import net.xdclass.xdvideo.domain.JsonData;
import net.xdclass.xdvideo.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class TestController {

	@RequestMapping("test")
	public String test(){
		System.out.println("xdclass.net");
		return "hello xdclass.net777";
	}

	@Autowired
	private WeChatConfig weChatConfig;
	@RequestMapping("test_config")
	public JsonData testConfig(){
		System.out.println(weChatConfig.getAppId());
		return JsonData.buildSuccess(weChatConfig.getAppId());
	}
	@Autowired
	private VideoMapper videoMapper;
	@RequestMapping("test_db")
	public Object testVM(){

		return videoMapper.findAll();
	}

	@GetMapping("/lo")
	public String alogin(){
		return "login";
	}
	
}
