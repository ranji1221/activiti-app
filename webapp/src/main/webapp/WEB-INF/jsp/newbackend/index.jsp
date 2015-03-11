<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html class="no-js">

<head>
    <!-- Some assets concatenated and minified to improve load speed. Download version includes source css, javascript and less assets -->
    <!-- meta -->
    <meta charset="utf-8">
    <meta name="description" content="Flat, Clean, Responsive, admin template built with bootstrap 3">
    <meta name="viewport" content="width=device-width, user-scalable=1, initial-scale=1, maximum-scale=1">

    <title>Admin Dashboard</title>

    <!-- bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/cameo/bootstrap/css/bootstrap.min.css">
    <!-- /bootstrap -->

    <!-- core styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/cameo/min/main.min.css">
    <!-- /core styles -->

    <!-- page styles -->
    <!-- /page styles -->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
        <script src="${pageContext.request.contextPath}/cameo/libs/html5shiv.js"></script>
        <script src="${pageContext.request.contextPath}/cameo/libs/respond.min.js"></script>
    <![endif]-->

    <!-- load modernizer -->
    <script src="${pageContext.request.contextPath}/cameo/vendor/modernizr.js"></script>
</head>

<!-- body -->

<body>
    <div class="app">
        <!-- top header -->
        <header class="header header-fixed navbar bg-white">

            <div class="brand bg-success">
                <a href="#" class="fa fa-bars off-left visible-xs" data-toggle="off-canvas" data-move="ltr"></a>

                <a href="index-2.html" class="navbar-brand text-white">
                    <i class="fa fa-microphone mg-r-xs"></i>
                    <span>RanJi
                        <b>ADMIN</b>
                    </span>
                </a>
            </div>

            <form class="navbar-form navbar-left hidden-xs" role="search">
                <div class="form-group">
                    <button class="btn no-border no-margin bg-none no-pd-l" type="submit">
                        <i class="fa fa-search"></i>
                    </button>
                    <input type="text" class="form-control no-border no-padding search" placeholder="Search Workspace">
                </div>
            </form>

            <ul class="nav navbar-nav navbar-right off-right">
                <li class="hidden-xs">
                    <a href="profile.html">
                        +Gerald Theodore Morris
                    </a>
                </li>

                <li class="notifications dropdown hidden-xs">
                    <a href="#" data-toggle="dropdown">
                        <i class="fa fa-bell"></i>
                        <div class="badge badge-top bg-danger animated flash">3</div>
                    </a>
                </li>
                <li class="quickmenu mg-r-md">
                    <a href="#" data-toggle="dropdown">
                        <img src="${pageContext.request.contextPath}/cameo/img/avatar.jpg" class="avatar pull-left img-circle" alt="user" title="user">
                        <i class="caret mg-l-xs hidden-xs no-margin"></i>
                    </a>
                </li>
            </ul>
        </header>
        <!-- /top header -->

        <section class="layout">
            <!-- sidebar menu -->
            <aside class="sidebar canvas-left bg-dark">
                <!-- main navigation -->
                <nav class="main-navigation">
                    <ul>
                        <li>
                            <a href="index-2.html">
                                <i class="fa fa-coffee"></i>
                                <span>Framework</span>
                            </a>
                        </li>
                        <li class="dropdown show-on-hover">
                            <a href="#" data-toggle="dropdown">
                                <i class="fa fa-ellipsis-h"></i>
                                <span>UI Elements</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="buttons.html">
                                        <span>Buttons</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="forms.html">
                                        <span>Forms</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="mail.html">
                                <i class="fa fa-envelope"></i>
                                <span>Mailbox</span>
                                <div class="badge badge-opac pull-right">8</div>
                            </a>
                        </li>
                       

                  
                        <li>
                            <a href="chat.html">
                                <i class="fa fa-comment"></i>
                                <span>Chat</span>
                            </a>
                        </li>
                    </ul>
                </nav>
                <!-- /main navigation -->


                <!-- footer -->
                <footer>
                    <div class="about-app pd-md animated pulse">
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/cameo/img/about.png" alt="">
                        </a>
                        <span>
                            <b>Cameo</b>&#32;is a responsive admin template powered by bootstrap 3.
                            <a href="#">
                                <b>Find out more</b>
                            </a>
                        </span>
                    </div>

                    <div class="footer-toolbar pull-left">
                        <a href="#" class="pull-left help">
                            <i class="fa fa-question-circle"></i>
                        </a>

                        <a href="#" class="toggle-sidebar pull-right hidden-xs">
                            <i class="fa fa-angle-left"></i>
                        </a>
                    </div>
                </footer>
                <!-- /footer -->
            </aside>
            <!-- /sidebar menu -->

            <!-- main content -->
            <section class="main-content">
                <!-- content wrapper -->
                <div class="content-wrap">
					
                </div>
                <!-- /content wrapper -->
            </section>
            <!-- /main content -->
        </section>

    </div>

    <script src="${pageContext.request.contextPath}/cameo/min/main.min.js"></script>

    <!-- page scripts -->
    <!-- /page scripts -->


</body>
<!-- /body -->

</html>



