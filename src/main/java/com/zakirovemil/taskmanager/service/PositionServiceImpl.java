package com.zakirovemil.taskmanager.service;

import com.zakirovemil.taskmanager.entity.PositionEntity;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchPositionException;
import com.zakirovemil.taskmanager.exception_handling.exception.PositionAlreadyExistException;
import com.zakirovemil.taskmanager.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public PositionEntity getPositionByName(String name) throws NoSuchPositionException {
        PositionEntity positionEntity = positionRepository.findByPositionName(name);
        if (positionEntity == null) {
            throw new NoSuchPositionException("No such position with name" + name);
        }
        return positionEntity;
    }

    @Override
    public List<PositionEntity> getAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    public void deletePosition(String name) throws NoSuchPositionException {
        PositionEntity positionEntity = getPositionByName(name);
        positionRepository.delete(positionEntity);
    }

    @Override
    public void createPosition(PositionEntity positionEntity) throws PositionAlreadyExistException {
        PositionEntity entity = positionRepository.findByPositionName(positionEntity.getPositionName());
        if (entity != null) {
            positionRepository.save(entity);
        } else {
            throw new PositionAlreadyExistException
                    ("Position with name " + positionEntity.getPositionName() + " already exist");
        }
    }
}
