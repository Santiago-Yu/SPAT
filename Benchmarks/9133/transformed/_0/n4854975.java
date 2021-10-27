class n4854975 {
	public void PutFile(ClientConnector b30WFV0w, Map<String, String> kRST2U48) throws Exception {
		String fUoCX8eG = kRST2U48.get("dest_name");
		String AEWx9bTU = kRST2U48.get("dest_user");
		String nWncbt5J = kRST2U48.get("dest_password");
		String fvEVBtMw = kRST2U48.get("dest_file");
		String MLQGjQB8 = kRST2U48.get("messageID");
		String kwB4uSGX = kRST2U48.get("dest_file_type");
		Integer nW4Gkm6P = 21;
		String wmzmiIld = kRST2U48.get("dest_port");
		if ((wmzmiIld != null) && (wmzmiIld.equals(""))) {
			try {
				nW4Gkm6P = Integer.parseInt(wmzmiIld);
			} catch (Exception BKRhWKBL) {
				nW4Gkm6P = 21;
				log.debug("Destination Port \"" + wmzmiIld + "\" was not valid. Using Default (21)");
			}
		}
		log.info("Starting FTP push of \"" + fvEVBtMw + "\" to \"" + fUoCX8eG);
		if ((AEWx9bTU == null) || (AEWx9bTU.equals(""))) {
			List kUMEMqOt = axt.db.GeneralDAO.getNodeValue(fUoCX8eG, "ftpUser");
			if (kUMEMqOt.size() < 1) {
				AEWx9bTU = DEFAULTUSER;
			} else {
				AEWx9bTU = (String) kUMEMqOt.get(0);
			}
		}
		if ((nWncbt5J == null) || (nWncbt5J.equals(""))) {
			List P7Lu5LIm = axt.db.GeneralDAO.getNodeValue(fUoCX8eG, "ftpPassword");
			if (P7Lu5LIm.size() < 1) {
				nWncbt5J = DEFAULTPASSWORD;
			} else {
				nWncbt5J = (String) P7Lu5LIm.get(0);
			}
		}
		log.debug("Getting Stage File ID");
		String qpBGj1uS = null;
		try {
			qpBGj1uS = STAGINGDIR + "/" + axt.db.GeneralDAO.getStageFile(MLQGjQB8);
		} catch (Exception P20ds6aT) {
			throw new Exception("Failed to assign a staging file \"" + qpBGj1uS + "\" - ERROR: " + P20ds6aT);
		}
		InputStream cuOu9vjg;
		try {
			cuOu9vjg = new FileInputStream(qpBGj1uS);
		} catch (FileNotFoundException MGU4mSZf) {
			throw new Exception("Failed to get the staging file \"" + qpBGj1uS + "\" - ERROR: " + MGU4mSZf);
		}
		log.debug("Sending File");
		FTPClient QFykQJjN = new FTPClient();
		try {
			log.debug("Connecting");
			QFykQJjN.connect(fUoCX8eG, nW4Gkm6P);
			log.debug("Checking Status");
			int iAMGzTnW = QFykQJjN.getReplyCode();
			if (!FTPReply.isPositiveCompletion(iAMGzTnW)) {
				QFykQJjN.disconnect();
				throw new Exception("Failed to connect to \"" + fUoCX8eG + "\"  as user \"" + AEWx9bTU + "\" - ERROR: "
						+ QFykQJjN.getReplyString());
			}
			log.debug("Logging In");
			if (!QFykQJjN.login(AEWx9bTU, nWncbt5J)) {
				QFykQJjN.disconnect();
				throw new Exception("Failed to connect to \"" + fUoCX8eG + "\"  as user \"" + AEWx9bTU
						+ "\" - ERROR: Login Failed");
			}
		} catch (SocketException nIBkFrUH) {
			throw new Exception(
					"Failed to connect to \"" + fUoCX8eG + "\"  as user \"" + AEWx9bTU + "\" - ERROR: " + nIBkFrUH);
		} catch (IOException TuQT1VPs) {
			throw new Exception(
					"Failed to connect to \"" + fUoCX8eG + "\"  as user \"" + AEWx9bTU + "\" - ERROR: " + TuQT1VPs);
		}
		log.debug("Performing Site Commands");
		Iterator FFFyFxrt = GeneralDAO.getNodeValue(fUoCX8eG, "ftpSite").iterator();
		while (FFFyFxrt.hasNext()) {
			String F3VIzjY1 = null;
			try {
				F3VIzjY1 = (String) FFFyFxrt.next();
				QFykQJjN.site(F3VIzjY1);
			} catch (IOException LymMT3xr) {
				throw new Exception("FTP \"site\" command \"" + F3VIzjY1 + "\" failed - ERROR: " + LymMT3xr);
			}
		}
		if (kwB4uSGX != null) {
			if (kwB4uSGX.equals("A")) {
				log.debug("Set File Type to ASCII");
				QFykQJjN.setFileType(FTP.ASCII_FILE_TYPE);
			} else if (kwB4uSGX.equals("B")) {
				log.debug("Set File Type to BINARY");
				QFykQJjN.setFileType(FTP.BINARY_FILE_TYPE);
			} else if (kwB4uSGX.equals("E")) {
				log.debug("Set File Type to EBCDIC");
				QFykQJjN.setFileType(FTP.EBCDIC_FILE_TYPE);
			}
		}
		log.debug("Pushing File");
		OutputStream e8OkrjIY = null;
		try {
			e8OkrjIY = QFykQJjN.storeFileStream(fvEVBtMw);
			if (e8OkrjIY == null) {
				throw new Exception("Failed send the file \"" + fvEVBtMw + "\" to \"" + fUoCX8eG + "\"  - ERROR: "
						+ QFykQJjN.getReplyString());
			}
		} catch (IOException tE2VOzkN) {
			log.error("Failed to push the file \"" + fvEVBtMw + "\" to \"" + fUoCX8eG + "\"  - ERROR: " + tE2VOzkN);
		}
		DESCrypt NrVmI4Bg = null;
		try {
			NrVmI4Bg = new DESCrypt();
		} catch (Exception zciCObO0) {
			log.error("Failed to initialize the encrypt process - ERROR: " + zciCObO0);
		}
		try {
			NrVmI4Bg.decrypt(cuOu9vjg, e8OkrjIY);
		} catch (Exception v66eghMo) {
			log.error("Send Error" + v66eghMo);
		}
		log.debug("Logging Out");
		try {
			e8OkrjIY.close();
			QFykQJjN.logout();
			cuOu9vjg.close();
		} catch (IOException VTJgiTd8) {
			log.error("Failed close connection to \"" + fUoCX8eG + "\"  - ERROR: " + VTJgiTd8);
		}
		return;
	}

}