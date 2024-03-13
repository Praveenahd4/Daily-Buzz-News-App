package com.hd.dailybuzz.presentation.details

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hd.dailybuzz.R
import com.hd.dailybuzz.domain.model.Article
import com.hd.dailybuzz.domain.model.Source
import com.hd.dailybuzz.presentation.Dimens.ArticleImageHeight
import com.hd.dailybuzz.presentation.Dimens.MediumPadding1
import com.hd.dailybuzz.presentation.details.components.DetailsTopBar
import com.hd.dailybuzz.ui.theme.DailyBuzzTheme
import com.hd.dailybuzz.util.UIComponent


@Composable
fun DetailsScreen(
    article: Article,
    event: (DetailsEvent) -> Unit,
    sideEffect: UIComponent?,
    navigateUp: () -> Unit
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = sideEffect) {
        sideEffect?.let {
            when(sideEffect){
                is UIComponent.Toast ->{
                    Toast.makeText(context, sideEffect.message, Toast.LENGTH_SHORT).show()
                    event(DetailsEvent.RemoveSideEffect)
                }
                else -> Unit
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        DetailsTopBar(
            onBrowsingClick = {
                Intent(Intent.ACTION_VIEW).also {
                    it.data = Uri.parse(article.url)
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, article.url)
                    it.type = "text/plain"
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onBookMarkClick = {
                event(DetailsEvent.UpsertDeleteArticle(article))
            },
            onBackClick = navigateUp
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = MediumPadding1,
                end = MediumPadding1,
                top = MediumPadding1
            )
        ) {
            item {
                if (!article.urlToImage.isNullOrEmpty()) {
                    AsyncImage(
                        model = ImageRequest.Builder(context = context).data(article.urlToImage)
                            .build(),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(ArticleImageHeight)
                            .clip(MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    // Display a placeholder image or any other UI element
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(ArticleImageHeight)
                            .clip(MaterialTheme.shapes.medium)
                            .background(Color.Gray), // Placeholder background color
                    ) {
                        Text(
                            text = "No Image",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(MediumPadding1))
                article.title.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.displaySmall,
                        color = colorResource(
                            id = R.color.text_title
                        )
                    )
                }
                article.content?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        color = colorResource(
                            id = R.color.body
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview(){
    DailyBuzzTheme(dynamicColor = false) {
        DetailsScreen(article = Article(
            id= 1,
            author = "",
            title = "Hello Testing my detail Screen",
            description = "I need job as soon i can, tring my best to get one job.",
            content = "android developer",
            publishedAt = "2024-03-12T17:54:33Z",
            source = Source(id = "",name="bbc"),
            url = "https://coolors.co/palettes/trending",
            urlToImage = "https://buffer.com/library/content/images/2023/10/free-images.jpg"
        ), event = {}, sideEffect =null) {

        }
    }
}