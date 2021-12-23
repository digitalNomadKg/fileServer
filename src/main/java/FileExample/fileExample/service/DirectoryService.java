package FileExample.fileExample.service;


import FileExample.fileExample.entity.DirectoryEntities;
import FileExample.fileExample.repository.DirectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;


@Service
public class DirectoryService {

    @Autowired
    private DirectoryRepository directoryRepository;

    private final static String DIRECTORY_PATH = "C:\\Users\\timki\\Documents\\cybernetica\\";

    public static ResponseEntity<Object> createDirectory() {

        DirectoryEntities directoryEntities = new DirectoryEntities("", "", "");

        File createDirectory = new File(DIRECTORY_PATH);

        try {
            if (createDirectory.exists()) {
                System.out.println("Sorry, such directory already exists");
                return new ResponseEntity<Object>("Sorry, such directory already exists", HttpStatus.BAD_REQUEST);
            } else {
                createDirectory.mkdir();
                System.out.println(" directory has been created successfully");
                return new ResponseEntity<Object>(" directory has been created successfully", HttpStatus.CREATED);

            }

        } catch (Exception exception) {
            return new ResponseEntity<Object>("bad request", HttpStatus.EXPECTATION_FAILED);
        }

    }

    public static ResponseEntity<Object> getDirectoryContentListService() {

        File getDirectoryFiles = new File(DIRECTORY_PATH);

        if (getDirectoryFiles.exists()) {
            String[] getList = getDirectoryFiles.list();
            if (getList == null || getList.length == 0) {
                System.out.println("Local directory: " + getDirectoryFiles.getAbsolutePath() + " is empty");
                return new ResponseEntity<>("Directory is empty", HttpStatus.BAD_REQUEST);

            } else {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Local directory: " + getDirectoryFiles.getAbsolutePath() + " contains: ");
                for (int i = 0; i < getList.length; i++) {
                    System.out.println(getList[i]);
                }
                return new ResponseEntity<>("Directory content listed", HttpStatus.OK);

            }
        }
        System.out.println("DIRECTORY NOT FOUND");
        return new ResponseEntity<>("DIRECTORY NOT FOUND", HttpStatus.NOT_FOUND);
    }


//    public static ResponseEntity<Object> deleteDirectoryService() {
//
//        File deleteDirectory = new File(FILE_PATH);
//
//        if (deleteDirectory.isDirectory()) {
//            String[] list = deleteDirectory.list();
//            if (list == null || list.length == 0) {
//                deleteDirectory.delete();
//                System.out.println(deleteDirectory.getDirectoryName() + " directory was deleted successfully");
//                return new ResponseEntity<Object>(deleteDirectory.getDirectoryName() + " directory was deleted successfully", HttpStatus.OK);
//
//            } else {
//                System.out.println("Oops, " + deleteDirectory.getDirectoryName() + " directory is not empty and can't be deleted");
//                return new ResponseEntity<Object>("Oops, " + deleteDirectory.getDirectoryName() + " directory is not empty and can't be deleted", HttpStatus.BAD_REQUEST);
//            }
//        }
//        System.out.println("DIRECTORY NOT FOUND");
//        return new ResponseEntity<Object>("DIRECTORY NOT FOUND", HttpStatus.NOT_FOUND);
//    }


}


