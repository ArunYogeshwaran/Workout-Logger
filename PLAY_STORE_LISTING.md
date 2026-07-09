# FlinkLog — Play Store Listing

---

## App Name (30 chars max)

FlinkLog: Tiny Workout Logger

---

## Short Description (80 chars max)

Tiny, lightweight workout log. Simple, fast, offline, no ads, no tracking.

---

## Full Description

FlinkLog is a privacy-first, ultra-lightweight workout logger. No sign-ups, no subscriptions, and no tracking.

◉ Log in one tap: Select workout type, hit "Log Workout," and move on.
◉ Quick History: View your logging history anytime via the monthly calendar or weekly strip.

Features:
• Under 3.5MB download size — fast, lightweight, and efficient
• Smart suggestions — auto-fill note descriptions from past entries
• Offline-first — 100% offline, code is fully open-source
• Auto Cloud Backups — securely restore your data via Google Auto Backup
• Material You — dynamic themes matching your device colors
• AppFunctions — Android 16 on-device system assistant hooks

What it does NOT do:
✗ No ads, account creation, or subscriptions
✗ No internet connection required
✗ No data collection or selling of any kind

---

## What's New (500 chars max)

• Smart Notes Auto-Suggestions: Save time by auto-filling descriptions with your past workout notes. Tap the drop-down arrow icon in the note box to see recent logs for each exercise type.
• Weekly View Picker: Tap the underlined date range header to pick a date range directly, or shift by one full week using the arrow controls.
• Secure Cloud Backups: Restores your workouts automatically from Google Drive when you reinstall or switch devices.
• App Stability: Performance tuning and navigation fixes for a smoother calendar and tracking flow.

---

## Subsequent Release Checklist

Ensure the following before publishing any update:

1. **Increment Version Code:** Increase `versionCode` in `app/build.gradle.kts` for each release.
2. **Verify AppFunctions & Obfuscation:** Run `./gradlew assembleRelease` to confirm R8 optimizations don't break AppFunctions reflection.
3. **Data Safety Declaration:** Ensure the Data Safety page in Play Console remains declared as collecting **"No data"**.
