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
        AdModel(featured = true, adId = 0, adImageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc/egy/desktop/imagestemp/102-Combo.png", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc/egy/desktop/imagestemp/48-Combo.png", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc/egy/desktop/imagestemp/32-Combo.png", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc/egy/desktop/imagestemp/110008.png", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc/egy/desktop/imagestemp/110049.png", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc/egy/desktop/imagestemp/58-Combo.png", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc/egy/desktop/imagestemp/110003.png", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc/egy/desktop/imagestemp/148-Combo.png", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc/egy/desktop/imagestemp/110059.png", externalWebUrl = null, isPromotional = true, null),
        AdModel(featured = true, adId = 0, adImageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc/egy/desktop/imagestemp/110035.png", externalWebUrl = null, isPromotional = true, null),
    )
}
