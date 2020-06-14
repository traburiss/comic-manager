<template>
  <el-dialog title="修改密码" :visible.sync="dialogVisible" width="30%" :show-close="false">
    <el-form :model="user" label-width="80px" ref="editPwdFrom" :rules="rules">
      <el-form-item label="旧密码" prop="oldPwd">
        <el-input v-model="user.oldPwd" placeholder="请输入旧的密码" show-password :clearable="true"/>
      </el-form-item>
      <el-form-item label="新密码" prop="newPwd">
        <el-input v-model="user.newPwd" placeholder="请输入新的密码" show-password :clearable="true"/>
      </el-form-item>
      <el-form-item label="新密码" prop="newPwdAgain">
        <el-input v-model="user.newPwdAgain" placeholder="请再次输入新的密码" show-password :clearable="true"/>
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
  import loading from "@/js/common/loading";
  import api from "@/js/api/login";
  import cookie from "@/js/common/cookie";
  
  export default {
    name: "EditPassword",
    data() {
      const passWordCheck = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value.length < 6 || value.length > 30) {
          callback(new Error('长度在 6 到 30 个字符'));
        } else if (value !== this.user.newPwd) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      }
      return {
        dialogVisible: false,
        user: {
          oldPwd: "",
          newPwd: "",
          newPwdAgain: "",
        },
        rules: {
          oldPwd: [
            {required: true, message: '请输入旧的密码', trigger: 'change'},
            {min: 6, max: 30, message: '长度在 6 到 30 个字符', trigger: 'change'}
          ],
          newPwd: [
            {required: true, message: '请输入新的密码', trigger: 'change'},
            {min: 6, max: 30, message: '长度在 6 到 30 个字符', trigger: 'change'}
          ],
          newPwdAgain: [
            {validator: passWordCheck, trigger: 'change'}
          ]
        }
      }
    },
    methods: {
      open() {
        this.dialogVisible = true
      },
      close() {
        this.user = {
          oldPwd: "",
          newPwd: "",
          newPwdAgain: "",
        }
        this.dialogVisible = false
        this.$refs.editPwdFrom.resetFields()
      },
      update() {
        this.$refs.editPwdFrom.validate(valid => {
          if (valid) {
            loading.start('正在修改')
            user.editPassword(this.user.oldPwd, this.user.newPwdAgain).then(response => {
              if (response.code === 200) {
                this.$message.success("修改成功")
                this.close()
                loading.stop()
                this.$confirm('您已修改密码，请问是否要重新登陆', '提示', {
                  confirmButtonText: '确定',
                  cancelButtonText: '取消',
                  type: 'warning'
                }).then(() => {
                  loading.start('正在登出')
                  api.logoutService().then(() => {
                    loading.stop()
                    this.$cookies.remove(cookie.token, '/')
                    this.$router.push('/login')
                    this.$message({message: '已登出!'});
                  }).catch(() => {
                    loading.stop()
                    this.$message({type: 'warn', message: '登出失败'})
                  })
                })
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
