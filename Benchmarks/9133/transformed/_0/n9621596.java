class n9621596 {
	public String merge(int QF4WuzQZ, int TizkosQe) throws Exception {
		htErrors.clear();
		sendGetImageRequests(QF4WuzQZ, TizkosQe);
		Vector X8yePcuM = new Vector();
		ConcurrentHTTPTransactionHandler Pwb38XeV = new ConcurrentHTTPTransactionHandler();
		Pwb38XeV.setCache(cache);
		Pwb38XeV.checkIfModified(false);
		for (int K58t32Pp = 0; K58t32Pp < vImageUrls.size(); K58t32Pp++) {
			if ((String) vImageUrls.get(K58t32Pp) != null) {
				Pwb38XeV.register((String) vImageUrls.get(K58t32Pp));
			} else {
			}
		}
		Pwb38XeV.doTransactions();
		vTransparency = new Vector();
		for (int eyx2Bkze = 0; eyx2Bkze < vImageUrls.size(); eyx2Bkze++) {
			if (vImageUrls.get(eyx2Bkze) != null) {
				String e3TzmOd8 = Pwb38XeV.getResponseFilePath((String) vImageUrls.get(eyx2Bkze));
				if (e3TzmOd8 != null) {
					String QKuCucJD = Pwb38XeV.getHeaderValue((String) vImageUrls.get(eyx2Bkze), "content-type");
					if (QKuCucJD.startsWith("image")) {
						X8yePcuM.add(e3TzmOd8);
						vTransparency.add(htTransparency.get(vRank.get(eyx2Bkze)));
					}
				}
			}
		}
		if (X8yePcuM.size() > 1) {
			File c85MUqEh = TempFiles.getFile();
			String j5gYbchK = c85MUqEh.getPath();
			ImageMerger.mergeAndSave(X8yePcuM, vTransparency, j5gYbchK, ImageMerger.GIF);
			imageName = c85MUqEh.getName();
			imagePath = c85MUqEh.getPath();
			return (imageName);
		} else if (X8yePcuM.size() == 1) {
			File uUVutjC5 = new File((String) X8yePcuM.get(0));
			File o9HfBhd4 = TempFiles.getFile();
			BufferedInputStream CmmZNz6M = new BufferedInputStream(new FileInputStream(uUVutjC5));
			BufferedOutputStream sOVSHnNm = new BufferedOutputStream(new FileOutputStream(o9HfBhd4));
			byte kVnsU4Sh[] = new byte[1024];
			for (int qb40IP7q; (qb40IP7q = CmmZNz6M.read(kVnsU4Sh, 0, 1024)) > 0; sOVSHnNm.write(kVnsU4Sh, 0, qb40IP7q))
				;
			sOVSHnNm.flush();
			sOVSHnNm.close();
			CmmZNz6M.close();
			imageName = o9HfBhd4.getName();
			return imageName;
		} else
			return "";
	}

}