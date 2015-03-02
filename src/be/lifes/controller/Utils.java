package be.lifes.controller;

import java.util.ArrayList;

import be.life.model.Profile;

public class Utils {
	ArrayList<String> variables;

	public ArrayList<String> generateVariablesProtected(Profile profile){
		ArrayList<String> names = new ArrayList<String>();
		
		if(profile.getUserFace()!= null && !profile.getUserFace().equals("")){
			names.add(profile.getUserFace());
		} 
		if(profile.getUserInsta()!= null && !profile.getUserInsta().equals("")){
			names.add(profile.getUserInsta());
		} 
		if (profile.getTmUser()!= null && !profile.getTmUser().equals("")){
			names.add(profile.getTmUser());
		} 
		if(profile.getUserEspecial()!= null && !profile.getUserEspecial().equals("")){
			names.add(profile.getUserEspecial());
		} 
		if(profile.getUserVar1()!= null && !profile.getUserVar1().equals("")){
			names.add(profile.getUserVar1());
		} 
		if(profile.getUserVar2()!= null && !profile.getUserVar2().equals("")){
			names.add(profile.getUserVar2());
		} 
		if(profile.getUserVar3()!= null && !profile.getUserVar3().equals("")){
			names.add(profile.getUserVar3());
		}
		if(profile.getUserVar4()!= null && !profile.getUserVar4().equals("")){
			names.add(profile.getUserVar4());
		}
		
		return names;
	}
	
	
	public ArrayList<String> generateVariablesUnauthorized(Profile profile){
		addVariables();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> namesBlocked = new ArrayList<String>();
		
		if(profile.getUserFace()!= null && !profile.getUserFace().equals("")){
			names.add(profile.getUserFace());
		} 
		if(profile.getUserInsta()!= null && !profile.getUserInsta().equals("")){
			names.add(profile.getUserInsta());
		} 
		if (profile.getTmUser()!= null && !profile.getTmUser().equals("")){
			names.add(profile.getTmUser());
		} 
		if(profile.getUserEspecial()!= null && !profile.getUserEspecial().equals("")){
			names.add(profile.getUserEspecial());
		} 
		if(profile.getUserVar1()!= null && !profile.getUserVar1().equals("")){
			names.add(profile.getUserVar1());
		} 
		if(profile.getUserVar2()!= null && !profile.getUserVar2().equals("")){
			names.add(profile.getUserVar2());
		} 
		if(profile.getUserVar3()!= null && !profile.getUserVar3().equals("")){
			names.add(profile.getUserVar3());
		}
		if(profile.getUserVar4()!= null && !profile.getUserVar4().equals("")){
			names.add(profile.getUserVar4());
		}
		String newStr;
		for(String name : names){
			for(String variable: variables){
				newStr = name+variable;
				namesBlocked.add(newStr);
				newStr = variable+name;
				namesBlocked.add(newStr);
			}
		}
		
		System.out.println(namesBlocked.size() + " variaveis bloqueadas.");
		return namesBlocked;
	}
	
	private void addVariables(){
		variables = new ArrayList<String>();
		variables.add("OFFICIAL");
		variables.add("OFICIAL");
		variables.add("THE");
		variables.add("THEREAL");
		variables.add("REAL");
		variables.add("IAM");
		variables.add("EUSOU");
		variables.add("I");
		variables.add("EU");
		variables.add(".");
		variables.add("_");
		variables.add("online");
		variables.add("SouthAfrica");
		variables.add("Germany");
		variables.add("Argentina");
		variables.add("Australia");
		variables.add("Austria");
		variables.add("Belgium");
		variables.add("Bolivia");
		variables.add("Brazil");
		variables.add("Canada");
		variables.add("Chile");
		variables.add("China");
		variables.add("Colombia");
		variables.add("CostaRica");
		variables.add("Denmark");
		variables.add("Egypt");
		variables.add("Ecuador");
		variables.add("Spain");
		variables.add("UnitedStates");
		variables.add("France");
		variables.add("Netherlands");
		variables.add("HongKong");
		variables.add("Hungary");
		variables.add("India");
		variables.add("Indonesia");
		variables.add("Ireland");
		variables.add("Italy");
		variables.add("Jamaica");
		variables.add("Japan");
		variables.add("Mexico");
		variables.add("NewZealand");
		variables.add("Paraguay");
		variables.add("Peru");
		variables.add("Portugal");
		variables.add("PuertoRico");
		variables.add("UnitedKingdom");
		variables.add("DominicanRepublic");
		variables.add("Russian");
		variables.add("Sweden");
		variables.add("Switzerland");
		variables.add("Thailand");
		variables.add("Turkey");
		variables.add("Uruguay");
		variables.add("Venezuela");
		variables.add("ZA");
		variables.add("DE");
		variables.add("AR");
		variables.add("AU");
		variables.add("AT");
		variables.add("BE");
		variables.add("BO");
		variables.add("BR");
		variables.add("CA");
		variables.add("CL");
		variables.add("CN");
		variables.add("CO");
		variables.add("CR");
		variables.add("DK");
		variables.add("EG");
		variables.add("EC");
		variables.add("ES");
		variables.add("US");
		variables.add("FR");
		variables.add("NL");
		variables.add("HK");
		variables.add("HU");
		variables.add("IN");
		variables.add("ID");
		variables.add("IE");
		variables.add("IT");
		variables.add("JM");
		variables.add("JP");
		variables.add("MX");
		variables.add("NZ");
		variables.add("PY");
		variables.add("PE");
		variables.add("PT");
		variables.add("PR");
		variables.add("GB");
		variables.add("DO");
		variables.add("RU");
		variables.add("SE");
		variables.add("CH");
		variables.add("TH");
		variables.add("TR");
		variables.add("UY");
		variables.add("VE");
		variables.add("ZAF");
		variables.add("DEU");
		variables.add("ARG");
		variables.add("AUS");
		variables.add("AUT");
		variables.add("BEL");
		variables.add("BOL");
		variables.add("BRA");
		variables.add("CAN");
		variables.add("CHL");
		variables.add("CHN");
		variables.add("COL");
		variables.add("CRI");
		variables.add("DNK");
		variables.add("EGY");
		variables.add("ECU");
		variables.add("ESP");
		variables.add("USA");
		variables.add("FRA");
		variables.add("NLD");
		variables.add("HKG");
		variables.add("HUN");
		variables.add("IND");
		variables.add("IDN");
		variables.add("IRL");
		variables.add("ITA");
		variables.add("JAM");
		variables.add("JPN");
		variables.add("MEX");
		variables.add("NZL");
		variables.add("PRY");
		variables.add("PER");
		variables.add("PRT");
		variables.add("PRI");
		variables.add("GBR");
		variables.add("DOM");
		variables.add("RUS");
		variables.add("SWE");
		variables.add("CHE");
		variables.add("THA");
		variables.add("TUR");
		variables.add("URY");
		variables.add("VEN");
	}
}
