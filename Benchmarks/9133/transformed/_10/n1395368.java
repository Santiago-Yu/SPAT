class n1395368 {
	private File copyFile(File currFile) throws IOException {
		String relativePath = currFile.getPath().substring(_distDir.length() + 1);
		File targetFile = new File(_installDir, relativePath);
		FileInputStream fis = null;
		if (targetFile.exists()) {
			log(targetFile.getPath() + " already exists, skipping libcopy", Project.MSG_INFO);
			return targetFile;
		} else {
			if (!targetFile.getParentFile().exists()) {
				if (!targetFile.getParentFile().mkdirs()) {
					log("Unable to create target dir tree for " + targetFile.getPath(), Project.MSG_ERR);
					throw new IOException();
				}
			}
		}
		try {
			fis = new FileInputStream(currFile);
		} catch (FileNotFoundException e) {
			log("Library from plugin manifest appears to have been deleted: " + currFile.getPath(), Project.MSG_ERR);
			throw new IOException();
		}
		FileOutputStream fos = null;
		BufferedInputStream bis = new BufferedInputStream(fis);
		try {
			fos = new FileOutputStream(targetFile);
		} catch (FileNotFoundException e) {
			log("Unable to create target file to write to: " + targetFile.getPath(), Project.MSG_ERR);
			throw new IOException();
		}
		int read = 0;
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		boolean success = true;
		byte[] buff = new byte[65536];
		while (read != -1 && success) {
			try {
				read = bis.read(buff, 0, 65536);
			} catch (IOException e) {
				log("Read error whilst reading from: " + currFile.getPath(), Project.MSG_ERR);
				success = false;
			}
			if (read != -1 && success) {
				try {
					bos.write(buff, 0, read);
				} catch (IOException e) {
					log("Write error whilst writing to: " + targetFile.getPath(), Project.MSG_ERR);
					success = false;
				}
			}
		}
		try {
			bis.close();
		} catch (IOException e) {
		}
		try {
			bos.close();
		} catch (IOException e) {
		}
		try {
			fis.close();
		} catch (IOException e) {
		}
		if (!success) {
			throw new IOException();
		}
		try {
			fos.close();
		} catch (IOException e) {
		}
		return targetFile;
	}

}