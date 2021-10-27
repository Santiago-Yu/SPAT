class n3011458 {
	public String FTPupload(String puvTxVTo) {
		String CKh4pkrr = null;
		Long ejjViBc5 = System.currentTimeMillis();
		String hM3ObO1l = ejjViBc5.toString();
		String[] MKrhPfFR = puvTxVTo.split("/");
		String kuFEikWh = hM3ObO1l + MKrhPfFR[MKrhPfFR.length - 1];
		String rYnMdQLW = "140.112.31.165:8080/sound/";
		Log.d("test", "get in");
		FTPClient ejenkUzU = new FTPClient();
		Log.d("test", "initial ftp");
		try {
			ejenkUzU.connect("140.112.31.165");
			ejenkUzU.enterLocalPassiveMode();
			Log.d("test", "we connected");
			if (!ejenkUzU.login("tacowu", "4565686")) {
				ejenkUzU.logout();
				return CKh4pkrr;
			}
			int jFVslgKm = ejenkUzU.getReplyCode();
			if (!FTPReply.isPositiveCompletion(jFVslgKm)) {
				Log.d("test", "get in trouble");
				ejenkUzU.disconnect();
				return CKh4pkrr;
			}
			Log.d("test", "we logged in");
			ejenkUzU.setFileType(ejenkUzU.BINARY_FILE_TYPE);
			ejenkUzU.enterLocalPassiveMode();
			File DKhYLh6L = new File(puvTxVTo);
			if (DKhYLh6L == null)
				Log.d("test", "file open faild");
			else
				Log.d("test", "file open sucess");
			FileInputStream oyXFjtPP = new FileInputStream(DKhYLh6L);
			boolean jE51qkny = ejenkUzU.storeFile(kuFEikWh, oyXFjtPP);
			oyXFjtPP.close();
			ejenkUzU.disconnect();
		} catch (Exception fcJWWMYc) {
		}
		CKh4pkrr = rYnMdQLW + kuFEikWh;
		return CKh4pkrr;
	}

}