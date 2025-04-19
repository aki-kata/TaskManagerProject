package model;

/**
 * Taskクラスは個々のタスクを表します。
 * タスクにはタイトル、説明、完了状態が含まれます。
 */
public class Task {
	private int id; //タスクのID
    private String title;  // タスクのタイトル
    private String description;  // タスクの説明
    private boolean isCompleted;  // タスクの完了状態

    /**
     * Taskオブジェクトを初期化します。
     * @param title タスクのタイトル
     * @param description タスクの説明
     */
    public Task(int id, String title, String description, boolean isCompleted) {
    	this.id = id;
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted; // 初期状態では未完了
    }
    /**
     * Taskオブジェクトのidを返します。
     */
    public int getId() {
    	return this.id;
    }
    /**
     * TaskオブジェクトのisCompletedを反転します。
     */
    public void updateTask() {
    	this.isCompleted = !this.isCompleted;
    }

    /**
     * タスクを完了状態に変更します。
     */
    public void completeTask() {
        this.isCompleted = true;
    }

    /**
     * Taskオブジェクトの状態を文字列形式で返します。
     * @return タイトル、説明、完了状態の文字列
     */
    @Override
    public String toString() {
        return id + "," + title + "," + description + "," + isCompleted;
    }
}