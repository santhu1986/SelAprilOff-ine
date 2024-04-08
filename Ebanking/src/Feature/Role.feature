Feature: RoleCreation

Scenario Outline: Verify Role Creation Functionality

Given User Should on Ranford Home Page

When User Enters un and Pwd click on Login

Then User Click on Role button

When User click on new role and enters "<RoleName>" and "<RoleType>"

Then User Close Application


Examples:

          | RoleName | RoleType |
          | Cashieraa | E |
          | Telleraa | E |
          | Gmanageraa | E |
          
          
          
          
          