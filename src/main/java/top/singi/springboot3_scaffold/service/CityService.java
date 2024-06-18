package top.singi.springboot3_scaffold.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import top.singi.springboot3_scaffold.entity.City;
import top.singi.springboot3_scaffold.mapper.CityMapper;

@Service
public class CityService extends ServiceImpl<CityMapper,City> {

}
