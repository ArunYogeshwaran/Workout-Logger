# Feature Specification: Workout Notes Suggestions

This document details the specifications and verification test cases for the contextual
auto-suggestion notes feature.

---

## 🏗️ 1. Technical Reference

* **Database Query:
  ** [WorkoutDao.kt](../../app/src/main/java/com/ayogeshwaran/workoutlogger/data/local/WorkoutDao.kt) (
  `getRecentNotesForWorkoutType`)
* **Repository Layer:
  ** [WorkoutRepository.kt](../../app/src/main/java/com/ayogeshwaran/workoutlogger/domain/repository/WorkoutRepository.kt), [WorkoutRepositoryImpl.kt](../../app/src/main/java/com/ayogeshwaran/workoutlogger/data/repository/WorkoutRepositoryImpl.kt)
* **Use Case:
  ** [GetRecentNotesUseCase.kt](../../app/src/main/java/com/ayogeshwaran/workoutlogger/domain/usecase/GetRecentNotesUseCase.kt)
* **UI Components:
  ** [HomeScreen.kt](../../app/src/main/java/com/ayogeshwaran/workoutlogger/presentation/home/HomeScreen.kt) (
  Log Sheet notes section)

---

## 📋 2. Functional Requirements

1. **Context-Aware Filtering:** Suggestions are loaded dynamically based on the current active
   `workoutType`. Suggestions from one workout type (e.g. *Cycling*) must not mix with suggestions
   from another (e.g. *HIIT*).
2. **Recent & Distinct:** The system retrieves up to **4 distinct, non-empty past notes** sorted by
   creation timestamp (most recent first).
3. **Active Input Deduplication:** A suggestion item is hidden from the dropdown menu if the text
   inside the note text field matches the suggestion exactly.
4. **No Performance Cost:** Queries are executed reactively using Coroutine Flows and cached inside
   the ViewModel lifecycle.
5. **Clean & Uncluttered UX:** Suggestions are completely hidden inside a trailing drop-down menu (
   `DropdownMenu`) on the text field, accessible only when suggestions are available and the user
   clicks the drop-down arrow. Each suggestion item is restricted to **exactly 1 line** using
   ellipsis overflow truncation to maintain visual consistency.

---

## 🧪 3. Verification Test Suite

### Test Case 6.1: Contextual Suggestions and Dropdown Auto-Fill

1. On the Home screen, select **Cycling** and type `13 km to office` into the notes field.
2. Tap **Log Workout**.
3. Select **Cycling** again.
4. *Verify:* A small drop-down arrow icon (`Icons.Default.ArrowDropDown`) is visible on the trailing
   side of the notes input box.
5. Tap the drop-down arrow icon.
6. *Verify:* A dropdown menu displays containing the item `13 km to office`.
7. Tap the suggestion item `13 km to office`.
8. *Verify:* The notes text field is instantly populated with `13 km to office`, and the drop-down
   arrow icon disappears (deduplicated because the input now matches the suggestion).

### Test Case 6.2: Suggestion Isolation

1. Select **Yoga** and log a note saying `30 min flow`.
2. Select **Walking** and log a note saying `2 miles commute`.
3. Select **Yoga** again.
4. Tap the drop-down arrow icon.
5. *Verify:* The item `30 min flow` is visible, but `2 miles commute` is **not** shown in the
   dropdown list for Yoga.

---

## 🤖 4. Verification Guidelines for AI

When modifying the workout notes or logging layout:

* Suggestions must always be collected using configuration-aware StateFlow structures so they
  recover correctly on configuration changes (such as rotation or split-screen toggles).
* Dropdown menus must remain fully responsive and dismiss when clicking outside or selection
  completes.
