//package com.oasys.fileuploaddownload.controller;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.oasys.fileuploaddownload.model.DatabaseFile;
//import com.oasys.fileuploaddownload.service.DatabaseFileService;
//
//
//
//@RestController
//public class FileDownloadController {
//
////    @Autowired
////    private DatabaseFileService fileStorageService;
////
//////    @GetMapping("/downloadFile/{fileName:.+}")
//////    public ResponseEntity < Resource > downloadFile(@PathVariable String fileName, HttpServletRequest request) {
//////        // Load file as Resource
//////        DatabaseFile databaseFile = fileStorageService.getFile(fileName);
//////
//////        return ResponseEntity.ok()
//////            .contentType(MediaType.parseMediaType(databaseFile.getFileType()))
//////            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
//////            .body(new ByteArrayResource(databaseFile.getData()));
//////    }
//////}