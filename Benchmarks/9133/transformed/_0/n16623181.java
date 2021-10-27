class n16623181 {
	public static void main(String[] ZhZi5OSz) {
		File mBKV6NeE = new File(ZhZi5OSz[0]);
		File Dp2zV2tP = new File(ZhZi5OSz[1]);
		File[] aquDHvqY = mBKV6NeE.listFiles();
		for (File cS9WLYRA : aquDHvqY) {
			if (cS9WLYRA.isDirectory())
				continue;
			try {
				FileChannel TPh2Y7nx = new FileInputStream(cS9WLYRA).getChannel();
				FileChannel JS63RSQO = new FileOutputStream(
						Dp2zV2tP.getAbsolutePath() + System.getProperty("file.separator") + cS9WLYRA.getName())
								.getChannel();
				ByteBuffer S8IY9IJb = ByteBuffer.allocate(1024);
				int jzWoUMrh = 0;
				TPh2Y7nx.position(jzWoUMrh);
				jzWoUMrh += TPh2Y7nx.read(S8IY9IJb);
				while (jzWoUMrh < cS9WLYRA.length()) {
					S8IY9IJb.flip();
					JS63RSQO.write(S8IY9IJb);
					S8IY9IJb.clear();
					jzWoUMrh += TPh2Y7nx.read(S8IY9IJb);
				}
				TPh2Y7nx.close();
				JS63RSQO.close();
			} catch (IOException P1YQY2FK) {
			}
		}
	}

}