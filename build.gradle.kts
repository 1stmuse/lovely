// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.compose.compiler) apply false
}

//plugins {
//    id("com.android.application") version "8.2.0" apply false
//    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
////    id("com.google.dagger.hilt.android") version "2.50" apply false
//    id("com.android.library") version "8.2.0" apply false
//}
