package com.example.trackingservice.pipelines.auth;

import an.awesome.pipelinr.Command;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationBehavior implements Command.Middleware {


    //invoke: C konutun kendisi R dönüş tipi nexde de diğer adıma geç diyebiliyorsun
    @Override
    public <R, C extends Command<R>> R invoke(C c, Next<R> next) {
        //command çalışmadan önce

        var response= next.invoke();

        return response;
    }
}
