package com.sda.project.service;

import com.sda.project.model.Project;
import com.sda.project.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @Mock
    ProjectRepository projectRepository;

    @InjectMocks
    ProjectService projectService;

    @Test
    void whenSaveProject_shouldReturnOk() {
        // given
        Project project = new Project();
        project.setName("name");

        Project mockProject = new Project();
        mockProject.setId(1L);
        mockProject.setName("name");

        when(projectRepository.findAll())
                .thenReturn(List.of(project));
        when(projectRepository.findByNameIgnoreCase(anyString()))
                .thenReturn(Optional.of(mockProject));

        // when
        Project actual = projectService.save(project);

        // then
        assertThat(actual.getName()).isEqualTo(project.getName());
    }
}