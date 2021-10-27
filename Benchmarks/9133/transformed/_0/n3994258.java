class n3994258 {
	public boolean connectServer(String Wmp2wbTi, String k8TXu17F, String MQJDRpbo) {
		boolean ROBpwSXK = true;
		try {
			if (k8TXu17F.equals("")) {
				k8TXu17F = "anonymous";
				MQJDRpbo = "anonymous";
			}
			this.server = Wmp2wbTi;
			this.user = k8TXu17F;
			this.password = MQJDRpbo;
			ftpClient = new FTPClient();
			ftpClient.setControlEncoding(encode);
			ftpClient.connect(Wmp2wbTi);
			ftpClient.setSoTimeout(1000 * 30);
			ftpClient.setDefaultTimeout(1000 * 30);
			ftpClient.setConnectTimeout(1000 * 30);
			ftpClient.enterLocalPassiveMode();
			ftpClient.login(k8TXu17F, MQJDRpbo);
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
				ftpClient.disconnect();
				return false;
			}
			queFilePath = "data\\" + this.server + ".que";
			bufFilePath = "data\\" + this.server + ".buf";
			startGetList();
		} catch (java.net.SocketTimeoutException sGi2A7qX) {
			errMsg = ftpClient.getReplyString();
			errCode = ftpClient.getReplyCode();
			ROBpwSXK = false;
			setArrToFile(dirQueue, queFilePath);
			setArrToFile(fileList, bufFilePath);
			cn.imgdpu.util.CatException.getMethod().catException(sGi2A7qX, "连接超时");
		} catch (Exception QaUdQX1o) {
			errMsg = ftpClient.getReplyString();
			errCode = ftpClient.getReplyCode();
			ROBpwSXK = false;
			setArrToFile(dirQueue, queFilePath);
			setArrToFile(fileList, bufFilePath);
			cn.imgdpu.util.CatException.getMethod().catException(QaUdQX1o, "未知异常");
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException zSuQiiYn) {
					cn.imgdpu.util.CatException.getMethod().catException(zSuQiiYn, "IO异常");
				}
			}
		}
		return ROBpwSXK;
	}

}