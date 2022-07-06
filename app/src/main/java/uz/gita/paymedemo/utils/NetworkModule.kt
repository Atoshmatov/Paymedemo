package uz.gita.paymedemo.utils

/*
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @[Provides Singleton]
    fun getRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    @[Provides Singleton]
    fun getOkHttpClient(pref: SharedPrefToken, @ApplicationContext context: Context): OkHttpClient =
        OkHttpClient.Builder()
            .addLoggingInterceptor(context)
            .addInterceptor(addHeaderInterceptor(pref))
            .addInterceptor(refreshInterceptor(pref))
            .build()
}
*/


