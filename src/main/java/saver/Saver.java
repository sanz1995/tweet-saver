package saver;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import saver.model.Tweet;
import saver.model.TweetRepository;


/**
 * Created by jorge on 29/03/18.
 *
 *
 */


@Component
public class Saver {

    @Autowired
    TweetRepository tr;


    public void receiveMessage(String message) {


        JSONObject tweet = new JSONObject(message);

        tr.save(new Tweet(tweet.getString("id"),tweet.getString("text"),tweet.getString("user")));



    }
}
