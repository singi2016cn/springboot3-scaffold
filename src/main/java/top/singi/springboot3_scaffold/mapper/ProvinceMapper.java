package top.singi.springboot3_scaffold.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import top.singi.springboot3_scaffold.entity.Province;

public interface ProvinceMapper extends BaseMapper<Province> {
    Province provinceWithCities(Integer id);
}
