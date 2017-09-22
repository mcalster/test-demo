package dk.alster.it.demo.testdemo.repository;

import dk.alster.it.demo.testdemo.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}