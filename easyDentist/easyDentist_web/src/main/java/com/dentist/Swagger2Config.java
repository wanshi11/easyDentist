/*package com.dentist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


*//**
 * 
 * @author xyj
 *
 *//*

@Configuration
@EnableSwagger2
public class Swagger2Config {
	//swagger2鐨勯厤缃枃浠讹紝杩欓噷鍙互閰嶇疆swagger2鐨勪竴浜涘熀鏈殑鍐呭锛屾瘮濡傛壂鎻忕殑鍖呯瓑绛�
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //涓哄綋鍓嶅寘璺緞
                .apis(RequestHandlerSelectors.basePackage("com.dentist.controller"))
                .paths(PathSelectors.any())
                .build();
    }
  //鏋勫缓 api鏂囨。鐨勮缁嗕俊鎭嚱鏁�娉ㄦ剰杩欓噷鐨勬敞瑙ｅ紩鐢ㄧ殑鏄摢涓�
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                 //椤甸潰鏍囬
                .title("SpringBoot闆嗘垚Swagger2鍦ㄧ嚎API鏂囨。")
                //鎻忚堪
                .description("restful椋庢牸鐨凙PI")
                //.termsOfServiceUrl(termsOfServiceUrl)
                //鐗堟湰
                .version("1.0")
                .build();
    }
 
 
}
*/