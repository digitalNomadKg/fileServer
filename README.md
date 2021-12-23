**FileServer spring boot application**

Hello team!

FileServer, a file storage service, similar to Dropbox or Google Drive. 
Basic functionality of FileServer includes uploading a file, navigating the file tree and downloading a file. 
There are no user accounts or authentication the files are accessible to everyone.

Tech used:
* Spring Boot
* Spring Data JPA
* Gradle
* Swagger
* H2
* PostGreSql (tested locally)

Swagger API documentation link:
* localhost:8002/swagger-ui.html

Currently, only upload/download, getFiles, getFIleById, deleteFileById
are available for Rest API requests.
* http://localhost:8002/directory/uploadFile/
* http://localhost:8002/directory/getFiles
* http://localhost:8002/directory/getFile/{id}
* http://localhost:8002/directory/deleteFile/{id}

Create/delete/getDirectory content is running using Local Directory only.
* http://localhost:8002/directory/createDirectory
* http://localhost:8002/directory/getDirectoryList
* http://localhost:8002/directory/deleteDirectory

Application is runnable on port: 8002

The application firstly was written for Local Directory and then code was refactoring according to Rest API,
it took a bit time to read lot of documentation and update accordingly.

To be done:
1) Directory- calling via rest api requests
2) Tests - fulfill/ check code using tests
3) Simple front end
