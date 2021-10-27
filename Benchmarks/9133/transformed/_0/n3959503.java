class n3959503 {
	public static void copyFile(File pMOSxOrn, File MVmI9jCx) throws IOException {
		FileChannel w2lrpM7i = null, OvfZDPK5 = null;
		try {
			w2lrpM7i = new FileInputStream(pMOSxOrn).getChannel();
			OvfZDPK5 = new FileOutputStream(MVmI9jCx).getChannel();
			w2lrpM7i.transferTo(0, w2lrpM7i.size(), OvfZDPK5);
		} catch (FileNotFoundException NeENRCl9) {
			NeENRCl9.printStackTrace();
		} finally {
			if (w2lrpM7i != null)
				w2lrpM7i.close();
			if (OvfZDPK5 != null)
				OvfZDPK5.close();
		}
	}

}