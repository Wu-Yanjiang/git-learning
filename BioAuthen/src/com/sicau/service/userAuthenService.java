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
	//��ͨ�û���֤ģʽ--����	
	public jdbcUsers faceCompare(String face_img){	
		/*
				 * ����������ȡ�����ظ���������ͨ�û�id
				 * ������Щid��������·��ͼƬ��ͬ��Щid��Ӧ������ͼƬ�ȶ�
				 * �ȶԳɹ����ظ��û�����Ϣ�����ɹ���������ֱ����󷵻�null
				 */
		usersDao usDao = new usersDao();
		faceDao fcDao = new faceDao();
		//�õ��������������е�Ȩ��ֵΪ��ͨ�û����û�����ļ���
		ArrayList<jdbcUsers> uList = usDao.findFullFace(2);
		//�����������
		for(jdbcUsers u : uList){
			//��������Ӧ��ͼƬ����ļ���
			ArrayList<jdbcFace> fcList = fcDao.findByUserId(u.getId());
			//�ٱ���ͼ�񼯺�
			for(jdbcFace f : fcList){
				//�õ�ͼ���·��
				String img = f.getFaceImg_url();
				/*
				 * ������·���ȶԣ��ȶԳ����
				 */
				boolean result = true;
				if(result){
					return u;//�ȶԳɹ�����u
				}
			}
		}
		//����������û�У�����null
		return null;
		}
	
	
	
	//����Ա��¼--����
	public boolean adminfaceCompare(String face_img){
		/*
		 * ����������ȡ�����ظ������й���Ա�û���id
		 * ͬ��
		 
		usersDao usDao = new usersDao();
		faceDao fcDao = new faceDao();
		//�õ��������������е�Ȩ��ֵΪ����Ա���û�����ļ���
		ArrayList<jdbcUsers> uList = usDao.findFullFace(1);
		//�����������
		for(jdbcUsers u : uList){
			//��������Ӧ��ͼƬ����ļ���
			ArrayList<jdbcFace> fcList = fcDao.findByUserId(u.getId());
			//�ٱ���ͼ�񼯺�
			for(jdbcFace f : fcList){
				//�õ�ͼ���·��
				String img = f.getFaceImg_url();
				boolean result = true;
				if(result){
					return u;//�ȶԳɹ�����u
				}
			}
		}
		*/
		faceUtils fcu = new faceUtils();
		JSONObject obj = fcu.face_rec(face_img);
		//System.out.println(obj.toString());
		System.out.println("�����");
		String a = obj.getJSONArray("result").getJSONObject(0).get("scores").toString();
		System.out.println(a);
		System.out.println("��ӡ����");
		double score = Double.parseDouble(a.substring(1, a.length()-1));
		System.out.println(score);
		if(score>80){
			return true;
		}
		return false;
		//return false;
	}
	
	//��ͨ�û���֤ģʽ--ָ��
	public jdbcUsers fingerCompare(String finger_img){
		/*
		 * ��ָ�Ʊ���ȡ�����ظ���������ͨ�û���id
		 * ͬ��
		 */
		usersDao usDao = new usersDao();
		fingerDao fgDao = new fingerDao();
		//�õ���ָ�Ʊ������е�Ȩ��ֵΪ��ͨ�û����û�����ļ���
		ArrayList<jdbcUsers> uList = usDao.findFullFace(2);
		//�����������
		for(jdbcUsers u : uList){
			//��������Ӧ��ͼƬ����ļ���
			ArrayList<jdbcFinger> fgList = fgDao.findByUserId(u.getId());
			//�ٱ���ͼ�񼯺�
			for(jdbcFinger f : fgList){
				//�õ�ͼ���·��
				String img = f.getFingerprintImge_url();
				/*
				 * ������·���ȶԣ��ȶԳ����
				 */
				boolean result = true;
				if(result){
					return u;//�ȶԳɹ�����u
				}
			}
		}
		//����������û�У�����null
		return null;
	}
	
	//����Ա��¼--ָ��
	public jdbcUsers adminfingerCompare(String finger_img){
		/*
		 * ��ָ�Ʊ���ȡ�����ظ������й���Ա�û���id
		 * ͬ��
		 
		usersDao usDao = new usersDao();
		fingerDao fgDao = new fingerDao();
		//�õ���ָ�Ʊ������е�Ȩ��ֵΪ����Ա���û�����ļ���
		ArrayList<jdbcUsers> uList = usDao.findFullFace(1);
		//�����������
		for(jdbcUsers u : uList){
			//��������Ӧ��ͼƬ����ļ���
			ArrayList<jdbcFinger> fgList = fgDao.findByUserId(u.getId());
			//�ٱ���ͼ�񼯺�
			for(jdbcFinger f : fgList){
				//�õ�ͼ���·��
				String img = f.getFingerprintImge_url();
				boolean result = true;
				if(result){
					return u;//�ȶԳɹ�����u
				}
			}
		}
	*/
		//����������û�У�����null
		return null;
	}
}
