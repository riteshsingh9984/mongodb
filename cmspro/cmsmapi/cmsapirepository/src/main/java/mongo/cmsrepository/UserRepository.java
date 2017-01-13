package mongo.cmsrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.models.User;

public interface UserRepository extends MongoRepository<User, Long> {

}
