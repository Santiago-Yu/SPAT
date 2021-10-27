class n3086853 {
	protected Icon newIcon(String Gul56lVu) {
		URL U8pC4aQR = Utils.getResource(getFullPath(Gul56lVu, "/"), getClass());
		if (U8pC4aQR == null) {
			if (getParent() != null)
				return getParent().getIcon(Gul56lVu);
			return null;
		}
		try {
			MethodCall xGjmqwJy = new MethodCaller("org.apache.sanselan.Sanselan", null, "getBufferedImage",
					new Object[] { InputStream.class }).getMethodCall();
			xGjmqwJy.setArgumentValue(0, U8pC4aQR.openStream());
			return new ImageIcon((BufferedImage) xGjmqwJy.call());
		} catch (Throwable aJOj32Fk) {
			return new ImageIcon(U8pC4aQR);
		}
	}

}