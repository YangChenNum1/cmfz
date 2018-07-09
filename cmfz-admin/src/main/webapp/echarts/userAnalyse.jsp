<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '持明法州App活跃用户'
        },
        tooltip: {},
        legend: {
            data:['人数']
        },
        xAxis: {
            data: ["7天","15天","30天","90天","半年","一年"]
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: [5,20,36,10,10,20]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>