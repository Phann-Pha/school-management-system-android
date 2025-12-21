package com.domain.visor.school.retrofit_client.builder
import com.domain.visor.school.retrofit_client.domain.DomainURL
import com.domain.visor.school.retrofit_client.provider.HttpClientProvider
import com.domain.visor.school.retrofit_client.services.APIInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class ClientBuilder @Inject constructor()
{
    internal val client: HttpClientProvider
        @Inject get() = HttpClientProvider()

    internal val domain: DomainURL
        @Inject get() = DomainURL()

    @Provides
    @Named(value = "RetrofitBuilder")
    internal fun onRetrofitBuilder(): Retrofit = Retrofit.Builder().baseUrl(domain.baseURL())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(client.okHttpClient())
        .build()

    @Provides
    @Named(value = "API")
    fun onRetrofit(@Named(value = "RetrofitBuilder") retrofit: Retrofit): APIInterface = retrofit.create(APIInterface::class.java)
}