package top.singi.springboot3_scaffold.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import top.singi.springboot3_scaffold.constant.CommonConstant;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@DateTimeFormat(pattern = CommonConstant.DATE_TIME_FORMAT_PATTERN)
@JsonFormat(pattern = CommonConstant.DATE_TIME_FORMAT_PATTERN, timezone = CommonConstant.DATE_TIME_FORMAT_TIMEZONE_GMT8)
public @interface DateTimeAndJsonFormatAnnotation {}
