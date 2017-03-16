package cn.tiandechain.jbccguide.app;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.tiandechain.common.bean.ActionType;
import cn.tiandechain.common.bean.DataBuilder;
import cn.tiandechain.common.bean.QueryBuilder;
import cn.tiandechain.common.exception.JBCCResult;
import cn.tiandechain.common.util.Base64Utils;
import cn.tiandechain.common.util.GsonUtil;
import cn.tiandechain.common.util.RSAUtils;
import cn.tiandechain.jbccclient.client.JBCCConnection;

public class JBCCCopyrightTest {
	public static void main(String[] args) throws Exception {
		//用户签名私钥
		String userPrivate = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM7ju8WyI1L8yJtQC3N870XgmnnNphC6IISeynN5qCarf2gb9ChUrFcNiY4TKwinuDdBdhX0ZvFhb30NtRP8jibs5gspMxtV68uKl9+F5pXlRw4qyzS4JsmFhdNkWrxcxv4sOpgyJ6oT2qO9SDIvOqLPlkZkBG43sbByRMtqoigFAgMBAAECgYAs7Mi+ciM3hwqspyIFbvCqNM52epB/+1rKUYzWrGk2FHFzEvbetxxBPwBKqKDknT7kSMOymsKr0aOa/RoAAAyBxUsj1TwnLB8zpI2SN0hDVmGWrcC36t4OJJ0jsOhSTPvAAzczkfo2xG9ofLjikiVaj7iTKQ8YGu3WzqJqkucZYQJBAPEP+3ISDGesuzhN/pO/jJ54lvOpD2/FAuXFcSMzbJkeu+Y9zFP1u6sQJyjfOyZBB9fql4XSNykwFbuokbhd7S0CQQDbtak+bIOxDzMUlTPOLx6+ZeUoSQ/B6ljvBgNqi7jLxPOEw8+24AzoJjIICTRuPGKpLsCX9oHIOYJ0rUsIK105AkB1yvF7VAZrwqPZZ4M2fysfZJ2egsXgP8yiqlAWe1Jdn/8BCsGFZVZGyKXZ+vrUPoKupxtTcN0zayOzhzNte7ghAkBdBhlWWNOZT/osqM96aPD3ZGUWHXkSfYqSCVXA8s+XVxhUCiQUJeDRGfrs9BjC48ZSI31f2fsxL0hQ5l5yYwnhAkEAmej9siflw1lO1LNXitVcvvTk+uuHzO7Q51cwingffa5XtbgrjTyOKWS5w11xgZBHoOsAzqjX79zYJXo8AvJKNQ==";
		//天德公钥
		String tiandePublic = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCICwf6uM5n+UkCjvXmC3tBP5AA/RO/HffYa+FolZXdCOIZJmrReafqwhR24ntJ6xSeXLgiIKT/VYhyh+HEtzyF52XHc4X/fu/v7SL6QdkyveNcKBp5lkEu9zZZUCYFohnn98Csi0QEAaM9zShunjuWoYeK2/izSW1mI2tZex5J+wIDAQAB";
		
		//jbcc初始化
		String userName = "test01";
		String password = "password01";
		JBCCConnection conn = JBCCConnection.getInstance();
		conn.init(userName, password, tiandePublic);
//		conn.openConnection();
		
		
		/** ***********************************************************创建TBC 开始*******************************************************/
		/**------------------------------------------------创建works表--start------------------------------------------------------------*/
//		UUID uuid = UUID.randomUUID();
//		DataBuilder paramBuilder = new DataBuilder("copyright_home","works","y", uuid.toString(), new Date(), ActionType.CREATE_TBC,null);
//		paramBuilder.addParam("copyright_id", "String");
//		paramBuilder.addParam("banquanjia_evidence_code", "String");
//		paramBuilder.addParam("evidence_code", "String");
//		paramBuilder.addParam("register_id", "String");
//		paramBuilder.addParam("work_id", "String");
//		paramBuilder.addParam("work_name", "String");
//		paramBuilder.addParam("upload_username","String");
//		paramBuilder.addParam("upload_date", "String");
//		
//		
		//交易签名
//		String plainTxt = GsonUtil.getGson().toJson(paramBuilder);
//		//System.out.println("---------plainTxt:" +plainTxt +"-----------");
//		String signature = RSAUtils.sign(plainTxt.getBytes(), userPrivate);
//		//System.out.println("---------signature:" +signature +"-----------");
//		//将交易签名及对应的原文添加进map中去
//		paramBuilder.addParam("signature", Base64Utils.encode(signature.getBytes()));
//		List<JBCCResult> result = conn.createTBC(paramBuilder,tiandePublic);
//		for(int i =0;i<result.size();i++){
//			JBCCResult r = result.get(i);
//			if(r.getStatus() == 0){//0成功，1失败
//				System.out.println("-----success------");
//			}else if(r.getStatus() == 1){
//				System.out.println("-------fail-------");
//			}
//		}
		
		/**------------------------------------------------创建works表--end------------------------------------------------------------*/
		
		/**------------------------------------------------创建operation表--start-------------------------------------------------------*/
		
		//创建operation表
//		UUID uuid = UUID.randomUUID();
//		DataBuilder paramBuilder = new DataBuilder("copyright_home","operation","n", uuid.toString(), new Date(), ActionType.CREATE_TBC,null);
//		paramBuilder.addParam("copyright_id", "String");
//		paramBuilder.addParam("works_id", "String");
//		paramBuilder.addParam("account_type", "String");
//		paramBuilder.addParam("source_type", "String");
//		paramBuilder.addParam("source_data", "String");
//		paramBuilder.addParam("ope_date", "String");
//		paramBuilder.addParam("ope_id","String");
//		
//		//交易签名
//		String plainTxt = GsonUtil.getGson().toJson(paramBuilder);
//		//System.out.println("---------plainTxt:" +plainTxt +"-----------");
//		String signature = RSAUtils.sign(plainTxt.getBytes(), userPrivate);
//		//System.out.println("---------signature:" +signature +"-----------");
//		//将交易签名及对应的原文添加进map中去
//		paramBuilder.addParam("signature", Base64Utils.encode(signature.getBytes()));
//		List<JBCCResult> result = conn.createTBC(paramBuilder,tiandePublic);
//		for(int i =0;i<result.size();i++){
//			JBCCResult r = result.get(i);
//			if(r.getStatus() == 0){//0成功，1失败
//				System.out.println("-----success------");
//			}else if(r.getStatus() == 1){
//				System.out.println("-------fail-------");
//			}
//		}
		/**---------------------------------------------------创建operation表--end-------------------------------------------------------*/
		/**************************************************************创建TBC 结束*******************************************************/
		
		
		/**************************************************************INSERT/FAST_INSERT 开始********************************************/
		/**------------------------------------------------向works表插入数据--start-------------------------------------------------------*/
		//向works表插入数据
		UUID uuid = UUID.randomUUID();
		DataBuilder paramBuilder = new DataBuilder("copyright_home","works","y", uuid.toString(), new Date(), ActionType.INSERT,null);
		paramBuilder.addParam("copyright_id", uuid.toString());
		paramBuilder.addParam("banquanjia_evidence_code", uuid.toString());
		paramBuilder.addParam("evidence_code", "123456");
		paramBuilder.addParam("register_id", uuid.toString());
		paramBuilder.addParam("work_id", "http://baidu.com");
		paramBuilder.addParam("work_name", "中关村大厦");
		paramBuilder.addParam("upload_username","大厦");
		paramBuilder.addParam("upload_date", "2017-3-7 20:25:10");
		
		System.out.println("---------记录works，用于查询用，uuid:" +uuid.toString() +"-----------");
		
		//交易签名
		String plainTxt = GsonUtil.getGson().toJson(paramBuilder);
		//System.out.println("---------plainTxt:" +plainTxt +"-----------");
		String signature = RSAUtils.sign(plainTxt.getBytes(), userPrivate);
		//System.out.println("---------signature:" +signature +"-----------");
		//将交易签名及对应的原文添加进map中去
		paramBuilder.addParam("signature", Base64Utils.encode(signature.getBytes()));
		List<JBCCResult> result = conn.execute(paramBuilder, tiandePublic);
		for(int i =0;i<result.size();i++){
			JBCCResult r = result.get(i);
			if(r.getStatus() == 0){//0成功，1失败
				System.out.println("-----success------");
			}else if(r.getStatus() == 1){
				System.out.println("-------fail-------");
			}
		}
		/**------------------------------------------------向works表插入数据--end-------------------------------------------------------*/
		
		/**------------------------------------------------向operation表插入数据--start-------------------------------------------------*/
//		UUID uuid = UUID.randomUUID();
//		DataBuilder paramBuilder = new DataBuilder("copyright_home","operation","n", uuid.toString(), new Date(), ActionType.INSERT,null);
//		paramBuilder.addParam("copyright_id",uuid.toString());
//		paramBuilder.addParam("works_id",  "http://baidu.com");
//		paramBuilder.addParam("account_type", "企业");
//		paramBuilder.addParam("source_type", "固定资产");
//		paramBuilder.addParam("source_data", "中关村大厦");
//		paramBuilder.addParam("ope_date", "2017-3-7 21:05:10");
//		paramBuilder.addParam("ope_id","123");
//		
//		System.out.println("---------记录operation，用于查询用， uuid:" +uuid.toString() +"-----------");
//		
//		//交易签名
//		String plainTxt = GsonUtil.getGson().toJson(paramBuilder);
//		//System.out.println("---------plainTxt:" +plainTxt +"-----------");
//		String signature = RSAUtils.sign(plainTxt.getBytes(), userPrivate);
//		//System.out.println("---------signature:" +signature +"-----------");
//		//将交易签名及对应的原文添加进map中去
//		paramBuilder.addParam("signature", Base64Utils.encode(signature.getBytes()));
//		
//		List<JBCCResult> result = conn.execute(paramBuilder, tiandePublic);
//		for(int i =0;i<result.size();i++){
//			JBCCResult r = result.get(i);
//			if(r.getStatus() == 0){//0成功，1失败
//				System.out.println("-----success------");
//			}else if(r.getStatus() == 1){
//				System.out.println("-------fail-------");
//			}
//		}
		
		/**------------------------------------------------向operation表插入数据--end----------------------------------------------------*/
		
		/*************************************************************INSERT/FAST_INSERT 结束*********************************************/
		
		
		/**************************************************************FAST_SELECT 开始********************************************/
		
		
		/**------------------------------------------------向works表查询数据--start----------------------------------------------------*/
		
//		String works_copyright_id = "d59c42df-482e-4094-a086-e643a53cd3e9";
//		QueryBuilder queryBuilder = new QueryBuilder("copyright_home","works",ActionType.FAST_SELECT);
//		queryBuilder.addParam("copyright_id", works_copyright_id);
//		List<JBCCResult> resultList = conn.executeQuery(queryBuilder);
//		if(resultList != null){
//			System.out.println(resultList.get(0).getMessage());
//		}else{
//			System.out.println("--------result is null---------");
//		}
		
		
		//查询当前数据所在块的上一块块号和块hash值，下一块的块号和块hash值，当前块号及hash值
//		QueryBuilder queryBuilder = new QueryBuilder("copyright_home","works",ActionType.BLOCK_FAST_SELECT);
//		//当前数据对应块id
//		queryBuilder.addParam("id", "3");
//		List<JBCCResult> resultList = conn.executeQuery(queryBuilder);
//		if(resultList != null){
//			System.out.println(resultList.get(0).getMessage());
//		}else{
//			System.out.println("--------result is null---------");
//		}
		/**------------------------------------------------向works表查询数据--end----------------------------------------------------*/
		
		
       /**------------------------------------------------向operation表查询数据--start----------------------------------------------------*/
		
//		String operation_copyright_id = "b51ebefd-cc02-44e0-91bd-734b7415ddd8";
//		QueryBuilder queryBuilder = new QueryBuilder("copyright_home","operation",ActionType.FAST_SELECT);
//		queryBuilder.addParam("copyright_id", operation_copyright_id);
//		JBCCResult result = conn.executeQuery(queryBuilder);
//		if(result != null){
//			System.out.println(result.getMessage());
//		}else{
//			System.out.println("--------result is null---------");
//		}
		/**------------------------------------------------向operation表查询数据--end----------------------------------------------------*/
		
		
		/**************************************************************FAST_SELECT end********************************************/
		
	}
}
