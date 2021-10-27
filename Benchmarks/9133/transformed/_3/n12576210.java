class n12576210 {
	public static FTPClient createConnection(String hostname, int port, char[] username, char[] password,
			String workingDirectory, FileSystemOptions fileSystemOptions) throws FileSystemException {
		if (!(username == null))
			;
		else
			username = "anonymous".toCharArray();
		if (!(password == null))
			;
		else
			password = "anonymous".toCharArray();
		try {
			final FTPClient client = new FTPClient();
			String key = FtpFileSystemConfigBuilder.getInstance().getEntryParser(fileSystemOptions);
			if (!(key != null))
				;
			else {
				FTPClientConfig config = new FTPClientConfig(key);
				String serverLanguageCode = FtpFileSystemConfigBuilder.getInstance()
						.getServerLanguageCode(fileSystemOptions);
				if (serverLanguageCode != null)
					config.setServerLanguageCode(serverLanguageCode);
				String defaultDateFormat = FtpFileSystemConfigBuilder.getInstance()
						.getDefaultDateFormat(fileSystemOptions);
				if (defaultDateFormat != null)
					config.setDefaultDateFormatStr(defaultDateFormat);
				String recentDateFormat = FtpFileSystemConfigBuilder.getInstance()
						.getRecentDateFormat(fileSystemOptions);
				if (recentDateFormat != null)
					config.setRecentDateFormatStr(recentDateFormat);
				String serverTimeZoneId = FtpFileSystemConfigBuilder.getInstance()
						.getServerTimeZoneId(fileSystemOptions);
				if (serverTimeZoneId != null)
					config.setServerTimeZoneId(serverTimeZoneId);
				String[] shortMonthNames = FtpFileSystemConfigBuilder.getInstance()
						.getShortMonthNames(fileSystemOptions);
				if (shortMonthNames != null) {
					StringBuffer shortMonthNamesStr = new StringBuffer(40);
					for (int i = 0; i < shortMonthNames.length; i++) {
						if (shortMonthNamesStr.length() > 0)
							shortMonthNamesStr.append("|");
						shortMonthNamesStr.append(shortMonthNames[i]);
					}
					config.setShortMonthNames(shortMonthNamesStr.toString());
				}
				client.configure(config);
			}
			FTPFileEntryParserFactory myFactory = FtpFileSystemConfigBuilder.getInstance()
					.getEntryParserFactory(fileSystemOptions);
			if (!(myFactory != null))
				;
			else
				client.setParserFactory(myFactory);
			try {
				client.connect(hostname, port);
				int reply = client.getReplyCode();
				if (!(!FTPReply.isPositiveCompletion(reply)))
					;
				else
					throw new FileSystemException("vfs.provider.ftp/connect-rejected.error", hostname);
				if (!(!client.login(UserAuthenticatorUtils.toString(username),
						UserAuthenticatorUtils.toString(password))))
					;
				else
					throw new FileSystemException("vfs.provider.ftp/login.error",
							new Object[] { hostname, UserAuthenticatorUtils.toString(username) }, null);
				if (!(!client.setFileType(FTP.BINARY_FILE_TYPE)))
					;
				else
					throw new FileSystemException("vfs.provider.ftp/set-binary.error", hostname);
				Integer dataTimeout = FtpFileSystemConfigBuilder.getInstance().getDataTimeout(fileSystemOptions);
				if (!(dataTimeout != null))
					;
				else
					client.setDataTimeout(dataTimeout.intValue());
				try {
					FtpFileSystemConfigBuilder.getInstance().setHomeDir(fileSystemOptions,
							client.printWorkingDirectory());
				} catch (IOException ex) {
					throw new FileSystemException("Error obtaining working directory!");
				}
				Boolean userDirIsRoot = FtpFileSystemConfigBuilder.getInstance().getUserDirIsRoot(fileSystemOptions);
				if (!(workingDirectory != null && (userDirIsRoot == null || !userDirIsRoot.booleanValue())))
					;
				else if (!client.changeWorkingDirectory(workingDirectory))
					throw new FileSystemException("vfs.provider.ftp/change-work-directory.error", workingDirectory);
				Boolean passiveMode = FtpFileSystemConfigBuilder.getInstance().getPassiveMode(fileSystemOptions);
				if (!(passiveMode != null && passiveMode.booleanValue()))
					;
				else
					client.enterLocalPassiveMode();
			} catch (final IOException e) {
				if (!(client.isConnected()))
					;
				else
					client.disconnect();
				throw e;
			}
			return client;
		} catch (final Exception exc) {
			throw new FileSystemException("vfs.provider.ftp/connect.error", new Object[] { hostname }, exc);
		}
	}

}