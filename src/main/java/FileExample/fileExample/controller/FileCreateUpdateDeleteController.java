package FileExample.fileExample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/directory")
public class FileCreateUpdateDeleteController {


    @PostMapping(path = "/createFile")
    public static ResponseEntity<Object> createFile() throws NullPointerException, IOException {
        File createFile = new File("C:\\Users\\timki\\Documents\\cybernetica\\test.txt");

        if (createFile.exists()) {
            return new ResponseEntity<Object>("Opps, such file already been created", HttpStatus.BAD_REQUEST);
        } else {
            createFile.createNewFile();
            return new ResponseEntity<Object>(createFile.getName() + " has been created", HttpStatus.OK);
        }
    }

    @DeleteMapping(path = "/deleteFile")
    public static ResponseEntity<Object> deleteFile() throws NullPointerException {
        File deleteFile = new File("C:\\Users\\timki\\Documents\\cybernetica\\testFile.txt");

        if (deleteFile.exists()) {
            deleteFile.delete();
            return new ResponseEntity<Object>(deleteFile.getName() + " has been deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(deleteFile.getName() + " oops, such file was not found", HttpStatus.NOT_FOUND);
        }
    }

}







