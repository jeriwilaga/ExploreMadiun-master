// Tambahkan import di bagian paling atas
import java.io.FileInputStream
import java.util.Properties

// Load apiKey.properties
val apiKeyPropertiesFile = rootProject.file("apiKey.properties")
val apiKeyProperties = Properties().apply {
    load(FileInputStream(apiKeyPropertiesFile))
}
val mapsApiKey: String = apiKeyProperties["MAPS_API_KEY"] as String

// Plugins untuk semua sub-project/module
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.gms.google-services") version "4.4.1" apply false
    id("com.google.firebase.firebase-perf") version "1.4.2" apply false
    id("com.google.firebase.crashlytics") version "2.9.9" apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
}

// Buildscript untuk plugin tambahan (safe args, dexcount, dsb)
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        val navVersion = project.properties["navigationVersion"].toString()
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
        classpath("com.getkeepsafe.dexcount:dexcount-gradle-plugin:4.0.0")
    }
}
