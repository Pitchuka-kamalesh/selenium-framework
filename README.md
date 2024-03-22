Sure, here's the revised README.md with the corrections:

```markdown
# Selenium Automation Framework

This repository contains a Selenium-based automation framework designed to facilitate automated testing of web applications. The framework is built using Java, TestNG, and Selenium WebDriver.

## Features

- **Modular Design**: The framework is structured with a modular design, making it easy to maintain and scale.
- **Page Object Model (POM)**: Implements the Page Object Model pattern for better code organization and readability.
- **Logging**: Utilizes Log4j for logging test execution information, making it easier to debug and analyze test results.
- **Reporting**: Generates comprehensive test reports using ExtentReports, providing insights into test execution status and details.
- **Configuration Management**: Utilizes properties files for configuration management, allowing easy modification of test parameters.
- **Test Data Management**: Supports external test data sources such as Excel files for efficient management and reuse of test data.
- **Screenshot Capture**: Automatically captures screenshots on test failure for enhanced error analysis.

## Prerequisites

Ensure you have the following software installed on your machine:

- Java Development Kit (JDK) version 8 or higher
- Apache Maven
- Chrome, Firefox, or Edge web browser

## Getting Started

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/Pitchuka-kamalesh/SeleniumAutomactionFrameWork.git
   ```

2. Navigate to the project directory:

   ```bash
   cd SeleniumAutomactionFrameWork
   ```

3. Configure the test parameters in the `config.properties` file located in the `config/` directory.

4. Place the `log4j2.xml` file in the `main/resources/` directory.

5. Build and install the framework using Maven:

   ```bash
   mvn clean install
   ```

6. After successful installation, you can add the framework as a dependency to another project by including the following dependency in the `pom.xml` file:

   ```xml
   <dependency>
     <groupId>com.seleniumframework.core</groupId>
     <artifactId>selenium-framework</artifactId>
     <version>1.1-snapshot</version>
   </dependency>
   ```

## Project Structure

The project follows the following structure:

```
SeleniumAutomactionFrameWork/
├── config/
│   └── config.properties
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── seleniumframework/
│   │               └── core/
│   │                   └── (core framework classes)
│   └── resources/
│       ├── log4j2.xml
│       └── (other resources)
├── pom.xml
└── README.md
```
---
