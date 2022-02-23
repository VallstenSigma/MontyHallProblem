# Monty Hall Problem
Programming test for Tele2

# Prerequisite:
JDK 17

Maven

# How to run this application

From root application folder:

**mvn clean package**

Tests for Monty Hall Problem runs 100 times as the default.
You can change this by specifying the number of checks by typing:

**mvn test -DnumberOfChecks=225000**

If you only want to run one of the tests you can type:

**mvn test -Dtest=MontyhallTest#testWinProbabilityKeepBox**

or

**mvn test -Dtest=MontyhallTest#testWinProbabilityChangeBox**

You can add '-DnumberOfChecks=225000' to the end if you only want to test one of the tests and a specified number of times.

**mvn test -Dtest=MontyhallTest#testWinProbabilityKeepBox -DnumberOfChecks=225000**

or

**mvn test -Dtest=MontyhallTest#testWinProbabilityChangeBox -DnumberOfChecks=225000**
