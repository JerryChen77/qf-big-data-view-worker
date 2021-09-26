package com.qf.bigdata.view.web.service;

import com.qf.data.view.core.model.request.WorkerAddRequest;
import com.qf.data.view.core.model.request.WorkerSignRequest;
import com.qf.data.view.core.model.request.WorkerUpdateRequest;
import com.qf.data.view.core.model.response.WorkerResponse;
import com.qf.data.view.core.model.result.ResultModel;

import java.util.List;

/**
 * @author Cjl
 * @date 2021/8/13 20:14
 */
public interface WorkerService {

   ResultModel<WorkerResponse> getWorkerById(long id);

   ResultModel addWorker(WorkerAddRequest request);

   ResultModel deleteWorkerById(long id);

   ResultModel updateWorkerById(WorkerUpdateRequest request);

   ResultModel<List> getAll();

   ResultModel signWorker(WorkerSignRequest request);

   ResultModel getSignTotal();
}
