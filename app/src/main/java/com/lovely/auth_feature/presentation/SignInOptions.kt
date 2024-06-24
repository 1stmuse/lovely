package com.lovely.auth_feature.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.lovely.R
import com.lovely.core.navigation.Destinations
import com.lovely.core.presentation.component.AppButton
import com.lovely.core.presentation.component.Buttontype


@Composable
fun SigninOptions(navController: NavController) {

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
            Spacer(modifier = Modifier.height(80.dp))
            Text(text = "Sign up to continue")
            Spacer(modifier = Modifier.height(20.dp))
            AppButton(label = "Continue with email") {
                
            }
            Spacer(modifier = Modifier.height(20.dp))
            AppButton(label = "Use phone number", variant = Buttontype.SECONDARY) {
                val navOptions = NavOptions.Builder().setPopUpTo(Destinations.SigninOptions.route, inclusive = true).build()
                navController.navigate(Destinations.MobileAccess.route, navOptions)
            }
            Spacer(modifier = Modifier.height(60.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                 Divider(modifier = Modifier.weight(1f))
                Text(text = "or sign up with", modifier = Modifier
                    .offset(y = (-12).dp)
                    .padding(horizontal = 10.dp))
                Divider(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Box(modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .width(60.dp)
                    .height(60.dp)
                    .border(1.dp, color = Color.LightGray, shape = RoundedCornerShape(15))
                    .clip(RoundedCornerShape(15.dp))
                    ,
                    contentAlignment = Alignment.Center
                ){
                    Image(painter = painterResource(id = R.drawable.facebook), contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                }
                Box(modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .width(60.dp)
                    .height(60.dp)
                    .border(1.dp, color = Color.LightGray, shape = RoundedCornerShape(15))
                    .clip(RoundedCornerShape(15.dp)),
                    contentAlignment = Alignment.Center
                ){
                    Image(painter = painterResource(id = R.drawable.facebook), contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                }
                Box(modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .width(60.dp)
                    .height(60.dp)
                    .border(1.dp, color = Color.LightGray, shape = RoundedCornerShape(15))
                    .clip(RoundedCornerShape(15.dp)),
                    contentAlignment = Alignment.Center
                ){
                    Image(painter = painterResource(id = R.drawable.facebook), contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                }

            }
            Spacer(modifier = Modifier.height(60.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                 Text(text = "Terms of use", modifier = Modifier.padding(horizontal = 10.dp), color = MaterialTheme.colorScheme.primary)
                Text(text = "Privacy Policy", modifier = Modifier.padding(horizontal = 10.dp), color = MaterialTheme.colorScheme.primary)
            }

        }
}