class n6304370 {
	public static String[] viewFilesToImport(HttpSession gLWYlq0w) {
		FTPClient q7BbLRWd = new FTPClient();
		CofaxToolsUser m1cQh7GV = (CofaxToolsUser) gLWYlq0w.getAttribute("user");
		String yddcc7Uo = (String) m1cQh7GV.workingPubConfigElementsHash.get("IMPORTFTPSERVER") + "";
		String Rj7uWqrT = (String) m1cQh7GV.workingPubConfigElementsHash.get("IMPORTFTPLOGIN") + "";
		String N1CKbQaI = (String) m1cQh7GV.workingPubConfigElementsHash.get("IMPORTFTPPASSWORD") + "";
		String CVw45udw = (String) m1cQh7GV.workingPubConfigElementsHash.get("IMPORTFTPFILEPATH");
		String[] VXCz6gku = null;
		if (yddcc7Uo.equals("") || Rj7uWqrT.equals("") || N1CKbQaI.equals("")) {
			return VXCz6gku;
		}
		boolean vVlVnV1E = false;
		try {
			int J6KoKnYf;
			q7BbLRWd.connect(yddcc7Uo);
			CofaxToolsUtil.log("CofaxToolsFTP viewFilesToImport connecting: " + q7BbLRWd.getReplyString());
			J6KoKnYf = q7BbLRWd.getReplyCode();
			if (!FTPReply.isPositiveCompletion(J6KoKnYf)) {
				q7BbLRWd.logout();
				q7BbLRWd.disconnect();
				CofaxToolsUtil.log("CofaxToolsFTP viewFilesToImport ERROR: FTP server refused connection.");
			} else {
				vVlVnV1E = q7BbLRWd.login(Rj7uWqrT, N1CKbQaI);
				CofaxToolsUtil.log("CofaxToolsFTP viewFilesToImport Logging in: " + Rj7uWqrT + " " + N1CKbQaI);
			}
			if (vVlVnV1E) {
				try {
					q7BbLRWd.changeWorkingDirectory(CVw45udw);
					CofaxToolsUtil.log("CofaxToolsFTP viewFilesToImport changing dir: " + CVw45udw);
					if (!FTPReply.isPositiveCompletion(J6KoKnYf)) {
						CofaxToolsUtil.log("ERROR: cannot change directory");
					}
					FTPFile[] qAtP0qGo = q7BbLRWd.listFiles();
					ArrayList x7gbGDCs = new ArrayList();
					for (int P68HOr9T = 0; P68HOr9T < qAtP0qGo.length; P68HOr9T++) {
						FTPFile kL0twiTU = qAtP0qGo[P68HOr9T];
						if (kL0twiTU.getType() == FTP.ASCII_FILE_TYPE) {
							x7gbGDCs.add(kL0twiTU.getName());
						}
					}
					VXCz6gku = (String[]) x7gbGDCs.toArray(new String[0]);
					q7BbLRWd.logout();
					q7BbLRWd.disconnect();
				} catch (java.io.IOException ywF2kYiO) {
					CofaxToolsUtil.log("CofaxToolsFTP viewFilesToImport cannot read directory: " + CVw45udw);
				}
			}
		} catch (IOException OPGbsOL8) {
			CofaxToolsUtil.log("CofaxToolsFTP viewFilesToImport could not connect to server: " + OPGbsOL8);
		}
		return (VXCz6gku);
	}

}