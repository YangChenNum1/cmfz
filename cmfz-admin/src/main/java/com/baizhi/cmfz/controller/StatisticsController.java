package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Statistics;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by HP on 2018/7/9.
 */
@Controller
@RequestMapping("statistics")
public class StatisticsController {

    @RequestMapping("/peopleDistribution")
    public @ResponseBody List<Statistics> searchPeopleDistribution(){

        List<Statistics> list=new ArrayList<Statistics>();
        list.add(new Statistics("北京", new Random().nextInt(1000)));
        list.add(new Statistics("天津", new Random().nextInt(1000)));
        list.add(new Statistics("上海", new Random().nextInt(1000)));
        list.add(new Statistics("重庆", new Random().nextInt(1000)));
        list.add(new Statistics("河北", new Random().nextInt(1000)));
        list.add(new Statistics("河南", new Random().nextInt(1000)));
        list.add(new Statistics("云南", new Random().nextInt(1000)));
        list.add(new Statistics("辽宁", new Random().nextInt(1000)));
        list.add(new Statistics("黑龙江", new Random().nextInt(1000)));
        list.add(new Statistics("湖南", new Random().nextInt(1000)));
        list.add(new Statistics("安徽", new Random().nextInt(1000)));
        list.add(new Statistics("山东", new Random().nextInt(1000)));
        list.add(new Statistics("山西", new Random().nextInt(1000)));
        list.add(new Statistics("新疆", new Random().nextInt(1000)));
        list.add(new Statistics("江苏", new Random().nextInt(1000)));
        list.add(new Statistics("浙江", new Random().nextInt(1000)));
        list.add(new Statistics("江西", new Random().nextInt(1000)));
        list.add(new Statistics("湖北", new Random().nextInt(1000)));
        list.add(new Statistics("广西", new Random().nextInt(1000)));
        list.add(new Statistics("广东", new Random().nextInt(1000)));
        list.add(new Statistics("甘肃", new Random().nextInt(1000)));
        list.add(new Statistics("内蒙古", new Random().nextInt(1000)));
        list.add(new Statistics("陕西", new Random().nextInt(1000)));
        list.add(new Statistics("吉林", new Random().nextInt(1000)));
        list.add(new Statistics("福建", new Random().nextInt(1000)));
        list.add(new Statistics("贵州", new Random().nextInt(1000)));
        list.add(new Statistics("青海", new Random().nextInt(1000)));
        list.add(new Statistics("西藏", new Random().nextInt(1000)));
        list.add(new Statistics("四川", new Random().nextInt(1000)));
        list.add(new Statistics("宁夏", new Random().nextInt(1000)));
        list.add(new Statistics("海南", new Random().nextInt(1000)));
        list.add(new Statistics("台湾", new Random().nextInt(1000)));
        list.add(new Statistics("香港", new Random().nextInt(1000)));
        list.add(new Statistics("澳门", new Random().nextInt(1000)));
        return list;
    }
}
