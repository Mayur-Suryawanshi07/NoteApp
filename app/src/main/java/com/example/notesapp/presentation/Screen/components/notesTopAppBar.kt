package com.example.notesapp.presentation.Screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun notesTopAppBar(
    title: String,
    subTitile:String?=null,
    showNavigationIcon: Boolean = false,
    backNavigationIcon:(() -> Unit)? = null,
    action: @Composable (RowScope.() -> Unit)? = null,
    scrollBehaviour: TopAppBarScrollBehavior?=null
) {
    TopAppBar(
        title = {
            Column {
                Text(
                    text = title,
                    fontStyle = FontStyle.Italic,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = subTitile?:"", fontSize = 16.sp,fontStyle = FontStyle.Italic)
            }
        },

        navigationIcon = {
            if (showNavigationIcon && backNavigationIcon != null) {
                IconButton(
                    onClick = {
                        backNavigationIcon()
                    }
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            }else null
        },
        actions = {
            action?.invoke(this) //So .invoke() is just Kotlin’s fancy way to say "call this function", especially useful when:

        },
        scrollBehavior = scrollBehaviour


    )
}