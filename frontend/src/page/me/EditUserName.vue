<template>
  <el-dialog title="修改用户名" :visible.sync="dialogVisible" width="30%" :show-close="false">
    <el-form :model="user" :rules="rules" ref="userNameForm" label-width="80px">
      <el-form-item label="旧用户名">
        <el-input v-model="userName" :disabled="true"/>
      </el-form-item>
      <el-form-item label="新用户名" prop="newUserName">
        <el-input v-model="user.newUserName" placeholder="请输入新的用户名" :clearable="true"/>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
    <el-button @click="close">取 消</el-button>
    <el-button type="primary" @click="update">确 定</el-button>
  </span>
  </el-dialog>
</template>

<script>
  import user from '@/js/api/user';
  import loading from '@/js/common/loading';
  import {UPDATE_USER_DATA} from "@/store";
  
  export default {
    name: "EditUserName",
    data() {
      return {
        dialogVisible: false,
        user: {
          newUserName: ""
        },
        rules: {
          newUserName: [
            {required: true, message: '请输入新的用户名', trigger: 'change'},
            {min: 1, max: 30, message: '长度在 1 到 30 个字符', trigger: 'change'}
          ]
        }
      }
    },
    computed: {
      userName() {
        return this.$store.state.userData.userName
      }
    },
    methods: {
      open() {
        this.dialogVisible = true
      },
      close() {
        this.user.newUserName = ""
        this.dialogVisible = false
        this.$refs.userNameForm.resetFields()
      },
      update() {
        this.$refs.userNameForm.validate(valid => {
          if (valid) {
            loading.start('正在修改')
            user.editUserName(this.user.newUserName).then(response => {
              if (response.code === 200) {
                this.$message.success("修改成功")
                this.$store.commit(UPDATE_USER_DATA)
                this.close()
              } else {
                this.$message.warning(response.msg)
              }
            }).finally(() => {
              loading.stop()
            })
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
