<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
            <script type="text/javascript">
                $(function () {
                    $("#response").html("Response Values");

                    $("#button").click(function () {
                        var url = $("#url_post").val();

                        var JSONdata = {
                            id: document.getElementById('userID').value,
                            username: document.getElementById('userName').value,
                            image: document.getElementById('userFile').value
                        };

                        alert(JSON.stringify(JSONdata));

                        $.ajax({
                            type: 'post',
                            url: url,
                            data: JSON.stringify(JSONdata),
                            contentType: 'application/JSON',
                            dataType: 'JSON',
                            scriptCharset: 'utf-8',
                            success: function (data) {

                                // Success
                                alert("success");
                                $("#response").html(JSON.stringify(data));
                            },
                            error: function (data) {

                                // Error
                                alert("error");
                                $("#response").html(JSON.stringify(data));
                            }
                        });
                    })
                })
            </script>
            <script type="text/javascript">
                $(function () {
                    $("#response").html("Response Values");

                    $("#buttonUsers").click(function () {
                        var url = $("#url_get").val();

                        $.ajax({
                            type: 'get',
                            url: url,
                            data: '',
                            dataType: 'json',
                            scriptCharset: 'utf-8',
                            success: function (data) {

                                // Success
                                var table='<table>';
                                for (var i = 0; i < data.length; i++)
                                {
                                    table += '<tr><td>ID:'+data[i].id+'</td><td>User:'+data[i].username+'</td><td>Image:'+data[i].image+'</td></tr>';
                                }
                                table+='</table>';
                                $('#results').html('');
                                $('#results').append(table);
                                alert("success");
                            },
                            error: function (data) {

                                // Error
                                alert("error");
                                $("#response").html(data);
                            }
                        });
                    })
                })
            </script>
            <title>Usuarios Prueba Acid</title>
        </head>
        <body style="background-color: #3299ff">

            <form name='formulario' id='idFormulario' method='post' action='...' target='_self' enctype="multipart/form-data">
                <div>
                    <input type="hidden" id="url_post" name="url" size="100" value="http://localhost:8080/AcidLabsUsers/rest/user/create">
                    <input type="hidden" id="url_get" name="url" size="100" value="http://localhost:8080/AcidLabsUsers/rest/users">
                    <br><br>
                    <table border='0' style="width: 30%; font-family: sans-serif">
                        <tr>
                            <td>
                                ID user
                            </td>
                            <td>
                                <input type="text" id='userID' style="border-radius: 4px">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                User name
                            </td>
                            <td>
                                <input type="text" id='userName' style="border-radius: 4px">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Image
                            </td>
                            <td>
                                <input type='file' name='userFile' id='userFile' style="border-radius: 4px">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                &nbsp;
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <button id="button" type="button">Create user</button>
                            </td>
                            <td>
                                <button id="buttonUsers" type="button">Return users list</button>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <textarea id="response" cols=120 rows=10 disabled></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <div id="results">
                                    
                                </div>    
                            </td>
                        </tr>


                    </table>
                </div>
            </form>

        </body>

    </html>
