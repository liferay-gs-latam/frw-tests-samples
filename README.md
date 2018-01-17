[![Build Status](https://semaphoreci.com/api/v1/manoelcyreno/frw-tests-samples/branches/master/badge.svg)](https://semaphoreci.com/manoelcyreno/frw-tests-samples)

# Welcome to Tests Samples Framework.

These SAMPLES are based on Liferay GS Selenium Commons Framework, that code can be used for anyone of wanna make tests in Liferay using Selenium with BDD.

## Functional Tests (Without BDD Samples):

1. Login (positive and negative scenarios)

## Functional Tests (With BDD Samples):

1. Login (positive and negative scenarios) [/src/functionalTest/resources/Login.feature]
2. Add Portlet on screen (positive scenario) [/src/functionalTest/resources/Portlet.feature]
3. Create User on screen (positive scenario) [/src/functionalTest/resources/User.feature]
4. Create Page (positive scenario) [/src/functionalTest/resources/Page.feature]
5. Create some forms structure (positive scenario) [/src/functionalTest/resources/Forms.feature]

## Integration Samples (Integration Tests):

1. Create and Delete a Page By Rest API (positive and negative scenarios)

## Unit Samples (Unit Tests):

1. Notes from a student (positive and negative scenarios) [samples1]
2. Product Exchange (positive scenario) [samples2]
3. TestApp portlet that is a portlet how print some text on it own portlet. (positive and negative scenarios) [samples3]

## Java Script - Jasmine Unit Test (Java Script Unit Tests):

1. Test Suite for verify something
2. Test Suite for verify using specific methods

## How Use?
PS.: Your Bundle must be configured previously.

1. Download the "tests-sample-code.sh" file, into the Gradle project root folder.
2. Set the permission to execute on "tests-sample-code.sh" file (command: chmod +x tests-sample-code.sh)
3. Run the "tests-sample-code.sh" file (command: ./tests-sample-code.sh)
4. Configure your `SeleniumPropertyKeys.properties` and yours `drivers` according the [Framework Setup](https://bitbucket.org/gs-br/frw-tests-samples/wiki/Create%20the%20configuration%20aut%C3%B3mat%C3%ADcly)

### What this script will make?

1. Create one backup of the "src" and "modules" folder and "settings.gradle" file.
2. Create a temporary structure of sample code
3. Copy this structure to "modules" folder.
4. Delete the temporary structure.

## How Run after step above?

### Run by line command into the specific test folder.

1. `gradle performTest` into the functional-tests-withoutBDD folder.
2. `gradle cucumberTest` into the functional-tests folder.
3. `gradle integrationTest` into the integration-tests folder.
4. `gradle unitTest` into the unit-tests folder.
5. For Java Script Tests Using Jasmine:

5.1. Go to `/modules/tests/js-unit-tests/jasmine`

5.2 Run `npm i`

5.3. Perform `npm run test` command to run all Java Script tests.

### Run by line command into the root folder.

Configure your project according: (https://github.com/manoelcyreno/lfrgs-selenium-commons/wiki/Setup#how-to-use)

1. `./gradlew modules:tests:functional-tests-withoutBDD:performTest ` into the root folder.
2. `./gradlew modules:tests:functional-tests:cucumberTest` into the root folder.
3. `./gradlew modules:tests:integration-tests:integrationTest` into the root folder.
4. `./gradlew modules:tests:unit-tests:unitTest` into the root folder.
5. For Java Script Tests Using Jasmine you must go to the specific folder according topic above.

### Run by IDE.

Configure your project according: (https://github.com/manoelcyreno/lfrgs-selenium-commons/wiki/Setup#how-to-use)

1. `runAllTests.java` into the src/functionalTest/java/com/liferay/samples/functional/testsSuite folder.
2. `runTest.java` into the src/functionalTest/java/com/liferay/samples/functional/test folder.
3. `runTest.java` into the src/integrationTest/java/com/liferay/samples/integration/test folder.
4. `runTest.java` into the src/unitTest/java/com/liferay/samples(1, 2 or 3)/unit/test folder.

## Goal of wiki project

Centralize all information related to the development of automated tests of the project, to allow quick access to them.

See the Wiki page of the GS Selenium Commons Framework: https://github.com/manoelcyreno/lfrgs-selenium-commons/wiki
