# mcp-01
## 项目描述
本项目是mcp(模型上下文协议)版的HelloWorld,由于Spring ai集成MCP的相关功能正在积极开发中。
目前还没有稳定版本,这里使用的是1.0.0-SNAPSHOT快照版本,你懂得！

## 环境配置
1. JDK17
2. SpringBoot 3.2.3
3. Spring ai 1.0.0-SNAPSHOT

```xml
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
<!-- 这个配置尤为重要 -->
<repositories>
        <repository>
            <id>central-portal-snapshots</id>
            <name>central</name>
            <url>https://central.sonatype.com/repository/maven-snapshots</url>
            <releases>
                <enabled>true</enabled>
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
                    <enabled>true</enabled>
                </releases>
            </repository>
    </repositories>
```
## 功能介绍
mcp-sever: 模拟了mcp服务端,实现了工具自动注册,通过sse对外暴露服务。
mcp-client5:模拟了mcp的客户端,集成了openai服务,只要遵循了openai规范的大模型均可以通过修改配置文件的base-uri、api_key实现快速集成。

## 功能测试

如果服务端、客户端均正常启动，可以看到效果如下图。

![image-20250410173105674](C:\Users\13439\AppData\Roaming\Typora\typora-user-images\image-20250410173105674.png)

模型功能测试

![image-20250410173225517](C:\Users\13439\AppData\Roaming\Typora\typora-user-images\image-20250410173225517.png)

工具调用测试

![image-20250410173303228](C:\Users\13439\AppData\Roaming\Typora\typora-user-images\image-20250410173303228.png)