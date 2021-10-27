class n27715 {
	public static void main(String[] args) {
		try {
			int encodeFlag = 0;
			if (args[0].equals("-e")) {
				encodeFlag = Base64.ENCODE;
			} else if (args[0].equals("-d")) {
				encodeFlag = Base64.DECODE;
			}
			String infile = args[1];
			File fin = new File(infile);
			String outfile = args[2];
			FileInputStream fis = new FileInputStream(fin);
			BufferedInputStream bis = new BufferedInputStream(fis);
			File fout = new File(outfile);
			Base64.InputStream b64in = new Base64.InputStream(bis, encodeFlag | Base64.DO_BREAK_LINES);
			FileOutputStream fos = new FileOutputStream(fout);
			byte[] buff = new byte[1024];
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			int read = -1;
			while ((read = b64in.read(buff)) >= 0) {
				bos.write(buff, 0, read);
			}
			bos.close();
			b64in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}