package com.issues.crawle;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.codec.BodyCodec;

/**
 * todo
 *
 * @author zhuzhenfeng
 * @date 2018/3/8
 */
public class MyVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        get();
    }

    private void get() {
        WebClient webClient = WebClient.create(vertx);

//        /repos/:owner/:repo/issues/:number
        webClient
                .get("gitee.com", "api/v5/repos/zhenfeng-zhu/vertx-blueprint-todo-backend/issues")

                .send(res -> {
                    if (res.succeeded()) {
                        System.out.println("success");
                        System.out.println("result: " + res.result().bodyAsString());
                    } else {
                        System.out.println("fail");
                        System.out.println(res.cause().getMessage());
                    }
                });


    }

}
