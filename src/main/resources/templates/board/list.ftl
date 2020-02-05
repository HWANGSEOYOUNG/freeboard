<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../common/head_meta.ftl">
</head>
<body>
<div class="card card-default">
    <div class="card-header"> 게시판 리스트</div>
    <div class="card-body">
        <div id="listBody">
            <div class="form-group row">
                <div class="col-xl-10">
                    <button class="btn btn-primary mb-2" type="button" @click="check()">리스트 확인!</button>
                </div>
            </div>
            <div>
                <ul>
                    <li v-for="value in boardList">
                        <button class="mb-1 btn btn-outline-secondary" type="button"@click="">{{ value.name }}</button>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<script>
    let list = new Vue({
        el: '#listBody',
        data: {
            boardList: {}
        },
        methods: {
            check: function () {
                axios
                    .get('/manage/list')
                    .then(function (response) {
                        list.$data.boardList = response.data;
                    })
            }
        }
    })
</script>
</body>
</html>