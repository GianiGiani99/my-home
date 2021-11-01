package com.sda.project;

import com.sda.project.model.Privilege;
import com.sda.project.model.PrivilegeType;
import com.sda.project.model.Project;
import com.sda.project.model.Role;
import com.sda.project.model.RoleType;
import com.sda.project.model.User;
import com.sda.project.service.PrivilegeService;
import com.sda.project.service.ProjectService;
import com.sda.project.service.RoleService;
import com.sda.project.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AcceptanceTest {

    @Autowired
    PrivilegeService privilegeService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Test
    void acceptanceFlow() {
        // create privileges
        Privilege writePrivilege = privilegeService.save(PrivilegeType.WRITE_PRIVILEGE);
        Privilege readPrivilege = privilegeService.save(PrivilegeType.READ_PRIVILEGE);

        // create roles
        Role adminRole = roleService.save(RoleType.ADMIN, Set.of(writePrivilege));

        Role userRole = roleService.save(RoleType.USER, Set.of(readPrivilege));

        // create users
        User projectLead = createAdmin(adminRole);
        User user = createUser(userRole);
        userService.save(projectLead);
        userService.save(user);

        // create project
        Project project = createProject();
        Project savedProject = projectService.save(project);

        assertThat(savedProject).isNotNull();
    }

    private User createAdmin(Role role) {
        User user = new User();
        user.setEmail("test-admin@gmail.com");
        user.setPassword("pass");
        user.addRole(role);
        return user;
    }

    private User createUser(Role role) {
        User user = new User();
        user.setEmail("test-user@gmail.com");
        user.setPassword("pass");
        user.addRole(role);
        return user;
    }

    private Project createProject() {
        Project project = new Project();
        project.setName("project");
        project.setProjectKey("PRO");
        return project;
    }
}
