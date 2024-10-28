
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
    kotlin("kapt")
//    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.lovely"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.lovely"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = libs.plugins.compose.compiler.get()
//    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler")
//    stabilityConfigurationFile = rootProject.layout.projectDirectory.file("stability_config.conf")
}

    kapt {
        correctErrorTypes = true
    }


dependencies {
    val nav_version = "2.7.7"
    val calendarVersion = "1.3.0"

    coreLibraryDesugaring ("com.android.tools:desugar_jdk_libs:2.0.4")


    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.compose.ui)
    implementation(libs.compose.graphics)
    implementation(libs.compose.ui.tooling.preview)

    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation(libs.compose.material3)


    testImplementation(libs.junit)
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation(libs.compose.ui.tooling)
//    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")


//    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
//    implementation(libs.compose.ui)
//    implementation("androidx.compose.ui:ui-graphics")
//    implementation(libs.compose.ui.tooling.preview)
//    implementation(libs.compose.material3)


    // Splash screen
//    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation(libs.androidx.core.splash.screens)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson.converter)

    //OKHTTP
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    //Coil
    implementation(libs.coil.compose)

//    //    Hilt
//    implementation("com.google.dagger:hilt-android:2.50")
//    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")
//    kapt("com.google.dagger:hilt-android-compiler:2.50")

    //KOIN
//    val koin_android_version = "3.5.3"
//    val koin_version ="3.5.5"
    api(libs.koin.core)
    implementation(libs.koin.androidx.compose)
    implementation(libs.koin.android)
    implementation(libs.koin.navigation)
    implementation(libs.koin.compose.navigation)
//    implementation("io.insert-koin:koin-android:$koin_version")
//    implementation("io.insert-koin:koin-androidx-navigation:$koin_version")
//    implementation("io.insert-koin:koin-androidx-compose:$koin_version")
//    implementation("io.insert-koin:koin-androidx-compose-navigation:$koin_version")


    //navigation
    implementation(libs.navigation.compose)
//    implementation("androidx.navigation:navigation-compose:$nav_version")

    //ROOM DB
    val room_version = "2.6.1"
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)
//    implementation("androidx.room:room-runtime:$room_version")
//    annotationProcessor("androidx.room:room-compiler:$room_version")

//    kapt("androidx.room:room-compiler:$room_version")
    kapt(libs.room.runtime)
    implementation(libs.room)
//    implementation("androidx.room:room-ktx:$room_version")

    //Calendar
    implementation ("io.github.boguszpawlowski.composecalendar:composecalendar:$calendarVersion")
    implementation ("io.github.boguszpawlowski.composecalendar:kotlinx-datetime:$calendarVersion")

}