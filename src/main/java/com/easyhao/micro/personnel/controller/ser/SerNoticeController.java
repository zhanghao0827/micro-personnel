package com.easyhao.micro.personnel.controller.ser;

import com.easyhao.micro.personnel.entity.SerNotice;
import com.easyhao.micro.personnel.service.ISerNoticeService;
import com.easyhao.micro.personnel.utils.JsonResult;
import com.easyhao.micro.personnel.aop.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ser/notice")
public class SerNoticeController {

    @Autowired
    ISerNoticeService noticeService;

    /**
     * axios不支持get请求传递json数据
     */
    @PostMapping("/list")
    public List<SerNotice> list(@RequestBody SerNotice notice) {
        return noticeService.selectNoticeList(notice);
    }

    @PostMapping("/")
    @Log(module = "通知公告", operContent = "添加")
    public JsonResult insert(@RequestBody SerNotice notice) {
        if (noticeService.insertNotice(notice) == 1) {
            return JsonResult.success("添加成功！");
        }
        return JsonResult.error("添加失败！");
    }

    @DeleteMapping("/{noticeId}")
    @Log(module = "通知公告", operContent = "删除")
    public JsonResult delete(@PathVariable Long noticeId) {
        if (noticeService.deleteNoticeById(noticeId) == 1) {
            return JsonResult.success("删除成功！");
        }
        return JsonResult.error("删除失败！");
    }

    @PutMapping("/")
    @Log(module = "通知公告", operContent = "更新")
    public JsonResult update(@RequestBody SerNotice notice) {
        if (noticeService.updateNotice(notice) == 1) {
            return JsonResult.success("更新成功！");
        }
        return JsonResult.error("更新失败！");
    }

}
