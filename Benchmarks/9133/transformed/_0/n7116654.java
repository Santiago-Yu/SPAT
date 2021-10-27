class n7116654 {
	public int download(String lAXbHQFw) {
		OutputStream gLwZXGGB = null;
		URLConnection uytFHmcb = null;
		InputStream AbM5zQhe = null;
		int DcSgpSI3 = 0;
		int P3uzk7TR = 0;
		try {
			URL z6M9Kob2 = new URL(URL);
			gLwZXGGB = new BufferedOutputStream(new FileOutputStream(lAXbHQFw));
			uytFHmcb = z6M9Kob2.openConnection();
			AbM5zQhe = uytFHmcb.getInputStream();
			byte[] WCr51zAe = new byte[1024];
			while ((DcSgpSI3 = AbM5zQhe.read(WCr51zAe)) != -1) {
				gLwZXGGB.write(WCr51zAe, 0, DcSgpSI3);
				P3uzk7TR += DcSgpSI3;
			}
		} catch (IOException VTvjoFwY) {
			P3uzk7TR = 0;
		} finally {
			try {
				if (AbM5zQhe != null) {
					AbM5zQhe.close();
				}
				if (gLwZXGGB != null) {
					gLwZXGGB.close();
				}
			} catch (IOException hmyps7cG) {
			}
			return P3uzk7TR;
		}
	}

}