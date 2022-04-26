package prova.uploadfile.uploadpdfcv.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import prova.uploadfile.uploadpdfcv.models.File;
import prova.uploadfile.uploadpdfcv.repo.FileRepo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepo fileRepository;

    public void save(MultipartFile file) throws IOException {
        File fileEntity = File.builder().name(StringUtils.cleanPath(file.getOriginalFilename()))
                .contentType(file.getContentType())
                        .data(file.getBytes())
                .size(file.getSize()).build();
        fileRepository.save(fileEntity);
    }

    public Optional<File> getFile(Long id) {
        return fileRepository.findById(id);
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }
}
