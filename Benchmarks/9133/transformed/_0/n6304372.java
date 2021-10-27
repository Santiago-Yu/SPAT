class n6304372 {
	public static String getUploadDeleteComboBox(String yEj8TPdl, String yLJvTcWe, String jJ9wpIHG, String T1geC46z,
			HttpSession xSNkVqnS) {
		FTPClient VEGrvZxl = new FTPClient();
		CofaxToolsUser hb2P8kfu = (CofaxToolsUser) xSNkVqnS.getAttribute("user");
		StringBuffer uVFELLu0 = new StringBuffer();
		StringBuffer cyzqjmf1 = new StringBuffer();
		String eCLKL57i = "";
		String w8l4QXCh = "";
		String kVNX7s0U = "";
		String OBCKM1nx = "";
		int It8BxCCU = 0;
		String fMnGnd0h = (String) hb2P8kfu.workingPubConfigElementsHash.get("LIVEFTPSERVER") + "";
		fMnGnd0h = fMnGnd0h.trim();
		if ((fMnGnd0h == null) || (fMnGnd0h.equals("null")) || (fMnGnd0h.equals(""))) {
			return ("This tool is not " + "configured and will not operate. " + "If you wish it to do so, please edit "
					+ "this publication's properties and add correct values to "
					+ " the Remote Server Upstreaming section.");
		}
		if (jJ9wpIHG.equals("Upload")) {
			w8l4QXCh = (String) hb2P8kfu.workingPubConfigElementsHash.get("TESTFTPSERVER");
			kVNX7s0U = (String) hb2P8kfu.workingPubConfigElementsHash.get("TESTFTPLOGIN");
			OBCKM1nx = (String) hb2P8kfu.workingPubConfigElementsHash.get("TESTFTPPASSWORD");
			CofaxToolsUtil.log("server= " + w8l4QXCh + " , login= " + kVNX7s0U + " , password=" + OBCKM1nx);
			if (T1geC46z.equals("Media")) {
				eCLKL57i = (String) hb2P8kfu.workingPubConfigElementsHash.get("TESTIMAGESFOLDER");
			}
			if (T1geC46z.equals("Templates")) {
				eCLKL57i = (String) hb2P8kfu.workingPubConfigElementsHash.get("TESTTEMPLATEFOLDER");
				CofaxToolsUtil.log("testTemplateFolder= " + eCLKL57i);
			}
		}
		if (jJ9wpIHG.equals("Delete")) {
			kVNX7s0U = (String) hb2P8kfu.workingPubConfigElementsHash.get("LIVEFTPLOGIN");
			OBCKM1nx = (String) hb2P8kfu.workingPubConfigElementsHash.get("LIVEFTPPASSWORD");
			if (T1geC46z.equals("Media")) {
				w8l4QXCh = (String) hb2P8kfu.workingPubConfigElementsHash.get("LIVEIMAGESSERVER");
				eCLKL57i = (String) hb2P8kfu.workingPubConfigElementsHash.get("LIVEIMAGESFOLDER");
			}
			if (T1geC46z.equals("Templates")) {
				w8l4QXCh = (String) hb2P8kfu.workingPubConfigElementsHash.get("LIVEFTPSERVER");
				eCLKL57i = (String) hb2P8kfu.workingPubConfigElementsHash.get("LIVETEMPLATEFOLDER");
			}
		}
		ArrayList UHr8cmqs = splitServers(w8l4QXCh);
		try {
			int zrplrU1y;
			VEGrvZxl.connect((String) UHr8cmqs.get(0));
			CofaxToolsUtil
					.log("CofaxToolsFTP getUploadDeleteComboBox connecting to server: " + (String) UHr8cmqs.get(0));
			CofaxToolsUtil.log("CofaxToolsFTP getUploadDeleteComboBox results: " + VEGrvZxl.getReplyString());
			zrplrU1y = VEGrvZxl.getReplyCode();
			if (!FTPReply.isPositiveCompletion(zrplrU1y)) {
				VEGrvZxl.disconnect();
				return ("CofaxToolsFTP getUploadDeleteComboBox ERROR: FTP server refused connection: " + w8l4QXCh);
			} else {
				VEGrvZxl.login(kVNX7s0U, OBCKM1nx);
				CofaxToolsUtil.log("CofaxToolsFTP getUploadDeleteComboBox login / pass " + kVNX7s0U + " " + OBCKM1nx);
			}
			try {
				String qwqVOwDP = eCLKL57i;
				CofaxToolsUtil.log("fromfolder is " + yLJvTcWe);
				if ((yLJvTcWe != null) && (yLJvTcWe.length() > eCLKL57i.length())) {
					eCLKL57i = yLJvTcWe;
					qwqVOwDP = eCLKL57i;
					int FEExnpzG = eCLKL57i.lastIndexOf("/");
					qwqVOwDP = qwqVOwDP.substring(0, FEExnpzG);
					String Jnhw4x0s = "";
					int QfjhTOnY = eCLKL57i.lastIndexOf((String) hb2P8kfu.workingPubName);
					if (QfjhTOnY > -1) {
						Jnhw4x0s = eCLKL57i.substring(QfjhTOnY);
					}
					cyzqjmf1.append(
							"<B><A HREF=\'/tools/?mode=" + yEj8TPdl + "&hl=templates_view_templates_images&fromFolder="
									+ qwqVOwDP + "\'>" + qwqVOwDP + "</A></B><BR>\n");
				} else if ((yLJvTcWe != null) && (yLJvTcWe.length() == eCLKL57i.length())) {
					eCLKL57i = yLJvTcWe;
					qwqVOwDP = eCLKL57i;
					int U3ys1lD3 = eCLKL57i.lastIndexOf("/");
					qwqVOwDP = qwqVOwDP.substring(0, U3ys1lD3);
				}
				boolean Fp2GySbL = VEGrvZxl.changeWorkingDirectory(eCLKL57i);
				CofaxToolsUtil.log("CofaxToolsFTP getUploadDeleteComboBox changing working directory to " + eCLKL57i);
				CofaxToolsUtil.log("CofaxToolsFTP getUploadDeleteComboBox results " + Fp2GySbL);
				FTPFile[] USa7bpk0 = null;
				if ((jJ9wpIHG.equals("Delete")) && (T1geC46z.equals("Templates"))) {
					USa7bpk0 = VEGrvZxl.listFiles(new CofaxToolsNTFileListParser());
				} else {
					USa7bpk0 = VEGrvZxl.listFiles(new CofaxToolsNTFileListParser());
				}
				if (USa7bpk0 == null) {
					CofaxToolsUtil.log("null");
				}
				for (int jIs8ZkcB = 0; jIs8ZkcB < USa7bpk0.length; jIs8ZkcB++) {
					FTPFile uPtsIoyw = (FTPFile) USa7bpk0[jIs8ZkcB];
					String yjLfWaMi = uPtsIoyw.getName();
					if (!uPtsIoyw.isDirectory()) {
						uVFELLu0.append("<INPUT TYPE=CHECKBOX NAME=" + It8BxCCU + " VALUE=" + eCLKL57i + "/" + yjLfWaMi
								+ ">" + yjLfWaMi + "<BR>\n");
						It8BxCCU++;
					}
					if ((uPtsIoyw.isDirectory()) && (!yjLfWaMi.startsWith(".")) && (!yjLfWaMi.endsWith("."))) {
						int bRZIrd8X = eCLKL57i.lastIndexOf((String) hb2P8kfu.workingPubName);
						String gMzcvtGY = "";
						if (bRZIrd8X > -1) {
							gMzcvtGY = eCLKL57i.substring(bRZIrd8X);
						} else {
							gMzcvtGY = eCLKL57i;
						}
						cyzqjmf1.append("<LI><A HREF=\'/tools/?mode=" + yEj8TPdl
								+ "&hl=templates_view_templates_images&fromFolder=" + eCLKL57i + "/" + yjLfWaMi + "\'>"
								+ gMzcvtGY + "/" + yjLfWaMi + "</A><BR>");
					}
				}
				VEGrvZxl.logout();
				VEGrvZxl.disconnect();
			} catch (java.io.IOException Yt3GJxa3) {
				return ("CofaxToolsFTP getUploadDeleteComboBox cannot read directory: " + eCLKL57i);
			}
		} catch (IOException PsTRFZUU) {
			return ("Could not connect to server: " + PsTRFZUU);
		}
		uVFELLu0.append("<INPUT TYPE=HIDDEN NAME=numElements VALUE=" + It8BxCCU + " >\n");
		uVFELLu0.append("<INPUT TYPE=SUBMIT VALUE=\"" + jJ9wpIHG + " " + T1geC46z + "\">\n");
		return (cyzqjmf1.toString() + uVFELLu0.toString());
	}

}