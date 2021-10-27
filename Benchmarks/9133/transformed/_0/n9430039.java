class n9430039 {
	private void CopyTo(File l3GCBQr9) throws IOException {
		FileReader NZRCcXya = null;
		FileWriter HJW5buZQ = null;
		int YJvDVALH;
		try {
			NZRCcXya = new FileReader(image);
			HJW5buZQ = new FileWriter(l3GCBQr9);
			while ((YJvDVALH = NZRCcXya.read()) != -1)
				HJW5buZQ.write(YJvDVALH);
		} finally {
			if (NZRCcXya != null)
				try {
					NZRCcXya.close();
				} catch (Exception VHgW9Hma) {
				}
			if (HJW5buZQ != null)
				try {
					HJW5buZQ.close();
				} catch (Exception HiGFBwUY) {
				}
		}
	}

}