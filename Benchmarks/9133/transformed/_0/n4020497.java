class n4020497 {
	public static void copyFile(File GY8f08ac, File AztXi98k) throws FileCopyingException {
		try {
			FileInputStream BnShZ7BD = new FileInputStream(GY8f08ac);
			FileOutputStream H4GSk6w7 = new FileOutputStream(AztXi98k);
			FileChannel Sjt0JdDt = BnShZ7BD.getChannel();
			FileChannel VOeowvdY = H4GSk6w7.getChannel();
			VOeowvdY.truncate(0);
			VOeowvdY.transferFrom(Sjt0JdDt, 0, Sjt0JdDt.size());
			BnShZ7BD.close();
			H4GSk6w7.close();
		} catch (IOException zjCDtwkt) {
			String mjY6YByf = "An error occurred when copying from the file \"" + GY8f08ac.getAbsolutePath()
					+ "\" to the file \"" + AztXi98k.getAbsolutePath() + "\".";
			throw new FileCopyingException(mjY6YByf, zjCDtwkt);
		}
	}

}