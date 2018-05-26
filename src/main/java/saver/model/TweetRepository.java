package saver.model;

import org.springframework.data.repository.CrudRepository;

public interface TweetRepository extends CrudRepository<Tweet,String> {

    public Tweet findById(String id);
}
