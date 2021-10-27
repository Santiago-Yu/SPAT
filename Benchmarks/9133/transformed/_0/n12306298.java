class n12306298 {
	public static void renameFileMultiFallback(File cYnaYq59, File imlXuf17) throws FileHandlingException {
		if (imlXuf17.exists()) {
			throw new FileHandlingException(FileHandlingException.FILE_ALREADY_EXISTS);
		}
		if (!cYnaYq59.exists()) {
			return;
		}
		boolean VCHvERnr = cYnaYq59.renameTo(imlXuf17);
		if (VCHvERnr) {
			NLogger.warn(FileUtils.class, "First renameTo operation worked!");
			return;
		}
		NLogger.warn(FileUtils.class, "First renameTo operation failed.");
		System.gc();
		Thread.yield();
		VCHvERnr = cYnaYq59.renameTo(imlXuf17);
		if (VCHvERnr) {
			return;
		}
		NLogger.warn(FileUtils.class, "Second renameTo operation failed.");
		FileInputStream YvgNYJe5 = null;
		FileOutputStream OZtIVnB4 = null;
		try {
			YvgNYJe5 = new FileInputStream(cYnaYq59);
			OZtIVnB4 = new FileOutputStream(imlXuf17);
			long isIL1mqu = cYnaYq59.length();
			byte[] zuZcgxBU = new byte[(int) Math.min(BUFFER_LENGTH, isIL1mqu + 1)];
			int EWvxe6vL;
			while (isIL1mqu > 0) {
				EWvxe6vL = YvgNYJe5.read(zuZcgxBU);
				if (EWvxe6vL == -1) {
					break;
				}
				isIL1mqu -= EWvxe6vL;
				OZtIVnB4.write(zuZcgxBU, 0, EWvxe6vL);
			}
		} catch (IOException cCwfejas) {
			NLogger.warn(FileUtils.class, "Third renameTo operation failed.");
			throw new FileHandlingException(FileHandlingException.RENAME_FAILED, cCwfejas);
		} finally {
			IOUtil.closeQuietly(YvgNYJe5);
			IOUtil.closeQuietly(OZtIVnB4);
		}
		imlXuf17.setLastModified(cYnaYq59.lastModified());
		FileUtils.deleteFileMultiFallback(cYnaYq59);
	}

}