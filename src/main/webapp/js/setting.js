var myGlobal = {
    LOCAL_TEACH_COURSE: "/workload/teachCourse",
    LOCAL_EXPRIMENT: "/workload/experiment",
    LOCAL_COURSE_DESIGN: "/workload/courseDesign",
    LOCAL_GRADUATE_PRACTICE: "/workload/graduationPractice",
    LOCAL_GRADUATE_DESIGN: "/workload/graduationDesign",
    LOCAL_TEACH_PRACTICE: "/workload/teachPractice",
    LOCAL_NET_COURSE: "/workload/netCourse",
    LOCAL_PROJECT: "/workload/project",
    LOCAL_COMPETITION: "/workload/competition",
    LOCAL_PUBLISH_TEXTBOOK: "/workload/publishTextbook",
    LOCAL_TRAINAXE: "/workload/trainAxe",
    LOCAL_EXP: "/workload/exp",

    REMOTE_NON_LESSON: "/allowance/nonLesson",
    REMOTE_TEACH_COURSE: "/allowance/teachCourse",
    REMOTE_EXPRIMENT: "/allowance/expriment",
    REMOTE_COURSE_DESIGN: "/allowance/courseDesign",
    REMOTE_GRADUATE_DESIGN: "/allowance/graduationDesign",
};

var ToolBar = {
    refresh: function () {
        $('.layui-laypage-btn').click();
    },
    add: function (maps, urls) {

        layui.use('layer', function () {
            var con = "";
            console.log(maps)
            for (var keys in maps) {
                /*       if (keys == "__proto__") {
                           continue;
                       }*/
                con = con + ' <input id="' + keys + '" class="layui-input" autocomplete="true" placeholder="' + maps[keys] + '"> '
            }
            layer.open({
                type: 0,
                title: '添加信息',
                content: con,
                shadeClose: true,
                shade: 0.8,
                area: ['400px', 'auto'],
                yes: function (index, layero) {
                    var ret = {};
                    for (var keys in maps) {
                        ret[keys] = $("#" + keys).val();
                    }
                    $.ajax({
                        type: 'post'
                        , url: urls
                        , data: {data: JSON.stringify(ret)}
                        , dataType: 'json'
                        , contentType: 'application/x-www-form-urlencoded;charset=UTF-8'
                        , success: function (res) {
                            if (res["status"] == 1) {
                                layer.alert(res['msg'], {
                                    icon: 2,
                                });
                                return;
                            } else {
                                layer.msg(res['msg'], {
                                    icon: 1,
                                    time: 1000
                                });
                                setTimeout("$('.layui-laypage-btn').click();", 1000)

                            }

                        }
                        , error: function (res) {
                            layer.alert('错误码：' + res.status);
                        }
                    });

                }
            });
        });
    },
    remove: function (tableId, urls) {
        layui.use(['layer', 'table'], function () {
                var layer = layui.layer;
                var table = layui.table;
                var checkStatus = table.checkStatus(tableId); //test即为基础参数id对应的值
                var data = checkStatus.data;
                var ret = [];


                if (data.length > 0) {
                    layer.confirm('是否删除这' + data.length + '条数据',
                        {icon: 3, title: '确认删除提示'},
                        function (index) {
                            for (var row = 0; row < data.length; row++) {
                                ret.push(data[row].id);
                            }
                            $.ajax({
                                type: 'post'
                                , url: urls
                                , data: {data: JSON.stringify(ret)}
                                , dataType: 'json'
                                , contentType: 'application/x-www-form-urlencoded;charset=UTF-8'
                                , success: function (res) {
                                    if (res["status"] == 1) {
                                        layer.alert(res['msg'], {
                                            icon: 2,
                                        });
                                        return;
                                    } else {
                                        layer.msg(res['msg'], {
                                            icon: 1,
                                            time: 1000
                                        });
                                    }
                                    setTimeout("$('.layui-laypage-btn').click();", 1000)
                                }
                                , error: function (res) {
                                    layer.alert('错误码：' + res.status);
                                    layer.close(layer.index);
                                    return;
                                }
                            });

                        }
                    );
                } else {
                    layer.alert("未选择数据.");
                }
                console.log(checkStatus.data) //获取选中行的数据
                console.log(checkStatus.data.length) //获取选中行数量，可作为是否有选中行的条件
                console.log(checkStatus.isAll) //表格是否全选

            }
        );

    }
    , searchlist: function (tableParam, type, data, tableObj) {
        var time = !data.field['time'] ? "0" : data.field['time'],
            teacher = !data.field['teacher'] ? "all" : encodeURI(data.field['teacher']);
        var url = "/" + type + "/".concat(time, "/", teacher);
        tableParam.url = url;
        tableObj.reload(tableParam); //重载表格
    }
    , downdetail: function (data, type) {
        var time = !data.field['time'] ? '0' : data.field['time'],
            teacher = !data.field['teacher'] ? "all" : encodeURI(data.field['teacher']);
        var url = "/downdetail/" + type + "/".concat(time, "/", teacher);
        document.location = url;
    }

};

