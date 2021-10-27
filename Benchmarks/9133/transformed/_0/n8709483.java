class n8709483 {
	private void saveAttachment(long nWBKwJXR, Part pQzKVnDA, boolean VatwF6xI) throws IOException, MessagingException {
		long cxWG4B9f = -1;
		Uri bsAI9HJR = null;
		int Gi1mr8JY = -1;
		File AlWNKcjn = null;
		if ((!VatwF6xI) && (pQzKVnDA instanceof LocalAttachmentBodyPart)) {
			cxWG4B9f = ((LocalAttachmentBodyPart) pQzKVnDA).getAttachmentId();
		}
		if (pQzKVnDA.getBody() != null) {
			Body M7omCXDt = pQzKVnDA.getBody();
			if (M7omCXDt instanceof LocalAttachmentBody) {
				bsAI9HJR = ((LocalAttachmentBody) M7omCXDt).getContentUri();
			} else {
				InputStream MNpkbUBi = pQzKVnDA.getBody().getInputStream();
				AlWNKcjn = File.createTempFile("att", null, mAttachmentsDir);
				FileOutputStream O7PGxubA = new FileOutputStream(AlWNKcjn);
				Gi1mr8JY = IOUtils.copy(MNpkbUBi, O7PGxubA);
				MNpkbUBi.close();
				O7PGxubA.close();
			}
		}
		if (Gi1mr8JY == -1) {
			String QBKpnmY1 = pQzKVnDA.getDisposition();
			if (QBKpnmY1 != null) {
				String weIC3PnL = MimeUtility.getHeaderParameter(QBKpnmY1, "size");
				if (weIC3PnL != null) {
					Gi1mr8JY = Integer.parseInt(weIC3PnL);
				}
			}
		}
		if (Gi1mr8JY == -1) {
			Gi1mr8JY = 0;
		}
		String fhQyedhH = Utility.combine(pQzKVnDA.getHeader(MimeHeader.HEADER_ANDROID_ATTACHMENT_STORE_DATA), ',');
		String B14vNMDy = MimeUtility.getHeaderParameter(pQzKVnDA.getContentType(), "name");
		String AjnzF4VL = pQzKVnDA.getContentId();
		if (cxWG4B9f == -1) {
			ContentValues OuAjd1cS = new ContentValues();
			OuAjd1cS.put("message_id", nWBKwJXR);
			OuAjd1cS.put("content_uri", bsAI9HJR != null ? bsAI9HJR.toString() : null);
			OuAjd1cS.put("store_data", fhQyedhH);
			OuAjd1cS.put("size", Gi1mr8JY);
			OuAjd1cS.put("name", B14vNMDy);
			OuAjd1cS.put("mime_type", pQzKVnDA.getMimeType());
			OuAjd1cS.put("content_id", AjnzF4VL);
			cxWG4B9f = mDb.insert("attachments", "message_id", OuAjd1cS);
		} else {
			ContentValues zx9Lf9jH = new ContentValues();
			zx9Lf9jH.put("content_uri", bsAI9HJR != null ? bsAI9HJR.toString() : null);
			zx9Lf9jH.put("size", Gi1mr8JY);
			zx9Lf9jH.put("content_id", AjnzF4VL);
			zx9Lf9jH.put("message_id", nWBKwJXR);
			mDb.update("attachments", zx9Lf9jH, "id = ?", new String[] { Long.toString(cxWG4B9f) });
		}
		if (AlWNKcjn != null) {
			File M3u0yZyM = new File(mAttachmentsDir, Long.toString(cxWG4B9f));
			AlWNKcjn.renameTo(M3u0yZyM);
			pQzKVnDA.setBody(new LocalAttachmentBody(bsAI9HJR, mContext));
			ContentValues rmO1euAv = new ContentValues();
			rmO1euAv.put("content_uri", bsAI9HJR != null ? bsAI9HJR.toString() : null);
			mDb.update("attachments", rmO1euAv, "id = ?", new String[] { Long.toString(cxWG4B9f) });
		}
		if (pQzKVnDA instanceof LocalAttachmentBodyPart) {
			((LocalAttachmentBodyPart) pQzKVnDA).setAttachmentId(cxWG4B9f);
		}
	}

}