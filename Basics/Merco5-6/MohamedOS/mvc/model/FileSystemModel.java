package mvc.model;

import java.io.File;
import java.io.IOException;

public class FileSystemModel {

    private File currentDirectory;

    public FileSystemModel() {

        currentDirectory =
                new File(System.getProperty("user.dir"));
    }

    public String pwd() {

        return currentDirectory.getAbsolutePath();
    }

    public String ls() {

        File[] files = currentDirectory.listFiles();

        if (files == null || files.length == 0) {

            return "Directory is empty.";
        }

        StringBuilder builder =
                new StringBuilder();

        for (File file : files) {

            if (file.isDirectory()) {

                builder.append("[DIR] ");

            } else {

                builder.append("[FILE] ");
            }

            builder.append(file.getName())
                    .append("\n");
        }

        return builder.toString();
    }

    public String mkdir(String folderName) {

        File folder =
                new File(currentDirectory, folderName);

        if (folder.exists()) {

            return "Folder already exists.";
        }

        boolean created = folder.mkdir();

        if (created) {

            return "Folder created successfully.";

        } else {

            return "Failed to create folder.";
        }
    }

    public String touch(String fileName) {

        File file =
                new File(currentDirectory, fileName);

        try {

            boolean created =
                    file.createNewFile();

            if (created) {

                return "File created successfully.";

            } else {

                return "File already exists.";
            }

        } catch (IOException e) {

            return "Error creating file.";
        }
    }

    public String rm(String name) {

        File target =
                new File(currentDirectory, name);

        if (!target.exists()) {

            return "File or folder does not exist.";
        }

        boolean deleted = target.delete();

        if (deleted) {

            return "Deleted successfully.";

        } else {

            return "Cannot delete non-empty folder.";
        }
    }

    public String cd(String path) {

        File newDir;

        if (path.equals("..")) {

            newDir = currentDirectory.getParentFile();

            if (newDir == null) {

                return "Already at root directory.";
            }

        } else {

            newDir =
                    new File(currentDirectory, path);
        }

        if (newDir.exists() &&
                newDir.isDirectory()) {

            currentDirectory = newDir;

            return "Changed directory to: "
                    + currentDirectory.getAbsolutePath();
        }

        return "Directory not found.";
    }
}