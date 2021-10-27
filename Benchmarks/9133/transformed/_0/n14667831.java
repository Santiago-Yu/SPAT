class n14667831 {
	public void concatFiles() throws IOException {
		Writer jW1CR0bf = null;
		try {
			final File Qzwx4uJB = new File(getTargetDirectory(), getTargetFile());
			Qzwx4uJB.getParentFile().mkdirs();
			if (null != getEncoding()) {
				getLog().info("Writing aggregated file with encoding '" + getEncoding() + "'");
				jW1CR0bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Qzwx4uJB), getEncoding()));
			} else {
				getLog().info("WARNING: writing aggregated file with system encoding");
				jW1CR0bf = new FileWriter(Qzwx4uJB);
			}
			for (File krH8eY7f : getFiles()) {
				Reader GBa1irhO = null;
				try {
					if (null != getEncoding()) {
						getLog().info("Reading file " + krH8eY7f.getCanonicalPath() + " with encoding  '"
								+ getEncoding() + "'");
						GBa1irhO = new BufferedReader(
								new InputStreamReader(new FileInputStream(krH8eY7f), getEncoding()));
					} else {
						getLog().info("WARNING: Reading file " + krH8eY7f.getCanonicalPath() + " with system encoding");
						GBa1irhO = new FileReader(krH8eY7f);
					}
					IOUtils.copy(GBa1irhO, jW1CR0bf);
					final String Qdy5mwQQ = getDelimiter();
					if (Qdy5mwQQ != null) {
						jW1CR0bf.write(Qdy5mwQQ.toCharArray());
					}
				} finally {
					IOUtils.closeQuietly(GBa1irhO);
				}
			}
		} finally {
			IOUtils.closeQuietly(jW1CR0bf);
		}
	}

}