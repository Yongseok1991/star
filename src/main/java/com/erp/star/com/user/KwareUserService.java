package com.erp.star.com.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KwareUserService {
    private final KwareUserRepository repository;

    public List<KwareUser> findAll() {
        return repository.findAll();
    }
    @Transactional
    public Optional<KwareUser> findById(Long id) {
        return repository.findById(id);
    }

}
