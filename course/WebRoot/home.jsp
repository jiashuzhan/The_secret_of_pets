<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!doctype html>
<html>
<% String base = request.getContextPath() + "/"; %>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>萌宠管家的世界</title>
<meta name="description" content="">
<meta name="keywords" content="" />
<meta name="author" content="">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Google Fonts  -->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,500' rel='stylesheet' type='text/css'> <!-- Body font -->
<link href='http://fonts.googleapis.com/css?family=Lato:300,400' rel='stylesheet' type='text/css'> <!-- Navbar font -->

<!-- Libs and Plugins CSS -->
<link rel="stylesheet" href="<%=base %>inc/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=base %>inc/animations/css/animate.min.css">
<link rel="stylesheet" href="<%=base %>inc/font-awesome/css/font-awesome.min.css"> <!-- Font Icons -->
<link rel="stylesheet" href="<%=base %>inc/owl-carousel/css/owl.carousel.css">
<link rel="stylesheet" href="<%=base %>inc/owl-carousel/css/owl.theme.css">

<!-- Theme CSS -->
<link rel="stylesheet" href="<%=base %>css/reset.css">
<link rel="stylesheet" href="<%=base %>css/style1.css">
<link rel="stylesheet" href="<%=base %>css/mobile.css">

<!-- Skin CSS -->
<link rel="stylesheet" href="<%=base %>css/skin/cool-gray.css">


</head>
    <script language="javascript">  
    var XMLHttpReq;  
        //创建XMLHttpRequest对象         
        function createXMLHttpRequest() {  
            if(window.XMLHttpRequest) { //Mozilla 浏览器  
                XMLHttpReq = new XMLHttpRequest();  
            }  
            else if (window.ActiveXObject) { // IE浏览器  
                try {  
                    XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");  
                } catch (e) {  
                    try {  
                        XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");  
                    } catch (e) {}  
                }  
            }  
        }  
        //发送请求函数  
        function sendRequest() {  
            createXMLHttpRequest();  
            var url = "ajax.jsp";  
            XMLHttpReq.open("GET", url, true);  
            XMLHttpReq.onreadystatechange = processResponse;//指定响应函数  
            XMLHttpReq.send(null);  // 发送请求  
        }  
        // 处理返回信息函数  
        function processResponse() {  
            if (XMLHttpReq.readyState == 4) { // 判断对象状态  
                if (XMLHttpReq.status == 200) { // 信息已经成功返回，开始处理信息  
                    DisplayHot();  
                    setTimeout("sendRequest()", 1000);  
                } else { //页面不正常  
                    window.alert("您所请求的页面有异常。");  
                }  
            }  
        }  
        function DisplayHot() {  
            var name = XMLHttpReq.responseXML.getElementsByTagName("name")[0].firstChild.nodeValue;
            var shiwen = XMLHttpReq.responseXML.getElementsByTagName("shiwen")[0].firstChild.nodeValue;    
            document.getElementById("product").innerHTML = name;   
            document.getElementById("shiwen").innerHTML = shiwen; 
        }   
    </script> 
