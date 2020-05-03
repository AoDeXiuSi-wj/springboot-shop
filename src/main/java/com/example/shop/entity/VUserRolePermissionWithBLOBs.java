package com.example.shop.entity;

import java.io.Serializable;

/**
 * v_user_role_permission
 * @author 
 */
public class VUserRolePermissionWithBLOBs extends VUserRolePermission implements Serializable {


    private String rolenames;

    private String permissions;

    private static final long serialVersionUID = 1L;

    public VUserRolePermissionWithBLOBs(Integer uid,String uname,String rolenames, String permissions) {
        super(uid,uname);
        this.rolenames = rolenames;
        this.permissions = permissions;
    }

    public String getRolenames() {
        return rolenames;
    }

    public void setRolenames(String rolenames) {
        this.rolenames = rolenames;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "VUserRolePermissionWithBLOBs{" +
                "uid='" + super.getUid() + '\'' +
                "uname='" + super.getUname() + '\'' +
                "rolenames='" + rolenames + '\'' +
                ", permissions='" + permissions + '\'' +
                '}';
    }
}