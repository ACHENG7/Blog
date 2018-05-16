<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>盼盼的小天地</title>

	<link rel="shortcut icon" href="assets/images/gt_favicon.png">
	
	<!-- Bootstrap -->
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.no-icons.min.css" rel="stylesheet">
	<!-- Icons -->
	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
	<!-- Fonts -->
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Alice|Open+Sans:400,300,700">
	<!-- Custom styles -->
	<link rel="stylesheet" href="assets/css/styles.css">
	<!-- 自加样式 -->
	<link rel="stylesheet" href="assets/css/lpp.css">
	
	

	<!--[if lt IE 9]> <script src="assets/js/html5shiv.js"></script> <![endif]-->
</head>
<body class="home">

<header id="header">
	<div id="head" class="parallax" parallax-speed="2">
		<h1 id="logo" class="text-center">
			<img class="img-circle" src="assets/images/guy.jpg" alt="">
			<span class="title">浮生追梦</span>
			<span class="tagline">个人网站<br>
				<a href="">lp995968535@qq.com</a></span>
		</h1>
	</div>

	<nav class="navbar navbar-default navbar-sticky">
		<div class="container-fluid">
			
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
			</div>
			
			<div class="navbar-collapse collapse ">
				
				<ul class="nav navbar-nav">
					<li class="active"><a href="index">首页</a></li>
					<li><a href="Article_findAll">博客</a></li>
					<li><a href="MoodLog_findAllMoodLog">心情日志</a></li>
					<li><a href="#">相册</a></li>
					<li><a href="message_findAll">留言板</a></li>
					<li><a href="about.html">我的信息</a></li>							
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">详情<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="sidebar-left.html">Left Sidebar</a></li>
							<li><a href="sidebar-right.html">Right Sidebar</a></li>							
						</ul>
					</li>
				</ul>
			
			</div><!--/.nav-collapse -->			
		</div>	
	</nav>
</header>

<main id="main">

	<div class="container">
		
		<div class="row section topspace">
			<div class="col-md-12">
				<p class="lead text-center text-muted">把这里当做你的吧 <a href="about.html">树洞</a>吧~ 尽情的在这个畅所欲言，留下你来过的痕迹 <a href="sidebar-right.html">(๑＞ ＜)☆</a>. </p>
			</div>
		</div> <!-- / section -->
		
		<div class="row section featured topspace">
			<h2 class="section-title"><span>博客</span></h2>
			<div class="row">
			   <s:iterator value="#request.newArticleList" var="n">
				<div class="col-sm-6 col-md-3 ">
				<!-- 标题限制两行 -->
					<h3 class="text-center wordsHide2" ><s:property value="title"/> </h3>					
					${n.content}				
					<p class="text-center"><a href="Article_getArticle?id=<s:property value="id"/>"  class="btn btn-action">Read more</a></p>
				</div>
				</s:iterator>
			</div>
		</div> <!-- / section -->
	
		<div class="row section recentworks topspace">
			
			<h2 class="section-title"><span>相 册</span></h2>
			
			<div class="thumbnails recentworks row">
			
				<s:iterator value="#request.newImagesList">
				<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
					<a class="thumbnail" href="#">
						<span class="img">
							<img  src='<s:property value='imagePath' />' alt="">
							<span class="cover"><span class="more">查 看 详 情 &rarr;</span></span>
						</span>
						<span class="title">相 册 信 息</span>
					</a>
					<span class="details"><a href="">(๑╹∀╹๑)</a> | <a href="">生 活 照</a> | <a href="">(๑╹∀╹๑)</a></span>
					<h4></h4>
					<p></p>
				</div>
				</s:iterator>
				
		
			</div>

		</div> <!-- /section -->

		<div class="row section topspace">
			<div class="panel panel-cta"><div class="panel-body">
				<div class="col-lg-8">
					<p>人 生 得 意 须 尽 欢 ，莫 使 金 樽 空 对 月。
                                                          天 生 我 材 必 有 用，千 金 散 尽 还 复 来。 </p>
				</div>
				<div class="col-lg-4 text-right">
					<a href="#/downloads/initio.zip " class="btn btn-primary btn-lg">李   白</a>
				</div>
			</div></div>
		</div> <!-- /section -->

		<div class="row section clients topspace">
			<h2 class="section-title"><span>Clients</span></h2>
			<div class="col-lg-12">
				<p>
					<img src="assets/images/sample_clients.png" alt="">
				</p>
			</div>
		</div> <!-- /section -->

	</div>	<!-- /container -->

</main>

<footer id="footer">
	<div class="container">
		<div class="row">
			<div class="col-md-3 widget">
				<h3 class="widget-title">联 系</h3>
				<div class="widget-body">
					<p>+ 995968535<br>
						<a href="mailto:#">lp995968535@qq.com</a><br>
						<br>
						At HeNan City,ZhuMaDian 47300 
					</p>	
				</div>
			</div>

			<div class="col-md-3 widget">
				<h3 class="widget-title">导 航</h3>
				<div class="widget-body">
					<p class="follow-me-icons">
						<a href=""><i class="fa fa-twitter fa-2"></i></a>
						<a href=""><i class="fa fa-dribbble fa-2"></i></a>
						<a href=""><i class="fa fa-github fa-2"></i></a>
						<a href=""><i class="fa fa-facebook fa-2"></i></a>
					</p>
				</div>
			</div>

			<div class="col-md-3 widget">
				<h3 class="widget-title">文 本 </h3>
				<div class="widget-body">
					<p>一切为了学习</p>
					<p>不足之处望大家多多与我交流，我回努力完善的~.~</p>
				</div>
			</div>

			<div class="col-md-3 widget">
				<h3 class="widget-title">文 本</h3>
				<div class="widget-body">
					<p>+ 995968535<br>
						<a href="mailto:#">lp995968535@qq.com</a><br>
						<br>
						微信联系方式：LIPANer-
					</p>	
				</div>
			</div>

		</div> <!-- /row of widgets -->
	</div>
</footer>

<footer id="underfooter">
	<div class="container">
		<div class="row">
			
			<div class="col-md-6 widget">
				<div class="widget-body">
					<p>At HuangHuai University(黄淮学院)</p>
				</div>
			</div>

			<div class="col-md-6 widget">
				<div class="widget-body">
					<p class="text-right">
						Copyright &copy; 2018, 盼盼个人博客网站<br> 
						
				</div>
			</div>

		</div> <!-- /row of widgets -->
	</div>
</footer>

<script src="assets/js/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

<script src="assets/js/template.js"></script>
<script src="assets/js/lpp.js"></script>
<!-- JavaScript libs are placed at the end of the document so the pages load faster -->

</body>
</html>
