package com.example.dogprofilepage

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension


@Composable
fun ProfilePage()
{

    Card(elevation = 6.dp,modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
        .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(30.dp))
    ) {
        BoxWithConstraints() {
            val constarint=if(minWidth<600.dp)
            {
                portaritConstraint(16.dp)
            }
            else
            {
                landscapeConstrain(16.dp)
            }

        ConstraintLayout(constarint) {

            Image(
                painter = painterResource(id = R.drawable.dog_img),
                contentDescription = "Puppies",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp, color = Color.Blue, shape = CircleShape
                    )
                    .layoutId("image"),
                contentScale = ContentScale.Crop
            )
            Text(text = "Cutest puppies", modifier = Modifier.layoutId("cutePuppies"))
            Text(text = "Kuala Lumpur", modifier = Modifier.layoutId("cityText"))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .layoutId("cutePuppisDec")
            )
            {
                ProfileStats("150", "Followers")
                ProfileStats("100", "Following")
                ProfileStats("30", "Post")
            }

            Button(
                onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                    Color.DarkGray
                ), modifier = Modifier.layoutId("buttonFollow")
            ) {
                Text(text = "Follow User", color = Color.White)

            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.layoutId("buttonDirectMessge")) {
                Text(text = "Direct Message")

            }
        }
        }
    }

}

 fun portaritConstraint(margin: Dp):ConstraintSet
{
    return ConstraintSet{

        val  image=createRefFor("image")
        val  cutePuppies=createRefFor("cutePuppies")
        val  cityText=createRefFor("cityText")
        val  cutePuppisDec=createRefFor("cutePuppisDec")
        val  buttonFollow=createRefFor("buttonFollow")
        val  buttonDirectMessge=createRefFor("buttonDirectMessge")
        val guideline=createGuidelineFromTop(0.1f)
        constrain(image)
        {
            top.linkTo(guideline) // it is linked at the top of the parent card
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(cutePuppies)
        {
            top.linkTo(image.bottom) // it will be under image
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(cityText)
        {
            top.linkTo(cutePuppies.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(cutePuppisDec)
        {
            top.linkTo(cityText.bottom)

        }
        constrain(buttonFollow)
        {
            top.linkTo(cutePuppisDec.bottom,margin =margin)
            start.linkTo(parent.start)
            end.linkTo(buttonDirectMessge.start)
            width= Dimension.wrapContent
        }
        constrain(buttonDirectMessge)
        {
            top.linkTo(cutePuppisDec.bottom,margin = margin)
            start.linkTo(buttonFollow.end,margin = 16.dp)
            end.linkTo(parent.end)
        }
    }
}

fun landscapeConstrain(margin: Dp):ConstraintSet
{
    return ConstraintSet(){
        val  image=createRefFor("image")
        val  cutePuppies=createRefFor("cutePuppies")
        val  cityText=createRefFor("cityText")
        val  cutePuppisDec=createRefFor("cutePuppisDec")
        val  buttonFollow=createRefFor("buttonFollow")
        val  buttonDirectMessge=createRefFor("buttonDirectMessge")
        val guideline=createGuidelineFromTop(0.1f)
        constrain(image)
        {
            top.linkTo(guideline,margin=margin) // it is linked at the top of the parent card
            start.linkTo(parent.start,margin = margin)

        }
        constrain(cutePuppies)
        {
            top.linkTo(image.bottom) // it will be under image
            start.linkTo(parent.start,margin = margin)

        }
        constrain(cityText)
        {
            top.linkTo(cutePuppies.bottom)
            start.linkTo(cutePuppies.start)
            end.linkTo(cutePuppies.end)

        }
        constrain(cutePuppisDec)
        {
            top.linkTo(image.top)
            start.linkTo(image.end,margin = margin)
            end.linkTo(parent.end)

        }
        constrain(buttonFollow)
        {
            top.linkTo(cutePuppisDec.bottom,margin =margin)
            start.linkTo(cutePuppisDec.start)
            end.linkTo(buttonDirectMessge.start)
            bottom.linkTo(cityText.bottom)
            width= Dimension.wrapContent
        }
        constrain(buttonDirectMessge)
        {
            top.linkTo(cutePuppisDec.bottom,margin = margin)
            start.linkTo(buttonFollow.end,margin = 16.dp)
            bottom.linkTo(cityText.bottom)
            end.linkTo(parent.end)
        }
    }
}
@Composable
fun ProfileStats(count:String,title:String)
{
    Column (horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = count,fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview()
{
    ProfilePage()
}