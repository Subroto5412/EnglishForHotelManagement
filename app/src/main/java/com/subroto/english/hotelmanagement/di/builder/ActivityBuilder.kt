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
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes =
    [SplashActivityModule::class,
        HomeActivityModule::class,
        VocabularyActivityModule::class,
        SentenceActivityModule::class,
        ConversationActivityModule::class]
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
}