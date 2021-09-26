package com.qf.data.view.core.model.request;

import lombok.Data;

import java.util.Date;

/**
 * @author Cjl
 * @date 2021/8/14 9:25
 */
@Data
public class WorkerUpdateRequest {
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
