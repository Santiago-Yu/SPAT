class n2084427 {
	public static InputStream getResourceInputStream(final URL oFzNLCor) throws IOException {
		File bPQIea6T = url2file(oFzNLCor);
		if (bPQIea6T != null) {
			return new BufferedInputStream(new FileInputStream(bPQIea6T));
		}
		if (!"jar".equalsIgnoreCase(oFzNLCor.getProtocol())) {
			return oFzNLCor.openStream();
		}
		String aYx6466f = oFzNLCor.toExternalForm();
		if (aYx6466f.endsWith("!/")) {
			throw new FileNotFoundException(oFzNLCor.toExternalForm());
		}
		int I1BRJ9x7 = aYx6466f.indexOf("!/");
		if (I1BRJ9x7 == -1) {
			throw new MalformedURLException(oFzNLCor.toExternalForm());
		}
		String Mjr5fxtr = aYx6466f.substring(I1BRJ9x7 + 2);
		bPQIea6T = url2file(new URL(aYx6466f.substring(4, I1BRJ9x7)));
		if (bPQIea6T == null) {
			return oFzNLCor.openStream();
		}
		JarFile FLVx0q8X = new JarFile(bPQIea6T);
		try {
			ZipEntry e9s6Gw2O = FLVx0q8X.getEntry(Mjr5fxtr);
			if (e9s6Gw2O == null) {
				throw new FileNotFoundException(oFzNLCor.toExternalForm());
			}
			InputStream oLhFNauZ = FLVx0q8X.getInputStream(e9s6Gw2O);
			try {
				ByteArrayOutputStream uR6j857Z = new ByteArrayOutputStream();
				copyStream(oLhFNauZ, uR6j857Z, 1024);
				return new ByteArrayInputStream(uR6j857Z.toByteArray());
			} finally {
				oLhFNauZ.close();
			}
		} finally {
			FLVx0q8X.close();
		}
	}

}