/**
 * Created by Sandeep Singh on 03-10-2015.
 */

package com.san.pro.config;

import javax.validation.constraints.NotNull;

@SuppressWarnings("UnusedDeclaration")
public class MessagesConfiguration {

    @NotNull
    private String hello;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

}
