class n11969981 {
	public static String readRss(String tjrG1zh8, int FCLcI28W) {
		InputStream kIpM6Mrd = null;
		try {
			tjrG1zh8 = appendParam(tjrG1zh8, "num", "" + FCLcI28W);
			System.out.println("feed=" + tjrG1zh8);
			URL SqDRZntx = new URL(tjrG1zh8);
			URLConnection SakajHwF = SqDRZntx.openConnection();
			SakajHwF.setRequestProperty("User-Agent", RSS_USER_AGENT);
			kIpM6Mrd = SakajHwF.getInputStream();
			return CFileHelper.readInputStream(kIpM6Mrd);
		} catch (Exception rcZr2ps2) {
			throw new CException(rcZr2ps2);
		} finally {
			CFileHelper.closeStream(kIpM6Mrd);
		}
	}

}