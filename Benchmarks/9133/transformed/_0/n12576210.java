class n12576210 {
	public static FTPClient createConnection(String rOncgBL9, int jZeTSezV, char[] NJe5KIQe, char[] vzjwSI7F,
			String RaZlcuCD, FileSystemOptions eIqsSLtV) throws FileSystemException {
		if (NJe5KIQe == null)
			NJe5KIQe = "anonymous".toCharArray();
		if (vzjwSI7F == null)
			vzjwSI7F = "anonymous".toCharArray();
		try {
			final FTPClient rGSSFU0I = new FTPClient();
			String UX29PgC4 = FtpFileSystemConfigBuilder.getInstance().getEntryParser(eIqsSLtV);
			if (UX29PgC4 != null) {
				FTPClientConfig HGmtD3Kn = new FTPClientConfig(UX29PgC4);
				String I8fHNTMp = FtpFileSystemConfigBuilder.getInstance().getServerLanguageCode(eIqsSLtV);
				if (I8fHNTMp != null)
					HGmtD3Kn.setServerLanguageCode(I8fHNTMp);
				String pmW23k8d = FtpFileSystemConfigBuilder.getInstance().getDefaultDateFormat(eIqsSLtV);
				if (pmW23k8d != null)
					HGmtD3Kn.setDefaultDateFormatStr(pmW23k8d);
				String U1mmSc7f = FtpFileSystemConfigBuilder.getInstance().getRecentDateFormat(eIqsSLtV);
				if (U1mmSc7f != null)
					HGmtD3Kn.setRecentDateFormatStr(U1mmSc7f);
				String XsJKo517 = FtpFileSystemConfigBuilder.getInstance().getServerTimeZoneId(eIqsSLtV);
				if (XsJKo517 != null)
					HGmtD3Kn.setServerTimeZoneId(XsJKo517);
				String[] dmV2GMA0 = FtpFileSystemConfigBuilder.getInstance().getShortMonthNames(eIqsSLtV);
				if (dmV2GMA0 != null) {
					StringBuffer LwR1MaQ8 = new StringBuffer(40);
					for (int xcdTKcp7 = 0; xcdTKcp7 < dmV2GMA0.length; xcdTKcp7++) {
						if (LwR1MaQ8.length() > 0)
							LwR1MaQ8.append("|");
						LwR1MaQ8.append(dmV2GMA0[xcdTKcp7]);
					}
					HGmtD3Kn.setShortMonthNames(LwR1MaQ8.toString());
				}
				rGSSFU0I.configure(HGmtD3Kn);
			}
			FTPFileEntryParserFactory YXWwk1pw = FtpFileSystemConfigBuilder.getInstance()
					.getEntryParserFactory(eIqsSLtV);
			if (YXWwk1pw != null)
				rGSSFU0I.setParserFactory(YXWwk1pw);
			try {
				rGSSFU0I.connect(rOncgBL9, jZeTSezV);
				int LK9eYz6x = rGSSFU0I.getReplyCode();
				if (!FTPReply.isPositiveCompletion(LK9eYz6x))
					throw new FileSystemException("vfs.provider.ftp/connect-rejected.error", rOncgBL9);
				if (!rGSSFU0I.login(UserAuthenticatorUtils.toString(NJe5KIQe),
						UserAuthenticatorUtils.toString(vzjwSI7F)))
					throw new FileSystemException("vfs.provider.ftp/login.error",
							new Object[] { rOncgBL9, UserAuthenticatorUtils.toString(NJe5KIQe) }, null);
				if (!rGSSFU0I.setFileType(FTP.BINARY_FILE_TYPE))
					throw new FileSystemException("vfs.provider.ftp/set-binary.error", rOncgBL9);
				Integer xSdvxovF = FtpFileSystemConfigBuilder.getInstance().getDataTimeout(eIqsSLtV);
				if (xSdvxovF != null)
					rGSSFU0I.setDataTimeout(xSdvxovF.intValue());
				try {
					FtpFileSystemConfigBuilder.getInstance().setHomeDir(eIqsSLtV, rGSSFU0I.printWorkingDirectory());
				} catch (IOException v9Ig3mxB) {
					throw new FileSystemException("Error obtaining working directory!");
				}
				Boolean ZLGFJDtd = FtpFileSystemConfigBuilder.getInstance().getUserDirIsRoot(eIqsSLtV);
				if (RaZlcuCD != null && (ZLGFJDtd == null || !ZLGFJDtd.booleanValue()))
					if (!rGSSFU0I.changeWorkingDirectory(RaZlcuCD))
						throw new FileSystemException("vfs.provider.ftp/change-work-directory.error", RaZlcuCD);
				Boolean juzyrUzO = FtpFileSystemConfigBuilder.getInstance().getPassiveMode(eIqsSLtV);
				if (juzyrUzO != null && juzyrUzO.booleanValue())
					rGSSFU0I.enterLocalPassiveMode();
			} catch (final IOException X2POXHrT) {
				if (rGSSFU0I.isConnected())
					rGSSFU0I.disconnect();
				throw X2POXHrT;
			}
			return rGSSFU0I;
		} catch (final Exception okYbaR3I) {
			throw new FileSystemException("vfs.provider.ftp/connect.error", new Object[] { rOncgBL9 }, okYbaR3I);
		}
	}

}