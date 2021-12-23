package FileExample.fileExample.service;

import FileExample.fileExample.entity.FileEntities;
import FileExample.fileExample.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import java.util.stream.Stream;

@Service
public class FileService {

    private final String FILE_NAME = "http://localhost:8002";

    @Autowired
    private FilesRepository filesRepository;

    public FileEntities uploadFile(MultipartFile file) throws IOException {
        FileEntities fileEntities = new FileEntities(file.getName(), file.getOriginalFilename(), file.getBytes(), file.getContentType());
        return filesRepository.save(fileEntities);
    }

    public FileEntities getFile(String id) {
        return filesRepository.findById(id).get();
    }

    public Stream<FileEntities> getAllFiles() {
        return filesRepository.findAll().stream();
    }

    public String deleteFile(String id) {
        filesRepository.deleteById(id);
        return "deleted";
    }



}
