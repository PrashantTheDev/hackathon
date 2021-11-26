<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
Welcome
    <title>File Uploading Form</title>
</head>

<body>
<p3>Hello</p3>
<h3>File Upload:</h3>
Select a file to upload: <br />
<form action = "UploadServlet" method = "post"
      enctype = "multipart/form-data">
    <input type = "file" name = "file" size = "50" />
    <br />
    <input type = "submit" value = "Upload File" />
</form>
</body>

</html>
