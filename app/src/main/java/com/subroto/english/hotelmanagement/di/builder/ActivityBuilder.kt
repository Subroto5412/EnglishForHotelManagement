package com.subroto.english.hotelmanagement.di.builder

import com.subroto.english.hotelmanagement.ui.main.conversation.ConversationActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.ConversationActivityModule
import com.subroto.english.hotelmanagement.ui.main.home.HomeActivity
import com.subroto.english.hotelmanagement.ui.main.home.HomeActivityModule
import com.subroto.english.hotelmanagement.ui.main.sentence.SentenceActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.SentenceActivityModule
import com.subroto.english.hotelmanagement.ui.main.splash.SplashActivity
import com.subroto.english.hotelmanagement.ui.main.splash.SplashActivityModule
import com.subroto.english.hotelmanagement.ui.main.vocabulary.VocabularyActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.VocabularyActivityModule
import com.subroto.english.hotelmanagement.ui.main.vocabulary.foods.VocabularyFoodsActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.foods.VocabularyFoodsActivityModule
import com.subroto.english.hotelmanagement.ui.main.vocabulary.foods.VocabularyFoodsAdapterModule
import com.subroto.english.hotelmanagement.ui.main.vocabulary.geeting.GeetingActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.geeting.GeetingActivityModule
import com.subroto.english.hotelmanagement.ui.main.vocabulary.geeting.GeetingAdapterModule
import com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen.VocabularyKitchenActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen.VocabularyKitchenActivityModule
import com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen.VocabularyKitchenAdapterModule
import com.subroto.english.hotelmanagement.ui.main.vocabulary.reception.VocabularyReceptionActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.reception.VocabularyReceptionActivityModule
import com.subroto.english.hotelmanagement.ui.main.vocabulary.reception.VocabularyReceptionAdapterModule
import com.subroto.english.hotelmanagement.ui.main.vocabulary.service.VocabularyServiceActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.service.VocabularyServiceActivityModule
import com.subroto.english.hotelmanagement.ui.main.vocabulary.service.VocabularyServiceAdapterModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes =
    [SplashActivityModule::class,
        HomeActivityModule::class,
        VocabularyActivityModule::class,
        SentenceActivityModule::class,
        ConversationActivityModule::class,
        GeetingActivityModule::class,
        VocabularyFoodsActivityModule::class,
        VocabularyServiceActivityModule::class,
        VocabularyReceptionActivityModule::class,
        VocabularyKitchenActivityModule::class
    ]
)

abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [SplashActivityModule::class]
    )
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(
        modules = [HomeActivityModule::class]
    )
    internal abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector(
        modules = [VocabularyActivityModule::class]
    )
    internal abstract fun bindVocabularyActivity(): VocabularyActivity

    @ContributesAndroidInjector(
        modules = [SentenceActivityModule::class]
    )
    internal abstract fun bindSentenceActivity(): SentenceActivity

    @ContributesAndroidInjector(
        modules = [ConversationActivityModule::class]
    )
    internal abstract fun bindConversationActivity(): ConversationActivity

    @ContributesAndroidInjector(
        modules = [GeetingActivityModule::class, GeetingAdapterModule::class]
    )
    internal abstract fun bindGeetingActivity(): GeetingActivity

    @ContributesAndroidInjector(
        modules = [VocabularyFoodsActivityModule::class, VocabularyFoodsAdapterModule::class]
    )
    internal abstract fun bindVocabularyFoodsActivity(): VocabularyFoodsActivity

    @ContributesAndroidInjector(
        modules = [VocabularyServiceActivityModule::class, VocabularyServiceAdapterModule::class]
    )
    internal abstract fun bindVocabularyServiceActivity(): VocabularyServiceActivity

    @ContributesAndroidInjector(
        modules = [VocabularyReceptionActivityModule::class, VocabularyReceptionAdapterModule::class]
    )
    internal abstract fun bindVocabularyReceptionActivity(): VocabularyReceptionActivity

    @ContributesAndroidInjector(
        modules = [VocabularyKitchenActivityModule::class, VocabularyKitchenAdapterModule::class]
    )
    internal abstract fun bindVocabularyKitchenActivity(): VocabularyKitchenActivity
}