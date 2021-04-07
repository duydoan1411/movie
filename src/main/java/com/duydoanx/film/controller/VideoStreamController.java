package com.duydoanx.film.controller;

import com.duydoanx.film.service.VideoStreamService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/videos")
public class VideoStreamController {

    private final VideoStreamService videoStreamService;

    public VideoStreamController(VideoStreamService videoStreamService) {
        this.videoStreamService = videoStreamService;
    }

    @GetMapping("/stream/{id}")
    public Mono<ResponseEntity<byte[]>> streamVideo(
            @RequestHeader(value = "Range", required = false) String httpRangeList,
            @PathVariable(name = "id") int id) {
        return Mono.just(videoStreamService.prepareContent(id, httpRangeList));
    }
}
