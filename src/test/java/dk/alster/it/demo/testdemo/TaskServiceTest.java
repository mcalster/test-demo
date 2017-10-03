package dk.alster.it.demo.testdemo;

import com.nitorcreations.junit.runners.NestedRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(NestedRunner.class)
public class TaskServiceTest {

    private TaskRepository repository;
    private TaskService service;

    @Before
    public void configureSUT() {
        repository = mock(TaskRepository.class);
        service = new TaskService(repository);
    }

    @Test
    public void testAtTheHighestLevel() {
        assertTrue(true);
    }
    public class FindById {

        private final Long TASK_ID = 1L;

        public class WhenTaskIsNotFound {

            @Before
            public void returnNoTask() {
                given(repository.findOne(TASK_ID))
                        .willReturn(null);
            }

            @Test
            public void testTitleFromTask() {

                assertNull("Title was not empty when no task is found.", service.getTitleFromId(TASK_ID));

            }
        }

        public class WhenTaskIsFound {

            private final String TITLE = "Foo";

            private Task found;

            @Before
            public void returnFoundTask() {
                found = new Task.TaskBuilder()
                        .title(TITLE)
                        .build();

                given(repository.findOne(TASK_ID)).willReturn(found);
            }

            @Test
            public void testTitleFromTask() {
                String res = service.getTitleFromId(TASK_ID);
                assertEquals("Title has changed when retrieving it", TITLE, res);

            }
        }
    }

}
