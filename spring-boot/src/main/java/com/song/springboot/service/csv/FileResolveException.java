package com.song.springboot.service.csv;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * @params :
 * @returns :
 */
public class FileResolveException extends RuntimeException {

    private List<String> errorInfos;

    public FileResolveException(List<String> errorInfos) {
        super();
        this.errorInfos = errorInfos;
    }

    public FileResolveException(String errorInfo) {
        super();
        this.errorInfos = new ArrayList<>(1);
        this.errorInfos.add(errorInfo);
    }

    public FileResolveException(List<String> errorInfos,Throwable cause) {
        super(cause);
        this.errorInfos = errorInfos;
    }

    public FileResolveException(String errorInfo,Throwable cause) {
        super(cause);
        this.errorInfos = new ArrayList<>(1);
        this.errorInfos.add(errorInfo);
    }

    public List<String> getErrorInfos() {
        return errorInfos;
    }

    public void setErrorInfos(List<String> errorInfos) {
        this.errorInfos = errorInfos;
    }

    @Override
    public String getMessage() {
        if (super.getMessage() != null) {
            return String.join("\t", errorInfos) + "\t" + super.getMessage();
        } else {
            return String.join("\t", errorInfos);
        }
    }
}
