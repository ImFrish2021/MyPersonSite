plugins {
    java
}

repositories {
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
}

group = "xyz.frish2021.website"
version = "1.0"
description = "BersonolGwefan Project is website"


dependencies {
    // SQL
//    implementation("mysql:mysql-connector-java:8.0.33")
//    implementation("com.zaxxer:HikariCP:4.0.3")

    // 其他依赖
    implementation("com.youbenzi:MD2File:1.0.2")
    implementation("commons-io:commons-io:2.8.0")

    implementation(platform("org.noear:solon-parent:2.5.5-SNAPSHOT"))
//    implementation("org.noear:mybatis-solon-plugin")
//    implementation("org.noear:captcha-solon-plugin")

    implementation("org.noear:solon-web")
    implementation("org.noear:solon.logging.simple")

    testImplementation("org.noear:solon-test")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}

tasks.withType<Jar> {
    manifest {
        attributes.apply {
            set("Main-Class", "xyz.frish2021.website.BersonolGwefanApp")
        }
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map {
        if (it.isDirectory) it else zipTree(it)
    })

    from(sourceSets.main.get().output)
}
