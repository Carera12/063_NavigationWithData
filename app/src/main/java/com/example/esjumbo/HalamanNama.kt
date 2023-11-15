package com.example.esjumbo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanNama(
    //onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    onSubmitButtonClick: (MutableList<String>) -> Unit
) {
    var namaTxt by rememberSaveable {
        mutableStateOf("")
    }
    var alamatTxt by rememberSaveable {
        mutableStateOf("")
    }
    var telponTxt by rememberSaveable {
        mutableStateOf("")
    }
    var listDataTxt: MutableList<String> = mutableListOf(namaTxt, alamatTxt, telponTxt)

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ){
        Text(text = "Data Pelanggan", fontWeight = FontWeight.Bold, fontSize = 25.sp)
        Column (modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = namaTxt,
            shape = MaterialTheme.shapes.large,
            label = { Text(text = stringResource(id = R.string.nama)) },
            onValueChange = {namaTxt = it})
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = telponTxt,
            shape = MaterialTheme.shapes.large,
            label = { Text(text = stringResource(id = R.string.no_tlp)) },
            onValueChange = {telponTxt = it})
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                value = alamatTxt,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = stringResource(id = R.string.alamat)) },
                onValueChange = {alamatTxt = it})
        Spacer(modifier = Modifier.padding(16.dp))

        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
                .weight(1f, false),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ) {
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = onCancelButtonClicked
            ) {
                Text(stringResource(R.string.cancel))
            }
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = {onSubmitButtonClick(listDataTxt)}
            ) {
                Text(stringResource(R.string.lanjut))
            }
        }
    }
}