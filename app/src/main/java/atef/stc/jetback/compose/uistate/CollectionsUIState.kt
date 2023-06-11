package atef.stc.jetback.compose.uistate

import atef.stc.jetback.compose.models.CollectionsModel
import atef.stc.jetback.compose.models.ItemCategoriesDetails
import atef.stc.jetback.compose.models.SectionDetails

data class CollectionsUIState(
    val data: List<CollectionsModel> = getDummyCollectionsList(),
    var numberOfGridRows: Int = 1,
    override val sectionDetails: SectionDetails? = SectionDetails(title = "Collections", subTitle = "build it bigger"),
    override val isLoading: Boolean = false,
    override val hasError: Boolean = false,
) : SectionBaseUIState(isLoading, hasError, sectionDetails)

fun getDummyCollectionsList() : List<CollectionsModel> {
    return listOf<CollectionsModel>(
        CollectionsModel("0","Cairo", "capital city", "https://imageio.forbes.com/specials-images/imageserve/5d35eacaf1176b0008974b54/2020-Chevrolet-Corvette-Stingray/0x0.jpg?format=jpg&crop=4560,2565,x790,y784,safe&width=960",""),
        CollectionsModel("0","Alex", "capital city", "https://imageio.forbes.com/specials-images/imageserve/5d35eacaf1176b0008974b54/2020-Chevrolet-Corvette-Stingray/0x0.jpg?format=jpg&crop=4560,2565,x790,y784,safe&width=960",""),
        CollectionsModel("0","Giza", "capital city", "https://hips.hearstapps.com/hmg-prod/images/nissanz2023-1673297639.jpeg?crop=0.535xw:0.357xh;0.290xw,0.489xh&resize=1200:*",""),
        CollectionsModel("0","October", "capital city", "https://imageio.forbes.com/specials-images/imageserve/5d35eacaf1176b0008974b54/2020-Chevrolet-Corvette-Stingray/0x0.jpg?format=jpg&crop=4560,2565,x790,y784,safe&width=960",""),
        CollectionsModel("0","MAtrouh", "capital city", "https://imageio.forbes.com/specials-images/imageserve/5d35eacaf1176b0008974b54/2020-Chevrolet-Corvette-Stingray/0x0.jpg?format=jpg&crop=4560,2565,x790,y784,safe&width=960",""),
        CollectionsModel("0","Luxor", "capital city", "https://imageio.forbes.com/specials-images/imageserve/5d35eacaf1176b0008974b54/2020-Chevrolet-Corvette-Stingray/0x0.jpg?format=jpg&crop=4560,2565,x790,y784,safe&width=960",""),
        CollectionsModel("0","Sinai", "capital city", "https://hips.hearstapps.com/hmg-prod/images/nissanz2023-1673297639.jpeg?crop=0.535xw:0.357xh;0.290xw,0.489xh&resize=1200:*",""),
        CollectionsModel("0","Aswan", "capital city", "https://imageio.forbes.com/specials-images/imageserve/5d35eacaf1176b0008974b54/2020-Chevrolet-Corvette-Stingray/0x0.jpg?format=jpg&crop=4560,2565,x790,y784,safe&width=960",""),
        CollectionsModel("0","Sharm Elsheikh", "capital city", "https://imageio.forbes.com/specials-images/imageserve/5d35eacaf1176b0008974b54/2020-Chevrolet-Corvette-Stingray/0x0.jpg?format=jpg&crop=4560,2565,x790,y784,safe&width=960",""),
        CollectionsModel("0","Gaza", "capital city", "https://imageio.forbes.com/specials-images/imageserve/5d35eacaf1176b0008974b54/2020-Chevrolet-Corvette-Stingray/0x0.jpg?format=jpg&crop=4560,2565,x790,y784,safe&width=960",""),
    )
}


