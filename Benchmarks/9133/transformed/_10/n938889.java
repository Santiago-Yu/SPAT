class n938889 {
	public void copyFile(String oldPathFile, String newPathFile) {
		try {
			int byteread = 0;
			int bytesum = 0;
			File oldfile = new File(oldPathFile);
			if (oldfile.exists()) {
				FileOutputStream fs = new FileOutputStream(newPathFile);
				InputStream inStream = new FileInputStream(oldPathFile);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			message = ("??????????????????");
		}
	}

}