package top.singi.springboot3_scaffold.util;

import org.springframework.util.StringUtils;
import top.singi.springboot3_scaffold.constant.CommonConstant;

import java.text.SimpleDateFormat;

public class Util {

    /**
     * 格式化日期时间格式
     * @param datetime 日期时间
     * @return String
     */
    public static String datetime(Object datetime) {
        return new SimpleDateFormat(CommonConstant.DATE_TIME_FORMAT_PATTERN).format(datetime);
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
