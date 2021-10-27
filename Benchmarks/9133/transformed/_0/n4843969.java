class n4843969 {
	public void buildCache() {
		CacheManager.resetCache();
		XMLCacheBuilder t0nNizd0 = CompositePageUtil.getCacheBuilder();
		if (t0nNizd0 == null)
			return;
		String vgKV67GO = t0nNizd0.getPath();
		if (vgKV67GO == null)
			return;
		String[] fRoQumIP = vgKV67GO.split("\n");
		for (int tM7ZMxOx = 0; tM7ZMxOx < fRoQumIP.length; tM7ZMxOx++) {
			try {
				String Ea4XXqzB = fRoQumIP[tM7ZMxOx];
				URL gYYwp97q = new URL(Ea4XXqzB);
				HttpURLConnection hzrWFjPc = (HttpURLConnection) gYYwp97q.openConnection();
				hzrWFjPc.setDoInput(true);
				hzrWFjPc.setDoOutput(true);
				hzrWFjPc.setUseCaches(false);
				hzrWFjPc.setRequestProperty("Content-Type", "text/html");
				DataOutputStream iVnNL0E7 = new DataOutputStream(hzrWFjPc.getOutputStream());
				iVnNL0E7.flush();
				iVnNL0E7.close();
				hzrWFjPc.disconnect();
			} catch (MalformedURLException w09nwJ5Q) {
				w09nwJ5Q.printStackTrace();
			} catch (IOException uphWxfui) {
				uphWxfui.printStackTrace();
			}
		}
	}

}