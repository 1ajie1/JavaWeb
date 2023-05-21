package com.tuleaj.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * 针对Object的base64消息处理器
 */
public class Base64ObjMessageConverter extends AbstractHttpMessageConverter<Object> {

    public Base64ObjMessageConverter() {
        // 新建一个我们自定义的媒体类型application/base64obj
        super(new MediaType("application", "base64obj", Charset.forName("UTF-8")));
    }


    @Override
    protected boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String source = new String(Base64.getDecoder().decode(StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"))), "UTF-8");
        return new ObjectMapper().readValue(source, clazz);
    }

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        byte[] encode = Base64.getEncoder().encode(new ObjectMapper().writeValueAsString(obj).getBytes());
        outputMessage.getBody().write(encode);
    }
}