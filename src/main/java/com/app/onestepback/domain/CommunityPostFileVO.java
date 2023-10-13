package com.app.onestepback.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommunityPostFileVO {
    private Long id;
    private Long communityPostId;
    private String fileName;
    private String filePath;
}