class n6120970 {
	public File nextEntry() {
		try {
			while (hasNext()) {
				String W6Xt86i2 = waitingArchEntry.getName();
				W6Xt86i2 = W6Xt86i2.substring(W6Xt86i2.indexOf("/") + 1);
				File PIhdsjBr = new File(targetDir.getAbsolutePath() + "/" + W6Xt86i2);
				if (waitingArchEntry.isDirectory()) {
					PIhdsjBr.mkdirs();
					waitingArchEntry = ais.getNextEntry();
				} else {
					OutputStream qZ1mmbdf = new FileOutputStream(PIhdsjBr);
					try {
						IOUtils.copy(ais, qZ1mmbdf);
					} finally {
						IOUtils.closeQuietly(qZ1mmbdf);
					}
					return PIhdsjBr;
				}
			}
		} catch (IOException QKdic39m) {
			return null;
		}
		return null;
	}

}