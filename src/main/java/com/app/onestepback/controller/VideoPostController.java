package com.app.onestepback.controller;

import com.app.onestepback.domain.ArtistPostDTO;
import com.app.onestepback.domain.MemberVO;
import com.app.onestepback.domain.Pagination;
import com.app.onestepback.domain.VideoPostDTO;
import com.app.onestepback.service.VideoPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/artist/video/*")
public class VideoPostController {
    private final VideoPostService videoPostService;

    @GetMapping("list")
    public void goToVideoList(Pagination pagination, @RequestParam("memberId") Long memberId, @RequestParam(value = "page", required = false) Integer page, Model model){
        model.addAttribute("artist", videoPostService.getArtist(memberId).get());

        pagination.setTotal(videoPostService.getPostCount(memberId));
        pagination.setPage(page);
        pagination.setRowCount(10);
        pagination.progress();
        model.addAttribute("pagination", pagination);
        model.addAttribute("videos", videoPostService.getAllVideos(memberId, pagination));
    }

    @GetMapping("write")
    public void goToPostWriteForm(VideoPostDTO videoPostDTO, HttpSession session, Model model) {
        MemberVO memberSession = (MemberVO) session.getAttribute("member");

        model.addAttribute("memberId", memberSession.getId());
    }

    @PostMapping("write")
    public RedirectView saveArtistPost(VideoPostDTO videoPostDTO, @RequestParam("numberOfTags") int numberOfTags, @RequestParam(value = "uuid", required = false) List<String> uuids, @RequestParam(value = "uploadFile", required = false) List<MultipartFile> uploadFiles) {
        videoPostService.savePost(videoPostDTO, numberOfTags);

        return new RedirectView("/artist/video/detail?id=" + videoPostDTO.getId());
    }
}
