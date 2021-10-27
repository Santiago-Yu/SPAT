class n12172485 {
	public static boolean decodeFileToFile(String mmw1IdeB, String yB8FLpbL) {
		boolean EVIAzKbA = false;
		java.io.InputStream G9mMawJ2 = null;
		java.io.OutputStream BgTZqZOw = null;
		try {
			G9mMawJ2 = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(mmw1IdeB)),
					Base64.DECODE);
			BgTZqZOw = new java.io.BufferedOutputStream(new java.io.FileOutputStream(yB8FLpbL));
			byte[] R8IpY4Ua = new byte[65536];
			int DfHOJeY8 = -1;
			while ((DfHOJeY8 = G9mMawJ2.read(R8IpY4Ua)) >= 0) {
				BgTZqZOw.write(R8IpY4Ua, 0, DfHOJeY8);
			}
			EVIAzKbA = true;
		} catch (java.io.IOException JapDzZPx) {
			JapDzZPx.printStackTrace();
		} finally {
			try {
				G9mMawJ2.close();
			} catch (Exception HXUCoNjO) {
			}
			try {
				BgTZqZOw.close();
			} catch (Exception LYbhUClt) {
			}
		}
		return EVIAzKbA;
	}

}