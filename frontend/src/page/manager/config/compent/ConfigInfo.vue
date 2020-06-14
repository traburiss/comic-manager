<template>
  <el-dialog :visible.sync="show" width="30%" :show-close="false">
    <el-form :model="data" :rules="rules" label-width="100px" ref="addConfigForm">
      <el-form-item label="key" prop="key">
        <el-input v-model="data.key" :clearable="true" :disabled="edit"/>
      </el-form-item>
      <el-form-item label="值" prop="value">
        <el-input v-model="data.value" :clearable="true"/>
      </el-form-item>
      <el-form-item label="名称" prop="name">
        <el-input v-model="data.name" :clearable="true" :disabled="edit"/>
      </el-form-item>
      <el-form-item label="说明" prop="desc">
        <el-input v-model="data.desc" :clearable="true"/>
      </el-form-item>
      <el-form-item label="类型" prop="desc">
        <el-select v-model="data.type" :disabled="edit">
          <el-option v-for="item in types" :key="item.value" :label="item.label" :value="item.value"/>
        </el-select>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="close">取 消</el-button>
      <el-button type="primary" @click="submitConfig">确 定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import api from "@/js/api/sysConfig";
  import loading from "@/js/common/loading";
  
  export default {
    name: "ConfigInfo",
    data() {
      let codeReg = new RegExp("^[5A-Za-z-0-9_]+$")
      const validateKey = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入'));
        } else if (!codeReg.test(value)) {
          callback(new Error('请输入英文、数字与下划线'));
        } else if (value.length < 1 || value.length > 20) {
          callback(new Error('长度在 1 到 20 个字符'))
        }
        callback()
      }
      return {
        edit: false,
        show: false,
        parent: null,
        data: {
          key: "",
          value: "",
          name: "",
          desc: "",
          type: 1
        },
        types: [
          {value: 0, label: '不可修改的系统配置'},
          {value: 1, label: '可修改的系统配置'},
          {value: 2, label: '用户配置默认值'}
        ],
        rules: {
          key: [
            {validator: validateKey, trigger: 'change'}
          ],
          value: [
            {required: true, message: '请输入', trigger: 'change'},
            {min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'change'}
          ],
          name: [
            {required: true, message: '请输入', trigger: 'change'},
            {min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'change'}
          ],
          desc: [
            {min: 0, max: 100, message: '长度在 0 到 100 个字符', trigger: 'change'}
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
          key: data.key,
          value: data.value,
          name: data.name,
          desc: data.desc,
          type: data.type
        }
      },
      close() {
        this.show = false
        this.$refs.addConfigForm.resetFields()
      },
      submitConfig() {
        this.$refs.addConfigForm.validate(valid => {
          if (valid) {
            loading.start("正在提交")
            if (this.edit) {
              api.editConfig(this.data).then(res => {
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
              api.addConfig(this.data).then(res => {
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
        console.info(this.data)
      }
    }
  }
</script>

<style scoped>

</style>
