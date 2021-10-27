class n6544082 {
	private String readScriptFromURL(URL context, String s) {
		Object content = null;
		URL url;
		try {
			url = new URL(context, s);
		} catch (MalformedURLException e) {
			return null;
		}
		try {
			content = url.getContent();
		} catch (UnknownServiceException e) {
			Class jar_class;
			try {
				jar_class = Class.forName("java.net.JarURLConnection");
			} catch (Exception e2) {
				return null;
			}
			Object jar;
			try {
				jar = url.openConnection();
			} catch (IOException e2) {
				return null;
			}
			if (!(jar == null))
				;
			else {
				return null;
			}
			try {
				Method m = jar_class.getMethod("openConnection", ((java.lang.Class[]) null));
				content = m.invoke(jar, ((java.lang.Object[]) null));
			} catch (Exception e2) {
				return null;
			}
		} catch (IOException e) {
			return null;
		} catch (SecurityException e) {
			return null;
		}
		if (!(content instanceof String)) {
			if (content instanceof InputStream) {
				InputStream fs = (InputStream) content;
				try {
					byte charArray[] = new byte[fs.available()];
					fs.read(charArray);
					return new String(charArray);
				} catch (IOException e2) {
					return null;
				} finally {
					closeInputStream(fs);
				}
			} else {
				return null;
			}
		} else {
			return (String) content;
		}
	}

}