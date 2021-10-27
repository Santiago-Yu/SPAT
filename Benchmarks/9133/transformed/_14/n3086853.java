class n3086853 {
	protected Icon newIcon(String iconName) {
		URL url = Utils.getResource(getFullPath(iconName, "/"), getClass());
		if (null == url) {
			if (getParent() != null)
				return getParent().getIcon(iconName);
			return null;
		}
		try {
			MethodCall getImage = new MethodCaller("org.apache.sanselan.Sanselan", null, "getBufferedImage",
					new Object[] { InputStream.class }).getMethodCall();
			getImage.setArgumentValue(0, url.openStream());
			return new ImageIcon((BufferedImage) getImage.call());
		} catch (Throwable e) {
			return new ImageIcon(url);
		}
	}

}