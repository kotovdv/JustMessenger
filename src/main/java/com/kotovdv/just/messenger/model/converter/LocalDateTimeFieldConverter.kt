package com.kotovdv.just.messenger.model.converter

import java.sql.Timestamp
import java.sql.Timestamp.valueOf
import java.time.LocalDateTime
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class LocalDateTimeFieldConverter : AttributeConverter<LocalDateTime, Timestamp> {

    override fun convertToDatabaseColumn(localDateTime: LocalDateTime?): Timestamp? {
        return if (localDateTime != null) valueOf(localDateTime) else null
    }

    override fun convertToEntityAttribute(timestamp: Timestamp?): LocalDateTime? {
        return timestamp?.toLocalDateTime()
    }
}
