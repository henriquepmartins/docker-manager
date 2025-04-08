package com.henrique.dockermanager.docker.domain;

import com.github.dockerjava.api.DockerClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DockerClientConfig {
    @Value("${docker.socket.path}")
    private String dockerSocketPath;

    @Bean
    public DockerClient buildDockerClient() {
        return null;
    }
}
