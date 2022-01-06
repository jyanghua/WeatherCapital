object Dependencies {

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    object Android {
        const val core = "androidx.core:core-ktx:${Versions.Android.core}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.Android.appcompat}"
        const val material = "com.google.android.material:material:${Versions.Android.material}"
        const val recyclerview =
            "androidx.recyclerview:recyclerview:${Versions.Android.recyclerview}"
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Android.coroutines}"
        const val coroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:${Versions.Android.coroutinesCore}"

        // Navigation & UI
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.Android.constraintLayout}"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.Android.navigation}"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.Android.navigation}"

        // Lifecycle
        const val viewmodel =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Android.lifecycle}"
        const val viewmodelCompose =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Android.viewmodelCompose}"
        const val livedata =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Android.lifecycle}"
        const val runtime =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Android.lifecycle}"
        const val savedstate =
            "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.Android.lifecycle}"
        const val lifecycleProcessor =
            "androidx.lifecycle:lifecycle-compiler:${Versions.Android.lifecycle}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val activity = "androidx.activity:activity-compose:${Versions.activityCompose}"
        const val compiler = "androidx.compose.compiler:compiler:${Versions.compose}"
        const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val materialIconsCore =
            "androidx.compose.material:material-icons-core:${Versions.compose}"
        const val materialIconsExt =
            "androidx.compose.material:material-icons-extended:${Versions.compose}"
        const val composeLivedata = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
        const val tests = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.Test.junit}"
        const val ext = "androidx.test.ext:junit:${Versions.Test.ext}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.Test.espresso}"
    }

    object Glide {
        const val core = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val processor = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object Hilt {
        const val core = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val processor = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    }

    object Moshi {
        const val core = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
        const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    }

    object OkHttp {
        const val bom = "com.squareup.okhttp3:okhttp-bom:${Versions.okhttp}"
        const val core = "com.squareup.okhttp3:okhttp"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val converter = "com.squareup.retrofit2:converter-moshi:${Versions.converterMoshi}"
    }
}
