package com.hu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hu.dao.HouseDAO;
import com.hu.entity.HouseEntity;
import com.hu.service.HouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HouseImpl extends ServiceImpl<HouseDAO, HouseEntity> implements HouseService {

    @Resource
    private HouseDAO dao;

    @Override
    public int count(HouseEntity house) {
        return this.dao.count(house);
    }

    @Override
    public List<HouseEntity> getAll(HouseEntity house) {
        List<HouseEntity> ar = dao.getAll(house);
        for (HouseEntity HouseEntity : ar) {
            String t = HouseEntity.getHimg();

            String tt[] = t.split("、");
            for (int i = 0; i < tt.length; i++) {
                tt[i] = "http://192.168.2.106:8080/fwcz/upload/" + tt[i];
            }
            HouseEntity.setImgs(tt);
        }
        return ar;
    }

    @Override
    public void houseAdd(HouseEntity house) {

        this.dao.houseAdd(house);
    }

    @Override
    public HouseEntity houseOne(int hid) {
        HouseEntity house = dao.houseOne(hid);
      //  if(house !=null){
            String t = house.getHimg();
            String tt[] = t.split("、");
            for (int i = 0; i < tt.length; i++) {
                tt[i] = "http://localhost:8080/upload/" + tt[i];
            }
            house.setImgs(tt);
       // }
        return house;
    }

    @Override
    public void houseUpd(HouseEntity house) {
        this.dao.houseUpd(house);
    }

    @Override
    public void houseDel(int hid) {
        this.dao.houseDel(hid);
    }

    @Override
    public int houseCkName(String name) {
        return this.dao.houseCkName(name);
    }
}
