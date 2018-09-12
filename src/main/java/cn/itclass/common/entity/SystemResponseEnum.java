package cn.itclass.common.entity;

/**
 *  系统响应信息
 * @author Yi Chen
 *
 */

public enum SystemResponseEnum {
	SUCCESS("成功"),
	PARAM_EMPTY_FAIL("请求参数为空"),
	PARAM_ERROR("参数异常"),
	SELECT_EXCEPTION("查询异常"),
	SERVER_ERROR("服务器异常");
	
	private String resultMsg;
	
	SystemResponseEnum(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getResultMsg() {
		return resultMsg;
	}
}
