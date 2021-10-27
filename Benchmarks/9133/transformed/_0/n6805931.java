class n6805931 {
	private static File copyJarToPool(File Vd2VImtK) {
		File iFTFK66Q = new File(
				RizzToolConstants.TOOL_POOL_FOLDER.getAbsolutePath() + File.separator + Vd2VImtK.getName());
		if (Vd2VImtK != null && Vd2VImtK.exists() && Vd2VImtK.canRead()) {
			try {
				FileChannel B552Tlv5 = new FileInputStream(Vd2VImtK).getChannel();
				FileChannel uxqWHoaV = new FileOutputStream(iFTFK66Q).getChannel();
				B552Tlv5.transferTo(0, B552Tlv5.size(), uxqWHoaV);
				return iFTFK66Q;
			} catch (Exception CrpD3YSt) {
				RizzToolConstants.DEFAULT_LOGGER.error("Exception while copying jar file to tool pool [inFile="
						+ Vd2VImtK.getAbsolutePath() + "] [outFile=" + iFTFK66Q.getAbsolutePath() + ": " + CrpD3YSt);
			}
		} else {
			RizzToolConstants.DEFAULT_LOGGER
					.error("Could not copy jar file. File does not exist or can't read file. [inFile="
							+ Vd2VImtK.getAbsolutePath() + "]");
		}
		return null;
	}

}