<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
	<script type="text/javascript">
    $(function(){
		$.ajax({
			url:"${pageContext.request.contextPath}/menu/showAllMenus",
			dataType:"json",
			success:function (res) {
				$.each(res,function (index,obj) {
				    var content="";
				    $.each(obj.menus,function (index1,obj1) {
                        content += "<p style=\"text-align:center\"><a class=\"easyui-linkbutton\" data-options=\"iconCls:'"+obj1.menuIcon+"',plain:true\" onclick=\"addTab('"+obj1.menuName+"','"+obj1.menuUrl+"')\">"+obj1.menuName+"</a></p>";
                    })
					$("#aa").accordion("add",{
						title:obj.menuName,
						iconCls:obj.menuIcon,
						content:content
					});
                })
            }
		});
    });
    function addTab(res,path) {
        // 调用选项卡的addTab新增选项卡
        var exists = $("#tt").tabs("exists",res);
        if(!exists){
            $("#tt").tabs("add",{
                iconCls:"icon-ok",
                title:res,
                href:"${pageContext.request.contextPath}/"+path, // 一个菜单项 对应一个需要加载的数据页面
                closable:true,
            });
        }else{
            $("#tt").tabs("select",res);
        }
    }
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:xxxxx &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 gaozhy@zparkhr.com.cn</div>
    </div>   

    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
		<div id="aa" class="easyui-accordion" data-options="fit:true">
			<%--<c:forEach items="${menus}" var="menu">
				<div title="${menu.menuName}" data-options="iconCls:'${menu.menuIcon}'"
					 style="overflow:auto;padding:10px; text-align: center;">
					<c:forEach var="menu" items="${menu.menus}">
						<a class="easyui-linkbutton"
						   data-options="plain:true,iconCls:'${menu.menuIcon}'"
						   onclick="addTab(this,'${menu.menuUrl}')">${menu.menuName}</a><br/>
					</c:forEach>
				</div>
			</c:forEach>--%>
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(/cmfz-admin/img/shouye.jpg);background-repeat: no-repeat;background-size:100% 120%;"></div>
		</div>
    </div>   
</body> 
</html>