package com.subroto.english.hotelmanagement.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Qualifier
import kotlin.reflect.KClass

@Qualifier
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ApiInfo

@Qualifier
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class PreferenceInfo

@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
