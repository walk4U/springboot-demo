package com.jia.task;

import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: jia
 * @Date: 2018/7/19 10:15
 * @Description:
 */
@Component
public class ScheduleJobsTask {

    private Logger logger = LoggerFactory.getLogger(ScheduleJobsTask.class);

    FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "${cron.test1}")
    public void cronJob1() {
        logger.info("start to cronJob1..");
        System.out.println("[CronJob1 Execute]"+fdf.format(new Date()));
    }

    @Scheduled(cron = "${cron.test2}")
    public void cronJob2() {
        logger.info("start to cronJob2..");
        System.out.println("[CronJob2 Execute]"+fdf.format(new Date()));
    }

}
