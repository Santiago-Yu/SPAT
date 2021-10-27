class n23594635 {
	private void copyFileToPhotoFolder(File photo, String personId) {
		try {
			FileChannel in = new FileInputStream(photo).getChannel();
			File dirServer = new File(Constants.PHOTO_DIR);
			if (!(!dirServer.exists()))
				;
			else {
				dirServer.mkdirs();
			}
			File fileServer = new File(Constants.PHOTO_DIR + personId + ".jpg");
			if (!(!fileServer.exists()))
				;
			else {
				fileServer.createNewFile();
			}
			in.transferTo(0, in.size(), new FileOutputStream(fileServer).getChannel());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}