package com.sicau.service;

import java.util.ArrayList;

import org.json.JSONObject;

import com.sicau.dao.faceDao;
import com.sicau.dao.fingerDao;
import com.sicau.dao.usersDao;
import com.sicau.jdbc.domain.jdbcFace;
import com.sicau.jdbc.domain.jdbcFinger;
import com.sicau.jdbc.domain.jdbcUsers;
import com.sicau.utils.faceUtils;

public class userAuthenService {
	//普通用户认证模式--人脸	
	public jdbcUsers faceCompare(String face_img){	
		/*
				 * 从人脸表中取出不重复的所有普通用户id
				 * 遍历这些id，将参数路径图片的同这些id对应的所有图片比对
				 * 比对成功返回该用户的信息，不成功继续遍历直到最后返回null
				 */
		usersDao usDao = new usersDao();
		faceDao fcDao = new faceDao();
		//得到了人脸表中所有的权限值为普通用户的用户对象的集合
		ArrayList<jdbcUsers> uList = usDao.findFullFace(2);
		//遍历这个集合
		for(jdbcUsers u : uList){
			//这个对象对应的图片对象的集合
			ArrayList<jdbcFace> fcList = fcDao.findByUserId(u.getId());
			//再遍历图像集合
			for(jdbcFace f : fcList){
				//得到图像的路径
				String img = f.getFaceImg_url();
				/*
				 * 对两个路径比对，比对出结果
				 */
				boolean result = true;
				if(result){
					return u;//比对成功返回u
				}
			}
		}
		//遍历下来都没有，返回null
		return null;
		}
	
	
	
	//管理员登录--人脸
	public boolean adminfaceCompare(String face_img){
		/*
		 * 从人脸表中取出不重复的所有管理员用户的id
		 * 同上
		 
		usersDao usDao = new usersDao();
		faceDao fcDao = new faceDao();
		//得到了人脸表中所有的权限值为管理员的用户对象的集合
		ArrayList<jdbcUsers> uList = usDao.findFullFace(1);
		//遍历这个集合
		for(jdbcUsers u : uList){
			//这个对象对应的图片对象的集合
			ArrayList<jdbcFace> fcList = fcDao.findByUserId(u.getId());
			//再遍历图像集合
			for(jdbcFace f : fcList){
				//得到图像的路径
				String img = f.getFaceImg_url();
				boolean result = true;
				if(result){
					return u;//比对成功返回u
				}
			}
		}
		*/
		faceUtils fcu = new faceUtils();
		JSONObject obj = fcu.face_rec(face_img);
		//System.out.println(obj.toString());
		System.out.println("结果：");
		String a = obj.getJSONArray("result").getJSONObject(0).get("scores").toString();
		System.out.println(a);
		System.out.println("打印结束");
		double score = Double.parseDouble(a.substring(1, a.length()-1));
		System.out.println(score);
		if(score>80){
			return true;
		}
		return false;
		//return false;
	}
	
	//普通用户认证模式--指纹
	public jdbcUsers fingerCompare(String finger_img){
		/*
		 * 从指纹表中取出不重复的所有普通用户的id
		 * 同上
		 */
		usersDao usDao = new usersDao();
		fingerDao fgDao = new fingerDao();
		//得到了指纹表中所有的权限值为普通用户的用户对象的集合
		ArrayList<jdbcUsers> uList = usDao.findFullFace(2);
		//遍历这个集合
		for(jdbcUsers u : uList){
			//这个对象对应的图片对象的集合
			ArrayList<jdbcFinger> fgList = fgDao.findByUserId(u.getId());
			//再遍历图像集合
			for(jdbcFinger f : fgList){
				//得到图像的路径
				String img = f.getFingerprintImge_url();
				/*
				 * 对两个路径比对，比对出结果
				 */
				boolean result = true;
				if(result){
					return u;//比对成功返回u
				}
			}
		}
		//遍历下来都没有，返回null
		return null;
	}
	
	//管理员登录--指纹
	public jdbcUsers adminfingerCompare(String finger_img){
		/*
		 * 从指纹表中取出不重复的所有管理员用户的id
		 * 同上
		 
		usersDao usDao = new usersDao();
		fingerDao fgDao = new fingerDao();
		//得到了指纹表中所有的权限值为管理员的用户对象的集合
		ArrayList<jdbcUsers> uList = usDao.findFullFace(1);
		//遍历这个集合
		for(jdbcUsers u : uList){
			//这个对象对应的图片对象的集合
			ArrayList<jdbcFinger> fgList = fgDao.findByUserId(u.getId());
			//再遍历图像集合
			for(jdbcFinger f : fgList){
				//得到图像的路径
				String img = f.getFingerprintImge_url();
				boolean result = true;
				if(result){
					return u;//比对成功返回u
				}
			}
		}
	*/
		//遍历下来都没有，返回null
		return null;
	}
}
