package org.simsek.camel.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimerRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer://foo?fixedRate=true&period=1000")
        .to("bean:myBean?method=getTime")
        .log("${body}");
    }
}

@Component
class MyBean {
    public String getTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }
}
