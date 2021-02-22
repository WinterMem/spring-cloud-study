package com.pch.gateway.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;

import com.github.xiaoymin.knife4j.core.util.CollectionUtils;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * <P> swagger 文档配置类 </P>
 *
 *
 * @Author: pch
 * @Date: 2021/2/21
 */
//@Configuration
//@EnableSwagger2WebFlux
//@Import(BeanValidatorPluginsConfiguration.class)
// todo knife4j 目前不支持webflux
public class SwaggerConfiguration {

    @Bean(value = "gatewayRouteApi")
    @Order(value = 1)
    public Docket groupRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pch.gateway.rest"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(CollectionUtils.newArrayList(securityContext(), securityContext1()))
                .securitySchemes(CollectionUtils.<SecurityScheme>newArrayList(apiKey(), apiKey1()));
    }

    private ApiInfo groupApiInfo() {
        return new ApiInfoBuilder()
                .title("路由管理")
                .description("<div style='font-size:14px;color:red;'>路由管理 APIs</div>")
                .termsOfServiceUrl("http://www.google.com")
                .contact("group@qq.com")
                .version("1.0")
                .build();
    }


    private ApiKey apiKey() {
        return new ApiKey("BearerToken", "Authorization", "header");
    }

    private ApiKey apiKey1() {
        return new ApiKey("BearerToken1", "Authorization-x", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    private SecurityContext securityContext1() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth1())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return CollectionUtils.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }

    List<SecurityReference> defaultAuth1() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return CollectionUtils.newArrayList(new SecurityReference("BearerToken1", authorizationScopes));
    }

}
