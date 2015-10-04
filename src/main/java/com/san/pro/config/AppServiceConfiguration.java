package com.san.pro.config;

import com.yammer.dropwizard.config.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 03-10-2015.
 */
@SuppressWarnings("UnusedDeclaration")
public class AppServiceConfiguration extends Configuration{

    @NotNull
    @Valid
    private MessagesConfiguration messages;

    @NotNull
    @Valid
    private DatabaseConfiguration database;

    public MessagesConfiguration getMessages() {
        return messages;
    }

    public void setMessages(MessagesConfiguration messages) {
        this.messages = messages;
    }

    public DatabaseConfiguration getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseConfiguration database) {
        this.database = database;
    }

}
