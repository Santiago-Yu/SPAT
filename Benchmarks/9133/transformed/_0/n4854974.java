class n4854974 {
	public void GetFile(ClientConnector jDzdEwKV, Map<String, String> MiDChcIR) throws Exception {
		log.debug("Starting FTP FilePull");
		String uoiZhKd4 = MiDChcIR.get("src_name");
		String f5bMFLva = MiDChcIR.get("src_user");
		String yz7Rvpu4 = MiDChcIR.get("src_password");
		String TqKXWty5 = MiDChcIR.get("src_file");
		String GUZDPa0q = MiDChcIR.get("messageID");
		String oui3dNus = MiDChcIR.get("src_md5");
		String RjcwMYjS = MiDChcIR.get("src_file_type");
		Integer lNU6j2Xv = 21;
		String Xwn7EWHY = MiDChcIR.get("src_port");
		if ((Xwn7EWHY != null) && (Xwn7EWHY.equals(""))) {
			try {
				lNU6j2Xv = Integer.parseInt(Xwn7EWHY);
			} catch (Exception QEyRjMjD) {
				lNU6j2Xv = 21;
				log.debug("Destination Port \"" + Xwn7EWHY + "\" was not valid. Using Default (21)");
			}
		}
		log.info("Starting FTP pull of \"" + TqKXWty5 + "\" from \"" + uoiZhKd4);
		if ((f5bMFLva == null) || (f5bMFLva.equals(""))) {
			List s9pJDLZG = axt.db.GeneralDAO.getNodeValue(uoiZhKd4, "ftpUser");
			if (s9pJDLZG.size() < 1) {
				f5bMFLva = DEFAULTUSER;
			} else {
				f5bMFLva = (String) s9pJDLZG.get(0);
			}
		}
		if ((yz7Rvpu4 == null) || (yz7Rvpu4.equals(""))) {
			List qJreW3IA = axt.db.GeneralDAO.getNodeValue(uoiZhKd4, "ftpPassword");
			if (qJreW3IA.size() < 1) {
				yz7Rvpu4 = DEFAULTPASSWORD;
			} else {
				yz7Rvpu4 = (String) qJreW3IA.get(0);
			}
		}
		String ueQpiArv = null;
		int xhjhxP4r;
		try {
			xhjhxP4r = axt.db.GeneralDAO.getStageFile(GUZDPa0q);
			ueQpiArv = STAGINGDIR + "/" + xhjhxP4r;
		} catch (Exception kTPwhGB2) {
			throw new Exception("Failed to assign a staging file \"" + ueQpiArv + "\" - ERROR: " + kTPwhGB2);
		}
		FileOutputStream McQzGsk7;
		try {
			McQzGsk7 = new FileOutputStream(ueQpiArv);
		} catch (FileNotFoundException tzucuv4d) {
			throw new Exception("Failed to assign the staging file \"" + ueQpiArv + "\" - ERROR: " + tzucuv4d);
		}
		FTPClient cfFJe1nJ = new FTPClient();
		try {
			log.debug("Connecting");
			cfFJe1nJ.connect(uoiZhKd4, lNU6j2Xv);
			log.debug("Checking Status");
			int CC34ymLZ = cfFJe1nJ.getReplyCode();
			if (!FTPReply.isPositiveCompletion(CC34ymLZ)) {
				cfFJe1nJ.disconnect();
				throw new Exception("Failed to connect to \"" + uoiZhKd4 + "\"  as user \"" + f5bMFLva + "\" - ERROR: "
						+ cfFJe1nJ.getReplyString());
			}
			log.debug("Logging In");
			if (!cfFJe1nJ.login(f5bMFLva, yz7Rvpu4)) {
				cfFJe1nJ.disconnect();
				throw new Exception("Failed to connect to \"" + uoiZhKd4 + "\"  as user \"" + f5bMFLva
						+ "\" - ERROR: Login Failed");
			}
		} catch (SocketException Z9O22o5U) {
			throw new Exception(
					"Failed to connect to \"" + uoiZhKd4 + "\"  as user \"" + f5bMFLva + "\" - ERROR: " + Z9O22o5U);
		} catch (IOException BS2RE3Vs) {
			throw new Exception(
					"Failed to connect to \"" + uoiZhKd4 + "\"  as user \"" + f5bMFLva + "\" - ERROR: " + BS2RE3Vs);
		}
		log.debug("Performing Site Commands");
		Iterator e3zeHt7P = GeneralDAO.getNodeValue(uoiZhKd4, "ftpSite").iterator();
		while (e3zeHt7P.hasNext()) {
			String tbEtV4Bl = null;
			try {
				tbEtV4Bl = (String) e3zeHt7P.next();
				cfFJe1nJ.site(tbEtV4Bl);
			} catch (IOException NSClTZcA) {
				throw new Exception("FTP \"site\" command \"" + tbEtV4Bl + "\" failed - ERROR: " + NSClTZcA);
			}
		}
		if (RjcwMYjS != null) {
			if (RjcwMYjS.equals("A")) {
				log.debug("Set File Type to ASCII");
				cfFJe1nJ.setFileType(FTP.ASCII_FILE_TYPE);
			} else if (RjcwMYjS.equals("B")) {
				log.debug("Set File Type to BINARY");
				cfFJe1nJ.setFileType(FTP.BINARY_FILE_TYPE);
			} else if (RjcwMYjS.equals("E")) {
				log.debug("Set File Type to EBCDIC");
				cfFJe1nJ.setFileType(FTP.EBCDIC_FILE_TYPE);
			}
		}
		log.debug("Opening the File Stream");
		InputStream z7tcUCWd = null;
		try {
			z7tcUCWd = cfFJe1nJ.retrieveFileStream(TqKXWty5);
			if (z7tcUCWd == null) {
				throw new Exception("Failed get the file \"" + TqKXWty5 + "\" from \"" + uoiZhKd4 + "\"  - ERROR: "
						+ cfFJe1nJ.getReplyString());
			}
		} catch (IOException Qlf8WsP0) {
			cfFJe1nJ.disconnect();
			log.error("Failed get the file \"" + TqKXWty5 + "\" from \"" + uoiZhKd4 + "\"  - ERROR: " + Qlf8WsP0);
			throw new Exception("Failed to retrieve file from \"" + uoiZhKd4 + "\"  as user \"" + f5bMFLva
					+ "\" - ERROR: " + Qlf8WsP0);
		}
		log.debug("Starting the read");
		DESCrypt OjOY61Xl = null;
		try {
			OjOY61Xl = new DESCrypt();
		} catch (Exception eP6b4C4Z) {
			log.error("Failed to initialize the encrypt process - ERROR: " + eP6b4C4Z);
		}
		String OJUyZAVG = null;
		try {
			Object[] nsFsZNwR = OjOY61Xl.encrypt(z7tcUCWd, McQzGsk7);
			OJUyZAVG = (String) nsFsZNwR[0];
			GeneralDAO.setStageFileSize(xhjhxP4r, (Long) nsFsZNwR[1]);
		} catch (Exception WSB45AHC) {
			log.error("Encrypt Error: " + WSB45AHC);
			throw new Exception("Encrypt Error: " + WSB45AHC);
		}
		log.debug("Logging Out");
		try {
			cfFJe1nJ.logout();
			McQzGsk7.close();
		} catch (Exception xs2C5fGu) {
			log.error("Failed close connection to \"" + uoiZhKd4 + "\"  - ERROR: " + xs2C5fGu);
		}
		log.debug("Setting the File Digest");
		GeneralDAO.setStageFileDigest(xhjhxP4r, OJUyZAVG);
		if ((oui3dNus != null) && (!oui3dNus.equals(""))) {
			log.debug("File DIGEST compare - Source: " + oui3dNus.toLowerCase() + " | Received: " + OJUyZAVG);
			if (!OJUyZAVG.equals(oui3dNus.toLowerCase())) {
				throw new Exception("MD5 validation on file failed.");
			}
		}
		return;
	}

}