package main;

import java.util.Scanner;

/**
 * Mainクラスはアプリケーションの実行を管理します。
 * ユーザーとの対話を通じてタスク操作を行います。
 */
public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager(); // タスク管理インスタンス
        
     // 起動時にタスクリストを読み込む
        System.out.println("タスクを読み込んでいます...");
        manager.setTasks(FileStorage.loadTasks());
        System.out.println("タスクを読み込みました。");
        
        manager.showTasks(); // タスクリストを表示
        
        Scanner scanner = new Scanner(System.in); // ユーザー入力を処理するスキャナー

        while (true) {
            System.out.println("1: タスク追加, 2: 表示, 3: 保存, 4: ステータス更新, 0: 終了");
            int choice = scanner.nextInt(); // 選択を受け取る
            scanner.nextLine(); // バッファクリア

            if (choice == 1) {
                System.out.print("タイトル: ");
                String title = scanner.nextLine(); // タスクのタイトル入力
                System.out.print("説明: ");
                String description = scanner.nextLine(); // タスクの説明入力
                int id = manager.getLastTaskid()+1;
                manager.addTask(id, title, description);
            } else if (choice == 2) {
                manager.showTasks(); // タスクリストを表示
            } else if (choice == 3) {
                FileStorage.saveTasks(manager.getTasks()); // タスクを保存
                System.out.println("タスクを保存しました！");
            } else if (choice == 4) {
                System.out.println("タスクIDを選択してください。");
                System.out.print("ID: ");
                int id = Integer.parseInt(scanner.nextLine()); // タスクのIDを入力
                if(id > manager.getLastTaskid() || id < 1) {
                	System.out.println("タスクIDが存在しません。有効な値を選択してください。");
                }else {
                	manager.updateTask(id);
                	System.out.println("タスクのステータスを更新しました。");
                }                
            } else if (choice == 0) {
                break; // アプリを終了
            }
        }
        scanner.close(); // スキャナーを閉じる
    }
}