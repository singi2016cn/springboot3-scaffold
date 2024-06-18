package top.singi.springboot3_scaffold.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import top.singi.springboot3_scaffold.entity.City;

public interface CityMapper extends BaseMapper<City> {
    City cityWithProince(Integer id);
}
