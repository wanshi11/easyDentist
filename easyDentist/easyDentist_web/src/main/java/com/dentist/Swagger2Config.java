package com.dentist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 
 * @author xyj
 *
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
	//swagger2�������ļ��������������swagger2��һЩ���������ݣ�����ɨ��İ��ȵ�
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //Ϊ��ǰ��·��
                .apis(RequestHandlerSelectors.basePackage("com.dentist.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //���� api�ĵ�����ϸ��Ϣ����,ע�������ע�����õ����ĸ�
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //ҳ�����
                .title("SpringBootʹ��Swagger2����API�ĵ�")
                //����
                .description("restful����API")
                //������
                //.termsOfServiceUrl(termsOfServiceUrl)
                //�汾��
                .version("1.0")
                .build();
    }
 
 
}
