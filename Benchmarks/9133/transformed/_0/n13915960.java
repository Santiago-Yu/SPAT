class n13915960 {
	protected void copyFile(final String BcfbS3l5, final File r0j9JIGj) throws IOException {
		final File JmCjQSSU = new File(BcfbS3l5);
		final File awKpt9Z0 = new File(r0j9JIGj, JmCjQSSU.getName());
		FileChannel uDXDqmXR = null;
		FileChannel gKBeM2az = null;
		FileInputStream Ptec6z39 = null;
		FileOutputStream rqCYmjv1 = null;
		try {
			Ptec6z39 = new FileInputStream(JmCjQSSU);
			uDXDqmXR = Ptec6z39.getChannel();
			rqCYmjv1 = new FileOutputStream(awKpt9Z0);
			gKBeM2az = rqCYmjv1.getChannel();
			gKBeM2az.transferFrom(uDXDqmXR, 0, uDXDqmXR.size());
		} finally {
			try {
				if (gKBeM2az != null) {
					gKBeM2az.close();
				}
			} catch (Exception yhYU2xdM) {
			}
			try {
				if (uDXDqmXR != null) {
					uDXDqmXR.close();
				}
			} catch (Exception FE6YvwBa) {
			}
			try {
				Ptec6z39.close();
			} catch (Exception e3ixC2yQ) {
			}
			try {
				rqCYmjv1.close();
			} catch (Exception zKwBohTa) {
			}
		}
	}

}