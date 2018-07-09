<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function() {
        // 数据表格 加载远程数据 数据来源数据库
        $("#table1").datagrid({
            url : "${pageContext.request.contextPath}/log/findByPage",
            columns : [ [ {
                title : "用户Id",
                field : "id",
                width:60,
            }, {
                title : "用户",
                field : "user",
                width:60,
            }, {
                title : "操作时间",
                field : "time",
                width:60,
            }, {
                title : "操作资源类型",
                field : "resource",
                width:60,
            }, {
                title : "操作动作",
                field : "action",
                width:60,
            }, {
                title : "操作详细信息",
                field : "message",
                width:200,
            },{
                title : "操作结果",
                field : "result",
                width:70,
            }] ],
            pagination : true,
            pageList : [ 4, 8, 12, 16, 20 ],
            pageSize : 4,
            toolbar : "#tb",
            fitColumns: true,
            singleSelect:true,
        });

    });
</script>

<table id="table1"></table>

