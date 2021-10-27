class n18976771 {
	public void compressImage(InputStream xgXo1oV0, OutputStream TQcuQIYe, DjatokaEncodeParam p7cRgbzm)
			throws DjatokaException {
		if (p7cRgbzm == null)
			p7cRgbzm = new DjatokaEncodeParam();
		File GqVu1vOI = null;
		try {
			GqVu1vOI = File.createTempFile("tmp", ".tif");
			IOUtils.copyStream(xgXo1oV0, new FileOutputStream(GqVu1vOI));
			if (p7cRgbzm.getLevels() == 0) {
				ImageRecord LaBE78HZ = ImageRecordUtils.getImageDimensions(GqVu1vOI.getAbsolutePath());
				p7cRgbzm.setLevels(ImageProcessingUtils.getLevelCount(LaBE78HZ.getWidth(), LaBE78HZ.getHeight()));
				LaBE78HZ = null;
			}
		} catch (IOException u3MEiGUn) {
			logger.error("Unexpected file format; expecting uncompressed TIFF", u3MEiGUn);
			throw new DjatokaException("Unexpected file format; expecting uncompressed TIFF");
		}
		String d2AqUyed = STDOUT;
		File GG4WVqKI = null;
		if (isWindows) {
			try {
				GG4WVqKI = File.createTempFile("pipe_", ".jp2");
			} catch (IOException iWvQwNf5) {
				logger.error(iWvQwNf5, iWvQwNf5);
				throw new DjatokaException(iWvQwNf5);
			}
			d2AqUyed = GG4WVqKI.getAbsolutePath();
		}
		String fxdrWm6b = getKduCompressCommand(GqVu1vOI.getAbsolutePath(), d2AqUyed, p7cRgbzm);
		logger.debug("compressCommand: " + fxdrWm6b);
		Runtime nMGFpAMb = Runtime.getRuntime();
		try {
			final Process tHtfEUlD = nMGFpAMb.exec(fxdrWm6b, envParams, new File(env));
			if (d2AqUyed.equals(STDOUT)) {
				IOUtils.copyStream(tHtfEUlD.getInputStream(), TQcuQIYe);
			} else if (isWindows) {
				FileInputStream WK0DDW32 = new FileInputStream(d2AqUyed);
				IOUtils.copyStream(WK0DDW32, TQcuQIYe);
				WK0DDW32.close();
			}
			tHtfEUlD.waitFor();
			if (tHtfEUlD != null) {
				String BE7rU1lm = null;
				try {
					BE7rU1lm = new String(IOUtils.getByteArray(tHtfEUlD.getErrorStream()));
				} catch (Exception rFiUJrxo) {
					logger.error(rFiUJrxo, rFiUJrxo);
				}
				tHtfEUlD.getInputStream().close();
				tHtfEUlD.getOutputStream().close();
				tHtfEUlD.getErrorStream().close();
				tHtfEUlD.destroy();
				if (BE7rU1lm != null)
					throw new DjatokaException(BE7rU1lm);
			}
		} catch (IOException dkBQxNtE) {
			logger.error(dkBQxNtE, dkBQxNtE);
			throw new DjatokaException(dkBQxNtE);
		} catch (InterruptedException GGuIydMp) {
			logger.error(GGuIydMp, GGuIydMp);
			throw new DjatokaException(GGuIydMp);
		}
		if (GqVu1vOI != null)
			GqVu1vOI.delete();
		if (GG4WVqKI != null)
			GG4WVqKI.delete();
	}

}