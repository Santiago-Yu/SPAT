class n6771711 {
	@SuppressWarnings("deprecation")
	public static final ReturnCode runCommand(IOBundle io, String[] args) {
		if ((args.length < 3) || (args.length > 4))
			return ReturnCode.makeReturnCode(ReturnCode.RET_INVALID_NUM_ARGS,
					"Invalid number of arguments: " + args.length);
		if ((args.length == 3) && (!"show".equals(args[1])))
			return ReturnCode.makeReturnCode(ReturnCode.RET_INVALID_NUM_ARGS,
					"Invalid number of arguments: " + args.length);
		if ((args.length == 4)
				&& (!("training".equals(args[2]) || "log".equals(args[2]) || "configuration".equals(args[2]))))
			return ReturnCode.makeReturnCode(ReturnCode.RET_BAD_REQUEST, "Access denied to directory: " + args[2]);
		if ("open".equals(args[1])) {
			final String fileName = args[2] + "/" + args[3];
			final File file = new File(fileName);
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			DataInputStream dis = null;
			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				dis = new DataInputStream(bis);
				io.println(fileName);
				io.println(file.length() + " bytes");
				while (dis.available() != 0) {
					io.println(dis.readLine());
				}
				fis.close();
				bis.close();
				dis.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return ReturnCode.makeReturnCode(ReturnCode.RET_NOT_FOUND, "File " + fileName + " doesn't exist");
			} catch (IOException e) {
				e.printStackTrace();
				return ReturnCode.makeReturnCode(ReturnCode.RET_IO_ERROR, "Error reading File " + fileName);
			}
		} else if ("save".equals(args[1])) {
			final String fileName = args[2] + "/" + args[3];
			String line;
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
				line = io.readLine();
				int count = Integer.parseInt(line.trim());
				while (count > 0) {
					out.write(io.read());
					count = count - 1;
				}
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				return ReturnCode.makeReturnCode(ReturnCode.RET_IO_ERROR, "Error writing File " + fileName);
			}
		} else if ("delete".equals(args[1])) {
			final String fileName = args[2] + "/" + args[3];
			final File file = new File(fileName);
			if (!file.exists())
				return ReturnCode.makeReturnCode(ReturnCode.RET_IO_ERROR, "No such file or directory: " + fileName);
			if (!file.canWrite())
				return ReturnCode.makeReturnCode(ReturnCode.RET_IO_ERROR, "File is write-protected: " + fileName);
			if (file.isDirectory()) {
				String[] files = file.list();
				if (files.length > 0)
					return ReturnCode.makeReturnCode(ReturnCode.RET_IO_ERROR, "Directory is not empty: " + fileName);
			}
			if (!file.delete())
				return ReturnCode.makeReturnCode(ReturnCode.RET_IO_ERROR, "Deletion failed: " + fileName);
		} else if ("show".equals(args[1])) {
			File directory = new File(args[2]);
			String[] files;
			if ((!directory.isDirectory()) || (!directory.exists())) {
				return ReturnCode.makeReturnCode(ReturnCode.RET_IO_ERROR, "No such directory: " + directory);
			}
			int count = 0;
			files = directory.list();
			io.println("Files in directory \"" + directory + "\":");
			for (int i = 0; i < files.length; i++) {
				directory = new File(files[i]);
				if (!directory.isDirectory()) {
					count++;
					io.println(" " + files[i]);
				}
			}
			io.println("Total " + count + " files");
		} else
			return ReturnCode.makeReturnCode(ReturnCode.RET_BAD_REQUEST, "Unrecognized command");
		return ReturnCode.makeReturnCode(ReturnCode.RET_OK);
	}

}