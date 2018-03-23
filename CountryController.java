package org.vishal.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vishal.bean.Country;
import org.vishal.service.CountryService;

@Path("/countries")
public class CountryController {
	
	CountryService countryservice= new CountryService();
	
		@GET
		@Produces(MediaType.APPLICATION_JSON)
	public List<Country> getCountries(){
		List<Country> listOfCountries= countryservice.getAllCountries();
		
		return listOfCountries;
		}
		
		 @GET
		 @Path("/{id}")
		 @Produces(MediaType.APPLICATION_JSON)
	public Country getCountryById(@PathParam("id") int id){
			 return countryservice.getCountry(id);
		 }	 
		 @POST
		 @Produces(MediaType.APPLICATION_JSON)
	public Country addCountry(Country country){
			 return countryservice.addCountry(country);
		 }
		 
		 @PUT
		 @Produces(MediaType.APPLICATION_JSON)
	public Country updateCountry(Country country){
			 return countryservice.updateCountry(country);
		 }
		 
		 
		 @DELETE
		 @Path("/{id}")
		 @Produces(MediaType.APPLICATION_JSON)
	public void deleteCountry(@PathParam("id") int id){
			 countryservice.deleteCountry(id);
		 }
		/* @DELETE
		 @Produces(MediaType.APPLICATION_JSON)
	public Country deleteCountry(Country country){
			 return countryservice.deleteCountry(country);
		 }	*/ 
}
