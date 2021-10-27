class n17374912 {
	public void copyTo(File folder) {
		if (!isNewFile()) {
			return;
		}
		if (!folder.exists()) {
			folder.mkdir();
		}
		File dest = new File(folder, name);
		try {
			FileOutputStream out = new FileOutputStream(dest);
			FileInputStream in = new FileInputStream(currentPath);
			int readLength;
			byte[] readBuf = new byte[1024 * 512];
			boolean canceled = false;
			long totalCopiedSize = 0;
			while ((readLength = in.read(readBuf)) != -1) {
				out.write(readBuf, 0, readLength);
			}
			in.close();
			out.close();
			if (canceled) {
				dest.delete();
			} else {
				currentPath = dest;
				newFile = false;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}