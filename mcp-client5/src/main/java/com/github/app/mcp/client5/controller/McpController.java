package com.github.app.mcp.client5.controller;

import io.modelcontextprotocol.client.McpClient;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tool")
public class McpController {

    private final ChatClient chatClient;

    @Autowired
    public McpController(ChatClient.Builder builder, ToolCallbackProvider mcpTools) {
        this.chatClient = builder.defaultTools(mcpTools).build();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam(value = "message") String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
