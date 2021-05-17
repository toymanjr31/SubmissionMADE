package com.dicoding.androidprogramming.submissionmade.di

import com.dicoding.androidprogramming.submissionmade.core.domain.usecase.MovieInteractor
import com.dicoding.androidprogramming.submissionmade.core.domain.usecase.MovieUseCase
import com.dicoding.androidprogramming.submissionmade.detail.DetailMovieViewModel
import com.dicoding.androidprogramming.submissionmade.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}