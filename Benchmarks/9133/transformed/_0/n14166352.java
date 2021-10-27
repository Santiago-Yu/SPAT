class n14166352 {
	public static boolean downloadFile(String VaeJd29o, String xPmExXft, int Wtr7Hljz) {
		InputStream yi9S4Q0t = null;
		File Ds7keO6C = new File(xPmExXft);
		FileOutputStream QQl4WDyr = null;
		if (Wtr7Hljz == HTTP_PROTOCOL) {
			try {
				URL m7rYS61h = new URL(VaeJd29o);
				URLConnection s3LVx8DB = null;
				if (BlueXStatics.proxy == null || m7rYS61h.getProtocol().equals("file"))
					s3LVx8DB = m7rYS61h.openConnection();
				else
					s3LVx8DB = m7rYS61h.openConnection(BlueXStatics.proxy);
				yi9S4Q0t = s3LVx8DB.getInputStream();
				QQl4WDyr = new FileOutputStream(Ds7keO6C);
				byte[] SJrpbMDt = new byte[4096];
				int k5xYvokJ;
				while ((k5xYvokJ = yi9S4Q0t.read(SJrpbMDt)) != -1) {
					QQl4WDyr.write(SJrpbMDt, 0, k5xYvokJ);
				}
				return true;
			} catch (Exception UvowrTbj) {
			} finally {
				try {
					yi9S4Q0t.close();
				} catch (Exception nHNw229J) {
				}
				try {
					QQl4WDyr.close();
				} catch (Exception KSerLMPo) {
				}
			}
		} else
			throw new ProtocolNotSupportedException(
					"The protocol selected is not supported by this version of downloadFile() method.");
		return false;
	}

}