package com.shortjam.topsongs;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.shortjam.ShortJamApplication;


@Component
public class TopSongsMaintainer {
	static Logger log = Logger.getLogger(ShortJamApplication.class.getName());

	
	
	@Scheduled(fixedRate=5000)
	public void update(){
		
		
		System.out.println("Whats up?");
		
		String url = "https://itunes.apple.com/us/rss/topsongs/limit=100/explicit=true/xml";
		try {
			URLConnection connection = new URL(url).openConnection();
			InputStream response = connection.getInputStream();
			
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			
			SongListParser parser = new SongListParser();
			
			saxParser.parse(response, parser);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		log.debug("This is a test");
	}
	
}
