class n6304371 {
	public static String getImportFileBody(String gUmGMJAT, HttpSession iNVTCn3c) {
		FTPClient UHWKN3gv = new FTPClient();
		CofaxToolsUser sjBPxKI2 = (CofaxToolsUser) iNVTCn3c.getAttribute("user");
		String E6Dasxaz = CofaxToolsServlet.fileTransferFolder;
		String XkVAHawn = (String) sjBPxKI2.workingPubConfigElementsHash.get("IMPORTFTPSERVER");
		String c46LZC5o = (String) sjBPxKI2.workingPubConfigElementsHash.get("IMPORTFTPLOGIN");
		String Zj6CSDEq = (String) sjBPxKI2.workingPubConfigElementsHash.get("IMPORTFTPPASSWORD");
		String TyI3aOdZ = (String) sjBPxKI2.workingPubConfigElementsHash.get("IMPORTFTPFILEPATH");
		String Pi9hTyg0 = ("");
		try {
			int DPYAcNfp;
			UHWKN3gv.connect(XkVAHawn);
			CofaxToolsUtil.log("CofaxToolsFTP getImportFileBody connecting to server " + XkVAHawn);
			DPYAcNfp = UHWKN3gv.getReplyCode();
			if (!FTPReply.isPositiveCompletion(DPYAcNfp)) {
				UHWKN3gv.disconnect();
				return ("CofaxToolsFTP getImportFileBody ERROR: FTP server refused connection.");
			} else {
				UHWKN3gv.login(c46LZC5o, Zj6CSDEq);
			}
			try {
				boolean suphdeaF = UHWKN3gv.changeWorkingDirectory(TyI3aOdZ);
				CofaxToolsUtil.log("CofaxToolsFTP getImportFileBody changing to directory: " + TyI3aOdZ);
				CofaxToolsUtil.log("Results: " + suphdeaF);
				OutputStream LaVBLfYm;
				LaVBLfYm = new FileOutputStream(E6Dasxaz + gUmGMJAT);
				boolean XXoTeUVH = UHWKN3gv.retrieveFile(gUmGMJAT, LaVBLfYm);
				CofaxToolsUtil.log("CofaxToolsFTP getImportFileBody retrieving file: " + gUmGMJAT);
				CofaxToolsUtil.log("CofaxToolsFTP getImportFileBody results: " + suphdeaF);
				LaVBLfYm.close();
				Pi9hTyg0 = CofaxToolsUtil.readFile(E6Dasxaz + gUmGMJAT, true);
				CofaxToolsUtil.log("CofaxToolsFTP getImportFileBody deleting remote file: " + TyI3aOdZ + gUmGMJAT);
				boolean c4Thb3QG = UHWKN3gv.deleteFile(TyI3aOdZ + gUmGMJAT);
				CofaxToolsUtil.log("CofaxToolsFTP getImportFileBody results: " + c4Thb3QG);
				CofaxToolsUtil.log("CofaxToolsFTP getImportFileBody disconnecting from server:" + XkVAHawn);
				UHWKN3gv.logout();
				UHWKN3gv.disconnect();
			} catch (java.io.IOException FmbdQDdk) {
				return ("CofaxToolsFTP getImportFileBody ERROR: cannot write file: " + gUmGMJAT);
			}
		} catch (IOException URZBLY5P) {
			return ("CofaxToolsFTP getImportFileBody  ERROR: could not connect to server: " + URZBLY5P);
		}
		return (Pi9hTyg0);
	}

}