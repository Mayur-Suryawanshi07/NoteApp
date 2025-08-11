package com.example.notesapp.feature_notes.presentation.screen.editnotes

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesapp.feature_notes.presentation.utils.ColorPalette


@Composable
fun EditNotesBody(
    padding: PaddingValues,
    state: EditNotesUiState,
    edtViewModel: EditNotesViewModel,
    titleFocusRequester: FocusRequester,
    contentFocusRequester: FocusRequester
) {
    val animatedBackgroundColor = animateColorAsState(
        targetValue = Color(state.color),
        animationSpec = tween(durationMillis = 600),
        label = "edit_background_color"
    ).value

    Column(
        modifier = Modifier
            .background(animatedBackgroundColor)
            .fillMaxSize()
            .padding(padding)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    )
    {
        // Color Selection
        Text(
            text = "Choose Color :",
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            ColorPalette.colors.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(color)
                        .border(
                            width = if (state.color == color.toArgb()) 2.dp else 1.dp,
                            color = if (state.color == color.toArgb()) Color.Black else Color.Gray,
                            shape = CircleShape
                        )
                        .clickable {
                            edtViewModel.onColorChange(color)
                        }
                )
            }
        }

        TextField(
            value = state.title,
            onValueChange = {
                edtViewModel.onTitleChange(it)

            },
            textStyle = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(titleFocusRequester),
            placeholder = {
                Text(
                    text = "Enter note title...",
                    color = Color.DarkGray,
                    fontSize = 22.sp
                )
            },
            maxLines = 1,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = animatedBackgroundColor,
                focusedLabelColor = animatedBackgroundColor,
                unfocusedBorderColor = animatedBackgroundColor,
                cursorColor = Color.Black
            )
        )

        TextField(
            value = state.content,
            onValueChange = {
                edtViewModel.onContentChange(it)
            },
            textStyle = TextStyle(
                fontSize = 18.sp,
                color = Color.DarkGray
            ),
            modifier = Modifier
                .fillMaxSize()
                .focusRequester(contentFocusRequester),
            placeholder = {
                Text(
                    text = "Enter note content...",
                    color = Color.DarkGray,
                    fontSize = 18.sp
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = animatedBackgroundColor,
                focusedLabelColor = animatedBackgroundColor,
                unfocusedBorderColor = animatedBackgroundColor,
                cursorColor = Color.Black
            ),
        )
    }
}