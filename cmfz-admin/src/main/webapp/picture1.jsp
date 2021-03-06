<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $('#tt_pic').datagrid({
        title:'DataGrid - DetailView',
        width:500,
        height:250,
        fit:true,
        remoteSort:false,
        singleSelect:true,
        nowrap:false,
        fitColumns:true,
        url:"${pageContext.request.contextPath}/picture/findByPage",
        columns:[[
            {field:'picId',title:'标识编号',width:80},
            {field:'picPath',title:'文件名',width:100,sortable:true},
            {field:'picDescription',title:'描述信息',width:80,align:'right',sortable:true},
            {field:'picStatus',title:'轮播图状态',width:80,align:'right',sortable:true},
            {field:'picDate',title:'轮播图创建时间',width:150,sortable:true},
        ]],
        pagination : true,
        pageList : [ 4, 8, 12, 16, 20 ],
        pageSize : 4,
        toolbar : '#tb',
        fitColumns: true,
        singleSelect:true,
        view: detailview,
        detailFormatter: function(rowIndex, rowData){
            return '<table><tr>' +
                /*'<td rowspan=2 style="border:0"><img src="image/' + rowData.picPath + '" style="height:50px;"></td>' +*/
                '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/Files/' + rowData.picPath + '" style="height:50px;"></td>' +
                '<td style="border:0">' +
                '</td>' +
                '</tr></table>';
        }
    });

    $("#btn1").linkbutton({
        onClick:function(){
            var rowData = $("#tt_pic").datagrid("getSelected");
            $("#tb2").dialog({
                title:'修改信息',
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
            $("#tb2").dialog({
				title:'添加信息',
                width:400,
                height:250,
                href:"${pageContext.request.contextPath}/form1.jsp", //包含子页面
            });
        }
    });
</script>
<table id="tt_pic"></table>
<div id="tb" style="display: none">
	<a href="#" id="btn1" class="easyui-linkbutton"
	   data-options="iconCls:'icon-edit',plain:true,text:'修改'"></a>
	<a id="btn2" href="#" class="easyui-linkbutton"
	   data-options="iconCls:'icon-add',plain:true,text:'新增'"></a>
</div>
<div id="tb2"></div>
