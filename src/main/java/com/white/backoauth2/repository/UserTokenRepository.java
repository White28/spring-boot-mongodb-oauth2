package com.white.backoauth2.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.white.backoauth2.model.UserToken;

@Repository
public interface UserTokenRepository extends MongoRepository<UserToken, ObjectId> {

	public UserToken findByToken(String token);
}
