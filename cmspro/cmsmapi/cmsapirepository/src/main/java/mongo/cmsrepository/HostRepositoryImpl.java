package mongo.cmsrepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.models.Employee;
import com.models.Host;

@Repository("hostRepository")
public class HostRepositoryImpl implements HostRepository {
	
	@Autowired
	@Qualifier("mongoTemplate")
	private MongoTemplate mongoTemplate;

	@Override
	public <S extends Host> List<S> save(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Host> findAll() {
		
		try{
			Query query = new Query();
			query.with(new Sort(Sort.Direction.DESC, "_id"));
			List<Host> hosts=  mongoTemplate.find(query, Host.class);
			
			return hosts;
		}catch(Exception ee){}
		
		return null;
	}

	@Override
	public List<Host> findAll(Sort sort) {
		
		try{
			Query query = new Query();
			//query.with(new Sort(Sort.Direction.DESC, "_id"));
			query.with(sort);
	
			List<Host> hosts=  mongoTemplate.find(query, Host.class);
			
			return hosts;
		}catch(Exception ee){}
		
		return null;
	}

	@Override
	public <S extends Host> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Host> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Host> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Host> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Host> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		
		/*Query query = new Query();
		   query.addCriteria(Criteria.where("category").is(category));*/
		
		try{	
			return mongoTemplate.count(new Query(), Host.class);
		}catch(Exception ee){}
		
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Host arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Host> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Host> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Host findOne(Long arg0) {
		
		return mongoTemplate.findById(arg0, Host.class);
	}

	@Override
	public <S extends Host> S save(S arg0) {
		
		try{
			mongoTemplate.save(arg0);
		}catch(Exception ee){
			
		}
		return arg0;
	}

	@Override
	public <S extends Host> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Host> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Host> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Host> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Host getHostByName(String hostName) {
		
		Query query = new Query();
		   query.addCriteria(Criteria.where("hostName").is(hostName));
		
		try{	
			return mongoTemplate.findOne(query, Host.class);
		}catch(Exception ee){}
		
		return null;
	}

}
