package GetOmnify;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import resources.base;
import pageObjects.SongStorePage;

public class SongStorePageTest extends base {

    @Test
    public void StaffLoginPage() throws IOException, InterruptedException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        SongStorePage songStorePage = new SongStorePage(driver);

      /*  Scenario: Play and retrieve recently played songs.
        TC-1: Play the song for a user and retrieve the recently played song.
        TC-2: Play additional song for the same user and retrieve the recently played song.
        Tc-3: Play the songs for multiple users and retrieve their recently played songs.  */
        
        // Ssteps To Login
        songStorePage.getUsernameInput().sendKeys(prop.getProperty("userName"));
        songStorePage.getPasswordInput().sendKeys(prop.getProperty("password"));
        songStorePage.getLoginButton().click();

        // Test Scenario: Play and retrieve recently played songs

        // Playing the song
        String[] songKeys = { "songKey1", "songKey2", "songKey3" };
        for (String songKey : songKeys) {
            String song = prop.getProperty(songKey);
            songStorePage.getSongSearchInput().sendKeys(song);
            songStorePage.getPlayButton().click();
        }

        // Retrieving the recently played songs
        String recentlyPlayedSongs = songStorePage.getRecentlyPlayedSongs().getText();

        // Validating the recently played songs
        String[] expectedSongs = { "S1", "S2", "S3" };
        Assert.assertTrue(validateRecentlyPlayedSongs(recentlyPlayedSongs, expectedSongs),
                "Validation of recently played songs failed");

        // Quitting the driver
        driver.quit();
    }

    private boolean validateRecentlyPlayedSongs(String actualSongs, String... expectedSongs) {
        for (String song : expectedSongs) {
            if (!actualSongs.contains(song)) {
                return false;
            }
        }
        return true;
    }
}
