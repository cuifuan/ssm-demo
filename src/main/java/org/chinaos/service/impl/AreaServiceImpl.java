package org.chinaos.service.impl;

import org.chinaos.dao.AreaMapper;
import org.chinaos.model.Area;
import org.chinaos.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    private final AreaMapper areaMapper;

    @Autowired
    public AreaServiceImpl(AreaMapper areaMapper) {
        this.areaMapper = areaMapper;
    }

    @Override
    public List<Area> getAreaAll() {
        return areaMapper.getAreaAll();
    }
}
