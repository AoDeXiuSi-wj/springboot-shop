package com.example.shop.service.impl;

import com.example.shop.ShopApplication;
import com.example.shop.dao.VUserRolePermissionExample;
import com.example.shop.entity.VUserRolePermissionWithBLOBs;
import com.example.shop.service.VUserRolePermissionWithBLOBsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class VUserRolePermissionWithBLOBsImplTest {
    @Resource
    private VUserRolePermissionWithBLOBsService vs;
    @Test
    public void selectByExampleWithBLOBs() {
        VUserRolePermissionExample vurpExample=new VUserRolePermissionExample();
        vurpExample.setOrderByClause("uid asc");
        VUserRolePermissionExample.Criteria vsCriteria = vurpExample.createCriteria();
        List<VUserRolePermissionWithBLOBs> vurpList=vs.selectByExampleWithBLOBs(vurpExample);
        for (VUserRolePermissionWithBLOBs vsp:vurpList
             ) {
            System.out.println("88888:"+vsp.toString());
        }
    }
}