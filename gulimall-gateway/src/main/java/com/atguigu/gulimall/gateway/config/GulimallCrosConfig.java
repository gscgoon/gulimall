package com.atguigu.gulimall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author Super
 * @date 2020-05-13 21:14
 */
@Configuration
public class GulimallCrosConfig {
    @Bean
    public CorsWebFilter corsWebFilter ()
    {
        //基于url的跨域
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //跨域配置类
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        //添加跨域配置
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        //任意请求来源
        corsConfiguration.addAllowedOrigin("*");
        //允许携带cookie进行跨域
        corsConfiguration.setAllowCredentials(true);

        source.registerCorsConfiguration("/**",corsConfiguration);

        return new CorsWebFilter(source);
    }

}
