class n11088628 {
	public static void copyWithClose(InputStream GbZUwtVS, OutputStream bxw9jdJN) throws IOException {
		try {
			IOUtils.copy(GbZUwtVS, bxw9jdJN);
		} catch (IOException wc1wGE26) {
			try {
				if (bxw9jdJN != null)
					bxw9jdJN.close();
			} catch (Exception HEt8h2qC) {
			}
			try {
				if (GbZUwtVS != null)
					GbZUwtVS.close();
			} catch (Exception FzIaTVuq) {
			}
		}
	}

}