package kr.co.teaspoon.controller;

import kr.co.teaspoon.service.MenuServiceImpl;
import kr.co.teaspoon.util.Week;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menu/*")
public class MenuCtrl {

    @Autowired
    private MenuServiceImpl menuService;

    @Autowired
    HttpSession session; // 세션 생성

    /*
    @GetMapping("list.do")		//info/list.do
    public String getinfoList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

        String schoolName = request.getParameter("name");
        List<String> ddishList; // 식단
        List<String> mlsvList; // 날짜
        List<String> orplcList; // 원산지
        List<String> calList; // 칼로리
        List<String> ntrList; // 영양

        Week week = new Week();

        List<String> date = week.getDate();

        Map<String, Integer> codeS = new HashMap<>();
        codeS.put("경인고", 7010563);
        codeS.put("고척중", 7041168);
        codeS.put("신구로초", 7041136);
        codeS.put("풍광초", 8011206);
        codeS.put("서원중", 8011017);
        codeS.put("청주고", 8000066);
        codeS.put("도장초", 7642017);
        codeS.put("병점중", 7679110);
        codeS.put("예당고", 7530849);
        codeS.put("밀양초", 9101008);
        codeS.put("밀양중", 9101030);
        codeS.put("밀양고", 9010051);
        codeS.put("동신초", 7121302);
        codeS.put("운천중", 7679120);
        codeS.put("운천고", 7530572);

        Map<String, String> codeK = new HashMap<>();
        codeK.put("경인고", "B10");
        codeK.put("고척중", "B10");
        codeK.put("신구로초", "B10");
        codeK.put("풍광초", "M10");
        codeK.put("서원중", "M10");
        codeK.put("청주고", "M10");
        codeK.put("도장초", "J10");
        codeK.put("병점중", "J10");
        codeK.put("예당고", "J10");
        codeK.put("밀양초", "S10");
        codeK.put("밀양중", "S10");
        codeK.put("밀양고", "S10");
        codeK.put("동신초", "B10");
        codeK.put("운천중", "J10");
        codeK.put("운천고", "J10");

        int minValue = 1;
        int maxValue = 5;

        menuService.menuServiceSet(codeS, codeK, date, schoolName, minValue, maxValue);
        ddishList = menuService.getDdishList();
        mlsvList = menuService.getMlsvList();
        orplcList = menuService.getOrplcList();
        calList = menuService.getCalList();
        ntrList = menuService.getNtrList();


        model.addAttribute("schoolName", schoolName);
        model.addAttribute("ddishList", ddishList);
        model.addAttribute("mlsvList", mlsvList);
        model.addAttribute("orplcList", orplcList);
        model.addAttribute("calList", calList);
        model.addAttribute("ntrList", ntrList);
        return "/menu/menuList";
    }*/

    /*
    @PostMapping("list.do")		//info/list.do
    public String postinfoList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

        String schoolName = request.getParameter("name");
        List<String> ddishList; // 식단
        List<String> mlsvList; // 날짜
        List<String> orplcList; // 원산지
        List<String> calList; // 칼로리
        List<String> ntrList; // 영양

        Week week = new Week();

        List<String> date = week.getDate();

        Map<String, Integer> codeS = new HashMap<>();
        codeS.put("경인고", 7010563);
        codeS.put("고척중", 7041168);
        codeS.put("신구로초", 7041136);
        codeS.put("풍광초", 8011206);
        codeS.put("서원중", 8011017);
        codeS.put("청주고", 8000066);
        codeS.put("도장초", 7642017);
        codeS.put("병점중", 7679110);
        codeS.put("예당고", 7530849);
        codeS.put("밀양초", 9101008);
        codeS.put("밀양중", 9101030);
        codeS.put("밀양고", 9010051);
        codeS.put("동신초", 7121302);
        codeS.put("운천중", 7679120);
        codeS.put("운천고", 7530572);

        Map<String, String> codeK = new HashMap<>();
        codeK.put("경인고", "B10");
        codeK.put("고척중", "B10");
        codeK.put("신구로초", "B10");
        codeK.put("풍광초", "M10");
        codeK.put("서원중", "M10");
        codeK.put("청주고", "M10");
        codeK.put("도장초", "J10");
        codeK.put("병점중", "J10");
        codeK.put("예당고", "J10");
        codeK.put("밀양초", "S10");
        codeK.put("밀양중", "S10");
        codeK.put("밀양고", "S10");
        codeK.put("동신초", "B10");
        codeK.put("운천중", "J10");
        codeK.put("운천고", "J10");

        int minValue = 1;
        int maxValue = 5;

        menuService.menuServiceSet(codeS, codeK, date, schoolName, minValue, maxValue);
        ddishList = menuService.getDdishList();
        mlsvList = menuService.getMlsvList();
        orplcList = menuService.getOrplcList();
        calList = menuService.getCalList();
        ntrList = menuService.getNtrList();


        model.addAttribute("schoolName", schoolName);
        model.addAttribute("ddishList", ddishList);
        model.addAttribute("mlsvList", mlsvList);
        model.addAttribute("orplcList", orplcList);
        model.addAttribute("calList", calList);
        model.addAttribute("ntrList", ntrList);
        return "/menu/menuList";
    }*/
}
