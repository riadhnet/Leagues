package com.riadh.leagues

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class LeaguesApplication @Inject constructor() : Application()