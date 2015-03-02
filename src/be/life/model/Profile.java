package be.life.model;

public class Profile {

	private String userFace;
	private String idFace;
	private String userInsta;
	private String idInsta;
	private String tmUser;//Nao pode ter variavel
	private String userEspecial;//pode ter variavel
	private String userVar1;
	private String userVar2;
	private String userVar3;
	private String userVar4;
	private String urlAvatar;
	private String password;
	private String urlBanner;
	
	public Profile(){
		
	};

	public Profile(String userFace, String idFace, String userInsta,
			String idInsta, String tmUser, String userEspecial,
			String userVar1, String userVar2, String userVar3, String userVar4,
			String urlAvatar, String password, String urlBanner) {
		super();
		this.userFace = userFace;
		this.idFace = idFace;
		this.userInsta = userInsta;
		this.idInsta = idInsta;
		this.tmUser = tmUser;
		this.userEspecial = userEspecial;
		this.userVar1 = userVar1;
		this.userVar2 = userVar2;
		this.userVar3 = userVar3;
		this.userVar4 = userVar4;
		this.urlAvatar = urlAvatar;
		this.password = password;
		this.urlBanner = urlBanner;
	}

	public String getUserFace() {
		return userFace;
	}
	public void setUserFace(String userFace) {
		this.userFace = userFace;
	}
	public String getIdFace() {
		return idFace;
	}
	public void setIdFace(String idFace) {
		this.idFace = idFace;
	}
	public String getUserInsta() {
		return userInsta;
	}
	public void setUserInsta(String userInsta) {
		this.userInsta = userInsta;
	}
	public String getIdInsta() {
		return idInsta;
	}
	public void setIdInsta(String idInsta) {
		this.idInsta = idInsta;
	}
	public String getTmUser() {
		return tmUser;
	}
	public void setTmUser(String tmUser) {
		this.tmUser = tmUser;
	}
	public String getUserEspecial() {
		return userEspecial;
	}
	public void setUserEspecial(String userEspecial) {
		this.userEspecial = userEspecial;
	}
	public String getUserVar1() {
		return userVar1;
	}
	public void setUserVar1(String userVar1) {
		this.userVar1 = userVar1;
	}
	public String getUserVar2() {
		return userVar2;
	}
	public void setUserVar2(String userVar2) {
		this.userVar2 = userVar2;
	}
	public String getUserVar3() {
		return userVar3;
	}
	public void setUserVar3(String userVar3) {
		this.userVar3 = userVar3;
	}
	public String getUserVar4() {
		return userVar4;
	}
	public void setUserVar4(String userVar4) {
		this.userVar4 = userVar4;
	}

	public String getUrlAvatar() {
		return urlAvatar;
	}

	public void setUrlAvatar(String urlAvatar) {
		this.urlAvatar = urlAvatar;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrlBanner() {
		return urlBanner;
	}

	public void setUrlBanner(String urlBanner) {
		this.urlBanner = urlBanner;
	}
	
}
