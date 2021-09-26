package com.qf.data.view.facade.service.worker;

import com.alibaba.dubbo.config.annotation.Service;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.qf.data.core.dal.po.WorkerPO;
import com.qf.data.view.core.model.constant.RedisConstant;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.core.service.utils.RedisUtil;
import com.qf.data.view.core.service.worker.WorkerService;
import com.qf.data.view.facade.api.WorkerFacede;
import com.qf.data.view.facade.request.worker.WorkerModelAddRequest;
import com.qf.data.view.facade.request.worker.WorkerModelRequest;
import com.qf.data.view.facade.request.worker.WorkerModelSignRequest;
import com.qf.data.view.facade.request.worker.WorkerModelUpdateRequest;
import com.qf.data.view.facade.response.worker.WorkerModelResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Cjl
 * @date 2021/8/13 20:33
 */
@Service
public class WorkerFacadeImpl implements WorkerFacede {
    @Autowired
    private WorkerService workerService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public ResultModel<WorkerModelResponse> getWorkerById(WorkerModelRequest request) {

        WorkerPO workerPO = workerService.selectByPrimaryKey(request.getId());

        WorkerModelResponse workerModelResponse = new WorkerModelResponse();
        BeanUtils.copyProperties(workerPO,workerModelResponse);

        return ResultModel.success(workerModelResponse) ;
    }

    @Override
    public ResultModel addWorker(WorkerModelAddRequest request) {

        WorkerPO workerPO = new WorkerPO();
        BeanUtils.copyProperties(request,workerPO);
        int i = workerService.insertSelective(workerPO);
        if (i==1){
            return ResultModel.success();
        }
        return ResultModel.error("插入失败");
    }

    @Override
    public ResultModel deleteWorkerById(WorkerModelRequest request) {
        int i = workerService.deleteByPrimaryKey(request.getId());
        if (i==1){
            return ResultModel.success();
        }
        return ResultModel.error("删除失败");
    }

    @Override
    public ResultModel updateWorkerById(WorkerModelUpdateRequest request) {

        WorkerPO workerPO = new WorkerPO();
        BeanUtils.copyProperties(request,workerPO);
        int i = workerService.updateByPrimaryKeySelective(workerPO);
        if (i==1){
            return ResultModel.success();
        }
        return ResultModel.error("更新失败");
    }

    @Override
    public ResultModel<List> getAll() {
        List<WorkerPO> workerPOS = workerService.selectAll();
        List<WorkerModelResponse> list = new ArrayList<>();
        for (WorkerPO workerPO : workerPOS) {
            WorkerModelResponse workerModelResponse = new WorkerModelResponse();
            BeanUtils.copyProperties(workerPO,workerModelResponse);
            list.add(workerModelResponse);
        }

        ResultModel success = ResultModel.success(list);
        return success;
    }

    @Override
    public ResultModel signWorker(WorkerModelSignRequest request) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        String date = request.getDate();
        String signTime = date.substring(0, 10);
        String redisKey = RedisUtil.getRedisKey(RedisConstant.WORKER_SIGN_PRE, signTime);
        if (redisTemplate.opsForValue().increment(redisKey)==1){
            redisTemplate.expire(redisKey,3, TimeUnit.DAYS);
        }
        return ResultModel.success();
    }

    @Override
    public ResultModel getSignTotal() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd");
        String dateFormat = sf.format(date);
        String redisKey = RedisUtil.getRedisKey(RedisConstant.WORKER_SIGN_PRE, dateFormat);
        String total = (String) redisTemplate.opsForValue().get(redisKey);
        Integer intTotal = Integer.valueOf(total);
        return ResultModel.success(intTotal);
    }

}
