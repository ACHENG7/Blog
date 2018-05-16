<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>盼盼Blog后台管理系统</title>
<meta name="description" content="这是一个form页面">
<meta name="keywords" content="form">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/admin.css">
<!-- ueditor -->
    <script type="text/javascript" charset="utf-8" src="/Blog/ueditor1_4_3/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/Blog/ueditor1_4_3/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="/Blog/ueditor1_4_3/lang/zh-cn/zh-cn.js"></script>


</head>
<body>


	<header class="am-topbar admin-header">
	<div class="am-topbar-brand">
		<strong>盼盼博客</strong> <small>后台管理</small>
	</div>

	</header>

	<div class="am-cf admin-main">
		<!-- sidebar start -->
		<!-- sidebar end -->
		<!-- content start -->
		<div class="admin-content">
			<div class="am-cf am-padding">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">操作栏</strong> / <small>form</small>
				</div>
			</div>

			<div class="am-tabs am-margin" data-am-tabs>
				<ul class="am-tabs-nav am-nav am-nav-tabs">
					<li><a href="#tab1" id="articleInsert">文章添加</a></li>
					<li><a href="#tab2" id="moodInsert">心情日志添加</a></li>
					<li><a href="#tab3" id="imagesInsert">图片添加</a></li>
					<li><a href="#tab4" id="articleOperation">文章操作</a></li>
					<li><a href="#tab5" id="moodOperation">心情日志操作</a></li>
					<li><a href="#tab6" id="imagesOperation">图片操作</a></li>
				</ul>
				<!-- 博客添加页面 -->
				<div class="am-tabs-bd">
					<div class="am-tab-panel am-fade am-in am-active" id="tab1">
						<form class="am-form" action="article_insert.action" method="post">
							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">标题</div>
								<div class="am-u-sm-4">
									<input type="text" class="am-input-sm" name="title">
								</div>
								<div class="am-u-sm-6">*必填，不可重复</div>
							</div>
							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">类型</div>
								<div class="am-u-sm-4">
									<select class="am-input-sm">
										<option></option>
									</select>
								</div>
								<div class="am-u-sm-6"></div>
							</div>

							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">内容摘要</div>
								<div class="am-u-sm-4">
									<input type="text" class="am-input-sm">
								</div>
								<div class="am-u-sm-6">不填写则自动截取内容前255字符</div>
							</div>

							<div class="am-g am-margin-top-sm">
								<div class="am-u-sm-2 am-text-right">内容</div>
								<div class="am-u-sm-10">         
                                   <script id="editor" type="text/plain" style="width:800px;height:500px;" name="content"></script>
                                 </div>
                                 <!--  
								<div class="am-u-sm-10">
									<textarea rows="10" placeholder="请使用富文本编辑插件" name="content"></textarea>
								</div>
								-->
							</div>
							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">${request.msg}</div>
							</div>
							<div class="am-margin">
								<button type="submit" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
								<button type="reset" class="am-btn am-btn-primary am-btn-xs">放弃保存</button>
							</div>
						</form>
					</div>
					<!-- 博客添加end -->

					<!-- 心情日志添加start -->
					<div class="am-tab-panel am-fade" id="tab2">
					  <form class="am-form" action="moodLog_insert.action" method="post">
							
							<div class="am-g am-margin-top-sm">
								<div class="am-u-sm-2 am-text-right">内容</div>
								<div class="am-u-sm-10">
									<textarea rows="10" placeholder="请使用富文本编辑插件" name="moodLogContent"></textarea>
								</div>
							</div>
							<div class="am-g am-margin-top">
								<div class="am-u-sm-2 am-text-right">${request.msg}</div>
							</div>
							<div class="am-margin">
								<button type="submit" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
								<button type="reset" class="am-btn am-btn-primary am-btn-xs">放弃保存</button>
							</div>
						</form>
					</div>
					<!-- 心情日志添加end -->
					<!-- 图片添加start -->
					<div class="am-tab-panel am-fade" id="tab3">
						<form class="am-form" action="images_insert" method="post" enctype="multipart/form-data">
							<div class="am-g am-margin-top-sm">
								<div class="am-u-sm-2 am-text-right"> 标题</div>
								<div class="am-u-sm-4 am-u-end">
									<input type="text" class="am-input-sm" name="title">
								</div>
							</div>

							<div class="am-g am-margin-top-sm">
								<div class="am-u-sm-2 am-text-right">内容</div>
								<div class="am-u-sm-4 am-u-end">
									<input type="text" class="am-input-sm" name="content">
								</div>
							</div>

							<div class="am-g am-margin-top-sm">
								<div class="am-u-sm-2 am-text-right">图片添加</div>
								<div class="am-u-sm-4 am-u-end">
									<input type="file" name="uploadImages">
								</div>
							</div>
							<div class="am-margin">
								<button type="submit" class="am-btn am-btn-primary am-btn-xs">提交保存</button>								
							</div>
						</form>
					</div>
					<!-- 相册添加end -->
					<!-- 博客的综合管理操作start -->

					<div class="am-tab-panel am-fade" id="tab4">
						<div class="admin-content">
							<div class="am-g">
								<div class="am-g">
									<div class="am-u-md-6 am-cf">
										<div class="am-fl am-cf">
											<div class="am-btn-toolbar am-fl">
												<div class="am-btn-group am-btn-group-xs">
													<button type="button" class="am-btn am-btn-default">
														<span class="am-icon-plus"></span> 新增
													</button>
													<button type="button" class="am-btn am-btn-default">
														<span class="am-icon-save"></span> 保存
													</button>
													<button type="button" class="am-btn am-btn-default">
														<span class="am-icon-archive"></span> 审核
													</button>
													<button type="button" class="am-btn am-btn-default">
														<span class="am-icon-trash-o"></span> 删除
													</button>
												</div>

												<div class="am-form-group am-margin-left am-fl">
													<select>
														<option value="option1">所有类别</option>
														<option value="option2">IT业界</option>
														
													</select>
												</div>
											</div>
										</div>
									</div>
									<div class="am-u-md-3 am-cf">
										<div class="am-fr">
											<div class="am-input-group am-input-group-sm">
												<input type="text" class="am-form-field"> <span
													class="am-input-group-btn">
													<button class="am-btn am-btn-default" type="button">搜索</button>
												</span>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="am-g">
								<div class="am-u-sm-12">
									<form class="am-form">
										<table
											class="am-table am-table-striped am-table-hover table-main">
											<thead>
												<tr>
													<th class="table-check"><input type="checkbox" /></th>
													<th class="table-id">ID</th>
													<th class="table-title">标题</th>

													<th class="table-date">修改日期</th>
													<th class="table-set">操作</th>
												</tr>
											</thead>
											<tbody id="acticleOperation_tbody">


											</tbody>
										</table>
										<div class="am-cf">
											共 15 条记录
											<div class="am-fr">
												<ul class="am-pagination">
													<li class="am-disabled"><a href="#">«</a></li>
													<li class="am-active"><a href="#">1</a></li>
													<li><a href="#">2</a></li>
													<li><a href="#">3</a></li>
													<li><a href="#">4</a></li>
													<li><a href="#">5</a></li>
													<li><a href="#">»</a></li>
												</ul>
											</div>
										</div>
										<hr />
									</form>
								</div>

							</div>
						</div>
					</div>

					<!-- 博客综合管理操作end -->

					<!-- 心情日志操作start -->
					<div class="am-tab-panel am-fade" id="tab5">
					  <div class="admin-content">
							<div class="am-g">
								<div class="am-g">
									<div class="am-u-md-6 am-cf">
										<div class="am-fl am-cf">
											<div class="am-btn-toolbar am-fl">
												<div class="am-btn-group am-btn-group-xs">
													<button type="button" class="am-btn am-btn-default">
														<span class="am-icon-plus"></span> 新增
													</button>
													<button type="button" class="am-btn am-btn-default">
														<span class="am-icon-save"></span> 保存
													</button>
													<button type="button" class="am-btn am-btn-default">
														<span class="am-icon-archive"></span> 审核
													</button>
													<button type="button" class="am-btn am-btn-default">
														<span class="am-icon-trash-o"></span> 删除
													</button>
												</div>

												<div class="am-form-group am-margin-left am-fl">
													<select>
														<option value="option1">所有类别</option>
														<option value="option2">IT业界</option>
														
													</select>
												</div>
											</div>
										</div>
									</div>
									<div class="am-u-md-3 am-cf">
										<div class="am-fr">
											<div class="am-input-group am-input-group-sm">
												<input type="text" class="am-form-field"> <span
													class="am-input-group-btn">
													<button class="am-btn am-btn-default" type="button">搜索</button>
												</span>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="am-g">
								<div class="am-u-sm-12">
									<form class="am-form">
										<table
											class="am-table am-table-striped am-table-hover table-main">
											<thead>
												<tr>
													<th class="table-check"><input type="checkbox" /></th>
													<th class="table-id">ID</th>
													<th class="table-title">说说</th>
													<th class="table-date">发布日期</th>
													<th class="table-set">操作</th>
												</tr>
											</thead>
											<tbody id="moodLogOperation_tbody">


											</tbody>
										</table>
										<div class="am-cf">
											共 15 条记录
											<div class="am-fr">
												<ul class="am-pagination">
													<li class="am-disabled"><a href="#">«</a></li>
													<li class="am-active"><a href="#">1</a></li>
													<li><a href="#">2</a></li>
													<li><a href="#">3</a></li>
													<li><a href="#">4</a></li>
													<li><a href="#">5</a></li>
													<li><a href="#">»</a></li>
												</ul>
											</div>
										</div>
										<hr />
									</form>
								</div>

							</div>
						</div>
					</div>
					<!-- 心情日志操作end -->
					<!-- 图片操作strat -->
					<div class="am-tab-panel am-fade" id="tab6"></div>
					<!-- 图片操作end -->
				</div>
			</div>


		</div>
		<!-- content end -->

	</div>


	<footer>
	<hr>
	<p class="am-padding-left">© 2018 浮生如梦博客后台管理系统.---盼盼</p>
	</footer>


	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<!--<![endif]-->
	<script src="assets/js/app.js"></script>
	
	<script src="assets/js/lpp.js"></script>
	
	<script type="text/javascript">  
  
    //实例化编辑器  
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例  
    var ue = UE.getEditor('editor');  
  
  
    function getContent() {  
        var arr = [];  
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");  
        arr.push("内容为：");  
        arr.push(UE.getEditor('editor').getContent());  
        alert(arr.join("\n"));  
    }  
  
</script> 
</body>
</html>
