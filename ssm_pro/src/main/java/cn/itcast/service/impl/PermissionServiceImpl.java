package cn.itcast.service.impl;

import cn.itcast.dao.permissionDao;
import cn.itcast.domain.Permission;
import cn.itcast.service.PermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("permissionService")
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private permissionDao dao;
    @Override
    public List<Permission> findAll(Integer page,Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return dao.findAll();
    }

    @Override
    public void save(Permission p) {
        dao.save(p);
    }

    @Override
    public List<Permission> findOtherPermission(Integer roleId) {
        return dao.findOtherPermission(roleId);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }

    @Override
    public int findTotal() {
        return dao.findTotal();
    }

    @Override
    public List<Permission> search(String sous, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.search(sous);
    }

    @Override
    public int findCount(String sous) {
        return dao.findCount(sous);
    }

    @Override
    public Permission findByPeId(Integer id) {
        return dao.findByPeId(id);
    }

    @Override
    public void updated(Integer id, String permissionName, String url) {
        dao.updated(id,permissionName,url);
    }
}
