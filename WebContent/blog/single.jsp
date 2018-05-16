<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">


<title>盼盼个人博客网站</title>


<!-- ueditor -->
<script type="text/javascript">
     document.write("<scr"+"ipt src=\"${pageContext.request.contextPath}/ueditor1_4_3/ueditor.config.js\"></sc"+"ript>")
     document.write("<scr"+"ipt src=\"/Blog/ueditor1_4_3/ueditor.all.min.js\"></sc"+"ript>")
     document.write("<scr"+"ipt src=\"/Blog/ueditor1_4_3/lang/zh-cn/zh-cn.js\"></sc"+"ript>")
</script>



<link rel="shortcut icon" href="assets/images/gt_favicon.png">

<!-- Bootstrap -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.no-icons.min.css"
	rel="stylesheet">
<!-- Icon font -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">
<!-- Fonts -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Alice|Open+Sans:400,300,700">
<!-- Custom styles -->
<link rel="stylesheet" href="assets/css/styles.css">





<!--[if lt IE 9]> <script src="assets/js/html5shiv.js"></script> <![endif]-->
</head>
<body>

	<header id="header">
	<div id="head" class="parallax" parallax-speed="2">
		<h1 id="logo" class="text-center">
			<img class="img-circle" src="assets/images/guy.jpg" alt=""> <span
				class="title">浮生追梦</span> <span class="tagline">个人网站<br>
				<a href="">lp995968535@qq.com</a></span>
		</h1>
	</div>

	<nav class="navbar navbar-default navbar-sticky">
	<div class="container-fluid">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="navbar-collapse collapse">

			<ul class="nav navbar-nav">
				<li class="active"><a href="index">首页</a></li>
				<li><a href="Article_findAll">博客</a></li>
				<li><a href="MoodLog_findAllMoodLog">心情日志</a></li>
				<li><a href="#">相册</a></li>
				<li><a href="message_findAll">留言板</a></li>
				<li><a href="about.html">我的信息</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">详情<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="sidebar-left.html">Left Sidebar</a></li>
						<li><a href="sidebar-right.html">Right Sidebar</a></li>
					</ul></li>
			</ul>

		</div>
		<!--/.nav-collapse -->
	</div>
	</nav> </header>

	<main id="main">

	<div class="container">

		<div class="row topspace">
			<div class="col-sm-8 col-sm-offset-2">

				<article class="post"> <header class="entry-header">
				<div class="entry-meta">
					<span class="posted-on"><time class="entry-date published"
							date="2013-06-17">${article.joinTime}</time></span>
				</div>
				<h1 class="entry-title">
					<a href="single.html" rel="bookmark">${article.title} </a>
				</h1>
				</header>
				<div class="entry-content">${article.content}</div>
				</article>
				<!-- #post-## -->

			</div>
		</div>
		<!-- /row post  -->

		<div class="row">
			<div class="col-sm-8 col-sm-offset-2">

				<div id="comments">
					<s:if test="%{#request.countReply!=0}">
						<h3 class="comments-title">共 有 ${countReply }条 评 论</h3>
						<a href="#respond" class="leave-comment">Leave a Comment</a>
					</s:if>
					<s:if test="%{#request.countReply==0}">
						<h5 class="comments-title">还没有评论哦~</h5>
						<a href="#respond" class="leave-comment">Leave a Comment</a>
					</s:if>


					<ol class="comments-list">
				   <!--  <c:forEach items="${replyList}" var="r">
							<li class="comment">
								<div>
									<img src="assets/images/reply.jpg" alt="Avatar" class="avatar">

									<div class="comment-meta">
										<span class="author"><a href="#">${r.nickname} </a></span> <span
											class="date"><a href="#">${r.replyTime } </a></span> <span
											class="reply"><a href="#">回 复</a></span>
									</div>

									<div class="comment-body">${r.content}</div>
								</div>

							</li>
						</c:forEach>
						-->
						<s:iterator value="#request.replyList">
							<li class="comment">
								<div>
									<img src="assets/images/reply.jpg" alt="Avatar" class="avatar">

									<div class="comment-meta">
										<span class="author"><a href="#"><s:property
													value="nickname" /> </a></span> <span class="date"><a href="#"><s:property
													value="%{getText('{0,date,yyyy年MM月dd日 HH:mm}',{replyTime})}" />
										</a></span> <span class="reply"><a href="#">回 复</a></span>
									</div>

									<div class="comment-body">
										<s:property value="content" />

									</div>
								</div> <!--
							<ul class="children">
								<li class="comment">
									<div>
										<img src="assets/images/avatar_man.png" alt="Avatar" class="avatar">
																
										<div class="comment-meta">
											<span class="author"><a href="#">John Doe</a></span>
											<span class="date"><a href="#">January 22, 2011 at 4:55 pm</a></span>
											<span class="reply"><a href="#">Reply</a></span>
										</div>

										<div class="comment-body">
											Morbi velit eros, sagittis in facilisis non, rhoncus et erat. Nam posuere tristique sem, eu ultricies tortor imperdiet vitae. Curabitur lacinia neque non metus.
										</div>
									</div>
								</li>
							</ul>   .children -->
							</li>
						</s:iterator>

					</ol>

					<div class="clearfix"></div>

					<nav id="comment-nav-below" class="comment-navigation clearfix"
						role="navigation">
					<div class="nav-content">
						<div class="nav-previous">&larr; Older Comments</div>
						<div class="nav-next">Newer Comments &rarr;</div>
					</div>
					</nav>
					<!-- #comment-nav-below -->


					<div id="respond">
						<h3 id="reply-title">评 论</h3>
						<!-- reply_insert?id=${article.id} -->
						
							
							<div class="form-group">
								<label for="inputName">昵 称</label> 
								<input type="text"
									class="form-control" id="nickname"
									placeholder="Enter your name">
							</div>


							<div class="form-group ">
								<label for="inputComment">内 容</label>
								 <textarea rows="6" class="form-control" id="content"></textarea> 
								<!--<script id="editor" type="text/plain"
									style="width:600px;height:500px;" name="content"></script>
								<script type="text/javascript">  
                                  var ue = UE.getEditor('editor');  
                                 function getContent() {  
                                 var arr = [];  
                                 arr.push("使用editor.getContent()方法可以获得编辑器的内容");  
                                 arr.push("内容为：");  
                                 arr.push(UE.getEditor('editor').getContent());  
                                alert(arr.join("\n"));  
                                 }  
  
                             </script>
                             -->
							</div>

							<div class="row">
								<div class="col-md-8">
									<div class="checkbox">
										<label> <input type="checkbox"> 保 存 编 辑
										</label>
									</div>
								</div>
								<div class="col-md-4 text-right">
								   
									<button onclick="ReplyInsert(${article.id})" type="submit" class="btn btn-action">
										发 送</button>
							   </div>
					
					</div>
					<!-- /respond -->
				</div>
			</div>
		</div>
		<!-- /row comments -->
		<div class="clearfix"></div>

	</div>
	<!-- /container --> </main>


	<footer id="footer">
	<div class="container">
		<div class="row">
			<div class="col-md-3 widget">
				<h3 class="widget-title">联 系</h3>
				<div class="widget-body">
					<p>
						+ 995968535<br> <a href="mailto:#">lp995968535@qq.com</a><br>
						<br> At HeNan City,ZhuMaDian 47300
					</p>
				</div>
			</div>

			<div class="col-md-3 widget">
				<h3 class="widget-title">导 航</h3>
				<div class="widget-body">
					<p class="follow-me-icons">
						<a href=""><i class="fa fa-twitter fa-2"></i></a> <a href=""><i
							class="fa fa-dribbble fa-2"></i></a> <a href=""><i
							class="fa fa-github fa-2"></i></a> <a href=""><i
							class="fa fa-facebook fa-2"></i></a>
					</p>
				</div>
			</div>

			<div class="col-md-3 widget">
				<h3 class="widget-title">文 本</h3>
				<div class="widget-body">
					<p>一切为了学习</p>
					<p>不足之处望大家多多与我交流，我回努力完善的~.~</p>
				</div>
			</div>

			<div class="col-md-3 widget">
				<h3 class="widget-title">文 本</h3>
				<div class="widget-body">
					<p>
						+ 995968535<br> <a href="mailto:#">lp995968535@qq.com</a><br>
						<br> 微信联系方式：LIPANer-
					</p>
				</div>
			</div>

		</div>
		<!-- /row of widgets -->
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

		</div>
		<!-- /row of widgets -->
	</div>
	</footer>


   	<!-- jqery处理请求 -->
<script src="assets/js/lpp.js"></script>
<script src="assets/js/jquery.min.js"></script>
<script type="text/javascript">
function ReplyInsert(id){
	
	var nickname = document.getElementById("nickname").value;
	var content = document.getElementById("content").value;
	
	 $.ajax({
		type:"post",
		url:"Blog/blog/reply_insert.action",
		data:{id:id,nickname:nickname,content:content},
		dataType:"json",
		success:function(data){	
		 	location.reload();
			alert(data.msg); 
		},
		error:function(jqObj){
			 alert("Jqery失败了哦~");
			location.reload(); 
		}
	}); 
	
	 
}



</script>
	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="assets/js/template.js"></script>




</body>
</html>
