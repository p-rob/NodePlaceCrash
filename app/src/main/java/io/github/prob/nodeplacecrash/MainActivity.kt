package io.github.prob.nodeplacecrash

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : AppCompatActivity() {

    private val formInNavHostLauncher =
        registerForActivityResult(FormInNavHostActivityContract()) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
            ) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(it)) {
                    Button(onClick = {
                        formInNavHostLauncher.launch(Unit)
                    }, modifier = Modifier.align(Alignment.Center)) {
                        Text("Open activity")
                    }
                }
            }
        }
    }
}