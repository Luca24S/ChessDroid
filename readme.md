# ChessDroid

ChessDroid is an Android app written in Java, designed to provide a simple and functional chess-playing experience on mobile devices.

## Features

- Intuitive and lightweight interface.
- Support for local chess matches.
- Compatible with Android devices (API 11 - 19).
- Optimized for older devices with limited resources.

## System Requirements

- **Min SDK Version:** 11 (Android 3.0 Honeycomb)
- **Target SDK Version:** 19 (Android 4.4 KitKat)
- **Development Language:** Java

## Project Structure

The project consists of:

1. **MainActivity:** Main screen for game options and navigation.
2. **GameActivity:** Handles the logic and interface for playing chess.
3. **Assets:** Custom icons and themes for the application.

## Android Manifest

The `AndroidManifest.xml` file defines the app's main configurations, including the activities and compatibility settings.

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="project.chessdroid"
    android:versionCode="1"
    android:versionName="1.0" >

    <uses-sdk
        android:minSdkVersion="11"
        android:targetSdkVersion="19" />

    <application
        android:allowBackup="true"
        android:icon="@drawable/ic_launcher"
        android:label="@string/app_name"
        android:theme="@style/AppTheme" >
        <activity
            android:name="project.chessdroid.MainActivity"
            android:label="@string/app_name" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity
            android:name="project.chessdroid.GameActivity"
            android:label="@string/title_activity_game" >
        </activity>
    </application>
</manifest>