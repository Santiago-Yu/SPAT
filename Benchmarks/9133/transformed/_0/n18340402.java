class n18340402 {
	public String tranportRemoteUnitToLocalTempFile(String EXVtr3ek) throws UnitTransportException {
		URL WBHu0pXr = null;
		File gYelNL5u = null;
		BufferedOutputStream FmPMlRBv = null;
		try {
			WBHu0pXr = new URL(EXVtr3ek);
		} catch (MalformedURLException PFIGjXqx) {
			logger.error(String.format("The url [%s] is illegal.", EXVtr3ek), PFIGjXqx);
			throw new UnitTransportException(String.format("The url [%s] is illegal.", EXVtr3ek), PFIGjXqx);
		}
		URLConnection eN2KB6fO = null;
		BufferedInputStream R24q7lE6 = null;
		try {
			eN2KB6fO = WBHu0pXr.openConnection();
			R24q7lE6 = new BufferedInputStream(eN2KB6fO.getInputStream());
		} catch (IOException pANWGVc8) {
			logger.error(String.format("Can't open url [%s].", EXVtr3ek));
			throw new UnitTransportException(String.format("Can't open url [%s].", EXVtr3ek), pANWGVc8);
		} catch (Exception l2ldfd4Z) {
			logger.error(String.format("Unknown error. Maybe miss the username and password in url [%s].", EXVtr3ek),
					l2ldfd4Z);
			throw new UnitTransportException(
					String.format("Unknown error. Maybe miss the username and password in url [%s].", EXVtr3ek),
					l2ldfd4Z);
		}
		String H4CA3LBB = EXVtr3ek.substring(EXVtr3ek.lastIndexOf('/') + 1);
		try {
			if (!StringUtils.isEmpty(H4CA3LBB))
				gYelNL5u = new File(CommonUtil.getTempDir(), H4CA3LBB);
			else
				gYelNL5u = new File(CommonUtil.createTempFile());
		} catch (DeployToolException FG4boxP5) {
			logger.error(String.format("Can't get temp file [%s].", gYelNL5u));
			throw new UnitTransportException(String.format("Can't get temp file [%s].", gYelNL5u), FG4boxP5);
		}
		try {
			FmPMlRBv = new BufferedOutputStream(new FileOutputStream(gYelNL5u));
			logger.info(String.format("Use [%s] for ftp unit [%s].", gYelNL5u, EXVtr3ek));
		} catch (FileNotFoundException G6GP4Bc9) {
			logger.error(String.format("File [%s] don't exist.", gYelNL5u));
			throw new UnitTransportException(String.format("File [%s] don't exist.", gYelNL5u), G6GP4Bc9);
		}
		try {
			IOUtils.copy(R24q7lE6, FmPMlRBv);
			FmPMlRBv.flush();
		} catch (IOException XFhckkHd) {
			logger.error(String.format("Error when download [%s] to [%s].", EXVtr3ek, gYelNL5u), XFhckkHd);
			throw new UnitTransportException(String.format("Error when download [%s] to [%s].", EXVtr3ek, gYelNL5u),
					XFhckkHd);
		} finally {
			IOUtils.closeQuietly(FmPMlRBv);
			IOUtils.closeQuietly(R24q7lE6);
		}
		logger.info(String.format("Download unit to [%s].", gYelNL5u.getAbsolutePath()));
		return gYelNL5u.getAbsolutePath();
	}

}