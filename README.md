# mcp-01
## 项目描述
本项目是MCP(模型上下文协议)版的HelloWorld,由于Spring ai集成MCP的相关功能正在积极开发中。
目前还没有稳定版本,这里使用的是1.0.0-SNAPSHOT快照版本,你懂得！

## 环境配置
1. JDK17
2. SpringBoot 3.2.3
3. Spring ai 1.0.0-SNAPSHOT

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.github.app</groupId>
    <artifactId>mcp-01</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>pom</packaging>
    <name>mcp-demo</name>
    <description>mcp-01</description>
    <properties>
        <java.version>17</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <spring-boot.version>3.2.3</spring-boot.version>
        <spring-ai.version>1.0.0.SNAPSHOT</spring-ai.version>
    </properties>
    <dependencies>

    </dependencies>
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.ai</groupId>
                <artifactId>spring-ai-bom</artifactId>
                <version>1.0.0-SNAPSHOT</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    <repositories>
        <repository>
            <id>central-portal-snapshots</id>
            <name>central</name>
            <url>https://central.sonatype.com/repository/maven-snapshots</url>
            <releases>
                <enabled>false</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
        <repository>
            <id>spring-milestones</id>
            <name>spring</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
            <repository>
                <id>spring-snapshots</id>
                <name>Spring Snapshots</name>
                <url>https://repo.spring.io/snapshot</url>
                <snapshots>
                    <enabled>true</enabled>
                </snapshots>
                <releases>
                    <enabled>false</enabled>
                </releases>
            </repository>
    </repositories>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>17</source>
                    <target>17</target>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>${spring-boot.version}</version>
                <configuration>
                    <mainClass>com.github.app.mcp.McpDemoApplication</mainClass>
                    <skip>true</skip>
                </configuration>
                <executions>
                    <execution>
                        <id>repackage</id>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

</project>

```
## 功能介绍
mcp-sever: 模拟了mcp服务端,实现了工具自动注册,通过sse对外暴露服务。
mcp-client5:模拟了mcp的客户端,集成了openai服务,只要遵循了openai规范的大模型均可以通过修改配置文件的base-uri、api_key实现快速集成。

## 功能测试

如果服务端、客户端均正常启动，可以看到效果如下图。

![image-20250410173105674](.\images\image-20250410173105674.png)

模型功能测试

![image-20250410173225517](.\images\image-20250410173225517.png)

工具调用测试

![image-20250410173303228](.\images\image-20250410173303228.png)