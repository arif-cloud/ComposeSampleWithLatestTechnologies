package com.example.soccerapp.presentation.home.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.soccerapp.domain.model.Country

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountrySelectSection(
    selectedCountry: String,
    onSelectedCountryChange: (Country) -> Unit,
    countryList: List<Country>
) {
    var isExpanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it },
        content = {
            OutlinedTextField(
                value = selectedCountry,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                countryList.forEach { country ->
                    DropdownMenuItem(
                        text = { Text(text = country.name.orEmpty()) },
                        onClick = {
                            onSelectedCountryChange(country)
                            isExpanded = false
                        }
                    )
                }
            }
        }
    )
}