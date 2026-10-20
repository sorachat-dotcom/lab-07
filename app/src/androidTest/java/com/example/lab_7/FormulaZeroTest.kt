package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput

/**
 * @RunWith(...) tells JUnit to use the Android testing system
 * @get:Rule automatically sets up Compose UI testing
 * composeTestRule is the object used to test UI
 *
*/
@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()

    }

    @Test
    fun navigate_to_drivers_add_driver_clear_drivers_return_home() {
        //navigate to Driver Screen
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()

        // verify driver screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // enter first driver name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Leon Kennedy")

        // add first driver name
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // enter second driver name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("John Cena")

        // add second driver name
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify first driver name appears
        composeTestRule
            .onNodeWithText("Leon Kennedy")
            .assertExists()

        // verify second driver name appears
        composeTestRule
            .onNodeWithText("John Cena")
            .assertExists()

        // verify clear list
        composeTestRule
            .onNodeWithTag("resetDriverButton")
            .performClick()

        // verify first driver name is gone
        composeTestRule
            .onNodeWithText("Leon Kennedy")
            .assertDoesNotExist()

        // verify second driver name is gone
        composeTestRule
            .onNodeWithText("John Cena")
            .assertDoesNotExist()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()

    }

}
