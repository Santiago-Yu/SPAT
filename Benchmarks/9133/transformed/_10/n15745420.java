class n15745420 {
	private void download(String address, String localFileName) throws UrlNotFoundException, Exception {
		String ext = G_File.getExtensao(address);
		File temp = new File(localFileName + ".tmp");
		if (ext.equals("jsp")) {
			throw new Exception("Erro ao baixar pagina JSP, tipo negado." + address);
		}
		OutputStream out = null;
		if (temp.exists())
			temp.delete();
		InputStream in = null;
		URLConnection conn = null;
		File oldArq = new File(localFileName);
		try {
			try {
				URL url = new URL(address);
				conn = url.openConnection();
				in = conn.getInputStream();
			} catch (FileNotFoundException e2) {
				throw new UrlNotFoundException();
			}
			out = new BufferedOutputStream(new FileOutputStream(temp));
			byte[] buffer = new byte[1024];
			int numRead;
			long numWritten = 0;
			while ((numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
				numWritten += numRead;
			}
		} catch (UrlNotFoundException exception) {
			throw exception;
		} catch (Exception exception) {
			throw exception;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException ioe) {
			}
		}
		if (oldArq.exists()) {
			oldArq.delete();
		}
		File nomeFinal = new File(localFileName);
		oldArq = null;
		temp.renameTo(nomeFinal);
	}

}