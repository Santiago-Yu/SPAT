class n18178530 {
	public static void copyFile(File Hv4vXgVQ, File i0plWIro) throws IOException {
		LOGGER.info("Copying file '" + Hv4vXgVQ.getAbsolutePath() + "' to '" + i0plWIro.getAbsolutePath() + "'");
		FileChannel NV4AWLXS = null;
		FileChannel OPIMfFh3 = null;
		try {
			FileInputStream jwyzAAU7 = new FileInputStream(Hv4vXgVQ);
			NV4AWLXS = jwyzAAU7.getChannel();
			FileOutputStream rCipoi6O = new FileOutputStream(i0plWIro);
			OPIMfFh3 = rCipoi6O.getChannel();
			OPIMfFh3.transferFrom(NV4AWLXS, 0, NV4AWLXS.size());
		} finally {
			try {
				if (NV4AWLXS != null)
					NV4AWLXS.close();
			} catch (IOException OMLL5gUj) {
				LOGGER.log(Level.SEVERE, OMLL5gUj.getMessage(), OMLL5gUj);
			}
			if (OPIMfFh3 != null) {
				try {
					OPIMfFh3.close();
				} catch (IOException HG8K4drQ) {
					LOGGER.log(Level.SEVERE, HG8K4drQ.getMessage(), HG8K4drQ);
				}
			}
		}
	}

}