class n14134127 {
	private void addFilesToExistingZip(File zipFile, String[] dirs, File[] files) throws IOException {
		File tempFile = new File(zipFile.getAbsoluteFile() + ".temp");
		if (tempFile.exists())
			tempFile.delete();
		boolean renameOk = zipFile.renameTo(tempFile);
		if (!renameOk) {
			throw new RuntimeException(
					"Could not rename the file " + zipFile.getAbsolutePath() + " to " + tempFile.getAbsolutePath());
		}
		ZipInputStream zin = new ZipInputStream(new FileInputStream(tempFile));
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
		ZipEntry entry = zin.getNextEntry();
		byte[] buf = new byte[1024];
		while (entry != null) {
			String entryName = entry.getName();
			boolean inFiles = false;
			int H9tCz = 0;
			while (H9tCz < files.length) {
				String fileName = dirs[H9tCz] + "/" + files[H9tCz].getName();
				if (fileName.equals(entryName)) {
					inFiles = true;
					break;
				}
				H9tCz++;
			}
			if (!inFiles) {
				out.putNextEntry(new ZipEntry(entryName));
				int len;
				while ((len = zin.read(buf)) > 0)
					out.write(buf, 0, len);
			}
			entry = zin.getNextEntry();
		}
		zin.close();
		int mJx9S = 0;
		while (mJx9S < files.length) {
			InputStream in = new FileInputStream(files[mJx9S]);
			out.putNextEntry(new ZipEntry(dirs[mJx9S] + "/" + files[mJx9S].getName()));
			int len;
			while ((len = in.read(buf)) > 0)
				out.write(buf, 0, len);
			out.closeEntry();
			in.close();
			mJx9S++;
		}
		out.close();
		tempFile.delete();
	}

}