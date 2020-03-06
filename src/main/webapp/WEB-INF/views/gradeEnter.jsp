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
                                <a href="/ToCourseApplication" class="nav-link">
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
                                                    <th >上课人数</th>
                                                    <th> </th>
                                                </tr>
                                            </thead>
                                            <tbody align="center" id="gradeTbody">
                                                <tr id="template">
                                                    <td id="courseName"></td>
                                                    <td id="week"></td>
                                                    <td> </td>
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

<div class="modal fade" id="modal-2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" style="display: none;" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header bg-primary border-0">
                <h5 class="modal-title text-white">课程成绩信息</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header bg-light">

                        </div>
                        <div class="card-body">
                            <div class="row">

                                <div class="table-responsive">
                                    <table id="courseGradeTable" class="table table-hover">
                                        <thead>
                                        <tr align="center">
                                            <th >学号</th>
                                            <th >姓名</th>
                                            <th >分数 </th>
                                        </tr>
                                        </thead>
                                        <tbody align="center" id="courseGradeTbody">
                                        <tr id="templates">
                                            <td id="account"></td>
                                            <td id="name"></td>
                                            <td id="grade"> </td>
                                        </tr>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal-footer border-0">
                <button type="button" class="btn btn-link" data-dismiss="modal">取消</button>
                <button id="comment" type="button" class="btn btn-primary">确认</button>
            </div>
        </div>
    </div>
</div>
<%@include file="JSResource.jsp" %>
</body>

<%--获取教师所教课程信息--%>
<script>
    //获取教师所教课程信息
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

                        for (i=0;i<result.data.length;i++) {
                            html+=`
                              <tr>
                                 <td>`+result.data[i].courseName+`</td>
                                 <td>`+(result.data[i].maxNumber-result.data[i].studentsNumber)+`</td>
                                 <td>
                                    <button id ="course_`+result.data[i].id+`" name ="course_`+result.data[i].id+`" value="`+result.data[i].id+`" onclick="enter(`+result.data[i].id+`)" class="btn btn-outline-primary" data-toggle="modal" data-target="#modal-2">录入
                                        <i class="fa fa-pencil-alt"></i>
                                    </button>
                                 </td>
                                 <td></td>
                                 <td></td>
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

<%--查询选择课程的所有学生成绩，并渲染到弹窗--%>
<script>
    function enter(teacherCourseId){
        //包装数据
        var obj = {
            'id':teacherCourseId
        };
        $.ajax({
            url:'/grade/getCourseGrade',
            data:JSON.stringify(obj),
            dataType:"json",
            type:"post",
            contentType: "application/json;charset=utf-8",
            success: function (result) {
                var html="";

                for (i=0;i<result.data.length;i++) {
                    html+=`
                              <tr>
                                 <td id="account_`+result.data[i].account+`">`+result.data[i].account+`</td>
                                 <td>`+result.data[i].name+`</td>
                                 <td>
                                    <input id="grade_`+result.data[i].account+`" class="grade-item"/>
                                 </td>
                                 <td>
                                    <input id="userId_`+result.data[i].userId+`" value="`+result.data[i].userId+`"class="userId-item" type="hidden" />
                                 </td>
                                 <td>
                                    <input id="teacherCourseId_`+teacherCourseId+`" value="`+teacherCourseId+`" class="teacherCourseId-item" type="hidden" />
                                 </td>

                              </tr>

                            `;
                }
                $('#courseGradeTbody').html(html);
                $('#teacherCourseId').val(teacherCourseId);
                return false;

            },
            error: function (){
                alert("输入信息有误")
            }
        })

    }
</script>

<script>
    $("#comment").click(function () {
        var userIdItem = $('.userId-item');
        var teacherCourseIdItem = $('.teacherCourseId-item');
        var gradeItem = $('.grade-item');

        var count = userIdItem.length;
        var gradeVoList = [];

        for(var i=0;i < count; i++) {
            var obj = {
                'userId':userIdItem[i].value,
                'teacherCourseId': teacherCourseIdItem[i].value,
                'grade': gradeItem[i].value
            }
            gradeVoList.push(obj)
        }
        //给后台发送gradeList
        $.ajax({
            url:'/grade/gradeEnter',
            data:JSON.stringify(gradeVoList),
            dataType:"json",
            type:"post",
            contentType: "application/json;charset=utf-8",
            success: function (result) {
                alert("录入成功")
            },
            error: function (){
                alert("输入信息有误")
            }
        })
    })
</script>


</html>
