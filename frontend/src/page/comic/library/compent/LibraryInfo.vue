<template>
  <el-dialog :title="edit?'编辑':'新增'" :visible.sync="show" width="30%" :show-close="false">
    <el-form :model="data" :rules="rules" label-width="100px" ref="libraryInfo">
      <el-form-item label="名称" prop="name">
        <el-input v-model="data.name" :clearable="true"/>
      </el-form-item>
      <el-form-item label="说明" prop="desc">
        <el-input v-model="data.desc" :clearable="true"/>
      </el-form-item>
      <el-form-item label="类型" prop="type">
        <el-select v-model="data.type">
          <el-option v-for="item in types" :key="item.value" :label="item.label" :value="item.value"/>
        </el-select>
      </el-form-item>
      <el-form-item label="路径" prop="path">
        <el-input v-model="data.path" :clearable="true"/>
      </el-form-item>
      <el-form-item label="参数" prop="param">
        <el-input v-model="data.param" :clearable="true"/>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="close">取 消</el-button>
      <el-button type="primary" @click="submitConfig">确 定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import api from "@/js/api/library";
  import loading from "@/js/common/loading";
  
  export default {
    name: "LibraryInfo",
    data() {
      return {
        edit: false,
        show: false,
        parent: null,
        data: {
          id: 0,
          name: "",
          desc: "",
          type: 1,
          path: "",
          param: ""
        },
        types: [
          {value: 1, label: '本地文件'},
          {value: 2, label: 'SMB'}
        ],
        rules: {
          name: [
            {required: true, message: '请输入', trigger: 'change'},
            {min: 1, max: 30, message: '长度在 1 到 20 个字符', trigger: 'change'}
          ],
          desc: [
            {min: 0, max: 60, message: '长度在 0 到 60 个字符', trigger: 'change'}
          ],
          path: [
            {required: true, message: '请输入', trigger: 'change'},
            {min: 1, max: 1024, message: '长度在 0 到 1024 个字符', trigger: 'change'}
          ],
          param: [
            {min: 0, max: 1024, message: '长度在 0 到 1024 个字符', trigger: 'change'}
          ]
        }
      }
    },
    methods: {
      openAdd(parent) {
        this.edit = false
        this.show = true
        this.parent = parent
      },
      openEdit(parent, data) {
        this.edit = true
        this.show = true
        this.parent = parent
        this.data = {
          id: data.id,
          name: data.name,
          desc: data.desc,
          type: data.type,
          path: data.path,
          param: data.param
        }
      },
      close() {
        this.show = false
        this.$refs.libraryInfo.resetFields()
      },
      submitConfig() {
        this.$refs.libraryInfo.validate(valid => {
          if (valid) {
            loading.start("正在提交")
            if (this.edit) {
              api.editLibrary(this.data).then(res => {
                if (res.code === 200) {
                  this.close()
                  this.$message.success("编辑成功")
                  this.parent.querySubmit()
                } else {
                  this.$message.success(res.msg)
                }
              }).finally(() => {
                loading.stop()
              })
            } else {
              api.addLibrary(this.data).then(res => {
                if (res.code === 200) {
                  this.close()
                  this.$message.success("新增成功")
                  this.parent.querySubmit()
                } else {
                  this.$message.success(res.msg)
                }
              }).finally(() => {
                loading.stop()
              })
            }
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
