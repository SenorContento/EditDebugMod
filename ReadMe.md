# https://mcforge.readthedocs.io/en/latest/gettingstarted/

To Build Mod
./gradlew build

To Run Under Client
./gradlew runClient

To Run Under Server
./gradlew runServer

To Setup Workspace for Eclipse
./gradlew setupDevWorkspace
./gradlew eclipse

When in doubt try,
./gradlew clean && ./gradlew setupDevWorkspace && ./gradlew eclipse && ./gradlew build