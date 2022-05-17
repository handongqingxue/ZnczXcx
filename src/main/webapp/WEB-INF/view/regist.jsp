<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新用户注册</title>
<%@include file="inc/js.jsp"%>
<script type="text/javascript">
$(function(){
	
});
</script>
<style>
.register_content {
	width: 53%;
	margin: auto;
	background-color: #fff;
	border-radius: 3px;
}

body .beg-login-bg {
	position: inherit;
	overflow: auto;
}

.beg-login-bg {
	background-color: #393D49;
}

.register_title {
	padding: 10px 0 20px 0;
}

.register {
	margin-top: 100px;
}

.register-form {
	padding: 20px;
	border-radius: 5px;
	width: 90%;
	max-width: 1080px;
	margin: auto;
}

.title {
	font-size: 21px;
	font-weight: 600;
	text-align: center;
}

.layui-form-item>label {
	font-size: 14px;
	width: 90px;
	font-weight: 600;
}

.layui-form-item>.layui-input-block {
	margin-left: 120px;
}

.layui-form {
	width: 90%
}
</style>
</head>
<body class="beg-login-bg">
	<div class="register">
		<div class="register_content register-form">
			<div class="register_title">
				<h2 class="title">智能称重平台系统注册</h2>
			</div>
			<form class="layui-form" method="post">
				<input type="hidden" name="action" value="${param.action }"/>
				<input type="hidden" name="price" value="${param.price }"/>
				<div class="layui-form-item">
					<label class="layui-form-label">企业号</label>
					<div class="layui-input-inline">
						<input type="text" name="qyh" required lay-verify="required|qyh"
							placeholder="请输入企业号" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">该企业号将作为登录账号使用</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">密码:</label>
					<div class="layui-input-inline">
						<input type="password" name="mm" id="mm" required
							lay-verify="required" placeholder="请输入密码" autocomplete="off"
							class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">请确保两次输入密码一致</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">确认密码:</label>
					<div class="layui-input-inline">
						<input type="password" name="mm1" id="mm1" required
							lay-verify="required|same_mm" placeholder="请再次输入密码" autocomplete="off"
							class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">请确保两次输入密码一致</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">企业名称</label>
					<div class="layui-input-inline">
						<input type="text" name="mc" required lay-verify="required"
							placeholder="请输入企业名称" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">简述</label>
					<div class="layui-input-inline">
						<input type="text" name="js" required lay-verify="required"
							placeholder="请输入简述" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
		<div style="height: 1px;width: 100%;background-color: #00f;margin-top: -88px;"></div>
	</div>
	<script type="text/javascript" src="<%=basePath %>resource/js/MD5.js"></script>
	<script type="text/javascript">
	var baseUrl="${pageContext.request.contextPath}"
		layui.use('form', function() {
			var form = layui.form;

			//监听提交
			form.on('submit(formDemo)', function(data) {
				url=baseUrl+"/main/regist"
				data.field.mm=MD5(data.field.mm).toUpperCase();
				$.post(url,data.field,function(result){
					console.log(result)
					if(result.status==0){
						window.location.href=baseUrl+result.url
					}else if(result.status==2){
						alert(result.msg)
					}
				},"json")
				console.log("===111===")
				return false
			});
			 form.verify({
					qyh:function(value){
						return '企业号已存在';
					},
		            //验证密码是否一样
		            same_mm: function (value) {
		                var pass1 = $("#mm").val();
		                if (value !== pass1) {
		                    return '两次输入密码不一致';
		                }
		            }
		        });
		})
	</script>
</body>
</html>