package com.zakirovemil.taskmanager.controller;

import com.zakirovemil.taskmanager.entity.PositionEntity;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchPositionException;
import com.zakirovemil.taskmanager.exception_handling.exception.PositionAlreadyExistException;
import com.zakirovemil.taskmanager.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public List<PositionEntity> getAllPositions() {
        return positionService.getAllPositions();
    }

    @PostMapping
    public PositionEntity createPosition(@RequestBody PositionEntity positionEntity) throws PositionAlreadyExistException {
        positionService.createPosition(positionEntity);
        return positionEntity;
    }

    @DeleteMapping("/{name}")
    public String deletePosition(@PathVariable String name) throws NoSuchPositionException {
        positionService.deletePosition(name);
        return name;
    }

}
