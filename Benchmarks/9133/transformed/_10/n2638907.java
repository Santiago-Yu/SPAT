class n2638907 {
	public void run() {
		LOG.debug(this);
		Runtime runtime = Runtime.getRuntime();
		String[] parts = createCmdArray(getCommand());
		try {
			Process process = runtime.exec(parts);
			if (isBlocking()) {
				process.waitFor();
				StringWriter out = new StringWriter();
				IOUtils.copy(process.getInputStream(), out);
				String stdout = out.toString().replaceFirst("\\s+$", "");
				StringWriter err = new StringWriter();
				if (StringUtils.isNotBlank(stdout)) {
					LOG.info("Process stdout:\n" + stdout);
				}
				IOUtils.copy(process.getErrorStream(), err);
				String stderr = err.toString().replaceFirst("\\s+$", "");
				if (StringUtils.isNotBlank(stderr)) {
					LOG.error("Process stderr:\n" + stderr);
				}
			}
		} catch (IOException ioe) {
			LOG.error(String.format("Could not exec [%s]", getCommand()), ioe);
		} catch (InterruptedException ie) {
			LOG.error(String.format("Interrupted [%s]", getCommand()), ie);
		}
	}

}