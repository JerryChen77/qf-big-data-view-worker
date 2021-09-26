package com.qf.data.view.core.model.response;

import lombok.Data;

import java.util.Date;

/**
 * @author Cjl
 * @date 2021/8/13 20:09
 */
@Data
public class WorkerResponse {
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
