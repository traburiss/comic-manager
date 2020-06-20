<template>
  <el-dialog title="标签管理" :visible.sync="show" width="30%" :show-close="false" @close="close">
    <div class="tag-div">
      <el-tag class="tag" :key="tag.id" :type="typeList[index%5]" v-for="(tag, index)  in tagList" closable :disable-transitions="false" @close="deleteTag(tag.id)">{{tag.name}}</el-tag>
      <el-input class="input-tag" v-if="inputVisible" v-model="text" ref="tagInput" size="small" @keyup.enter.native="addTag" @blur="addTag"/>
      <el-button v-else class="button-tag" size="small" @click="showInput" icon="el-icon-plus"/>
    </div>
  </el-dialog>
</template>

<script>
  import api from "@/js/api/library";
  
  export default {
    name: "TagInfo",
    data() {
      return {
        typeList: ['', 'success', 'info', 'danger', 'warning'],
        show: false,
        inputVisible: false,
        text: '',
        tagList: [],
        libraryId: 0,
        parent: null
      }
    },
    methods: {
      open(parent, row) {
        this.show = true;
        this.libraryId = row.id;
        this.parent = parent
        this.queryTag()
      },
      close() {
        this.show = false
        this.inputVisible = false
        this.text = ''
        this.tagList = []
        this.libraryId = 0
        this.parent = null
      },
      queryTag() {
        api.tagList({libraryId: this.libraryId})
          .then(res => {
            this.tagList = res.data
          })
      },
      showInput() {
        this.inputVisible = true
      },
      addTag() {
        this.inputVisible = false
        api.tagAdd({
          id: 0,
          libraryId: this.libraryId,
          name: this.text
        }).finally(() => {
          this.text = ""
          this.queryTag()
        })
      },
      deleteTag(id) {
        this.$confirm('请确认是否要删除', '删除', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          showClose: false,
          confirmButtonClass: 'el-button--danger'
        }).then(() => {
          api.tagRemove({
            tagId: id
          }).finally(() => {
            this.text = ""
            this.queryTag()
          })
        })
      }
    }
  }
</script>

<style scoped>
  .tag-div {
    text-align: start;
  }

  .tag {
    margin: 0 5px 5px 0;
  }

  .input-tag {
    margin: 0 5px 5px 0;
    width: 90px;
  }

  .button-tag {
    margin: 0 5px 5px 0;
    width: 90px;
  }
</style>
