# soapy-sample

A super basic SOAP service used as a back end to Apigee API proxy demos.

Requirements: Maven, Java 1.8+

Configured to be deployed to a Google App Engine project.  Supply the parameter `appengine.projectId`
on the maven command line to deploy to your project.

This project is intentionally in-memory persistence for easy data cleansing (just restart and you have fresh data).

Licensed under the Apache 2.0 license as found in the [LICENSE] file.

See [CONTRIBUTING.md] for details on how to contribute.

[CONTRIBUTING.md]: CONTRIBUTING.md
[LICENSE]: LICENSE

## Building

From the command line:

```
mvn clean install
```

## Deploying

From the command line, assuming you have a GAE project configured.

```
mvn clean install appengine:deploy -D appengine.projectId=<your-project-id>
```

## Sample deployment

http://soapy-sample.appspot.com/soapy
