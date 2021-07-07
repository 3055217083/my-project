package com.song.springboot.utils;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/7/1 10:24
 */
@SpringBootTest
@Slf4j
class HttpClientUtilTest {
    @Test
    public void httpTest() {
        Map<String, String> params = new HashMap<>();
        JsonObject paramJson = new JsonObject();
        paramJson.addProperty("storeIdOrName", "1001");
        paramJson.addProperty("type", "1");
        params.put("data", paramJson.toString());
        log.error(HttpClientUtil.sendPost("http://pmapiservice.beta1.fn/rest/YxStoreManage/getStoreInfoByIdOrName", params));
    }
}
