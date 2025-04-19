package main;

import model.Task;
import java.util.ArrayList;

/**
 * TaskManagerクラスは複数のタスクを管理する機能を提供します。
 * タスクの追加、一覧表示、取得などを行います。
 */
public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();  // タスクを格納するリスト

    /**
     * タスクリストを設定します。
     * 主に外部から読み込んだタスクデータを管理クラスに追加するために使用します。
     * @param tasks 新しく設定するタスクリスト
     */
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
    
    /**
     * 新しいタスクをリストに追加します。
     * @param title タスクのタイトル
     * @param description タスクの説明
     */
    public void addTask(int id, String title, String description) {
        tasks.add(new Task(id, title, description,false));
    }
    /**
     * タスクの状態を更新します。
     * @param id タスクのID
     */
    public void updateTask(int id) {
        Task targetTask = this.tasks.get(id-1);
        targetTask.updateTask();
    }
    
    /**
     * 最後のタスクIDの値を取得します。
     */
    public int getLastTaskid() {
    	int lastTaskId = 0;
    	
    	if(tasks.size() != 0) {
    		lastTaskId = this.tasks.get(tasks.size()-1).getId();
    	}
        return lastTaskId;
    }
    
    /**
     * 現在のタスクリストをコンソールに表示します。
     */
    public void showTasks() {
        for (Task task : tasks) {
            System.out.println(task); // 各タスクの内容を表示
        }
    }

    /**
     * タスクリストを取得します。
     * @return タスクリストのArrayList
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}