import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def dataMap = CustomKeywords.'fileOperation.ReadDataFile.returnDataMap'('TC01', 'Custom-Binding')

WebUI.waitForElementVisible(findTestObject('Test Objects/Pages/Login Page/elHeader'), 60)

WebUI.verifyTextPresent('Log in to your account', false)

WebUI.setText(findTestObject('Test Objects/Pages/Login Page/elUsername'), dataMap['UserName'])

WebUI.click(findTestObject('Test Objects/Pages/Login Page/elContinue'))

WebUI.setText(findTestObject('Test Objects/Pages/Login Page/elEmail'), dataMap['UserName'])

WebUI.click(findTestObject('Test Objects/Pages/Login Page/elNext'))

WebUI.setText(findTestObject('Test Objects/Pages/Login Page/elPassword'), dataMap['Password'])

WebUI.click(findTestObject('Test Objects/Pages/Login Page/elSignin'))

WebUI.click(findTestObject('Test Objects/Pages/Login Page/elYes'))

WebUI.waitForElementVisible(findTestObject('Test Objects/Pages/Dashboard Page/elHeader'), 60)

WebUI.verifyTextPresent('System dashboard', false)

