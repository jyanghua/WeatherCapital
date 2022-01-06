object Config {

    object Dependencies {
        const val gradle = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    }

    object PluginIds {
        const val library = "com.android.library"
        const val android = "com.android.application"
        const val kapt = "kotlin-kapt"
        const val kotlinAndroid = "kotlin-android"
        const val hilt = "dagger.hilt.android.plugin"
    }
}
