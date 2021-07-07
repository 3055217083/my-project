layui.define( function (exports) {
    var obj = {
        hello: function (str) {
            alert('Hello ' + (str || 'mymod'));
        }
    };
    //输出 mymod 接口
    exports('mymod', obj);
});
