package cn.most.esp.common;

public class ResultUtil {
	
	public static ResultVO getSuccess(String msg) {
		return  new ResultVO(1,msg);
	}
	
	public static ResultVO getSuccess(String msg,Object data) {
		return  new ResultVO(1,msg,data);
	}
	
	public static  ResultVO getFail(String msg) {
		return  new ResultVO(0,msg);
	}
	
	public static  ResultVO getFail(String msg,Object data) {
		return  new ResultVO(0,msg,data);
	}
	
	public static ResultVO getData(Object data) {
		return  new ResultVO(data);
	}
}
