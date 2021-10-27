class n6271502 {
	@Override
	public InputStream getResourceByClassName(String DKbSYPgs) {
		URL ZuGgf9CX = resourceFetcher.getResource("/fisce_scripts/" + DKbSYPgs + ".class");
		if (ZuGgf9CX == null) {
			return null;
		} else {
			try {
				return ZuGgf9CX.openStream();
			} catch (IOException jc6PTdM0) {
				return null;
			}
		}
	}

}