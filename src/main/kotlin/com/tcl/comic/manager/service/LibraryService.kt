package com.tcl.comic.manager.service

import com.tcl.comic.manager.entity.Page
import com.tcl.comic.manager.entity.Response
import com.tcl.comic.manager.entity.ResponseCode
import com.tcl.comic.manager.entity.library.LibraryModifyVO
import com.tcl.comic.manager.entity.library.LibraryRequestVO
import com.tcl.comic.manager.entity.library.LibraryVO
import com.tcl.comic.manager.entity.library.TagVO
import com.tcl.comic.manager.mapper.LibraryMapper
import org.apache.commons.lang3.ObjectUtils
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by traburiss on 2020/6/20.
 * describe:
 */
@Service
class LibraryService {

    @Autowired
    private lateinit var libraryMapper: LibraryMapper

    fun getLibraryList(query: LibraryRequestVO): Response<Page<LibraryVO>> {
        if (ObjectUtils.isEmpty(query)) {
            return Response(Page(emptyList(), 0), ResponseCode.PARAM_ERROR.code, "参数为空，请检查参数")
        }
        val start = query.start()
        val list = libraryMapper.libraryList(query, start, query.pageSize)
        val count = libraryMapper.libraryCount(query)
        val data = Page(list, count)
        return Response(data)
    }

    @Transactional
    fun addLibrary(library: LibraryModifyVO, userId: Int, roleId: Int): Response<Boolean> {
        if (ObjectUtils.isEmpty(library)) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "参数为空，请检查参数")
        }
        libraryMapper.addLibrary(library, userId)
        libraryMapper.addDefaultLibraryRoleMap(library.id, roleId)
        return Response(true)
    }

    fun editLibrary(library: LibraryModifyVO, userId: Int): Response<Boolean> {
        if (ObjectUtils.isEmpty(library)) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "参数为空，请检查参数")
        }
        if (libraryMapper.getLibrary(library.id) == null) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "不存在该书库信息，请确认后重试")
        }
        libraryMapper.editLibrary(library, userId)
        return Response(true)
    }

    fun removeLibrary(libraryId: Int, userId: Int): Response<Boolean> {
        if (libraryMapper.getLibrary(libraryId) == null) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "不存在该书库信息，请确认后重试")
        }
        libraryMapper.removeLibrary(libraryId, userId)
        return Response(true)
    }

    fun tagList(libraryId: Int): Response<List<TagVO>> {
        if (libraryMapper.getLibrary(libraryId) == null) {
            return Response(emptyList(), ResponseCode.PARAM_ERROR.code, "不存在该书库信息，请确认后重试")
        }
        val data = libraryMapper.tagList(libraryId)
        return Response(data)
    }

    fun addTag(addTag: TagVO, userId: Int): Response<Boolean> {
        if (ObjectUtils.isEmpty(addTag)) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "参数为空，请检查参数")
        }
        if (StringUtils.isBlank(addTag.name)) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "没有标签信息，请检查参数")
        }
        if (libraryMapper.getLibrary(addTag.libraryId) == null) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "没有书库信息，请检查参数")
        }
        libraryMapper.addTag(addTag, addTag.libraryId, userId)
        return Response(true)
    }

    fun removeTag(tagId: Int, userId: Int): Response<Boolean> {
        libraryMapper.removeTag(tagId, userId)
        return Response(true)
    }
}
