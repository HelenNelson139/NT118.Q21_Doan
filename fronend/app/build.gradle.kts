plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.do_an_mon_hoc_quanlikhoahoc_23521023"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.do_an_mon_hoc_quanlikhoahoc_23521023"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("com.android.volley:volley:1.2.1")

    implementation("androidx.recyclerview:recyclerview:1.3.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.viewpager2:viewpager2:1.1.0-beta01")
    implementation("com.google.android.flexbox:flexbox:3.0.0")
    implementation("io.getstream:photoview:1.0.3")
}