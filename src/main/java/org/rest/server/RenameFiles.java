package org.rest.server;

import java.io.File;
import java.io.IOException;

public class RenameFiles {

	private static void renameFromChildrenFolders(String folder_path) {
		try {
			// Path of folder where files are located

			// creating new folder
			File myfolder = new File(folder_path);

			File[] folders = myfolder.listFiles();
			int nameIndex = 1;
			for (File folder : folders) {

				if (folder.isDirectory()) {
					File myfile = new File(
							folder_path + "\\" + folder.getName() + "\\" + folder.listFiles()[0].getName());

					String long_file_name = myfile.getName();

					String new_file_name = Integer.toString(nameIndex++);
					System.out.println(long_file_name +", New Name - "+new_file_name);

					// file name format: "Snapshot 11 (12-05-2017 11-57).png"
					// To Shorten it to "11.png", get the substring which
					// starts after the first space character in the long
					// _file_name.
					myfile.renameTo(new File(folder_path + "\\" + new_file_name + ".mp4"));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	private static void renameWithinFolder(String folder_path) {
		try {
			// Path of folder where files are located

			// creating new folder
			File myfolder = new File(folder_path);

			File[] folders = myfolder.listFiles();
			int nameIndex = 1;
			for (File file : folders) {

				if (file.isFile()) {
					File myfile = new File(
							folder_path + "\\" + file.getName());

					String long_file_name = myfile.getName();

					String new_file_name = Integer.toString(nameIndex++);
					System.out.println(long_file_name +", New Name - "+new_file_name);

					// file name format: "Snapshot 11 (12-05-2017 11-57).png"
					// To Shorten it to "11.png", get the substring which
					// starts after the first space character in the long
					// _file_name.
					myfile.renameTo(new File(folder_path + "\\" + new_file_name + ".mp4"));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void main(String[] argv) throws IOException {

		String folder_path = "D:\\MyData\\Technical Videos\\Udemy\\Python Complete course";
		renameFromChildrenFolders(folder_path);
		
	}
}