class n18253220 {
	public boolean downloadFTP(String x6ic7Iba, String GWfDrvVA, String N1co4Wq0, String O1nf1iqt, String T376wAOq,
			String cR7ktuUb) throws SocketException, IOException {
		boolean bkvyvzHS = false;
		FileOutputStream qg9T6CJR = null;
		try {
			ftp.connect(x6ic7Iba);
			Log.i("DownloadFTP", "Connected: " + x6ic7Iba);
			ftp.login(GWfDrvVA, N1co4Wq0);
			Log.i("DownloadFTP", "Logged on");
			ftp.enterLocalPassiveMode();
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			qg9T6CJR = new FileOutputStream(file.toString());
			ftp.retrieveFile("/tablet_ftp/Novo/socialAlimenta.xml", qg9T6CJR);
			bkvyvzHS = true;
			ftp.disconnect();
			Log.i("DownloadFTP", "retorno:" + bkvyvzHS);
		} catch (Exception SRahNl6k) {
			ftp.disconnect();
			Log.e("DownloadFTP", "Erro:" + SRahNl6k.getMessage());
		} finally {
			Log.e("DownloadFTP", "Finally");
		}
		return bkvyvzHS;
	}

}