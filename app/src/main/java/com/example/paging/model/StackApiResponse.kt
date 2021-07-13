package com.example.paging.model

data class StackApiResponse(
    val backoff: Int,
    val has_more: Boolean,
    val items: List<Item>,
    val quota_max: Int,
    val quota_remaining: Int
)