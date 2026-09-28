package com.mvp.surf_api.repository;

import com.mvp.surf_api.model.SessaoSurf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoSurfRepository extends JpaRepository<SessaoSurf, Long> {
}