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
                    <div class="col-md-3">
                        <div class="card p-4">
                            <div class="card-body d-flex justify-content-between align-items-center">
                                <div>
                                    <span class="h4 d-block font-weight-normal mb-2">${userInfoVo.name}</span>
                                    <span class="font-weight-light">${userInfoVo.departmentName}</span>
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
                                <h4>课表查询</h4>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="year-select">学年</label>
                                            <select id="year-select" class="form-control">
                                                <option>2015-2016</option>
                                                <option>2016-2017</option>
                                                <option>2017-2018</option>
                                                <option>2018-2019</option>
                                                <option>2019-2020</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="term-select">学期</label>
                                            <select id="term-select" class="form-control">
                                                <option>1</option>
                                                <option>2</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-md-1"></div>

                                    <div class="my-4">
                                        <button id="selectCourse" class="btn btn-primary">查询</button>
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
