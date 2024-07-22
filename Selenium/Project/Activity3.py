from selenium.webdriver.common.by import By
# Set up the Firefox Driver with WebDriverManager
from selenium.webdriver.firefox.webdriver import WebDriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with WebDriver(service=service) as driver:
    # Navigate to the URL
    driver.get("https://alchemy.hguy.co/lms")

    # Print the title of the page
    title = driver.title
    print("Page title is:", title)

    assert title == "Alchemy LMS – An LMS Application"

    infoBoxTitle = driver.find_element(By.XPATH, "//h3[text()=' Actionable Training ']")
    print("Info Box Title ", infoBoxTitle.text)
    assert infoBoxTitle.text == "Actionable Training"
