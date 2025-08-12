package com.rainy.video.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

/**
 * @author Jacky
 * @date 2025/8/12
 **/

@Configuration
public class FastJsonConfigBean {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 创建 Fastjson 转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        // 配置 Fastjson
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,      // 美化输出
                SerializerFeature.WriteMapNullValue, // 输出空值
                SerializerFeature.WriteDateUseDateFormat, // 日期格式化
                SerializerFeature.DisableCircularReferenceDetect //关闭引用检测
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);

        // 设置支持的媒体类型
        fastConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));

        return new HttpMessageConverters(fastConverter);
    }
}
