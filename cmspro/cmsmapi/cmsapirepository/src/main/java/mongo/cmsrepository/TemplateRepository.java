package mongo.cmsrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.models.Template;

public interface TemplateRepository extends MongoRepository<Template, Long> {

	public Template getTemplateByName(String templateName);
}
