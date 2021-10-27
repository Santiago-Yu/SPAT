class n13111022 {
	private static void copy(File yWqjQ0Rp, File dnO1SQJX) throws IOException {
		InputStream vPEKGweU = null;
		OutputStream GAZ7mTAb = null;
		try {
			vPEKGweU = new BufferedInputStream(new FileInputStream(yWqjQ0Rp));
			GAZ7mTAb = new BufferedOutputStream(new FileOutputStream(dnO1SQJX));
			int miVvb3Ae;
			while ((miVvb3Ae = vPEKGweU.read()) > -1)
				GAZ7mTAb.write(miVvb3Ae);
		} finally {
			try {
				if (vPEKGweU != null)
					vPEKGweU.close();
			} catch (IOException j6CkGiWK) {
			}
			try {
				if (GAZ7mTAb != null)
					GAZ7mTAb.close();
			} catch (IOException Sq3g4GCd) {
			}
		}
	}

}