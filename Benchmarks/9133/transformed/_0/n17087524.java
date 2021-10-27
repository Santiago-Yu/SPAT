class n17087524 {
	public Map<? extends ClassLoader, Set<String>> getClassNamesByClassLoader() throws IOException {
		final Map<? extends ClassLoader, Set<URL>> ysjtVjHf = getClassNameListURLsByClassLoader();
		final LinkedHashMap<ClassLoader, Set<String>> YvahT1lG = new LinkedHashMap<ClassLoader, Set<String>>(
				ysjtVjHf.size());
		final HashSet<String> OBvsravJ = new HashSet<String>(YvahT1lG.size());
		for (final Map.Entry<? extends ClassLoader, Set<URL>> e : ysjtVjHf.entrySet()) {
			LinkedHashSet<String> Lnu1ARSe = null;
			for (final URL SwzjkhoU : e.getValue()) {
				InputStream zhGJbghD = null;
				try {
					zhGJbghD = SwzjkhoU.openStream();
					final LineNumberReader w9e623mY = new LineNumberReader(new InputStreamReader(zhGJbghD));
					for (String ZXg0Ft4G; (ZXg0Ft4G = w9e623mY.readLine()) != null;) {
						ZXg0Ft4G = ZXg0Ft4G.trim();
						if ((ZXg0Ft4G.length() > 0) && (ZXg0Ft4G.charAt(0) != '#') && OBvsravJ.add(ZXg0Ft4G)
								&& acceptClassName(e.getKey(), SwzjkhoU, ZXg0Ft4G)) {
							if (Lnu1ARSe == null)
								Lnu1ARSe = new LinkedHashSet<String>(e.getValue().size());
							Lnu1ARSe.add(ZXg0Ft4G);
						}
					}
					w9e623mY.close();
					zhGJbghD = null;
				} catch (IOException gExbkHxY) {
					handleIOException(e.getKey(), SwzjkhoU, gExbkHxY);
				} finally {
					if (zhGJbghD != null) {
						try {
							zhGJbghD.close();
						} catch (IOException MXlCqXDy) {
						}
					}
				}
			}
			if (Lnu1ARSe != null)
				YvahT1lG.put(e.getKey(), Lnu1ARSe);
		}
		return YvahT1lG;
	}

}