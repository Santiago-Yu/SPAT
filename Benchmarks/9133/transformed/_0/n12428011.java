class n12428011 {
	public static String ftpPing(String yLgxUIjq, String oTwSzCrl, int klBcAaUq, String Wof4H9Yc, String nSn5ObkT) {
		try {
			ftpClient = new FTPClient();
			ftpClient.setRemoteAddr(InetAddress.getByName(oTwSzCrl));
			ftpClient.setControlPort(klBcAaUq);
			ftpClient.setTimeout(4000);
			ftpClient.connect();
			try {
				Thread.sleep(200);
			} catch (InterruptedException cqZNeqRN) {
				cqZNeqRN.printStackTrace();
			}
			ftpClient.login(Wof4H9Yc, (nSn5ObkT));
			ftpClient.chdir(yLgxUIjq);
			JobHandler.releaseFTPLock();
		} catch (UnknownHostException wbkTl9q3) {
			wbkTl9q3.printStackTrace();
			return wbkTl9q3.getMessage();
		} catch (FTPException OuMMr1o8) {
			OuMMr1o8.printStackTrace();
			return OuMMr1o8.getMessage();
		} catch (IOException WPjvRwnZ) {
			WPjvRwnZ.printStackTrace();
			return WPjvRwnZ.getMessage();
		}
		try {
			ftpClient.quit();
		} catch (IOException y6XogOrN) {
			y6XogOrN.printStackTrace();
			return y6XogOrN.getMessage();
		} catch (FTPException LlnzowpW) {
			LlnzowpW.printStackTrace();
			return LlnzowpW.getMessage();
		}
		return null;
	}

}