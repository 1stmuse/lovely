package com.lovely.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.lovely.core.navigation.Destinations
import com.lovely.core.presentation.component.AppButton
import com.lovely.onboarding.component.SwiperItem
import com.lovely.onboarding.component.onboardingItem
import org.koin.androidx.compose.navigation.koinNavViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoarding(navController: NavController) {
    val vm:OnboardingViewModel = koinNavViewModel()
    val state = rememberPagerState(initialPage = 0, pageCount = { onboardingItem.size})

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(50.dp))
        HorizontalPager(state = state,
            pageSize = PageSize.Fixed(250.dp),
//            pageSpacing = 30.dp,
            contentPadding = PaddingValues(horizontal = 70.dp)
        ) {

            SwiperItem(image = onboardingItem[it].image, index = it, currentIndex = state.currentPage )
        }
        Column(modifier = Modifier.padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = onboardingItem[state.currentPage].label, textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = onboardingItem[state.currentPage].desc,  textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
                )
            Spacer(modifier = Modifier.height(30.dp))
            AppButton(label = "Create Account") {
                vm.loginUser()
                val navOptions = NavOptions.Builder().setPopUpTo(Destinations.Onboarding.route, inclusive = true).build()
                navController.navigate(Destinations.SigninOptions.route, navOptions)
            }
        }
    }
}