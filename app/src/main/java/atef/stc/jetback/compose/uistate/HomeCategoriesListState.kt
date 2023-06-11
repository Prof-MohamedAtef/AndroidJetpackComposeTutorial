package atef.stc.jetback.compose.uistate

import atef.stc.jetback.compose.models.ItemCategoriesDetails
import atef.stc.jetback.compose.models.SectionDetails

data class HomeCategoriesListState(
    val data: List<ItemCategoriesDetails> = getDummyItemCategories(),
    override var sectionDetails: SectionDetails? = null,
    override var isLoading: Boolean = false,
    override var hasError: Boolean = false,
) : SectionBaseUIState(isLoading, hasError, sectionDetails)


fun getDummyItemCategories() : List<ItemCategoriesDetails>{
    return listOf<ItemCategoriesDetails>(
        ItemCategoriesDetails(0, "Books", null, "https://img.freepik.com/free-vector/hand-drawn-flat-design-stack-books-illustration_23-2149341898.jpg?w=1380&t=st=1686467659~exp=1686468259~hmac=a745e2341fef3fd4dd7059a38be19ea0b344bd7afe30952ed3baf9160863614f", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://img.freepik.com/free-vector/hand-drawn-flat-design-stack-books-illustration_23-2149341898.jpg?w=1380&t=st=1686467659~exp=1686468259~hmac=a745e2341fef3fd4dd7059a38be19ea0b344bd7afe30952ed3baf9160863614f", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://img.freepik.com/free-vector/hand-drawn-flat-design-stack-books-illustration_23-2149341898.jpg?w=1380&t=st=1686467659~exp=1686468259~hmac=a745e2341fef3fd4dd7059a38be19ea0b344bd7afe30952ed3baf9160863614f", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://img.freepik.com/free-vector/hand-drawn-flat-design-stack-books-illustration_23-2149341898.jpg?w=1380&t=st=1686467659~exp=1686468259~hmac=a745e2341fef3fd4dd7059a38be19ea0b344bd7afe30952ed3baf9160863614f", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://img.freepik.com/free-vector/hand-drawn-flat-design-stack-books-illustration_23-2149341898.jpg?w=1380&t=st=1686467659~exp=1686468259~hmac=a745e2341fef3fd4dd7059a38be19ea0b344bd7afe30952ed3baf9160863614f", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://img.freepik.com/free-vector/hand-drawn-flat-design-stack-books-illustration_23-2149341898.jpg?w=1380&t=st=1686467659~exp=1686468259~hmac=a745e2341fef3fd4dd7059a38be19ea0b344bd7afe30952ed3baf9160863614f", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://img.freepik.com/free-vector/hand-drawn-flat-design-stack-books-illustration_23-2149341898.jpg?w=1380&t=st=1686467659~exp=1686468259~hmac=a745e2341fef3fd4dd7059a38be19ea0b344bd7afe30952ed3baf9160863614f", null, "#ffcccc",null, null, null, null, null,null),
        ItemCategoriesDetails(0, "Books", null, "https://img.freepik.com/free-vector/hand-drawn-flat-design-stack-books-illustration_23-2149341898.jpg?w=1380&t=st=1686467659~exp=1686468259~hmac=a745e2341fef3fd4dd7059a38be19ea0b344bd7afe30952ed3baf9160863614f", null, "#ffcccc",null, null, null, null, null,null),
    )
}
