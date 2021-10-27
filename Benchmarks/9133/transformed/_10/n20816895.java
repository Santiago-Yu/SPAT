class n20816895 {
	public void mode(String env) {
		InputStream in = null;
		String path = this.envs.get(env);
		try {
			URL url = ResourceUtil.getResourceNoException(path);
			if (url == null) {
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