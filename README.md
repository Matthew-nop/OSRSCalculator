## OSRSCalculator
OSRSCalculator is an efficiency focused calculator written in Java for OldSchool RuneScape. <br>
Prices are fetched from the [OSRS Wiki](https://oldschool.runescape.wiki/), with their 
[Real-time Prices API](https://oldschool.runescape.wiki/w/RuneScape:Real-time_Prices).

## Latest Release
The latest version can be found in the [releases](https://github.com/Matthew-nop/OSRSCalculator/releases) page. <br>
This project is still in a very early beta, with many features/skills not implemented yet and many bugs left to be ironed out.

## Features
 - Real-time prices, fetched automatically from the [OSRS Wiki](https://oldschool.runescape.wiki/)
 - Sort by required level, GP/XP, profit/action, or alphabetically by name
 - Compare training options that all utilise the same method 
 - Flags for special effects such as the amulet of chemistry
 - Cross-platform and extremely portable (thanks to Java)
 - Manually enter prices for recipes so you can be certain it's efficient (in a future release)

![Calculator Screenshot](./doc/resources/herblore_screenshot_scaled.png)


## Requirements
You will need to have Java (JDK 11 or newer) installed on your machine to run the .jar file or build the project. <br>
You will need maven if you want to build the project.

## Building
To build a .jar file, in the project root directory run the following commands:
```
mvn compiler:compile 
mvn assembly:single
```
The output file jar be located at `out/OSRSCalculator-v*.*-jar-with-dependencies.jar`

## File Layout
 - src/main/java
   - source directory
 - src/main/resources
   - resources directory
 - doc/
   - documentation directory
 - images/
   - contains all images used in the calculator in original size
