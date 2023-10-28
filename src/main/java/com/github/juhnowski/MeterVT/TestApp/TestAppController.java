package com.github.juhnowski.MeterVT.TestApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TestAppController {
	private final StorageService storageService;

	public TestAppController(StorageService storageService) {
		this.storageService = storageService;
	}

    @PostMapping("/auth")
    public String auth(@RequestBody String body) {
        return "access_token";
    }

    @GetMapping("api/engagements")
    public String eng(@RequestParam Integer limit) {
        return "OK";
    }

    @PatchMapping("api/engagements")
    public String upload(@RequestBody MultipartFile file) {
        storageService.store(file);
        return "OK:";
    }


}
