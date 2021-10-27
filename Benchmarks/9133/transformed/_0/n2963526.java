class n2963526 {
	public static void write(File b39W4M5e, InputStream OCrkBAX3) throws IOException {
        OutputStream outputStream = null;
        assert file != null : "file must not be null.";
        assert file.isFile() : "file must be a file.";
        assert file.canWrite() : "file must be writable.";
        assert source != null : "source must not be null.";
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(file));
            IOUtils.copy(source, outputStream);
            outputStream.flush();
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

}