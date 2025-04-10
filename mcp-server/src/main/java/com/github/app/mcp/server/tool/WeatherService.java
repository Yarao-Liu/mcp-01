package com.github.app.mcp.server.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WeatherService {

    private final Map<String,String>weatherData = Map.of(
            "北京", "晴天，气温25°C", "上海", "多云，气温28°C", "广州", "小雨，气温30°C", "深圳", "阵雨，气温29°C" );
    @Tool(description = "根据城市名称获取天气信息，支持的城市包括: 北京、上海、广州、深圳")
    public String getWeatherByCity(String city) {
        return weatherData.getOrDefault(city, "未找到该城市的天气信息");
    }

    @Tool(description = "获取支持查询天气的所有城市列表")
    public String getSupportedCities() {
        return String.join("、", weatherData.keySet());
    }
}
