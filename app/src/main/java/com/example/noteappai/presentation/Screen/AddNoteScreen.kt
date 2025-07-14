package com.example.noteappai.presentation.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteappai.presentation.utils.ColorPalette
import com.example.noteappai.domain.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteScreen(
    onBackPressed: () -> Unit,
    onNoteSaved: (Note) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var selectedColor by remember { mutableStateOf(ColorPalette.getRandomColor()) }
    val titleFocusRequester = remember { FocusRequester() }
    val contentFocusRequester = remember { FocusRequester() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("New Note", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            if (title.isNotBlank()) {
                                val note = Note(
                                    title = title,
                                    content = content,
                                    color = selectedColor
                                )
                                onNoteSaved(note)
                            }
                        },
                        enabled = title.isNotBlank()
                    ) {
                        Icon(Icons.Default.Check, contentDescription = "Save")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Color Selection
            Text(
                text = "Choose Color",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
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
                                width = if (selectedColor == color) 3.dp else 1.dp,
                                color = if (selectedColor == color) Color.Black else Color.Gray,
                                shape = CircleShape
                            )
                            .clickable { selectedColor = color }
                    )
                }
            }
            
            // Note Preview
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(selectedColor)
                        .padding(16.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = if (title.isNotBlank()) title else "Note Title",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (title.isBlank()) Color.Black.copy(alpha = 0.5f) else Color.Black
                        )
                        
                        Text(
                            text = if (content.isNotBlank()) content else "Note content...",
                            fontSize = 14.sp,
                            color = if (content.isBlank()) Color.Black.copy(alpha = 0.5f) else Color.Black.copy(alpha = 0.8f)
                        )
                    }
                }
            }
            
            // Title Input
            Text(
                text = "Title",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
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
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                    )
                }
            )
            
            // Content Input
            Text(
                text = "Content",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            OutlinedTextField(
                value = content,
                onValueChange = { content = it },
                textStyle = TextStyle(
                    fontSize = 14.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .focusRequester(contentFocusRequester),
                placeholder = {
                    Text(
                        text = "Enter note content...",
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                    )
                }
            )
        }
    }
    
    LaunchedEffect(Unit) {
        titleFocusRequester.requestFocus()
    }
} 