plugins {
    id(Config.PluginIds.library)
    id(Config.PluginIds.kotlinAndroid)
    id(Config.PluginIds.kapt)
    id(Config.PluginIds.hilt)
}

android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk

        testInstrumentationRunner = Config.Dependencies.testInstrumentationRunner
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
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Android
    implementation(Dependencies.Android.core)
    implementation(Dependencies.Android.appcompat)
    implementation(Dependencies.Android.material)
    implementation(Dependencies.Android.coroutines)
    implementation(Dependencies.Android.coroutinesCore)

    // Android Test
    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.ext)
    androidTestImplementation(Dependencies.Test.espresso)

    // Hilt
    implementation(Dependencies.Hilt.core)
    kapt(Dependencies.Hilt.processor)
}

// Allow references to generated code (Hilt)
kapt {
    correctErrorTypes = true
}

// Enabling this option enables sharing test components and classpath aggregation.
hilt {
    enableAggregatingTask = true
}
