package com.hd.dailybuzz.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hd.dailybuzz.R
import com.hd.dailybuzz.domain.model.Article
import com.hd.dailybuzz.presentation.Dimens.ArticleCardSize
import com.hd.dailybuzz.presentation.Dimens.ExtraSmallPadding
import com.hd.dailybuzz.presentation.Dimens.ExtraSmallPadding2
import com.hd.dailybuzz.presentation.Dimens.SmallIconSize


@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: (() -> Unit)? = null
) {

    val context = LocalContext.current
    Row(
        modifier = modifier.clickable { onClick?.invoke() },

        ) {

        if (!article.urlToImage.isNullOrEmpty()) {
            AsyncImage(
                modifier = Modifier
                    .size(ArticleCardSize)
                    .clip(MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(context).data(article.urlToImage).build(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        } else {
            // Display a placeholder or any other UI element when the image URL is null or empty
            Box(
                modifier = Modifier
                    .size(ArticleCardSize)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.Gray),
            ) {
                Text(
                    text = "No Image",
                    style = MaterialTheme.typography.bodyMedium.copy(),
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize)
        ) {
            article.title?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium.copy(),
                    color = colorResource(id = R.color.text_title),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                article.source?.let {
                    Text(
                        text = it.name,
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                        color = colorResource(id = R.color.body)
                    )
                }
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding))
                article.publishedAt?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.labelSmall,
                        color = colorResource(id = R.color.body)
                    )
                }
            }
        }
    }
}