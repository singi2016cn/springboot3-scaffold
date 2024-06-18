package top.singi.springboot3_scaffold.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import top.singi.springboot3_scaffold.entity.City;
import top.singi.springboot3_scaffold.mapper.CityMapper;
import top.singi.springboot3_scaffold.service.CityService;

@Controller
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityService cityService;

    @Autowired
    CityMapper cityMapper;

    @GetMapping
    public Map<String,Object> index(
        @RequestParam(required = false, defaultValue = "") String search,
        @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
        @RequestParam(name = "per_page", required = false, defaultValue = "10") Integer perPage
    ) {
        LambdaQueryChainWrapper<City> lambdaQueryChainWrapper = new LambdaQueryChainWrapper<>(City.class);
        
        if (!search.isBlank()) {
            lambdaQueryChainWrapper.like(City::getName, search);
        }
        
        IPage<City> pageRes = lambdaQueryChainWrapper.page(new Page<>(page, perPage));
        
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("items", pageRes.getRecords());
        hashMap.put("total", pageRes.getTotal());
        return hashMap;
    }

    @GetMapping("/{id}")
    public City show(@PathVariable Integer id) {
        return cityService.getById(id);
    }

    @GetMapping("/{id}/province")
    public City showCities(@PathVariable Integer id) {
        return cityMapper.cityWithProince(id);
    }
}
