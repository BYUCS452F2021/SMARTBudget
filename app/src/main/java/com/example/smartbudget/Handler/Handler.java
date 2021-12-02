package com.example.smartbudget.Handler;

import com.example.smartbudget.Response.Response;

public abstract class Handler<Req, Resp extends Response> {
    protected abstract Resp handle(Req request);
    protected abstract Resp fail(Exception e);
    public Resp handleRequest(Req request){
        try {
            return handle(request);
        } catch(Exception e){
            return fail(e);
        }
    }
}
