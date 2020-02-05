<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../common/head_meta.ftl">
</head>
<body>
<div class="card card-default">
    <div class="card-header"> 게시판 생성</div>
    <div class="card-body">
        <form id="addBoard">
            <div class="form-group row">
                <div class="col-md-3">
                    <input class="form-control" type="text" v-model="name" placeholder="게시판명">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xl-10">
                    <button class="btn btn-primary mb-2" type="button" @click="add()">저장!</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    let add = new Vue({
        el: '#addBoard',
        data: {
            name: ''
        },
        methods: {
            add: function () {
                let param = { name : add.$data.name };
                console.log(param.name);
                axios
                    .post('/manage/add', param)
                    .then(function (response) {
                        console.log(response);
                    })
            }
        }
    })
</script>
</body>
</html>