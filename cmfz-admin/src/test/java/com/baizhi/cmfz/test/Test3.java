package com.baizhi.cmfz.test;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by HP on 2018/7/8.
 */
public class Test3 {
    @Test
    public void test1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("/applicationContext.xml");
        GuruDao guruDao=(GuruDao)ctx.getBean("guruDao");
        List<Guru> list=guruDao.findGuruByPage(2,3);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("上师","上师"),Guru.class, list);
    }

    @Test
    public void test2(){
        ImportParams params = new ImportParams();
        long start=new Date().getTime();
        List<Guru> list = ExcelImportUtil.importExcel(
                new File(PoiPublicUtil.getWebRootPath("import/guru.xlsx")),
               Guru.class, params);
        ApplicationContext ctx=new ClassPathXmlApplicationContext("/applicationContext.xml");
        GuruService guruService= (GuruService)ctx.getBean("guruServiceImpl");
        for (Guru guru : list) {
            guruService.addGuru(guru);
        }

    }
}
