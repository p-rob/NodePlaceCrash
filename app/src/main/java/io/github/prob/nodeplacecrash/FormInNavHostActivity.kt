package io.github.prob.nodeplacecrash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class FormInNavHostActivityContract : ActivityResultContract<Unit, Unit>() {
    override fun createIntent(context: Context, input: Unit): Intent {
        return Intent(context, FormInNavHostActivity::class.java)
    }

    override fun parseResult(resultCode: Int, intent: Intent?) = Unit
}

@OptIn(ExperimentalMaterial3Api::class)
class FormInNavHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    TopAppBar(title = { Text(text = "FormInNavHostActivity") })
                }
            ) { paddingValues ->
                NavHost(
                    navController = rememberNavController(),
                    startDestination = "home",
                    modifier = Modifier.fillMaxSize(),
                ) {
                    composable("home") { entry ->
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .imePadding(),
                            contentPadding = paddingValues
                        ) {
                            items(24) { index ->
                                OutlinedTextField(
                                    value = "",
                                    onValueChange = {},
                                    placeholder = { Text(text = "Field $index") }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

