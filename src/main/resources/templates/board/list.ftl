<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../common/head_meta.ftl">
</head>
<body>
<div id="listBody">

    <div class="col-md-12">
        <div class="card card-default">
            <div class="card-header"> 게시판 리스트</div>
            <div class="card-body">
                <div class="form-group row">
                    <div class="col-xl-10">
                        <button class="btn btn-primary mb-2" type="button" @click="check()">리스트 확인!</button>
                        <button class="btn btn-primary mb-2" type="button" @click="createBoard()">게시판 만들기</button>
                    </div>
                </div>
                <div>
                    <ul>
                        <li v-for="value in boardList">
                            <button class="mb-1 btn btn-outline-secondary" type="button" :value="value.name"
                                    @click="boardClick(event)">
                                {{ value.name }}
                            </button>
                            <button class="mb-1 btn btn-danger" type="button" :value="value.name"
                                    @click="deleteBoard(event)">삭제
                            </button>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div v-if="list" class="col-md-12">
        <div class="card card-default">
            <div class="card-header">{{boardName}}</div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>no</th>
                            <th>제목</th>
                            <th>내용</th>
                            <th>작성일</th>
                            <th>최종수정일</th>
                            <th>댓글</th>
                            <th>관리</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="value in articles">
                            <td>{{ value.id}}</td>
                            <td>{{ value.title}}</td>
                            <td>{{ value.content}}</td>
                            <td>{{ value.createDate}}</td>
                            <td>{{ value.updateDate}}</td>
                            <td>
                                <button class="mb-1 btn btn-purple" type="button" :value="value.id"
                                        @click="replyClick(event)">댓글확인
                                </button>
                            </td>
                            <td>
                                <button class="mb-1 btn btn-green" type="button" :value="value.id"
                                        @click="articleUpdateClick(event)">수정
                                </button>
                                <button class="mb-1 btn btn-danger" type="button" :value="value.id"
                                        @click="deleteArticle(event)">삭제
                                </button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="form-group row">
                    <div class="col-xl-10">
                        <button class="btn btn-primary mb-2" type="button" :value="boardName"
                                @click="articleAddClick()">게시글 추가
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div v-if="modify" class="col-md-12">
        <div class="card card-default">
            <div class="card-header">{{boardName}}</div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>no</th>
                            <th>제목</th>
                            <th>내용</th>
                            <th>작성일</th>
                            <th>최종수정일</th>
                            <th>관리</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="value in articles">
                            <td>{{ value.id}}</td>
                            <td v-if="id === value.id"><input class="form-control" type="text" :value="value.title" v-model="title" placeholder="제목"></td></v-if>
                            <td v-else>{{ value.title}}</td></v-else>
                            <td v-if="id === value.id"><input class="form-control" type="text" :value="value.content" v-model="content" placeholder="내용"></td></v-if>
                            <td v-else>{{ value.content}}</td></v-else>
                            <td>{{ value.createDate}}</td>
                            <td>{{ value.updateDate}}</td>
                            <td>
                                <button v-if="id === value.id" class="mb-1 btn btn-green" type="button" :value="value.id"
                                        @click="updateArticle()">수정
                                </button>
                                <button v-if="id === value.id" class="mb-1 btn btn-danger" type="button" :value="value.id"
                                        @click="resetModify()">취소
                                </button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div v-if="add" class="col-md-12">
        <div class="card card-default">
            <div class="card-header">게시글 작성</div>
            <div class="card-body">
                <div class="form-group row">
                    <div class="col-md-8">
                        <input class="form-control" type="text" v-model="title" placeholder="제목">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-md-8">
                        <input class="form-control" type="text" v-model="content" placeholder="내용">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-xl-10">
                        <button class="btn btn-primary mb-2" type="button" @click="writeArticle()">저장!</button>
                        <button class="btn btn-primary mb-2" type="button" @click="resetArticle()">취소</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

