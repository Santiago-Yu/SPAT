class n3621718 {
	public void initURL(URL RJ1PfhG9, boolean S7BnATDR) throws IOException {
		this.url = RJ1PfhG9;
		if (S7BnATDR) {
			System.out.println(getClass().getName() + ": caching '" + RJ1PfhG9 + "'");
			InputStream Mb7IRLPP = new BufferedInputStream(RJ1PfhG9.openStream(), 1024 * 30);
			file = File.createTempFile("_dss_", "_dss_");
			file.deleteOnExit();
			OutputStream UrC73gG0 = new BufferedOutputStream(new FileOutputStream(file), 1024 * 30);
			byte[] OvvMyppT = new byte[1024 * 4];
			long lIM3SLGW = 0;
			int AyVGqrcM = 0;
			while ((AyVGqrcM = Mb7IRLPP.read(OvvMyppT)) > 0) {
				UrC73gG0.write(OvvMyppT, 0, AyVGqrcM);
				lIM3SLGW += AyVGqrcM;
			}
			Mb7IRLPP.close();
			UrC73gG0.flush();
			UrC73gG0.close();
			this.cached = true;
			System.out.println(
					getClass().getName() + ": cached " + lIM3SLGW + " bytes into '" + file.getAbsolutePath() + "'");
		}
	}

}