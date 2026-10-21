<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Locale" %>
<%!
    // JSP declaration: reusable conversion method.
    private double convertValue(double value, String conversion) {
        switch (conversion) {
            case "cmToM": return value / 100.0;
            case "mToCm": return value * 100.0;
            case "cToF": return (value * 9.0 / 5.0) + 32.0;
            case "fToC": return (value - 32.0) * 5.0 / 9.0;
            default: throw new IllegalArgumentException("Unknown conversion type");
        }
    }

    private String conversionLabel(String conversion) {
        switch (conversion) {
            case "cmToM": return "Centimeters to meters";
            case "mToCm": return "Meters to centimeters";
            case "cToF": return "Celsius to Fahrenheit";
            case "fToC": return "Fahrenheit to Celsius";
            default: return "Unknown conversion";
        }
    }
%>
<%
    // JSP scriptlet: read and validate submitted form values.
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String numberText = request.getParameter("number");
    String conversion = request.getParameter("conversion");

    if (name == null || name.trim().isEmpty() || numberText == null || conversion == null) {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Please submit all required fields.");
        return;
    }

    double inputValue;
    double outputValue;
    try {
        inputValue = Double.parseDouble(numberText);
        outputValue = convertValue(inputValue, conversion);
    } catch (NumberFormatException | IllegalArgumentException ex) {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid number or conversion option.");
        return;
    }

    String safeName = name.replace("&", "&amp;").replace("<", "&lt;")
                          .replace(">", "&gt;").replace("\"", "&quot;")
                          .replace("'", "&#39;");
    String formattedInput = String.format(Locale.US, "%.4f", inputValue);
    String formattedOutput = String.format(Locale.US, "%.4f", outputValue);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Conversion Result</title>
    <style>
        * { box-sizing: border-box; }
        body { margin: 0; min-height: 100vh; display: grid; place-items: center;
               font-family: Arial, sans-serif; background: #f3f6fb; color: #172033; }
        .card { width: min(92%, 500px); padding: 30px; background: white;
                border-radius: 16px; box-shadow: 0 12px 35px rgba(20,35,70,.12); }
        .result { margin: 18px 0; padding: 18px; background: #edf4ff;
                  border-radius: 10px; font-size: 20px; overflow-wrap: anywhere; }
        a { display: inline-block; margin-top: 12px; color: #2459d3; font-weight: 700; }
        .label { color: #596579; font-size: 14px; }
    </style>
</head>
<body>
    <main class="card">
        <h1>Conversion Result</h1>
        <p>Hello, <strong><%= safeName %></strong>!</p>
        <p class="label">Selected conversion</p>
        <p><strong><%= conversionLabel(conversion) %></strong></p>
        <div class="result">
            <%= formattedInput %> → <strong><%= formattedOutput %></strong>
        </div>
        <p class="label">This page demonstrates JSP declarations, scriptlets and expressions.</p>
        <a href="index.jsp">← Convert another value</a>
    </main>
</body>
</html>
