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
    driver.find_element(By.XPATH, "//a[text()='Contact']").click()
    contactPage = driver.title
    print("Contact Title is ", contactPage)
    assert contactPage == "Contact – Alchemy LMS"

    #Contact us page
    driver.find_element(By.ID, "wpforms-8-field_0").send_keys("Mahesh")
    driver.find_element(By.ID, "wpforms-8-field_1").send_keys("mass@abc.com")
    driver.find_element(By.ID, "wpforms-8-field_3").send_keys("login issue")
    driver.find_element(By.ID, "wpforms-8-field_2").send_keys("Unable to login")
    driver.find_element(By.ID, "wpforms-submit-8").click()

    responseMessage = driver.find_element(By.XPATH, "//p[text()='Thanks for contacting us! We will be in touch with you shortly.']")
    print("Response Message : ", responseMessage.text)




