package atef.stc.jetback.compose.uistate

import atef.stc.jetback.compose.models.AdModel
import atef.stc.jetback.compose.models.SectionDetails
import atef.stc.jetback.compose.models.SubscriptionBanner

data class SubscriptionUiState(
    val data: List<AdModel> = getDummySubscriptionsList(),
    val foodOrderBanner: SubscriptionBanner? = null,
    override val sectionDetails: SectionDetails? = SectionDetails(title = "Subscriptions", subTitle = "Subscribe if you need"),
    override val isLoading: Boolean = false,
    override val hasError: Boolean = false,
) : SectionBaseUIState(isLoading, hasError, sectionDetails)

fun getDummySubscriptionsList() : List<AdModel> {
    return listOf<AdModel>(
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.telegraph.co.uk/content/dam/cars/2023/05/02/TELEMMGLPICT000283815772_trans_NvBQzQNjv4BqbK_1UUehATdjjkMr7SzgmaFUQKs5OtsqD0rsK93FHDU.jpeg?imwidth=1280", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.telegraph.co.uk/content/dam/cars/2023/05/02/TELEMMGLPICT000283815772_trans_NvBQzQNjv4BqbK_1UUehATdjjkMr7SzgmaFUQKs5OtsqD0rsK93FHDU.jpeg?imwidth=1280", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.telegraph.co.uk/content/dam/cars/2023/05/02/TELEMMGLPICT000283815772_trans_NvBQzQNjv4BqbK_1UUehATdjjkMr7SzgmaFUQKs5OtsqD0rsK93FHDU.jpeg?imwidth=1280", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.telegraph.co.uk/content/dam/cars/2023/05/02/TELEMMGLPICT000283815772_trans_NvBQzQNjv4BqbK_1UUehATdjjkMr7SzgmaFUQKs5OtsqD0rsK93FHDU.jpeg?imwidth=1280", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.telegraph.co.uk/content/dam/cars/2023/05/02/TELEMMGLPICT000283815772_trans_NvBQzQNjv4BqbK_1UUehATdjjkMr7SzgmaFUQKs5OtsqD0rsK93FHDU.jpeg?imwidth=1280", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.telegraph.co.uk/content/dam/cars/2023/05/02/TELEMMGLPICT000283815772_trans_NvBQzQNjv4BqbK_1UUehATdjjkMr7SzgmaFUQKs5OtsqD0rsK93FHDU.jpeg?imwidth=1280", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.telegraph.co.uk/content/dam/cars/2023/05/02/TELEMMGLPICT000283815772_trans_NvBQzQNjv4BqbK_1UUehATdjjkMr7SzgmaFUQKs5OtsqD0rsK93FHDU.jpeg?imwidth=1280", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.telegraph.co.uk/content/dam/cars/2023/05/02/TELEMMGLPICT000283815772_trans_NvBQzQNjv4BqbK_1UUehATdjjkMr7SzgmaFUQKs5OtsqD0rsK93FHDU.jpeg?imwidth=1280", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.telegraph.co.uk/content/dam/cars/2023/05/02/TELEMMGLPICT000283815772_trans_NvBQzQNjv4BqbK_1UUehATdjjkMr7SzgmaFUQKs5OtsqD0rsK93FHDU.jpeg?imwidth=1280", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.telegraph.co.uk/content/dam/cars/2023/05/02/TELEMMGLPICT000283815772_trans_NvBQzQNjv4BqbK_1UUehATdjjkMr7SzgmaFUQKs5OtsqD0rsK93FHDU.jpeg?imwidth=1280", externalWebUrl = null, isPromotional = true, null),
    )
}
