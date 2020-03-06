<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar page-header">
    <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
        <i class="fa fa-bars"></i>
    </a>

    <a class="navbar-brand" href="#">
        <img src="/EduManagement/Static/imgs/logo.png" alt="logo">
    </a>

    <a href="#" class="btn btn-link sidebar-toggle d-md-down-none">
        <i class="fa fa-bars"></i>
    </a>

    <ul class="navbar-nav ml-auto">

        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <img src="/EduManagement/Static/imgs/avatar-1.png" class="avatar avatar-sm" alt="logo">
                <span class="small ml-1 d-md-down-none">用户</span>
            </a>

            <div class="dropdown-menu dropdown-menu-right">
                <div class="dropdown-header">账户信息</div>

                <a href="/EduManagement/studentsInfo/quireInfo" class="dropdown-item">
                    <i class="fa fa-user"></i> 个人信息
                </a>


                <div class="dropdown-header">设置</div>

                <a href="#" class="dropdown-item">
                    <i class="fa fa-wrench"></i> 设置
                </a>

                <a href="/EduManagement/login/login.jsp" class="dropdown-item">
                    <i class="fa fa-lock"></i> 注销
                </a>
            </div>
        </li>
    </ul>
</nav>