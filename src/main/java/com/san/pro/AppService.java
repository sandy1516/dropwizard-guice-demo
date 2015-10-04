/**
 * Created by Sandeep Singh on 03-10-2015.
 */

package com.san.pro;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.san.pro.config.AppServiceConfiguration;
import com.san.pro.config.MessagesConfiguration;
import com.san.pro.dao.UserDao;
import com.san.pro.dao.UserDaoImpl;
import com.san.pro.resource.HelloResource;
import com.san.pro.resource.UserResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class AppService extends Service<AppServiceConfiguration> {
    public static void main(String args[]) throws Exception {
        new AppService().run(args);
    }

    @Override
    public void initialize(Bootstrap<AppServiceConfiguration> bootstrap) {
        bootstrap.setName("dropwizard-guice-demo");
    }

    @Override
    public void run(AppServiceConfiguration appServiceConfiguration, Environment environment) throws Exception {
        Injector injector = createInjector(appServiceConfiguration);
        environment.addResource(injector.getInstance(HelloResource.class));
        environment.addResource(injector.getInstance(UserResource.class));
    }

    // you probably would like to move this method to separate class
    private Injector createInjector(final AppServiceConfiguration appServiceConfiguration) {
        return Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                // if someone would like to @Inject ExampleServiceConfiguration
                bind(AppServiceConfiguration.class).toInstance(appServiceConfiguration);
                // for ExampleResource, which does @Inject MessagesConfiguration
                bind(MessagesConfiguration.class).toInstance(appServiceConfiguration.getMessages());
                // for UserDao
                bind(UserDao.class).to(UserDaoImpl.class);
            }
        });
    }



}
