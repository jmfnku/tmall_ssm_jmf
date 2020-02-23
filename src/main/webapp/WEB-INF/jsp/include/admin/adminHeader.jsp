<%--
  Created by IntelliJ IDEA.
  User: czwbig
  Date: 2018/10/31
  Time: 0:39
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>

    <script>
        function checkEmpty(id, name) {
            var value = $("#" + id).val();
            if (value.length == 0) {
                alert(name + "不能为空");
                $("#" + id)[0].focus();
                return false;
            }
            return true;
        }

        function checkNumber(id, name) {
            var value = $("#" + id).val();
            if (value.length == 0) {
                alert(name + "不能为空");
                $("#" + id)[0].focus();
                return false;
            }
            if (isNaN(value)) {
                alert(name + "必须是数字");
                $("#" + id)[0].focus();
                return false;
            }
            return true;
        }

        function checkInt(id, name) {
            var value = $("#" + id).val();
            if (value.length == 0) {
                alert(name + "不能为空");
                $("#" + id)[0].focus();
                return false;
            }
            if (parseInt(value) != value) {
                alert(name + "必须是整数");
                $("#" + id)[0].focus();
                return false;
            }
            return true;
        }

        $(function () {
            $("a").click(function () {
                var deleteLink = $(this).attr("deleteLink");
                console.log(deleteLink);
                if ("true" == deleteLink) {
                    var confirmDelete = confirm("确认要删除");
                    if (confirmDelete)
                        return true;
                    return false;

                }
            });
        })

    </script>
</head>
<body>
