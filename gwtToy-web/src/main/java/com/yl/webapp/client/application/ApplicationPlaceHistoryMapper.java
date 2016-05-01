package com.yl.webapp.client.application;

import com.yl.webapp.client.ui.home.HomePlace;
import com.yl.webapp.client.ui.login.LoginPlace;
import com.yl.webapp.client.ui.logout.LogoutPlace;
import com.yl.webapp.client.ui.reloadOptions.ReloadOptionsPlace;
import com.yl.webapp.client.ui.upload.FileUploadPlace;
import com.yl.webapp.client.ui.users.active.ActiveUsersPlace;
import com.yl.webapp.client.ui.users.editProfile.EditProfilePlace;
import com.yl.webapp.client.ui.users.signUp.SignUpPlace;
import com.yl.webapp.client.ui.users.updatePassword.UpdatePasswordPlace;

import com.google.gwt.place.shared.PlaceHistoryMapperWithFactory;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({
        HomePlace.Tokenizer.class,
        LoginPlace.Tokenizer.class,
        UpdatePasswordPlace.Tokenizer.class,
        LogoutPlace.Tokenizer.class,
        EditProfilePlace.Tokenizer.class,
        SignUpPlace.Tokenizer.class,
        ActiveUsersPlace.Tokenizer.class,
        FileUploadPlace.Tokenizer.class,
        ReloadOptionsPlace.Tokenizer.class
})
public interface ApplicationPlaceHistoryMapper extends PlaceHistoryMapperWithFactory<ApplicationPlaceHistoryFactory> {
}