package atef.stc.jetback.compose.models

import atef.stc.jetback.compose.uistate.SectionBaseUIState

data class TopBrandsListState(
    var numberOfGridRows: Int = 2,
    val topBrands: List<TopBrand> = getDummyTopBrandsList(),
    override val sectionDetails: SectionDetails? = SectionDetails(title = "Top Brads", subTitle = "Our Top Brads for you"),
    override val isLoading: Boolean = false,
    override val hasError: Boolean = false,
) : SectionBaseUIState(isLoading, hasError, sectionDetails)

fun getDummyTopBrandsList() : List<TopBrand> {
    return listOf<TopBrand>(
        TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://smilesuae.ae/images/APP/FRESCO/TOP_BRANDS/Logo-4.png"
        ),
        TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://www.celebritycruises.com/blog/content/uploads/2020/12/famous-landmarks-in-europe-paris-france.jpg"
        ),
        TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc//egy/desktop//imagestemp/56-Combo.png"
        ),TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc/egy/imagestemp/510050.png"
        ),TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc/egy/imagestemp/600001.png"
        ),TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc/egy/imagestemp/600030.png"
        ),TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc/egy/imagestemp/511006.png"
        ),TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc//egy//imagestemp/811701.png"
        ),TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://kfcprodnecmsimage.azureedge.net/cmsimages/kfc/egy/desktop/imagestemp/110005.png"
        )
    )
}
