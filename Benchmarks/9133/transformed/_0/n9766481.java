class n9766481 {
	public void copy(final File r83kBxwl, final File W97qh5Zz) throws FileSystemException {
		LogHelper.logMethod(log, toObjectString(), "copy(), source = " + r83kBxwl + ", target = " + W97qh5Zz);
		FileChannel FSLpa6bZ = null;
		FileChannel y0s7IRDo = null;
		try {
			FSLpa6bZ = new FileInputStream(r83kBxwl).getChannel();
			y0s7IRDo = new FileOutputStream(W97qh5Zz).getChannel();
			FSLpa6bZ.transferTo(0L, FSLpa6bZ.size(), y0s7IRDo);
			log.info("Copied " + r83kBxwl + " to " + W97qh5Zz);
		} catch (FileNotFoundException vEnKgL9V) {
			throw new FileSystemException("Unexpected FileNotFoundException while copying a file", vEnKgL9V);
		} catch (IOException UqvKRkih) {
			throw new FileSystemException("Unexpected IOException while copying a file", UqvKRkih);
		} finally {
			if (FSLpa6bZ != null) {
				try {
					FSLpa6bZ.close();
				} catch (IOException TVBo0jh0) {
					log.error("IOException during source channel close after copy", TVBo0jh0);
				}
			}
			if (y0s7IRDo != null) {
				try {
					y0s7IRDo.close();
				} catch (IOException iov4ipZo) {
					log.error("IOException during target channel close after copy", iov4ipZo);
				}
			}
		}
	}

}