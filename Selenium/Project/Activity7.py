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
    driver.find_element(By.XPATH, "//a[text()='My Account']").click()
    myAccountPageTitle = driver.title
    print("My Account Page Title is ", myAccountPageTitle)
    assert myAccountPageTitle == "My Account – Alchemy LMS"

    #All Course page
    courseList = driver.find_elements(By.XPATH, "//div[@class='ld_course_grid col-sm-8 col-md-4 ']")
    courseListCount = len(courseList)
    print("Course List Count = ", courseListCount)


