class n10118785 {
	@Override
	public void download(String remoteFilePath, String localFilePath) {
		InputStream remoteStream = null;
		OutputStream localStream = null;
		try {
			remoteStream = client.get(remoteFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			localStream = new FileOutputStream(new File(localFilePath));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			IOUtils.copy(remoteStream, localStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}