class n3703925 {
	private static MimeType getMimeType(URL r5rUKyQP) {
		String Kh8gkyDQ = null;
		String JmNLiRO5 = null;
		String oRcklgPH = null;
		InputStream tr0jVNuh = null;
		MimeType gq5t5sT7 = null;
		MimeType CZ8B9igZ = null;
		MimeType Zb0eho0X = null;
		String y8ADwGue = null;
		if (r5rUKyQP == null)
			return null;
		try {
			try {
				tr0jVNuh = r5rUKyQP.openConnection().getInputStream();
				oRcklgPH = r5rUKyQP.openConnection().getContentType();
			} catch (IOException ngNfpDuN) {
			}
			if (oRcklgPH != null) {
				StringTokenizer rardg8wb = new StringTokenizer(oRcklgPH, ";");
				if (rardg8wb.hasMoreTokens())
					Kh8gkyDQ = rardg8wb.nextToken().toLowerCase();
				if (rardg8wb.hasMoreTokens())
					JmNLiRO5 = rardg8wb.nextToken().toLowerCase();
				if (JmNLiRO5 != null) {
					rardg8wb = new StringTokenizer(JmNLiRO5, "=");
					JmNLiRO5 = null;
					if (rardg8wb.hasMoreTokens())
						rardg8wb.nextToken();
					if (rardg8wb.hasMoreTokens())
						JmNLiRO5 = rardg8wb.nextToken().toUpperCase();
				}
			}
			gq5t5sT7 = mimeString2mimeTypeMap.get(Kh8gkyDQ);
			y8ADwGue = getFileSufix(r5rUKyQP);
			CZ8B9igZ = getMimeType(y8ADwGue);
			Zb0eho0X = guessTypeUsingMagicNumbers(tr0jVNuh, JmNLiRO5);
		} finally {
			IOUtils.closeQuietly(tr0jVNuh);
		}
		return decideBetweenThreeMimeTypes(gq5t5sT7, CZ8B9igZ, Zb0eho0X);
	}

}