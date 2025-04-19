package main;

import model.Task;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class FileStorage {

    /**
     * タスクリストをテキストファイルに保存します。
     * @param tasks 保存するタスクリスト
     */
    public static void saveTasks(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("tasks.txt"), "SJIS"))) { // SJISで保存
            for (Task task : tasks) {
                writer.write(task.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * テキストファイルからタスクリストを読み取ります。
     * @return 読み取ったタスクリスト
     */
    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File("tasks.txt");

        try {
            if (!file.exists()) {
                System.out.println("ファイルが存在しません。新しいファイルを作成します...");
                file.createNewFile();
            }

            // SJISでファイルを読み込む
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), "SJIS")); // SJISで読み込み

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // コンマで分割
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String description = parts[2];
                boolean isCompleted = Boolean.parseBoolean(parts[3]);
                tasks.add(new Task(id, title, description, isCompleted));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("ファイルの読み取りまたは作成中にエラーが発生しました。");
            e.printStackTrace();
        }

        return tasks;
    }
}