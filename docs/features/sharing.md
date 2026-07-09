# Feature Specification: Workout Sharing

This document details the specifications and verification test cases for the workout sharing feature.

---

## 🏗️ 1. Technical Reference
*   **Share Engine:** [WorkoutComponents.kt](../../app/src/main/java/com/ayogeshwaran/workoutlogger/presentation/components/WorkoutComponents.kt) (`shareWorkouts`)
*   **UI Components:**
    *   [HomeScreen.kt](../../app/src/main/java/com/ayogeshwaran/workoutlogger/presentation/home/HomeScreen.kt) (Today's workouts section header)
    *   [HistoryScreen.kt](../../app/src/main/java/com/ayogeshwaran/workoutlogger/presentation/history/HistoryScreen.kt) (Weekly View date headers & Monthly View selected date header)

---

## 📋 2. Functional Requirements
1.  **Contextual Gathering:** Gathers all logged workouts for a specific date (e.g. all activities completed on *July 7, 2026*).
2.  **Nicely Formatted Text:** Generates a clean text representation:
    *   The date on the very first line (e.g. `📅 Tuesday, Jul 7, 2026`).
    *   A bulleted list containing the exercise category/type with its respective emoji.
    *   Notes/descriptions nested in brackets next to the exercise title.
    *   A closing tagline: `Log your workouts offline, ad-free, and privately with FlinkLog! Download it here:` followed by the Play Store installation link.
3.  **Android Share Intent:** Invokes the standard system-level share chooser, allowing users to share the formatted text to any external communication app (e.g. WhatsApp, Messages, Slack, Email).
4.  **No UI Bloat:** The share icon button is only displayed next to the date/section headers when there is at least **one** logged workout for that day.

---

## 🧪 3. Verification Test Suite

### Test Case 7.1: Today's Workouts Sharing (Home Screen)
1.  Select **Cycling** and type `13 km commute` in the notes field.
2.  Tap **Log Workout**.
3.  *Verify:* A Share icon appears next to the "Logged Workouts Today" header.
4.  Tap the **Share** button.
5.  *Verify:* Android's system share sheet opens.
6.  Choose to copy to clipboard or share to a text app.
7.  *Verify:* The shared text reads:
    ```text
    📅 <Today's Date>
    • 🚴 Cycling (13 km commute)

    Log your workouts offline, ad-free, and privately with FlinkLog! Download it here:
    https://play.google.com/store/apps/details?id=com.ayogeshwaran.workoutlogger
    ```

### Test Case 7.2: Past Day Sharing (History Screen)
1.  Navigate to the **History** tab.
2.  Select a date on the monthly calendar that contains logged workouts.
3.  *Verify:* A Share icon appears next to the selected date header text.
4.  Switch to the **Weekly View**.
5.  *Verify:* A Share icon appears next to each day's date header that contains logged workouts.
6.  Tap the **Share** button.
7.  *Verify:* The correct list of workouts for that day is gathered and formatted with their respective emojis and a medium-formatted date on the first line.
