dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")
}

jib {
    from {
        image = "amazoncorretto:17.0.3-alpine3.15"
        auth {
            username = System.getenv("DOCKER_USER")
            password = System.getenv("DOCKER_PASSWORD")
        }
    }
    to {
        image = "zalerix/kustomize-article-us"
        tags = setOf("latest", "${project.version}")
        auth {
            username = System.getenv("DOCKER_USER")
            password = System.getenv("DOCKER_PASSWORD")
        }
    }
    container {
        mainClass = "com.zlrx.article.kustomize.userservice.UserServiceApplicationKt"
        ports = listOf("8080/tcp", "9000/tcp")
        appRoot = "/app"
        workingDirectory = "/app"
        creationTime = "USE_CURRENT_TIMESTAMP"
        jvmFlags = listOf(
            "-XX:InitialRAMPercentage=40.0",
            "-XX:MaxRAMPercentage=75.0",
        )
    }
}