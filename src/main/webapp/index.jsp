<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Student Management</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h2>Student Management</h2>
<form id="studentForm">
  ID: <input type="text" id="id" name="id"><br>
  Name: <input type="text" id="name" name="name"><br>
  Sex: <input type="text" id="sex" name="sex"><br>
  <button type="button" id="insert">Insert</button>
  <button type="button" id="update">Update</button>
  <button type="button" id="delete">Delete</button>
  <button type="button" id="findAll">Find All</button>
</form>

<script>
  $(document).ready(function() {
    $("#insert").click(function() {
      var student = {
        id: $("#id").val(),
        name: $("#name").val(),
        sex: $("#sex").val()
      };
      $.ajax({
        url: "insert",
        type: "POST",
        data: JSON.stringify(student),
        contentType: "application/json",
        success: function(data) {
          alert("Data inserted: " + data);
        }
      });
    });

    $("#update").click(function() {
      var student = {
        id: $("#id").val(),
        name: $("#name").val(),
        sex: $("#sex").val()
      };
      $.ajax({
        url: "update",
        type: "POST",
        data: JSON.stringify(student),
        contentType: "application/json",
        success: function(data) {
          alert("Data updated: " + data);
        }
      });
    });

    $("#delete").click(function() {
      var student = {
        id: $("#id").val(),
        name: $("#name").val(),
        sex: $("#sex").val()
      };
      $.ajax({
        url: "delete",
        type: "POST",
        data: JSON.stringify(student),
        contentType: "application/json",
        success: function(data) {
          alert("Data deleted: " + data);
        }
      });
    });

    $("#findAll").click(function() {
      $.ajax({
        url: "findAll",
        type: "GET",
        success: function(data) {
          alert("Data found: " + data);
        }
      });
    });
  });
</script>
</body>
</html>