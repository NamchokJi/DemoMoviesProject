package com.namchok.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.namchok.core.common.base.BaseUiState
import com.namchok.domain.model.MoviesDetailModel
import com.namchok.resource.AppTheme
import com.namchok.ui.model.HomeViewType

@Composable
fun HomeMainScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()

//    BaseViewModelCommonCompose(viewModel = viewModel)

    HomeScreen(
        modifier = modifier,
        uiState = uiState,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: BaseUiState<HomeUiState>,
) {
    val pageCount = 5
    val pagerState = rememberPagerState(pageCount = { pageCount })

    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) { contentPadding ->
        uiState.mainUiState?.let { state ->
            LazyColumn(
                modifier =
                    Modifier
                        .padding(contentPadding)
                        .fillMaxSize()
                        .background(AppTheme.colors.primaryGrey),
            ) {
                items(state.viewType) { viewType ->
                    when (viewType) {
                        is HomeViewType.PopularMovies -> {
                            HorizontalPager(
                                modifier = modifier.fillMaxWidth(),
                                state = pagerState,
                            ) { page ->
                                MoviePager(data = viewType.moviesList[page])
                            }
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                            ) {
                                repeat(pageCount) { iteration ->
                                    if (pagerState.currentPage == iteration) {
                                        Box(
                                            modifier =
                                                Modifier
                                                    .padding(4.dp)
                                                    .clip(CircleShape)
                                                    .background(AppTheme.colors.white)
                                                    .height(AppTheme.dimensions.paddingM)
                                                    .width(32.dp),
                                        )
                                    } else {
                                        Box(
                                            modifier =
                                                Modifier
                                                    .padding(4.dp)
                                                    .clip(CircleShape)
                                                    .background(AppTheme.colors.white.copy(alpha = 0.5F))
                                                    .size(AppTheme.dimensions.paddingM),
                                        )
                                    }
                                }
                            }
                        }

                        is HomeViewType.TopRatedMovies -> {
                            Text(
                                modifier = Modifier.padding(vertical = AppTheme.dimensions.paddingL),
                                text = "Top Rated",
                                color = AppTheme.colors.white,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            LazyRow(
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                modifier =
                                    Modifier.fillMaxWidth(),
                            ) {
                                items(viewType.moviesList) { data ->
                                    AsyncImage(
                                        model = data.poster,
                                        contentDescription = null,
                                        modifier =
                                            Modifier.width(120.dp).height(200.dp),
                                        contentScale = ContentScale.Crop,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MoviePager(data: MoviesDetailModel) {
    Box {
        AsyncImage(
            model = data.poster,
            contentDescription = null,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .graphicsLayer { alpha = 0.99F }
                    .drawWithContent {
                        drawContent()
                        drawRect(
                            brush =
                                Brush.verticalGradient(
                                    colors =
                                        listOf(
                                            Color.Transparent,
                                            Color.Black,
                                        ),
                                    startY = Float.POSITIVE_INFINITY,
                                    endY = 0.0f,
                                ),
                            blendMode = BlendMode.DstIn,
                        )
                    }
                    .height(480.dp),
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier =
                Modifier.align(Alignment.BottomStart)
                    .padding(AppTheme.dimensions.paddingM),
        ) {
            Text(
                text = data.title,
                color = AppTheme.colors.white,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier =
                        Modifier.size(AppTheme.dimensions.paddingXL)
                            .padding(end = AppTheme.dimensions.paddingM),
                    imageVector = Icons.Filled.Star,
                    contentDescription = "",
                    tint = AppTheme.colors.white,
                )
                Text(
                    text = data.voteAverage.toString(),
                    color = AppTheme.colors.white,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Text(
                text = data.overview,
                color = AppTheme.colors.white,
                fontSize = 12.sp,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 16.sp,
            )
        }
    }
}
