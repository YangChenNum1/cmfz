<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">
	$(function() {
		// 数据表格 加载远程数据 数据来源数据库
		$("#table1").datagrid({
			url : "${pageContext.request.contextPath}/picture/findByPage",
			columns : [ [ {
				title : "标识编号",
				field : "picId",
				width:50,
			}, {
				title : "文件名",
				field : "picPath",
				width:50,
			}, {
				title : "描述信息",
				field : "picDescription",
				width:50,
			}, {
                title : "轮播图状态",
                field : "picStatus",
                width:50,
            }, {
                title : "轮播图创建时间",
                field : "picDate",
                width:50,
            },{field:"operation",title:"操作",formatter:function(value,row,index){ // 格式化展示数据到对应的列
				return "<a id='btn1'>删除</a><a id='btn2'>查看详情</a>";
			}}] ],
			pagination : true,
			pageList : [ 4, 8, 12, 16, 20 ],
			pageSize : 4,
			toolbar : "#tb",
			fitColumns: true,
			singleSelect:true,
		});
		
		$("#btn1").linkbutton({
			onClick:function(){
				var rowData = $("#table1").datagrid("getSelected");
				alert(rowData);
				$("#tb").dialog({
					width:400,
					height:250,
					href:"${pageContext.request.contextPath}/form.jsp", //包含子页面
					onLoad:function(){
						$("#ff").form("load",rowData); //在加载表单时将行数据加载到表单元素中
					}
				});
			}
		});
		
		$("#btn2").linkbutton({
			onClick:function(){
				$("#tb").dialog({
					width:400,
					height:250,
					href:"${pageContext.request.contextPath}/form.jsp", //包含子页面
				});
			}
		});
	});
	
	/*function qq(value,name) {
		alert(value + ":" + name);
		$("#table1").datagrid({
			url : "http://localhost:8080/SSM_Easyui/manager/findByPageMohu.do?value="+value+"&name="+name,
		});
	} */
	
	/*function remove(){
		var rowData = $("#table1").datagrid("getSelected");
		var username=rowData.username;
		alert(username);
		$.get("/SSM_Easyui/manager/drop.do",{username:""+username},function(data){
			$("#table1").datagrid({
				url : "http://localhost:8080/SSM_Easyui/manager/findByPage.do",
			});
		});
	}*/
</script>

	<table id="table1"></table>
	<div id="tb" style="display: none">
		<a href="#" id="btn1" class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true,text:'修改'"></a> <a
			id="btn2" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true,text:'新增'"></a>
	</div>
