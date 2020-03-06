package cn.hhj.course;

public class ResponsResult<E> {
    private String flag;
    private Integer code;
    private E data;
    private String msg;

    public ResponsResult() {
    }

    public ResponsResult(String flag, Integer code, E data, String msg) {
        this.flag = flag;
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
