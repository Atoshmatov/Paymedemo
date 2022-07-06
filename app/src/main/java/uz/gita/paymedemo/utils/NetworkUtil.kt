package uz.gita.paymedemo.utils


/*fun OkHttpClient.Builder.addLoggingInterceptor(context: Context): OkHttpClient.Builder {
    HttpLoggingInterceptor.Level.HEADERS
    val logging = HttpLoggingInterceptor.Logger { message -> myLog(message, "HTTP") }
    if (BuildConfig.LOGGING) {
        if (Build.VERSION.SDK_INT <= 30)
            addInterceptor(ChuckInterceptor(context))
        addInterceptor(HttpLoggingInterceptor(logging))
    }
    return this
}

fun addHeaderInterceptor(pref: MyPreferences) = Interceptor { chain ->
    val request = chain.request().newBuilder()
        .addHeader("Authorization", "Bearer ${pref.accessToken}")
        .build()

//    request.url.host.startsWith()
    return@Interceptor chain.proceed(request)
}


fun refreshInterceptor(pref: MyPreferences) = Interceptor { chain ->
    val request = chain.request()
    val response = chain.proceed(request)
    myLog("response.code =${response.code}")
    if (response.code == 401) {
        response.close()
        val data = JSONObject()
        data.put("refresh", pref.refreshToken)
        val body =
            data.toString().toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

        val requestRefresh = request.newBuilder()
            .method("POST", body)
            .url("https://api.taksi24.uz/api/auth/token/refresh/")
            .build()

        val responseRefresh = chain.proceed(requestRefresh)
        myLog("responseRefresh.code =${responseRefresh.code}")
        if (!responseRefresh.isSuccessful) {
            myLog("login navigate")
            EventListener.openLoginScreenLiveData.postValue(Unit)
            return@Interceptor responseRefresh
        }

        if (responseRefresh.code == 200) {
            responseRefresh.body?.let {
                pref.accessToken =
                    Gson().fromJson(it.string(), AuthResponse.RefreshData::class.java).access
            }
            responseRefresh.close()
            val requestRepeat = request.newBuilder()
                .removeHeader("Authorization")
//                .addHeader("Token", pref.accessToken)
                .addHeader("Authorization", "Bearer ${pref.accessToken}")
                .build()
            EventListener.connectWithRawSocketLiveData.postValue(Unit)
            return@Interceptor chain.proceed(requestRepeat)
        }
    }
    return@Interceptor response
}*/
