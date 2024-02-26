# Universal Data Validator API

## Description 🌍

This RESTful web service, built with Spring Boot, offers a flexible data validation framework supporting multiple languages for easy integration with web and mobile apps. Initially focusing on electric vehicle charging station data, its adaptable architecture is suitable for various data types and domains.

## Features 🌟

- Validation of charging station data
- Multilingual support (English, French)
- RESTful API for integration

## Technologies 🛠

- Java 21
- Spring Boot 3.2.3
- Maven 4.0.0

## Installation 🔧

1. **Clone the repository to your local machine**:

```
https://github.com/vero-git-hub/validator-api.git
```

2. **Build the project with Maven**:

```
mvn clean install
```

3. **Start the service using Maven**:
```
mvn spring-boot:run
```

The API is now accessible at http://localhost:8080.

## Usage 📘

Send a POST request to /api/charging-stations with a JSON containing the data (for example, an electric vehicle charging station):

```
{
  "id": 1,
  "title": "Central Charging Station",
  "description": "Available 24/7",
  "address": "123 Main St, Anytown, AT 12345",
  "geoCoordinates": {
    "latitude": 50.1109,
    "longitude": 8.6821
  },
  "isPublic": true,
  "connectors": [
    {
      "id": 1,
      "type": "CCS",
      "maxPower": 150
    }
  ]
}
```

## Testing 🧪

For testing the API, use Postman or any other tool for HTTP requests. To check multilingual support, set the Accept-Language header.


## License 📄

© Copyright vero-git-hub, 2024. All rights reserved. Use, copying, modification and distribution of this work is possible only with the express permission of the author.