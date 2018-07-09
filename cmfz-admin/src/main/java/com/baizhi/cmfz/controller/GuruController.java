package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by HP on 2018/7/6.
 */
@Controller
@RequestMapping("/guru")
public class GuruController {

    @Autowired
    private GuruService guruService;

    @RequestMapping("/findByPage")
    @ResponseBody
    public Map<String,Object> findByPage(@RequestParam("page") Integer nowPage, @RequestParam("rows") Integer pageSize){
        return guruService.queryGuruByPage(nowPage,pageSize);
    }

    @RequestMapping("/findByPageMohu")
    @ResponseBody
    public Map<String,Object> findByPageMohu(String value,@RequestParam("page") Integer nowPage,@RequestParam("rows") Integer pageSize){
        return guruService.queryGuruByPageMohu(value,nowPage,pageSize);
    }


    @RequestMapping("/modify")
    @ResponseBody
    public Map<String,Object> modify(Guru guru){
        Map<String, Object> map=new HashMap<String, Object>();
        try {
            int result=guruService.modifyGuru(guru);
            map.put("result", "success");
        } catch (Exception e) {
            // TODO: handle exception
            map.put("result", "fail");
        }
        return map;
    }

    @RequestMapping("/upload")
    public @ResponseBody Map<String,Object> upload(MultipartFile myfile, HttpSession session,Guru guru) throws IOException {
        //1.获得文件夹真实路径
        String realPath=session.getServletContext().getRealPath("/");
        int lastIndexOf=realPath.lastIndexOf("\\");
        String substring=realPath.substring(0,lastIndexOf);
        int lastIndexOf1=substring.lastIndexOf("\\");
        String substring1=realPath.substring(0,lastIndexOf1);
        String uploadPath=substring1+"\\Files";
        //2.生成UUID
        String guruId= UUID.randomUUID().toString().replace("-", "");
        guru.setGuruId(guruId);
        //3.读取文件后缀名
        //（1）获取上传文件名称
        String guruPhoto=myfile.getOriginalFilename();
        guru.setGuruPhoto(guruPhoto);
        //（3）组装
        myfile.transferTo(new File(uploadPath+"\\"+guruPhoto));
        int num=guruService.addGuru(guru);
        Map<String, Object> map=new HashMap<String, Object>();
        if(num>0){
            map.put("result","succeess");
        }
        return map;
    }

    @RequestMapping("importParams")
    public @ResponseBody Map<String,Object> importParams(HttpSession session,MultipartFile myfile) throws Exception{
        String realPath=session.getServletContext().getRealPath("/");
        int lastIndexOf=realPath.lastIndexOf("\\");
        String substring=realPath.substring(0,lastIndexOf);
        int lastIndexOf1=substring.lastIndexOf("\\");
        String substring1=realPath.substring(0,lastIndexOf1);
        String uploadPath=substring1+"\\Files";
        //3.读取文件后缀名
        //（1）获取上传文件名称
        String guruFile=myfile.getOriginalFilename();
        //（3）组装
        myfile.transferTo(new File(uploadPath+"\\"+guruFile));
        ImportParams params = new ImportParams();
        List<Guru> list = ExcelImportUtil.importExcel(myfile.getInputStream(),
                Guru.class, params);
        guruService.addAllGuru(list);
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("result","success");
        return map;
    }

    @RequestMapping("export")
    public void exportGuru(HttpServletResponse response) throws  Exception{
        List<Guru> gurus=guruService.queryAllGuru();
        //Excel文件
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("上师","上师"),Guru.class, gurus);
        ServletOutputStream out=response.getOutputStream();
        //文件下载，设置响应头
        //响应头默认使用编码格式iso-8859-1;
        String fileName=new String("上师信息.xlsx".getBytes(),"iso-8859-1");
        response.setContentType("application/vnd.ms-excel");    //响应类型
        response.setHeader("content-disposition","attachment;fileName="+fileName);
        //导出，文件下载方式
        workbook.write(out);
        out.close();
    }
}
