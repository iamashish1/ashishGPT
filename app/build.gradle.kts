plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")

    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.ashishgpt"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ashishgpt"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        dataBinding=true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    val lifecycleVersion = "2.7.0"

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")


    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")

    //DI
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")
    // Not a processor, but forces Dagger to use newer metadata lib
    kapt ("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.4.2")
    implementation("com.squareup:javapoet:1.13.0")
    implementation("androidx.core:core-ktx:1.13.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}


