<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
	$(function(){
		$("#btn22").linkbutton({
			iconCls:"icon-add",
			onClick:function(){
				$("#ff").form("submit",{
					url:"${pageContext.request.contextPath}/guru/upload",
					onSubmit:function(){
						return $("#ff").form("validate");
					},
					success:function(res){
						var d=JSON.parse(res);
						if(d.result!=null){
                            $("#tt_guru").datagrid({
                                url : "${pageContext.request.contextPath}/guru/findByPage"
                            });
							$("#tb2_guru").dialog('close');
                            $.messager.show({
                                title:'我的消息',
                                msg:'添加成功消息将在5秒后关闭。',
                                timeout:5000,
                                showType:'slide'
                            });

                        }else{
							location.href="${pageContext.request.contextPath}/error.jsp";
						}
					}
					
				});
			}
		});

        $('#fb').filebox({
            buttonText: '选择文件',
            buttonAlign: 'right',
            buttonIcon:'icon-ok'
        })

    });
</script>

<form id="ff" method="post" enctype="multipart/form-data">
	<table style="text-align: center" border="1px" id="table1" width="400px">
		<tr>
			<td>上师法名:</td>
			<td><input class="easyui-textbox" size=30 style="background-color:transparent" name="guruName" data-options="required:true"></td>
		</tr>
		<tr>
			<td>上师状态:</td>
			<td><input class="easyui-textbox" size=30 style="background-color:transparent" name="guruSummer" data-options="required:true"></td>
		</tr>
		<tr>
			<td>上传头像:</td>
			<td><input id="fb" type="text" style="width:230px" name="myfile"></td>
		</tr>
		<tr>
			<td colspan="2"><a id="btn22">上传</a></td>
		</tr>
	</table>	
</form>

