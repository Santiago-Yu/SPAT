class n6304366 {
	public static String uploadArticleMedia(String uvjuaUA9, String C8Tyx2tN, String XtFxa2Ky, String fSfqGq01,
			String CnAAeglL, DataStore YL34YEtj, HttpSession mxMEmtId) {
		CofaxToolsUser taxkuXPR = (CofaxToolsUser) mxMEmtId.getAttribute("user");
		if (!uvjuaUA9.endsWith(File.separator)) {
			uvjuaUA9 += File.separator;
		}
		FTPClient Ke77X5H5 = new FTPClient();
		String WrJGZgeg = (String) taxkuXPR.workingPubConfigElementsHash.get("LIVEFTPLOGIN");
		String OPLLWKxk = (String) taxkuXPR.workingPubConfigElementsHash.get("LIVEFTPPASSWORD");
		String x61mVVDC = (String) taxkuXPR.workingPubConfigElementsHash.get("LIVEFTPSERVER");
		String lsFFOk82 = (String) taxkuXPR.workingPubConfigElementsHash.get("LIVEIMAGESFOLDER");
		if (!lsFFOk82.endsWith("/")) {
			lsFFOk82 = lsFFOk82 + "/";
		}
		String RZzc9nCz = "";
		String usE5dC69 = "";
		String TgQZGl4t = "";
		TgQZGl4t += "/" + XtFxa2Ky + "/" + fSfqGq01 + "/" + CnAAeglL;
		RZzc9nCz = lsFFOk82 + XtFxa2Ky;
		usE5dC69 = (RZzc9nCz + "/" + fSfqGq01);
		lsFFOk82 = (usE5dC69 + "/" + CnAAeglL);
		CofaxToolsUtil.log("CofaxToolsFTP: liveImagesServer: " + x61mVVDC);
		CofaxToolsUtil.log("CofaxToolsFTP: liveImagesFolder: " + lsFFOk82);
		boolean E3Z3aAoB = false;
		ArrayList FExeAoij = splitServers(x61mVVDC);
		for (int vswhvsD7 = 0; vswhvsD7 < FExeAoij.size(); vswhvsD7++) {
			String YwQETLPK = (String) FExeAoij.get(vswhvsD7);
			try {
				int HZwrWVjq;
				Ke77X5H5.connect(YwQETLPK);
				CofaxToolsUtil.log("CofaxToolsFTP: uploadArticleMedia connecting to server : " + YwQETLPK);
				CofaxToolsUtil.log("CofaxToolsFTP: uploadArticleMedia results: " + Ke77X5H5.getReplyString());
				CofaxToolsUtil.log(Ke77X5H5.getReplyString());
				HZwrWVjq = Ke77X5H5.getReplyCode();
				if (!FTPReply.isPositiveCompletion(HZwrWVjq)) {
					Ke77X5H5.disconnect();
					return ("CofaxToolsFTP uploadArticleMedia ERROR: FTP server refused connection.");
				} else {
					Ke77X5H5.login(WrJGZgeg, OPLLWKxk);
				}
				try {
					Ke77X5H5.setFileType(FTP.IMAGE_FILE_TYPE);
					InputStream IjZAUOfn;
					CofaxToolsUtil.log("CofaxToolsFTP: opening file stream: " + uvjuaUA9 + C8Tyx2tN);
					IjZAUOfn = new FileInputStream(uvjuaUA9 + C8Tyx2tN);
					CofaxToolsUtil.log("CofaxToolsFTP: attempting to change working directory to: " + lsFFOk82);
					boolean unsB4gc4 = Ke77X5H5.changeWorkingDirectory(lsFFOk82);
					CofaxToolsUtil.log("CofaxToolsFTP: uploadArticleMedia results: " + unsB4gc4);
					if (unsB4gc4 == false) {
						CofaxToolsUtil
								.log("CofaxToolsFTP: uploadArticleMedia attempting to create directory :" + lsFFOk82);
						boolean iPdrZy4F = Ke77X5H5.makeDirectory(RZzc9nCz);
						boolean pn1kYMHw = Ke77X5H5.makeDirectory(usE5dC69);
						boolean TcS5wTf4 = Ke77X5H5.makeDirectory(lsFFOk82);
						CofaxToolsUtil.log("CofaxToolsFTP: uploadArticleMedia results: YearDir: " + iPdrZy4F
								+ " MonthDir: " + pn1kYMHw + " finalDir: " + TcS5wTf4);
						unsB4gc4 = Ke77X5H5.changeWorkingDirectory(lsFFOk82);
					}
					if (unsB4gc4) {
						CofaxToolsUtil.log("CofaxToolsFTP: storing " + C8Tyx2tN + " to " + lsFFOk82);
						E3Z3aAoB = Ke77X5H5.storeFile(C8Tyx2tN, IjZAUOfn);
					} else {
						CofaxToolsUtil.log("CofaxToolsFTP: failed changing: " + lsFFOk82);
					}
					if (E3Z3aAoB) {
						CofaxToolsUtil.log("CofaxToolsFTP: Successfully ftped file.");
					} else {
						CofaxToolsUtil.log("CofaxToolsFTP: Failed ftping file.");
					}
					IjZAUOfn.close();
					Ke77X5H5.logout();
					Ke77X5H5.disconnect();
				} catch (org.apache.commons.net.io.CopyStreamException vIyYaV4z) {
					CofaxToolsUtil.log("CofaxToolsFTP: Failed ftping file." + vIyYaV4z.toString());
					CofaxToolsUtil.log("CofaxToolsFTP: " + vIyYaV4z.getIOException().toString());
					return ("Cannot upload file " + lsFFOk82 + "/" + C8Tyx2tN);
				} catch (IOException eHoy4yMV) {
					CofaxToolsUtil.log("CofaxToolsFTP: Failed ftping file." + eHoy4yMV.toString());
					return ("Cannot upload file " + lsFFOk82 + "/" + C8Tyx2tN);
				} catch (Exception poJUfRRZ) {
					CofaxToolsUtil.log("CofaxToolsFTP: Failed ftping file." + poJUfRRZ.toString());
					return ("Cannot upload file " + lsFFOk82 + "/" + C8Tyx2tN);
				}
			} catch (IOException I6GzxDCw) {
				return ("Could not connect to server: " + I6GzxDCw);
			}
		}
		return ("");
	}

}