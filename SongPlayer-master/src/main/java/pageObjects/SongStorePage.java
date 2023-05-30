package pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SongStorePage {
	public WebDriver driver; 
	public Properties prop;
	
     By usernameInput = By.id("username");
     By passwordInput = By.id("password");
     By loginButton = By.id("login-button");
     By songSearchInput = By.id("song-search-input");
     By playButton = By.id("play-button");
     By logoutButton = By.id("logout-button");
     By recentlyPlayedSongs = By.className("recently-played");


    public SongStorePage(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getUsernameInput() {
		return driver.findElement(usernameInput);
	}
	
	public WebElement getPasswordInput() {
		return driver.findElement(passwordInput);
	}
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
	
	public WebElement getSongSearchInput() {
		return driver.findElement(songSearchInput);
	}
	
	public WebElement getPlayButton() {
		return driver.findElement(playButton);
	}
	public WebElement getLogoutButton() {
		return driver.findElement(logoutButton);
	}
	public WebElement getRecentlyPlayedSongs() {
		return driver.findElement(recentlyPlayedSongs);
	}
}