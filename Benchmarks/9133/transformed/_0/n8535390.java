class n8535390 {
	public static File doRequestPost(URL eGyBJ2kh, String QgdxHaub, String cIVcKqpS, boolean FePuumvN)
			throws ArcImsException {
		File Es7yQnCu = null;
		URL qH4Ccwea = getVirtualRequestUrlFromUrlAndRequest(eGyBJ2kh, QgdxHaub);
		if ((Es7yQnCu = getPreviousDownloadedURL(qH4Ccwea, FePuumvN)) == null) {
			File skVt63Kv = new File(tempDirectoryPath);
			if (!skVt63Kv.exists()) {
				skVt63Kv.mkdir();
			}
			String TDzyKyaS = normalizeFileName(cIVcKqpS);
			Es7yQnCu = new File(tempDirectoryPath + "/" + TDzyKyaS);
			Es7yQnCu.deleteOnExit();
			logger.info("downloading '" + eGyBJ2kh.toString() + "' to: " + Es7yQnCu.getAbsolutePath());
			try {
				HttpURLConnection rywfWnrQ = (HttpURLConnection) eGyBJ2kh.openConnection();
				rywfWnrQ.setDoOutput(true);
				rywfWnrQ.setRequestMethod("POST");
				rywfWnrQ.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
				rywfWnrQ.setRequestProperty("Content-length", "" + QgdxHaub.length());
				OutputStreamWriter rs5Dlxjp = new OutputStreamWriter(rywfWnrQ.getOutputStream());
				rs5Dlxjp.write(QgdxHaub);
				rs5Dlxjp.flush();
				DataOutputStream m1d3ElHT = new DataOutputStream(
						new BufferedOutputStream(new FileOutputStream(Es7yQnCu)));
				byte[] h6DxIeHl = new byte[1024 * 256];
				InputStream w9NweRuE = rywfWnrQ.getInputStream();
				long FSGr81DQ = 0;
				for (int PQ7vMfM8 = w9NweRuE.read(h6DxIeHl); PQ7vMfM8 > 0; PQ7vMfM8 = w9NweRuE.read(h6DxIeHl)) {
					m1d3ElHT.write(h6DxIeHl, 0, PQ7vMfM8);
					FSGr81DQ += PQ7vMfM8;
				}
				m1d3ElHT.close();
				w9NweRuE.close();
				rs5Dlxjp.close();
				addDownloadedURL(qH4Ccwea, Es7yQnCu.getAbsolutePath());
			} catch (ConnectException CzXtUTsf) {
				logger.error("Timed out error", CzXtUTsf);
				throw new ArcImsException("arcims_server_timeout");
			} catch (FileNotFoundException FeVyZeFI) {
				logger.error("FileNotFound Error", FeVyZeFI);
				throw new ArcImsException("arcims_server_error");
			} catch (IOException IXZbR5Bi) {
				logger.error("IO Error", IXZbR5Bi);
				throw new ArcImsException("arcims_server_error");
			}
		}
		if (!Es7yQnCu.exists()) {
			downloadedFiles.remove(qH4Ccwea);
			Es7yQnCu = doRequestPost(eGyBJ2kh, QgdxHaub, cIVcKqpS, FePuumvN);
		}
		return Es7yQnCu;
	}

}