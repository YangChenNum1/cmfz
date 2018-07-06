<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
	$(function(){
		$("#btn11").linkbutton({
			iconCls:"icon-edit",
			onClick:function(){
				$("#ff").form("submit",{
					url:"${pageContext.request.contextPath}/picture/modify",
					onSubmit:function(){
						return $("#ff").form("validate");
					},
					success:function(res){
						var d=JSON.parse(res);
						if(d.result!=null){
                            $("#tt_pic").datagrid({
                                url : "${pageContext.request.contextPath}/picture/findByPage"
                            });
                            $("#tb2").dialog('close');
						}else{
							location.href="${pageContext.request.contextPath}/form.jsp";
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
			<td>轮播图标识:</td>
			<td><input class="easyui-textbox" size=30 style="background-color:transparent" name="picId" data-options="required:true" readonly></td>
		</tr>
		<tr>
			<td>轮播图描述:</td>
			<td><input class="easyui-textbox" size=30 style="background-color:transparent" name="picDescription" data-options="required:true"></td>
		</tr>
		<tr>
			<td>轮播图状态:</td>
			<td><input class="easyui-textbox" size=30 style="background-color:transparent" name="picStatus" data-options="required:true"></td>
		</tr>
		<tr>
			<td>轮播图命名:</td>
			<td><input class="easyui-textbox" size=30 style="background-color:transparent" name="picPath" data-options="required:true"></td>
		</tr>
		<tr>
			<td colspan="2"><a id="btn11" >修改</a></td>
		</tr>
	</table>	
</form>

<%--
<form action="${pageContext.request.contextPath}/manager/upload.do" method="post" enctype="multipart/form-data">

	<input type="file" name="myfile"><br/><br/><br/>

	<input type="submit" value="upload">

</form>--%>
