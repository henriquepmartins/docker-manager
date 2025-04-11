package com.henrique.dockermanager.docker.infrastructure;

import com.github.dockerjava.api.model.Container;
import com.henrique.dockermanager.docker.domain.DockerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/containers")
public class DockerContainerController {

    private final DockerService dockerService;

    public DockerContainerController(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    @GetMapping({"", "/filter"})
    public List<Container> listContainers(
            @RequestParam(name = "showAll", required = false, defaultValue = "true") boolean showAll) {
        return dockerService.listContainers(showAll);
    }

    @PostMapping("/{id}/start")
    public void startContainer(@PathVariable("id") String id) {
        dockerService.startContainer(id);
    }

    @PostMapping("/{id}/stop")
    public void stopContainer(@PathVariable("id") String id) {
        dockerService.stopContainer(id);
    }

    @DeleteMapping("/{id}")
    public void removeContainer(@PathVariable("id") String id) {
        dockerService.removeContainer(id);
    }

    @PostMapping("")
    public void createContainer(
            @RequestParam("imageName") String imageName,
            @RequestParam("containerName") String containerName) {
        dockerService.createContainer(imageName, containerName);
    }
}
