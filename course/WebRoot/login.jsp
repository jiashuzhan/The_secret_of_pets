<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<% String base = request.getContextPath() + "/"; %>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>萌宠管家_登录界面</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="author" content="" />
  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Themify Icons-->
	<link rel="stylesheet" href="css/themify-icons.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">

	<!-- Magnific Popup -->
	<link rel="stylesheet" href="css/magnific-popup.css">

	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
 <SCRIPT Language=javascript>
<!--
//下面的副程序将执行资料检查
function isValid()
{
//下面的if判断语句将检查是否已输入账号 
if(frmLogin.id.value="")
{
window.a1ert("您必须完成账号的输入!");
//显示错误信息
document.frmLogin.elements(1).focus ();
//将光标移至账号输入栏
return false;
}
//下面的if判断语句将检查是否输入账号密码
if(frmLogin.password.value =="")
{
window.a1ert("您必须完成密码的输入!");
//显示错误信息
document.frmLogin.elements(1). focus();
//将光标移至密码输入栏
return fa1se;
//离开函数
}
frmLogin.submit();//送出表单中的资料
}
-->
</SCRIPT>
	</head>
	<body>
	<div id="page">
	<header id="gtco-header" class="gtco-cover" role="banner" style="background-image: url(images/img_333.jpg)">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 text-left">
					

					<div class="row row-mt-15em">
						<div class="col-md-7 mt-text animate-box" data-animate-effect="fadeInUp">
							<span class="intro-text-small">欢迎来到爱宠大机密的世界</span>
							<h1>智能化宠物检测系统</h1>	
						</div>
						<div class="col-md-4 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
							<div class="form-wrap">
								<div class="tab">
									<ul class="tab-menu">
										<li class="gtco-second"><a href="#" data-tab="login">登录</a></li>
										<li class="active gtco-first"><a href="#" data-tab="signup">注册</a></li>
                                    
									</ul>
									<div class="tab-content">
										<div class="tab-content-inner active" data-content="signup">
											<form action="#">
												<div class="row form-group">
													<div class="col-md-12">
														<label for="username">用户名</label>
														<input type="text" class="form-control" id="username">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="password">密码</label>
														<input type="password" class="form-control" id="password">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="password2">重复密码</label>
														<input type="password" class="form-control" id="password2">
													</div>
												</div>

												<div class="row form-group">
													<div class="col-md-12" style="text-align:center">
														<input type="submit" class="btn btn-primary" value="注册">
													</div>
												</div>
											</form>	
										</div>
<form name="frmLogin" method="post" action="servlet/login_confirm" onSubmit="return isvalid(this);">
										<div class="tab-content-inner" data-content="login">
											<form action="#">
												<div class="row form-group">
													<div class="col-md-12">
														<label for="username">用户名</label>
														 <input type="text" class="form-control" placeholder="id" name="id" >
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="password">密码</label>
														<input type="password" class="form-control" placeholder="password" name="password">
														<br>
              <input name="kind" type="radio" value="student" checked>                  
              <font color="#778899" size="+1.7" face="宋体">学生</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="kind" value="teacher">
              <font color="#778899" size="+1.7" face="宋体">教师</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="kind" value="admin">
              <font color="#778899" size="+1.7" face="宋体">管理员</font></td>
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12" style="text-align:center">
													<button type="submit" name="Submit" class="btn btn-primary">登录</button>
													<%
String getmessage =(String)  session.getAttribute("error");
if(getmessage==null) {getmessage="";}
 %>
  <p class="text-muted text-center"><small><font color="red"><%= getmessage%></small></p>
 </form>
                                                   <p><a href="#">忘记密码?</a></p>      
													</div>
												</div>
											</form>	
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
							
					
				</div>
			</div>
		</div>
	</header>

			<div class="row copyright">
				<div class="col-md-12">
					<p class="pull-left">
						<small class="block">Copyright &copy; 2019.TheSecretOfThePets All rights reserved.</small> 
					</p>
				</div>
			</div>

		</div>
	</footer>
	</div>

	</div>
<!--回到顶部-->
	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>

	</body>
</html>

