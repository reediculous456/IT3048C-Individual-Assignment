package app.plantdiary.individualassignment3048q

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.plantdiary.individualassignment3048q.ui.main.MainViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CountryUnitTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    lateinit var mvm: MainViewModel

    @Before
    fun populateCountries() {
        mvm = MainViewModel()

    }

    @Test
    fun countryDTO_maintainsState() {
        var country = Country("NZ", "New Zealand")
        assertTrue(country.code.equals("NZ") )
        assertTrue(country.name.equals("New Zealand"))
    }

    @Test
    fun countryDTO_isPopulated() {
        givenViewModelIsInitialized()
        whenJSONDataAreReadAndParsed()
        thenTheCollectionSizeShouldBeGreaterThanZero()
    }

    private fun givenViewModelIsInitialized() {

    }

    private fun whenJSONDataAreReadAndParsed() {
        mvm.fetchCountries()
    }

    private fun thenTheCollectionSizeShouldBeGreaterThanZero() {
        mvm.countries.observeForever{
            assertNotNull(it)
            assertTrue(it.size > 0)
        }
    }


    @Test
    fun countryDTO_containsBelize() {
        givenViewModelIsInitialized()
        whenJSONDataAreReadAndParsed()
        thenResultsShouldContainBelize()
    }

    private fun thenResultsShouldContainBelize() {
        var containsBelize:Boolean = false
        mvm.countries.observeForever {
            it.forEach {
                if (it.name.equals("Belize")) {
                    containsBelize = true
                }
            }
            assertTrue(containsBelize)
        }    }
}
