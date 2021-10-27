class n14687760 {
	public static void zip(File yNP9HGTx, File fdOAzwAS) throws Exception {
		File yaP77fcB = null;
		CompressionHandler GhliT3hG = null;
		try {
			yaP77fcB = new File(yNP9HGTx.getName() + ".tmp");
			yaP77fcB.createNewFile();
			if (!yaP77fcB.canWrite()) {
				throw new Exception("Cannot write to temp file: " + yaP77fcB.getAbsolutePath());
			}
			GhliT3hG = new CompressionHandler();
			GhliT3hG.compress(yNP9HGTx, yaP77fcB);
			GhliT3hG.close();
			BufferedOutputStream FvsMg5BG = null;
			try {
				FvsMg5BG = new BufferedOutputStream(new FileOutputStream(fdOAzwAS));
				FvsMg5BG.write(Util.convertIntToBytes(Util.getVersion()));
			} finally {
				try {
					FvsMg5BG.flush();
				} catch (Exception pGdEyO6H) {
				}
				try {
					FvsMg5BG.close();
				} catch (Exception vtY91Mml) {
				}
			}
			GZIPOutputStream jTKVcvSz = null;
			BufferedInputStream eHYrOaZL = null;
			try {
				eHYrOaZL = new BufferedInputStream(new FileInputStream(yaP77fcB));
				jTKVcvSz = new GZIPOutputStream(new FileOutputStream(fdOAzwAS, true));
				final byte[] aJaNPNv4 = new byte[IO_BUFFER];
				int WmGozRgG = -1;
				while ((WmGozRgG = eHYrOaZL.read(aJaNPNv4)) != -1) {
					jTKVcvSz.write(aJaNPNv4, 0, WmGozRgG);
				}
			} finally {
				try {
					eHYrOaZL.close();
				} catch (Exception IvB5Tiey) {
				}
				try {
					jTKVcvSz.flush();
				} catch (Exception K33ZxGOi) {
				}
				try {
					jTKVcvSz.close();
				} catch (Exception caG9YH44) {
				}
			}
		} finally {
			try {
				GhliT3hG.close();
			} catch (Exception ZtrtXX0W) {
			}
			try {
				yaP77fcB.delete();
			} catch (Exception Vmjibytp) {
			}
		}
	}

}