class n6605492 {
	public static void getCoverFromUrl(URL sY0JEdjC, String eKBhXC9U) {
		try {
			sY0JEdjC.openConnection();
			InputStream PzPVCWG0 = sY0JEdjC.openStream();
			System.out.flush();
			FileOutputStream MBFfvyGL = null;
			MBFfvyGL = new FileOutputStream(eKBhXC9U);
			int IdPqn9wX, KJXcK9Zx = 0;
			while ((IdPqn9wX = PzPVCWG0.read()) != -1) {
				MBFfvyGL.write(IdPqn9wX);
				KJXcK9Zx++;
			}
			PzPVCWG0.close();
			MBFfvyGL.close();
		} catch (MalformedURLException KlYOSPen) {
			System.err.println(" getCoverFromUrl " + KlYOSPen.toString());
			KlYOSPen.printStackTrace();
		} catch (IOException QvrRVo8B) {
			System.err.println(" getCoverFromUrl " + QvrRVo8B.toString());
			QvrRVo8B.printStackTrace();
		}
	}

}