package com.qf.data.view.facade.request.worker;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Cjl
 * @date 2021/8/16 12:45
 */
@Data
public class WorkerModelAddRequest implements Serializable {
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
