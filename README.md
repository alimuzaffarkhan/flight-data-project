# flight-data-project

This is a basic documentation to help you setup the project and run it. 

The best way to run this project is from within IntelliJ or by creating an assembly from command-line.

## Setup

### IntelliJ

In order to set this up on IntelliJ, follow the steps.
- Open the `build.sbt` file with the IntelliJ (File > Open) 
- IntelliJ will show a message to open it as a project, select yes.
- SBT will take some time to download all the libraries. Once its done, you should be all setup.

I have added runConfig for each of the jobs. IntelliJ should automatically load them. Just select the job you want and
press Run.

### SBT (untested)

In order to create assembly, you need sbt installed on your computer. 
Go to the project root, type `sbt assembly`. A jar file should be created for you in the target folder.
Run the job by using spark-submit to a spark instance.

## Other Important Information

- All the jobs read config from the `default.conf` file from within the resources folder. They are pretty straight forward.
- Modify the config as per your file locations.
- All the config in the config file, are required.
- All the jobs are inside the `jobs` folder. 
- All the jobs, are split into transformations and DataStore (read/write layer). 

 
 
 