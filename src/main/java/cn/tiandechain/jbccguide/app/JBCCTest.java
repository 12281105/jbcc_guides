package cn.tiandechain.jbccguide.app;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.tiandechain.common.bean.ActionType;
import cn.tiandechain.common.bean.DataBuilder;
import cn.tiandechain.common.bean.QueryBuilder;
import cn.tiandechain.common.exception.JBCCClientException;
import cn.tiandechain.common.exception.JBCCResult;
import cn.tiandechain.common.util.Base64Utils;
import cn.tiandechain.common.util.GsonUtil;
import cn.tiandechain.common.util.RSAUtils;
import cn.tiandechain.common.util.SHA256Util;
import cn.tiandechain.jbccclient.client.JBCCClientExecutor;
import cn.tiandechain.jbccclient.client.JBCCConnection;

/**
 * @author liwh
 * added by 2017-3-1
 */
public class JBCCTest {

	public static void main(String[] args) throws Exception {
		//用户签名私钥
		String userPrivate3 = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM7ju8WyI1L8yJtQC3N870XgmnnNphC6IISeynN5qCarf2gb9ChUrFcNiY4TKwinuDdBdhX0ZvFhb30NtRP8jibs5gspMxtV68uKl9+F5pXlRw4qyzS4JsmFhdNkWrxcxv4sOpgyJ6oT2qO9SDIvOqLPlkZkBG43sbByRMtqoigFAgMBAAECgYAs7Mi+ciM3hwqspyIFbvCqNM52epB/+1rKUYzWrGk2FHFzEvbetxxBPwBKqKDknT7kSMOymsKr0aOa/RoAAAyBxUsj1TwnLB8zpI2SN0hDVmGWrcC36t4OJJ0jsOhSTPvAAzczkfo2xG9ofLjikiVaj7iTKQ8YGu3WzqJqkucZYQJBAPEP+3ISDGesuzhN/pO/jJ54lvOpD2/FAuXFcSMzbJkeu+Y9zFP1u6sQJyjfOyZBB9fql4XSNykwFbuokbhd7S0CQQDbtak+bIOxDzMUlTPOLx6+ZeUoSQ/B6ljvBgNqi7jLxPOEw8+24AzoJjIICTRuPGKpLsCX9oHIOYJ0rUsIK105AkB1yvF7VAZrwqPZZ4M2fysfZJ2egsXgP8yiqlAWe1Jdn/8BCsGFZVZGyKXZ+vrUPoKupxtTcN0zayOzhzNte7ghAkBdBhlWWNOZT/osqM96aPD3ZGUWHXkSfYqSCVXA8s+XVxhUCiQUJeDRGfrs9BjC48ZSI31f2fsxL0hQ5l5yYwnhAkEAmej9siflw1lO1LNXitVcvvTk+uuHzO7Q51cwingffa5XtbgrjTyOKWS5w11xgZBHoOsAzqjX79zYJXo8AvJKNQ==";
		//天德公钥
		String tiandePublic = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCICwf6uM5n+UkCjvXmC3tBP5AA/RO/HffYa+FolZXdCOIZJmrReafqwhR24ntJ6xSeXLgiIKT/VYhyh+HEtzyF52XHc4X/fu/v7SL6QdkyveNcKBp5lkEu9zZZUCYFohnn98Csi0QEAaM9zShunjuWoYeK2/izSW1mI2tZex5J+wIDAQAB";
		
		String userPrivate = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALu+IkCwZnPdH7cypMCGU0lsFps1FS/fxmdYQAMIHMveNGmxp5TudvmICFZwy1pqPYbZoIAHN6NrTqBIs718+uJDBudTI1Qb97tHYRiFJ9PTS+M9KeyFt+Go3d4yLM3bwNZ3Ahx4XwdzHf00pnYoqe2RWIyYQ9jnqPMPxEbEV0U5AgMBAAECgYB5+PMj9/b3+4dpbBuhgSOHJhQhzgDv04CBD9K2pYSf5sNCj8sCdVMSlxBjqHBVU4SZobYmt4msQEEa3WD5EMOlMTAHLKX3xm4LJMg8VNInw7HRi4z8dvvPt+jXawo89B0vXP6E3wwVsMpRlQdyy+lpJ0frpB5NW0GeGR/fh79iIQJBAPiB+iX9QtRQmVJXSVhe5V5kZ56K/3+k6kLCvxALZHPB9FqFkc0oKaiCLy9shG0oYTGq5QQASWInRJhc99BBKSUCQQDBZymV+cbkEzQrig+lhl6gbNg3QDR24Px/xqNZSoydAD7GVxWrE4hTF5mMGr2PUzKXTKriw2ztoxpTfC4LGMGFAkEA3z8M9THW5ptdkZ4+krf1gF3cxI4ER6xkkwMW15gUbvWPyf5yZAavneUN9KGdOd7rqc3nnTeQtS+nrOTf72OKTQJBAJtGgTvZCxcIWAVw1fkWNZjlan6JfNXI8tB/oZxJ3zUaAkxplIsCppvXwb6bpX+R03dn5XckYas1HSjT9X+RQ6UCQB3/+/OzJlj6RrIFw2ras9TvikTUrQO5JqaPEfXSJfb/ktzge94ZSSTP/mjyAyOEKbDWVdRYrEW37nQNw+v6F5Y=";
		
		String userName = "test01";
		String password = "password01";
		JBCCConnection conn = JBCCConnection.getInstance();
		conn.init(userName, password, tiandePublic);
		
		/** ***********************************************************创建TBC 开始*******************************************************/
//		UUID uuid = UUID.randomUUID();
//		DataBuilder paramBuilder = new DataBuilder("CopyrightHome", uuid.toString(), new Date(), ActionType.CREATE_TBC,null);
//		paramBuilder.addParam("agent_id", "String");
//		paramBuilder.addParam("agent_user_id", "String");
//		paramBuilder.addParam("register_type", "String");
//		paramBuilder.addParam("product_label", "String");
//		paramBuilder.addParam("product_name", "String");
//		paramBuilder.addParam("agent_idempotent", "String");
//		paramBuilder.addParam("product_hash", "String[]");
//		paramBuilder.addParam("product_type", "String");
//		paramBuilder.addParam("dci", "String");
//		paramBuilder.addParam("creative_date", "long");
//		paramBuilder.addParam("creative_address", "String");
//		paramBuilder.addParam("publish_status", "String");
//		paramBuilder.addParam("publish_date", "String");
//		paramBuilder.addParam("publish_address", "String");
//		paramBuilder.addParam("creative_purpose", "String");
//		paramBuilder.addParam("creative_process", "String");
//		paramBuilder.addParam("creative_self", "String");
		
		//创建表1
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
		
		//创建表2
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
//		JBCCResult result = conn.createTBC(paramBuilder,tiandePublic);
//		if(result != null){
//			if(result.getStatus() == 0){//0成功，1失败
//				System.out.println("-----success------");
//			}else if(result.getStatus() == 1){
//				System.out.println("-------fail-------");
//			}
//		}
		/**************************************************************创建TBC 结束*******************************************************/
		
		
		/**************************************************************INSERT/FAST_INSERT 开始********************************************/
//		UUID uuid = UUID.randomUUID();
//		DataBuilder paramBuilder = new DataBuilder("UnivInfoTransaction","","", uuid.toString(), new Date(), ActionType.INSERT,null);
//		paramBuilder.addParam("userId", uuid.toString());
//		paramBuilder.addParam("name", uuid.toString());
//		paramBuilder.addParam("introduction", "test");
//		paramBuilder.addParam("vtype", "0");
//		paramBuilder.addParam("publicinfo", "Arizona State University");
//		paramBuilder.addParam("privateinfo", "Getting Started for make mooncake");
//		paramBuilder.addParam("sex", "male");
//		paramBuilder.addParam("title", "test");
//		paramBuilder.addParam("college", "北大");
//		paramBuilder.addParam("degree", "学士");
//		paramBuilder.addParam("background", "不告诉你");
//		paramBuilder.addParam("email", "a@163.com");
		
		//表1插入数据
//		UUID uuid = UUID.randomUUID();
//		DataBuilder paramBuilder = new DataBuilder("copyright_home","works","y", uuid.toString(), new Date(), ActionType.INSERT,null);
//		paramBuilder.addParam("copyright_id", uuid.toString());
//		paramBuilder.addParam("banquanjia_evidence_code", uuid.toString());
//		paramBuilder.addParam("evidence_code", "123456");
//		paramBuilder.addParam("register_id", uuid.toString());
//		paramBuilder.addParam("work_id", "http://baidu.com");
//		paramBuilder.addParam("work_name", "中关村大厦");
//		paramBuilder.addParam("upload_username","大厦");
//		paramBuilder.addParam("upload_date", "2017-3-10 15:25:10");
		
		//表2插入数据
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
//		System.out.println("---------uuid:" +uuid.toString() +"-----------");
//		
//		//交易签名
//		String plainTxt = GsonUtil.getGson().toJson(paramBuilder);
//		//System.out.println("---------plainTxt:" +plainTxt +"-----------");
//		String signature = RSAUtils.sign(plainTxt.getBytes(), userPrivate);
//		//System.out.println("---------signature:" +signature +"-----------");
//		//将交易签名及对应的原文添加进map中去
//		paramBuilder.addParam("signature", Base64Utils.encode(signature.getBytes()));
//		JBCCResult result = conn.execute(paramBuilder, tiandePublic);
//		if(result != null){
//			if(result.getStatus() == 0){//0成功，1失败
//				System.out.println("-----success------");
//			}else if(result.getStatus() == 1){
//				System.out.println("-------fail-------");
//			}
//		}
//		
		/*************************************************************INSERT/FAST_INSERT 结束*********************************************/
		
		/**************************************************************BATCH_INSERT/BATCH_FAST_INSERT 开始********************************/
//		List<DataBuilder> dataList = new ArrayList<DataBuilder>();
//		int m = 1000;
//		for(int i = 0;i<m;i++){
//			UUID uuid = UUID.randomUUID();
//			DataBuilder paramBuilder = new DataBuilder("copyright_home","works","y", uuid.toString(), new Date(), ActionType.BATCH_INSERT,null);
//			paramBuilder.addParam("userId", uuid.toString());
//			paramBuilder.addParam("name", uuid.toString());
//			paramBuilder.addParam("introduction", "test");
//			paramBuilder.addParam("vtype", "0");
//			paramBuilder.addParam("publicinfo", "Arizona State University");
//			paramBuilder.addParam("privateinfo", "Getting Started for make mooncake");
//			paramBuilder.addParam("sex", "male");
//			paramBuilder.addParam("title", "test");
//			paramBuilder.addParam("college", "北大");
//			paramBuilder.addParam("degree", "学士");
//			paramBuilder.addParam("background", "不告诉你");
//			paramBuilder.addParam("email", "a@163.com");
			
			
		
//			paramBuilder.addParam("copyright_id", uuid.toString());
//			paramBuilder.addParam("banquanjia_evidence_code", "123");
//			paramBuilder.addParam("evidence_code", "123456");
//			paramBuilder.addParam("register_id", "123");
//			paramBuilder.addParam("work_id", "http://baidu.com");
//			paramBuilder.addParam("work_name", "中关村大厦");
//			paramBuilder.addParam("upload_username","大厦");
//			paramBuilder.addParam("upload_date", "2017-3-7 20:25:10");
//			
//			//交易签名
//			String plainTxt = GsonUtil.getGson().toJson(paramBuilder);
//			//System.out.println("---------plainTxt:" +plainTxt +"-----------");
//			String signature = RSAUtils.sign(plainTxt.getBytes(), userPrivate);
//			//System.out.println("---------signature:" +signature +"-----------");
//			//将交易签名及对应的原文添加进map中去
//			paramBuilder.addParam("signature", Base64Utils.encode(signature.getBytes()));
//			dataList.add(paramBuilder);
//		}
//		
//		JBCCResult result = conn.batchExecute(dataList,tiandePublic);
//		if(result != null){
//			if(result.getStatus() == 0){//0成功，1失败
//				System.out.println("-----success------");
//			}else if(result.getStatus() == 1){
//				System.out.println("-------fail-------");
//			}
//		}
		
		/**************************************************************BATCH_INSERT/BATCH_FAST_INSERT 结束********************************/
		
		/**************************************************************SELECT/FAST_SELECT 开始********************************************/
		
		//查询部分
//		UUID uuid = UUID.randomUUID();
//		DataBuilder paramBuilder = new DataBuilder("UnivInfoTransaction", uuid.toString(), new Date(), ActionType.SELECT,null);
//		paramBuilder.addParam("userId", uuid.toString());
//		paramBuilder.addParam("name", uuid.toString());
//		paramBuilder.addParam("introduction", "test");
//		paramBuilder.addParam("vtype", "0");
//		paramBuilder.addParam("publicinfo", "Arizona State University");
//		paramBuilder.addParam("privateinfo", "Getting Started for make mooncake");
//		paramBuilder.addParam("sex", "male");
//		paramBuilder.addParam("title", "test");
//		paramBuilder.addParam("college", "北大");
//		paramBuilder.addParam("degree", "学士");
//		paramBuilder.addParam("background", "不告诉你");
//		paramBuilder.addParam("email", "a@163.com");
		
//		String copyright_id = "f896e58b-4e98-4831-93f9-4ac79bd8e582";
//		QueryBuilder queryBuilder = new QueryBuilder("copyright_home","works",ActionType.FAST_SELECT);
//		queryBuilder.addParam("copyright_id", copyright_id);
//		JBCCResult result = conn.executeQuery(queryBuilder);
//		if(result != null){
//			System.out.println(result.getMessage());
//		}else{
//			System.out.println("--------result is null---------");
//		}
		/**************************************************************SELECT/FAST_SELECT 开始********************************************/
		
		//ABC TBC分开场景
		//conn.createABC(paramBuilder);
		
		
		//统一场景
//		conn.execute(dataList.get(0),tiandePublic);
		
//		System.out.printf(" test System.currentTimeMillis() %dms \n", System.currentTimeMillis());
//		int count = 0;
//		int time = 0;
//		if (args.length > 0) {
//	            count = Integer.parseInt(args[0]);
//	            time = Integer.parseInt(args[1]);
//	     }else{
//	    	 count = 1;
//	    	 time = 1;
//	     }
//		
//		simulate(conn,count,time,userPrivate,tiandePublic);
		
//		test();
	}
	
	
	public static void simulate(JBCCConnection conn, int count, int time,String userPrivate,String tiandePublic)
			throws Exception {
		int curr_sec = 0;

		while (curr_sec < time) {
			System.out.println(String.valueOf(curr_sec));

			long start = System.currentTimeMillis();
			List<DataBuilder> dataList = new ArrayList<DataBuilder>();
			//int m = 1000;
			for(int i = 0;i<count;i++){
				UUID uuid = UUID.randomUUID();
//				DataBuilder paramBuilder = new DataBuilder("UnivInfoTransaction","","", uuid.toString(), new Date(), ActionType.BATCH_INSERT,null);
//				paramBuilder.addParam("userId", uuid.toString());
//				paramBuilder.addParam("name", uuid.toString());
//				paramBuilder.addParam("introduction", "test");
//				paramBuilder.addParam("vtype", "0");
//				paramBuilder.addParam("publicinfo", "Arizona State University");
//				paramBuilder.addParam("privateinfo", "Getting Started for make mooncake");
//				paramBuilder.addParam("sex", "male");
//				paramBuilder.addParam("title", "test");
//				paramBuilder.addParam("college", "北大");
//				paramBuilder.addParam("degree", "学士");
//				paramBuilder.addParam("background", "不告诉你");
//				paramBuilder.addParam("email", "a@163.com");
				
				DataBuilder paramBuilder = new DataBuilder("copyright_home","works","y", uuid.toString(), new Date(), ActionType.BATCH_INSERT,null);
				paramBuilder.addParam("copyright_id", uuid.toString());
				paramBuilder.addParam("banquanjia_evidence_code", "123");
				paramBuilder.addParam("evidence_code", "123456");
				paramBuilder.addParam("register_id", "123");
				paramBuilder.addParam("work_id", "http://baidu.com");
				paramBuilder.addParam("work_name", "中关村大厦");
				paramBuilder.addParam("upload_username","大厦");
				paramBuilder.addParam("upload_date", "2017-3-7 20:25:10");
				
				//交易签名
				String plainTxt = GsonUtil.getGson().toJson(paramBuilder);
				//System.out.println("---------plainTxt:" +plainTxt +"-----------");
				plainTxt = SHA256Util.sha256(plainTxt);
				String signature = RSAUtils.sign(plainTxt.getBytes(), userPrivate);
				//System.out.println("---------signature:" +signature +"-----------");
				//将交易签名及对应的原文添加进map中去
				paramBuilder.addParam("signature", Base64Utils.encode(signature.getBytes()));
				dataList.add(paramBuilder);
			}
			
			System.out.printf("for System.currentTimeMillis() %dms \n", System.currentTimeMillis());
			System.out.printf("for circle use %dms \n", (System.currentTimeMillis() - start));
//			JBCCResult result = conn.batchExecute(dataList,tiandePublic);
//			if(result != null){
//				if(result.getStatus() == 0){//0成功，1失败
//					System.out.println("-----success------");
//				}else if(result.getStatus() == 1){
//					System.out.println("-------fail-------");
//				}
//			}
			
			System.out.printf("batch use %dms \n", (System.currentTimeMillis() - start));

			curr_sec++;
//			try {
//				Thread.sleep(sleepTime * 1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		}

		
	}

}