<#--    <div v-if="modify" class="col-md-12">
        <div class="card card-default">
            <div class="card-header">{{id}}번 게시글 수정</div>
            <div class="card-body">
                <div class="form-group row">
                    <div class="col-md-8">
                        <input class="form-control" type="text" v-model="title" placeholder="제목">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-md-8">
                        <input class="form-control" type="text" v-model="content" placeholder="내용">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-xl-10">
                        <button class="btn btn-primary mb-2" type="button" @click="updateArticle()">수정!</button>
                        <button class="btn btn-primary mb-2" type="button" @click="resetModify()">취소</button>
                    </div>
                </div>
            </div>
        </div>
    </div>-->

    <div v-if="reply" class="col-md-12">
        <div class="card card-default">
            <div class="card-header">{{id}}번 댓글</div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>no</th>
                            <th>내용</th>
                            <th>작성일</th>
                            <th>관리</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="value in replyList">
                            <td>{{value.id}}</td>
                            <td>{{value.reContent}}</td>
                            <td>{{value.reCreateDate}}</td>
                            <td>
                                <button class="mb-1 btn btn-danger" type="button" :value="value.id"
                                        @click="deleteReply(event)">삭제
                                </button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="form-group row">
                    <div class="col-md-9">
                        <input class="form-control" type="text" v-model="reContent" placeholder="내용">
                    </div>
                    <div class="col-xl-3">
                        <button class="btn btn-primary mb-2" type="button"
                                @click="addReply()">댓글 추가
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<script>
    let list = new Vue({
        el: '#listBody',
        data: {
            boardList: {},
            boardName: '',
            articles: {},
            list: false,
            add: false,
            modify: false,
            reply: false,
            title: '',
            content: '',
            id: '',
            replyList: {},
            reContent: ''
        },
        methods: {
            check: function () {
                this.list = false;
                this.add = false;
                this.modify = false;
                this.reply = false;

                axios
                    .get('/manage/list')
                    .then(function (response) {
                        list.$data.boardList = response.data;
                    })
            },
            createBoard : function(){
                location.href = '/add';
            },
            boardClick: function (event) {
                this.add = false;
                this.modify = false;
                this.reply = false;
                this.list = true;
                list.$data.boardName = event.target.value;
                let boardName = event.target.value;

                axios
                    .get('/board/list', {
                        params: {
                            boardName: boardName
                        }
                    })
                    .then(function (response) {
                        list.$data.articles = response.data;
                    })
            },
            deleteBoard: function (event) {
                let name = event.target.value;
                this.add = false;
                this.modify = false;
                this.reply = false;

                axios
                    .delete('/manage/del', {
                        params: {
                            name: name
                        }
                    })
                    .then(function () {
                        list.check();
                    })

            },
            boardReset: function () {
                let boardName = list.$data.boardName;

                axios
                    .get('/board/list', {
                        params: {
                            boardName: boardName
                        }
                    })
                    .then(function (response) {
                        list.$data.articles = response.data;
                    })
            },
            deleteArticle: function (event) {
                let id = event.target.value;
                this.add = false;
                this.modify = false;
                this.reply = false;

                axios
                    .delete('/board/del', {
                        params: {
                            id: id
                        }
                    })
                    .then(function () {
                        list.boardReset();
                    })

            },
            writeArticle: function () {
                if(list.$data.title.length === 0 || list.$data.content.length === 0){
                    alert("제목 또는 내용을 입력하세요!");
                    return;
                }

                let article = {
                    boardName: list.$data.boardName,
                    title: list.$data.title,
                    content: list.$data.content
                };

                axios
                    .post('/board/write', article)
                    .then(function () {
                        list.boardReset();
                        list.$data.add = false;
                    })
            },
            articleAddClick: function () {
                this.add = true;
                this.modify = false;
                this.reply = false;
                this.title = '';
                this.content = '';
            },
            articleUpdateClick: function (event) {
                this.id = event.target.value;
                this.list = false;
                this.modify = true;
                this.add = false;
                this.reply = false;

                let id = this.id;

                axios
                    .get('/board/article', {
                        params: {
                            id: id
                        }
                    })
                    .then(function (response) {
                        list.$data.id = response.data.id;
                        list.$data.title = response.data.title;
                        list.$data.content = response.data.content;

                    })
            },
            updateArticle: function () {
                if(list.$data.title.length === 0 || list.$data.content.length === 0){
                    alert("제목 또는 내용을 입력하세요!");
                    return;
                }

                let article = {
                    id: list.$data.id,
                    title: list.$data.title,
                    content: list.$data.content
                };
                axios
                    .put('/board/modify', article)
                    .then(function () {
                        list.boardReset();
                        list.$data.modify = false;
                        list.$data.list = true;
                    })
            },
            resetModify : function (){
                this.modify = false;
                this.list = true;
            },
            resetArticle : function () {
                this.add = false;
            },
            replyClick: function (event) {
                this.reply = true;
                this.modify = false;
                this.add = false;
                this.id = event.target.value;
                let id = this.id;

                axios
                    .get('/reply/list', {params: {articleId: id}})
                    .then(function (response) {
                        list.$data.replyList = response.data;
                    })

            },
            replyReset: function () {
                let id = list.$data.id;

                axios
                    .get('/reply/list', {params: {articleId: id}})
                    .then(function (response) {
                        list.$data.replyList = response.data;
                    })

            },
            addReply: function () {

                if(list.$data.reContent.length === 0){
                    alert("댓글을 입력하세요!");
                    return;
                }

                let reply = {
                    articleId: list.$data.id,
                    reContent: list.$data.reContent
                };

                axios
                    .post('/reply/add', reply)
                    .then(function () {
                        list.replyReset();
                        list.$data.reContent = '';
                    })
            },
            deleteReply : function (event) {
                let id = event.target.value;

                axios
                .delete('/reply/del', {params : {id : id}})
                .then(function () {
                    list.replyReset();
                })
            }
        }
    })
</script>
<#include "../common/script.ftl">
</body>
</html>