package org.vishal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.vishal.bean.Country;


public class CountryService {
	
	static HashMap<Integer, Country> countryIdmap= getCountry();
	
	private static HashMap<Integer, Country> getCountry(){
		return countryIdmap;
	}
	
	public CountryService(){
		super();
		
		if(countryIdmap==null){
			countryIdmap=new HashMap<Integer, Country>(); 
			
			countryIdmap.put(1,new Country(01, "India", 2018));
			countryIdmap.put(2,new Country(02, "America", 12345));
			countryIdmap.put(3,new Country(03, "Australia", 76421));
			countryIdmap.put(4,new Country(04, "London", 98765));
			countryIdmap.put(5,new Country(05, "Japan", 5678));
			
		}
	}
	
	public List<Country> getAllCountries(){
		
		List<Country> countries=new ArrayList<Country>(countryIdmap.values());
		return countries;
	}
	public Country getCountry(int id){
		Country country=countryIdmap.get(id);
		return country;
	}
	public Country addCountry(Country country){
		country.setId(countryIdmap.size()+1);
		countryIdmap.put(country.getId(), country);
		return country;
	}
	public Country updateCountry(Country country){
		if(country.getId()<0) 
			return null;
		else{
			countryIdmap.put(country.getId(), country);
			return country;
		}
	}
	public void deleteCountry(int id){
		countryIdmap.remove(id);
	}
	
}