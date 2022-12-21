package org.school.management.api.seeder;

import org.school.management.api.entities.Role;
import org.school.management.api.enums.UserRole;
import org.school.management.api.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataBaseSeeder {

    @Autowired
    RoleRepository roleRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedRoles();
    }

    private void seedRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1L, UserRole.ROLE_USER));
        roles.add(new Role(2L, UserRole.ROLE_MODERATOR));
        roles.add(new Role(3L, UserRole.ROLE_ADMIN));
        roleRepository.saveAll(roles);
    }
}
