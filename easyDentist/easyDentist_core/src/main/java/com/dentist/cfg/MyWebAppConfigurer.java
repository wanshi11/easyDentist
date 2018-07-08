package com.dentist.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置自定义静态资源引用
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter{
	
	
	@Value("${pic_db_Path}")
	private String pic_db_Path;  //虚拟图片路径
	
	@Value("${picPath}")
	private String picPath;  //真实图片磁盘路径
	
	
	@Value("${kindeditor_files_path}")
	private String kindeditor_files_path;
	
	@Value("${kindeditor_files_db_path}")
	private String kindeditor_files_db_path;

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//图片上传路径地址配置
        registry.addResourceHandler(pic_db_Path+"**").addResourceLocations("file:"+picPath);
        
        //kindeditor文件上传路径地址配置
        registry.addResourceHandler(kindeditor_files_db_path+"**").addResourceLocations("file:"+kindeditor_files_path);
        super.addResourceHandlers(registry);
    }
	
}