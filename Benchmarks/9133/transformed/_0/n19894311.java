class n19894311 {
	public static Map getFile(DispatchContext iX4Fxmr8, Map IRwu64i2) {
		String CwfHsvrR = (String) IRwu64i2.get("localFilename");
		OutputStream OuQoKgO6 = null;
		try {
			OuQoKgO6 = new FileOutputStream(CwfHsvrR);
		} catch (IOException LvDssvjO) {
			Debug.logError(LvDssvjO, "[getFile] Problem opening local file", module);
			return ServiceUtil.returnError("ERROR: Could not open local file");
		}
		List P5x7bVEU = new ArrayList();
		FTPClient WpIpxd0T = new FTPClient();
		try {
			WpIpxd0T.connect((String) IRwu64i2.get("hostname"));
			if (!FTPReply.isPositiveCompletion(WpIpxd0T.getReplyCode())) {
				P5x7bVEU.add("Server refused connection");
			} else {
				String GqS5GuQs = (String) IRwu64i2.get("username");
				String VTeZZyV8 = (String) IRwu64i2.get("password");
				if (!WpIpxd0T.login(GqS5GuQs, VTeZZyV8)) {
					P5x7bVEU.add("Login failed (" + GqS5GuQs + ", " + VTeZZyV8 + ")");
				} else {
					Boolean OB2QdBqg = (Boolean) IRwu64i2.get("binaryTransfer");
					boolean P6u0a0IE = (OB2QdBqg == null) ? false : OB2QdBqg.booleanValue();
					if (P6u0a0IE) {
						WpIpxd0T.setFileType(FTP.BINARY_FILE_TYPE);
					}
					Boolean UoEiTK6X = (Boolean) IRwu64i2.get("passiveMode");
					boolean I1biQWSb = (UoEiTK6X == null) ? false : UoEiTK6X.booleanValue();
					if (I1biQWSb) {
						WpIpxd0T.enterLocalPassiveMode();
					}
					if (!WpIpxd0T.retrieveFile((String) IRwu64i2.get("remoteFilename"), OuQoKgO6)) {
						P5x7bVEU.add("File not received succesfully: " + WpIpxd0T.getReplyString());
					}
				}
				WpIpxd0T.logout();
			}
		} catch (IOException OXCyAMD7) {
			P5x7bVEU.add("Problem with FTP transfer: " + OXCyAMD7.getMessage());
		} finally {
			if (WpIpxd0T.isConnected()) {
				try {
					WpIpxd0T.disconnect();
				} catch (IOException xttN8mnM) {
					Debug.logWarning(xttN8mnM, "[getFile] Problem with FTP disconnect", module);
				}
			}
		}
		try {
			OuQoKgO6.close();
		} catch (IOException ZufH28Tg) {
			Debug.logWarning(ZufH28Tg, "[getFile] Problem closing local file", module);
		}
		if (P5x7bVEU.size() > 0) {
			Debug.logError("[getFile] The following error(s) (" + P5x7bVEU.size() + ") occurred: " + P5x7bVEU, module);
			return ServiceUtil.returnError(P5x7bVEU);
		}
		return ServiceUtil.returnSuccess();
	}

}