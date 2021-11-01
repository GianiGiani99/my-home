package com.sda.project.integration;

import com.sda.project.model.Project;
import com.sda.project.model.User;
import com.sda.project.service.ProjectService;
import com.sda.project.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProjectServiceIT {

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @Test
    void whenSaveNewProjectName_shouldReturnProject() {
        // given
        Project project = new Project();
        project.setName("project");
        projectService.save(project);

        User user = new User("test@gmail.com", "test", "alex", "vasile");
        userService.save(user);

        // when
        Project actual = projectService.findById(project.getId());

        // then
        assertThat(actual.getName()).isNotNull();
    }

    @Test
    void whenSaveExistingProjectName_shouldNotSaveProject() {
        // given

        // when

        // then
    }

    @Test
    void whenFindAll_shouldReturnList() {
        // given

        // when

        // then
    }

    @Test
    void whenFindById_shouldReturnOne() {
        // given

        // when

        // then
    }

    @Test
    void whenUpdate_shouldUpdateProject() {
        // given

        // when

        // then
    }

    @Test
    void whenUpdateExistingName_shouldNotUpdateProject() {
        // given

        // when

        // then
    }

    @Test
    void whenSetProjectLead_shouldHaveAProjectLead() {
        // given

        // when

        // then
    }

    @Test
    void whenAddSprintToProject_shouldHaveProjectWithSprint() {
        // given

        // when

        // then
    }

    @Test
    void whenDelete_shouldHaveNoProjects() {
        // given

        // when

        // then
    }
}