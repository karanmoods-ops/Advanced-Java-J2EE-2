 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Form</title>

<script>
function validateForm() {
    let roll = document.forms["studentForm"]["rollno"].value;
    let name = document.forms["studentForm"]["name"].value;
    let subs = ["sub1","sub2","sub3","sub4","sub5"];

    if (roll === "" || isNaN(roll)) {
        alert("Enter valid Roll Number");
        return false;
    }

    if (name === "") {
        alert("Enter Student Name");
        return false;
    }

    for (let i = 0; i < subs.length; i++) {
        let mark = document.forms["studentForm"][subs[i]].value;
        if (mark === "" || isNaN(mark) || mark < 0 || mark > 100) {
            alert("Enter valid marks (0-100)");
            return false;
        }
    }
    return true;
}
</script>

</head>

<body>
<h2>Student Marks Entry</h2>

<form name="studentForm" action="ResultServlet" method="post" onsubmit="return validateForm()">

Roll No: <input type="text" name="rollno"><br><br>
Name: <input type="text" name="name"><br><br>

Sub1: <input type="text" name="sub1"><br><br>
Sub2: <input type="text" name="sub2"><br><br>
Sub3: <input type="text" name="sub3"><br><br>
Sub4: <input type="text" name="sub4"><br><br>
Sub5: <input type="text" name="sub5"><br><br>

<input type="submit" value="Submit">

</form>

</body>
</html>