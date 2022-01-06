plugins {
    id(Config.PluginIds.android)
    id(Config.PluginIds.kotlinAndroid)
    id(Config.PluginIds.kapt)
    id(Config.PluginIds.hilt)
}

android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.example.weathercapital"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
        versionCode = Releases.versionCode
        versionName = Releases.versionName
        testInstrumentationRunner = Config.Dependencies.testInstrumentationRunner
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    packagingOptions {
        resources.excludes.add("META-INF/*")
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":repository"))
    implementation(project(":domain"))
    implementation(project(":network"))

    // Android
    implementation(Dependencies.Android.core)
    implementation(Dependencies.Android.appcompat)
    implementation(Dependencies.Android.material)
    implementation(Dependencies.Android.recyclerview)
    implementation(Dependencies.Android.coroutines)
    implementation(Dependencies.Android.coroutinesCore)
    implementation(Dependencies.Android.constraintLayout)
    implementation(Dependencies.Android.navigationFragment)
    implementation(Dependencies.Android.navigationUI)

    // Compose
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.compiler)
    implementation(Dependencies.Compose.tooling)
    implementation(Dependencies.Compose.foundation)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.materialIconsCore)
    implementation(Dependencies.Compose.materialIconsExt)
    implementation(Dependencies.Compose.composeLivedata)
    implementation(Dependencies.Compose.toolingPreview)
    androidTestImplementation(Dependencies.Compose.tests)
    debugImplementation(Dependencies.Compose.tooling)

    // Glide
    implementation(Dependencies.Glide.core)
    kapt(Dependencies.Glide.processor)

    // Lifecycle
    implementation(Dependencies.Android.viewmodel)
    implementation(Dependencies.Android.viewmodelCompose)
    implementation(Dependencies.Android.livedata)
    implementation(Dependencies.Android.runtime)
    implementation(Dependencies.Android.savedstate)
    kapt(Dependencies.Android.lifecycleProcessor)

    // Hilt
    implementation(Dependencies.Hilt.core)
    kapt(Dependencies.Hilt.processor)

    // Moshi
    implementation(Dependencies.Moshi.core)
    kapt(Dependencies.Moshi.codegen)

    // OkHttp
    implementation(platform(Dependencies.OkHttp.bom))
    implementation(Dependencies.OkHttp.core)
    implementation(Dependencies.OkHttp.interceptor)

    // Retrofit
    implementation(Dependencies.Retrofit.core)
    implementation(Dependencies.Retrofit.converter)

    // Saved state module for ViewModel
    implementation(Dependencies.Android.savedstate)

    // Android Test
    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.ext)
    androidTestImplementation(Dependencies.Test.espresso)
}

// Allow references to generated code (Hilt)
kapt {
    correctErrorTypes = true
}

// Enabling this option enables sharing test components and classpath aggregation.
hilt {
    enableAggregatingTask = true
}
