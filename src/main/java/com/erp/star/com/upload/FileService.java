package com.erp.star.com.upload;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileService {

    private final KwareFileRepository kwareFileRepository;

    @Transactional
    public Long saveFile(KwareFile file) {
        return kwareFileRepository.save(file.toEntity()).getId();
    }

    @Transactional
    public KwareFile getFile(Long id) {
        KwareFile file = kwareFileRepository.findById(id).orElseGet(KwareFile::new);

        KwareFile fileDto = KwareFile.builder()
                .id(id)
                .origFilename(file.getOrigFilename())
                .filename(file.getFilename())
                .filePath(file.getFilePath())
                .build();
        return fileDto;
    }
}
