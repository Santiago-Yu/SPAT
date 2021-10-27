class n3526188 {
	public static FTPClient createConnection(String XQF5R7lX, int zitUSEtT, char[] qXJR9B0j, char[] fsStliKe,
			String BuB2Z2gX, FileSystemOptions Z33roy1N) throws FileSystemException {
		if (qXJR9B0j == null) {
			qXJR9B0j = "anonymous".toCharArray();
		}
		if (fsStliKe == null) {
			fsStliKe = "anonymous".toCharArray();
		}
		try {
			final FTPClient fQMZ8V5E = new FTPClient();
			String hZvUPzEz = FtpFileSystemConfigBuilder.getInstance().getEntryParser(Z33roy1N);
			if (hZvUPzEz != null) {
				FTPClientConfig hrKrvq8T = new FTPClientConfig(hZvUPzEz);
				String zBAS2pj1 = FtpFileSystemConfigBuilder.getInstance().getServerLanguageCode(Z33roy1N);
				if (zBAS2pj1 != null) {
					hrKrvq8T.setServerLanguageCode(zBAS2pj1);
				}
				String KULMT9QC = FtpFileSystemConfigBuilder.getInstance().getDefaultDateFormat(Z33roy1N);
				if (KULMT9QC != null) {
					hrKrvq8T.setDefaultDateFormatStr(KULMT9QC);
				}
				String oIRPBgtQ = FtpFileSystemConfigBuilder.getInstance().getRecentDateFormat(Z33roy1N);
				if (oIRPBgtQ != null) {
					hrKrvq8T.setRecentDateFormatStr(oIRPBgtQ);
				}
				String MKQwipfb = FtpFileSystemConfigBuilder.getInstance().getServerTimeZoneId(Z33roy1N);
				if (MKQwipfb != null) {
					hrKrvq8T.setServerTimeZoneId(MKQwipfb);
				}
				String[] L6pH7Xqd = FtpFileSystemConfigBuilder.getInstance().getShortMonthNames(Z33roy1N);
				if (L6pH7Xqd != null) {
					StringBuffer IY0nIA0X = new StringBuffer(40);
					for (int PHoX0i0c = 0; PHoX0i0c < L6pH7Xqd.length; PHoX0i0c++) {
						if (IY0nIA0X.length() > 0) {
							IY0nIA0X.append("|");
						}
						IY0nIA0X.append(L6pH7Xqd[PHoX0i0c]);
					}
					hrKrvq8T.setShortMonthNames(IY0nIA0X.toString());
				}
				fQMZ8V5E.configure(hrKrvq8T);
			}
			FTPFileEntryParserFactory kknMmR8W = FtpFileSystemConfigBuilder.getInstance()
					.getEntryParserFactory(Z33roy1N);
			if (kknMmR8W != null) {
				fQMZ8V5E.setParserFactory(kknMmR8W);
			}
			try {
				fQMZ8V5E.connect(XQF5R7lX, zitUSEtT);
				int xFPAt6xr = fQMZ8V5E.getReplyCode();
				if (!FTPReply.isPositiveCompletion(xFPAt6xr)) {
					throw new FileSystemException("vfs.provider.ftp/connect-rejected.error", XQF5R7lX);
				}
				if (!fQMZ8V5E.login(UserAuthenticatorUtils.toString(qXJR9B0j),
						UserAuthenticatorUtils.toString(fsStliKe))) {
					throw new FileSystemException("vfs.provider.ftp/login.error",
							new Object[] { XQF5R7lX, UserAuthenticatorUtils.toString(qXJR9B0j) }, null);
				}
				if (!fQMZ8V5E.setFileType(FTP.BINARY_FILE_TYPE)) {
					throw new FileSystemException("vfs.provider.ftp/set-binary.error", XQF5R7lX);
				}
				Integer ZaPnqHsi = FtpFileSystemConfigBuilder.getInstance().getDataTimeout(Z33roy1N);
				if (ZaPnqHsi != null) {
					fQMZ8V5E.setDataTimeout(ZaPnqHsi.intValue());
				}
				Boolean z9ohR2i7 = FtpFileSystemConfigBuilder.getInstance().getUserDirIsRoot(Z33roy1N);
				if (BuB2Z2gX != null && (z9ohR2i7 == null || !z9ohR2i7.booleanValue())) {
					if (!fQMZ8V5E.changeWorkingDirectory(BuB2Z2gX)) {
						throw new FileSystemException("vfs.provider.ftp/change-work-directory.error", BuB2Z2gX);
					}
				}
				Boolean ElQdGEZE = FtpFileSystemConfigBuilder.getInstance().getPassiveMode(Z33roy1N);
				if (ElQdGEZE != null && ElQdGEZE.booleanValue()) {
					fQMZ8V5E.enterLocalPassiveMode();
				}
			} catch (final IOException xHTCyeoE) {
				if (fQMZ8V5E.isConnected()) {
					fQMZ8V5E.disconnect();
				}
				throw xHTCyeoE;
			}
			return fQMZ8V5E;
		} catch (final Exception cwQDOjDg) {
			throw new FileSystemException("vfs.provider.ftp/connect.error", new Object[] { XQF5R7lX }, cwQDOjDg);
		}
	}

}