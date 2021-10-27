class n19894310 {
	public static Map putFile(DispatchContext UflvZ1Ay, Map Z8leQCuK) {
		Debug.logInfo("[putFile] starting...", module);
		InputStream H4jJdEYy = null;
		try {
			H4jJdEYy = new FileInputStream((String) Z8leQCuK.get("localFilename"));
		} catch (IOException QKezgvmz) {
			Debug.logError(QKezgvmz, "[putFile] Problem opening local file", module);
			return ServiceUtil.returnError("ERROR: Could not open local file");
		}
		List YGYHrWQb = new ArrayList();
		FTPClient ZtC4kOrV = new FTPClient();
		try {
			Debug.logInfo("[putFile] connecting to: " + (String) Z8leQCuK.get("hostname"), module);
			ZtC4kOrV.connect((String) Z8leQCuK.get("hostname"));
			if (!FTPReply.isPositiveCompletion(ZtC4kOrV.getReplyCode())) {
				Debug.logInfo("[putFile] Server refused connection", module);
				YGYHrWQb.add("connection refused");
			} else {
				String pd36Uk0c = (String) Z8leQCuK.get("username");
				String kr9rTEUU = (String) Z8leQCuK.get("password");
				Debug.logInfo("[putFile] logging in: username=" + pd36Uk0c + ", password=" + kr9rTEUU, module);
				if (!ZtC4kOrV.login(pd36Uk0c, kr9rTEUU)) {
					Debug.logInfo("[putFile] login failed", module);
					YGYHrWQb.add("Login failed (" + pd36Uk0c + ", " + kr9rTEUU + ")");
				} else {
					Boolean e9aKMAnG = (Boolean) Z8leQCuK.get("binaryTransfer");
					boolean a44N6jOM = (e9aKMAnG == null) ? false : e9aKMAnG.booleanValue();
					if (a44N6jOM) {
						ZtC4kOrV.setFileType(FTP.BINARY_FILE_TYPE);
					}
					Boolean VdJsERV9 = (Boolean) Z8leQCuK.get("passiveMode");
					boolean Qy8mRn80 = (VdJsERV9 == null) ? true : VdJsERV9.booleanValue();
					if (Qy8mRn80) {
						ZtC4kOrV.enterLocalPassiveMode();
					}
					Debug.logInfo("[putFile] storing local file remotely as: " + Z8leQCuK.get("remoteFilename"),
							module);
					if (!ZtC4kOrV.storeFile((String) Z8leQCuK.get("remoteFilename"), H4jJdEYy)) {
						Debug.logInfo("[putFile] store was unsuccessful", module);
						YGYHrWQb.add("File not sent succesfully: " + ZtC4kOrV.getReplyString());
					} else {
						Debug.logInfo("[putFile] store was successful", module);
						List Pxyrd4FA = (List) Z8leQCuK.get("siteCommands");
						if (Pxyrd4FA != null) {
							Iterator IyfZxBMa = Pxyrd4FA.iterator();
							while (IyfZxBMa.hasNext()) {
								String Aa3GpqD9 = (String) IyfZxBMa.next();
								Debug.logInfo("[putFile] sending SITE command: " + Aa3GpqD9, module);
								if (!ZtC4kOrV.sendSiteCommand(Aa3GpqD9)) {
									YGYHrWQb.add(
											"SITE command (" + Aa3GpqD9 + ") failed: " + ZtC4kOrV.getReplyString());
								}
							}
						}
					}
				}
				ZtC4kOrV.logout();
			}
		} catch (IOException EvHeLe4T) {
			Debug.log(EvHeLe4T, "[putFile] caught exception: " + EvHeLe4T.getMessage(), module);
			YGYHrWQb.add("Problem with FTP transfer: " + EvHeLe4T.getMessage());
		} finally {
			if (ZtC4kOrV.isConnected()) {
				try {
					ZtC4kOrV.disconnect();
				} catch (IOException hotyce31) {
					Debug.logWarning(hotyce31, "[putFile] Problem with FTP disconnect", module);
				}
			}
		}
		try {
			H4jJdEYy.close();
		} catch (IOException xmj7v22Y) {
			Debug.logWarning(xmj7v22Y, "[putFile] Problem closing local file", module);
		}
		if (YGYHrWQb.size() > 0) {
			Debug.logError("[putFile] The following error(s) (" + YGYHrWQb.size() + ") occurred: " + YGYHrWQb, module);
			return ServiceUtil.returnError(YGYHrWQb);
		}
		Debug.logInfo("[putFile] finished successfully", module);
		return ServiceUtil.returnSuccess();
	}

}