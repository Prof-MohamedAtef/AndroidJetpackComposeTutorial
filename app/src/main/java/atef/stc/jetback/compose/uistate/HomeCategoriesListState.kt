package atef.stc.jetback.compose.uistate

import atef.stc.jetback.compose.models.GroupItemCategoriesDetails
import atef.stc.jetback.compose.models.ItemCategoriesDetails
import atef.stc.jetback.compose.models.SectionDetails

data class HomeCategoriesListState(
    val data: List<ItemCategoriesDetails> = getDummyItemCategories(),
    override var sectionDetails: SectionDetails? = SectionDetails(title = "Categories", subTitle = "Pick appropriate Items"),
    override var isLoading: Boolean = false,
    override var hasError: Boolean = false,
) : SectionBaseUIState(isLoading, hasError, sectionDetails)


fun getDummyItemCategories() : List<ItemCategoriesDetails>{
    return listOf<ItemCategoriesDetails>(
        ItemCategoriesDetails(0, "Books", null, "https://www.usnews.com/object/image/00000185-cfee-ddcf-a5c7-ffeebfb20001/new-intro-stock.jpg?update-time=1674230808410&size=responsive970", null, "#ffcccc",null, null, null, null, null, null),
        ItemCategoriesDetails(0, "Books", null, "https://www.kids-world-travel-guide.com/images/xparis_eiffeltower_ssk500.jpeg.pagespeed.ic.k1hzu_w6jL.webp", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://i0.wp.com/theboutiqueadventurer.com/wp-content/uploads/2020/11/Rome-Colosseum-pink-flowers.jpg?w=1067&ssl=1", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://www.celebritycruises.com/blog/content/uploads/2022/01/famous-landmarks-in-paris-arc-de-triomphe-hero-1920x890.jpg", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://thetravelscribes.com/wp-content/uploads/2020/06/Landmarks-of-the-World-header-feature-image.jpg", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://img.freepik.com/free-vector/hand-drawn-flat-design-stack-books-illustration_23-2149341898.jpg?w=1380&t=st=1686467659~exp=1686468259~hmac=a745e2341fef3fd4dd7059a38be19ea0b344bd7afe30952ed3baf9160863614f", null, "#ffcccc",null, null, null, null, null, null),
        ItemCategoriesDetails(0, "Books", null, "https://img.freepik.com/free-vector/hand-drawn-flat-design-stack-books-illustration_23-2149341898.jpg?w=1380&t=st=1686467659~exp=1686468259~hmac=a745e2341fef3fd4dd7059a38be19ea0b344bd7afe30952ed3baf9160863614f", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://img.freepik.com/free-vector/hand-drawn-flat-design-stack-books-illustration_23-2149341898.jpg?w=1380&t=st=1686467659~exp=1686468259~hmac=a745e2341fef3fd4dd7059a38be19ea0b344bd7afe30952ed3baf9160863614f", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://www.usnews.com/object/image/00000185-cfee-ddcf-a5c7-ffeebfb20001/new-intro-stock.jpg?update-time=1674230808410&size=responsive970", null, "#ffcccc",null, null, null, null, null, null),
        ItemCategoriesDetails(0, "Books", null, "https://www.kids-world-travel-guide.com/images/xparis_eiffeltower_ssk500.jpeg.pagespeed.ic.k1hzu_w6jL.webp", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://i0.wp.com/theboutiqueadventurer.com/wp-content/uploads/2020/11/Rome-Colosseum-pink-flowers.jpg?w=1067&ssl=1", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://www.celebritycruises.com/blog/content/uploads/2022/01/famous-landmarks-in-paris-arc-de-triomphe-hero-1920x890.jpg", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://thetravelscribes.com/wp-content/uploads/2020/06/Landmarks-of-the-World-header-feature-image.jpg", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://img.freepik.com/free-vector/hand-drawn-flat-design-stack-books-illustration_23-2149341898.jpg?w=1380&t=st=1686467659~exp=1686468259~hmac=a745e2341fef3fd4dd7059a38be19ea0b344bd7afe30952ed3baf9160863614f", null, "#ffcccc",null, null, null, null, null, null),
        ItemCategoriesDetails(0, "Books", null, "https://img.freepik.com/free-vector/hand-drawn-flat-design-stack-books-illustration_23-2149341898.jpg?w=1380&t=st=1686467659~exp=1686468259~hmac=a745e2341fef3fd4dd7059a38be19ea0b344bd7afe30952ed3baf9160863614f", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://img.freepik.com/free-vector/hand-drawn-flat-design-stack-books-illustration_23-2149341898.jpg?w=1380&t=st=1686467659~exp=1686468259~hmac=a745e2341fef3fd4dd7059a38be19ea0b344bd7afe30952ed3baf9160863614f", null, "#ffcccc",null, null, null, null, null,null),
    )
}

fun getDummyGroupItemCategoriesDetailsList() : List<GroupItemCategoriesDetails>{
    return listOf<GroupItemCategoriesDetails>(
        GroupItemCategoriesDetails(0, "Books", null, "https://www.usnews.com/object/image/00000185-cfee-ddcf-a5c7-ffeebfb20001/new-intro-stock.jpg?update-time=1674230808410&size=responsive970", getDummyItemCategories()),
        GroupItemCategoriesDetails(0, "Books", null, "https://www.usnews.com/object/image/00000185-cfee-ddcf-a5c7-ffeebfb20001/new-intro-stock.jpg?update-time=1674230808410&size=responsive970", getDummyItemCategories()),
        GroupItemCategoriesDetails(0, "Books", null, "https://www.usnews.com/object/image/00000185-cfee-ddcf-a5c7-ffeebfb20001/new-intro-stock.jpg?update-time=1674230808410&size=responsive970", getDummyItemCategories()),
        GroupItemCategoriesDetails(0, "Books", null, "https://www.usnews.com/object/image/00000185-cfee-ddcf-a5c7-ffeebfb20001/new-intro-stock.jpg?update-time=1674230808410&size=responsive970", getDummyItemCategories()),
        GroupItemCategoriesDetails(0, "Books", null, "https://www.usnews.com/object/image/00000185-cfee-ddcf-a5c7-ffeebfb20001/new-intro-stock.jpg?update-time=1674230808410&size=responsive970", getDummyItemCategories()),
        GroupItemCategoriesDetails(0, "Books", null, "https://www.usnews.com/object/image/00000185-cfee-ddcf-a5c7-ffeebfb20001/new-intro-stock.jpg?update-time=1674230808410&size=responsive970", getDummyItemCategories()),
        GroupItemCategoriesDetails(0, "Books", null, "https://www.usnews.com/object/image/00000185-cfee-ddcf-a5c7-ffeebfb20001/new-intro-stock.jpg?update-time=1674230808410&size=responsive970", getDummyItemCategories()),
        GroupItemCategoriesDetails(0, "Books", null, "https://www.usnews.com/object/image/00000185-cfee-ddcf-a5c7-ffeebfb20001/new-intro-stock.jpg?update-time=1674230808410&size=responsive970", getDummyItemCategories()),
        GroupItemCategoriesDetails(0, "Books", null, "https://www.usnews.com/object/image/00000185-cfee-ddcf-a5c7-ffeebfb20001/new-intro-stock.jpg?update-time=1674230808410&size=responsive970", getDummyItemCategories()),
    )
}