function getCookie(c_name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=")
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1
            c_end = document.cookie.indexOf(";", c_start)
            if (c_end == -1) c_end = document.cookie.length
            return unescape(document.cookie.substring(c_start, c_end))
        }
    }
    return ""
}

function setCookie(c_name, value, expiredays) {
    var exdate = new Date()
    exdate.setDate(exdate.getDate() + expiredays)
    document.cookie = c_name + "=" + escape(value) +
        ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString())
}

function checkCookie() {
    username = getCookie('username')
    if (username != null && username != "") {
        alert('Welcome again ' + username + '!')
    }
    else {
        username = prompt('Please enter your name:', "")
        if (username != null && username != "") {
            setCookie('username', username, 365)
        }
    }
}
(function ($, doc, o) {
    var tk;
    var obj;
    var otd;
    var callback;
    o.show = function (h, e, c) {
        callback = c;
        var d = doc.getElementById('table_type_select');
        if (d) {
            d.remove();
        }
        otd = e;
        var s = '<div id="table_type_select" class="table-select"><dl class="layui-anim layui-anim-upbit" style="padding: 0px;top: 28px">';
        for (var k in h.data) {
            if (h.value == h.data[k].value) {
                s += '<dd lay-value="' + h.data[k].value + '" class="layui-this">' + h.data[k].text + '</dd>';
            } else {
                s += '<dd lay-value="' + h.data[k].value + '" >' + h.data[k].text + '</dd>';
            }
        }
        s += '</dl></div>';
        otd.innerHTML = s + otd.innerHTML;
        obj = doc.getElementById('table_type_select');
        //console.log($(obj));
        obj.onmouseout = function () {
            tk = 1;
            setTimeout(function () {
                if (tk) {
                    if (obj) {
                        ke = 0;
                        obj.remove();
                    }
                }
            }, 200);
        }
        obj.onmouseover = function () {
            tk = 0;
        }
        obj.addEventListener('click', function (e) {
            var value = $(e.srcElement).attr('lay-value');
            var text = e.srcElement.innerHTML;
            obj.remove();
            callback({value: value, text: text});
        });
    }
})($, document, window.type_select = {});

/*window.onload = function () {
  /!*  document.getElementsByTagName("footer")[0].innerHTML = "©CopyRight 2017 合肥工业大学 All Rights Reserved.";
*!/
    var obj = "  <ul class=\"layui-nav\" lay-filter='demo'> " +
        "           <li class=\"layui-nav-item \"><a href=\"../index.html\">工作量核算系统</a></li>\n" +


        "           <li style=\"float: right\" class=\"layui-nav-item \"><a href=\"/logout\">退出</a></li>\n" +
        "       </ul>" +
        "       <script>" +
        "           layui.use('element', function(){\n" +
        "               var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块\n" +
        "\n" +
        "               //监听导航点击\n" +
        "               element.on('nav(demo)', function(elem){\n" +
        "                   //console.log(elem)\n" +
        /!*            "                   layer.msg(elem.text());\n" +*!/
        "               });\n" +
        "           });" +
        "       </script>";  //按个人要求拼接标签
    $("header").append(obj);  // 用append 方式添加拼接的标签

    $("header").trigger("create");  //重点：这名的意思是重新加载所在标签的样式。非常有用的一句话，不加这一句你动态append的标签将丢失Css样式

    document.getElementsByTagName("main")[0] = document.getElementsByTagName("main")[0].innerHTML + "<br><br><br>";
    layui.use('element', function () {
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

        //监听导航点击
        element.on('nav(demo)', function (elem) {
            //console.log(elem)
            //layer.msg(elem.text());
        });
    });
}*/

