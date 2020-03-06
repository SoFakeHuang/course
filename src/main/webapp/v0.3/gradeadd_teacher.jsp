<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <ul class="nav">
                    <li class="nav-title">导航</li>

                    <li class="nav-item">
                        <a href="/EduManagement/v0.3/index_teacher.jsp" class="nav-link">
                            <i class="icon icon-speedometer"></i> 主页
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="/EduManagement/grade/GradeAdd" class="nav-link active">
                            <i class="icon icon-target"></i> 学生成绩操作
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="/EduManagement/v0.3/info_teacher.jsp" class="nav-link">
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
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-4"></div>
                                    <div class="col-md-4">
                                        <label for="single-select">课程名称</label>
                                        <select id="single-select" class="form-control">
                                            <c:forEach items="${courseList}" var="list" varStatus="vs">
                                                <option id="confirm_${list.id}" value="${list.id}">${list.course.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-md-1"></div>
                                    <div class="my-4 col-md-1">
                                        <button id="quire" class="btn btn-primary">查询</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header bg-light">
                                查询结果
                            </div>

                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>学生姓名</th>
                                            <th>任课老师</th>
                                            <th>成绩</th>
                                            <th>修改</th>
                                        </tr>
                                        </thead>
                                        <tbody id="gradeTbody">

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

<div class="modal fade" id="modal-4" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header bg-primary border-0">
                <h5 class="modal-title text-white">修改成绩</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body p-5">
                <div class="form-group">
                    <label  for="grade" class="form-control-label">输入成绩</label>
                    <input onblur="checkInt(this.value,100);" id="grade" class="form-control">
                </div>
            </div>

            <div class="modal-footer border-0">
                <button  id="submit" type="button" class="btn btn-primary" data-dismiss="modal">提交</button>
            </div>
        </div>
    </div>
</div>
<%@include file="JSResource.jsp" %>
</body>

<%--查询课程--%>
<script>
    $('#quire').click(function () {
        var checkValue = $("#single-select").val();//获取课程ID
            $.ajax({
                    url: "${pageContext.request.contextPath}/grade/courseGradeList",
                    async:true,
                    data: checkValue,
                    dataType: "json",
                    type: "post",
                    contentType: "application/json;charset=utf-8",
                    success: function (data) {
                        // alert(data.msg)
                        var html="";
                        for (i=0;i<data.data.length;i++) {
                            html+=`
                              <tr>
                                <td>`+data.data[i].studentsInfo.name+`</td>
                                <td>`+data.data[i].teachersInfo.name+`</td>
                                <td>`+data.data[i].grade+`</td>
                                <td>
                                    <button id="update_`+data.data[i].studentsInfo.id+`" name="`+i+`"
                                    class="btn btn-outline-info" data-toggle="modal" data-target="#modal-4">修改</button>
                                </td>
                              </tr>
                            `;
                        }
                        $('#gradeTbody').html(html)
                        <%--修改成绩--%>
                        $( function (){
                            $( "button[id^='update_']" ).each( function(){//获取所有的id为confirm_开头的Button
                                $( this ).bind("click" , function(){//绑定当前点击的按钮
                                    var ids = $(this).attr( "name");//获取它的data下标属性值
                                    var id = $(this).attr( "id");//获取它的id值
                                    var obj;//包装json
                                    var grade//获取成绩

                                    //data下标
                                    // alert(ids)

                                    $("#submit").click(function () {
                                        grade = $("#grade").val()
                                        // alert(grade)
                                        obj = {
                                            "id":data.data[ids].id,
                                            "teachers_course_id":data.data[ids].teachers_course_id,
                                            "students_info_id": data.data[ids].students_info_id,
                                            "grade":grade
                                        }

                                        //请求修改
                                        $.ajax({
                                                url: "${pageContext.request.contextPath}/grade/update",
                                                data:JSON.stringify(obj),
                                                dataType:"json",
                                                type: "post",
                                                contentType: "application/json;charset=utf-8",
                                                success: function (data) {
                                                    // alert(data.msg)
                                                    $("#quire").trigger('click');
                                                }
                                            }
                                        )
                                    })
                                });
                            });
                        });
                    }
                }
            )
    });
</script>

<script>
    function checkInt(n,max){
        var regex = /^\d+$/;
        if(regex.test(n)){
            if(n<max && n>0){

            }else{
                alert("输入0-100整数")
                $(#submit).attr("disabled", true)
            }
        }else{
            alert("非整数");
            $(#submit).attr("disabled", true);
        }
    }
</script>

</html>
