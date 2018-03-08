Feature: Calculator

Scenario: Sum two numbers
Given i'am in Calculator Screen
When sum two numbers
Then show the result of sum

Scenario: Subtract two numbers
Given i'am in Calculator Screen
When subtract two numbers
Then show the result of subtraction

Scenario: Divide two numbers
Given i'am in Calculator Screen
When divide two numbers
Then show the result of division

Scenario: Multiply two numbers
Given i'am in Calculator Screen
When multiply two numbers
Then show the result of multiplication

Scenario: Dont divide by zero
Given i'am in Calculator Screen
When divide by zero
Then show the message cannot divide by zero!