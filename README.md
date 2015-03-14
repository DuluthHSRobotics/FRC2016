# Duluth Robotics - FRC 2015 Season Code

This repository contains the source code for **The Metal Crusader's (Team 5293)** FRC 2014-2015 Season competition code. The code is implemented using features in Java 8 on the RoboRIO and is designed to be as modular and organized as possible for future reuse (but we'll see how that plays out).

# Getting Started

## 1. Setup your development environment
To get started with the code in the repository, first you need to follow the setup instructions presented on the WPILib website detailing how to setup your development environment.

*(Additionally its recommended that you install the C++ tools for Eclipse anyways so that you don't have to worry about setting them up in the future if the need for them arises, though if you really want to you can always install them later on.)*

You will want to follow the instructions presented in these tutorials:
 * [Installing Eclipse](https://wpilib.screenstepslive.com/s/4485/m/13809/l/145002-installing-eclipse-c-java)
 * [Installing FRC 2015 Update Suite](https://wpilib.screenstepslive.com/s/4485/m/13809/l/144150-installing-the-frc-2015-update-suite-all-languages)

After doing so you should have:
 * Installed Java 8
 * Downloaded and Configured Eclipse
 * Installed the Java and C++ tooling plugins for Eclipse
 * Installed the FRC Plugins for Eclipse
 * Installed the FRC 2015 Update Suite

## 2. Setup git

You will want to install a git client on to access the code on your computer. **git** is a version control system, which in other words, is what manages and keeps track of changes between each revision of the code essentially. There a several GUI options when it comes making git easier to manage.

So starting out, I recommend [Github for Windows](https://windows.github.com/) and [Github for Mac](https://mac.github.com/) as they are fairly simplistic to use.

> Josh Side Note: Personally, I prefer to use [SourceTree for Windows or Mac](http://www.sourcetreeapp.com/) as its a bit more powerful to use managing git. Of course, there are plenety of options when it comes to [git GUI clients](http://git-scm.com/downloads/guis) instead of using git from the command line straight up.

Once you have installed your git client of choice, you need to then **clone** the repository from GitHub to your local computer so you have your own copy to work with. You will want to have the destination folder be a subdirectory in your *Eclipse Workspace* (since we are going to want to import the code in Eclipse next). So it should look like `{your_workspace}\FRC2015\` where `{your_workspace}` is the path to your Eclipse workspace. (Of course the name of the subdirectory does not really matter.)

So, after doing so, you should have:
 * Choose your git client of choice
 * Installed said client
 * Cloned the repostory into your Eclipse Workspace

## 3. Configure Eclipse
 1. Next, open up your copy of Eclipse in your workspace you created/choose in *Section 1*.
 2. Close the Welcome Screen
 3. We are now going to import the project in to your workspace. To do so:
 4. Right-click in Package Explorer and go to `Import...`  
    ![Importing Eclipse Project](https://i.imgur.com/qZ6gUBw.png)
 5. Select `Existing Projects into Workspace`
    ![Existing Projects into Workspace](http://imgur.com/lhVneBb.png)
 6. Click `Next >`
 7. Click `Browse...` to browse for the current workspace which should alread contain your local copy of the repository.  
    ![Browse for Project](http://i.imgur.com/ChFAwBe.png)
 8. You should now have a single project that is now listed. This should be the code you just cloned.
 9. Click `Finish`
 10. Now Eclipse is going to be complaining about two "unbound classpath varaibles". In other words, what Eclipse is trying to tell you is that it has variables that are suposed to be pointing to a path on your system but you have yet to define where exactly that is. We are now going to fix this.  
    ![Eclipse complaining](http://i.imgur.com/iZx3oh6.png)  
      1. To fix this problem, on the menu go to `Menu » Window » Preferences » Java » Build Path » Classpath Variables`
      2. Click `New...`
      3. You are then going to need to add a total of 4 classpath variables with each of their associated paths. These paths for on Windows where `{username}` is your username for your user directory:  
        
      | Name          | Path          |
      | ------------- | ------------- |
      | `wpilib`      | `C:/Users/{username}/wpilib/java/current/lib/WPILib.jar` |
      | `wpilib.sources` | `C:/Users/{username}/wpilib/java/current/lib/WPILib-sources.jar` |
      | `networktables` | `C:/Users/{username}/wpilib/java/current/lib/NetworkTables.jar` |
      | `networktables.sources` | `C:/Users/{username}/wpilib/java/current/lib/NetworkTables-sources.jar` |
 11. Eclipse will ask you if you want to rebuild the project. Select `Yes`.
 12. All the errors should be resolved now.
 
**Conguradulations!** You are ready to start to deploying to the robot (assuming the RoboRIO is already properly configured)!

## Deploying

To deploy your code to the robot so you can test it out, follow [this tutorial provided by WPILib](https://wpilib.screenstepslive.com/s/4485/m/13809/l/242586-building-and-downloading-a-robot-project-to-the-roborio).
