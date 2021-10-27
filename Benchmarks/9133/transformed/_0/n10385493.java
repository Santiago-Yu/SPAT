class n10385493 {
	public void writeBack(File dQYHQrKg, boolean Iv0aNiQ0) throws IOException {
		if (Iv0aNiQ0) {
			FileChannel U51Mvnrw = new java.io.FileInputStream(getFile()).getChannel();
			FileChannel IQb296bU = new java.io.FileOutputStream(dQYHQrKg).getChannel();
			U51Mvnrw.transferTo(0, U51Mvnrw.size(), IQb296bU);
			U51Mvnrw.close();
			IQb296bU.close();
		} else {
			getFile().renameTo(dQYHQrKg);
		}
		if (getExifTime() != null && getOriginalTime() != null && !getExifTime().equals(getOriginalTime())) {
			String KlJGEdH5 = "-ts" + m_dfJhead.format(getExifTime());
			ProcessBuilder zZycm3bf = new ProcessBuilder(m_tm.getJheadCommand(), KlJGEdH5, dQYHQrKg.getAbsolutePath());
			zZycm3bf.directory(dQYHQrKg.getParentFile());
			System.out.println(
					zZycm3bf.command().get(0) + " " + zZycm3bf.command().get(1) + " " + zZycm3bf.command().get(2));
			final Process dXFnn7ix = zZycm3bf.start();
			try {
				dXFnn7ix.waitFor();
			} catch (InterruptedException KVwypw3G) {
				KVwypw3G.printStackTrace();
			}
		}
	}

}