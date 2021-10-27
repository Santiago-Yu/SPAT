class n22542860 {
	public static void storeRemote(String sourceLocation, SourceDetail targetSourceDetail, String targetlocation,
			boolean isBinary) throws Exception {
		FTPClient client = new FTPClient();
		client.connect(targetSourceDetail.getHost());
		client.login(targetSourceDetail.getUser(), targetSourceDetail.getPassword());
		File file = new File(sourceLocation);
		if (isBinary)
			client.setFileType(FTPClient.BINARY_FILE_TYPE);
		if (file.isDirectory()) {
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
		} else {
			FileInputStream in = new FileInputStream(sourceLocation);
			client.storeFile(targetlocation, in);
			in.close();
		}
		client.disconnect();
	}

}