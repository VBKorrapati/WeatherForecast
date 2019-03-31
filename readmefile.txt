Installations :
install java 8

Run details :

    open command prompt

    cd <path of the project where the .pom file is>

    mvn test -Dtest=features.RunFeatures -DfailfNoTests=false

    runs all the test scenarios


Test Results:

  Test results are stored in .html format which is stored in \\target\cucumber-reports\report.html

Improvements :

    Better report generations ( using JVM reporting )

    Group all Given , when , then , And - functions in seperate java file

    Group all the reusable functional in one java file , so that functions can be reused.

    Group all the global variable in common properties eg : Sleep , Url , paths ( so it is easier to change the URl depending of the environment tested ).

    Hook up java file can be added to launch the application before the start of the scenaerio and to close the application after each  scenario execution.

    Assert messages can be written better , to specify what went wrong.


Testing coverage

    Can cover more edge cases - but no enough time to coverage.