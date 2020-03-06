<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <%@ include file="Resource.jsp" %>
    <title>教务管理系统</title>
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <%@include file="Head.jsp" %>
    <div class="main-container">
        <div class="sidebar">
            <nav class="sidebar-nav">
                <li class="nav-title">导航</li>

                <li class="nav-item">
                    <a href="/EduManagement/user/indexInfo" class="nav-link ">
                        <i class="icon icon-speedometer"></i> 主页
                    </a>
                </li>
                <li class="nav-item">
                    <a href="/EduManagement/teachersCourse/electiveList" class="nav-link">
                        <i class="icon icon-target"></i> 自主选课
                    </a>
                </li>
                </li>
                <ul class="nav">
                    <li class="nav-item">
                        <a href="/EduManagement/v0.3/grade.jsp" class="nav-link active">
                            <i class="icon icon-energy"></i> 查询成绩
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="/EduManagement/studentsInfo/quireInfo" class="nav-link">
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
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header bg-light">
                                成绩查询
                            </div>
                            <div class="card-body">
                                <div class="row">

                                    <div class="col-md-1"></div>

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="year-select">学年</label>
                                            <select id="year-select" class="form-control">
                                                <option>2015-2016</option>
                                                <option>2016-2017</option>
                                                <option>2017-2018</option>
                                                <option>2018-2019</option>
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
                                        <button id="selectGrade" class="btn btn-primary">查询</button>
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
                                查询结果
                            </div>
                            <div class="card-body">
                                <div class="row">

                                    <div class="table-responsive">
                                        <table id="gradeTable" class="table table-hover">
                                            <thead>
                                                <tr align="center">
                                                    <th >课程名</th>
                                                    <th>任课老师</th>
                                                    <th >成绩</th>
                                                </tr>
                                            </thead>
                                            <tbody align="center" id="gradeTbody">
                                                <tr id="template">
                                                    <td id="courseName"></td>
                                                    <td id="teacher"></td>
                                                    <td id="grade"></td>
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
</div>
<%@include file="JSResource.jsp" %>

<script>
    $('#selectGrade').click(function () {
            // 获取学年
            var year = $("#year-select").val().replace(/(^\s*)|(\s*$)/g, "");
            var term = $('#term-select').val().replace(/(^\s*)|(\s*$)/g, "");
            //包装成JSON
            var obj = {
                'years': year,
                'semester':term,
            }
            // ajax处理接收课程表
            $.ajax({
                    url: "${pageContext.request.contextPath}/grade/getGradeVo",
                    data: JSON.stringify(obj),
                    dataType: "json",
                    type: "post",
                    contentType: "application/json;charset=utf-8",
                    success: function (result) {
                        var html="";

                        /*测试接收数据
                        var i;
                        for(i=0;i<result.data.length;i++){
                            alert(result.data[i].grade)
                            alert(result.data[i].course.name)
                        }*/
                        for (i=0;i<result.data.length;i++) {
                            html+=`
                              <tr>
                                 <td>`+result.data[i].courseName+`</td>
                                 <td>`+result.data[i].teacherName+`</td>
                                 <td>`+result.data[i].grade+`</td>
                              </tr>
                            `;
                        }
                        $('#gradeTbody').html(html)
                        return false;
                    }
                }
            )
        }
    )
</script>
</body>
</html>
