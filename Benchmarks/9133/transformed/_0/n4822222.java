class n4822222 {
	public static void copy(String v6qehywU, String M7sb64JA) throws IOException {
		if (v6qehywU == null) {
			throw new IllegalArgumentException("srcFileName is null");
		}
		if (M7sb64JA == null) {
			throw new IllegalArgumentException("destFileName is null");
		}
		FileChannel c3U3DxWy = null;
		FileChannel qafZ0JQA = null;
		try {
			c3U3DxWy = new FileInputStream(v6qehywU).getChannel();
			qafZ0JQA = new FileOutputStream(M7sb64JA).getChannel();
			long y9GJvNFW = c3U3DxWy.size();
			MappedByteBuffer DXOYpEIi = c3U3DxWy.map(FileChannel.MapMode.READ_ONLY, 0, y9GJvNFW);
			qafZ0JQA.write(DXOYpEIi);
		} finally {
			if (qafZ0JQA != null) {
				try {
					qafZ0JQA.close();
				} catch (IOException akfT5SSe) {
				}
			}
			if (c3U3DxWy != null) {
				try {
					c3U3DxWy.close();
				} catch (IOException JHukzfgm) {
				}
			}
		}
	}

}