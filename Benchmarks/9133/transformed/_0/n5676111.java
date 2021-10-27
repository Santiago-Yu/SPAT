class n5676111 {
	public void get() {
		try {
			int ZgjCWBmg;
			URL hvTH8vp6 = new URL(urlStr);
			URLConnection LEbbHwwg = hvTH8vp6.openConnection();
			LEbbHwwg.setDoInput(true);
			LEbbHwwg.setDoOutput(false);
			InputStream Ri52dXan = LEbbHwwg.getInputStream();
			String KzuFAOOk = new File(hvTH8vp6.getFile()).getName();
			FileOutputStream SVYRHq09 = new FileOutputStream(dstDir + File.separator + KzuFAOOk);
			byte[] GhbsIjhH = new byte[4096];
			while ((ZgjCWBmg = Ri52dXan.read(GhbsIjhH, 0, GhbsIjhH.length)) != -1)
				SVYRHq09.write(GhbsIjhH, 0, ZgjCWBmg);
			SVYRHq09.close();
			Ri52dXan.close();
		} catch (Exception kC2a33ZJ) {
			kC2a33ZJ.printStackTrace();
		}
	}

}