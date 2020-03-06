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
                        <a href="/EduManagement/v0.3/index_admin.jsp" class="nav-link active">
                            <i class="icon icon-speedometer"></i> 主页
                        </a>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> 学生管理 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="/EduManagement/v0.3/student_admin.jsp" class="nav-link">
                                    <i class="icon icon-target"></i> 学生管理
                                </a>
                            </li>                 
                        </ul>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> 教师管理 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="/EduManagement/v0.3/teacher_admin.jsp" class="nav-link">
                                    <i class="icon icon-target"></i> 教师管理
                                </a>
                            </li>                 
                        </ul>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> 公告管理 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="/EduManagement/v0.3/announcement_admin.jsp" class="nav-link">
                                    <i class="icon icon-target"></i> 公告管理
                                </a>
                            </li>                 
                        </ul>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> 班级管理 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="/EduManagement/v0.3/class_admin.jsp" class="nav-link">
                                    <i class="icon icon-target"></i> 班级管理
                                </a>
                            </li>                 
                        </ul>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> 学院管理 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="/EduManagement/v0.3/department_admin.jsp" class="nav-link">
                                    <i class="icon icon-target"></i> 学院管理
                                </a>
                            </li>                 
                        </ul>
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
                    <div class="col-md-3">
                        <div class="card p-4">
                            <div class="card-body d-flex justify-content-between align-items-center">
                                <div>
                                    <span class="h4 d-block font-weight-normal mb-2">用户名</span>
                                    <span class="font-weight-light">班级</span>
                                </div>

                                <div class="h2 text-muted">
                                    <i class="icon icon-people"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-9 mb-4">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#home" role="tab" aria-controls="home">标题1</a>
                            </li>
    
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#profile" role="tab" aria-controls="profile">标题2</a>
                            </li>
    
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#messages" role="tab" aria-controls="messages">标题3</a>
                            </li>
                        </ul>
    
                        <div class="tab-content">
                            <div class="tab-pane active" id="home" role="tabpanel">
                                正文1
                            </div>
    
                            <div class="tab-pane" id="profile" role="tabpanel">
                                2. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure
                                dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </div>
    
                            <div class="tab-pane" id="messages" role="tabpanel">
                                3. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure
                                dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header bg-light">
                                课表信息
                            </div>
    
                            <div class="card-body">
                                <div>
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>星期一</th>
                                            <th>星期二</th>
                                            <th>星期三</th>
                                            <th>星期四</th>
                                            <th>星期五</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>第一节</td>
                                            <td>语文</td>
                                            <td></td>
                                            <td>数学</td>
                                            <td>英语</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Google Pixel XL</td>
                                            <td>99,542</td>
                                            <td>$750</td>
                                            <td>3%</td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>iPhone X</td>
                                            <td>62,220</td>
                                            <td>$1,200</td>
                                            <td>0%</td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td>OnePlus 5T</td>
                                            <td>50,000</td>
                                            <td>$650</td>
                                            <td>5%</td>
                                        </tr>
                                        <tr>
                                            <td>5</td>
                                            <td>Google Nexus 6</td>
                                            <td>400</td>
                                            <td>$400</td>
                                            <td>7%</td>
                                        </tr>
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
</div>
<%@include file="JSResource.jsp"%>
</body>
</html>
