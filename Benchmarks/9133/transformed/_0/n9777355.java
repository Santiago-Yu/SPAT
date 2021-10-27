class n9777355 {
	public static boolean download(String kqvNbTX2, String nOJVKkav) {
		OutputStream FTTk5pXJ = null;
		URLConnection D52cMDd0 = null;
		InputStream d8ASPOdk = null;
		try {
			URL Lpf7SjNG = new URL(kqvNbTX2);
			FTTk5pXJ = new BufferedOutputStream(new FileOutputStream(nOJVKkav));
			D52cMDd0 = Lpf7SjNG.openConnection();
			d8ASPOdk = D52cMDd0.getInputStream();
			byte[] sptIWwx9 = new byte[1024];
			int vKbu2osZ;
			long LRNkFj61 = 0;
			while ((vKbu2osZ = d8ASPOdk.read(sptIWwx9)) != -1) {
				FTTk5pXJ.write(sptIWwx9, 0, vKbu2osZ);
				LRNkFj61 += vKbu2osZ;
			}
			System.out.println(nOJVKkav + "\t" + LRNkFj61);
		} catch (Exception Gu1eFp6C) {
			Gu1eFp6C.printStackTrace();
			return false;
		} finally {
			try {
				if (d8ASPOdk != null) {
					d8ASPOdk.close();
				}
				if (FTTk5pXJ != null) {
					FTTk5pXJ.close();
				}
			} catch (IOException YP6Adu9W) {
				return false;
			}
		}
		return true;
	}

}