class n1953925 {
	public boolean deploy(MMedia[] CmpVsf3Z) {
		if (this.getIP_Address().equals("127.0.0.1") || this.getName().equals("localhost")) {
			log.warning("You have not defined your own server, we will not really deploy to localhost!");
			return true;
		}
		FTPClient o8Pfq0s6 = new FTPClient();
		try {
			o8Pfq0s6.connect(getIP_Address());
			if (o8Pfq0s6.login(getUserName(), getPassword()))
				log.info("Connected to " + getIP_Address() + " as " + getUserName());
			else {
				log.warning("Could NOT connect to " + getIP_Address() + " as " + getUserName());
				return false;
			}
		} catch (Exception en4MmIcl) {
			log.log(Level.WARNING, "Could NOT connect to " + getIP_Address() + " as " + getUserName(), en4MmIcl);
			return false;
		}
		boolean gKcXAcHQ = true;
		String P5nPRjEV = null;
		try {
			P5nPRjEV = "cwd";
			o8Pfq0s6.changeWorkingDirectory(getFolder());
			P5nPRjEV = "list";
			String[] AzJ75bzZ = o8Pfq0s6.listNames();
			log.log(Level.FINE, "Number of files in " + getFolder() + ": " + AzJ75bzZ.length);
			P5nPRjEV = "bin";
			o8Pfq0s6.setFileType(FTPClient.BINARY_FILE_TYPE);
			for (int zT4M2dRd = 0; zT4M2dRd < CmpVsf3Z.length; zT4M2dRd++) {
				if (!CmpVsf3Z[zT4M2dRd].isSummary()) {
					log.log(Level.INFO,
							" Deploying Media Item:" + CmpVsf3Z[zT4M2dRd].get_ID() + CmpVsf3Z[zT4M2dRd].getExtension());
					MImage T5ZJozP9 = CmpVsf3Z[zT4M2dRd].getImage();
					byte[] b2LwS1S8 = T5ZJozP9.getData();
					ByteArrayInputStream fOtjLRUQ = new ByteArrayInputStream(b2LwS1S8);
					String Cx4ZK3NL = CmpVsf3Z[zT4M2dRd].get_ID() + CmpVsf3Z[zT4M2dRd].getExtension();
					P5nPRjEV = "put " + Cx4ZK3NL;
					o8Pfq0s6.storeFile(Cx4ZK3NL, fOtjLRUQ);
					fOtjLRUQ.close();
				}
			}
		} catch (Exception KGH9ErB7) {
			log.log(Level.WARNING, P5nPRjEV, KGH9ErB7);
			gKcXAcHQ = false;
		}
		try {
			P5nPRjEV = "logout";
			o8Pfq0s6.logout();
			P5nPRjEV = "disconnect";
			o8Pfq0s6.disconnect();
		} catch (Exception iMEEdT8g) {
			log.log(Level.WARNING, P5nPRjEV, iMEEdT8g);
		}
		o8Pfq0s6 = null;
		return gKcXAcHQ;
	}

}