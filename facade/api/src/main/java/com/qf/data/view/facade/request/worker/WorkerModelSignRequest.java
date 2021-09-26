package com.qf.data.view.facade.request.worker;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Cjl
 * @date 2021/8/16 18:42
 */
@Data
public class WorkerModelSignRequest implements Serializable {
    private Integer id;
    private Integer deviceId;
    private String date;

}
