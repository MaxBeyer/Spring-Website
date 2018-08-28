package hello;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String getRss(Model model) {
    	ArrayList<Episode> episodes = new ArrayList<>();
    	FeedReader feedReader = new FeedReader();
    	episodes = feedReader.parseRssXmlIntoEpisodes();
        model.addAttribute("episodes", episodes);
        return "index";
    }
    
    

}