layui.use(['table', 'element', 'form', 'laydate', 'layer', 'util', 'upload',], function () {
    var layer = layui.layer, form = layui.form, $ = layui.jquery, table = layui.table, laydate = layui.laydate,
        upload = layui.upload;

    // 提示
    $('#tips').on('mouseenter', function () {
        layer.tips($('#u123_text').html(), '#tip', {
            tips: [2, 'white'],
            area: ['300px', 'auto'],
            time: 0
        });
    })
    $('#tips').on('mouseleave', function () {
        layer.closeAll('tips');
    })

    //上传文件
    upload.render({
        elem: '.up'
        , url: '/csv/letItGo' //改成您自己的上传接口
        , accept: 'file' //普通文件
        , exts: 'csv'
        , headers: {}
        , data: {}
        , before: function (obj) {
        }
        , acceptMime: '.csv'
        , done: function (res) {
            console.log(res);
        }
    });
})
