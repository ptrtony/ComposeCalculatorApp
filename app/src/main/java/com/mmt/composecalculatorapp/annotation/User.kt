package com.mmt.composecalculatorapp.annotation

data class User(
    val name: String,
    @AllowRegex(regex = "\\d{4}-\\d{2}-\\d{2}") val birthDate: String
) {
    init {
        val fields = this::class.java.declaredFields
        fields.forEach { field ->
            field?.annotations?.forEach { annotation ->
                if (annotation is AllowRegex) {
                    val regex = annotation.regex
                    if (!regex.toRegex().matches(birthDate)) {
                        throw IllegalArgumentException("Birth date is not valid date:$birthDate")
                    }
                }
            }
        }
    }
}

@Target(AnnotationTarget.FIELD)
annotation class AllowRegex(val regex: String)