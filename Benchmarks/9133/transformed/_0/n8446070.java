class n8446070 {
	private FTPClient getFtpClient(Entry IHnysTJ4) throws Exception {
		Object[] YdGAvPFx = IHnysTJ4.getValues();
		if (YdGAvPFx == null) {
			return null;
		}
		String QAeXNeEb = (String) YdGAvPFx[COL_SERVER];
		String gmV0sc7n = (String) YdGAvPFx[COL_BASEDIR];
		String zDDSNccg = (String) YdGAvPFx[COL_USER];
		String PN0UezPA = (String) YdGAvPFx[COL_PASSWORD];
		if (PN0UezPA != null) {
			PN0UezPA = getRepository().getPageHandler().processTemplate(PN0UezPA, false);
		} else {
			PN0UezPA = "";
		}
		FTPClient PJ4ExtZr = new FTPClient();
		try {
			PJ4ExtZr.connect(QAeXNeEb);
			if (zDDSNccg != null) {
				PJ4ExtZr.login(zDDSNccg, PN0UezPA);
			}
			int U2hdPygI = PJ4ExtZr.getReplyCode();
			if (!FTPReply.isPositiveCompletion(U2hdPygI)) {
				PJ4ExtZr.disconnect();
				System.err.println("FTP server refused connection.");
				return null;
			}
			PJ4ExtZr.setFileType(FTP.IMAGE_FILE_TYPE);
			PJ4ExtZr.enterLocalPassiveMode();
			return PJ4ExtZr;
		} catch (Exception X05lrNpE) {
			System.err.println("Could not connect to ftp server:" + X05lrNpE);
			return null;
		}
	}

}