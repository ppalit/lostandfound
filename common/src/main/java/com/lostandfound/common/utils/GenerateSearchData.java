package com.lostandfound.common.utils;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;

import com.github.javafaker.Faker;
import com.lostandfound.common.bean.LocationBean;
import com.lostandfound.common.bean.RegisterItemBean;
import com.lostandfound.common.bean.ReporterBean;

class GenerateSearchData{
	public static void main(String[] args) {
		System.out.println(getRegisterData());
		/*DataFactory df = new DataFactory();
		for (int i = 0; i < 100; i++) {
			String name = df.getFirstName() + " "+ df.getLastName();
			System.out.println(name);
		}*/
	}
	
	private static RegisterItemBean getRegisterData(){
		
		Faker faker = new Faker();
		DataFactory df = new DataFactory();
		
		RegisterItemBean item = new RegisterItemBean();
		
		ReporterBean reporter = new ReporterBean();
			reporter.setEmailId(faker.internet().emailAddress());
			reporter.setFirstName(faker.name().firstName());
			reporter.setLastName(faker.name().lastName());
			reporter.setPhoneNo(faker.phoneNumber().phoneNumber());
			reporter.setUserId(""+System.currentTimeMillis());
		item.setReporter(reporter);
		
		LocationBean location = new LocationBean();
			location.setCity(df.getCity());
			location.setCountry(faker.address().country());
			location.setLat(faker.address().latitude());
			location.setLng(faker.address().longitude());
			String[] locType= {"APPROXIMATE","ROOF_TOP"};
			location.setLocType(faker.options().option(locType));
			location.setManualAddress(faker.address().streetAddress(false));
			location.setState(faker.address().stateAbbr());
		item.setLocation(location);
		
		
		Date minDate = df.getDate(2000, 1, 1);
		Date maxDate = new Date();
		
		item.setFoundDate(df.getDateBetween(minDate, maxDate).toString());
		
		List<String> colours = new ArrayList<String>();
		colours.add("aqua");
		colours.add("black");
		colours.add("blue");
		colours.add("fuchsia");
		colours.add("gray");
		colours.add("green");
		colours.add("lime");
		colours.add("maroon");
		colours.add("navy");
		colours.add("olive");
		colours.add("orange");
		colours.add("purple");
		colours.add("red");
		colours.add("silver");
		colours.add("teal");
		colours.add("white");
		colours.add("yellow");
		
		item.setItemColor(df.getItem(colours));
		
		List<String> items = new ArrayList<String>();
		items.add("Animals / Pets");
		items.add("Bags, Baggage, Luggage");
		items.add("Clothing");
		items.add("Collectors Items");
		items.add("Currency / Money");
		items.add("Electronics");
		items.add("Household/Tools");
		items.add("Jewelry");
		items.add("Literature");
		items.add("Mail/Parcel");
		items.add("Media");
		items.add("Medical");
		items.add("Musical Equipment");
		items.add("Personal Accessories");
		items.add("Sporting Goods");
		items.add("Tickets");
		items.add("Toys");
		items.add("Visual Art Related");
		items.add(df.getRandomText(8));
		
		item.setItemType(df.getItem(items));
		item.setPublicDescription(faker.lorem().paragraph(df.getNumberBetween(1, 6)));
		item.setSecretDescription(faker.lorem().sentence());
		
		
		return item;
	}
	
}