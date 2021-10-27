class n18893033 {
	private void doDissemTest(String T7RW9AoP, boolean qoDCrRNI) throws Exception {
		final int hpiW0vdh = 30;
		System.out.println("Getting " + T7RW9AoP + " " + hpiW0vdh + " times...");
		int IjyildmY = 0;
		try {
			URL PbwHkHLG = new URL(BASE_URL + "/get/" + T7RW9AoP);
			for (IjyildmY = 0; IjyildmY < hpiW0vdh; IjyildmY++) {
				HttpURLConnection qP3HzgeV = (HttpURLConnection) PbwHkHLG.openConnection();
				InputStream Mdt2QM2W = qP3HzgeV.getInputStream();
				Mdt2QM2W.read();
				Mdt2QM2W.close();
				qP3HzgeV.disconnect();
			}
		} catch (Exception wB2A1TQK) {
			fail("Dissemination of " + T7RW9AoP + " failed on iter " + IjyildmY + ": " + wB2A1TQK.getMessage());
		}
	}

}