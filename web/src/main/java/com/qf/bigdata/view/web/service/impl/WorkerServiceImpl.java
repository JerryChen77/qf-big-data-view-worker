package com.qf.bigdata.view.web.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.bigdata.view.web.service.WorkerService;
import com.qf.data.view.core.model.request.WorkerAddRequest;
import com.qf.data.view.core.model.request.WorkerSignRequest;
import com.qf.data.view.core.model.request.WorkerUpdateRequest;
import com.qf.data.view.core.model.response.WorkerResponse;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.facade.api.WorkerFacede;
import com.qf.data.view.facade.request.worker.WorkerModelAddRequest;
import com.qf.data.view.facade.request.worker.WorkerModelRequest;
import com.qf.data.view.facade.request.worker.WorkerModelSignRequest;
import com.qf.data.view.facade.request.worker.WorkerModelUpdateRequest;
import com.qf.data.view.facade.response.worker.WorkerModelResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Cjl
 * @date 2021/8/13 20:16
 */
@Service
public class WorkerServiceImpl implements WorkerService {
    @Reference
    private WorkerFacede workerFacede;

    @Override
    public ResultModel<WorkerResponse> getWorkerById(long id) {
        WorkerModelRequest request = new WorkerModelRequest();
        request.setId(id);
        ResultModel<WorkerModelResponse> response = workerFacede.getWorkerById(request);

        if (Objects.nonNull(response.getData())){
            WorkerResponse workerResponse = new WorkerResponse();
            BeanUtils.copyProperties(response.getData(),workerResponse);
            return ResultModel.success(workerResponse);
        }
        return ResultModel.error();
    }

    @Override
    public ResultModel addWorker(WorkerAddRequest request) {
            WorkerModelAddRequest workerModelAddRequest = new WorkerModelAddRequest();
            BeanUtils.copyProperties(request,workerModelAddRequest);
            ResultModel resultModel = workerFacede.addWorker(workerModelAddRequest);
            return resultModel;
    }

    @Override
    public ResultModel deleteWorkerById(long id) {
        WorkerModelRequest request = new WorkerModelRequest();
        request.setId(id);
        ResultModel resultModel = workerFacede.deleteWorkerById(request);
        return resultModel;
    }

    @Override
    public ResultModel updateWorkerById(WorkerUpdateRequest request) {
        WorkerModelUpdateRequest workerModelUpdateRequest = new WorkerModelUpdateRequest();
        BeanUtils.copyProperties(request,workerModelUpdateRequest);
        ResultModel resultModel = workerFacede.updateWorkerById(workerModelUpdateRequest);
        return resultModel;
    }

    @Override
    public ResultModel<List> getAll() {
        ResultModel<List> resultModel = workerFacede.getAll();
        List<WorkerModelResponse> workerModelResponses = resultModel.getData();
        List<WorkerResponse> workerResponses = new ArrayList<>();
        for (WorkerModelResponse workerModelResponse : workerModelResponses) {
            WorkerResponse workerResponse = new WorkerResponse();
            BeanUtils.copyProperties(workerModelResponse,workerResponse);
            workerResponses.add(workerResponse);
        }
        resultModel.setData(workerResponses);
        return resultModel;
    }

    @Override
    public ResultModel signWorker(WorkerSignRequest request) {

        WorkerModelSignRequest request1 = new WorkerModelSignRequest();
        BeanUtils.copyProperties(request,request1);
        ResultModel resultModel = workerFacede.signWorker(request1);

        return resultModel;
    }

    @Override
    public ResultModel getSignTotal() {
        return  workerFacede.getSignTotal();

    }


}
