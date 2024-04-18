Feature: To check the functionality of Train module in Makemytrip web application

 Background:
   Given User is on Homepage
    
    
  @SearchTrain
  Scenario Outline: To validate the Book Train Ticket functionality of Trains option .
   
    When User clicks on the Train option
    And User enters the "<fromstation>","<tostation>","<traveldate>" and "<class>"
    And click on search option
    Then list of train appears
    
 Examples:
    
|fromstation|tostation|traveldate|class|
|Mumbai| SBC| 24,April 2024 | Third AC |

  @FilterTrain
  
  Scenario: To check AC filter is applied
  
  When User is on the searchpage
  And click on AC filter
  Then AC trains are displayed 

  @ValidPNR
 
  Scenario: to check the PNR status of my train ticket
  
  When user to click the train option from the homepage 
  And  User should click on check pnr status 
  And User should enter the valid pnr number
  |4364810556|
  And user should click on the check status button
  Then user should see the current status of booked tickets
 
 
  @InvalidPNR
 
  Scenario: to check the PNR status with in invalid PNR number
  
  When user to be in the train option of the homepage 
  And  User will click on check pnr status 
  And User should enter the invalid pnr number
  |4364816755|
  And user will click on the check status button
  Then user will see PNR is either not generated
  
 
 
 @LiveStatus
 
  Scenario: to check the live status of train
 
  When user in on the train page
  And user should click on live train status
  And user should enter the train number and date of the journey
  |11301| 
  And user should be able to click on check status to the live status of the train
  Then user should be able see the live status of particular train 