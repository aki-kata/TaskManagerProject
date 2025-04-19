package main;

import model.Task;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * FileStorageクラスはタスクデータをテキストファイルに保存する機能を提供します。
 */
public class FileStorage {

    /**
     * タスクリストをテキストファイルに保存します。
     * @param tasks 保存するタスクリスト
     */
    public static void saveTasks(List<Task> tasks) {
        try (FileWriter writer = new FileWriter("tasks.txt")) {
            // 各タスクをファイルに書き込む
            for (Task task : tasks) {
                writer.write(task.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace(); // エラーが発生した場合に詳細を出力
        }
    }
    /**
     * テキストファイルからタスクリストを読み取ります。
     * @return 読み取ったタスクリスト
     */
    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("tasks.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // コンマで分割
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String description = parts[2];
                boolean isCompleted = Boolean.parseBoolean(parts[3]);
                tasks.add(new Task(id,title, description, isCompleted));
            }
        } catch (IOException e) {
            System.out.println("ファイル読み取り中にエラーが発生しました。");
            e.printStackTrace();
        }
        return tasks;
    }
}