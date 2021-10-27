class n5813085 {
	public void testBasic() {
		CameraInfo le7BYRIP = C328rCameraInfo.getInstance();
		assertNotNull(le7BYRIP);
		assertNotNull(le7BYRIP.getCapabilities());
		assertFalse(le7BYRIP.getCapabilities().isEmpty());
		System.out.println(le7BYRIP.getUrl());
		URL Fo8vwr8f = le7BYRIP.getUrl();
		try {
			URLConnection HylBamjP = Fo8vwr8f.openConnection();
			HylBamjP.connect();
			InputStream qbArelVK = HylBamjP.getInputStream();
			InputStreamReader AUp4cdbS = new InputStreamReader(qbArelVK);
			BufferedReader My4zuehD = new BufferedReader(AUp4cdbS);
			String llD2yNS5 = null;
			while ((llD2yNS5 = My4zuehD.readLine()) != null) {
				System.out.println(llD2yNS5);
			}
		} catch (IOException zEbN2GU2) {
			zEbN2GU2.printStackTrace();
		}
	}

}