package com.coo.ms.cloud.baidu;

import java.util.List;

import com.baidu.frontia.FrontiaData;
import com.baidu.frontia.api.FrontiaPushListener.PushMessageListener;
import com.baidu.frontia.api.FrontiaStorageListener;
import com.baidu.frontia.api.FrontiaStorageListener.DataInfoListener;
import com.baidu.frontia.api.FrontiaStorageListener.DataOperationListener;
import com.kingstar.ngbf.ms.util.Reference;


/**
 * 监听器适配器...
 * 
 * @author boqing.shen
 * 
 */
public class BaiduListenerAdapter implements
		FrontiaStorageListener.DataInsertListener,
		DataOperationListener, DataInfoListener, PushMessageListener {

	public BaiduListenerAdapter() {
		// TODO Auto-generated constructor stub
	}

	// 更新、保存
	@Reference(note="ALL Listener")
	@Override
	public void onFailure(int errCode, String errMsg) {
		// TODO Auto-generated method stub
	}

	// 保存
	@Reference(override=FrontiaStorageListener.DataInsertListener.class)
	@Override
	public void onSuccess() {
		// TODO Auto-generated method stub
	}

	// 更新、删除
	@Reference(override=DataOperationListener.class)
	@Override
	public void onSuccess(long count) {
		// TODO Auto-generated method stub
	}

	// 查询
	@Reference(override=DataInfoListener.class)
	@Override
	public void onSuccess(List<FrontiaData> list) {
		// TODO Auto-generated method stub
		// StringBuilder sb = new StringBuilder();
		// int i = 0;
		// for(FrontiaData d : list){
		// sb.append(i).append(":").append(d.toJSON().toString()).append("\n");
		// }
	}
	
	@Reference(override=PushMessageListener.class)
	@Override
	public void onSuccess(String msgId) {
		// TODO Auto-generated method stub
		
	}

}
