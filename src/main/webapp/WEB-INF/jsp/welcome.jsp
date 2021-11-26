<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
    <title>Candidate Registration Portal</title>
</head>

<body>
<p3>Candidate Registration Form</p3>
<p> </p>
<p> </p>
<form:form id="UploadServlet" action="UploadServlet" modelAttribute="candidateInfo" method = "post"
      enctype = "multipart/form-data">

    <label for="fname">Candidate Name     :</label>
    <input type="text" id="fname" name="name"><br>
    <p> </p>
    <label for="mnum">Mobile Number       :</label>
    <input type="text" id="mnum" name="mobNum"><br>
    <p> </p>
    <label for="jdate">Joining Date       :</label>
    <input type="text" id="jdate" name="joiningDate"><br>
    <p> </p>

    <%--<h3>File Upload:</h3>--%>
    PLease upload your offer letter       :
    <input type = "file" name = "offerLetter" size = "50" />
    <br />

    <p> </p>

    PLease upload your PAN Card          :
    <input type = "file" name = "pan" size = "50" />
    <br />
    <p> </p>
    <input type = "submit" value = "Submit Form" />

</form:form>
</body>

</html>
