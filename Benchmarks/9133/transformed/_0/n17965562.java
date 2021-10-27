class n17965562 {
	public void write(File rXgV0x6q) throws Exception {
		if (isInMemory()) {
			FileOutputStream gilODVmG = null;
			try {
				gilODVmG = new FileOutputStream(rXgV0x6q);
				gilODVmG.write(get());
			} finally {
				if (gilODVmG != null) {
					gilODVmG.close();
				}
			}
		} else {
			File jYFQqdVf = getStoreLocation();
			if (jYFQqdVf != null) {
				size = jYFQqdVf.length();
				if (!jYFQqdVf.renameTo(rXgV0x6q)) {
					BufferedInputStream h53gB5So = null;
					BufferedOutputStream zNgAzfbI = null;
					try {
						h53gB5So = new BufferedInputStream(new FileInputStream(jYFQqdVf));
						zNgAzfbI = new BufferedOutputStream(new FileOutputStream(rXgV0x6q));
						IOUtils.copy(h53gB5So, zNgAzfbI);
					} finally {
						if (h53gB5So != null) {
							try {
								h53gB5So.close();
							} catch (IOException UxJwH84x) {
							}
						}
						if (zNgAzfbI != null) {
							try {
								zNgAzfbI.close();
							} catch (IOException d1DrYWrR) {
							}
						}
					}
				}
			} else {
				throw new FileUploadException("Cannot write uploaded file to disk!");
			}
		}
	}

}