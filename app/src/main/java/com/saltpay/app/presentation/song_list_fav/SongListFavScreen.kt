package com.saltpay.app.presentation.song_list_fav
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.saltpay.app.presentation.song_list.components.SongFavListItems
import com.saltpay.app.presentation.song_list.components.SongListItems
import com.saltpay.app.util.TestTags

@Composable
fun SongFavListScreen(
    navController: NavController,
    viewModel: SongFavListViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize().testTag(TestTags.SONGS_SECTION)) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.songs) { song ->
                SongFavListItems(
                    song = song,
                    onItemClick = {
                        Toast.makeText(context, "Selected ${song.title}", Toast.LENGTH_SHORT).show()

                        //navController.navigate(ScreenType.SongDetailScreen.route + "/${song.id}")
                    }
                )
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}