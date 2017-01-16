package mongo.cmsrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.models.Host;

public interface HostRepository extends MongoRepository<Host, Long> {

	public Host getHostByName(String hostName);
}
