package com.okulyonetim.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestKontrol {

    @GetMapping("/")
    public String home() {
        return "Okul Yönetim Sistemi API'ye Hoş Geldiniz!";
    }

    @GetMapping("/test")
    public String test() {
        return "Sistem çalışıyor!";
    }
}
