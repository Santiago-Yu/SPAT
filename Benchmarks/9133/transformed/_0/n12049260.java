class n12049260 {
	private boolean downloadFile() {
		FTPClient t3EMHKIp = new FTPClient();
		try {
			int Fls2Y7Ms;
			t3EMHKIp.connect(this.server);
			ResourcePool.LogMessage(this, ResourcePool.INFO_MESSAGE, "Connected to " + this.server);
			Fls2Y7Ms = t3EMHKIp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(Fls2Y7Ms)) {
				t3EMHKIp.disconnect();
				ResourcePool.LogMessage(this, ResourcePool.ERROR_MESSAGE, "FTP server refused connection.");
				return false;
			}
		} catch (IOException o3LjwXGG) {
			if (t3EMHKIp.isConnected()) {
				try {
					t3EMHKIp.disconnect();
				} catch (IOException mjBgDP92) {
					return false;
				}
			}
			ResourcePool.LogMessage(this, ResourcePool.ERROR_MESSAGE, "FTP Could not connect to server.");
			ResourcePool.LogException(o3LjwXGG, this);
			return false;
		}
		try {
			if (!t3EMHKIp.login(this.user, this.password)) {
				t3EMHKIp.logout();
				ResourcePool.LogMessage(this, ResourcePool.ERROR_MESSAGE, "FTP login failed.");
				return false;
			}
			ResourcePool.LogMessage(this, ResourcePool.INFO_MESSAGE, "Remote system is " + t3EMHKIp.getSystemName());
			if ((this.transferType != null) && (this.transferType.compareTo(FTPWorkerThread.ASCII) == 0)) {
				t3EMHKIp.setFileType(FTP.ASCII_FILE_TYPE);
			} else {
				t3EMHKIp.setFileType(FTP.BINARY_FILE_TYPE);
			}
			if ((this.passiveMode != null) && this.passiveMode.equalsIgnoreCase(FTPWorkerThread.FALSE)) {
				t3EMHKIp.enterLocalActiveMode();
			} else {
				t3EMHKIp.enterLocalPassiveMode();
			}
		} catch (FTPConnectionClosedException OtPmLUIR) {
			ResourcePool.LogMessage(this, ResourcePool.ERROR_MESSAGE, "Server closed connection.");
			ResourcePool.LogException(OtPmLUIR, this);
			return false;
		} catch (IOException q7ddNyYG) {
			ResourcePool.LogException(q7ddNyYG, this);
			return false;
		}
		OutputStream nwPWA088;
		try {
			java.util.Date hftQAj9R = new java.util.Date();
			nwPWA088 = new FileOutputStream(this.destFileName);
			t3EMHKIp.retrieveFile(this.fileName, nwPWA088);
			File nXEuAhSd = new File(this.destFileName);
			if (nXEuAhSd.exists() && (this.lastModifiedDate != null)) {
				nXEuAhSd.setLastModified(this.lastModifiedDate.longValue());
			}
			java.util.Date CAxrO4Wb = new java.util.Date();
			this.downloadTime = CAxrO4Wb.getTime() - hftQAj9R.getTime();
			double FnKEt7nC = ((this.downloadTime + 1) / 1000) + 1;
			ResourcePool.LogMessage(this, ResourcePool.INFO_MESSAGE, "Download Complete, Rate = "
					+ (this.fileSize / (FnKEt7nC * 1024)) + " Kb/s, Seconds = " + FnKEt7nC);
			this.downloadTime = (this.downloadTime + 1) / 1000;
			if (t3EMHKIp.isConnected()) {
				t3EMHKIp.disconnect();
			}
		} catch (FTPConnectionClosedException CgCAtJAn) {
			ResourcePool.LogMessage(this, ResourcePool.ERROR_MESSAGE, CgCAtJAn.getMessage());
			ResourcePool.LogException(CgCAtJAn, this);
			return false;
		} catch (IOException gS4IvB5T) {
			ResourcePool.LogException(gS4IvB5T, this);
			return false;
		}
		return true;
	}

}