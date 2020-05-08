package com.example.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.shop.dao.VRolePermissionExample;
import com.example.shop.dao.VRolePermissionMapper;
import com.example.shop.entity.VRolePermission;
import com.example.shop.service.VRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service()
public class VRolePermissionServiceImpl implements VRolePermissionService {
    @Resource
    private VRolePermissionMapper vrpMapper;
    @Override
    public String selectByExampleWithBLOBs(Integer pageIdx,Integer pageNum) {
        VRolePermissionExample vurpExample=new VRolePermissionExample();
        vurpExample.setOrderByClause("rid asc limit "+(pageIdx*pageNum-pageNum > 0 ? pageIdx*pageNum-pageNum:0)+","+(pageIdx*pageNum));
        long count = vrpMapper.countByExample(vurpExample);
        List<VRolePermission> vRolePermissionList = vrpMapper.selectByExampleWithBLOBs(vurpExample);

        JSONObject json= new JSONObject(true);
        if (count == 0){
            json.put("code",-1);
            json.put("msg","尚未保存任何数据！");
            json.put("count",0);
        }else {
            json.put("code",0);
            json.put("msg","查询成功！");
            json.put("count",count);
        }
        LinkedList<JSONObject> dataList = new LinkedList<JSONObject>();
        for (VRolePermission vrp:vRolePermissionList){
            dataList.add((JSONObject) JSONObject.toJSON(vrp));
        }
        json.put("data",dataList);
        System.out.println(json.toString());
        return json.toString();
    }
}