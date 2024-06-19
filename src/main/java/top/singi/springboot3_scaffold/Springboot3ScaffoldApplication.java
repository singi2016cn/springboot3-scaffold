package top.singi.springboot3_scaffold;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;

@SpringBootApplication
@MapperScan("top.singi.springboot3_scaffold.mapper")
public class Springboot3ScaffoldApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot3ScaffoldApplication.class, args);
	}

    /**
     * 添加MyBatis Plus插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		// 添加分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
		// 防全表更新与删除插件
		interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        return interceptor;
    }

}
