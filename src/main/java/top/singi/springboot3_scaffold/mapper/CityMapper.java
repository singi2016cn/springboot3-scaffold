package top.singi.springboot3_scaffold.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import top.singi.springboot3_scaffold.entity.City;

@Mapper
public interface CityMapper extends BaseMapper<City> {
    City cityWithProvince(Integer id);
}
