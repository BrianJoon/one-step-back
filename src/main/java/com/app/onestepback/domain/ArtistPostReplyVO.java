package com.app.onestepback.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ArtistPostReplyVO {
    private Long id;
    private Long artistPostId;
    private Long memberId;
}