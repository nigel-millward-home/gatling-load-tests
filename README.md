# Gatling-fundamentals
This framework is an introduction to Gatling, illustrating some of features of the Gatling performance test tool. For example, reading data from a csv file, checking response from a body



### Basic Test

Each test has a similar format:

```
// 1 Setup httpConf
  val httpConf = http
    .baseURL("http://localhost:8080/app/")
    .header("Accept", "application/json")
    
// 2 Creat scenario Definition
   val scn = scenario("My First Test")
    .exec(http("Get All Games")
    .get("videogames"))
    
// 3 Load Scenario
     setUp(
        scn.inject(atOnceUsers(1))
      ).protocols(httpConf)```
```



See further details with the gatling cheat sheet:
https://gatling.io/docs/current/cheat-sheet

### Test Runner
Run a test by setting the required test class in the Gatling Runner.


### Test Results
Test results are listed in results folder, and opening index.html
