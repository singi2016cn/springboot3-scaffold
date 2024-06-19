package top.singi.springboot3_scaffold.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import top.singi.springboot3_scaffold.entity.Province;

@Mapper
public interface ProvinceMapper extends BaseMapper<Province> {
    Province provinceWithCities(Integer id);
}
