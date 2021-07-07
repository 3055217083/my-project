package com.song.springboot.controller.used4study或者test;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.song.springboot.AAA_TWO2222222222.燃えろ俺の小宇宙よ.NameEnum;
import com.song.springboot.entity.learn.Book;
import com.song.springboot.service.learn.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.RolesAllowed;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/6/21 9:46
 */
@Controller
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    HelloService helloService;
    @Autowired
    DefaultKaptcha defaultKaptcha;

    @ResponseBody
    @GetMapping(value = {"/", "/f"})
    Book getHello() throws Exception {
        if (false) {
            NameEnum nameEnum = NameEnum.SONG_ZHI_XIAN;
            throw new Exception("12321");
        }
        return helloService.selectAll();
    }

    @Secured({"ROLE_1", "ROLE_2"})
    @RolesAllowed({"1", "2"})
    @PreAuthorize("hasRole('ROLE_1')")
    @GetMapping(value = {"/hello"})
    String goToJSP() {
        return "used4studyORtest/hello";
    }

    @GetMapping(value = {"/nihao"})
    String goToHTML() {
        return "html/used4studyORtest/hello";
    }

    @GetMapping("/error/404")
    public String error404() {
        return "templates/error/40X";
    }

    @GetMapping("/error/500")
    public String error500() {
        return "templates/error/50X";
    }

    /**
     * yan zheng ma , bu tai xing de yang zi
     * 验证码,不太行的样子
     * @params :
     * @returns :
     */
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @RequestMapping("/imgvrifyControllerDefaultKaptcha")
    public String imgvrifyControllerDefaultKaptcha(HttpServletRequest httpServletRequest, Model model){
        String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
        String parameter = httpServletRequest.getParameter("vrifyCode");
        System.out.println("Session  vrifyCode "+captchaId+" form vrifyCode "+parameter);

        if (!captchaId.equals(parameter)) {
            model.addAttribute("info", "错误的验证码");
            log.error("错误的验证码");
        } else {
            model.addAttribute("info", "登录成功");
        }
        return "html/used4studyORtest/hello";
    }
}
