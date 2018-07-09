<%@ page language="java" contentType="text/html;charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false"%>
<script type="text/javascript">
    $('#tt_guru').datagrid({
        title:'上师管理',
        width:500,
        height:250,
        remoteSort:false,
        singleSelect:true,
        nowrap:false,
        fitColumns:true,
        url:"${pageContext.request.contextPath}/guru/findByPage",
        columns:[[
            {field:'guruId',title:'上师编号',width:80},
            {field:'guruName',title:'上师法名',width:100,sortable:true},
            {field:'guruPhoto',title:'上师头像',width:80,align:'right',sortable:true},
            {field:'guruSummer',title:'上师简述',width:80,align:'right',sortable:true}
        ]],
        pagination : true,
        pageList : [2,4,6,8],
        pageSize : 4,
        fit:true,
        toolbar : "#tb_guru",
        fitColumns: true,
        singleSelect:true,
        view: detailview,
        detailFormatter: function(rowIndex, rowData){
            return '<table><tr>' +
                /*'<td rowspan=2 style="border:0"><img src="image/' + rowData.picPath + '" style="height:50px;"></td>' +*/
                '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/Files/' + rowData.guruPhoto + '" style="height:50px;"></td>' +
                '<td style="border:0">' +
                '</td>' +
                '</tr></table>';
        }/*,
        toolbar: [{
            iconCls: 'icon-edit',
            handler: function(){alert('编辑按钮')},
			text:'编辑'
        },'-',{
            iconCls: 'icon-help',
            handler: function(){alert('帮助按钮')},
            text:'帮助'
        },'-',{
            iconCls: 'icon-ok',
            handler: function(){alert('添加按钮')},
            text:'添加'
        }]*/
    });

    $("#btn1").linkbutton({
        onClick:function(){
            var rowData = $("#tt_guru").datagrid("getSelected");
            $("#tb2_guru").dialog({
                title:'修改信息',
                width:400,
                height:250,
                href:"${pageContext.request.contextPath}/guruUp.jsp", //包含子页面
                onLoad:function(){
                    $("#ff").form("load",rowData); //在加载表单时将行数据加载到表单元素中
                }
            });
        }
    });

    $("#btn2").linkbutton({
        onClick:function(){
            $("#tb2_guru").dialog({
				title:'添加信息',
                width:400,
                height:250,
                href:"${pageContext.request.contextPath}/guruAdd.jsp", //包含子页面
            });
        }
    });

    $("#btn3").linkbutton({
        onClick:function(){
            $("#tb2_guru").dialog({
                title:'批量插入',
                width:400,
                height:250,
                href:"${pageContext.request.contextPath}/guruAddMore.jsp", //包含子页面
            });
        }
    });

    function qq(value,name) {
        alert(value + ":" + name);
        $("#tt_guru").datagrid({
            url : "${pageContext.request.contextPath}/guru/findByPageMohu?value="+value,
        });
    }


</script>
<table id="tt_guru"></table>
<div id="tb_guru" style="display: none">
	<a href="#" id="btn1" class="easyui-linkbutton"
	   data-options="iconCls:'icon-edit',plain:true,text:'修改'"></a>
	<a id="btn2" href="#" class="easyui-linkbutton"
	   data-options="iconCls:'icon-add',plain:true,text:'新增'"></a>
	<a id="btn3" href="#" class="easyui-linkbutton"
	   data-options="iconCls:'icon-add',plain:true,text:'批量插入'"></a>
	<a id="btn4" href="${pageContext.request.contextPath}/guru/export" class="easyui-linkbutton"
	   data-options="iconCls:'icon-ok',plain:true,text:'导出文件'"></a>
	<input
			id="ss" class="easyui-searchbox" style="width:300px"
			data-options="searcher:qq,prompt:'请您输入需要模糊查询的内容',menu:'#mm'"></input>
	<div id="mm" style="width:120px">
		<div data-options="name:'name',iconCls:'icon-ok'">法名</div>
	</div>
</div>
<div id="tb2_guru"></div>
