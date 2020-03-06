<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <%@ include file ="Resource.jsp"%>
    <title>教务管理系统</title>
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <%@include file="Head.jsp"%>

    <div class="main-container">
        <div class="sidebar">
            <nav class="sidebar-nav">
                <ul class="nav">
                    <li class="nav-title">导航</li>

                    <li class="nav-item">
                        <a href="/EduManagement/v0.3/index_teacher.jsp" class="nav-link">
                            <i class="icon icon-speedometer"></i> 主页
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="/EduManagement/v0.3/gradeadd_teacher.jsp" class="nav-link">
                            <i class="icon icon-target"></i> 学生成绩操作
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="/EduManagement/teachersInfo/personalTeachersInfo" class="nav-link active">
                            <i class="icon icon-energy"></i> 教师信息
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
                    <div class="container-fluid">
                        <div class="row">

                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-header bg-light">
                                        学生信息
                                    </div>
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="card text-white border-0">
                                                    <div class="card-header bg-info">
                                                        基本信息
                                                    </div>

                                                    <div class="card-body bg-info">
                                                        <ul>
                                                            <li>工号：${teachersInfo.teacher_number}</li>
                                                            <li>姓名:${teachersInfo.name}</li>
                                                            <li>性别:${teachersInfo.sex}</li>
                                                            <li>用户组</li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-12">
                                                <div class="card text-white border-0">
                                                    <div class="card-header bg-primary">
                                                        详细信息
                                                    </div>

                                                    <div class="card-body bg-primary">
                                                        <ul>
                                                            <li>电话号码：${teachersInfo.phone}</li>
                                                            <li>籍贯：</li>
                                                            <li>身份证号码：${teachersInfo.user_id}</li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
        
            </div>
        </div>
    </div>
</div>
<%@include file="JSResource.jsp"%>
</body>
</html>
