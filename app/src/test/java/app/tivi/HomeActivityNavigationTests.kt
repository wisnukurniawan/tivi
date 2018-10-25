/*
 * Copyright 2018 LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.tivi

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.tivi.home.HomeActivity
import app.tivi.utils.bottomNavItemWithTitle
import app.tivi.utils.rotateLandscape
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(application = TiviApplication::class)
class HomeActivityNavigationTests {

    lateinit var scenario: ActivityScenario<HomeActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(HomeActivity::class.java)
                .moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun testBottomNavigationLibraryClick() {
        onView(bottomNavItemWithTitle(R.string.home_nav_library))
                .perform(click())

        onView(withId(R.id.library_rv))
                .check(matches(isDisplayed()))
    }

    @Test
    fun testBottomNavigationLibraryClickAfterRotation() {
        onView(isRoot()).perform(rotateLandscape())

        onView(bottomNavItemWithTitle(R.string.home_nav_library))
                .perform(click())

        onView(withId(R.id.library_rv))
                .check(matches(isDisplayed()))
    }
}