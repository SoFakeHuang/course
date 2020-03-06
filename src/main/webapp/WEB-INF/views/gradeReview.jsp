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
                <li class="nav-item">
                    <a href="/ToGradeReview" class="nav-link">
                        <i class="icon icon-target"></i> 成绩修改审批
                    </a>
                </li>
                </li>
                <ul class="nav">
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
                                            <th>学号</th>
                                            <th>修改成绩</th>
                                            <th>申请人</th>
                                            <th>申请理由</th>
                                            <th>审核状态</th>
                                        </tr>
                                        </thead>
                                        <tbody id="courseTbody">
                                            <c:forEach items="${gradeReviewVoList}" var="list" varStatus="vs">
                                            <tr>
                                                <td>${list.courseName}</td>
                                                <td>${list.account}</td>
                                                <td>${list.grade}</td>
                                                <td>${list.name}</td>
                                                <td>${list.introduce}</td>
                                                <td>
                                                    <c:if test="${list.status == 0}">
                                                        待审核
                                                    </c:if>
                                                    <c:if test="${list.status == 1}">
                                                     审核通过
                                                      </c:if>
                                                </td>
                                                <td>
                                                    <button id="update_${list.id}" value="${list.id}" class="btn btn-outline-primary">通过
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

<%--审核通过按钮--%>
<script>
    $( function (){
        $( "button[id^='update_']" ).each( function(){//获取所有的id为confirm_开头的Button
            $( this ).bind("click" , function(){//绑定当前点击的按钮
                var id = $(this).attr( "value");//获取它的id属性值
                $.ajax({
                        url: "/gradeReview/pass",
                        data:id,
                        dataType:"json",
                        type: "post",
                        contentType: "application/json;charset=utf-8",
                        success: function (data) {
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
