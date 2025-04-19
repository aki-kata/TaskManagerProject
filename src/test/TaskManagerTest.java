package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import java.util.ArrayList;
//import model.Task;
import main.TaskManager;

class TaskManagerTest {
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

//    @Test
//    void testSetTasks() {
//        ArrayList<Task> taskList = new ArrayList<>();
//        taskList.add(new Task(1, "Sample Task", "Task Description", false));
//
//        taskManager.setTasks(taskList);
//        assertEquals(1, taskManager.getTasks().size());
//        assertEquals("Sample Task", taskManager.getTasks().get(0).getTitle());
//    }
//
//    @Test
//    void testAddTask() {
//        taskManager.addTask(1, "Test Task", "This is a test task.");
//        assertEquals(1, taskManager.getTasks().size());
//        assertEquals("Test Task", taskManager.getTasks().get(0).getTitle());
//    }
//
//    @Test
//    void testUpdateTask() {
//        taskManager.addTask(1, "Test Task", "This is a test task.");
//        taskManager.updateTask(1);
//        assertTrue(taskManager.getTasks().get(0).isCompleted()); // タスクの状態更新を確認
//    }

    @Test
    void testGetLastTaskid() {
        assertEquals(0, taskManager.getLastTaskid()); // タスクがない状態
        taskManager.addTask(1, "Task 1", "First Task");
        taskManager.addTask(2, "Task 2", "Second Task");
        assertEquals(2, taskManager.getLastTaskid()); // 最後のタスクIDを確認
    }

    @Test
    void testShowTasks() {
        taskManager.addTask(1, "Test Task", "This is a test task.");
        taskManager.addTask(2, "Another Task", "Another description.");

        assertDoesNotThrow(() -> taskManager.showTasks()); // 例外が発生しないことを確認
    }

    @Test
    void testGetTasks() {
        assertNotNull(taskManager.getTasks());
        assertEquals(0, taskManager.getTasks().size());

        taskManager.addTask(1, "Sample Task", "Task Description");
        assertEquals(1, taskManager.getTasks().size());
    }
}