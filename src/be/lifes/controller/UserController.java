package be.lifes.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.life.dao.UserDao;
import be.life.model.Profile;

public class UserController {
	private static ResultSet rs;
	
	public String profileController(Profile profile, int idProfileBrand){
		int idProfile;
		//verificar se usuário já existe e pegar id
	
		idProfile = getUser(profile);
		//se não existe criar
		if(idProfile == 0){
			idProfile = createUser(profile);
		}
		System.out.println("Inicio com >>> " +  idProfile);
		
		if(idProfile==0){
			return "erro";
		}
		//aceitar os termos e deixar como protegido.
		boolean termos = false;
		termos = setActiveAndProtected(idProfile);
		
		if(!termos)
			return "erro";
		
		//colocar a foto de avatar
		boolean image = setImageAvatar(idProfile, profile.getUrlAvatar());
		
		if(!image)
			return "erro";
		
		image = setImageBanner(idProfile, profile.getUrlBanner());
		if(!image)
			return "erro";
		
		//salvar as redes sociais
		if(profile.getIdFace() != null || profile.getIdInsta()!= null){
			setSocialAccounts(profile, idProfile);
		}
		//salvar as variaveis
		
		saveVariables(profile, idProfile);
		//seguir a marca e a marca seguir a pessoa.
		setFollow(idProfile, idProfileBrand);
		System.out.println("Fim com >>> " +  idProfile);
		return "ok";
	}
	
	private void saveVariables(Profile profile, int idProfile){
		ArrayList<String> list = new ArrayList<String>();
		Utils util = new Utils();
		UserDao dao = new UserDao();
		list = util.generateVariablesUnauthorized(profile);
		
		for(String name : list){
			dao.saveNameUnauthorized(idProfile, name);
		}
		
		list = util.generateVariablesProtected(profile);
		for(String name : list){
			dao.saveNameBlocked(idProfile, name);
		}
	}
	
	private void setFollow(int idProfile, int idProfileBrand){
		UserDao dao = new UserDao();
		if(idProfileBrand!=0){
			dao.setFollow(idProfile, idProfileBrand);
			dao.setFollow(idProfileBrand, idProfile);
		}
		dao.setFollow(idProfile, 1);
	}
	
	private void setSocialAccounts(Profile profile, int idProfile){
		UserDao dao = new UserDao();
		
		if(profile.getIdFace() != null ){
			dao.setSocialAccount(idProfile, profile.getIdFace(), 6, profile.getUserFace());
		}
		
		if(profile.getIdInsta()!= null){
			dao.setSocialAccount(idProfile, profile.getIdInsta(), 3, profile.getUserInsta());
		}

	}
	
	private boolean setActiveAndProtected(int idProfile){
		UserDao dao = new UserDao();
		
		dao.setTerms(idProfile);
		
		return dao.acceptTermsAndProtectedProfile(idProfile);
	}
	
	private boolean setImageAvatar(int idProfile, String url){
		UserDao dao = new UserDao();		
		return dao.setAvatarImage(idProfile, url);
	}
	
	private boolean setImageBanner(int idProfile, String url){
		UserDao dao = new UserDao();		
		return dao.setBannerImage(idProfile, url);
	}
	
	private int createUser(Profile profile){
		UserDao dao = new UserDao();
		rs = dao.createUser(profile);
		int id = 0;
		if(rs==null){
			return id;
		}
		try {
			while (rs.next()) {
				id =  rs.getInt("id_profile");
			}
			rs.close();
			return id;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
	}
	
	
	
	public int getUser(Profile profile){
		int idProfile = 0;
		
		UserDao dao = new UserDao();
		rs = dao.getUserDAO(profile);
		if(rs==null){
			return 0;
		}
		try {
			while (rs.next()) {
				idProfile = rs.getInt("id_profile");
			}
			rs.close();
			return idProfile;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
	
	}
}
