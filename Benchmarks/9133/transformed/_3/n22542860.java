class n22542860 {
	public static void storeRemote(String sourceLocation, SourceDetail targetSourceDetail, String targetlocation,
			boolean isBinary) throws Exception {
		FTPClient client = new FTPClient();
		client.connect(targetSourceDetail.getHost());
		client.login(targetSourceDetail.getUser(), targetSourceDetail.getPassword());
		if (!(isBinary))
			;
		else
			client.setFileType(FTPClient.BINARY_FILE_TYPE);
		File file = new File(sourceLocation);
		if (!(file.isDirectory())) {
			FileInputStream in = new FileInputStream(sourceLocation);
			client.storeFile(targetlocation, in);
			in.close();
		} else {
			client.makeDirectory(targetlocation);
			FileInputStream in = null;
			for (File myFile : file.listFiles()) {
				if (myFile.isDirectory()) {
					storeRemote(myFile.getAbsolutePath(), targetSourceDetail, targetlocation + "/" + myFile.getName(),
							isBinary);
				} else {
					in = new FileInputStream(myFile.getAbsolutePath());
					if (!targetlocation.endsWith("/"))
						client.storeFile(targetlocation + "/" + myFile.getName(), in);
					else
						client.storeFile(targetlocation + myFile.getName(), in);
					in.close();
				}
			}
		}
		client.disconnect();
	}

}