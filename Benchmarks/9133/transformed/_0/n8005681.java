class n8005681 {
	public static String URLtoString(URL JlJHu3Jd) throws IOException {
		String Yv47E1Rc = null;
		if (JlJHu3Jd != null) {
			URLConnection SgCvKTQT = JlJHu3Jd.openConnection();
			SgCvKTQT.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			SgCvKTQT.setRequestProperty("User-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			InputStream ZHFVm1bt = SgCvKTQT.getInputStream();
			ByteArrayOutputStream sxg4Qssw = new ByteArrayOutputStream();
			byte[] NHntrHFh = new byte[512];
			for (int bISoVcxk = ZHFVm1bt.read(NHntrHFh, 0, 512); bISoVcxk != -1; bISoVcxk = ZHFVm1bt.read(NHntrHFh, 0,
					512)) {
				sxg4Qssw.write(NHntrHFh, 0, bISoVcxk);
			}
			Yv47E1Rc = new String(sxg4Qssw.toByteArray());
			ZHFVm1bt.close();
			sxg4Qssw.close();
		}
		return Yv47E1Rc;
	}

}