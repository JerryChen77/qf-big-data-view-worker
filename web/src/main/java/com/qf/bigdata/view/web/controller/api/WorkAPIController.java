package com.qf.bigdata.view.web.controller.api;

import com.qf.bigdata.view.web.service.WorkerService;
import com.qf.data.view.core.model.exception.ViewException;
import com.qf.data.view.core.model.request.WorkerAddRequest;
import com.qf.data.view.core.model.request.WorkerSelectRequest;
import com.qf.data.view.core.model.request.WorkerSignRequest;
import com.qf.data.view.core.model.request.WorkerUpdateRequest;
import com.qf.data.view.core.model.response.WorkerResponse;
import com.qf.data.view.core.model.result.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;

/**
 * @author Cjl
 * @date 2021/8/13 20:04
 */

@RestController
@RequestMapping("/worker")
@CrossOrigin
public class WorkAPIController {
    @Autowired
    private WorkerService workerService;

    @PostMapping("/sign")
    public ResultModel signWorker(@RequestBody WorkerSignRequest request){
        try {
            if (Objects.isNull(request)||Objects.isNull(request.getId())){
                throw new ViewException("参数错误");
            }
        } catch (ViewException e) {
            return ResultModel.error(e.getMessage());
        }
        return workerService.signWorker(request);
    }

    @GetMapping("/sign/total")
    public ResultModel getSignTotal(){
        return  workerService.getSignTotal();
    }

    @GetMapping("/getall")
    public ResultModel<List> getAll(){
        ResultModel<List> all = workerService.getAll();
                List data = all.getData();
                for (Object datum : data) {
                    System.out.println(datum);
                }
        return all;
    }

    @PostMapping("/get")
    public ResultModel<WorkerResponse> getWorkerById(@RequestBody WorkerSelectRequest request){

        try {
            if (Objects.isNull(request)||Objects.isNull(request.getId())){
                throw new ViewException("参数有误");
            }
        } catch (ViewException e) {
            return ResultModel.error(e.getMessage());
        }
        return workerService.getWorkerById(request.getId());
    }

    @PostMapping("/add")
    public ResultModel addWorker(@RequestBody WorkerAddRequest request){
        try {
            if (Objects.isNull(request)||Objects.isNull(request.getName())){
                throw new ViewException("参数有误");
            }
        } catch (ViewException e) {
            return ResultModel.error(e.getMessage());
        }
        return workerService.addWorker(request);
    }

    @DeleteMapping("/delete")
    public ResultModel deleteWorkerById(@RequestBody WorkerSelectRequest request){
        try {
            if (Objects.isNull(request)){
                throw new ViewException("参数有误");
            }
        } catch (ViewException e) {
            return ResultModel.error(e.getMessage());
        }
        return workerService.deleteWorkerById(request.getId());
    }

    @PostMapping("/update")
    public ResultModel updateWorkerById(@RequestBody WorkerUpdateRequest request){
        try {
            if (Objects.isNull(request)||Objects.isNull(request.getId())){
                throw new ViewException("参数有误");
            }
        } catch (ViewException e) {
            return ResultModel.error(e.getMessage());
        }
        return workerService.updateWorkerById(request);
    }

}
