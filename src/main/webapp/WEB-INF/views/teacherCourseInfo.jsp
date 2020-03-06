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
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header bg-light">
                                课程查询
                            </div>
                            <div class="card-body">
                                <div class="row">

                                    <div class="col-md-1"></div>

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="year-select">学年</label>
                                            <select id="year-select" class="form-control">
                                                <option>2019-2020</option>
                                                <option>2018-2019</option>
                                                <option>2017-2018</option>
                                                <option>2016-2017</option>
                                                <option>2015-2016</option>
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
                                                    <th>时间</th>
                                                    <th >上课课室</th>
                                                </tr>
                                            </thead>
                                            <tbody align="center" id="gradeTbody">
                                                <tr id="template">
                                                    <td id="courseName"></td>
                                                    <td id="week"></td>
                                                    <td id="classroom"></td>
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
            var years = $("#year-select").val().replace(/(^\s*)|(\s*$)/g, "");
            var semester = $('#term-select').val().replace(/(^\s*)|(\s*$)/g, "");

            //包装成JSON
            var obj = {
                'years': years,
                'semester':semester,
            }
            // ajax处理接收课程表
            $.ajax({
                    url: "/course/getCourseVoByUser",
                    data: JSON.stringify(obj),
                    dataType: "json",
                    type: "post",
                    contentType: "application/json;charset=utf-8",
                    success: function (result) {
                        var html="";

                        /*//测试接收数据
                        var i;
                        for(i=0;i<result.data.length;i++){
                            alert(result.data[i].grade)
                            alert(result.data[i].courseName)
                        }*/
                        for (i=0;i<result.data.length;i++) {
                            html+=`
                              <tr>
                                 <td>`+result.data[i].courseName+`</td>
                                 <td>周`+result.data[i].week+`第`+result.data[i].classTime+`节</td>
                                 <td>`+result.data[i].classroom+`</td>
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
