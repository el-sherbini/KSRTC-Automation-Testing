# KSRTC-Test-Automation
> This is a test automation task for _VOIS on [_KSRTC_](https://ksrtc.in/oprs-web/guest/home.do?h=1) website (Indian Transporation Company).

## Installation

Clone the repo:

```sh
git clone https://github.com/el-sherbini/KSRTC-Test-Automation.git
```

Install dependencies:

You need to install these dependencies from [_mvnrepository_](https://mvnrepository.com/):

```sh
Selenium
Testng
Webdrivermanager
```

## Test Scenario

1.	Open this website: “https://ksrtc.in/oprs-web/guest/home.do?h=1”
2.	Choose the following (from "CHIKKAMAGALURU" to "BENGALURU”) from the popular routes
3.	Choose the arrival date only (date picker)
4.	Click “Search for bus”
5.	Select a seat (I used **data-driven** for filling multiple seats)
6.	Choose the boarding point and dropping point
7.	Fill in the “Customer” and “Passenger” details
8.	Click on “make payment” and fill in all the fields without submitting the payment

## Skills

- Java
- Selenium
- TestNG
- POM (Page Object Model)
- DDT (Data-driven Testing)
