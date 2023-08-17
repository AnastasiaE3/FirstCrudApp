package repository;

import model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonModel, Long> {

}
