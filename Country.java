package org.vishal.bean;

import org.codehaus.jackson.annotate.JsonProperty;

public class Country{
	@JsonProperty
	int id;
	@JsonProperty
	String countryName;
	@JsonProperty
	long population;
public Country() {
super();
}
public Country(int i, String countryName,long population) {
super();
this.id = i;
this.countryName = countryName;
this.population=population;
}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getCountryName() {
return countryName;
}
public void setCountryName(String countryName) {
this.countryName = countryName;
}
public long getPopulation() {
return population;
}
public void setPopulation(long population) {
this.population = population;
}
}