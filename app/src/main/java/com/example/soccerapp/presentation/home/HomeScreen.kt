package com.example.soccerapp.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.soccerapp.presentation.home.component.CountrySelectSection
import com.example.soccerapp.presentation.home.component.TeamItem
import com.example.soccerapp.presentation.root.ErrorText
import com.example.soccerapp.presentation.root.LoadingAnimation
import com.example.soccerapp.presentation.root.Screen

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {
    val state by viewModel.homeState.collectAsState()
    val listState = rememberLazyListState()
    Box(modifier = Modifier.fillMaxSize()) {
        state.data?.let {homeData ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp, top = 10.dp)
            ) {
                CountrySelectSection(
                    selectedCountry = viewModel.selectedCountry.value,
                    onSelectedCountryChange = { country ->
                        viewModel.selectedCountry.value = country.name.orEmpty()
                        viewModel.getTeams(country.id.toInt())
                    },
                    countryList = homeData.countryList
                )
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    state = listState
                ) {
                    items(homeData.teamList) { team ->
                        TeamItem(
                            teamName = team.name.orEmpty(),
                            modifier = Modifier.fillMaxWidth(),
                            onClick = { navController.navigate(Screen.TeamDetailScreen(teamId = team.id)) }
                        )
                    }
                }
                if (homeData.teamList.isEmpty()) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        ErrorText(
                            errorMessage = "No team found !",
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
            LaunchedEffect(key1 = homeData.teamList) {
                listState.scrollToItem(0)
            }
        }
        if (state.isLoading)
            LoadingAnimation(modifier = Modifier.align(Alignment.Center))
        if (state.error.isNotEmpty())
            ErrorText(
                errorMessage = state.error,
                modifier = Modifier.align(Alignment.Center)
            )
    }
}