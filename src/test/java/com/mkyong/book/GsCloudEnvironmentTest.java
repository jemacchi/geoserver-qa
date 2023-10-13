package com.mkyong.book;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import co.poynt.postman.runner.PostmanCollectionRunner;
import junit.framework.Assert;

@Testcontainers
public class GsCloudEnvironmentTest {

    @Container
    public static DockerComposeContainer environment =
        new DockerComposeContainer(new File("src/test/resources/docker-compose.yml"))
                .withExposedService("gateway", 8080).waitingFor("gateway", Wait.forListeningPort().withStartupTimeout(Duration.ofSeconds(60)));

    @Test
    public void testSimplest() throws Exception {
    	PostmanCollectionRunner cr = new PostmanCollectionRunner();

		boolean isSuccessful = cr.runCollection(
				"classpath:PostmanRunnerRegression.postman_collection.json",
				"classpath:PostmanRunnerRegression.postman_environment.json",
				"Simpletest", false).isSuccessful();
		
		Assert.assertTrue(isSuccessful);
    }
}
