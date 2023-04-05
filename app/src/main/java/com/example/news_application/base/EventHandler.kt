package com.example.news_application.base

interface EventHandler<T> {
    fun obtainEvent(event: T)
}