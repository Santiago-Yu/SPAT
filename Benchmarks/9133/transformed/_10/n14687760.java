class n14687760 {
	public static void zip(File mzml, File zipDestination) throws Exception {
		CompressionHandler comp = null;
		File preCompressionTmp = null;
		try {
			preCompressionTmp = new File(mzml.getName() + ".tmp");
			preCompressionTmp.createNewFile();
			comp = new CompressionHandler();
			if (!preCompressionTmp.canWrite()) {
				throw new Exception("Cannot write to temp file: " + preCompressionTmp.getAbsolutePath());
			}
			comp.compress(mzml, preCompressionTmp);
			comp.close();
			BufferedOutputStream bos = null;
			GZIPOutputStream gos = null;
			try {
				bos = new BufferedOutputStream(new FileOutputStream(zipDestination));
				bos.write(Util.convertIntToBytes(Util.getVersion()));
			} finally {
				try {
					bos.flush();
				} catch (Exception nope) {
				}
				try {
					bos.close();
				} catch (Exception nope) {
				}
			}
			BufferedInputStream bis = null;
			try {
				gos = new GZIPOutputStream(new FileOutputStream(zipDestination, true));
				bis = new BufferedInputStream(new FileInputStream(preCompressionTmp));
				int read = -1;
				final byte[] buffer = new byte[IO_BUFFER];
				while ((read = bis.read(buffer)) != -1) {
					gos.write(buffer, 0, read);
				}
			} finally {
				try {
					bis.close();
				} catch (Exception nope) {
				}
				try {
					gos.flush();
				} catch (Exception nope) {
				}
				try {
					gos.close();
				} catch (Exception nope) {
				}
			}
		} finally {
			try {
				comp.close();
			} catch (Exception nope) {
			}
			try {
				preCompressionTmp.delete();
			} catch (Exception nope) {
			}
		}
	}

}