<body data-spy="scroll" data-target="#main-navbar" onload =sendRequest()>
<div class="page-loader"></div>  <!-- Display loading image while page loads -->
<div class="body">

	<!--========== BEGIN HEADER ==========-->
	<header id="header" class="header-main">

		<!-- Begin Navbar -->
		<nav id="main-navbar" class="navbar navbar-default navbar-fixed-top" role="navigation"> <!-- Classes: navbar-default, navbar-inverse, navbar-fixed-top, navbar-fixed-bottom, navbar-transparent. Note: If you use non-transparent navbar, set "height: 98px;" to #header -->

		  <div class="container">

			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
			  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			  </button>
			  <a class="navbar-brand page-scroll" href="<%=base %>home。jsp">Psecret</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a class="page-scroll" href="body">首页</a></li>
					<li><a class="page-scroll" href="#about-section">实时监测</a></li>
					<li><a class="page-scroll" href="#services-section">历史记录</a></li>
					<li><a class="page-scroll" href="#more-section">更多信息</a></li>
                    <li><a class="page-scroll" href="#contact-section">联系我们</a></li>
				</ul>
			</div><!-- /.navbar-collapse -->
		  </div><!-- /.container -->
		</nav>
		<!-- End Navbar -->

	</header>
	<!-- ========= END HEADER =========-->
	
	
	
	
	<!-- Begin text carousel intro section -->
	<section id="text-carousel-intro-section" class="parallax" data-stellar-background-ratio="0.5" style="background-image: url(<%=base %>img/11.jpg);">
		
		<div class="container">
			<div class="caption text-center text-white" data-stellar-ratio="0.7">

				<div id="owl-intro-text" class="owl-carousel">
					<div class="item">
						<h1>购买产品</h1>
						<p>Buy product</p>
						<div class="extra-space-l"></div>
						<a class="btn btn-blank" href="<%=base %>" target="_blank" role="button">查看更多!</a>
					</div>
					<div class="item">
						<h1>加入我们</h1>
						<p>Join us</p>
						<div class="extra-space-l"></div>
						<a class="btn btn-blank" href="<%=base %>" target="_blank" role="button">查看更多!</a>
					</div>
				</div>

			</div> <!-- /.caption -->
		</div> <!-- /.container -->

	</section>
	<!-- End text carousel intro section -->
	
