package cn.most.esp.common;

public class ResultVO {

	/**
	 * 1:成功  0失败
	 */
	private Integer code;

	private String msg;

	private Object data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ResultVO(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public ResultVO(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public ResultVO(Object data) {
		super();
		this.data = data;
	}
	
	public ResultVO() {
		
	}
	
}
