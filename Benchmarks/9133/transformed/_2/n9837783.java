class n9837783 {
	private void fileCopier(String filenameFrom, String filenameTo) {
		FileInputStream fromStream = null;
		FileOutputStream toStream = null;
		try {
			fromStream = new FileInputStream(new File(filenameFrom));
			if (new File(filenameTo).exists()) {
				new File(filenameTo).delete();
			}
			File dirr = new File(getContactPicPath());
			if (!dirr.exists()) {
				dirr.mkdir();
			}
			toStream = new FileOutputStream(new File(filenameTo));
			byte[] buffer = new byte[4096];
			int bytesRead;
			for (; (bytesRead = fromStream.read(buffer)) != -1;)
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