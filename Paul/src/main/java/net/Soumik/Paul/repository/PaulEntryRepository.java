package net.Soumik.Paul.repository;

import net.Soumik.Paul.entity.PaulEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PaulEntryRepository extends MongoRepository<PaulEntry, ObjectId> {


}
