<%@ page language="java" contentType="text/html;charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor');
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/rt/upload';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files'; //上传图片的名称

    editor.create();

    function test() {
        alert(editor.txt.html());
    }
</script>

<div id="editor">
	<form id="ff" method="post">
		<table id="table1">
			<tr>
				<td>文章标题:</td>
				<td><input class="easyui-textbox" size=30 style="background-color:transparent" name="picDescription" data-options="required:true"></td>
			</tr>
			<tr>
				<td>文章作者:</td>
				<td><input id="cc" class="easyui-combobox" name="dept"
						   data-options="valueField:'id',textField:'text',url:'get_data.php'" /> </td>
			</tr>
			<tr>
				<td colspan="2"><a id="btn22">上传</a></td>
			</tr>
		</table>
	</form>
</div>

<button id="btn" onclick="test()">点击获取富文本编辑器中的内容</button>

<%--<td valign="middle" align="left">
	<select name="dept.deptId">
		<s:iterator var="dept" value="list">
			<option value="<s:property value='#dept.deptId'/>"><s:property value="#dept.deptName"/></option>
		</s:iterator>
	</select>
</td>--%>

