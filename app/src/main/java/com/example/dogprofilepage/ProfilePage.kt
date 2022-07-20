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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension


@Composable
fun ProfilePage()
{

    Card(elevation = 6.dp,modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
        .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(30.dp))
    ) {
        /**
         * Modifier.fillMaxSize take the entire row to fill
         * Content of our card
         */
        ConstraintLayout{
            val (image,cutePuppies,cityText,cutePuppisDec,buttonFollow,buttonDirectMessge)=createRefs()
            val guideLine=createGuidelineFromTop(0.1f)
            Image(painter = painterResource(id = R.drawable.dog_img)
                ,contentDescription = "Puppies"
                , modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp, color = Color.Blue, shape = CircleShape
                    ).constrainAs(image) // How something is positioned
                    {
                        top.linkTo(guideLine) // it is linked at the top of the parent card
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                    }
                ,contentScale = ContentScale.Crop)
            Text(text="Cutest puppies",
            modifier= Modifier.constrainAs(cutePuppies)
            {
                top.linkTo(image.bottom) // it will be under image
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
            Text(text="Kuala Lumpur",
            modifier = Modifier.constrainAs(cityText)
            {
                top.linkTo(cutePuppies.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .constrainAs(cutePuppisDec)
                    {
                        top.linkTo(cityText.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })
            {
                ProfileStats("150","Followers")
                ProfileStats("100","Following")
                ProfileStats("30","Post")
            }

                Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(
                    Color.DarkGray),modifier = Modifier.constrainAs(buttonFollow)
                {
                    top.linkTo(cutePuppisDec.bottom,margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(buttonDirectMessge.start)
                    width= Dimension.wrapContent
                }) {
                    Text(text = "Follow User",color = Color.White)

                }
                Button(onClick = { /*TODO*/ },modifier=Modifier.constrainAs(buttonDirectMessge)
                {
                    top.linkTo(cutePuppisDec.bottom,margin = 16.dp)
                    start.linkTo(buttonFollow.end,margin = 16.dp)
                    end.linkTo(parent.end)
                    width= Dimension.wrapContent
                }) {
                    Text(text = "Direct Message")

                }

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