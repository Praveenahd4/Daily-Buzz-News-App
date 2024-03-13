package com.hd.dailybuzz.presentation.bookmark

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hd.dailybuzz.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {

    private val _state = mutableStateOf(BookmarkState())
    val state: State<BookmarkState> = _state

    init {
        getArticles()
    }

    private fun getArticles() {
        newsUseCases.getArticles().onEach {
            _state.value = _state.value.copy(articles = it)
        }.launchIn(viewModelScope)
    }
}
//class BookmarkViewModel @Inject constructor(
//    private val getSavedArticlesUseCase: GetSavedArticles,
//    private val upsertArticleUseCase: UpsertArticle,
//    private val deleteArticleUseCase: DeleteArticle
//) : ViewModel() {
//
//    var savedArticlesState = mutableStateOf(BookmarkState())
//        private set
//    var screenToastState = mutableStateOf(DetailScreenState())
//        private set
//
//
//    init {
//        getArticles()
//    }
//
//    private fun getArticles() {
//        getSavedArticlesUseCase().onEach {
//            savedArticlesState.value = savedArticlesState.value.copy(articles = it)
//        }.launchIn(viewModelScope)
//    }
////    fun saveArticle(article:Article){
////        viewModelScope.launch {
////            var article =article
////            article= article.copy(isSaved = true)
////            upsertArticleUseCase.execute(article)
////            screenToastState.value = screenToastState.value.copy(toastMessage = "Article Saved")
////        }
////    }
////    fun deleteArticles(article: Article) {
////        viewModelScope.launch {
////            deleteArticleUseCase.delete(article)
////            savedArticlesState.value = savedArticlesState.value.copy(
////                isDelete = true,
////                toast = "Deleted!"
////            )
////        }
////    }
//
//}