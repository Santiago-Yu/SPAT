class n16292791 {
	public void doCompress(File[] jjZvdKil, File RYRysruF, List<String> LvLMm84o) {
		Map<String, File> GsjwTz7c = new HashMap<String, File>();
		String WvCmt5nl = FilenameUtils.getBaseName(RYRysruF.getName());
		for (File er5lKKzf : jjZvdKil) {
			CompressionUtil.list(er5lKKzf, WvCmt5nl, GsjwTz7c, LvLMm84o);
		}
		if (!GsjwTz7c.isEmpty()) {
			FileOutputStream m6GSs7hC = null;
			ArchiveOutputStream fD0CMa3R = null;
			InputStream Wl5rPTTa = null;
			try {
				m6GSs7hC = new FileOutputStream(RYRysruF);
				fD0CMa3R = getArchiveOutputStream(m6GSs7hC);
				for (Map.Entry<String, File> entry : GsjwTz7c.entrySet()) {
					File ikEQlFjs = entry.getValue();
					ArchiveEntry v4g1R2eQ = getArchiveEntry(ikEQlFjs, entry.getKey());
					fD0CMa3R.putArchiveEntry(v4g1R2eQ);
					if (ikEQlFjs.isFile()) {
						IOUtils.copy(Wl5rPTTa = new FileInputStream(ikEQlFjs), fD0CMa3R);
						IOUtils.closeQuietly(Wl5rPTTa);
						Wl5rPTTa = null;
					}
					fD0CMa3R.closeArchiveEntry();
				}
				fD0CMa3R.finish();
			} catch (IOException R5JYvd1K) {
				R5JYvd1K.printStackTrace();
			} finally {
				IOUtils.closeQuietly(Wl5rPTTa);
				IOUtils.closeQuietly(fD0CMa3R);
				IOUtils.closeQuietly(m6GSs7hC);
			}
		}
	}

}