
/**
 * 盼盼jquery
*/

/**
 * 评论添加操作
 */



function test123() {
	alert("123");
	var nickname = document.getElementById("nickname").value;
	var content = document.getElementById("content").value;
	alert(nickname+"  "+content);
	
	$.ajax({
		type:"post",
		url:"Blog/blog/reply_insert.action",
		data:"id="+id+"&nickename="+nickname+"&content="+content,
		dataType:"json",
		success:function(data){
			alert(nickname+"  "+content);
			alert(data.msg);
		},
		error:function(jqObj){
			alert("Jqery失败了哦~");
		}
	});
}


/** 文章操作_删除
 * @returns
 */
 function articleDelete(id){
	 $.ajax({
		 type:"post",
		 url:"Blog/blog/article_delete.action",
		 data:"id="+id,
		 dataType:"json",
		 success:function(data){			
	    	  alert(data.msg);
	    	  console.log(data)		    	 
		  },
		 error:function(jqObj){
	    	  console.log(jqObj.status)	    
	    	  alert("Jquery失败哦");
	      }
	 });
	 
 }  

  /**
   * 文章操作
   * author:盼盼
   * @returns
   */
  $("#articleOperation").click(function(){
	  $.ajax({
		  type:"post",
	      url:"Blog/blog/article_findAllArticle.action",
	      dataType:"json",
	      success:function(data){
	    	  console.log(data)
	    	  
	    	    $("#acticleOperation_tbody").html(" ");
	    	
	    	    $.each(data,function(key,value){ 
	    		    
	    	     	var prebody=$("#acticleOperation_tbody").html();
	    	        $("#acticleOperation_tbody").html(prebody+'<tr>'
						+'<td><input type="checkbox" /></td>'
						+'<td>'+value.id+'</td>'
						+'<td><a href="#">'+value.title+'</a></td>'						
						+'<td>'+value.joinTime+'</td>'
						+'<td>'
						+'	<div class="am-btn-toolbar">'
						+'		<div class="am-btn-group am-btn-group-xs">'
						+'			<button  '
						+'				class="am-btn am-btn-default am-btn-xs am-text-secondary">'
						+'				<span class="am-icon-pencil-square-o"></span> 编辑'
						+'			</button>'
						+'			<button class="am-btn am-btn-default am-btn-xs">'
						+'				<span class="am-icon-copy"></span> 复制'
						+'			</button>'
						+'			<button onclick="articleDelete('+value.id+')" '
						+'				class="am-btn am-btn-default am-btn-xs am-text-danger" >'
						+'				<span class="am-icon-trash-o"></span> 删除'
						+'			</button>'
						+'		</div>'
						+'	</div>'
						+'</td>'
						+'</tr>');
	    	      }) 
	    	    	 
	      },
	      error:function(jqObj){
	    	  console.log(jqObj.status)
	    	  
	    	  
	      }
	  });
  });
  
  /**
   * 盼盼jquery
   * 心情操作_删除
   * @returns
   */
   function moodLogDelete(id){
  	 
  	 $.ajax({
  		 type:"post",
  		 url:"Blog/blog/moodLog_delete.action",
  		 data:"moodLogId="+id,
  		 dataType:"json",
  		 success:function(data){
  	    	  console.log(data) 	    	
  	    	  alert(data.msg);
  	    	  
  		  },
  		 error:function(jqObj){
  	    	  console.log(jqObj.status)
  	    	  alert("JQuery失败");
  	      }
  	 });
  	 
   }
  
  /**
   * 心情日志操作
   * author:盼盼
   * @returns
   */
  $("#moodOperation").click(function(){  
	  $.ajax({
		  type:"post",
	      url:"Blog/blog/moodLog_findAll.action",
	      dataType:"json",
	      success:function(data){	    	 
	    	  console.log(data)	
	    	 
	    	    $("#moodLogOperation_tbody").html(" ");
	    	    $.each(data,function(key,value){ 
	    	     	var prebody=$("#moodLogOperation_tbody").html();
	    	        $("#moodLogOperation_tbody").html(prebody+'<tr>'
						+'<td><input type="checkbox" /></td>'
						+'<td>'+value.id+'</td>'
						+'<td><a href="#">'+value.content+'</a></td>'						
						+'<td>'+value.publicDate+'</td>'
						+'<td>'
						+'	<div class="am-btn-toolbar">'
						+'		<div class="am-btn-group am-btn-group-xs">'
						+'			<button  '
						+'				class="am-btn am-btn-default am-btn-xs am-text-secondary">'
						+'				<span class="am-icon-pencil-square-o"></span> 编辑'
						+'			</button>'
						+'			<button class="am-btn am-btn-default am-btn-xs">'
						+'				<span class="am-icon-copy"></span> 复制'
						+'			</button>'
						+'			<button onclick="moodLogDelete('+value.id+')" '
						+'				class="am-btn am-btn-default am-btn-xs am-text-danger" >'
						+'				<span class="am-icon-trash-o"></span> 删除'
						+'			</button>'
						+'		</div>'
						+'	</div>'
						+'</td>'
						+'</tr>');
	    	      }) 
	    	     	 
	      },
	      error:function(jqObj){
	    	  console.log(jqObj.status)
	    	  alert("JQuery失败");
	      }
	  });
  });
 
