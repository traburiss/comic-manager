<template>
  <el-container>
    <el-header class="search-header">
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
        <el-table-column prop="name" label="书库名称" min-width="10%" :show-overflow-tooltip="true"/>
        <el-table-column prop="desc" label="书库说明" min-width="20%" :show-overflow-tooltip="true"/>
        <el-table-column prop="type" label="书库类型" min-width="5%">
          <template slot-scope="scope">
            <el-tooltip v-if="scope.row.type === 1" class="item" content="本地文件" placement="top">
              <el-tag type="success" size="mini">F</el-tag>
            </el-tooltip>
            <el-tooltip v-else-if="scope.row.type === 2" class="item" content="smb文件" placement="top">
              <el-tag type="success" size="mini">S</el-tag>
            </el-tooltip>
            <el-tooltip v-else class="item" content="未知" placement="top">
              <el-tag type="danger" size="mini">未</el-tag>
            </el-tooltip>
          </template>
        </el-table-column>
        <el-table-column prop="status" label="扫描状态" min-width="5%">
          <template slot-scope="scope">
            <el-tooltip v-if="scope.row.status === 0" class="item" content="已准备" placement="top">
              <el-tag type="warning" size="mini">R</el-tag>
            </el-tooltip>
            <el-tooltip v-else-if="scope.row.status === 1" class="item" content="正在扫描" placement="top">
              <el-tag type="success" size="mini">P</el-tag>
            </el-tooltip>
            <el-tooltip v-else-if="scope.row.status === 2" class="item" content="已完成扫描" placement="top">
              <el-tag type="success" size="mini">F</el-tag>
            </el-tooltip>
            <el-tooltip v-else class="item" content="未知" placement="top">
              <el-tag type="danger" size="mini">未</el-tag>
            </el-tooltip>
          </template>
        </el-table-column>
        <el-table-column prop="scanTime" label="扫描时间" :formatter="dateFormatter" min-width="10%" :show-overflow-tooltip="true"/>
        <el-table-column prop="scanMsg" label="扫描信息" min-width="20%" :show-overflow-tooltip="true"/>
        <el-table-column prop="updater" label="更新人" min-width="10%" :show-overflow-tooltip="true"/>
        <el-table-column prop="updateTime" label="更新时间" :formatter="dateFormatter" min-width="10%" :show-overflow-tooltip="true"/>
        <el-table-column prop="operation" label="操作" min-width="10%">
          <template slot-scope="scope">
            <el-tooltip class="item" content="编辑" placement="top">
              <el-button size="mini" @click="editSubmit(scope.row)" type="primary" icon="el-icon-edit"/>
            </el-tooltip>
            <el-tooltip class="item" content="删除" placement="top">
              <el-button size="mini" @click="deleteSubmit(scope.row)" type="danger" icon="el-icon-delete"/>
            </el-tooltip>
            <el-tooltip class="item" content="TAG编辑" placement="top">
              <el-button size="mini" @click="tagManager(scope.row)" type="success" icon="el-icon-document-add"/>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        @size-change="querySubmit"
        @current-change="querySubmit"
        :current-page.sync="pageParam.page"
        :page-sizes.sync="pageParam.pageList"
        :page-size.sync="pageParam.pageSize"
        :total.sync="pageParam.total"
        layout="->,total, sizes, prev, pager, next"/>
    </el-main>
    <library-info ref="libraryInfo"/>
    <tag-info ref="tagInfo"/>
  </el-container>
</template>

<script>
  import Constant from "@/js/common/constant";
  import api from "@/js/api/library";
  import {formatTimestamp} from '@/js/common/date'
  import LibraryInfo from "@/page/comic/library/compent/LibraryInfo";
  import loading from "@/js/common/loading";
  import TagInfo from "@/page/comic/library/compent/TagInfo";
  
  export default {
    name: 'Library',
    components: {TagInfo, LibraryInfo},
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
        api.libraryList({
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
        this.$refs.libraryInfo.openAdd(this)
      },
      editSubmit(row) {
        this.$refs.libraryInfo.openEdit(this, row)
      },
      deleteSubmit(row) {
        this.$confirm('请确认是否要删除', '删除', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          showClose: false,
          confirmButtonClass: 'el-button--danger'
        }).then(() => {
          loading.start('正在删除')
          api.removeLibrary({libraryId: row.id}).then(() => {
            this.$message.success("删除成功")
            this.querySubmit()
          }).finally(() => {
            loading.stop()
          })
        })
      },
      tagManager(row) {
        this.$refs.tagInfo.open(this, row)
      },
      dateFormatter(row, column, cellValue) {
        return formatTimestamp(cellValue)
      }
    }
  }
</script>

<style scoped>

</style>
