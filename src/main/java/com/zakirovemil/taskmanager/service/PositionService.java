package com.zakirovemil.taskmanager.service;

import com.zakirovemil.taskmanager.entity.PositionEntity;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchPositionException;
import com.zakirovemil.taskmanager.exception_handling.exception.PositionAlreadyExistException;

import java.util.List;

public interface PositionService {
    PositionEntity getPositionByName(String name) throws NoSuchPositionException;

    List<PositionEntity> getAllPositions();

    void deletePosition(String name) throws NoSuchPositionException;

    void createPosition(PositionEntity positionEntity) throws PositionAlreadyExistException;
}
