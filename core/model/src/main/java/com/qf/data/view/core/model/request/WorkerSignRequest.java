package com.qf.data.view.core.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Cjl
 * @date 2021/8/16 15:16
 */
@Data
public class WorkerSignRequest implements Serializable {
    private Integer id;
    private Integer deviceId;
    private String date;
}
