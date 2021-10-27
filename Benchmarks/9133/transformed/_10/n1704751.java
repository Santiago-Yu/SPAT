class n1704751 {
	public static void copy(File fromFile, File toFile) throws IOException {
		String fromFilename = fromFile.getPath();
		String toFileName = toFile.getPath();
		if (!fromFile.exists())
			throw new IOException("FileCopy: " + "no such source file: " + fromFilename);
		if (!fromFile.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + fromFilename);
		if (!fromFile.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + fromFilename);
		if (toFile.isDirectory())
			toFile = new File(toFile, fromFile.getName());
		FileInputStream from = null;
		if (toFile.exists()) {
			if (!toFile.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + toFileName);
			if (AppState.isVerbose())
				System.out.print("Overwrite existing file " + toFile.getName() + "? (Y/N): ");
			System.out.flush();
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String response = in.readLine();
			if (!response.equals("Y") && !response.equals("y"))
				throw new IOException("FileCopy: " + "existing file was not overwritten.");
		} else {
			String parent = toFile.getParent();
			if (parent == null)
				parent = System.getProperty("user.dir");
			File dir = new File(parent);
			if (!dir.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + parent);
			if (dir.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + parent);
			if (!dir.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + parent);
		}
		FileOutputStream to = null;
		try {
			to = new FileOutputStream(toFile);
			from = new FileInputStream(fromFile);
			int bytesRead;
			byte[] buffer = new byte[4096];
			while ((bytesRead = from.read(buffer)) != -1)
				to.write(buffer, 0, bytesRead);
		} finally {
			if (from != null)
				try {
					from.close();
				} catch (IOException e) {
					;
				}
			if (to != null)
				try {
					to.close();
				} catch (IOException e) {
					;
				}
		}
	}

}