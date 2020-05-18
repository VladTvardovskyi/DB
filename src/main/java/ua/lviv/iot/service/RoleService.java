package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Role;
import ua.lviv.iot.model.RolePK;
import ua.lviv.iot.repository.RoleRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Role getById(RolePK id) {
        return roleRepository.findById(id).get();
    }

    @Transactional
    public void create(Role role) {
        roleRepository.save(role);
    }

    @Transactional
    public void update(Role role, RolePK id) {
        if (roleRepository.findById(id).isPresent()) {
            Role oldRole = roleRepository.findById(id).get();
            oldRole.setRole(role.getRole());
        }
    }

    @Transactional
    public void delete(RolePK id) {
        if (roleRepository.findById(id).isPresent()) {
            roleRepository.deleteById(id);
        }
    }
}
