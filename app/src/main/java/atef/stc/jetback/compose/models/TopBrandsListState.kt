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
            imageUrl = "https://car-images.bauersecure.com/wp-images/2697/best_electric_2022.jpg"
        ),
        TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://smilesuae.ae/images/APP/FRESCO/TOP_BRANDS/Logo-4.png"
        ),TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://smilesuae.ae/images/APP/FRESCO/TOP_BRANDS/Logo-4.png"
        ),TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://car-images.bauersecure.com/wp-images/2697/best_electric_2022.jpg"
        ),TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://smilesuae.ae/images/APP/FRESCO/TOP_BRANDS/Logo-4.png"
        ),TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://smilesuae.ae/images/APP/FRESCO/TOP_BRANDS/Logo-4.png"
        ),TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://car-images.bauersecure.com/wp-images/2697/best_electric_2022.jpg"
        ),TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://smilesuae.ae/images/APP/FRESCO/TOP_BRANDS/Logo-4.png"
        )
    )
}
