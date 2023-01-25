package com.mmt.composecalculatorapp.download

interface DownLoader {
    fun downloadFile(url: String): Long
}