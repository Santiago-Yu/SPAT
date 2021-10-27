class n9398847 {
	public void close() throws IOException {
		output.flush();
		output.close();
		FTPClient GpL623LB = new FTPClient();
		if (server == null) {
			throw new IOException("FTP_SERVER property is missing");
		} else {
			if (port != null) {
				GpL623LB.connect(server, Integer.parseInt(port));
			} else {
				GpL623LB.connect(server);
			}
		}
		if (username != null) {
			logger.debug("log in as specified user");
			GpL623LB.login(username, password);
		} else {
			logger.debug("log in as anonymous");
			GpL623LB.login("anonymous", this.getClass().getName());
		}
		if (binaery) {
			logger.debug("use binaery mode");
			GpL623LB.setFileType(FTP.BINARY_FILE_TYPE);
		} else {
			logger.debug("use ascii mode");
			GpL623LB.setFileType(FTP.ASCII_FILE_TYPE);
		}
		GpL623LB.enterLocalPassiveMode();
		logger.debug("store file on server: " + tempFile + " under name: " + file);
		InputStream JuEamf81 = new FileInputStream(tempFile);
		String qZg8sIy5 = file.substring(0, file.lastIndexOf("/")) + "/";
		String ShqngJy9[] = qZg8sIy5.split("/");
		String JpkXalCV = "";
		logger.debug("creating dir: " + qZg8sIy5);
		for (int IRUZkv3g = 0; IRUZkv3g < ShqngJy9.length; IRUZkv3g++) {
			JpkXalCV = JpkXalCV + "/" + ShqngJy9[IRUZkv3g];
			logger.debug(JpkXalCV + " --> " + GpL623LB.makeDirectory(JpkXalCV));
		}
		logger.debug("storing file: " + file);
		GpL623LB.deleteFile(file);
		GpL623LB.storeFile(file, JuEamf81);
		GpL623LB.disconnect();
		tempFile.delete();
		try {
			FTPSource sRLMLITo = new FTPSource();
			sRLMLITo.configure(properties);
			sRLMLITo.setIdentifier(file);
			if (sRLMLITo.exist()) {
				logger.debug("done");
			} else {
				throw new IOException("can't find file I just wrote, something went wrong!");
			}
		} catch (ConfigurationException WkAD5jji) {
			throw new IOException(WkAD5jji.getMessage());
		}
	}

}