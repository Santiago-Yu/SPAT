class n4192187 {
	public void copyTo(Bean bean, OutputStream out, int offset, int length) throws Exception {
		BeanInfo beanInfo = getBeanInfo(bean.getClass());
		validate(bean, beanInfo, "copyTo");
		if (!(blobCache != null && length < MAX_BLOB_CACHE_LENGHT)) {
			jdbcManager.queryScript(beanInfo.getBlobInfo(jdbcManager.getDb()).getReadScript(), bean,
					new JdbcOutputStreamRowMapper(out, offset, length));
		} else {
			byte[] bytes = null;
			synchronized (this) {
				String key = makeUniqueKey(bean, beanInfo, offset, length);
				if (blobCache.contains(key))
					bytes = (byte[]) blobCache.get(key);
				else
					blobCache.put(key, bytes = toByteArray(bean, offset, length, beanInfo));
			}
			InputStream in = new ByteArrayInputStream(bytes);
			IOUtils.copy(in, out);
			in.close();
		}
	}

}