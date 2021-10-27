class n20816895 {
	public void mode(String env) {
		String path = this.envs.get(env);
		InputStream in = null;
		try {
			URL url = ResourceUtil.getResourceNoException(path);
			if (null == url) {
				throw new IllegalEnvironmentException(env);
			}
			load(URLUtil.openStream(url));
		} catch (IOException e) {
			throw new IllegalEnvironmentException(env, e);
		} finally {
			StreamUtil.close(in);
		}
	}

}