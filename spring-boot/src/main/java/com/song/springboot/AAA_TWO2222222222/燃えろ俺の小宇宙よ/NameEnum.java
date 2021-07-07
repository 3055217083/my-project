package com.song.springboot.AAA_TWO2222222222.燃えろ俺の小宇宙よ;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/6/24 10:49
 */
public enum NameEnum {

    SONG_ZHI_XIAN("szx","1561");

    private final String name;
    private final String code;

    NameEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
