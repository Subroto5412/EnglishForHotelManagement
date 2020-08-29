package com.subroto.english.hotelmanagement.data

import android.content.Context
import com.subroto.english.hotelmanagement.data.pref.IPreferencesHelper
import javax.inject.Inject

class AppDataManager @Inject
constructor(
    private val mContext: Context,
    private val mPreferencesHelper: IPreferencesHelper
) : IDataManager {
    override var user: String
        get() = mPreferencesHelper.user
        set(user) {
            mPreferencesHelper.user = user
        }
    override var email: String
        get() = mPreferencesHelper.email
        set(email) {
            mPreferencesHelper.email = email
        }
    override var quizOneValue: String
        get() = mPreferencesHelper.quizOneValue
        set(quizOneValue){
            mPreferencesHelper.quizOneValue = quizOneValue
        }
    override var quizTwoValue: String
        get() = mPreferencesHelper.quizTwoValue
        set(quizTwoValue) {
            mPreferencesHelper.quizTwoValue = quizTwoValue
        }
}