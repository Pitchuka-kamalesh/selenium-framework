---

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

4. Place the `log4j2.xml` file in the `resources/` directory.

5. Run the tests using Maven:

   ```bash
   mvn clean test
   ```

6. After test execution, view the test reports located in the `test-output` directory.

## Javadoc

Access the Javadoc for the core framework classes [here](https://pitchuka-kamalesh.github.io/SeleniumAutomactionFrameWork/com/seleniumframework/core/package-summary.html).

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
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── seleniumframework/
│   │               └── tests/
│   │                   └── (test classes)
│   └── resources/
│       ├── log4j2.xml
│       └── (other resources)
├── pom.xml
└── README.md
```

## Contributing

Contributions are welcome! Feel free to submit bug reports, feature requests, or pull requests to improve the framework.

## License



---

Feel free to customize the content according to your specific project details and requirements.
