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

import com.models.Host;
import com.models.Template;

@Repository("templateRepository")
public class TemplateRepositoryImpl implements TemplateRepository  {

	@Autowired
	@Qualifier("mongoTemplate")
	private MongoTemplate mongoTemplate;

	@Override
	public <S extends Template> List<S> save(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Template> findAll() {
		// TODO Auto-generated method stub
		
		try{
			Query query = new Query();
			query.with(new Sort(Sort.Direction.DESC, "_id"));
			List<Template> templates=  mongoTemplate.find(query, Template.class);
			
			return templates;
		}catch(Exception ee){}
		
		return null;
	}

	@Override
	public List<Template> findAll(Sort sort) {
		// TODO Auto-generated method stub
		try{
			Query query = new Query();
			//query.with(new Sort(Sort.Direction.DESC, "_id"));
			query.with(sort);
	
			List<Template> templates=  mongoTemplate.find(query, Template.class);
			
			return templates;
		}catch(Exception ee){}
		
		return null;
	}

	@Override
	public <S extends Template> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Template> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Template> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Template> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Template> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		try{	
			return mongoTemplate.count(new Query(), Template.class);
		}catch(Exception ee){}
		
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Template arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Template> arg0) {
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
	public Iterable<Template> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Template findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Template> S save(S arg0) {
		
		try{
			mongoTemplate.save(arg0);
		}catch(Exception ee){
			
		}
		return arg0;
	}

	@Override
	public <S extends Template> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Template> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Template> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Template> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Template getTemplateByName(String templateName) {
		// TODO Auto-generated method stub
		
		Query query = new Query();
		   query.addCriteria(Criteria.where("templateName").is(templateName));
		try{	
			return mongoTemplate.findOne(query, Template.class);
		}catch(Exception ee){}
		
		return null;
	}
}
