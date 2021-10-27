class n5813085 {
	public void testBasic() {
		CameraInfo ci = C328rCameraInfo.getInstance();
		assertNotNull(ci);
		assertNotNull(ci.getCapabilities());
		assertFalse(ci.getCapabilities().isEmpty());
		System.out.println(ci.getUrl());
		URL url = ci.getUrl();
		try {
			URLConnection conn = url.openConnection();
			conn.connect();
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			String line = null;
			BufferedReader br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}