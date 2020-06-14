<template>
  <el-container>
    <el-header class="header">
      <el-form size="small" :model="queryParam" :inline="true">
        <el-form-item label="名称">
          <el-input v-model="queryParam.name" clearable/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="search">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="success" @click="addSubmit">新增</el-button>
        </el-form-item>
      </el-form>
    </el-header>
    <el-main>
      <el-table v-loading="queryParam.tableLoading" :data="resultList">
        <el-table-column prop="key" label="配置KEY" min-width="10%" :show-overflow-tooltip="true"/>
        <el-table-column prop="value" label="配置值" min-width="20%" :show-overflow-tooltip="true"/>
        <el-table-column prop="name" label="配置名称" min-width="15%" :show-overflow-tooltip="true"/>
        <el-table-column prop="desc" label="配置说明" min-width="25%" :show-overflow-tooltip="true"/>
        <el-table-column prop="type" label="配置类型" min-width="5%">
          <template slot-scope="scope">
            <el-tooltip v-if="scope.row.type === 0" class="item" effect="dark" content="不可更改的系统配置" placement="top">
              <el-tag type="warning" size="mini">系</el-tag>
            </el-tooltip>
            <el-tooltip v-if="scope.row.type === 1" class="item" effect="dark" content="系统配置" placement="top">
              <el-tag type="success" size="mini">系</el-tag>
            </el-tooltip>
            <el-tooltip v-if="scope.row.type === 2" class="item" effect="dark" content="用户配置默认值" placement="top">
              <el-tag type="success" size="mini">用</el-tag>
            </el-tooltip>
          </template>
        </el-table-column>
        >
        <el-table-column prop="updater" label="更新人" min-width="10%" :show-overflow-tooltip="true"/>
        <el-table-column prop="updateTime" label="更新时间" :formatter="dateFormatter" min-width="10%" :show-overflow-tooltip="true"/>
        <el-table-column prop="operation" label="操作" min-width="5%">
          <template slot-scope="scope">
            <el-button :disabled="scope.row.type === 0" size="mini" @click="editSubmit(scope.row)">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        @size-change="querySubmit"
        @current-change="querySubmit"
        :current-page="pageParam.page"
        :page-sizes="pageParam.pageList"
        :page-size="pageParam.pageSize"
        :total="pageParam.total"
        layout="->,total, sizes, prev, pager, next"/>
    </el-main>
    <config-info ref="configInfo"></config-info>
  </el-container>
</template>

<script>
  import Constant from "@/js/common/constant";
  import api from "@/js/api/sysConfig";
  import {formatTimestamp} from '@/js/common/date'
  import ConfigInfo from "@/page/manager/config/compent/ConfigInfo";
  
  export default {
    name: 'ComicManager',
    components: {ConfigInfo},
    data() {
      return {
        queryParam: {
          tableLoading: false,
          name: ""
        },
        resultList: [],
        pageParam: {
          pageList: Constant.pageList,
          page: 1,
          pageSize: Constant.pageSize,
          total: 0
        }
      }
    },
    mounted() {
      this.search()
    },
    methods: {
      search() {
        this.pageParam.page = 1
        this.querySubmit();
      },
      querySubmit() {
        this.queryParam.tableLoading = true
        api.configList({
          page: this.pageParam.page,
          pageSize: this.pageParam.pageSize,
          name: this.queryParam.name
        }).then(resp => {
          this.resultList = resp.data.list
          this.pageParam.total = resp.data.count
        }).finally(() => {
          this.queryParam.tableLoading = false
        })
      },
      addSubmit() {
        this.$refs.configInfo.openAdd(this)
      },
      editSubmit(row) {
        this.$refs.configInfo.openEdit(this, row)
      },
      dateFormatter(row, column, cellValue) {
        if (cellValue != null) {
          return formatTimestamp(cellValue)
        } else {
          return '未设置时间'
        }
      }
    }
  }
</script>

<style scoped>
  .header {
    text-align: end;
  }
</style>
