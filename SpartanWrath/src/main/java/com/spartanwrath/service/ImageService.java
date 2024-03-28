package com.spartanwrath.service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class ImageService {


    private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/images");

   /* public String createImage(MultipartFile multiPartFile) {

        String originalName = multiPartFile.getOriginalFilename();

        if (!originalName.matches(".*\\.(jpg|jpeg|gif|png)")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The url is not an image resource");
        }

        String fileName = "image_" + UUID.randomUUID() + "_" + originalName;

        Path imagePath = FILES_FOLDER.resolve(fileName);
        try {
            multiPartFile.transferTo(imagePath);
        } catch (Exception ex) {
            System.err.println(ex);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't save image locally", ex);
        }

        return fileName;
    }
*/

    private Path createFilePath(long imageId, Path folder) {
        return folder.resolve("productimage-" + imageId + ".jpg");

    }

    public void saveImage (String folderName, long imageId, MultipartFile image) throws IOException {
        Path folder = FILES_FOLDER.resolve(folderName);
        Files.createDirectories(folder);
        Path newFile = createFilePath(imageId, folder);
        image.transferTo(newFile);
    }

    public ResponseEntity<Object> createResponseFromImage(String folderName, long imageId) throws MalformedURLException{
        Path folder = FILES_FOLDER.resolve(folderName);
        Path imagePath = createFilePath(imageId, folder);
        Resource file = new UrlResource(imagePath.toUri());

        if (!Files.exists(imagePath)) {
            return ResponseEntity.notFound().build();
        }else {
            return  ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg").body(file);
        }
    }

    public void deleteImage(String folderName, long imageId) throws IOException {
        Path folder = FILES_FOLDER.resolve(folderName);
        Path imageFile = createFilePath(imageId, folder);
        Files.deleteIfExists(imageFile);
    }
}