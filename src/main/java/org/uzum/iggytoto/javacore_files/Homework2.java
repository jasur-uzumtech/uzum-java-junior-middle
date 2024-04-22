package org.uzum.iggytoto.javacore_files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homework2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String folderPath;
        do {
            System.out.print("Введите путь к папке: ");
            folderPath = scanner.nextLine();
        } while (!isValidFolderPath(folderPath));

        List<String> largeFiles = findLargeFiles(folderPath, 10 * 1024 * 1024); // 10 MB
        if (!largeFiles.isEmpty()) {
            System.out.println("Найдены файлы размером больше 10 МБ:");
            for (String filePath : largeFiles) {
                System.out.println(filePath);
            }
        } else {
            System.out.println("Файлы размером больше 10 МБ не найдены.");
        }
    }

    private static boolean isValidFolderPath(String folderPath) {
        File folder = new File(folderPath);
        return folder.exists() && folder.isDirectory();
    }

    private static List<String> findLargeFiles(String folderPath, long minSize) {
        List<String> result = new ArrayList<>();
        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            return result;
        }

        File[] files = folder.listFiles();
        if (files == null) {
            return result;
        }

        for (File file : files) {
            if (file.isFile() && file.length() > minSize) {
                result.add(file.getAbsolutePath());
            } else if (file.isDirectory()) {
//                если текущий элемент - это папка, функция вызывает саму себя рекурсивно для поиска
//                больших файлов в этой подпапке и добавляет результаты в список result
                result.addAll(findLargeFiles(file.getAbsolutePath(), minSize));
            }
        }
        return result;
    }
}
