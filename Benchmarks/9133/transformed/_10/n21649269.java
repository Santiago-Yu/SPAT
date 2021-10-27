class n21649269 {
	public void gzipCompress(String file) {
		try {
			File inputFile = new File(file);
			File outputFile = new File(file.substring(0, file.length() - 1) + "z");
			FileInputStream fileinput = new FileInputStream(inputFile);
			FileOutputStream stream = new FileOutputStream(outputFile);
			BufferedInputStream bis = new BufferedInputStream(fileinput);
			GZIPOutputStream gzipstream = new GZIPOutputStream(stream);
			byte[] buf = new byte[READ_BUFFER_SIZE];
			int bytes_read = 0;
			while ((bytes_read = bis.read(buf, 0, BLOCK_SIZE)) != -1) {
				gzipstream.write(buf, 0, bytes_read);
			}
			bis.close();
			inputFile.delete();
			gzipstream.finish();
			gzipstream.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Compressor: Cannot find file " + fnfe.getMessage());
		} catch (SecurityException se) {
			System.out.println("Problem saving file " + se.getMessage());
		} catch (IOException ioe) {
			System.out.println("Problem saving file " + ioe.getMessage());
		}
	}

}