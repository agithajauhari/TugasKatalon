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

HashMap<String,Object> data = WebUI.callTestCase(findTestCase('TC Checkout Step 1, 2 Product'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/name_checkout1'), data.get("product_name"))
WebUI.verifyElementText(findTestObject('Object Repository/price_checkout1'), data.get("product_price"))
WebUI.verifyElementText(findTestObject('Object Repository/desc_checkout1'), data.get("product_desc"))
WebUI.verifyElementText(findTestObject('Object Repository/name_checkout2'), data.get("product_name2"))
WebUI.verifyElementText(findTestObject('Object Repository/price_checkout2'), data.get("product_price2"))
WebUI.verifyElementText(findTestObject('Object Repository/desc_checkout2'), data.get("product_desc2"))

def actualPrice1 = WebUI.getText(findTestObject('Object Repository/price_checkout1'))
def actualPrice2 = WebUI.getText(findTestObject('Object Repository/price_checkout2'))
def total = WebUI.getText(findTestObject('Object Repository/item_total'))
def tax = WebUI.getText(findTestObject('Object Repository/tax'))
def total_keseluruhan = WebUI.getText(findTestObject('Object Repository/total'))

def pecah1 = actualPrice1.replace('$', '').replace('.', '')
def harga_total1 = Integer.valueOf(pecah1)

def pecah2 = actualPrice2.replace('$', '').replace('.', '')
def harga_total2 = Integer.valueOf(pecah2)

def totalin = total.replaceAll("\\D", "")
def expectTotal = Integer.valueOf(totalin)

def actualTotal = harga_total1 + harga_total2

WebUI.verifyEqual(expectTotal, actualTotal)

def taxin = tax.replaceAll("\\D", "")
def expectTax = Integer.valueOf(taxin)

def totalSEMUA = total_keseluruhan.replaceAll("\\D", "")
def selesai_cihuy = Integer.valueOf(totalSEMUA)

def AllTotal = expectTax + actualTotal
WebUI.verifyEqual(selesai_cihuy, AllTotal)


