class n9543284 {
	public static final void copyFile(String srcFilename, String dstFilename) throws IOException {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		FileChannel ofc = null;
		FileChannel ifc = null;
		Util.copyBuffer.clear();
		try {
			fis = new FileInputStream(srcFilename);
			fos = new FileOutputStream(dstFilename);
			ifc = fis.getChannel();
			ofc = fos.getChannel();
			int n = 0;
			int sz = (int) ifc.size();
			while (n < sz) {
				if (ifc.read(Util.copyBuffer) < 0) {
					break;
				}
				Util.copyBuffer.flip();
				n += ofc.write(Util.copyBuffer);
				Util.copyBuffer.compact();
			}
		} finally {
			try {
				if (ifc != null) {
					ifc.close();
				} else if (fis != null) {
					fis.close();
				}
			} catch (IOException exc) {
			}
			try {
				if (ofc != null) {
					ofc.close();
				} else if (fos != null) {
					fos.close();
				}
			} catch (IOException exc) {
			}
		}
	}

}