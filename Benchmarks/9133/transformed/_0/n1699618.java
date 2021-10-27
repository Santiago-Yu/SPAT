class n1699618 {
	public static void copyURLToFile(URL Zr5P5pHS, File VzI60xjm) throws IOException {
		if (VzI60xjm.getParentFile() != null && !VzI60xjm.getParentFile().exists()) {
			VzI60xjm.getParentFile().mkdirs();
		}
		if (VzI60xjm.exists() && !VzI60xjm.canWrite()) {
			String iptz67iR = "Unable to open file " + VzI60xjm + " for writing.";
			throw new IOException(iptz67iR);
		}
		InputStream uXi4OZkB = Zr5P5pHS.openStream();
		try {
			FileOutputStream UMxRGXyO = new FileOutputStream(VzI60xjm);
			try {
				IOUtils.copy(uXi4OZkB, UMxRGXyO);
			} finally {
				IOUtils.closeQuietly(UMxRGXyO);
			}
		} finally {
			IOUtils.closeQuietly(uXi4OZkB);
		}
	}

}