class n15799935 {
	public static void saveAttachmentBody(Context Dc4aoXhj, Part K3Wq7GgF, Attachment gaPkLgfg, long LXy4VNaa)
			throws MessagingException, IOException {
		if (K3Wq7GgF.getBody() != null) {
			long RjkME1Wp = gaPkLgfg.mId;
			InputStream HwfyY48G = K3Wq7GgF.getBody().getInputStream();
			File x2lzoG14 = AttachmentProvider.getAttachmentDirectory(Dc4aoXhj, LXy4VNaa);
			if (!x2lzoG14.exists()) {
				x2lzoG14.mkdirs();
			}
			File mtl8xHWA = AttachmentProvider.getAttachmentFilename(Dc4aoXhj, LXy4VNaa, RjkME1Wp);
			mtl8xHWA.createNewFile();
			FileOutputStream fGT8QsQf = new FileOutputStream(mtl8xHWA);
			long GiNKxjPH = IOUtils.copy(HwfyY48G, fGT8QsQf);
			HwfyY48G.close();
			fGT8QsQf.close();
			String T7Rbdbif = AttachmentProvider.getAttachmentUri(LXy4VNaa, RjkME1Wp).toString();
			gaPkLgfg.mSize = GiNKxjPH;
			gaPkLgfg.mContentUri = T7Rbdbif;
			ContentValues oXtqx4kf = new ContentValues();
			oXtqx4kf.put(AttachmentColumns.SIZE, GiNKxjPH);
			oXtqx4kf.put(AttachmentColumns.CONTENT_URI, T7Rbdbif);
			Uri I7cF3Bom = ContentUris.withAppendedId(Attachment.CONTENT_URI, RjkME1Wp);
			Dc4aoXhj.getContentResolver().update(I7cF3Bom, oXtqx4kf, null, null);
		}
	}

}