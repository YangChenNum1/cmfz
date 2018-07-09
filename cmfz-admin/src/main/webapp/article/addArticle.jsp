<%@ page language="java" contentType="text/html;charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor');
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'myfile'; //上传图片的名称

    editor.create();
/*
    function test() {
        alert(editor.txt.html());
    }*/
</script>

<script type="text/javascript">
    $(function(){
        $("#guruId").combobox({
            url:"${pageContext.request.contextPath}/article/selectGuru",
            valueField : "guruId",
            textField : "guruName",
            value:"请选择",
        });
	});

    $("#btn22").linkbutton({
        iconCls:"icon-add",
        onClick:function(){
            $("#ff").form("submit",{
                url:"${pageContext.request.contextPath}/article/add1",
                queryParams:{'artDescrip':editor.txt.html()},
                onSubmit:function(){
                    return $("#ff").form("validate");
                },
                success:function(res){
                    var d=JSON.parse(res);
                    if(d.result!=null){
                        $.messager.show({
                            title:'我的消息',
                            msg:'添加成功消息将在5秒后关闭。',
                            timeout:5000,
                            showType:'slide'
                        });
                    }
                }

            });
        }
    });
</script>


	<form id="ff" method="post">
		<table id="table1">
			<tr>
				<td>文章标题:</td>
				<td><input class="easyui-textbox" size=30 style="background-color:transparent" name="artName" data-options="required:true"></td>
			</tr>
			<tr>
				<td>文章作者:</td>
				<td><input id="guruId" size=30 style="background-color:transparent" name="guruId"></td>
			</tr>
			<div id="editor"></div>
			<tr>
				<td colspan="2"><a id="btn22">上传</a></td>
			</tr>
		</table>
	</form>


<%--<button id="btn" onclick="test()">点击获取富文本编辑器中的内容</button>--%>

