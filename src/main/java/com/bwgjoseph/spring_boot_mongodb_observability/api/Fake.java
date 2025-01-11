package com.bwgjoseph.spring_boot_mongodb_observability.api;

import io.micrometer.observation.annotation.Observed;
import io.micrometer.tracing.annotation.NewSpan;
import io.micrometer.tracing.annotation.SpanTag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Fake {

    @Observed(name = "fake.new.class.span")
    @NewSpan(name = "new class span")
    public void newClassSpan(@SpanTag("arg") String arg) {
      log.info("this will generate a new span");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
