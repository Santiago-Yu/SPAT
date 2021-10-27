class n3739492 {
	public static boolean downloadFile(String xwOzsKaA, String XgCpFfrw) {
		BufferedInputStream MpGYm3FX = null;
		BufferedOutputStream kVmV68he = null;
		File YIkpm2zo;
		try {
			java.net.URL XyyuGXM0;
			try {
				XyyuGXM0 = new java.net.URL(xwOzsKaA);
			} catch (MalformedURLException w8czIaBx) {
				return false;
			}
			MpGYm3FX = new BufferedInputStream(XyyuGXM0.openStream());
			YIkpm2zo = new File(XgCpFfrw);
			if (!YIkpm2zo.createNewFile()) {
				YIkpm2zo.delete();
				YIkpm2zo.createNewFile();
			}
			kVmV68he = new BufferedOutputStream(new FileOutputStream(YIkpm2zo));
			int vXe5vZ6t;
			while ((vXe5vZ6t = MpGYm3FX.read()) != -1) {
				kVmV68he.write(vXe5vZ6t);
			}
			kVmV68he.flush();
		} catch (IOException g4c20TJ9) {
			return false;
		} finally {
			try {
				MpGYm3FX.close();
				kVmV68he.close();
			} catch (Exception dvd4QKjI) {
			}
		}
		return true;
	}

}