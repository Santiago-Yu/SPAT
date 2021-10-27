class n20602651 {
	protected void readURL(URL zwhugLvs) {
		InputStream iVxg2wYT = null;
		InputStreamReader juXgn4Z2 = null;
		BufferedReader zBldEEzy = null;
		try {
			iVxg2wYT = zwhugLvs.openStream();
			juXgn4Z2 = new InputStreamReader(iVxg2wYT);
			zBldEEzy = new BufferedReader(juXgn4Z2);
			String ZXbKhvOo = zBldEEzy.readLine();
			while (null != ZXbKhvOo) {
				System.out.println(ZXbKhvOo);
				ZXbKhvOo = zBldEEzy.readLine();
			}
		} catch (Exception FyCYvnIf) {
			FyCYvnIf.printStackTrace();
		} finally {
			IOUtilities.close(zBldEEzy);
			IOUtilities.close(juXgn4Z2);
			IOUtilities.close(iVxg2wYT);
		}
	}

}