package com.eppen.internalserver.schedule;

import com.alibaba.fastjson.JSONObject;
import com.eppen.internalserver.models.InternalTable;
import com.eppen.internalserver.repository.InternalTableRepository;
import com.eppen.internalserver.to.HttpUnirest;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Configuration
@EnableScheduling
@Component
@Slf4j
public class ScheduleTask {

    @Autowired
    InternalTableRepository internalTableRepository;

    @Autowired
    HttpUnirest httpUnirest;

    private final String MAX_UPDATE_TIME = "maxUpdatetime";

    // 如果内部增加会有问题
    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24 * 36500)
    public void run() {

        while (true) {

            log.info("test>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

            try {
                Map<String, Object> maxTimeStamp = internalTableRepository.getMaxUpdateTime();
                JSONArray datas = httpUnirest.get(maxTimeStamp.get(MAX_UPDATE_TIME).toString());

                if (datas != null) {
                    for (Object ds: datas) {
                        InternalTable internalTable = JSONObject.parseObject(ds.toString(), InternalTable.class);
                        internalTableRepository.saveAndFlush(internalTable);
                    }
                }

                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
