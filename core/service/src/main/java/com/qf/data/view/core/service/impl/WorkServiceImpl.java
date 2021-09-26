package com.qf.data.view.core.service.impl;

import com.qf.data.core.dal.dao.worker.TbWorkerMapper;
import com.qf.data.core.dal.po.WorkerPO;
import com.qf.data.view.core.service.worker.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Cjl
 * @date 2021/8/13 20:00
 */

@Service
public class WorkServiceImpl implements WorkerService {
    @Autowired
    TbWorkerMapper mapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return  mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WorkerPO record) {
        return 0;
    }

    @Override
    public int insertSelective(WorkerPO record) {
        return  mapper.insertSelective(record);
    }

    @Override
    public WorkerPO selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WorkerPO record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WorkerPO record) {
        return 0;
    }

    @Override
    public List<WorkerPO> selectAll() {
        return mapper.selectAll();
    }
}
