class n20109501 {
	private void native2ascii(LanguageInfo info) {
		InputStream in = null;
		if (!info.isUTF8())
			throw new IllegalArgumentException("requires utf8 language.");
		OutputStream out = null;
		print("\tConverting to ASCII... ");
		try {
			in = new BufferedInputStream(new FileInputStream(info.getFileName()));
			in.mark(3);
			if (in.read() != 0xEF || in.read() != 0xBB || in.read() != 0xBF)
				in.reset();
			out = new BufferedOutputStream(new FileOutputStream(info.getAlternateFileName()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF8"));
			String read;
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "ISO-8859-1"));
			while ((read = reader.readLine()) != null) {
				writer.write(ascii(read));
				writer.newLine();
			}
			writer.flush();
			out.flush();
			println("... done!");
		} catch (IOException ignored) {
			println("... error! (" + ignored.getMessage() + ")");
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException ignored) {
				}
			if (out != null)
				try {
					out.close();
				} catch (IOException ignored) {
				}
		}
	}

}