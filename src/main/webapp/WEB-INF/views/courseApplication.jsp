<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <%@ include file="Resource.jsp" %>
    <title>选课系统</title>
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <%@include file="Head.jsp" %>
    <div class="main-container">
        <div class="sidebar">
            <nav class="sidebar-nav">
                <li class="nav-title">导航</li>

                <li class="nav-item">
                    <a href="/user/ToIndex" class="nav-link active">
                        <i class="icon icon-speedometer"></i> 主页
                    </a>
                </li>

                <li class="nav-item nav-dropdown">
                    <a href="#" class="nav-link nav-dropdown-toggle">
                        <i class="icon icon-target"></i> 课程管理 <i class="fa fa-caret-left"></i>
                    </a>

                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a href="/ToCourseApplication" class="nav-link">
                                <i class="icon icon-target"></i> 课程申报
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/ToTeacherCourseInfo" class="nav-link">
                                <i class="icon icon-target"></i> 课程情况
                            </a>
                        </li>

                    </ul>
                </li>

                </li>

                <ul class="nav">
                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> 成绩管理 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="/ToGradeEnter" class="nav-link">
                                    <i class="icon icon-target"></i> 成绩录入
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="/ToGradeModificationReview" class="nav-link">
                                    <i class="icon icon-target"></i> 成绩修改
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="/ToTeacherCourseInfo" class="nav-link">
                                    <i class="icon icon-target"></i> 修改情况
                                </a>
                            </li>

                        </ul>
                    </li>

                    <li class="nav-item">
                        <a href="/ToInfo" class="nav-link">
                            <i class="icon icon-energy"></i> 查询信息
                        </a>
                    </li>
                    <li class="nav-title">更多</li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-umbrella"></i> 其他 <i class="fa fa-caret-left"></i>
                        </a>

                    </li>
                </ul>
            </nav>
        </div>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-7">
                        <div class="card">
                            <div class="card-header bg-light">
                                课程申报
                            </div>
                            <div class="card-body">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="courseApplicationName">课程名称</label>
                                        <input id="courseApplicationName" class="form-control">
                                    </div>
                                </div>


                                <div class="col-md-2">
                                    <div class="form-group">
                                        <label for="type-select">课程类型</label>
                                        <select id="type-select" class="form-control">
                                            <option>线上</option>
                                            <option>网课</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-md-1"></div>

                                <div class="col-md-10">
                                    <div class="form-group">
                                        <label for="introduce">申请理由</label>
                                        <input id="introduce" class="form-control">
                                    </div>
                                </div>


                                <div class="my-4">
                                    <button id="submit" class="btn btn-primary">提交</button>
                                </div>
                            </div>
                        </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header bg-light">
                                课程情况
                            </div>
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>课程名称</th>
                                        <th>课程类型</th>
                                        <th>审核情况</th>
                                    </tr>
                                    </thead>
                                    <tbody id="courseTbody">
                                    <c:forEach items="${courseVoList}" var="list" varStatus="vs">
                                        <tr>
                                            <td>${list.courseName}</td>
                                            <td>${list.type}</td>
                                            <c:if test="${list.status == 0}">
                                                <td>待审核</td>
                                            </c:if>
                                            <c:if test="${list.status == 1}">
                                                <td>审核通过</td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="JSResource.jsp" %>

<script>
    $('#submit').click(function () {
            // 申请信息
            var courseApplicationName = $("#courseApplicationName").val().replace(/(^\s*)|(\s*$)/g, "");
            var type = $('#type-select').val().replace(/(^\s*)|(\s*$)/g, "");
            var introduce = $('#introduce').val().replace(/(^\s*)|(\s*$)/g, "");

            //包装成JSON
            var obj = {
                'name': courseApplicationName,
                'type':type,
                'introduce':introduce
            }
            // ajax处理接收课程表
            $.ajax({
                    url: "/teacherCourse/application",
                    data: JSON.stringify(obj),
                    dataType: "text",
                    type: "post",
                    contentType: "application/json;charset=utf-8",
                    success: function (data) {
                        alert("提交成功");
                        window.location.reload();
                    }
                }
            )
        }
    )
</script>
</body>
</html>
