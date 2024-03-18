import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('TC Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('atc_button_product1'))

WebUI.click(findTestObject('atc_button_product2'))

name = WebUI.getText(findTestObject('name_product1'))

price = WebUI.getText(findTestObject('price_product1'))

desc = WebUI.getText(findTestObject('desc_product1'))

name2 = WebUI.getText(findTestObject('name_product2'))

price2 = WebUI.getText(findTestObject('price_product2'))

desc2 = WebUI.getText(findTestObject('desc_product2'))

WebUI.click(findTestObject('cart_logo'))

WebUI.click(findTestObject('button_Checkout'))

HashMap<String, Object> data = new HashMap<String, Object>()

data.put('product_name', name)
data.put('product_price', price)
data.put('product_desc', desc)

data.put('product_name2', name2)
data.put('product_price2', price2)
data.put('product_desc2', desc2)

return data

