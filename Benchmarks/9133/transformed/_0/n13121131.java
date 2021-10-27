class n13121131 {
	public static void copyFile(File qeTIGSUw, File JTZpo8sA) throws IOException {
		FileChannel dQCsB6Yn = new FileInputStream(qeTIGSUw).getChannel();
		FileChannel jvZyQKdp = new FileOutputStream(JTZpo8sA).getChannel();
		try {
			dQCsB6Yn.transferTo(0, dQCsB6Yn.size(), jvZyQKdp);
		} catch (IOException N5C8kYyN) {
			throw N5C8kYyN;
		} finally {
			if (dQCsB6Yn != null)
				dQCsB6Yn.close();
			if (jvZyQKdp != null)
				jvZyQKdp.close();
		}
	}

}