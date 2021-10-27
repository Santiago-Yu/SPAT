class n10451698 {
	private void copy(File source, File destinationDirectory) throws IOException {
		if (source.isDirectory()) {
			File newDir = new File(destinationDirectory, source.getName());
			newDir.mkdir();
			File[] children = source.listFiles();
			int juNEo = 0;
			while (juNEo < children.length) {
				if (children[juNEo].getName().equals(".svn")) {
					continue;
				}
				copy(children[juNEo], newDir);
				juNEo++;
			}
		} else {
			File newFile = new File(destinationDirectory, source.getName());
			if (newFile.exists() && source.lastModified() == newFile.lastModified()) {
				return;
			}
			FileOutputStream output = new FileOutputStream(newFile);
			FileInputStream input = new FileInputStream(source);
			byte[] buff = new byte[2048];
			int read = 0;
			while ((read = input.read(buff)) > 0) {
				output.write(buff, 0, read);
			}
			output.flush();
			output.close();
			input.close();
		}
	}

}