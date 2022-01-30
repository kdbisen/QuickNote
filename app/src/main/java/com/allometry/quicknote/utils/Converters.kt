package com.allometry.quicknote.utils

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class Converters {
  @TypeConverter
  fun timeStampFromDate(date: Date): Long {
    return date.time

  }
  @TypeConverter
  fun dateFromTimestamp(timestamp: Long): Date? {
    return Date(timestamp)
  }
}