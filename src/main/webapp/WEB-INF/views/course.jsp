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
                    <a href="/user/ToIndex" class="nav-link ">
                        <i class="icon icon-speedometer"></i> 主页
                    </a>
                </li>
                <li class="nav-item">
                    <a href="/course/ToCourseList" class="nav-link active">
                        <i class="icon icon-target"></i> 自主选课
                    </a>
                </li>
                </li>
                <ul class="nav">
                    <li class="nav-item">
                        <a href="/ToGrade" class="nav-link">
                            <i class="icon icon-energy"></i> 查询成绩
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="/ToInfo" class="nav-link">
                            <i class="icon icon-energy"></i> 查询学籍信息
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

                    <%--TODO 课程查找--%>
                    <%--<div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-3"></div>
                                    <div class="col-md-6">
                                        <label for="input-group-2"></label>
                                        <div class="input-group">
                                            <input type="text" id="input-group-2" name="input1-group2"
                                                   class="form-control" placeholder="课程名称">
                                            <span class="input-group-btn">
                                                    <button type="button" class="btn btn-primary"><i
                                                            class="fa fa-search"></i>查找</button>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>--%>


                    <div class="col-md-12">
                        <div class="card">
                                <div class="card-header bg-light">
                                    课程信息
                                </div>
                                <div class="table-responsive">
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>课程名称</th>
                                            <th>课程类型</th>
                                            <th>课程时间</th>
                                            <th>剩余</th>
                                            <th>选课</th>
                                        </tr>
                                        </thead>
                                        <tbody id="courseTbody">
                                            <c:forEach items="${teachersCourseVoList}" var="list" varStatus="vs">
                                            <tr>
                                                <td>${list.courseName}</td>
                                                <td>${list.type}</td>
                                                <td>周${list.week}第${list.classTime}节</td>
                                                <td>${list.studentsNumber}</td>
                                                <td>
                                                    <button id="confirm_${list.id}" name="${list.id}" class="btn btn-outline-primary">选课
                                                    </button>
                                                </td>
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
</body>

<script>
    $( function (){
        $( "button[id^='confirm_']" ).each( function(){//获取所有的id为confirm_开头的Button
            $( this ).bind("click" , function(){//绑定当前点击的按钮
                var ids = $(this).attr( "name");//获取它的id属性值
                $.ajax({
                        url: "${pageContext.request.contextPath}/course/elCourse",
                        data:ids,
                        dataType:"json",
                        type: "post",
                        contentType: "application/json;charset=utf-8",
                        success: function (data) {
                            alert(data.msg);
                            window.location.reload();
                        }
                    }
                )
                $(this).attr("disabled", true)
            });
        });
    });
</script>

</html>
