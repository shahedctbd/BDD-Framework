 Feature: Validate TechFios Login Functionality

Background:
  Given User is on the TechFios login page

Scenario: User should be able to login with valid credentials
  When User enters username as "demo@techfios.com" 
  When User enters password as "abc123"
  When User clicks on signin button
  Then User should land on Dashboard page