# REST-API-CLIENT
*COMPANY* : CODTECH IT SOLUTIONS
*NAME* : SOUMYA RANJAN SAHOO
*INTERN ID* : CT06DH674
*DOMAIN* : JAVA
*DURATION* : 6 WEEKS
*MENTOR* : NEELA SANTHOSH
## Deliverable: Java Swing Weather Forecast Application
Objective
The aim of this Java program is to create a desktop application using Java Swing that fetches real-time weather data from an online REST API (OpenWeatherMap) via an HTTP request, parses the JSON response, and displays the weather information in a user-friendly graphical interface. This project demonstrates key skills such as API integration, HTTP communication, JSON parsing, and GUI development in Java.

Core Features
Graphical User Interface (GUI) – Built using Swing components (JFrame, JTextField, JButton, JTextArea).

HTTP GET Request Handling – Connects to the OpenWeatherMap API using HttpURLConnection.

JSON Parsing – Extracts temperature, humidity, and weather description from the JSON response.

User Input Handling – Takes a city name from the user and fetches weather data accordingly.

Data Conversion – Converts temperature from Kelvin to Celsius for better readability.

Program Workflow
GUI Initialization

A window (JFrame) is created with a city name input field, a fetch button, and a display area for weather information.

The layout uses FlowLayout for a simple component arrangement.

User Input

The user enters the name of a city in the JTextField.

Clicking the "Fetch Weather" button triggers an ActionListener.

HTTP Request to API

The program constructs a URL:

bash
Copy
Edit
https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apikey}
HttpURLConnection is used to send a GET request to the API endpoint.

Response Reading

The API returns a JSON-formatted string.

A BufferedReader reads the incoming stream line-by-line and concatenates it into a complete JSON string.

JSON Parsing

The JSON string is parsed into a JSONObject.

Nested objects (main for temperature and humidity, weather array for description) are accessed.

Temperature in Kelvin is converted to Celsius by subtracting 273.15.

Display Results

The extracted weather description, temperature, and humidity are formatted into a readable string.

The JTextArea updates with the weather report for the entered city.

Key Code Components
API Key – A unique authentication key (apikey) for accessing OpenWeatherMap.

fetchWeatherData() Method – Handles the HTTP request, response reading, and JSON parsing.

Exception Handling – Captures connection or parsing errors and informs the user.

Swing Components – Provide interactive elements for user input and output display.

Sample Output
If the user enters "London", the display area might show:

makefile
Copy
Edit
description: clear sky
temperature: 18.52 Celsius
humidity: 56%
(Values vary depending on real-time conditions.)

Advantages of This Approach
Interactive and Real-Time – Data updates instantly when a new city is entered.

Lightweight – No heavy frameworks required; only Swing and JSON parsing.

Cross-Platform – Runs on any machine with Java installed.

Reusable API Logic – The HTTP and JSON parsing method can be adapted for other APIs.

