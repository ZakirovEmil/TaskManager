package com.zakirovemil.taskmanager.repository;

import com.zakirovemil.taskmanager.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<PositionEntity, Long> {
    PositionEntity findByPositionName(String positionName);
}
