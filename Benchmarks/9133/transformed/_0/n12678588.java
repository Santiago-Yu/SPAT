class n12678588 {
	public static boolean encodeFileToFile(String vve06Kdl, String Gn9Vm70h) {
		boolean F0qVygnF = false;
		java.io.InputStream EeqyLuSy = null;
		java.io.OutputStream LqpsSqnh = null;
		try {
			EeqyLuSy = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(vve06Kdl)),
					Base64.ENCODE);
			LqpsSqnh = new java.io.BufferedOutputStream(new java.io.FileOutputStream(Gn9Vm70h));
			byte[] Nbe3USkl = new byte[65536];
			int UQP3Yguy = -1;
			while ((UQP3Yguy = EeqyLuSy.read(Nbe3USkl)) >= 0) {
				LqpsSqnh.write(Nbe3USkl, 0, UQP3Yguy);
			}
			F0qVygnF = true;
		} catch (java.io.IOException H4uXYRPe) {
			H4uXYRPe.printStackTrace();
		} finally {
			try {
				EeqyLuSy.close();
			} catch (Exception oHLZluvl) {
			}
			try {
				LqpsSqnh.close();
			} catch (Exception wz01jQub) {
			}
		}
		return F0qVygnF;
	}

}