package FileExample.fileExample.controller;

import FileExample.fileExample.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:8002")
@RequestMapping("/directory")
public class DirectoryCreateDeleteController  {

    @Autowired
    private  DirectoryService directoryService;

    @PostMapping(path = "/createDirectory")
    public static ResponseEntity<Object> createDirectory() throws NullPointerException{
        return DirectoryService.createDirectory();
    }

    @GetMapping("/getDirectoryList")
    public static ResponseEntity getDirectoryList() throws NullPointerException{
        return DirectoryService.getDirectoryContentListService();
    }

}

//
//    @DeleteMapping(path = "/deleteDirectory")
//    public static ResponseEntity<Object> deleteDirectory() {
//        return DirectoryService.deleteDirectoryService();
//    }
//

