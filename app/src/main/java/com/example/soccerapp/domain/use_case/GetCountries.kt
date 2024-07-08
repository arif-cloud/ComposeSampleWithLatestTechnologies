package com.example.soccerapp.domain.use_case

import com.example.soccerapp.data.remote.model.response.CountriesResponse
import com.example.soccerapp.domain.repository.SoccerRepository
import javax.inject.Inject

class GetCountries @Inject constructor(
    private val repository: SoccerRepository
) {
    suspend operator fun invoke(): CountriesResponse {
        return repository.getCountries()
    }
}