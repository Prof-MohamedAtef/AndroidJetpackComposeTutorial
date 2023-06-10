package atef.stc.jetback.compose.route.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import atef.stc.jetback.compose.route.Screen

@Composable
fun MainScreen(navController: NavController) {
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        var text by remember {
            mutableStateOf("")
        }
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
        ) {
            TextField(
                value = text, onValueChange = {
                    text = it
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    navController.navigate(Screen.DetailsScreen.withArgs(text))
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "To Detail Screen")
            }
        }
    }
}