<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>专业管理</title>
</head>
<body>
<div class="layuimini-container layuimini-page-anim">
    <div class="layuimini-main">
        <div class="layui-row">
            <script type="text/html" id="toolbar">
                <div class="layui-btn-container">

                    <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add">
                        <i class="fa fa-plus"></i>
                        添加
                    </button>
                    <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="save">
                        <i class="fa fa-save"></i>
                        保存
                    </button>
                </div>
            </script>
            <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
        </div>

    </div>
</div>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;
            table.render({
                elem: '#currentTableId',
                url: '${basePath}section/query_student_section',
                contentType:'application/json',
                method:"post",
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports', 'print'],
                page: false,
                cols: [[
                    {type: "checkbox", width: 50},
                    {field: 'id', width: 80, title: 'ID'},
                    {field: 'year',  title: '年份'},
                    {field: 'type', title: '类型'},
                    {field: 'clazzName', title: '班级',templet: '<div>{{d.clazz.clazzName}}</div>'},
                    {field: 'courseName', title: '课程',templet: '<div>{{d.course.courseName}}</div>'},
                    {field: 'teacherName', title: '老师',templet: '<div>{{d.teacher.teacherName}}</div>'},
                    {field: 'remark',title: '备注'}
                ]],
                done: function(res, page, count){
                    for(var index in res.data){
                        if(res.data[index].selected >= 1){
                            res.data[index]["LAY_CHECKED"]='true';
                            var index= res.data[index]['LAY_TABLE_INDEX'];
                            $('tr[data-index=' + index + '] input[type="checkbox"]').prop('checked', true);
                            $('tr[data-index=' + index + '] input[type="checkbox"]').next().addClass('layui-form-checked');
                        }
                    }
                },
                skin: 'line'
            });

        /**
         * toolbar事件监听
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'save') {   // 监听添加操作
                var checkStatus = table.checkStatus('currentTableId');
                var data = checkStatus.data;
                if(data.length ==0){
                    layer.msg("请选择选课信息",{time:1000});
                    return;
                }
                var sectionIdArr = [];
                var courseIdArr = [];
                $.each(data,function (i,item) {
                    sectionIdArr.push(item.id);
                    courseIdArr.push(item.course.id);
                })
                $.ajax({
                    url:"${basePath}score/create",
                    type:"POST",
                    dataType:'json',
                    data:{
                        sectionIds:sectionIdArr.join(","),
                        courseIds:courseIdArr.join(",")
                    },
                    success:function(data){
                        layer.msg(data.msg,{time:500},
                            function(){
                                table.reload("currentTableId");
                            });
                    }
                });
            }else if (obj.event === 'add'){
                var index = layer.open({
                    title: '添加选课',
                    type: 2,  //类型
                    shade: 0.2,  //透明度
                    shadeClose: false,  //阴影
                    area: ['50%', '50%'],  //大小：高、宽
                    content: '${basePath}student/add',
                    end:function(){
                        table.reload('currentTableId');  //添加成功后刷新页面
                    }
                });

            }
        });
    });
</script>
</body>
</html>
