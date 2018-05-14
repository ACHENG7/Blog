<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>盼盼小天地</title>

	<link rel="shortcut icon" href="assets/images/gt_favicon.png">
	
	<!-- Bootstrap -->
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.no-icons.min.css" rel="stylesheet">
	<!-- Icon font -->
	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
	<!-- Fonts -->
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Alice|Open+Sans:400,300,700">
	<!-- Custom styles -->
	<link rel="stylesheet" href="assets/css/styles.css">

	<!--[if lt IE 9]> <script src="assets/js/html5shiv.js"></script> <![endif]-->
</head>
<body>

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
			
		<div class="navbar-collapse collapse">

			<ul class="nav navbar-nav">
				<li class="active"><a href="index">首页</a></li>
				<li><a href="Article_findAll">博客</a></li>
				<li><a href="MoodLog_findAllMoodLog">心情日志</a></li>
				<li><a href="single.html">相册</a></li>
				<li><a href="#">留言板</a></li>
				<li><a href="about.html">我的信息</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">详情<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="sidebar-left.html">Left Sidebar</a></li>
						<li><a href="sidebar-right.html">Right Sidebar</a></li>
					</ul></li>
			</ul>

		</div>		
		</div>	
	</nav>
</header>

<main id="main">

	<div class="container">
		
		<div class="row">
			<div class="col-sm-8 col-sm-offset-2">

				<div id="comments">	
					<h3 class="comments-title">${countMoodLog} 条心情说说</h3>
					<a href="#comment-form" class="leave-comment">Leave a Comment</a>
					
					<ol class="comments-list">
					 <s:iterator value="#request.allMoodLogList"  >	
						<li class="comment">					 					  
							<div>
								<img src="assets/images/girl.jpg" alt="Avatar" class="avatar">
												
								<div class="comment-meta">
									<span class="author"><a href="#">盼盼博主</a></span>
									<span class="date"><a href="#"><s:property value="%{getText('{0,date,yyyy年MM月dd日    HH:mm:ss}',{publicDate})}"/></a></span>
									<span class="reply"><a href="#">回复</a></span>
								</div>

								<div class="comment-body">
									<s:property value="content"/>
								</div>
							</div>						
						</li>
                       </s:iterator>	
						
					</ol>
					
						<center class="">
		                	<ul class="pagination">
		                   	${pageSplit}
		                 	</ul>
		               </center>
										
					<div class="clearfix"></div>

					<nav id="comment-nav-below" class="comment-navigation clearfix" role="navigation"><div class="nav-content">
							<div class="nav-previous">&larr; Older Comments</div>
							<div class="nav-next">Newer Comments &rarr;</div>
					</div>
					</nav><!-- #comment-nav-below -->
				</div>
			</div>
		</div> <!-- /row comments -->
		<div class="clearfix"></div>

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


<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="assets/js/template.js"></script>
</body>
</html>
