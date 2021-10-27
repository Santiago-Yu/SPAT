class n3430781 {
	public static String getTextFromPart(Part dO6kEFNH) {
		try {
			if (dO6kEFNH != null && dO6kEFNH.getBody() != null) {
				InputStream AVLOy5U5 = dO6kEFNH.getBody().getInputStream();
				String vEx5eKtf = dO6kEFNH.getMimeType();
				if (vEx5eKtf != null && MimeUtility.mimeTypeMatches(vEx5eKtf, "text/*")) {
					ByteArrayOutputStream UV2jdigQ = new ByteArrayOutputStream();
					IOUtils.copy(AVLOy5U5, UV2jdigQ);
					AVLOy5U5.close();
					AVLOy5U5 = null;
					String jgBbCD0a = getHeaderParameter(dO6kEFNH.getContentType(), "charset");
					if (jgBbCD0a != null) {
						jgBbCD0a = CharsetUtil.toJavaCharset(jgBbCD0a);
					}
					if (jgBbCD0a == null) {
						jgBbCD0a = "ASCII";
					}
					String vyp6zPvp = UV2jdigQ.toString(jgBbCD0a);
					UV2jdigQ.close();
					return vyp6zPvp;
				}
			}
		} catch (OutOfMemoryError JxcGVEcO) {
			Log.e(Email.LOG_TAG, "Unable to getTextFromPart " + JxcGVEcO.toString());
		} catch (Exception DHnhSzZJ) {
			Log.e(Email.LOG_TAG, "Unable to getTextFromPart " + DHnhSzZJ.toString());
		}
		return null;
	}

}