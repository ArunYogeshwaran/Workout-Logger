package com.ayogeshwaran.workoutlogger.domain.usecase

import com.ayogeshwaran.workoutlogger.domain.repository.WorkoutRepository
import kotlinx.coroutines.flow.Flow

class GetRecentNotesUseCase(private val repository: WorkoutRepository) {

    operator fun invoke(workoutType: String): Flow<List<String>> {
        return repository.getRecentNotesForWorkoutType(workoutType)
    }
}
