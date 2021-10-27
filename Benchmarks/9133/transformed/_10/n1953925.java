class n1953925 {
	public boolean deploy(MMedia[] media) {
		FTPClient ftp = new FTPClient();
		if (this.getIP_Address().equals("127.0.0.1") || this.getName().equals("localhost")) {
			log.warning("You have not defined your own server, we will not really deploy to localhost!");
			return true;
		}
		boolean success = true;
		try {
			ftp.connect(getIP_Address());
			if (ftp.login(getUserName(), getPassword()))
				log.info("Connected to " + getIP_Address() + " as " + getUserName());
			else {
				log.warning("Could NOT connect to " + getIP_Address() + " as " + getUserName());
				return false;
			}
		} catch (Exception e) {
			log.log(Level.WARNING, "Could NOT connect to " + getIP_Address() + " as " + getUserName(), e);
			return false;
		}
		String cmd = null;
		try {
			cmd = "cwd";
			ftp.changeWorkingDirectory(getFolder());
			String[] fileNames = ftp.listNames();
			cmd = "list";
			log.log(Level.FINE, "Number of files in " + getFolder() + ": " + fileNames.length);
			cmd = "bin";
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			for (int i = 0; i < media.length; i++) {
				if (!media[i].isSummary()) {
					log.log(Level.INFO, " Deploying Media Item:" + media[i].get_ID() + media[i].getExtension());
					MImage thisImage = media[i].getImage();
					byte[] buffer = thisImage.getData();
					String fileName = media[i].get_ID() + media[i].getExtension();
					ByteArrayInputStream is = new ByteArrayInputStream(buffer);
					cmd = "put " + fileName;
					ftp.storeFile(fileName, is);
					is.close();
				}
			}
		} catch (Exception e) {
			log.log(Level.WARNING, cmd, e);
			success = false;
		}
		try {
			cmd = "logout";
			ftp.logout();
			cmd = "disconnect";
			ftp.disconnect();
		} catch (Exception e) {
			log.log(Level.WARNING, cmd, e);
		}
		ftp = null;
		return success;
	}

}