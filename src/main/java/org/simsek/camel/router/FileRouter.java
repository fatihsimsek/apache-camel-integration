package org.simsek.camel.router;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.simsek.camel.model.User;
import org.simsek.camel.processor.UserProcessor;
import org.springframework.stereotype.Component;

@Component
public class FileRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:source").unmarshal(new ListJacksonDataFormat(User.class))
                .split(body())
                .process(new UserProcessor())
                .bean(MyUserBean.class)
                .log("${body}");
    }
}

@Component
class MyUserBean {
    public String getUser(Exchange exchange) {
        User user = (User) exchange.getIn().getBody();
        return user.toString();
    }
}
