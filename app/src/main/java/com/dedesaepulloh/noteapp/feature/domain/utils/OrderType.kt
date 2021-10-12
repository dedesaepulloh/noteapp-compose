package com.dedesaepulloh.noteapp.feature.domain.utils

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
