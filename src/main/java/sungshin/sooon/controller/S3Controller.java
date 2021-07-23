package sungshin.sooon.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sungshin.sooon.service.S3Uploader;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class S3Controller {

    private final S3Uploader s3Uploader;

    @PostMapping("/upload")
    public String upload(@RequestParam("data") MultipartFile multipartFile) throws IOException {
        return s3Uploader.upload(multipartFile, "static");
    }
}
