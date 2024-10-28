package com.lovely.di

import android.content.Context
import android.content.SharedPreferences
import com.lovely.auth.data.local.SessionManager
import com.lovely.auth.presentation.AuthViewModel
import com.lovely.chat.ChatViewModel
import com.lovely.core.presentation.MainActivityViewModel
import com.lovely.discover.presentation.DiscoverViewModel
import com.lovely.likes.LikesViewModel
import com.lovely.onboarding.OnboardingViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


//
//@Module
//@InstallIn(SingletonComponent::class)
//object LovelyModule {
//
//    @Provides
//    @Singleton
//    fun providesSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
//        return context.getSharedPreferences("lovely-pref", Context.MODE_PRIVATE)
//    }
//}

val appModule = module {
    single<SharedPreferences>{
        androidApplication().getSharedPreferences("lovely-pref", Context.MODE_PRIVATE)
    }

    single { SessionManager(get()) }

    viewModel { MainActivityViewModel(get()) }
    viewModel { DiscoverViewModel() }
    viewModel { ChatViewModel() }
    viewModel { LikesViewModel() }
    viewModel { OnboardingViewModel(get()) }
    viewModel {AuthViewModel()}
}