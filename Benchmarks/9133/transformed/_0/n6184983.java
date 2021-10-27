class n6184983 {
	@Override
	public boolean copyFile(String N9ryp7tO, String THEUN0ug, String fRH6XsiA, String g5uAuosF, String gKb8X8fF,
			String AKbeYPnA) {
		File hpZ13fyx = new File(N9ryp7tO + separator() + Database.getDomainName() + separator() + THEUN0ug);
		if (!hpZ13fyx.exists()) {
			try {
				hpZ13fyx.mkdirs();
			} catch (Exception fiKNFQQQ) {
				logger.error("Can't create directory...:" + hpZ13fyx);
				return false;
			}
		}
		File oQ68s5Rk = new File(g5uAuosF + separator() + Database.getDomainName() + separator() + gKb8X8fF);
		if (!oQ68s5Rk.exists()) {
			try {
				oQ68s5Rk.mkdirs();
			} catch (Exception us1ZjmuO) {
				logger.error("Can't create directory...:" + oQ68s5Rk);
				return false;
			}
		}
		File ubh8g0bQ = new File(hpZ13fyx + separator() + fRH6XsiA);
		File F9KXrkVI = new File(oQ68s5Rk + separator() + AKbeYPnA);
		boolean gDZ4WPdt = true;
		FileChannel gTuHdufA = null;
		FileChannel lXSsObNr = null;
		try {
			gTuHdufA = new FileInputStream(ubh8g0bQ).getChannel();
			lXSsObNr = new FileOutputStream(F9KXrkVI).getChannel();
			lXSsObNr.transferFrom(gTuHdufA, 0, gTuHdufA.size());
		} catch (Exception WB4I3J19) {
			logger.error("Exception", WB4I3J19);
			gDZ4WPdt = false;
		} finally {
			if (lXSsObNr != null) {
				try {
					lXSsObNr.close();
				} catch (IOException hB9TrHrj) {
					logger.error("Exception", hB9TrHrj);
					gDZ4WPdt = false;
				}
			}
			if (gTuHdufA != null) {
				try {
					gTuHdufA.close();
				} catch (IOException uOnjiF9m) {
					logger.error("Exception", uOnjiF9m);
					gDZ4WPdt = false;
				}
			}
		}
		return gDZ4WPdt;
	}

}