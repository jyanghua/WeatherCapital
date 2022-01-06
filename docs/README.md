# Project - Weather Capital

**Weather Capital** is a simple android app that allows a user to view the weather forecast of the capital cities of all country.

## Set-up:
Create a `keys.properties` file on the root directory. This will be used to include the keys/secrets needed:

```
    # Weather API keys
    API_WEATHER_KEY = "add the key here!!!"
```

## Features:
- Uses multi-modular MVVM
- First try at using Jetpack Compose and Navigation
- Kotlin DSL for Gradle
- Dependency injection with Hilt and Jetpack
- Coroutines

## What could have gone better:
- Architecture/organization regarding presentation layer could improve drastically as I get more used to Compose.
- Tried using navigation with NavController and not rely on .xml, but didn't work out.
- Made an attempt on removing fragments as it's not required anymore and by using Jetpack Navigation and Compose, it can all be build out based on Components or View Models.
- Tried to add loading bar/animation, but ran out of time.
- Attempting Jetpack compose animations.