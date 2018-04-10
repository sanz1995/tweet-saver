package saver;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


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
