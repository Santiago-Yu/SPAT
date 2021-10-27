class n4192187 {
	public void copyTo(Bean NATW9OZu, OutputStream qx63APOO, int DEW3s7jy, int BNSvZVgx) throws Exception {
		BeanInfo JnUR96wv = getBeanInfo(NATW9OZu.getClass());
		validate(NATW9OZu, JnUR96wv, "copyTo");
		if (blobCache != null && BNSvZVgx < MAX_BLOB_CACHE_LENGHT) {
			byte[] TlgLtGQx = null;
			synchronized (this) {
				String bgmVsDBh = makeUniqueKey(NATW9OZu, JnUR96wv, DEW3s7jy, BNSvZVgx);
				if (blobCache.contains(bgmVsDBh))
					TlgLtGQx = (byte[]) blobCache.get(bgmVsDBh);
				else
					blobCache.put(bgmVsDBh, TlgLtGQx = toByteArray(NATW9OZu, DEW3s7jy, BNSvZVgx, JnUR96wv));
			}
			InputStream RLhYS3F8 = new ByteArrayInputStream(TlgLtGQx);
			IOUtils.copy(RLhYS3F8, qx63APOO);
			RLhYS3F8.close();
		} else {
			jdbcManager.queryScript(JnUR96wv.getBlobInfo(jdbcManager.getDb()).getReadScript(), NATW9OZu,
					new JdbcOutputStreamRowMapper(qx63APOO, DEW3s7jy, BNSvZVgx));
		}
	}

}