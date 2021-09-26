package com.qf.data.view.facade.response.worker;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Cjl
 * @date 2021/8/13 20:27
 */
@Data
public class WorkerModelResponse implements Serializable {
    private Long id;

    private String name;

    private Boolean gender;

    private Integer age;

    private Boolean workType;

    private Boolean status;

    private Boolean flag;

    private Date gmtCreated;

    private Date gmtModified;

    private Boolean isDeleted;

    private Long depId;
}
