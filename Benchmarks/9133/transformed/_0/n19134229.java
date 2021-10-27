class n19134229 {
	private void copyFile(final String EfPM0oqx, final File nST8g3JC) throws IOException {
		final File wQTHmCkY = new File(EfPM0oqx);
		final File elFeSC4i = new File(nST8g3JC, wQTHmCkY.getName());
		FileChannel m1lL80lX = null;
		FileChannel es8LvfUd = null;
		try {
			m1lL80lX = new FileInputStream(wQTHmCkY).getChannel();
			es8LvfUd = new FileOutputStream(elFeSC4i).getChannel();
			es8LvfUd.transferFrom(m1lL80lX, 0, m1lL80lX.size());
		} finally {
			try {
				if (es8LvfUd != null) {
					es8LvfUd.close();
				}
			} catch (Exception nazeogQh) {
			}
			try {
				if (m1lL80lX != null) {
					m1lL80lX.close();
				}
			} catch (Exception SYmoG9rP) {
			}
		}
	}

}