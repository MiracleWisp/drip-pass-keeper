package ru.tbank.edu.passkeeper.service;

import java.util.List;
import java.util.Objects;
import ru.tbank.edu.passkeeper.model.Secret;
import ru.tbank.edu.passkeeper.repository.SecretRepository;
import ru.tbank.edu.passkeeper.service.validation.PasswordValidator;

public class SecretService {

    private final SecretRepository secretRepository;
    private final List<PasswordValidator> validators;

    public SecretService(SecretRepository secretRepository, List<PasswordValidator> validators) {
        this.secretRepository = secretRepository;
        this.validators = validators;
    }

    public Secret find(String name) {
        return secretRepository.findByName(name);
    }

    public void save(Secret secret) {
        var errors = validators.stream().map(validator -> validator.validate(secret.password()))
            .filter(Objects::nonNull).toList();
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join(" ", errors));
        }
        secretRepository.save(secret);
    }


    public void delete(String name) {
        secretRepository.deleteByName(name);
    }
}
