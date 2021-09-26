package com.qf.data.view.core.service.worker;

import com.qf.data.core.dal.po.WorkerPO;

import java.util.List;

/**
 * @author Cjl
 * @date 2021/8/13 19:58
 */
public interface WorkerService {

    int deleteByPrimaryKey(Long id);

    int insert(WorkerPO record);

    int insertSelective(WorkerPO record);

    WorkerPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WorkerPO record);

    int updateByPrimaryKey(WorkerPO record);

    List<WorkerPO> selectAll();
}
