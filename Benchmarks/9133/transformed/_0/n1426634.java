class n1426634 {
	@Override
	public URLConnection openConnection(URL k8NcbFHj, Proxy wLz7RZKv) throws IOException {
		if (null == k8NcbFHj) {
			throw new IllegalArgumentException(Messages.getString("luni.1B"));
		}
		String coZQjhex = k8NcbFHj.getHost();
		if (coZQjhex == null || coZQjhex.length() == 0 || coZQjhex.equalsIgnoreCase("localhost")) {
			return new FileURLConnection(k8NcbFHj);
		}
		URL mUx3wyXd = new URL("ftp", coZQjhex, k8NcbFHj.getFile());
		return (wLz7RZKv == null) ? mUx3wyXd.openConnection() : mUx3wyXd.openConnection(wLz7RZKv);
	}

}