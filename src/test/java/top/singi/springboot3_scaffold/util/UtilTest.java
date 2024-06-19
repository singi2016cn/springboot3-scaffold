package top.singi.springboot3_scaffold.util;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilTest {

    @Test
    void datetime() {
        assertEquals("2024-06-19 17:25:48", Util.datetime(new Date(1718789148468L)));
    }

    @Test
    void bearerToken() {
        assertEquals("eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIxIiwiaWF0IjoxNzE4Nzg2NzMzLCJleHAiOjE3MTkzOTE1MzN9.rUNP-Dueq54l_J7NOkVpx8k_tPRnPEZf5JRrEeODOwBkZfHRmg1FRzrw62hOJWe_", Util.bearerToken("Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIxIiwiaWF0IjoxNzE4Nzg2NzMzLCJleHAiOjE3MTkzOTE1MzN9.rUNP-Dueq54l_J7NOkVpx8k_tPRnPEZf5JRrEeODOwBkZfHRmg1FRzrw62hOJWe_"));
    }
}