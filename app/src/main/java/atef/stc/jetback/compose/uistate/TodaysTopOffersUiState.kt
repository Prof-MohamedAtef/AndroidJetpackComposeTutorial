package atef.stc.jetback.compose.uistate

import atef.stc.jetback.compose.models.AdModel
import atef.stc.jetback.compose.models.SectionDetails

data class TodaysTopOffersUiState(
    val data: List<AdModel> = getDummyTopOffersList(),
    override val sectionDetails: SectionDetails? = SectionDetails(title = "Top Offers", subTitle = "Get your Offers"),
    override val isLoading: Boolean = false,
    override val hasError: Boolean = false,
) : SectionBaseUIState(isLoading, hasError, sectionDetails)


fun getDummyTopOffersList() : List<AdModel>{
    return listOf<AdModel>(
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.motortrend.com/uploads/2023/06/003-2024-Lexus-GX-03.jpg?fit=around%7C875:492", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.telegraph.co.uk/content/dam/cars/2023/05/02/TELEMMGLPICT000283815772_trans_NvBQzQNjv4BqbK_1UUehATdjjkMr7SzgmaFUQKs5OtsqD0rsK93FHDU.jpeg?imwidth=1280", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://m.atcdn.co.uk/vms/media/b43037cf53da44b8b232ac042e942785.jpg", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.telegraph.co.uk/content/dam/cars/2023/05/02/TELEMMGLPICT000283815772_trans_NvBQzQNjv4BqbK_1UUehATdjjkMr7SzgmaFUQKs5OtsqD0rsK93FHDU.jpeg?imwidth=1280", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.telegraph.co.uk/content/dam/cars/2023/05/02/TELEMMGLPICT000283815772_trans_NvBQzQNjv4BqbK_1UUehATdjjkMr7SzgmaFUQKs5OtsqD0rsK93FHDU.jpeg?imwidth=1280", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.acura.com/-/media/Acura-Platform/homepage/hero-carousel/2023/MY23-TLX-and-Type-S-CO/2023-TLX-homepage-hero_xl.jpg", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://images.ctfassets.net/c9t6u0qhbv9e/4mPSBtGfxQYmLf3wDKP8oZ/445c033d8a28cc9c736dca427f43942c/____EV9_GTL_KV_EXT_04.jpg", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.telegraph.co.uk/content/dam/cars/2023/05/02/TELEMMGLPICT000283815772_trans_NvBQzQNjv4BqbK_1UUehATdjjkMr7SzgmaFUQKs5OtsqD0rsK93FHDU.jpeg?imwidth=1280", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://media.architecturaldigest.com/photos/6304f967ba7fd5ce146f1a19/master/w_2580%2Cc_limit/Lincoln%2520Model%2520L100%2520Concept%2520Exterior%25205.jpg", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://www.acura.com/-/media/Acura-Platform/Vehicle-Pages/TLX/2023/gallery-page/Exterior/Detail/09-acura-tlx-2023-gallery-exterior-detailview-Exclusive-chassis-bracing-and-reinforcement.jpg?mw=1400&hash=F3DB796FC52A97A3E11E6EA8F0709E9A", externalWebUrl = null, isPromotional = true, null),
    )
}