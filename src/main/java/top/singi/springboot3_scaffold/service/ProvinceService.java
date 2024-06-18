package top.singi.springboot3_scaffold.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import top.singi.springboot3_scaffold.entity.Province;
import top.singi.springboot3_scaffold.mapper.ProvinceMapper;

@Service
public class ProvinceService extends ServiceImpl<ProvinceMapper,Province> {

}
