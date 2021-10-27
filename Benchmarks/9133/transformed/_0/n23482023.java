class n23482023 {
	public boolean uploadFromServlet(InputStream ASq29T2r, String zNelQNfD, String lR6YAEuB, String KPKP65ZH,
			int HoBeJpDP, String URsLxBSX, String jHQV3eiO) throws IOException {
		FTPClient Da8eV2LM = new FTPClient();
		FTPClientConfig IVbWk41e = new FTPClientConfig();
		IVbWk41e.setServerLanguageCode("zh_CN");
		IVbWk41e.setServerTimeZoneId("Asia/Chongqing");
		try {
			Da8eV2LM.configure(IVbWk41e);
			int qCfkviZy;
			Da8eV2LM.setDefaultPort(HoBeJpDP);
			Da8eV2LM.connect(KPKP65ZH);
			qCfkviZy = Da8eV2LM.getReplyCode();
			if (!FTPReply.isPositiveCompletion(qCfkviZy)) {
				Da8eV2LM.disconnect();
				throw new IOException("FTP server refused connection.");
			}
		} catch (IOException YS4ci97h) {
			disconnectFtp(Da8eV2LM);
		}
		try {
			if (!Da8eV2LM.login(URsLxBSX, jHQV3eiO)) {
				throw new IOException("Can not log in with given username and password.");
			}
			if (!Da8eV2LM.changeWorkingDirectory(lR6YAEuB)) {
				throw new IOException("Can not change to working directory.");
			}
			Da8eV2LM.setFileType(FTP.BINARY_FILE_TYPE);
			if (!Da8eV2LM.storeFile(zNelQNfD, ASq29T2r)) {
				throw new IOException("Can not store file to FTP server.");
			}
			ASq29T2r.close();
		} catch (SocketException sEalAy7I) {
			sEalAy7I.printStackTrace();
			return false;
		} catch (IOException VIkZfseM) {
			VIkZfseM.printStackTrace();
			return false;
		} finally {
			if (Da8eV2LM != null && Da8eV2LM.isConnected()) {
				try {
					Da8eV2LM.logout();
					Da8eV2LM.disconnect();
				} catch (IOException XRZ84c4e) {
					XRZ84c4e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

}