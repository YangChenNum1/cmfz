<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
	$(function(){
		$("#btn11").linkbutton({
			iconCls:"icon-edit",
			onClick:function(){
				$("#ff").form("submit",{
					url:"/SSM_Easyui/manager/modify.do",
					onSubmit:function(){
						return $("#ff").form("validate");
					},
					success:function(res){
						var d=JSON.parse(res);
						if(d.result!=null){
							location.href="${pageContext.request.contextPath}/main.jsp";
						}else{
							location.href="${pageContext.request.contextPath}/error.jsp";
						}
					}
					
				});
			}
		});	
		
		$("#btn22").linkbutton({
			iconCls:"icon-add",
			onClick:function(){
				$("#ff").form("submit",{
					url:"/SSM_Easyui/manager/insert.do",
					onSubmit:function(){
						return $("#ff").form("validate");
					},
					success:function(res){
						var d=JSON.parse(res);
						if(d.result!=null){
							location.href="${pageContext.request.contextPath}/main.jsp";
						}else{
							location.href="${pageContext.request.contextPath}/error.jsp";
						}
					}
					
				});
			}
		});	
	});
</script>

<form id="ff" method="post" >
	<table style="text-align: center" border="1px" id="table1" width="400px">
		<tr>
			<td>用户名:</td>
			<td><input class="easyui-textbox" size=20 style="background-color:transparent" name="username" data-options="required:true"></td>
		</tr>
		<tr>
			<td>密&nbsp;码:</td>
			<td><input class="easyui-textbox" name="password" size=20 style="background-color:transparent" data-options="required:true"></td>
		</tr>
		<tr>
			<td>盐&nbsp;:</td>
			<td><input class="easyui-textbox" name="salt" size=20 style="background-color:transparent" data-options="required:true"></td>
		</tr>
		<tr>
			<td><a id="btn11">修改</a></td>
			<td><a id="btn22">添加</a></td>
		</tr>
	</table>	
</form>