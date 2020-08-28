package com.subroto.english.hotelmanagement.di.builder

import com.subroto.english.hotelmanagement.ui.main.conversation.ConversationActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.ConversationActivityModule
import com.subroto.english.hotelmanagement.ui.main.conversation.foods.ConversationFoodsActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.foods.ConversationFoodsActivityModule
import com.subroto.english.hotelmanagement.ui.main.conversation.foods.ConversationFoodsAdapterModule
import com.subroto.english.hotelmanagement.ui.main.conversation.geetings.ConversationGeetingsActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.geetings.ConversationGeetingsActivityModule
import com.subroto.english.hotelmanagement.ui.main.conversation.geetings.ConversationGeetingsAdapterModule
import com.subroto.english.hotelmanagement.ui.main.conversation.kitchen.ConversationKitchenActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.kitchen.ConversationKitchenActivityModule
import com.subroto.english.hotelmanagement.ui.main.conversation.kitchen.ConversationKitchenAdapterModule
import com.subroto.english.hotelmanagement.ui.main.conversation.reception.ConversationReceptionActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.reception.ConversationReceptionActivityModule
import com.subroto.english.hotelmanagement.ui.main.conversation.reception.ConversationReceptionAdapterModule
import com.subroto.english.hotelmanagement.ui.main.conversation.service.ConversationServiceActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.service.ConversationServiceActivityModule
import com.subroto.english.hotelmanagement.ui.main.conversation.service.ConversationServiceAdapterModule
import com.subroto.english.hotelmanagement.ui.main.home.HomeActivity
import com.subroto.english.hotelmanagement.ui.main.home.HomeActivityModule
import com.subroto.english.hotelmanagement.ui.main.quiz.QuizActivity
import com.subroto.english.hotelmanagement.ui.main.quiz.QuizActivityModule
import com.subroto.english.hotelmanagement.ui.main.sentence.SentenceActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.SentenceActivityModule
import com.subroto.english.hotelmanagement.ui.main.sentence.foods.SentenceFoodsActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.foods.SentenceFoodsActivityModule
import com.subroto.english.hotelmanagement.ui.main.sentence.foods.SentenceFoodsAdapterModule
import com.subroto.english.hotelmanagement.ui.main.sentence.geetings.SentenceGeetingsActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.geetings.SentenceGeetingsActivityModule
import com.subroto.english.hotelmanagement.ui.main.sentence.geetings.SentenceGeetingsAdapterModule
import com.subroto.english.hotelmanagement.ui.main.sentence.kitchen.SentenceKitchenActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.kitchen.SentenceKitchenActivityModule
import com.subroto.english.hotelmanagement.ui.main.sentence.kitchen.SentenceKitchenAdapterModule
import com.subroto.english.hotelmanagement.ui.main.sentence.reception.SentenceReceptionActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.reception.SentenceReceptionActivityModule
import com.subroto.english.hotelmanagement.ui.main.sentence.reception.SentenceReceptionAdapterModule
import com.subroto.english.hotelmanagement.ui.main.sentence.service.SentenceServiceActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.service.SentenceServiceActivityModule
import com.subroto.english.hotelmanagement.ui.main.sentence.service.SentenceServiceAdapterModule
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
        VocabularyKitchenActivityModule::class,
        ConversationGeetingsActivityModule::class,
        ConversationFoodsActivityModule::class,
        ConversationServiceActivityModule::class,
        ConversationReceptionActivityModule::class,
        ConversationKitchenActivityModule::class,
        SentenceGeetingsActivityModule::class,
        SentenceFoodsActivityModule::class,
        SentenceServiceActivityModule::class,
        SentenceReceptionActivityModule::class,
        SentenceKitchenActivityModule::class,
        QuizActivityModule::class
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

    @ContributesAndroidInjector(
        modules = [ConversationGeetingsActivityModule::class, ConversationGeetingsAdapterModule::class]
    )
    internal abstract fun bindConversationGeetingsActivity(): ConversationGeetingsActivity

    @ContributesAndroidInjector(
        modules = [ConversationFoodsActivityModule::class, ConversationFoodsAdapterModule::class]
    )
    internal abstract fun bindConversationFoodsActivity(): ConversationFoodsActivity

    @ContributesAndroidInjector(
        modules = [ConversationServiceActivityModule::class, ConversationServiceAdapterModule::class]
    )
    internal abstract fun bindConversationServiceActivity(): ConversationServiceActivity

    @ContributesAndroidInjector(
        modules = [ConversationReceptionActivityModule::class, ConversationReceptionAdapterModule::class]
    )
    internal abstract fun bindConversationReceptionActivity(): ConversationReceptionActivity

    @ContributesAndroidInjector(
        modules = [ConversationKitchenActivityModule::class, ConversationKitchenAdapterModule::class]
    )
    internal abstract fun bindConversationKitchenActivity(): ConversationKitchenActivity

    @ContributesAndroidInjector(
        modules = [SentenceGeetingsActivityModule::class, SentenceGeetingsAdapterModule::class]
    )
    internal abstract fun bindSentenceGeetingsActivity(): SentenceGeetingsActivity

    @ContributesAndroidInjector(
        modules = [SentenceFoodsActivityModule::class, SentenceFoodsAdapterModule::class]
    )
    internal abstract fun bindSentenceFoodsActivity(): SentenceFoodsActivity

    @ContributesAndroidInjector(
        modules = [SentenceServiceActivityModule::class, SentenceServiceAdapterModule::class]
    )
    internal abstract fun bindSentenceServiceActivity(): SentenceServiceActivity

    @ContributesAndroidInjector(
        modules = [SentenceReceptionActivityModule::class, SentenceReceptionAdapterModule::class]
    )
    internal abstract fun bindSentenceReceptionActivity(): SentenceReceptionActivity

    @ContributesAndroidInjector(
        modules = [SentenceKitchenActivityModule::class, SentenceKitchenAdapterModule::class]
    )
    internal abstract fun bindSentenceKitchenActivity(): SentenceKitchenActivity

    @ContributesAndroidInjector(
        modules = [QuizActivityModule::class]
    )
    internal abstract fun bindQuizActivity(): QuizActivity


}