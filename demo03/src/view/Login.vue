<template>
  <div id="loginContainer">
    <div id="loginTitle">欢迎登录</div>
    <el-form :model="loginForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

      <el-form-item label="用户" prop="username">
        <el-input v-model="loginForm.username"></el-input>
      </el-form-item>

      <el-form-item label="密码" prop="password">
        <el-input placeholder="请输入密码" v-model="loginForm.password" show-password></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm">登录</el-button>
      </el-form-item>

    </el-form>
  </div>
</template>
<script>

export default {
  name: "LoginView",
  data() {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      rules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
          {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 3, max: 6, message: '长度在 3 到 5 个字符', trigger: 'blur'}
        ],
      }
    };
  },
  methods: {
    submitForm() {
      console.log("username:" + this.loginForm.username + "\n" + "password:" + this.loginForm.password)
      this.$axios.post("/api/login", this.loginForm).then(res => {
        if(res.data.code==200){
          this.$router.push("/main")
        }
        else
        {
          this.$message.error(res.data.data)
        }
      });
    }
  }
}
</script>

<style scoped>
#loginContainer {
  width: 400px;
  margin: 0 auto;
}

#loginTitle {
  text-align: center;
  margin-bottom: 40px;
  color: #42b983;
}
</style>
