package com.zzy.vertx.core.router;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VertxRouter {
  @Bean
  public Router router(){
    Router router = Router.router(Vertx.vertx());
    router.route().handler(BodyHandler.create());
    router.errorHandler(404, ctx ->{
      ctx.response().setStatusCode(404).end("404");
    });

    return router;
  }

}
