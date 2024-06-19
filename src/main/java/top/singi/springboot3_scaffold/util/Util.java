package top.singi.springboot3_scaffold.util;

import org.springframework.util.StringUtils;
import top.singi.springboot3_scaffold.constant.CommonConstant;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Util {

    /**
     * 格式化日期时间格式
     * @param date 日期
     * @return String
     */
    public static String datetime(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return DateTimeFormatter.ofPattern(CommonConstant.DATE_TIME_FORMAT_PATTERN).format(localDateTime);
    }

    /**
     * 获取 bearer token
     * @param authorization 原始值
     * @return bearerToken
     */
    public static String bearerToken(String authorization) {
        if (StringUtils.hasText(authorization) && authorization.startsWith("Bearer ")) {
            return authorization.substring(7);
        }
        return null;
    }
}
