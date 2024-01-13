<template>
  <div id="main">
    <el-container id="non">
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="200px">
          <el-tree
              :props="props"
              :load="loadNode"
              lazy
              @node-click="getStudents">
          </el-tree>
        </el-aside>
        <el-container>
          <el-main>
            <el-table
                :data="tableData"
                style="width: 100%">
              <el-table-column
                  prop="id"
                  label="id"
                  width="180">
              </el-table-column>
              <el-table-column
                  prop="name"
                  label="姓名"
                  width="180">
              </el-table-column>
              <el-table-column
                  prop="sid"
                  label="班级id">
              </el-table-column>
            </el-table>
          </el-main>
          <el-footer>Footer</el-footer>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "main",
  data() {
    return {
      //菜单树属性
      props: {
        label: 'name',
        isLeaf: 'isParent'
      },
      tableData:[

      ]
    };
  },
  methods: {
    loadNode(node, resolve) {
      this.$axios.get('/api/schools?pid='+node.id).then(res => {
        for (var i = 0; i < res.data.data.length; i++) {
          res.data.data[i].isParent = !res.data.data[i].isParent;
        }
        return resolve(res.data.data);
      });
    },
    getStudents(a,b)
    {
      this.$axios.get('/api/students?sid='+b.id).then(res => {
        this.tableData = res.data.data;
      });
    }
  }
};
</script>

<style>
html, body {
  margin: 0;
  padding: 0;
  height: 100%;
}

#main {
  height: 100%;
}

#non {
  height: 100%;
}

.el-header, .el-footer {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #D3DCE6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 160px;

}
</style>
