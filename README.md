# Multi-threaded linked list #

An example project for demonstration of the multi-threaded implementation
of the linked list, accessible via REST service.

It's implemented in *Scala* (list part) and *Java* (REST part), with help
of [Swagger](http://swagger.io/) and [Gradle](https://gradle.org/).

## How to run the example

1. Clone the repository.
1. Run the command `gradle jettyRun` or `gradle tomcatRun`.
1. Open the *SoapUI* project `orcl-list-soapui-project.xml` located in `src/test/soapui`.
1. Run *SoapUI* test suite `Multi-thread list TestSuite`.
1. See the log messages in the console.
1. Browse the source code.
