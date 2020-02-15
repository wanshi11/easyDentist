package com.dentist.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.dentist.interceptor.SecurityInterceptor;

/**
 * 配置自定义静态资源引用 
 * AND
 * 拦截器注入
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
	
	
	
	  @Bean  //注入拦截器
	  public SecurityInterceptor securityInterceptor() {
	        return new SecurityInterceptor();
	  }
	
	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
	 registry.addInterceptor(securityInterceptor()).addPathPatterns("/admin/**");
	 
	 super.addInterceptors(registry);
	 }
	 
	 
	 
	//springboot统一页码处理配置
		@Bean
		public EmbeddedServletContainerCustomizer containerCustomizer() {
		    return new EmbeddedServletContainerCustomizer() {
		        @Override
		        public void customize(ConfigurableEmbeddedServletContainer container) {
		            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/Err404.html");
		            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/Err500.html");
	 
		            container.addErrorPages( error404Page, error500Page);
		        }
		    };
		}

	 
	 
	 
	 
	 
	
}