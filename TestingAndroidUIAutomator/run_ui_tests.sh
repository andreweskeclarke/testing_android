cd /Users/Thoughtworker/Programming/android/workspace/testing_android/TestingAndroidUIAutomator
ant build
adb push bin/TestingAndroidUIAutomator.jar /data/local/tmp
adb shell uiautomator runtest TestingAndroidUIAutomator.jar -c com.aeclarke.testingandroid.MainActivityTest
