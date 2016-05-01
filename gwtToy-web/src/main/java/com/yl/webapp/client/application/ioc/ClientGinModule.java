package com.yl.webapp.client.application.ioc;

import com.yl.webapp.client.application.Application;
import com.yl.webapp.client.application.ApplicationActivityMapper;
import com.yl.webapp.client.application.ApplicationPlaceHistoryFactory;
import com.yl.webapp.client.application.ApplicationPlaceHistoryMapper;
import com.yl.webapp.client.application.ApplicationProxyFactory;
import com.yl.webapp.client.application.DesktopApplication;
import com.yl.webapp.client.application.base.request.EventSourceRequestTransport;
import com.yl.webapp.client.requests.ApplicationRequestFactory;
import com.yl.webapp.client.ui.home.HomeActivity;
import com.yl.webapp.client.ui.home.HomeView;
import com.yl.webapp.client.ui.home.HomeViewDesktop;
import com.yl.webapp.client.ui.login.LoginActivity;
import com.yl.webapp.client.ui.login.LoginView;
import com.yl.webapp.client.ui.login.LoginViewImpl;
import com.yl.webapp.client.ui.logout.LogoutActivity;
import com.yl.webapp.client.ui.reloadOptions.ReloadOptionsActivity;
import com.yl.webapp.client.ui.upload.FileUploadActivity;
import com.yl.webapp.client.ui.upload.views.FileUploadView;
import com.yl.webapp.client.ui.upload.views.FileUploadViewImpl;
import com.yl.webapp.client.ui.upload.views.UploadedFileView;
import com.yl.webapp.client.ui.upload.views.UploadedFileViewImpl;
import com.yl.webapp.client.ui.users.active.ActiveUsersActivity;
import com.yl.webapp.client.ui.users.active.ActiveUsersView;
import com.yl.webapp.client.ui.users.active.ActiveUsersViewImpl;
import com.yl.webapp.client.ui.users.editProfile.EditProfileActivity;
import com.yl.webapp.client.ui.users.editProfile.EditProfileView;
import com.yl.webapp.client.ui.users.editProfile.EditProfileViewImpl;
import com.yl.webapp.client.ui.users.editUser.EditUserActivity;
import com.yl.webapp.client.ui.users.editUser.EditUserView;
import com.yl.webapp.client.ui.users.editUser.EditUserViewImpl;
import com.yl.webapp.client.ui.users.search.UsersSearchActivity;
import com.yl.webapp.client.ui.users.search.UsersSearchView;
import com.yl.webapp.client.ui.users.search.UsersSearchViewImpl;
import com.yl.webapp.client.ui.users.signUp.SignUpActivity;
import com.yl.webapp.client.ui.users.signUp.SignUpView;
import com.yl.webapp.client.ui.users.signUp.SignUpViewImpl;
import com.yl.webapp.client.ui.users.updatePassword.UpdatePasswordView;
import com.yl.webapp.client.ui.users.updatePassword.UpdatePasswordViewImpl;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(Application.class).to(DesktopApplication.class).in(Singleton.class);
        bind(ActivityMapper.class).to(ApplicationActivityMapper.class).in(Singleton.class);

        bind(HomeActivity.class);
        bind(LoginActivity.class);
        bind(LogoutActivity.class);
        bind(ReloadOptionsActivity.class);
        bind(SignUpActivity.class);
        bind(EditProfileActivity.class);
        bind(ActiveUsersActivity.class);
        bind(FileUploadActivity.class);
        bind(EditUserActivity.class);
        bind(UsersSearchActivity.class);

        bind(HomeView.class).to(HomeViewDesktop.class).in(Singleton.class);
        bind(LoginView.class).to(LoginViewImpl.class).in(Singleton.class);
        bind(UpdatePasswordView.class).to(UpdatePasswordViewImpl.class).in(Singleton.class);
        bind(SignUpView.class).to(SignUpViewImpl.class).in(Singleton.class);
        bind(EditProfileView.class).to(EditProfileViewImpl.class).in(Singleton.class);
        bind(ActiveUsersView.class).to(ActiveUsersViewImpl.class).in(Singleton.class);
        bind(FileUploadView.class).to(FileUploadViewImpl.class).in(Singleton.class);
        bind(UploadedFileView.class).to(UploadedFileViewImpl.class).in(Singleton.class);
        bind(EditUserView.class).to(EditUserViewImpl.class).in(Singleton.class);
        bind(UsersSearchView.class).to(UsersSearchViewImpl.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    public PlaceController providePlaceController(final EventBus eventBus) {
        final PlaceController placeController = new PlaceController(eventBus);
        return placeController;
    }

    @Provides
    @Singleton
    public ApplicationRequestFactory provideRequestFactory(final EventBus eventBus) {
        final ApplicationRequestFactory requestFactory = GWT.create(ApplicationRequestFactory.class);
        requestFactory.initialize(eventBus, new EventSourceRequestTransport(eventBus));
        return requestFactory;
    }

    @Provides
    @Singleton
    PlaceHistoryMapper providePlaceHistoryMapper(final ApplicationRequestFactory requestFactory, final ApplicationProxyFactory proxyFactory) {
        final ApplicationPlaceHistoryMapper historyMapper = GWT.create(ApplicationPlaceHistoryMapper.class);
        historyMapper.setFactory(new ApplicationPlaceHistoryFactory(requestFactory, proxyFactory));
        return historyMapper;
    }

    @Provides
    @Singleton
    PlaceHistoryHandler providePlaceHistoryHandler(final PlaceHistoryMapper historyMapper) {
        return new PlaceHistoryHandler(historyMapper);
    }

    @Provides
    @Singleton
    ActivityManager provideActivityManager(final ActivityMapper activityMapper, final EventBus eventBus) {
        return new ActivityManager(activityMapper, eventBus);
    }
}
