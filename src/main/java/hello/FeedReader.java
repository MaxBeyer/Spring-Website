package hello;

import java.net.URL;
import java.util.ArrayList;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
 
public class FeedReader {
	
	public ArrayList<Episode> parseRssXmlIntoEpisodes() {
		ArrayList<Episode> episodes = new ArrayList<>();
		
        try {
            String url = "http://dangerboat.net/nrpg?format=rss";
 
            try (XmlReader reader = new XmlReader(new URL(url))) {
                SyndFeed feed = new SyndFeedInput().build(reader);
                System.out.println(feed.getTitle());
                System.out.println("***********************************");
                for (SyndEntry entry : feed.getEntries()) {
                	
                	Episode episode = new Episode();
                	episode.setTitle(entry.getTitle());
                	episode.setDate(entry.getPublishedDate().toString());
                	episode.setDescription(entry.getDescription().getValue());
                	episode.setAudioUrl(entry.getEnclosures().get(0).getUrl());
                	episodes.add(episode);
                	
                    System.out.println(entry.getTitle());
                    System.out.println(entry.getPublishedDate());
                    System.out.println(entry.getDescription().getValue());
                    System.out.println(entry.getEnclosures().get(0).getUrl());
                    System.out.println("***********************************");
                }
                System.out.println("Done");
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
		return episodes;
 
    }
}
