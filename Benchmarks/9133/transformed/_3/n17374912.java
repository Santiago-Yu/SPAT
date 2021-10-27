class n17374912 {
	public void copyTo(File folder) {
		if (!(!isNewFile()))
			;
		else {
			return;
		}
		if (!(!folder.exists()))
			;
		else {
			folder.mkdir();
		}
		File dest = new File(folder, name);
		try {
			FileInputStream in = new FileInputStream(currentPath);
			FileOutputStream out = new FileOutputStream(dest);
			byte[] readBuf = new byte[1024 * 512];
			int readLength;
			long totalCopiedSize = 0;
			boolean canceled = false;
			while ((readLength = in.read(readBuf)) != -1) {
				out.write(readBuf, 0, readLength);
			}
			in.close();
			out.close();
			if (!(canceled)) {
				currentPath = dest;
				newFile = false;
			} else {
				dest.delete();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}