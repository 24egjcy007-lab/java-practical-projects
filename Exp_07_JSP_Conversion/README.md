# Experiment: JSP Conversion

## Aim
To demonstrate JavaServer Pages (JSP) form processing and value conversion using JSP declaration, scriptlet, and expression elements.

## Requirements
- JDK installed
- Apache Tomcat with JSP support (Tomcat 11 is suitable)
- VS Code or any text editor

## Files
- `index.jsp` — form for student name, input number, and conversion type.
- `result.jsp` — validates input, performs the selected conversion, and displays the result.

## Conversions included
- Centimeters to meters
- Meters to centimeters
- Celsius to Fahrenheit
- Fahrenheit to Celsius

## Run using Tomcat 11
1. Create a folder named `JSPConversion` inside Tomcat's `webapps` folder.
2. Copy `index.jsp` and `result.jsp` into that folder.
3. Start Tomcat.
4. Open this URL in your browser: `http://localhost:8080/JSPConversion/`
5. Enter values and click **Convert**.

For a standard Tomcat installation, `webapps` is inside the Tomcat installation directory. Do not open JSP files directly with the browser or VS Code Live Server; JSP requires a servlet container such as Tomcat.

## Example
For input `100` and conversion `Centimeters to meters`, the result is `1.0000`.

## Result
The JSP application accepts form data, performs the selected conversion, and displays the result.
