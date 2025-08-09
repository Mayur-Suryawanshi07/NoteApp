package com.example.notesapp.presentation.screen.editnotes

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesapp.presentation.utils.ColorPalette


@Composable
fun EditNotesBody(
    padding: PaddingValues,
    state: EditNotesUiState,
    edtViewModel: EditNotesViewModel,
    titleFocusRequester: FocusRequester,
    contentFocusRequester: FocusRequester
) {
    Column(
        modifier = Modifier
            .background(state.color)
            .fillMaxSize()
            .padding(padding)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    )
    {
        // Color Selection
        Text(
            text = "Choose Color",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
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
                            width = if (state.color == color) 2.dp else 1.dp,
                            color = if (state.color == color) Color.Black else Color.Gray,
                            shape = CircleShape
                        )
                        .clickable {
                            edtViewModel.onColorChange(color)
                        }
                )
            }
        }
        // Title Input
        Text(
            text = "Title :",
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black

        )

        TextField(
            value = state.title,
            onValueChange = {
                edtViewModel.onTitleChange(it)

            },
            textStyle = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(titleFocusRequester),
            placeholder = {
                Text(
                    text = "Enter note title...",
                    color = Color.DarkGray
                )
            },
            maxLines = 1,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor =state.color,
                focusedLabelColor = state.color,
                unfocusedBorderColor = state.color,
                cursorColor = Color.Black
            )
        )

        // Content Input
        Text(
            text = "Content :",
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black
        )

        TextField(
            value = state.content,
            onValueChange = {
                edtViewModel.onContentChange(it)
            },
            textStyle = TextStyle(
                fontSize = 16.sp
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = state.color,
                focusedLabelColor = state.color,
                unfocusedBorderColor = state.color,
                cursorColor = Color.Black
            ),
            modifier = Modifier
                .fillMaxSize()
                .focusRequester(contentFocusRequester),
            placeholder = {
                Text(
                    text = "Enter note content...",
                    color = Color.DarkGray
                )
            }
        )
    }
}