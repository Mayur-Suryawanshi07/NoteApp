# 📒 NoteApp  

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9-blue.svg?logo=kotlin)](https://kotlinlang.org/)  
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-blueviolet.svg?logo=jetpackcompose)](https://developer.android.com/jetpack/compose)  
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)  

A **beautiful & minimal Note-Taking Android App** built with **Kotlin**, **Jetpack Compose**, and **Clean Architecture**.  
Organize your thoughts effortlessly with a modern UI and smooth user experience.  

---

## ✨ Features  
- 📝 Create, edit, and delete notes  
- 🎨 Assign custom colors to notes  
- 🔍 Search & filter notes easily  
- 📅 Auto-save with timestamps  
- 💾 Offline-first storage with Room  
- 🖥 Built on **Clean Architecture + MVVM**  

---

## 🛠 Tech Stack  
- **Language:** Kotlin  
- **UI:** Jetpack Compose, Material 3  
- **Architecture:** Clean Architecture + MVVM  
- **Database:** Room  
- **DI:** Hilt  
- **Async:** Kotlin Coroutines & Flow  

---


---

## 📸 Screenshots

## 📸 Screenshots

<table align="center">
  <tr>
    <th>Edit Screen (Dark)</th>
    <th>Edit Screen (Light)</th>
    <th>Detail Screen (Dark)</th>
    <th>Detail Screen (Light)</th>
    <th>Note Screen (Dark)</th>
    <th>Note Screen (Light)</th>
  </tr>
  <tr>
    <td><img src="screenshots/EditScreen(LightMode).jpg" width="200"></td>
    <td><img src="screenshots/EditScreen(DarkMode).jpg" width="200"></td>
    <td><img src="screenshots/NoteDetailScreen(Light_Mode).jpg" width="200"></td>
    <td><img src="screenshots/NoteDetailScreen(Dark_Mode).jpg" width="200"></td>
    <td><img src="screenshots/NoteScreen(Light_Mode).jpg" width="200"></td>
    <td><img src="screenshots/NoteScreen(DarkMode).jpg" width="200"></td>
  </tr>
</table>

---

## 📦 Setup & Installation
1. Clone the repository  
   ```bash
   git clone https://github.com/yourusername/NoteApp.git
2.Open the project in Android Studio
  Go to File > Open
  Select the cloned project folder.
3.Sync Gradle
  Android Studio will prompt you to sync Gradle files.
  Click "Sync Now".
4.Run the app
  Connect an Android device or start an emulator.
  Click the Run ▶️ button in Android Studio.

  Android App Setup (app/):

Firebase:
Create an Android project in Firebase Console.
Use package name com.github.adnanrangrej.natureguardian.
Place google-services.json in app/.
Enable Authentication (Email/Password) and Firestore.
Secrets (app/secrets.properties):
MAPS_API_KEY=YOUR_MAPS_API_KEY
BACKEND_BASE_URL=YOUR_NEWS_API_GATEWAY_URL
CLOUDINARY_CLOUD_NAME=YOUR_CLOUDINARY_CLOUD_NAME
CLOUDINARY_BACKEND_URL=YOUR_CLOUDINARY_FUNCTION_URL
CLOUDINARY_BACKEND_URL_API_KEY=YOUR_CLOUDINARY_API_KEY
Ensure secrets.properties is in .gitignore.
Build: Open in Android Studio, sync Gradle, and run.


