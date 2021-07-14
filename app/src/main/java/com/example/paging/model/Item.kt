package com.example.paging.model

data class Item(
    val answer_id: Int,
    val content_license: String,
    val creation_date: Int,
    val is_accepted: Boolean,
    val last_activity_date: Int,
    val last_edit_date: Int,
    val owner: Owner,
    val question_id: Int,
    val score: Int
)