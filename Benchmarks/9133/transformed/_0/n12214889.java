class n12214889 {
	public static boolean copyFile(String wfJrOrqD, String AfQJkMya, boolean QB2tkjiw) {
		File ekRfvUVl = new File(wfJrOrqD);
		File QM2HOsHR = new File(AfQJkMya);
		if (ekRfvUVl.isDirectory() || QM2HOsHR.isDirectory())
			return false;
		if (QM2HOsHR.isFile() && !QB2tkjiw)
			return false;
		if (!ekRfvUVl.isFile())
			return false;
		if (QB2tkjiw)
			QM2HOsHR.delete();
		try {
			File Y2d5E6fM = QM2HOsHR.getParentFile();
			while (Y2d5E6fM != null && !Y2d5E6fM.exists()) {
				Y2d5E6fM.mkdir();
			}
			DataOutputStream wdGp4tGu = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(QM2HOsHR), 10240));
			DataInputStream odTiwM5B = new DataInputStream(
					new BufferedInputStream(new FileInputStream(ekRfvUVl), 10240));
			try {
				while (odTiwM5B.available() > 0) {
					wdGp4tGu.write(odTiwM5B.readUnsignedByte());
				}
			} catch (EOFException CxVomSd3) {
			}
			odTiwM5B.close();
			wdGp4tGu.close();
		} catch (IOException ap3o9s2l) {
			throw new FailedException(
					"Failed to copy file " + ekRfvUVl.getAbsolutePath() + " to " + QM2HOsHR.getAbsolutePath(), ap3o9s2l)
							.setFile(QM2HOsHR.getAbsolutePath());
		}
		return true;
	}

}