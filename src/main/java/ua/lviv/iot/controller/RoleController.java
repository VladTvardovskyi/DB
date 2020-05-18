package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Role;
import ua.lviv.iot.model.RolePK;
import ua.lviv.iot.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/film_db")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/roles/{id}")
    public Role getById(@PathVariable RolePK id) {
        return roleService.getById(id);
    }

    @PostMapping("/roles")
    public void create(@RequestBody Role role) {
        roleService.create(role);
    }

    @PutMapping("/roles/{id}")
    public void update(@PathVariable RolePK id, @RequestBody Role role) {
        roleService.update(role, id);
    }

    @DeleteMapping("/roles/{id}")
    public void delete(@PathVariable RolePK id) {
        roleService.delete(id);
    }
}