<!-- 连接数据库 -->
<%
String dbName = "TheSecretOfPet";
String username = "sa";
String password = "123456";
String host = "127.0.0.1";
int port = 1433;
String connectionUrl = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + dbName + ";user=" + username
+ ";password=" + password;
//声明需要使用的资源
// 数据库连接，记得用完了一定要关闭
Connection con = null;
// Statement 记得用完了一定要关闭
Statement stmt = null;
// 结果集，记得用完了一定要关闭
ResultSet rs1 = null;
// 注册驱动
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
// 获得一个数据库连接
con = DriverManager.getConnection(connectionUrl);
String SQL = "SELECT * from PetInnerInformation";
// 创建查询
stmt = con.createStatement();
// 执行查询，拿到结果集
rs1 = stmt.executeQuery(SQL);
%>
		
	<!-- Begin about section -->
	<section id="about-section" class="page bg-style1">
		<!-- Begin page header-->
		<div class="page-header-wrapper">
			<div class="container">
				<div class="page-header text-center wow fadeInUp" data-wow-delay="0.3s">
				<HR style="FILTER: progid:DXImageTransform.Microsoft.Shadow(color:#987cb9,direction:145,strength:15)" border="width=1000"  width="200%" color=#987cb9 SIZE="1000">
				<br><br><br>
					<h2>实时监测</h2>
					<div class="devider"></div>
					<p class="subtitle">Real-time monitoring</p>
				</div>
			</div>
		</div>
		<!-- End page header-->

		<!-- Begin rotate box-1 -->
		<div class="rotate-box-1-wrapper" >
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0">
							<span class="rotate-box-icon"><i class="fa fa-users"></i></span>
							<div class="rotate-box-info">
								<h4>年龄</h4>
								<% while (rs1.next()&&rs1.getString(1).trim().equals("123456789")) {
                                %>
                                 <p><%=rs1.getString(12)%>周岁</p>
                         
							</div>
						</a>
					</div>
                    <div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0">
							<span class="rotate-box-icon"><i class="fa fa-heart"></i></span>
							<div class="rotate-box-info">
								<h4>心率</h4>
								<p>62次/分钟</p>
							</div>
						</a>
					</div>
                    <div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0">
							<span class="rotate-box-icon"><i class="fa fa-cloud"></i></span>
							<div class="rotate-box-info">
								<h4>体温</h4>
								<p id="product"></p><p> 摄氏度</p>
							</div>
						</a>
					</div>
                    <div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0">
							<span class="rotate-box-icon"><i class="fa fa-users"></i></span>
							<div class="rotate-box-info">
								<h4>运动</h4>
								<p>12336</p>
								<p>步数</p>
							</div>
						</a>
					</div>
                    <div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0">
							<span class="rotate-box-icon"><i class="fa fa-users"></i></span>
							<div class="rotate-box-info">
								<h4>定位</h4>
								<p>纬度<%=rs1.getString(5)%>经度<%=rs1.getString(6)%></p>
							</div>
						</a>
					</div>

					<div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0.2s">
							<span class="rotate-box-icon"><i class="fa fa-diamond"></i></span>
							<div class="rotate-box-info">
								<h4>室温</h4>
								<p id="shiwen"></p>
								<p>摄氏度</p>
							</div>
						</a>
					</div>

					<div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0.4s">
							<span class="rotate-box-icon"><i class="fa fa-heart"></i></span>
							<div class="rotate-box-info">
								<h4>寻觅灯</h4>
								<p><%=rs1.getString(8)%>（1表示开 0表示关）</p>
							</div>
						</a>
					</div>
					
                    					<div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0.4s">
							<span class="rotate-box-icon"><i class="fa fa-clock-o"></i></span>
							<div class="rotate-box-info">
								<h4>健康值</h4>
								<p>83.6分数值</p>
								<%
                                  }
                                  //con.close();
                                  //stmt.close();
                                  //rs1.close();
                                %>
							</div>
						</a>
					</div>
				</div> <!-- /.row -->
			</div> <!-- /.container -->
		</div>
		<!-- <div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></div>-->
	
		<!-- End rotate box-1 -->
		
		<div class="extra-space-l"></div>
  </section>
  <!-- End about section -->	  
	<!-- Begin Services -->
	<section id="services-section" class="page text-center">
		<!-- Begin page header-->
		<div class="page-header-wrapper">
			<div class="container">
				<div class="page-header text-center wow fadeInDown" data-wow-delay="0.4s">
					<h2>历史记录</h2>
					<div class="devider"></div>
					<p class="subtitle">History record</p>
				</div>
			</div>
		</div>
		<!-- End page header-->
	
		<!-- Begin roatet box-2 -->
		<div class="rotate-box-2-wrapper">
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0">
							<span class="rotate-box-icon"><i class="fa fa-mobile"></i></span>
							<div class="rotate-box-info">
								<h4>App Development</h4>
								<p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
							</div>
						</a>
					</div>
	
					<div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0.2s">
							<span class="rotate-box-icon"><i class="fa fa-pie-chart"></i></span>
							<div class="rotate-box-info">
								<h4>Ui Design</h4>
								<p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
							</div>
						</a>
					</div>
	
					<div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0.4s">
							<span class="rotate-box-icon"><i class="fa fa-cloud"></i></span>
							<div class="rotate-box-info">
								<h4>Cloud Hosting</h4>
								<p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
							</div>
						</a>
					</div>
					
					<div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0.6s">
							<span class="rotate-box-icon"><i class="fa fa-pencil"></i></span>
							<div class="rotate-box-info">
								<h4>Coding Pen</h4>
								<p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
							</div>
						</a>
					</div>
					
				</div> <!-- /.row -->
			</div> <!-- /.container -->
			
			<div class="container">
				<!-- Cta Button -->
				<div class="extra-space-l"></div>
				<div class="text-center">
					<a class="btn btn-default btn-lg-xl" href="<%=base %>" target="_blank" role="button">Large Button</a>
				</div>
			</div> <!-- /.container -->                       
		</div>
		<!-- End rotate-box-2 -->
	</section>
	<!-- End Services -->
	
    
    
    
    	<!-- Begin about section -->
	<section id="more-section" class="page bg-style1">
		<!-- Begin page header-->
		<div class="page-header-wrapper">
			<div class="container">
				<div class="page-header text-center wow fadeInUp" data-wow-delay="0.3s">
					<h2>更多信息</h2>
					<div class="devider"></div>
					<p class="subtitle">more information</p>
				</div>
			</div>
		</div>
		<!-- End page header-->

		<!-- Begin rotate box-1 -->
		<div class="rotate-box-1-wrapper">
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0">
							<span class="rotate-box-icon"><i class="fa fa-users"></i></span>
							<div class="rotate-box-info">
								<h4>团队组成</h4>
								<p>我们一支由大学生组建的团队，为保证宠物的健康创造了这种宠物智能检测系统。</p>
                                <!--我们是一支团队，为保证宠物的健康创造了这种宠物智能检测系统。-->
							</div>
						</a>
					</div>

					<div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0.2s">
							<span class="rotate-box-icon"><i class="fa fa-diamond"></i></span>
							<div class="rotate-box-info">
								<h4>研究方向</h4>
								<p>我们专注于宠物数据的实时监控，以确保宠物的主人了解宠物的具体情况。</p>
                                <!--我们专注于宠物数据的实时监控，以确保宠物的主人了解宠物的具体情况-->
							</div>
						</a>
					</div>

					<div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0.4s">
							<span class="rotate-box-icon"><i class="fa fa-heart"></i></span>
							<div class="rotate-box-info">
								<h4>项目背景</h4>
								<p>宠物无法像人类一样，直观的表达出自己身体的不舍情况，更多的病痛需要宠物的主人去主动的发现，为了避免这种情况的发生，从而创建了这个宠物智能化检测的系统。</p>
                                <!--宠物无法像人类一样，直观的表达出自己身体的不舍情况，更多的病痛需要宠物的主人去主动的发现，为了避免这种情况的发生，从而创建了这个宠物智能化检测的系统-->
							</div>
						</a>
					</div>
					
					<div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0.6s">
							<span class="rotate-box-icon"><i class="fa fa-clock-o"></i></span>
							<div class="rotate-box-info">
								<h4>成立时间</h4>
								<p>从2018年十一月下旬，我们的团队正式成立并确定了我们的研究方向。</p>
                                <!--从2018年十一月下旬，我们的小组正式成立并确定了我们的研究方向-->
							</div>
						</a>
					</div>
					
				</div> <!-- /.row -->
			</div> <!-- /.container -->
		</div>
		<!-- End rotate box-1 -->
		
		<div class="extra-space-l"></div>
  </section>
  <!-- End about section -->	  
	<!-- Begin Services -->
	<section id="services-section" class="page text-center">
		<!-- Begin page header-->
		<div class="page-header-wrapper">
			<div class="container">
				<div class="page-header text-center wow fadeInDown" data-wow-delay="0.4s">
					<h2>Services</h2>
					<div class="devider"></div>
					<p class="subtitle">what we really know how</p>
				</div>
			</div>
		</div>
		<!-- End page header-->
	
		<!-- Begin roatet box-2 -->
		<div class="rotate-box-2-wrapper">
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0">
							<span class="rotate-box-icon"><i class="fa fa-mobile"></i></span>
							<div class="rotate-box-info">
								<h4>App Development</h4>
								<p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
							</div>
						</a>
					</div>
	
					<div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0.2s">
							<span class="rotate-box-icon"><i class="fa fa-pie-chart"></i></span>
							<div class="rotate-box-info">
								<h4>Ui Design</h4>
								<p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
							</div>
						</a>
					</div>
	
					<div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0.4s">
							<span class="rotate-box-icon"><i class="fa fa-cloud"></i></span>
							<div class="rotate-box-info">
								<h4>Cloud Hosting</h4>
								<p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
							</div>
						</a>
					</div>
					
					<div class="col-md-3 col-sm-6">
						<a href="<%=base %>#" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0.6s">
							<span class="rotate-box-icon"><i class="fa fa-pencil"></i></span>
							<div class="rotate-box-info">
								<h4>Coding Pen</h4>
								<p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
							</div>
						</a>
					</div>
					
				</div> <!-- /.row -->
			</div> <!-- /.container -->
			
			<div class="container">
				<!-- Cta Button -->
				<div class="extra-space-l"></div>
				<div class="text-center">
					<a class="btn btn-default btn-lg-xl" href="<%=base %>" target="_blank" role="button">Large Button</a>
				</div>
			</div> <!-- /.container -->                       
		</div>
		<!-- End rotate-box-2 -->
	</section>
	<!-- End Services -->
	
	<!-- Begin counter up -->
	<section id="counter-section">                					
		<div id="counter-up-trigger" class="counter-up text-white parallax" data-stellar-background-ratio="0.5" style="background-image: url(<%=base %>img/counter-bg.jpg);">
			<div class="cover"></div>
			
			<div class="container">

				<div class="row">

					<div class="fact text-center col-md-3 col-sm-6">
						<div class="fact-inner">
							<i class="fa fa-users fa-3x"></i>
							<div class="extra-space-l"></div>
							<span class="counter">6666</span>
							<p class="lead">Clients Worked With</p>
						</div>
					</div>

					<div class="fact text-center col-md-3 col-sm-6">
						<div class="fact-inner">
							<i class="fa fa-leaf fa-3x"></i>
							<div class="extra-space-l"></div>
							<span class="counter">800</span>
							<p class="lead">Completed Projects</p>
						</div>
					</div>

					<div class="fact text-center col-md-3 col-sm-6">
						<div class="fact-inner">
							<i class="fa fa-trophy fa-3x"></i>
							<div class="extra-space-l"></div>
							<span class="counter">55</span>
							<p class="lead">Winning Awards</p>
						</div>
					</div>

					<div class="fact last text-center col-md-3 col-sm-6">
						<div class="fact-inner">
							<i class="fa fa-coffee fa-3x"></i>
							<div class="extra-space-l"></div>
							<span class="counter">1100</span>
							<p class="lead">Cups of coffee drinking</p>
						</div>
					</div>

				</div> <!-- /.row -->
			</div> <!-- /.container -->
		</div>
	</section>
	<!-- End counter up -->

		
	<!-- Begin contact section -->
	<section id="contact-section" class="page text-white parallax" data-stellar-background-ratio="0.5" style="background-image: url(<%=base %>img/map-bg.jpg);">
	<div class="cover"></div>
    
    
    
	
		 <!-- Begin page header-->
		<div class="page-header-wrapper">
			<div class="container">
				<div class="page-header text-center wow fadeInDown" data-wow-delay="0.4s">
					<h2>联系我们</h2>
					<div class="devider"></div>
					<p class="subtitle">All to contact us</p>
				</div>
			</div>
		</div>
		<!-- End page header-->
		
		<div class="contact wow bounceInRight" data-wow-delay="0.4s">
			<div class="container">
				<div class="row">
				
					<div class="col-sm-6">
						<div class="contact-info">
							<h4>地址</h4>
							<ul class="contact-address">
								<li><i class="fa fa-map-marker fa-lg"></i>&nbsp; **********,<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 浙江省 ,<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 中国</li>
								<li><i class="fa fa-phone"></i>&nbsp; 1 -234 -456 -7890</li>
								<li><i class="fa fa-print"></i>&nbsp; 1 -234 -456 -7890</li>
								<li><i class="fa fa-envelope"></i> info@secertpet.com</li>
							</ul>
						</div>
					</div>
				
					<div class="col-sm-6">
						<div class="contact-form">
							<h4>留言给我们</h4>
							<form role="form">
								<div class="form-group">
									<input type="text" class="form-control input-lg" placeholder="姓名" required>
								</div>
								<div class="form-group">
									<input type="email" class="form-control input-lg" placeholder="联系方式" required>
								</div>
								<div class="form-group">
									<input type="text" class="form-control input-lg" placeholder="主题" required>
								</div>
								<div class="form-group">
									<textarea class="form-control input-lg" rows="5" placeholder="内容" required></textarea>
								</div>
								<button type="submit" class="btn wow bounceInRight" data-wow-delay="0.8s">发送</button>
							</form>
						</div>	
					</div>
																		
				</div> <!-- /.row -->
			</div> <!-- /.container -->
		</div>
	</section>
	<!-- End contact section -->

	<a href="<%=base %>#" class="scrolltotop"><i class="fa fa-arrow-up"></i></a> <!-- Scroll to top button -->


<!-- Plugins JS -->
<script src="<%=base %>inc/jquery/jquery-1.11.1.min.js"></script>
<script src="<%=base %>inc/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=base %>inc/owl-carousel/js/owl.carousel.min.js"></script>
<script src="<%=base %>inc/stellar/js/jquery.stellar.min.js"></script>
<script src="<%=base %>inc/animations/js/wow.min.js"></script>
<script src="<%=base %>inc/waypoints.min.js"></script>
<script src="<%=base %>inc/isotope.pkgd.min.js"></script>
<script src="<%=base %>inc/classie.js"></script>
<script src="<%=base %>inc/jquery.easing.min.js"></script>
<script src="<%=base %>inc/jquery.counterup.min.js"></script>
<script src="<%=base %>inc/smoothscroll.js"></script>

<!-- Theme JS -->
<script src="<%=base %>js/theme.js"></script>

</body> 
</html>
