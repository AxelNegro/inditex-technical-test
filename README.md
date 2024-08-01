# inditex-technical-test
Repository made for the Inditex technical test.

## Software version used
- Java 17
- Maven 3.9.5

## How to run tests and start
After cloning the repository, you should:
1. Execute maven sync.
2. Enable Lombok Annotation Processing.
3. Execute the following command `mvn clean install`.

With this, maven will generate all the necessary sources and execute the tests.
Once finished executing the tests, the project it's ready to run.

To run it, just start it from the main class `TechnicalTestApplication.java`.

## Troubleshooting

_The IDE throw errors when cloning the project_
- Ignore them, it's only the first time opening the project.

_I cannot run the project because Java cannot find the auto generated classes_
- If using:
	- IntelliJ IDEA: Go to File > Invalidate Caches > Invalidate and Restart.
	- Eclipse: Window > Preferences > Remote Systems > File Cache > Clear Cached Files > Apply > OK.
