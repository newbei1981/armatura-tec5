package com.armatura.repository;

import com.armatura.model.Valve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValvesRepository extends JpaRepository<Valve,Long> {
    List<Valve> findAllByBiuIsContainingIgnoreCase(String biu);
    List<Valve> findAllByNameIsContainingIgnoreCase(String name);
    List<Valve> findAllByAssemblyIsContainingIgnoreCase(String assembly);

    void deleteAll();

    Valve save(Valve valve);
}
