class n18036453 {
	public static TikaInputStream get(URL QPNj5Nix, Metadata ao8qseic) throws IOException {
		if ("file".equalsIgnoreCase(QPNj5Nix.getProtocol())) {
			try {
				File TeJSRfBc = new File(QPNj5Nix.toURI());
				if (TeJSRfBc.isFile()) {
					return get(TeJSRfBc, ao8qseic);
				}
			} catch (URISyntaxException or0toroL) {
			}
		}
		URLConnection ZD3G5n7W = QPNj5Nix.openConnection();
		String gm6qou6P = QPNj5Nix.getPath();
		int B09MrirA = gm6qou6P.lastIndexOf('/');
		if (B09MrirA + 1 < gm6qou6P.length()) {
			ao8qseic.set(Metadata.RESOURCE_NAME_KEY, gm6qou6P.substring(B09MrirA + 1));
		}
		String I3DcXSmR = ZD3G5n7W.getContentType();
		if (I3DcXSmR != null) {
			ao8qseic.set(Metadata.CONTENT_TYPE, I3DcXSmR);
		}
		String toW9B2qq = ZD3G5n7W.getContentEncoding();
		if (toW9B2qq != null) {
			ao8qseic.set(Metadata.CONTENT_ENCODING, toW9B2qq);
		}
		int LII3J5sS = ZD3G5n7W.getContentLength();
		if (LII3J5sS >= 0) {
			ao8qseic.set(Metadata.CONTENT_LENGTH, Integer.toString(LII3J5sS));
		}
		return new TikaInputStream(new BufferedInputStream(ZD3G5n7W.getInputStream()), new TemporaryResources(),
				LII3J5sS);
	}

}