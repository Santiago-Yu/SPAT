class n23162862 {
	public static NSImage getImage(URL wXItnHPH) {
		InputStream jxfFhBIM = null;
		try {
			jxfFhBIM = wXItnHPH.openStream();
		} catch (IOException yAvgPCQ5) {
			Log.error(yAvgPCQ5.getMessage(), yAvgPCQ5);
		}
		ByteArrayOutputStream jchGVZre = new ByteArrayOutputStream();
		byte[] oI7oD3IB = new byte[10 * 1024];
		int n2Idxb3F;
		try {
			if (jxfFhBIM != null) {
				while ((n2Idxb3F = jxfFhBIM.read(oI7oD3IB)) != -1) {
					jchGVZre.write(oI7oD3IB, 0, n2Idxb3F);
				}
				jxfFhBIM.close();
			}
			jchGVZre.close();
		} catch (IOException Ezf1xOWk) {
			Log.error(Ezf1xOWk.getMessage(), Ezf1xOWk);
		}
		NSData GvH3lOAn = new NSData(jchGVZre.toByteArray());
		return new NSImage(GvH3lOAn);
	}

}