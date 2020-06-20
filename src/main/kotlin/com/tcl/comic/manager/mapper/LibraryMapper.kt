package com.tcl.comic.manager.mapper

import com.tcl.comic.manager.entity.library.LibraryModifyVO
import com.tcl.comic.manager.entity.library.LibraryRequestVO
import com.tcl.comic.manager.entity.library.LibraryVO
import com.tcl.comic.manager.entity.library.TagVO
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 * Created by traburiss on 2020/6/20.
 * describe:
 */
@Repository
interface LibraryMapper {
    fun libraryList(@Param("query") query: LibraryRequestVO, @Param("start") start: Int, @Param("pageSize") pageSize: Int): List<LibraryVO>
    fun libraryCount(@Param("query") query: LibraryRequestVO): Int
    fun getLibrary(@Param("libraryId") libraryId: Int): LibraryVO?
    fun addLibrary(@Param("item") library: LibraryModifyVO, @Param("userId") userId: Int)
    fun editLibrary(@Param("item") library: LibraryModifyVO, @Param("userId") userId: Int)
    fun removeLibrary(@Param("libraryId") libraryId: Int, @Param("userId") userId: Int)
    fun tagList(@Param("libraryId") libraryId: Int): List<TagVO>
    fun addTag(@Param("tag") tagList: TagVO, @Param("libraryId") libraryId: Int, @Param("userId") userId: Int)
    fun removeTag(@Param("tagId") tagId: Int, @Param("userId") userId: Int)
}
