package com.tcl.comic.manager.controller

import com.tcl.comic.manager.config.Constant
import com.tcl.comic.manager.entity.Page
import com.tcl.comic.manager.entity.Response
import com.tcl.comic.manager.entity.library.LibraryModifyVO
import com.tcl.comic.manager.entity.library.LibraryRequestVO
import com.tcl.comic.manager.entity.library.LibraryVO
import com.tcl.comic.manager.entity.library.TagVO
import com.tcl.comic.manager.service.LibraryService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

/**
 * Created by traburiss on 2020/6/20.
 * describe:
 */
@RestController
@RequestMapping("/api/library")
@Tag(name = "LibraryController", description = "书库接口")
class LibraryController {

    @Autowired
    private lateinit var libraryService: LibraryService

    @Operation(summary = "获取书库配置")
    @GetMapping("/list")
    fun libraryList(query: LibraryRequestVO, model: Model): Mono<Response<Page<LibraryVO>>> {
        return Mono.fromSupplier {
            val roleId = model.getAttribute(Constant.ROLE_ID) as Int
            query.roleId = roleId
            libraryService.getLibraryList(query)
        }
    }

    @Operation(summary = "新增书库")
    @PostMapping("/add")
    fun addLibrary(@RequestBody library: LibraryModifyVO, model: Model): Mono<Response<Boolean>> {
        return Mono.fromSupplier {
            val userId = model.getAttribute(Constant.LOGIN_ID) as Int
            val roleId = model.getAttribute(Constant.ROLE_ID) as Int
            libraryService.addLibrary(library, userId, roleId)
        }
    }

    @Operation(summary = "修改书库")
    @PostMapping("/edit")
    fun editLibrary(@RequestBody library: LibraryModifyVO, model: Model): Mono<Response<Boolean>> {
        return Mono.fromSupplier {
            val userId = model.getAttribute(Constant.LOGIN_ID) as Int
            libraryService.editLibrary(library, userId)
        }
    }

    @Operation(summary = "删除书库")
    @DeleteMapping("/remove")
    fun removeLibrary(@RequestParam("libraryId") libraryId: Int, model: Model): Mono<Response<Boolean>> {
        return Mono.fromSupplier {
            val userId = model.getAttribute(Constant.LOGIN_ID) as Int
            libraryService.removeLibrary(libraryId, userId)
        }
    }

    @Operation(summary = "获取标签列表")
    @GetMapping("/tag/list")
    fun addTag(@RequestParam("libraryId") libraryId: Int): Mono<Response<List<TagVO>>> {
        return Mono.fromSupplier {
            libraryService.tagList(libraryId)
        }
    }

    @Operation(summary = "新增标签列表")
    @PostMapping("/tag/add")
    fun addTag(@RequestBody addTag: TagVO, model: Model): Mono<Response<Boolean>> {
        return Mono.fromSupplier {
            val userId = model.getAttribute(Constant.LOGIN_ID) as Int
            libraryService.addTag(addTag, userId)
        }
    }

    @Operation(summary = "删除标签")
    @DeleteMapping("/tag/remove")
    fun removeTag(@RequestParam("tagId") tagId: Int, model: Model): Mono<Response<Boolean>> {
        return Mono.fromSupplier {
            val userId = model.getAttribute(Constant.LOGIN_ID) as Int
            libraryService.removeTag(tagId, userId)
        }
    }
}
