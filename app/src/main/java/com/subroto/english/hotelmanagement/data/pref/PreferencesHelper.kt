package com.subroto.english.hotelmanagement.data.pref

import android.content.Context
import android.content.SharedPreferences
import com.subroto.english.hotelmanagement.di.PreferenceInfo
import javax.inject.Inject

class PreferencesHelper @Inject
constructor(context: Context, @PreferenceInfo prefFileName: String) : IPreferencesHelper {
    override var user: String
        get() = mPrefs.getString(PREF_KEY_USER, "").toString()
        set(user) = mPrefs.edit().putString(PREF_KEY_USER, user).apply()
    override var email: String
        get() = mPrefs.getString(PREF_KEY_EMAIL, "").toString()
        set(user) = mPrefs.edit().putString(PREF_KEY_EMAIL, user).apply()
    override var quizOneValue: String
        get() = mPrefs.getString(PREF_KEY_QUIZONE,"").toString()
        set(quizOneValue) = mPrefs.edit().putString(PREF_KEY_QUIZONE, quizOneValue).apply()
    override var quizTwoValue: String
        get() = mPrefs.getString(PREF_KEY_QUIZTWO,"").toString()
        set(quizTwoValue) = mPrefs.edit().putString(PREF_KEY_QUIZTWO, quizTwoValue).apply()
    override var quizThreeValue: String
        get() = mPrefs.getString(PREF_KEY_QUIZTHREE,"").toString()
        set(quizThreeValue) = mPrefs.edit().putString(PREF_KEY_QUIZTHREE, quizThreeValue).apply()

    private val mPrefs: SharedPreferences =
        context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    companion object {
        private val PREF_KEY_USER = "PREF_KEY_USER"
        private val PREF_KEY_EMAIL = "PREF_KEY_EMAIL"
        private val PREF_KEY_QUIZONE = "PREF_KEY_QUIZONE"
        private val PREF_KEY_QUIZTWO = "PREF_KEY_QUIZTWO"
        private val PREF_KEY_QUIZTHREE = "PREF_KEY_QUIZTHREE"
    }
}