package ru.tbank.edu.passkeeper.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ru.tbank.edu.passkeeper.model.Secret;

public class LocalSecretRepository implements SecretRepository {

    private final Map<String, Secret> secrets = new HashMap<>();

    @Override
    public List<Secret> findAll() {
        return secrets.values().stream().toList();
    }

    @Override
    public Secret findByName(String name) {
        return secrets.get(name);
    }

    @Override
    public void save(Secret secret) {
        secrets.put(secret.name(), secret);
    }

    @Override
    public void saveAll(List<Secret> secrets) {
        secrets.forEach(secret -> {
            this.secrets.put(secret.name(), secret);
        });
    }

    @Override
    public void deleteByName(String name) {
        secrets.remove(name);
    }

    @Override
    public void deleteAll(List<String> names) {
        names.forEach(secrets::remove);
    }

    @Override
    public void deleteAll() {
        secrets.clear();
    }
}
