class n7669917 {
	public void insertStringInFile(String file, String textToInsert, long fromByte, long toByte) throws Exception {
		BufferedInputStream in = null;
		String tmpFile = file + ".tmp";
		long byteCount = 0;
		BufferedOutputStream out = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(tmpFile));
			in = new BufferedInputStream(new FileInputStream(new File(file)));
			byte[] buf = null;
			long size = fromByte;
			if (size == 0) {
			} else {
				int length = -1;
				buf = new byte[(int) size];
				if ((length = in.read(buf)) != -1) {
					out.write(buf, 0, length);
					byteCount = byteCount + length;
				} else {
					String msg = "Failed to read the first '" + size + "' bytes of file '" + file
							+ "'. This might be a programming error.";
					logger.warning(msg);
					throw new Exception(msg);
				}
			}
			buf = textToInsert.getBytes();
			int length = buf.length;
			out.write(buf, 0, length);
			long skipLength = toByte - fromByte;
			byteCount = byteCount + length;
			long skippedBytes = in.skip(skipLength);
			if (skippedBytes == -1) {
			} else {
				length = -1;
				buf = new byte[4096];
				while ((length = in.read(buf)) != -1) {
					out.write(buf, 0, length);
					byteCount = byteCount + length;
				}
			}
			in.close();
			in = null;
			out.close();
			File fileToDelete = new File(file);
			out = null;
			boolean wasDeleted = fileToDelete.delete();
			File fileToRename = new File(tmpFile);
			if (!wasDeleted) {
				String msg = "Failed to delete the original file '" + file
						+ "' to replace it with the modified file after text insertion.";
				logger.warning(msg);
				throw new Exception(msg);
			}
			boolean wasRenamed = fileToRename.renameTo(fileToDelete);
			if (!wasRenamed) {
				String msg = "Failed to rename tmp file '" + tmpFile + "' to the name of the original file '" + file
						+ "'";
				logger.warning(msg);
				throw new Exception(msg);
			}
		} catch (Exception e) {
			logger.log(Level.WARNING, "Failed to read/write file '" + file + "'.", e);
			throw e;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					logger.log(Level.FINEST, "Ignoring error closing input file '" + file + "'.", e);
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					logger.log(Level.FINEST, "Ignoring error closing output file '" + tmpFile + "'.", e);
				}
			}
		}
	}

}