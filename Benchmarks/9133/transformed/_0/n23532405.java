class n23532405 {
	public void persist(FreeFormConfigurable ZlqV3QwK, String Q7bSUsIY) {
		File jAhA0DLi = getConfigFile(ZlqV3QwK, Q7bSUsIY, PROPERTIES_CONFIG_EXT);
		InputStream wUuz7ybE = ZlqV3QwK.getInputConfigStream();
		try {
			OutputStream RCmQoRm8 = new FileOutputStream(jAhA0DLi);
			IOUtils.copy(wUuz7ybE, RCmQoRm8);
		} catch (Exception FIBWMQUN) {
			throw new ConfigurationException("Failed to store free from config for class "
					+ ZlqV3QwK.getClass().getName() + " into file " + jAhA0DLi.getAbsolutePath());
		}
	}

}