package cn.itcast.service;

import cn.itcast.domain.Permission;

import java.util.List;

public interface PermissionService {


    List<Permission> findAll(Integer page,Integer pageSize);

    void save(Permission p);

    List<Permission> findOtherPermission(Integer roleId);

    void delete(Integer id);

    int findTotal();

    List<Permission> search(String sous, Integer page, Integer pageSize);

    int findCount(String sous);

    Permission findByPeId(Integer id);

    void updated(Integer id, String permissionName, String url);
}
