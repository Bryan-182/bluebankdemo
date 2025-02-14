package com.bryanortiz.bluesoft.bluebank.mainmvp;

import android.app.Application;
import android.content.Context;

import com.bryanortiz.bluesoft.bluebank.repository.ApiRepository;
import com.bryanortiz.bluesoft.bluebank.repository.DatabaseRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private Application application;

    public MainModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    public MainMVP.Presenter provideMainPresenter(MainMVP.Model model) {
        return new MainPresenter(model);
    }

    @Provides
    public MainMVP.Model provideMainModel(ApiRepository apiRepository, DatabaseRepository databaseRepository) {
        return new MainModel(apiRepository, databaseRepository);
    }

    @Provides
    public ApiRepository provideApiRepository() {
        return new ApiRepository();
    }

    @Provides
    public DatabaseRepository provideDatabaseRepository() {
        return new DatabaseRepository();
    }
}
