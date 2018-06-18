package com.eppen.internalserver.schedule;


import com.alibaba.fastjson.JSON;
import com.eppen.internalserver.models.InternalTable;
import com.eppen.internalserver.repository.InternalTableRepository;
import com.eppen.internalserver.to.HttpUnirest;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
import org.json.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

//@Configuration
//@EnableScheduling
@Component
@Slf4j
public class ScheduleTask {

//    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24 * 1000)
    @Autowired
    InternalTableRepository internalTableRepository;

    @Autowired
    HttpUnirest httpUnirest;

    private final String MAX_UPDATE_TIME = "maxUpdatetime";

    public void run() {

        while (true) {

            log.info("test>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

            try {
                Map<String, Object> maxTimeStamp = internalTableRepository.getMaxUpdateTime();
                JSONArray datas = httpUnirest.get(maxTimeStamp.get(MAX_UPDATE_TIME).toString());

                for (Object ds: datas) {
                    InternalTable internalTable = JSONObject.parseObject(ds.toString(), InternalTable.class);
                    internalTableRepository.saveAndFlush(internalTable);
                }

                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
