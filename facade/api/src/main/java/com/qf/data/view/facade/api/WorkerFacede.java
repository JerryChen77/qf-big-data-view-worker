package com.qf.data.view.facade.api;

import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.facade.request.worker.WorkerModelAddRequest;
import com.qf.data.view.facade.request.worker.WorkerModelSignRequest;
import com.qf.data.view.facade.request.worker.WorkerModelUpdateRequest;
import com.qf.data.view.facade.response.worker.WorkerModelResponse;
import com.qf.data.view.facade.request.worker.WorkerModelRequest;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author Cjl
 * @date 2021/8/13 20:25
 */
public interface WorkerFacede {

    ResultModel<WorkerModelResponse> getWorkerById(WorkerModelRequest request);

    ResultModel addWorker(WorkerModelAddRequest request);

    ResultModel deleteWorkerById(WorkerModelRequest request);

    ResultModel updateWorkerById(WorkerModelUpdateRequest request);

    ResultModel<List> getAll();

    ResultModel signWorker(WorkerModelSignRequest request);

    ResultModel getSignTotal();
}
