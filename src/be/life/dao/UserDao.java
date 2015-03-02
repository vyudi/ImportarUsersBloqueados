package be.life.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import be.life.conn.Conn;
import be.life.model.Profile;

public class UserDao {
	private static Connection con;
	private static ResultSet rs;
	
	public ResultSet getUserDAO(Profile profile){
		
		try {
			con = Conn.connect();
			Statement stmt = con.createStatement(); 
			String username = "";
			if(profile.getUserFace()!= null && !profile.getUserFace().equals("")){
				username = profile.getUserFace();
			}else if(profile.getUserInsta()!= null && !profile.getUserInsta().equals("")){
				username = profile.getUserInsta();
			}else if (profile.getTmUser()!= null && !profile.getTmUser().equals("")){
				username = profile.getTmUser();
			}else if(profile.getUserEspecial()!= null && !profile.getUserEspecial().equals("")){
				username = profile.getUserEspecial();
			}else if(profile.getUserVar1()!= null && !profile.getUserVar1().equals("")){
				username = profile.getUserVar1();
			}else if(profile.getUserVar2()!= null && !profile.getUserVar2().equals("")){
				username = profile.getUserVar2();
			}else if(profile.getUserVar3()!= null && !profile.getUserVar3().equals("")){
				username = profile.getUserVar3();
			}else if(profile.getUserVar4()!= null && !profile.getUserVar4().equals("")){
				username = profile.getUserVar4();
			}
			
			String query = "SELECT id_profile FROM tb_list_username where username ='"+username+"' order by id_profile desc limit 1";

			rs = stmt.executeQuery(query); 
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
		
	}
	
	public ResultSet createUser(Profile profile){
		      try {
		    	  	String sql; 
					con = Conn.connect();

					String username = "";
					if(profile.getUserFace()!= null && !profile.getUserFace().equals("")){
						username = profile.getUserFace();
					}else if(profile.getUserInsta()!= null && !profile.getUserInsta().equals("")){
						username = profile.getUserInsta();
					}else if (profile.getTmUser()!= null && !profile.getTmUser().equals("")){
						username = profile.getTmUser();
					}else if(profile.getUserEspecial()!= null && !profile.getUserEspecial().equals("")){
						username = profile.getUserEspecial();
					}else if(profile.getUserVar1()!= null && !profile.getUserVar1().equals("")){
						username = profile.getUserVar1();
					}else if(profile.getUserVar2()!= null && !profile.getUserVar2().equals("")){
						username = profile.getUserVar2();
					}else if(profile.getUserVar3()!= null && !profile.getUserVar3().equals("")){
						username = profile.getUserVar3();
					}else if(profile.getUserVar4()!= null && !profile.getUserVar4().equals("")){
						username = profile.getUserVar4();
					}
					sql = "{call pr_ins_user("+ "'"+ username + "'," + "'" + "'," + "'" + profile.getPassword() + "'" +")}"; 
		            CallableStatement cb = con.prepareCall(sql);
		            ResultSet rsa = cb.executeQuery();
		            
		            return rsa;
				} catch (Exception e) {
					
					e.printStackTrace();
				}
		
		return null;
		
	}
	
	public boolean acceptTermsAndProtectedProfile(int idProfile){
		
		try {
			con = Conn.connect();
			String query = "Update tb_profile set active = 1,  is_protected = 1 where id ="+idProfile;
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      // execute the java preparedstatement
		      preparedStmt.executeUpdate();
		      preparedStmt.close();
		      return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;	
	}
	
	public boolean getBannerImage(int idProfile){
		boolean retorno = false;
		try {
			con = Conn.connect();
			Statement stmt = con.createStatement(); 
			
			String query = "SELECT id FROM tb_image_profile where id_profile ="+idProfile+" and is_avatar = 0 and active = 1";

			rs = stmt.executeQuery(query); 
			
			while (rs.next()) {
				retorno = true;
			}
			rs.close();
			stmt.close();
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return retorno;
	}
	
	public boolean setBannerImage(int idProfile, String url){
		
		if(getBannerImage(idProfile)){
			return true;
		}
		try {
			con = Conn.connect();
			int server = 2;
			
			String query = "INSERT INTO `tb_image_profile` ( `id_profile`, `id_server`, `image_profile`, `is_avatar`, `active`) "+
					" VALUES ("+ idProfile+ ","+ server +",'"+ url + "', 0, 1)";
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      // execute the java preparedstatement
		      preparedStmt.executeUpdate();
		     preparedStmt.close();
		      return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean getAvatarImage(int idProfile){
		boolean retorno = false;
		try {
			con = Conn.connect();
			Statement stmt = con.createStatement(); 
			
			String query = "SELECT id FROM tb_image_profile where id_profile ="+idProfile+" and is_avatar = 1 and active = 1";

			rs = stmt.executeQuery(query); 
			
			while (rs.next()) {
				retorno = true;
			}
			rs.close();
			stmt.close();
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return retorno;
	}
	
	public boolean setAvatarImage(int idProfile, String url){
		
		if(getAvatarImage(idProfile)){
			return true;
		}
		
		try {
			con = Conn.connect();
			int server = 8;
			if(url.equals("avatar_star.jpg")){
				server = 2;
			}
			
			String query = "INSERT INTO `tb_image_profile` ( `id_profile`, `id_server`, `image_profile`, `is_avatar`, `active`) "+
					" VALUES ("+ idProfile+ ","+ server +",'"+ url + "', 1, 1)";
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      // execute the java preparedstatement
		      preparedStmt.executeUpdate();
		     preparedStmt.close();
		      return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean getSocialAccount(int idProfile, int socialType){
		boolean retorno = false;
		try {
			con = Conn.connect();
			Statement stmt = con.createStatement(); 
			
			String query = "SELECT count(*) as total FROM tb_social_network_profile where id_profile ="+idProfile+" and id_social_network = " + socialType + " and active = 1";
			
			rs = stmt.executeQuery(query); 
			
			while (rs.next()) {
				if(rs.getInt("total")>0)
					retorno = true;
			}
			
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return retorno;
	}
	
	public boolean setSocialAccount(int idProfile, String idLogin, int socialType, String username){
		
		if(getSocialAccount(idProfile,socialType)){
			return true;
		}
		
		try {
			con = Conn.connect();
			String url;
			if(socialType == 3){
				url = "http://www.instagram.com/"+username;
			}else{
				url = "https://www.facebook.com/"+idLogin;
			}
			
			String query = "INSERT INTO `tb_social_network_profile` (`id_profile`, `id_social_network`, `address`, `login`, friends, `active`)"+
					" VALUES ("+ idProfile+ ","+ socialType +",'"+ url + "', '" + idLogin + "', '0',1)";
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      // execute the java preparedstatement
		      preparedStmt.executeUpdate();
		     preparedStmt.close();
		      return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean setFollow(int idProfile, int idProfileFollow){
	      try {
	    	  	String sql; 
				con = Conn.connect();
				
				sql = "{call pr_ins_follows(" + idProfile + ", " + idProfileFollow + ", " + 0 + ")}"; 
	            CallableStatement cb = con.prepareCall(sql);
	            ResultSet rsa = cb.executeQuery();
	            rsa.close();
	            cb.close();
	            return true;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	
	      return false;
	
	}
	
	public void setTerms(int idProfile){
	      try {
	    	  	String sql; 
				con = Conn.connect();
				sql = "{call pr_ins_preferences_profile(" + idProfile + ")}"; 
	            CallableStatement cb = con.prepareCall(sql);
	            ResultSet rsa = cb.executeQuery();
	            rsa.close();
	            cb.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void saveNameBlocked(int idProfile, String name){
	      try {
	    	  	String sql; 
				con = Conn.connect();
				sql = "{call pr_ins_blocked_name(" + idProfile +",'" + name + "')}"; 
	            CallableStatement cb = con.prepareCall(sql);
	            ResultSet rsa = cb.executeQuery();
	            rsa.close();
	            cb.close();
	            con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void saveNameUnauthorized(int idProfile, String name){
	      try {
	    	  	String sql; 
				con = Conn.connect();
				sql = "{call pr_ins_unauthorized_username('" + name +"'," + 0 + ")}"; 
	            CallableStatement cb = con.prepareCall(sql);
	            ResultSet rsa = cb.executeQuery();
	            rsa.close();
	            cb.close();
	            con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}


