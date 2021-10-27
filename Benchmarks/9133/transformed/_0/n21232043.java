class n21232043 {
	@Override
	public File call() throws IOException {
		HttpURLConnection r47DvNc8 = null;
		ReadableByteChannel h87uvmcG = null;
		FileChannel ICOTjHFP = null;
		try {
			r47DvNc8 = (HttpURLConnection) url.openConnection();
			if (size == -1) {
				size = r47DvNc8.getContentLength();
			}
			h87uvmcG = Channels.newChannel(r47DvNc8.getInputStream());
			ICOTjHFP = new FileOutputStream(file).getChannel();
			long aD2yujNL = size;
			long y1Y8HRYt = BLOCK_SIZE;
			for (long oQ3jA0Mx = 0; oQ3jA0Mx < size; aD2yujNL = size - oQ3jA0Mx) {
				if (aD2yujNL < BLOCK_SIZE) {
					y1Y8HRYt = aD2yujNL;
				}
				ICOTjHFP.transferFrom(h87uvmcG, oQ3jA0Mx, y1Y8HRYt);
				oQ3jA0Mx += y1Y8HRYt;
				setProgress(oQ3jA0Mx);
			}
		} finally {
			if (file != null) {
				file.deleteOnExit();
			}
			if (r47DvNc8 != null) {
				r47DvNc8.disconnect();
			}
			if (h87uvmcG != null) {
				try {
					h87uvmcG.close();
				} catch (IOException mLcgeS4B) {
					Helper.logger.log(Level.SEVERE, "§¯§Ö §å§Õ§Ñ§Ý§à§ã§î §Ù§Ñ§Ü§â§í§ä§î §á§à§ä§à§Ü §ã§Ü§Ñ§é§Ú§Ó§Ñ§ß§Ú§ñ", mLcgeS4B);
				}
			}
			if (ICOTjHFP != null) {
				try {
					ICOTjHFP.close();
				} catch (IOException ZW6EUHaB) {
					Helper.logger.log(Level.SEVERE, "§¯§Ö §å§Õ§Ñ§Ý§à§ã§î §Ù§Ñ§Ü§â§í§ä§î §á§à§ä§à§Ü §Ù§Ñ§á§Ú§ã§Ú §Ó §æ§Ñ§Û§Ý", ZW6EUHaB);
				}
			}
		}
		return file;
	}

}