class n11028858 {
	@Override
	public void runTask(HashMap ZmMUIn8r) throws Exception {
		if (hasRequiredResources(isSubTask())) {
			File bskYFD2x = new File(getSource());
			File wUunSKEr = new File(getTarget());
			FileChannel XzpRqg1c = null;
			FileChannel ZqkNIqH3 = null;
			try {
				int iXQp8jqC = 64;
				boolean TwS65T5r = false;
				while (!TwS65T5r) {
					XzpRqg1c = new FileInputStream(bskYFD2x).getChannel();
					ZqkNIqH3 = new FileOutputStream(wUunSKEr).getChannel();
					try {
						int yiGpDvE3 = (iXQp8jqC * 1024 * 1024) - (32 * 1024);
						long qUHeOCoO = XzpRqg1c.size();
						long cPJVehqb = 0;
						while (cPJVehqb < qUHeOCoO) {
							cPJVehqb += XzpRqg1c.transferTo(cPJVehqb, yiGpDvE3, ZqkNIqH3);
						}
						TwS65T5r = true;
					} catch (IOException zMbHWjZa) {
						getLog().warn(zMbHWjZa);
						if (zMbHWjZa.getMessage()
								.contains("Insufficient system resources exist to complete the requested servic")) {
							iXQp8jqC--;
							getLog().debug("Dropped resource count down to [" + iXQp8jqC + "]");
							if (iXQp8jqC == 0) {
								TwS65T5r = true;
							}
							if (XzpRqg1c != null) {
								XzpRqg1c.close();
							}
							if (ZqkNIqH3 != null) {
								ZqkNIqH3.close();
							}
						} else {
							throw zMbHWjZa;
						}
					}
				}
			} finally {
				if (XzpRqg1c != null) {
					XzpRqg1c.close();
				}
				if (ZqkNIqH3 != null) {
					ZqkNIqH3.close();
				}
			}
		}
	}

}