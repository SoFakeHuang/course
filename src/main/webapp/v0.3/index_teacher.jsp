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
                        <a href="/EduManagement/user/indexInfo" class="nav-link active">
                            <i class="icon icon-speedometer"></i> 主页
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="/EduManagement/grade/GradeAdd" class="nav-link">
                            <i class="icon icon-target"></i> 学生成绩操作
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="/EduManagement/teachersInfo/personalTeachersInfo " class="nav-link">
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
                    <div class="col-md-3">
                        <div class="card p-4">
                            <div class="card-body d-flex justify-content-between align-items-center">
                                <div>
                                    <span class="h4 d-block font-weight-normal mb-2">${teacherDepartmentPo.name}</span>
                                    <span class="font-weight-light">${teacherDepartmentPo.department.name}</span>
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
                                <a class="nav-link active" data-toggle="tab" href="#home" role="tab"
                                   aria-controls="home">${announcementList.get(0).tittle}</a>
                            </li>

                            <c:forEach items="${announcementList}" var="list" begin="1" varStatus="vs">
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#massage_${vs.index}" role="tab"
                                       aria-controls="#massage_${vs.index}">${list.tittle}</a>
                                </li>
                            </c:forEach>
                        </ul>

                        <div class="tab-content">
                            <div class="tab-pane active" id="home" role="tabpanel">
                                ${announcementList.get(0).text}
                            </div>

                            <c:forEach items="${announcementList}" var="list" begin="1" varStatus="vs">
                                <div class="tab-pane" role="tabpanel" id="massage_${vs.index}">
                                        ${list.text}
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header bg-light">
                                <div class="row">
                                    <div class="col-md-3">
                                        课表信息
                                    </div>
                                    <div class="col-md-6">
                                        <div class="input-group">
                                            <input type="text" id="className" name="name"
                                                   class="form-control" placeholder="班级">
                                            <span class="input-group-btn">
                                                    <button id="selectCourse" type="button" class="btn btn-primary"><i
                                                            class="fa fa-search"></i>查找</button>
                                                </span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th></th>
                                            <th>星期一</th>
                                            <th>星期二</th>
                                            <th>星期三</th>
                                            <th>星期四</th>
                                            <th>星期五</th>
                                        </tr>
                                        </thead>
                                        <tbody id="tbody">
                                        <tr>
                                            <th scope="row">1-2节</th>
                                            <td id="table_1_1"></td>
                                            <td id="table_2_1"></td>
                                            <td id="table_3_1"></td>
                                            <td id="table_4_1"></td>
                                            <td id="table_5_1"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">3-4节</th>
                                            <td id="table_1_2"></td>
                                            <td id="table_2_2"></td>
                                            <td id="table_3_2"></td>
                                            <td id="table_4_2"></td>
                                            <td id="table_5_2"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">5-6节</th>
                                            <td id="table_1_3"></td>
                                            <td id="table_2_3"></td>
                                            <td id="table_3_3"></td>
                                            <td id="table_4_3"></td>
                                            <td id="table_5_3"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">7-8节</th>
                                            <td id="table_1_4"></td>
                                            <td id="table_2_4"></td>
                                            <td id="table_3_4"></td>
                                            <td id="table_4_4"></td>
                                            <td id="table_5_4"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">9-10节</th>
                                            <td id="table_1_5"></td>
                                            <td id="table_2_5"></td>
                                            <td id="table_3_5"></td>
                                            <td id="table_4_5"></td>
                                            <td id="table_5_5"></td>
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
