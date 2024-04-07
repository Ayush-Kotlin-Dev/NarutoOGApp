package ggv.ayush.narutoog.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success : Boolean,
    val message : String? =null,
    val prevPage : Int ? = null,
    var nextPage : Int ? = null,
    val heroes: List<Hero> = emptyList(),
    val lastUpdated: Long? = null  // Add this line
)