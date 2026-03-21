package com.arava.os.rest;

import com.arava.os.rest.exceptions.AravaSDKClientException;
import com.arava.os.rest.exceptions.AravaSDKServerException;
import com.arava.os.rest.models.CreateFileResponse;
import com.arava.os.rest.models.GetFileResponse;
import com.arava.os.rest.models.MultipartCompleteResponse;
import com.arava.os.rest.models.MultipartInitiateRequest;
import com.arava.os.rest.models.MutipartInitiateResponse;
import com.arava.os.rest.models.PaginatedListFileResponse;
import com.arava.os.rest.models.UploadPartResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping("/files/v1")
public class ObjectStorageResource {

    /**
     * Uploads the file to server and returns unique fileId
     *
     * @param file       - file to be uploaded
     * @param authHeader - auth header
     * @param region     - region where file to be stored
     * @return fileId and meta data of file
     * @throws AravaSDKClientException - In case of client side validation errors
     * @throws AravaSDKServerException - In case of server side retryable errors
     */
    @PutMapping(consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CreateFileResponse> createFile(
            @RequestPart("file") MultipartFile file,
            @RequestHeader("Authorization") String authHeader,
            @RequestHeader("X-Region") String region
    ) {
        return ResponseEntity.ok(null);
    }

    /**
     * Download file with fileId from the server
     *
     * @param fileId     - file to be downloaded
     * @param authHeader - auth header
     * @param region     - region where file to be stored
     * @return fileId and meta data of file
     * @throws AravaSDKClientException - In case of client side validation errors
     * @throws AravaSDKServerException - In case of server side retryable errors
     */
    @GetMapping("/{fileId}")
    public ResponseEntity<GetFileResponse> getFileById(
            @PathVariable("fileId") String fileId,
            @RequestHeader("Authorization") String authHeader,
            @RequestHeader("X-Region") String region
    ) {
        return ResponseEntity.ok(null);
    }

    /**
     * Deletes a file from the server
     *
     * @param fileId     - ID of the file to be deleted
     * @param authHeader - JWT auth header
     * @param region     - region where file is stored
     * @return No Content on success
     * @throws AravaSDKClientException - In case of client side validation errors
     * @throws AravaSDKServerException - In case of server side retryable errors
     */
    @DeleteMapping("/{fileId}")
    public ResponseEntity<Void> deleteFile(
            @PathVariable("fileId") String fileId,
            @RequestHeader("Authorization") String authHeader,
            @RequestHeader("X-Region") String region
    ) {
        return ResponseEntity.noContent().build();
    }

    /**
     * Initiates a multipart upload session using a request body.
     *
     * @param authHeader - JWT auth header
     * @param region     - region where file will be stored
     * @param request    - Object containing filePath and fileName
     * @return Response containing the unique uploadId
     * @throws AravaSDKClientException - In case of client side validation errors
     * @throws AravaSDKServerException - In case of server side retryable errors
     */
    @PostMapping("/initiate")
    public ResponseEntity<MutipartInitiateResponse> initiateUpload(
            @RequestHeader("Authorization") String authHeader,
            @RequestHeader("X-Region") String region,
            @RequestBody MultipartInitiateRequest request
    ) throws AravaSDKClientException, AravaSDKServerException {
        return null;
    }

    /**
     * Uploads a specific part/chunk of a file for a multipart upload session.
     *
     * @param uploadId   - The unique ID returned from the initiate API
     * @param partNumber - The sequence number of the chunk (e.g., 1, 2, 3...)
     * @param file       - The actual binary chunk/part of the file
     * @param authHeader - JWT auth header
     * @param region     - region where file is stored
     * @return Success status for the specific part
     * @throws AravaSDKClientException - In case of non retryable client errors
     * @throws AravaSDKServerException - In case of server side errors
     */
    @PutMapping(value = "/{uploadId}/part/{partNumber}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<UploadPartResponse> uploadPart(
            @PathVariable("uploadId") String uploadId,
            @PathVariable("partNumber") int partNumber,
            @RequestPart("file") MultipartFile file,
            @RequestHeader("Authorization") String authHeader,
            @RequestHeader("X-Region") String region
    ) {
        return null;
    }

    /**
     * Completes a multipart upload session.
     *
     * @param uploadId   - The unique ID returned from the initiate API
     * @param authHeader - JWT auth header
     * @param region     - region where file is stored
     * @return Final metadata and status of the assembled file
     * @throws AravaSDKClientException - In case of non retryable client errors
     * @throws AravaSDKServerException - In case of server side errors
     */
    @PostMapping("/{uploadId}/complete")
    public ResponseEntity<MultipartCompleteResponse> completeUpload(
            @PathVariable("uploadId") String uploadId,
            @RequestHeader("Authorization") String authHeader,
            @RequestHeader("X-Region") String region
    ) {
        return null;
    }

    /**
     * Lists all files within a specific directory path with pagination support.
     *
     * @param path       - The directory path to scan
     * @param page       - The page number (default: 0)
     * @param size       - Number of items per page (default: 50)
     * @param authHeader - JWT auth header
     * @param region     - region where files are stored
     * @return Paginated list of files at path directory
     * @throws AravaSDKClientException - In case of non retryable client errors
     * @throws AravaSDKServerException - In case of server side errors
     */
    @GetMapping
    public ResponseEntity<PaginatedListFileResponse> listFiles(
            @RequestParam("path") String path,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "50") int size,
            @RequestHeader("Authorization") String authHeader,
            @RequestHeader("X-Region") String region
    ) {
        return null;
    }
}
