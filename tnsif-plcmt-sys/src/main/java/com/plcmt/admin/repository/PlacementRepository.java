package com.plcmt.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.plcmt.admin.entity.Placement;

public interface PlacementRepository extends JpaRepository<Placement, Long> {
}