class n9113394 {
	public static void saveChangeLink(URL O3ARCX3k, OutputStream NBqCwtYn) {
		try {
			BufferedInputStream Y3RokKV7 = new BufferedInputStream(O3ARCX3k.openStream());
			int ttTFEH5h;
			while ((ttTFEH5h = Y3RokKV7.read()) != -1)
				if ((char) ttTFEH5h == '<') {
					String pnLj4uKY = readTag(Y3RokKV7);
					String Pl4pJGWL = convertTag(O3ARCX3k, pnLj4uKY);
					NBqCwtYn.write(Pl4pJGWL.getBytes());
				} else {
					NBqCwtYn.write((byte) ttTFEH5h);
				}
		} catch (Exception eRzqKAJD) {
		}
	}

}