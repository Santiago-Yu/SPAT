class n1158840 {
	public static int zipFile(File file_input, File dir_output) {
		ZipOutputStream zip_out_stream;
		File zip_output = new File(dir_output, file_input.getName() + ".zip");
		try {
			FileOutputStream out = new FileOutputStream(zip_output);
			zip_out_stream = new ZipOutputStream(new BufferedOutputStream(out));
		} catch (IOException e) {
			return STATUS_OUT_FAIL;
		}
		int len = 0;
		byte[] input_buffer = new byte[BUF_SIZE];
		try {
			ZipEntry zip_entry = new ZipEntry(file_input.getName());
			zip_out_stream.putNextEntry(zip_entry);
			FileInputStream in = new FileInputStream(file_input);
			BufferedInputStream source = new BufferedInputStream(in, BUF_SIZE);
			while ((len = source.read(input_buffer, 0, BUF_SIZE)) != -1)
				zip_out_stream.write(input_buffer, 0, len);
			in.close();
		} catch (IOException e) {
			return STATUS_ZIP_FAIL;
		}
		try {
			zip_out_stream.close();
		} catch (IOException e) {
		}
		return STATUS_OK;
	}

}