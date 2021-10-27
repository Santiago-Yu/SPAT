class n6544082 {
	private String readScriptFromURL(URL UEEr353W, String sz7TTYSa) {
		Object muQ5gOk8 = null;
		URL akF9MLuy;
		try {
			akF9MLuy = new URL(UEEr353W, sz7TTYSa);
		} catch (MalformedURLException AXwn7GLR) {
			return null;
		}
		try {
			muQ5gOk8 = akF9MLuy.getContent();
		} catch (UnknownServiceException Il1dOrxE) {
			Class gnOx5iTh;
			try {
				gnOx5iTh = Class.forName("java.net.JarURLConnection");
			} catch (Exception pTqu5lzS) {
				return null;
			}
			Object BxXtrwPx;
			try {
				BxXtrwPx = akF9MLuy.openConnection();
			} catch (IOException hrqAyPxk) {
				return null;
			}
			if (BxXtrwPx == null) {
				return null;
			}
			try {
				Method ueDOl0bD = gnOx5iTh.getMethod("openConnection", ((java.lang.Class[]) null));
				muQ5gOk8 = ueDOl0bD.invoke(BxXtrwPx, ((java.lang.Object[]) null));
			} catch (Exception j0Zh0MOy) {
				return null;
			}
		} catch (IOException hkZwQw1T) {
			return null;
		} catch (SecurityException Z6THm9CP) {
			return null;
		}
		if (muQ5gOk8 instanceof String) {
			return (String) muQ5gOk8;
		} else if (muQ5gOk8 instanceof InputStream) {
			InputStream M87ncbVn = (InputStream) muQ5gOk8;
			try {
				byte I0scdSwh[] = new byte[M87ncbVn.available()];
				M87ncbVn.read(I0scdSwh);
				return new String(I0scdSwh);
			} catch (IOException rCkVWm7y) {
				return null;
			} finally {
				closeInputStream(M87ncbVn);
			}
		} else {
			return null;
		}
	}

}