# FRC 2016 Stronghold - Season Code
 
**The Metal Crusader's (Team 5293)**  
This repository contains the all the necessary code for the running the team's robot for the FRC 2015-2016 Season.

Instead of using Java, this project is written entirely in [**Kotlin**](https://kotlinlang.org/), a programming language that builds dircetly on top of Java. It allows for writing simplier, less error prone, and more consice code in comparison to straight up Java. A complete refernce to the Kotlin programming language is avaiable [here](https://kotlinlang.org/docs/reference/).

Since it's entirely compatible with Java, we can still seamlessly use WPILib and any other Java library.

## Getting Started

### Clone this repository
In order to get a copy of code in this project, you need to *clone* this repository. For guided instructions for how to do so, see [this wiki article]().

### Install IntelliJ
Instead of using Eclipse, it's strongly recommended that you use **IntelliJ** for working with this project. 

**Side note:** You still should still follow [the official instructions for how to setup Eclipse with Java][1] since IntelliJ does not support the FRC Plugins. (During development, in practice, the FRC Plugins for Eclipse are particuarly useful for reading log information streamed from the roboRIO.)

You can download and install the latest version of **IntelliJ** for free at https://www.jetbrains.com/idea/.

## Building and Deploying
This project uses Gradle for managing building the code and deploying it. (This is in comparison using Ant which the default FRC projects use.)

To compile and package the project to check for errors, in IntelliJ, select `Build` configuration. (This is the same as going to the *Gradle projects* panel and double-click on `FRC2016 > Tasks > build > jar` in the tree.)  

To deploy the project to the roboRIO, use the `

 [1]: https://wpilib.screenstepslive.com/s/4485/m/13503/l/145002-installing-eclipse-c-java
