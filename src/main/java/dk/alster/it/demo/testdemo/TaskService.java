package dk.alster.it.demo.testdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(@Autowired TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public String getTitleFromId(Long id) {

        Task task = taskRepository.findOne(id);

        return task == null ? null : task.getTitle();
    }
}
