class n9837783 {
	private void fileCopier(String filenameFrom, String filenameTo) {
		FileOutputStream toStream = null;
		FileInputStream fromStream = null;
		try {
			if (new File(filenameTo).exists()) {
				new File(filenameTo).delete();
			}
			fromStream = new FileInputStream(new File(filenameFrom));
			File dirr = new File(getContactPicPath());
			toStream = new FileOutputStream(new File(filenameTo));
			if (!dirr.exists()) {
				dirr.mkdir();
			}
			int bytesRead;
			byte[] buffer = new byte[4096];
			while ((bytesRead = fromStream.read(buffer)) != -1)
				toStream.write(buffer, 0, bytesRead);
		} catch (FileNotFoundException e) {
			Errmsg.errmsg(e);
		} catch (IOException e) {
			Errmsg.errmsg(e);
		} finally {
			try {
				if (fromStream != null) {
					fromStream.close();
				}
				if (toStream != null) {
					toStream.close();
				}
			} catch (IOException e) {
				Errmsg.errmsg(e);
			}
		}
	}

}