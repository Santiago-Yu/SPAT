class n2638907 {
	public void run() {
		LOG.debug(this);
		String[] kZ3Gkv3t = createCmdArray(getCommand());
		Runtime mo5ZFYHj = Runtime.getRuntime();
		try {
			Process Z8VOhuUy = mo5ZFYHj.exec(kZ3Gkv3t);
			if (isBlocking()) {
				Z8VOhuUy.waitFor();
				StringWriter POggmSQ4 = new StringWriter();
				IOUtils.copy(Z8VOhuUy.getInputStream(), POggmSQ4);
				String mkBlgTK1 = POggmSQ4.toString().replaceFirst("\\s+$", "");
				if (StringUtils.isNotBlank(mkBlgTK1)) {
					LOG.info("Process stdout:\n" + mkBlgTK1);
				}
				StringWriter YqJzcKhZ = new StringWriter();
				IOUtils.copy(Z8VOhuUy.getErrorStream(), YqJzcKhZ);
				String pYrSpI6b = YqJzcKhZ.toString().replaceFirst("\\s+$", "");
				if (StringUtils.isNotBlank(pYrSpI6b)) {
					LOG.error("Process stderr:\n" + pYrSpI6b);
				}
			}
		} catch (IOException LZfEMbVX) {
			LOG.error(String.format("Could not exec [%s]", getCommand()), LZfEMbVX);
		} catch (InterruptedException jk1NlaXc) {
			LOG.error(String.format("Interrupted [%s]", getCommand()), jk1NlaXc);
		}
	}

}