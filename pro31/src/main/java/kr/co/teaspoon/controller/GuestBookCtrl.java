package kr.co.teaspoon.controller;

import kr.co.teaspoon.dto.FileInfo;
import kr.co.teaspoon.dto.Free;
import kr.co.teaspoon.dto.GuestBook;
import kr.co.teaspoon.dto.Member;
import kr.co.teaspoon.service.GuestBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/guestbook/*")
public class GuestBookCtrl {

    @Autowired
    ServletContext servletContext;

    @Autowired
    private GuestBookService guestBookService;

    @RequestMapping(value = "insert.do", method = RequestMethod.GET)
    public String write() {
        return "/guestbook/guestBookInsert";
    }

    @RequestMapping(value = "insert.do", method = RequestMethod.POST)
    public String write(GuestBook guestBookDto, @RequestParam("upfile") MultipartFile[] files, Model model, HttpSession session) throws IllegalStateException, IOException {
        Member member = (Member) session.getAttribute("member");
        if (member != null) {
            String realPath = servletContext.getRealPath("/pro3_war/resources/upload");
            String today = new SimpleDateFormat("yyMMdd").format(new Date());
            String saveFolder = realPath + File.separator + today;
            System.out.println(saveFolder);
            File folder = new File(saveFolder);
            if(!folder.exists())
                folder.mkdirs();
            List<FileInfo> fileInfos = new ArrayList<FileInfo>();
            for (MultipartFile mfile : files) {
                FileInfo fileInfoDto = new FileInfo();
                String originalFileName = mfile.getOriginalFilename();
                if (!originalFileName.isEmpty()) {
                    String saveFileName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf('.'));
                    fileInfoDto.setSaveFolder(today);
                    fileInfoDto.setOriginFile(originalFileName);
                    fileInfoDto.setSaveFile(saveFileName);
                    System.out.println(mfile.getOriginalFilename() + "   " + saveFileName);
                    mfile.transferTo(new File(folder, saveFileName));
                }
                fileInfos.add(fileInfoDto);
            }
            guestBookDto.setFileInfos(fileInfos);
            guestBookDto.setUserid(member.getId());
            try {
                guestBookService.writeArticle(guestBookDto);
                return "/guestbook/writesuccess";
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("msg", "글 작성중 문제가 발생했습니다.");
                return "/error/error";
            }
        } else {
            model.addAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
            return "/error/error";
        }
    }
}
