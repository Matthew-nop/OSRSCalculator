## OSRSCalculator
OSRSCalculator is an efficiency focused calculator for OldSchool RuneScape, written in Java. <br>
Prices are fetched in real-time from the [OSRS Wiki](https://oldschool.runescape.wiki/), with their 
[Real-time Prices API](https://oldschool.runescape.wiki/w/RuneScape:Real-time_Prices).

## Latest Release
The latest version can be found in the [releases](https://github.com/Matthew-nop/OSRSCalculator/releases) page. <br>
This project is still in a very early beta, with many features/skills not implemented yet and many bugs left to be ironed out.

## Requirements
You will need to have Java (JDK 11 or newer) installed on your machine to run the .jar file or build the project. <br>
You will need maven if you want to build the project.

## Building
To build a .jar file, run the following commands in the project root directory. 
```
mvn compiler:compile 
mvn assembly:single
```  
The output file jar be located at `out/OSRSCalculator-*.*-jar-with-dependencies.jar`
