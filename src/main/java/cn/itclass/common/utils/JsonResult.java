package cn.itclass.common.utils;

import cn.itclass.common.entity.SystemResponseEnum;

/**  
 * @ClassName: AjaxResult   
 * @Description: 封装返回数据  
 */  
public class JsonResult {  
  
    private String resultCode;
    private String resultMsg;
    private Object resultData;  
      
    public JsonResult(String retcode, String retmsg, Object data){  
        this.resultCode = retcode;  
        this.resultMsg = retmsg;  
        this.resultData = data;  
    }  
      
    public JsonResult(Object data){  
        this.resultMsg = SystemResponseEnum.SUCCESS.getResultMsg(); 
        this.resultCode = SystemResponseEnum.SUCCESS.name();
        this.resultData = data;  
    }  
      
//    public JsonResult(){
//    	this.resultMsg = SystemResponseEnum.SUCCESS.getResultMsg();
//    	this.resultCode = SystemResponseEnum.SUCCESS.name();
//    	this.resultData = (Object)null;
//    }
      
    public static JsonResult success(Object resultData){  
          return new JsonResult(resultData);
    }  
    
    public static JsonResult success(){  
        return new JsonResult((Object)null);
    }  
    
    public static JsonResult fail(SystemResponseEnum response,Object resultData){
    	return new JsonResult(response.name(),response.getResultMsg(),resultData);
    }
    
    public static JsonResult fail(SystemResponseEnum response){
    	return new JsonResult(response.name(),response.getResultMsg(),null);
    }
    
    public static JsonResult fail(String retcode,String retMsg,Object resultData){
    	return new JsonResult(retcode,retMsg,resultData);
    }
    
    public static JsonResult fail(String retcode,String retMsg){
    	return new JsonResult(retcode,retMsg,null);
    }
  
    public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}

	@Override  
    public String toString() {  
        return "JsonResult [retcode=" + resultCode + ", retmsg=" + resultMsg + ", data=" + resultData + "]";  
    }  
      
}
