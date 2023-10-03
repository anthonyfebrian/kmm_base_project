plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.rariki.kmmbaseproject.android"
    compileSdk = AndroidAppConfig.compileSdk
    defaultConfig {
        applicationId = "com.rariki.kmmbaseproject.android"
        minSdk = AndroidAppConfig.minSdk
        targetSdk = AndroidAppConfig.targetSdk
        versionCode = AndroidAppConfig.versionCode
        versionName = AndroidAppConfig.versionName
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.KOTLIN_COMPILER_EXTENSION
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(platform(Dependencies.composeBoM))
    implementation(Dependencies.compose)
    implementation(Dependencies.composeGraphic)
    implementation(Dependencies.composeToolingPreview)
    implementation(Dependencies.composeMaterial3)
    implementation(Dependencies.composeNavigation)
    implementation(Dependencies.composeActivity)
}