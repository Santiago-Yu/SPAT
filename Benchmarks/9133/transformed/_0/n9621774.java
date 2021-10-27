class n9621774 {
	public void initResources() throws XAwareException {
		final String thIb6gxm = "initResources";
		if (!initialized) {
			String xT5DH7CK = channelObject.getProperty(XAwareConstants.BIZDRIVER_HOST);
			if (xT5DH7CK == null || xT5DH7CK.trim().length() == 0) {
				throw new XAwareException("xa:host must be specified.");
			}
			String vQNJ3sH6 = channelObject.getProperty(XAwareConstants.BIZDRIVER_PORT);
			if (vQNJ3sH6 == null || vQNJ3sH6.trim().length() == 0) {
				throw new XAwareException("xa:port must be specified.");
			}
			int T2svu2l6 = 0;
			try {
				T2svu2l6 = Integer.parseInt(vQNJ3sH6);
			} catch (Exception tFjqu1pw) {
				throw new XAwareException("xa:port must be numeric.");
			}
			String mHlaHFc1 = channelObject.getProperty(XAwareConstants.XAWARE_FTP_REMOTE_VERIFICATION);
			String rWlYb8yl = channelObject.getProperty(XAwareConstants.BIZDRIVER_USER);
			String GUfvSWpR = channelObject.getProperty(XAwareConstants.BIZDRIVER_PWD);
			String KlUCNWhK = channelObject.getProperty(XAwareConstants.BIZCOMPONENT_ATTR_PROXYUSER);
			String IgCVT8lz = channelObject.getProperty(XAwareConstants.BIZCOMPONENT_ATTR_PROXYPASSWORD);
			ftpClient = new FTPClient();
			logger.finest("Connecting to host:" + xT5DH7CK + " Port:" + T2svu2l6, className, thIb6gxm);
			try {
				ftpClient.connect(xT5DH7CK, T2svu2l6);
				if (mHlaHFc1 != null && mHlaHFc1.trim().equals(XAwareConstants.XAWARE_YES)) {
					ftpClient.setRemoteVerificationEnabled(true);
				} else {
					ftpClient.setRemoteVerificationEnabled(false);
				}
				final int H4a5w5GH = ftpClient.getReplyCode();
				if (!FTPReply.isPositiveCompletion(H4a5w5GH)) {
					ftpClient.disconnect();
					String tAV9evc4 = "FTP server refused connection. Error Code:" + H4a5w5GH;
					logger.severe(tAV9evc4, className, thIb6gxm);
					throw new XAwareException(tAV9evc4);
				}
				logger.finest("Logging in User:" + rWlYb8yl + " PWD:" + GUfvSWpR, className, thIb6gxm);
				if (!ftpClient.login(rWlYb8yl, GUfvSWpR)) {
					ftpClient.logout();
					String Z1FzfLaX = "Error logging into server. Please check credentials.";
					logger.severe(Z1FzfLaX, className, thIb6gxm);
					throw new XAwareException(Z1FzfLaX);
				}
				if (KlUCNWhK != null && KlUCNWhK.trim().length() > 0) {
					logger.finest("Logging in again proxy UID:" + KlUCNWhK + " proxy password:" + IgCVT8lz, className,
							thIb6gxm);
					if (!ftpClient.login(KlUCNWhK, IgCVT8lz)) {
						ftpClient.logout();
						String VJsXKbug = "Error logging using proxy user/pwd. Please check proxy credentials.";
						logger.severe(VJsXKbug, className, thIb6gxm);
						throw new XAwareException(VJsXKbug);
					}
				}
			} catch (SocketException BmeH6xNE) {
				String VcXi8PVf = "SocketException: " + ExceptionMessageHelper.getExceptionMessage(BmeH6xNE);
				logger.severe(VcXi8PVf, className, thIb6gxm);
				throw new XAwareException(VcXi8PVf, BmeH6xNE);
			} catch (IOException fc8Ge3NG) {
				String HcKYCgyN = "IOException: " + ExceptionMessageHelper.getExceptionMessage(fc8Ge3NG);
				logger.severe(HcKYCgyN, className, thIb6gxm);
				throw new XAwareException(HcKYCgyN, fc8Ge3NG);
			}
			logger.finest("Connected to host:" + xT5DH7CK + " Port:" + T2svu2l6, className, thIb6gxm);
			initialized = true;
		}
	}

}