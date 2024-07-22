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
    # Course page
    driver.find_element(By.XPATH, "//p//a[@href='https://alchemy.hguy.co/lms/courses/social-media-marketing/']").click()
    coursePage = driver.title
    print("Contact Title is ", coursePage)
    assert coursePage == "Social Media Marketing – Alchemy LMS"

    #login

    driver.find_element(By.XPATH, "//a[text()='Login to Enroll']").click()
    driver.find_element(By.ID, "user_login").send_keys("root")
    driver.find_element(By.ID, "user_pass").send_keys("pa$$w0rd")
    driver.find_element(By.ID, "wp-submit").click()

    #content
    contentLink = driver.find_element(By.XPATH, "//div//a[@href='https://alchemy.hguy.co/lms/lessons/developing-strategy/']")
    contentLink.click()
    contentPageTitle = driver.title
    assert contentPageTitle == "Developing Strategy – Alchemy LMS"

    #status
    completionStatus = driver.find_element(By.XPATH, "//span[@class='ld-lesson-list-progress']")
    print("Completion Status: ", completionStatus.text)
    assert completionStatus.text == "100% COMPLETE"

    #logout
    driver.find_element(By.XPATH, "//span//img[contains(@class,'avatar-96')]").click()
    driver.find_element(By.XPATH, "//a[text()='Logout']").click()
