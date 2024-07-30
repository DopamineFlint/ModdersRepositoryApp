package ru.dpflint.moddersrepository.utils.test

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class FetchDataTest {

    @Before
    fun setUp() {

    }

    @Test
    fun fetchDataFromNexusModsTest() = runTest {
        val testData = listOf<GameModel>(
            //GameModel(name = "Fallout 4", genre = "RPG", mods = 76),
            //GameModel(name = "Skyrim", genre = "RPG", mods = 69)
        )

        val mockApi = mockk<ModsApi>()

        coEvery { mockApi.getNexusGamesList() } returns Response.success(testData)

//        val repository = FetchData()
//
//        val result = repository.fetchDataFromNexusMods()

        //assertTrue(mockApi.getNexusGamesList().isSuccessful)
        assertEquals(testData, mockApi.getNexusGamesList().body())
    }

    @After
    fun tearDown() {

    }
}