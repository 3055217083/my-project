package com.song.springboot.constant;

public enum MyEnum {
    YES(1, "yes"),
    NO(1, "no");

    private int code;
    private String name;

    MyEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
