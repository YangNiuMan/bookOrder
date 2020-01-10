package cn.itcast.service.impl;

import cn.itcast.dao.roleDao;
import cn.itcast.domain.Role;
import cn.itcast.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private roleDao dao;

    @Override
    public List<Role> findAll(Integer page,Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return dao.findAll();
    }

    @Override
    public void save(Role role) {
        dao.save(role);
    }

    @Override
    public Role findByRoleId(Integer roleId) {
        return dao.findByRoleId(roleId);
    }

    @Override
    public void addPermissionToRole(Integer roleId, Integer[] ids) {
        for (Integer id : ids) {
            dao.addPermissionToRole(roleId,id);
        }
    }

    @Override
    public int findTotal() {
        return dao.findTotal();
    }

    @Override
    public void delete(Integer roleId) {
        dao.delete(roleId);
    }

    @Override
    public List<Role> search(String sous, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);

        return  dao.search(sous);
    }

    @Override
    public int findCount(String sous) {
        return dao.findCount(sous);
    }

    @Override
    public void updated(Integer roleId, String roleName, String roleDesc) {
        dao.updated(roleId,roleName,roleDesc);
    }

    @Override
    public Role findById(Integer roleId) {
        return dao.findById(roleId);
    }

}
