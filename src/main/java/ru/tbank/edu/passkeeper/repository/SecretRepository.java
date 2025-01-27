package ru.tbank.edu.passkeeper.repository;

import java.util.List;
import ru.tbank.edu.passkeeper.model.Secret;

public interface SecretRepository {

    List<Secret> findAll();

    Secret findByName(String name);

    void save(Secret secret);

    void saveAll(List<Secret> secrets);

    void deleteByName(String name);

    void deleteAll(List<String> names);

    void deleteAll();
}
