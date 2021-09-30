### How to start application and run the tests
1. Clone repository.
2. Open SQL Script and run it (you can find it here src\sql\ciklum_test.sql).
3. Customize the content of the file local.properties to your own mysql connection.
4. To run the program you need to open terminal, change directory to ..\ciklum_test_task and write
> mvn clean install

> mvn exec:java

to view available commands.

5. To run tests you need write command
> mvn clean test

