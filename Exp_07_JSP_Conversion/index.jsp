<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP Conversion Experiment</title>
    <style>
        * { box-sizing: border-box; }
        body {
            margin: 0; min-height: 100vh; display: grid; place-items: center;
            font-family: Arial, sans-serif; background: #f3f6fb; color: #172033;
        }
        .card {
            width: min(92%, 460px); padding: 30px; background: white;
            border-radius: 16px; box-shadow: 0 12px 35px rgba(20, 35, 70, .12);
        }
        h1 { margin-top: 0; font-size: 25px; }
        p { color: #596579; line-height: 1.5; }
        label { display: block; margin: 18px 0 7px; font-weight: 700; }
        input, select, button {
            width: 100%; padding: 12px; border-radius: 8px; font-size: 15px;
        }
        input, select { border: 1px solid #cbd3df; }
        button {
            margin-top: 22px; border: 0; color: white; background: #2459d3;
            font-weight: 700; cursor: pointer;
        }
        button:hover { background: #1746b5; }
        .note { font-size: 13px; }
    </style>
</head>
<body>
    <main class="card">
        <h1>JSP Conversion Experiment</h1>
        <p>Enter your details and submit the form. The next JSP page processes the request and displays the result.</p>

        <form action="result.jsp" method="post">
            <label for="name">Student name</label>
            <input id="name" name="name" type="text" maxlength="80" required>

            <label for="number">Number to convert</label>
            <input id="number" name="number" type="number" step="any" required>

            <label for="conversion">Choose conversion</label>
            <select id="conversion" name="conversion">
                <option value="cmToM">Centimeters to meters</option>
                <option value="mToCm">Meters to centimeters</option>
                <option value="cToF">Celsius to Fahrenheit</option>
                <option value="fToC">Fahrenheit to Celsius</option>
            </select>

            <button type="submit">Convert</button>
        </form>
        <p class="note">Advanced Java Lab · JSP form processing</p>
    </main>
</body>
</html>
