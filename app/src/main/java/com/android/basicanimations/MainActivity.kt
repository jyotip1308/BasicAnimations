package com.android.basicanimations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.basicanimations.ui.theme.BasicAnimationsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicAnimationsTheme {
               Column (
                   modifier = Modifier.fillMaxSize()
               ){
                   
                   var isVisible by remember {
                       mutableStateOf(false)
                   }

                   var isRound by remember {
                       mutableStateOf(false)
                   }
                   Button(onClick = { 
                       isVisible = !isVisible
                       isRound  = !isRound
                       
                   }) {
                       Text(text = "Toggle")
                   }

//                   val transition = updateTransition(
//                       targetState = isRound,
//                       label = null
//                   )
//
//                   val borderRadius by transition.animateInt(
//                       transitionSpec = { tween(2000) },
//                       label = "borderRadius",
//                       targetValueByState = {isRound ->
//                           if (isRound) 100 else 0
//                       }
//                   )
//
//                   val color by transition.animateColor(
//                       transitionSpec = { tween(1000) },
//                       label = "color",
//                       targetValueByState = {isRound ->
//                           if (isRound) Color.Green else Color.Magenta
//
//                       }
//                   )

                  /* val borderRadius by animateIntAsState(
                       targetValue = if (isRound) 40 else 20,

                       //TWEEN
                       animationSpec = tween(
                           durationMillis = 1000
                       ),



                       //SPRING

//                       animationSpec = spring(
//                           dampingRatio = Spring.DampingRatioHighBouncy,
//                           stiffness = Spring.StiffnessVeryLow
//                       ),


                       // KEYFRAMES
//                       animationSpec = keyframes {  },
                       label = "border radius"
                   )
*/


//                   val transition = rememberInfiniteTransition(label = "")
//                   val borderRadius by transition.animateFloat(
//                       initialValue = 0F,
//                       targetValue = 100F,
//                       animationSpec = infiniteRepeatable(
//                           animation = tween(2000),
//                           repeatMode = RepeatMode.Reverse
//                       ) ,
//                       label = "animate"
//                   )
//
//                   val color by transition.animateColor(
//                       initialValue = Color.Magenta,
//                       targetValue = Color.Green,
//                       animationSpec = infiniteRepeatable(
//                           animation = tween(2000),
//                           repeatMode = RepeatMode.Reverse
//                       ) ,
//                       label = "animate"
//                   )
//
//                   Box(
//                       modifier = Modifier
//                           .padding(36.dp)
//                           .size(200.dp)
//                           .clip(RoundedCornerShape(borderRadius))
//                           .background(color)
//                   )

//                   {
//                       Image(painter = painterResource(id = R.drawable.nature),
//                           contentDescription = "")
//                   }

//                   AnimatedVisibility(
//                       visible = isVisible,
//                       enter = slideInHorizontally() + fadeIn(),
//                       modifier = Modifier.fillMaxWidth().weight(1f)
//                       ) {
//                       Image(painter = painterResource(id = R.drawable.nature),
//                           contentDescription = "nature")
//                   }


 /*                  AnimatedContent(
                       targetState = isVisible,
                       modifier = Modifier
                           .fillMaxWidth()
                           .weight(1f)
                           .padding(8.dp),
                       label = "Animate Content",
                       transitionSpec = {
                           slideInHorizontally(
                               initialOffsetX = {
//                                   -it
                                   if (isVisible) it else -it
                               }
                           ) with slideOutHorizontally(
                               targetOffsetX = {
//                                   it
                                   if (isVisible) -it else it
                               }
                           )
                       }
                   ) {isVisible ->
                       if (isVisible){

                           Box(modifier = Modifier.background(Color.Green))

                       }
                       else {
                           Box(modifier = Modifier.background(Color.Magenta))
                       }
                   }*/

                   var toggled by remember {
                       mutableStateOf(false)
                   }
                   val color by animateColorAsState(
                       targetValue = if(toggled) Color.Green else Color.Magenta,
                       label = "Color",
                       animationSpec = infiniteRepeatable(
                           animation = tween(2000),
                           repeatMode = RepeatMode.Reverse
                       )
                   )


                   val animatePadding by animateDpAsState(
                       targetValue = if (toggled) 32.dp else 0.dp,
                       label = "Animate Padding",
                       animationSpec = infiniteRepeatable(
                           animation = tween(2000),
                           repeatMode = RepeatMode.Reverse
                       )
                   )



                   Column (
                       modifier = Modifier
                           .padding(8.dp)
                           .fillMaxSize()
                   ){
                       Box(modifier = Modifier
                           .aspectRatio(1f)
                           .fillMaxSize()
                           .padding(animatePadding)
                           .background(color)
                           .clickable { toggled = !toggled }){
                           Image(
                               painter = painterResource(id = R.drawable.nature),
                               contentDescription = "Nature" ,
                               contentScale = ContentScale.Crop)
                       }

                   }
                   
               }
            }
        }
    }
}
