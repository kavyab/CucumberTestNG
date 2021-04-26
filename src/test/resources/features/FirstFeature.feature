Feature: Registration and Login
This feature includes the following validation of Registration
1)Register with Valid User details 
2)Register with missing data
3)Register with invalid emailid
4)Register with existing user

Background: User Navigates to Registration Page on Chrome Browser
Given User is on Home Page

@positive_flow
Scenario: Successful Registration with valid User Details
When User Clicks on SignUp link
And Navigates to Registration page
And User enters firstname
And User enters lastname
And User enters emailid
And User enters username
And User enters password
And User enters confirmpwd 
And User clicks on Register Button
Then Success Message 'Your  personal settings have been registered' is displayed 

@invalid_flow
Scenario: Registration with missing data
When User Clicks on SignUp link
And Navigates to Registration page
And User enters firstname
And User enters lastname
And User enters emailid
And User enters password
And User enters confirmpwd 
And User clicks on Register Button
Then Error Message 'Required field' is displayed

@invalid_flow
Scenario: Registration with invalid emailid
When User Clicks on SignUp link
And Navigates to Registration page
And User enters firstname
And User enters lastname
And User enters invalid emailid
And User enters username
And User enters password
And User enters confirmpwd
And User clicks on Register Button
Then Email id Error Message 'The email address is not complete or contains some invalid characters' is displayed

@invalid_flow
Scenario: Registration with existing username
When User Clicks on SignUp link
And Navigates to Registration page
And User enters firstname
And User enters lastname
And User enters emailid
And User enters existing username
And User enters password
And User enters confirmpwd
And User clicks on Register Button
Then login already in use Error  'This login is already in use' is displayed

@positive_flow
Scenario: Login with Valid user credentials
When User enters username in the Home page
And User enters password in the Home page
And User clicks on Login Button
Then User should be logged in successfully

@invalid_flow
Scenario: Login with invalid password
When User enters username in the Home page
And User enters invalid password in the Home page
And User clicks on Login Button
Then Error message 'Login failed - incorrect login or password.' should be displayed

@invalid_flow
Scenario: Login with invalid username
When User enters invalid username in the Home page
And User enters password in the Home page
And User clicks on Login Button
Then Error message 'Login failed - incorrect login or password.' should be displayed

@invalid_flow
Scenario: Login with invalid username and password
When User enters invalid username in the Home page
And User enters invalid password in the Home page
And User clicks on Login Button
Then Error message 'Login failed - incorrect login or password.' should be displayed

@positive_flow
Scenario: Loggedin User emailid validation
When User enters username in the Home page
And User enters password in the Home page
And User clicks on Login Button
And User clicks on profile dropdown button
Then Registered emailid of that user should be displayed

@positive_flow
Scenario: Composing Email with valid input
When User enters username in the Home page
And User enters password in the Home page
And User clicks on Login Button
And User is on Home page
And User clicks on Compose link
And User enters Sendto address
And User enters subject
#And User enters Message
And User clicks on Send message button
Then Success message 'The message has been sent to' should be displayed

@invalid_flow
Scenario: Composing Email without subject
When User enters username in the Home page
And User enters password in the Home page
And User clicks on Login Button
And User is on Home page
And User clicks on Compose link
And User enters Sendto address
#And User enters Message
And User clicks on Send message button
Then Error message for missing subject 'There was an error while trying to send the message.' should be displayed

@invalid_flow
Scenario: Composing Email without sendTo address
When User enters username in the Home page
And User enters password in the Home page
And User clicks on Login Button
And User is on Home page
And User clicks on Compose link
And User enters subject
#And User enters Message
And User clicks on Send message button
Then Error message for missing sendTo address 'Required field' should be displayed

@positive_flow
Scenario: Log out
When User enters username in the Home page
And User enters password in the Home page
And User clicks on Login Button
And User clicks on profile dropdown button
And User clicks on Logout Button
Then User should be logged out successfully



