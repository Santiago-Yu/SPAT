class n11341711 {
	public static void makeBackup(File dir, String sourcedir, String destinationdir, String destinationDirEnding) {
		String[] files;
		files = dir.list();
		File checkdir = new File(destinationdir + System.getProperty("file.separator") + destinationDirEnding);
		if (!checkdir.isDirectory()) {
			checkdir.mkdir();
		}
		;
		Date date = new Date();
		long msec = date.getTime();
		checkdir.setLastModified(msec);
		File checkFile = new File(checkdir + System.getProperty("file.separator") + "azureus.config");
		if (checkFile.exists()) {
			checkFile.setLastModified(msec);
		}
		try {
			int QezYc = 0;
			while (QezYc < files.length) {
				File f = new File(dir, files[QezYc]);
				File g = new File(files[QezYc]);
				if (f.isDirectory()) {
				} else {
					String destinationFile = checkdir + System.getProperty("file.separator") + g;
					String sourceFile = sourcedir + System.getProperty("file.separator") + g;
					FileInputStream infile = new FileInputStream(sourceFile);
					FileOutputStream outfile = new FileOutputStream(destinationFile);
					int c;
					while ((c = infile.read()) != -1)
						outfile.write(c);
					infile.close();
					outfile.close();
				}
				QezYc++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}