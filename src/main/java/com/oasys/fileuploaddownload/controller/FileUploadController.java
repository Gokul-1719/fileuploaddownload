package com.oasys.fileuploaddownload.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oasys.fileuploaddownload.model.DatabaseFile;
import com.oasys.fileuploaddownload.payload.Response;
import com.oasys.fileuploaddownload.service.DatabaseFileService;
@RestController
@RequestMapping(value = "image")	
public class FileUploadController {

    @Autowired
    private DatabaseFileService fileStorageService;

    @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam("file") MultipartFile file) {
        DatabaseFile fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/downloadFile/")
            .path(fileName.getFileName())
            .toUriString();

        return new Response(fileName.getFileName(), fileDownloadUri,
            file.getContentType(), file.getSize());
    }

    
    @PostMapping(value="/uploadMultipleFiles")
//    @PostMapping(value = "/uploadMultipleFiles",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List <Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
            .stream()
            .map(file -> uploadFile(file))
            .collect(Collectors.toList());
    }
    
    
    @GetMapping("/files")
    public List<DatabaseFile> getAllFiles() {
        return fileStorageService.getAllFiles(); // Assuming this method exists in DatabaseFileService to fetch all files
    }

}