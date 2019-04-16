Feature: check for BOI website
Scenario: Verification of valid credentials
		Given Google Home Page is Opened
		When user input is Bank of India and search
		Then Bank of India Page should open
		When Click on Internet Banking and Click on Personal
		Then Handle the newly opened window and redirect to the Login Page