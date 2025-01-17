package com.app.onestepback.service;

import com.app.onestepback.domain.ArtistDTO;
import com.app.onestepback.domain.Pagination;
import com.app.onestepback.domain.VideoPostDTO;

import java.util.List;
import java.util.Optional;

public interface VideoPostService {

    public Optional<ArtistDTO> getArtist(Long memberId);

    public int getPostCount(Long memberId);

    public List<VideoPostDTO> getAllVideos(Long memberId, Pagination pagination);

    public void savePost(VideoPostDTO videoPostDTO, int numberOfTags);
}
