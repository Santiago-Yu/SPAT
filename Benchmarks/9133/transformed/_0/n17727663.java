class n17727663 {
	private static void copy(String qWIp22ik, String KCqNvUlk) throws IOException {
		File qMhnMcui = new File(qWIp22ik);
		File TnWo4iiY = new File(KCqNvUlk);
		FileChannel XJcOdmlm = null, FhoJ5wbB = null;
		try {
			XJcOdmlm = new FileInputStream(qMhnMcui).getChannel();
			FhoJ5wbB = new FileOutputStream(TnWo4iiY).getChannel();
			long yTjh6DB2 = XJcOdmlm.size();
			MappedByteBuffer q2ldfDyg = XJcOdmlm.map(FileChannel.MapMode.READ_ONLY, 0, yTjh6DB2);
			FhoJ5wbB.write(q2ldfDyg);
		} finally {
			if (XJcOdmlm != null)
				XJcOdmlm.close();
			if (FhoJ5wbB != null)
				FhoJ5wbB.close();
		}
	}

}