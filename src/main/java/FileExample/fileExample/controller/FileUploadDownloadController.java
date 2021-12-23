package FileExample.fileExample.controller;

import FileExample.fileExample.entity.FileEntities;
import FileExample.fileExample.message.ResponseFile;
import FileExample.fileExample.message.ResponseMessage;
import FileExample.fileExample.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:8002")
@RequestMapping("/directory")
public class FileUploadDownloadController {

    @Autowired
    private FileService fileService;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private String loggerInfo = "";

    @PostMapping("/uploadFile")
    public ResponseEntity<ResponseMessage> fileUpload(@RequestParam("File") MultipartFile file) throws NullPointerException{


        try {
            fileService.uploadFile(file);
            loggerInfo = file.getOriginalFilename() + " uploaded successfully ";
            logger.info(loggerInfo);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(loggerInfo));

        } catch (Exception exception) {
            loggerInfo = file.getOriginalFilename() + " can't be uploaded, file exists";
            logger.info(loggerInfo);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(loggerInfo));
        }
    }

    @GetMapping("/getFiles")
    public ResponseEntity<List<ResponseFile>> getFilesList() throws NullPointerException{
        List<ResponseFile> filesList = fileService.getAllFiles().map(fileEntities -> {
            String fileUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/getFiles/")
                    .path(fileEntities.getId())
                    .toUriString();
            return new ResponseFile(
                    fileEntities.getId(),
                    fileEntities.getFileName(),
                    fileEntities.getType(),
                    fileEntities.getSize().length,
                    fileUri);

        }).collect(Collectors.toList());
        loggerInfo = "All files from DB are listed";
        logger.info(loggerInfo);
        return ResponseEntity.status(HttpStatus.OK).body(filesList);
    }

    @GetMapping("/getFile/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) throws NullPointerException{
        FileEntities getFileEntities = fileService.getFile(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName= " + getFileEntities.getFileName())
                .body(getFileEntities.getSize());
    }

    @DeleteMapping("/deleteFile/{id}")
    public ResponseEntity<byte[]> deleteFile(@PathVariable String id) throws NullPointerException{
        String deleteFileEntities = fileService.deleteFile(id);
        loggerInfo = "The file has been deleted successfully";
        logger.info(loggerInfo);
        return new ResponseEntity(loggerInfo, HttpStatus.OK);
    }



}



