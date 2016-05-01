package com.yl.webapp.client.application.ioc;

import com.yl.webapp.client.application.Application;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(value = { ClientGinModule.class })
public interface ClientInjector extends Ginjector {

    Application getApplication();
}
