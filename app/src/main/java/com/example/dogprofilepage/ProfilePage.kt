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
        Column (Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center)
        {
            Image(painter = painterResource(id = R.drawable.dog_img)
                ,contentDescription = "Puppies"
                , modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp, color = Color.Blue, shape = CircleShape
                    )
                ,contentScale = ContentScale.Crop)
            Text(text="Cutest puppies")
            Text(text="Kuala Lumpur")

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
            {
                ProfileStats("150","Followers")
                ProfileStats("100","Following")
                ProfileStats("30","Post")
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
            {
                Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(
                    Color.DarkGray)) {
                    Text(text = "Follow User",color = Color.White)

                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Direct Message")

                }
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