package com.henrique.dockermanager.docker.domain;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DockerService {

    private final DockerClient dockerClient;

    public DockerService(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    public List<Container> listContainers(boolean allContainers) {
        return dockerClient.listContainersCmd().withShowAll(allContainers).exec();
    }

    public List<Image> listImages() {
        return dockerClient.listImagesCmd().exec();
    }
    public List<Image> filterImages(String filterName) {
        return dockerClient.listImagesCmd().withImageNameFilter(filterName).exec();
    }
    public void startContainer(String containerId) {
        dockerClient.startContainerCmd(containerId).exec();
    }

    public void stopContainer(String containerId) {
        dockerClient.stopContainerCmd(containerId).exec();
    }

    public void removeContainer(String containerId) {
        dockerClient.removeContainerCmd(containerId).exec();
    }

    public void createContainer(String imageName, String containerName) {
        dockerClient.createContainerCmd(imageName).exec();
    }
}
