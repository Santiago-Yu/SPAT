class n14289588 {
	@Override
	public ResourceBundle newBundle(String HoYAS4aH, Locale kbKL5B2w, String yJp7ERZ5, ClassLoader jFqM8k6h,
			boolean VyUGJAbh) throws IllegalAccessException, InstantiationException, IOException {
		if ((HoYAS4aH == null) || (kbKL5B2w == null) || (yJp7ERZ5 == null) || (jFqM8k6h == null)) {
			throw new NullPointerException();
		}
		ResourceBundle dVWfIb38 = null;
		if (yJp7ERZ5.equals(XML)) {
			String eLIbG1zv = toBundleName(HoYAS4aH, kbKL5B2w);
			String MBgDBdQJ = toResourceName(eLIbG1zv, yJp7ERZ5);
			URL OwDR8NQr = jFqM8k6h.getResource(MBgDBdQJ);
			if (OwDR8NQr != null) {
				URLConnection g7XNvjI7 = OwDR8NQr.openConnection();
				if (g7XNvjI7 != null) {
					if (VyUGJAbh) {
						g7XNvjI7.setUseCaches(false);
					}
					InputStream JPBhavmo = g7XNvjI7.getInputStream();
					if (JPBhavmo != null) {
						BufferedInputStream sSzgZZrC = new BufferedInputStream(JPBhavmo);
						dVWfIb38 = new XMLResourceBundle(sSzgZZrC);
						sSzgZZrC.close();
					}
				}
			}
		}
		return dVWfIb38;
	}

}