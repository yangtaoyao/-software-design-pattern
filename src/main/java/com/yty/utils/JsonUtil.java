package com.yty.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class JsonUtil {
    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    private static ObjectMapper om = new ObjectMapper();

    static {
        // 属性为Null的不进行序列化，只对pojo起作用，对map和list不起作用
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // json进行换行缩进等操作
        om.enable(SerializationFeature.INDENT_OUTPUT);
        // json不进行换行缩进等操作  默认就是不进行操作，写了这行和没写的效果一样
//        om.disable(SerializationFeature.INDENT_OUTPUT);

        // json是否允许属性名没有引号 ，默认是false
//        om.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        //json是否允许属性名为单引号 ，默认是false
//        om.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

        // 遇到未知属性是否抛出异常 ，默认是抛出异常的
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 当实体类没有setter方法时，序列化不报错，返回一个空对象
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        // 所有的字母小写，下划线作为名字之间分隔符，例如 snake_case
//        om.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        // 所有名字（包括第一个字符）都以大写字母开头，后跟小写字母，没有分隔符，例如 UpperCamelCase
//        om.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);

        // 第一个单词以小写字母开头，后续每个单词都是大写字母开头，没有分隔符，例如 lowerCamelCase
//        om.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);

        // 所有的字母小写，没有分隔符，例如 lowercase
//        om.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE);

        // “Lisp” 风格，采用小写字母、连字符作为分隔符，例如 “lower-case” 或 “first-name”
//        om.setPropertyNamingStrategy(PropertyNamingStrategy.KEBAB_CASE);
    }

    public static String objertToString(Object obj){
        try {
            return om.writeValueAsString(obj);
        } catch (Exception e) {
            logger.error("json 转换错误", e);
            return null;
        }
    }

    public static Map toMap(Object obj){
        try {
            return om.readValue(objertToString(obj), Map.class);
        } catch (Exception e) {
            logger.error("json 转换错误", e);
            return null;
        }
    }

    public static <T> T strToBean(String str,Class<T> classType){
        try {
            return om.readValue(str, classType);
        } catch (Exception e) {
            logger.error("json 转换错误", e);
            return null;
        }
    }

    public static <T> T strToBean(String str, TypeReference typeReference){
        try {
            return om.readValue(str, typeReference);
        } catch (Exception e) {
            logger.error("json 转换错误", e);
            return null;
        }
    }

}
