class n10697587 {
	public static void copyFileNIO(File KIbHVEas, File w5XH3LVC) throws IOException {
		FileInputStream CSxW6lE4 = null;
		FileOutputStream ul9hUkcq = null;
		try {
			CSxW6lE4 = new FileInputStream(KIbHVEas);
			ul9hUkcq = new FileOutputStream(w5XH3LVC);
			FileChannel JjbjJyCl = CSxW6lE4.getChannel();
			FileChannel c3JgfZu2 = ul9hUkcq.getChannel();
			JjbjJyCl.transferTo(0, JjbjJyCl.size(), c3JgfZu2);
			JjbjJyCl.close();
			c3JgfZu2.close();
		} catch (IOException xjHmOFsn) {
			throw xjHmOFsn;
		} finally {
			try {
				if (ul9hUkcq != null) {
					ul9hUkcq.close();
				}
			} catch (Exception YYT64PHH) {
				YYT64PHH.printStackTrace(System.out);
			}
			try {
				if (CSxW6lE4 != null) {
					CSxW6lE4.close();
				}
			} catch (Exception jXrU8kbZ) {
				jXrU8kbZ.printStackTrace(System.out);
			}
		}
	}

}