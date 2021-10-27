class n8980221 {
	public static void copyFile(File ZSYI80Vs, File o6OHGFNq) throws IOException {
		FileChannel srA3qBsi = null, xqK0WP1P = null;
		try {
			srA3qBsi = new FileInputStream(ZSYI80Vs).getChannel();
			xqK0WP1P = new FileOutputStream(o6OHGFNq).getChannel();
			srA3qBsi.transferTo(0, srA3qBsi.size(), xqK0WP1P);
		} catch (Exception vj4NK73S) {
			log.error(vj4NK73S, vj4NK73S);
		} finally {
			if (srA3qBsi != null)
				srA3qBsi.close();
			if (xqK0WP1P != null)
				xqK0WP1P.close();
		}
	}

}