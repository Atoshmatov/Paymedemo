package uz.gita.paymedemo.di.auth

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.paymedemo.BuildConfig.BASE_URL
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.data.remote.api.auth.AuthApi
import uz.gita.paymedemo.data.remote.api.main.BasicApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AuthModule {

    @[Provides Singleton]
    fun okHTTPClientObject(
        @ApplicationContext context: Context,
        shared: SharedPrefToken
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(ChuckInterceptor(context))
            /*.addInterceptor {
                val request = it.request()
                val build = request.newBuilder()
                build.addHeader("Authorization", "Bearer ${shared.token}")
                val newRequest = build.build()
                val response = it.proceed(newRequest)
                if (response.code == 401) {

                    return@addInterceptor it.proceed(newRequest)
                }
                response
            }*/
            .build()

    @[Provides Singleton]
    fun getRetrofitObject(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @[Provides Singleton]
    fun getAuthApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)

    @[Provides Singleton]
    fun getCardApi(retrofit: Retrofit): BasicApi = retrofit.create(BasicApi::class.java)
}