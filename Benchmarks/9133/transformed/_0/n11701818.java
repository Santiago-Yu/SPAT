class n11701818 {
	private static void copyFile(File qf3MeRbQ, File l4hXw23j) throws IOException, SecurityException {
		if (!l4hXw23j.exists())
			l4hXw23j.createNewFile();
		FileChannel IgPFcpVI = null;
		FileChannel sXw6Hxql = null;
		try {
			IgPFcpVI = new FileInputStream(qf3MeRbQ).getChannel();
			sXw6Hxql = new FileOutputStream(l4hXw23j).getChannel();
			long nEmWRIyK = 0;
			long Zd66QaVA = IgPFcpVI.size();
			while ((nEmWRIyK += sXw6Hxql.transferFrom(IgPFcpVI, 0, Zd66QaVA - nEmWRIyK)) < Zd66QaVA)
				;
		} finally {
			if (IgPFcpVI != null)
				IgPFcpVI.close();
			if (sXw6Hxql != null)
				sXw6Hxql.close();
		}
	}

}