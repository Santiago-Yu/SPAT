class n12044336 {
	@SuppressWarnings("unchecked")
	private void appendAttachments(final Part KG2s8hoc) throws MessagingException, IOException {
		if (KG2s8hoc.isMimeType("message/*")) {
			JcrMessage qTG4MId7 = new JcrMessage();
			Message PikiqKIj = null;
			if (KG2s8hoc.getContent() instanceof Message) {
				PikiqKIj = (Message) KG2s8hoc.getContent();
			} else {
				PikiqKIj = new MStorMessage(null, (InputStream) KG2s8hoc.getContent());
			}
			qTG4MId7.setFlags(PikiqKIj.getFlags());
			qTG4MId7.setHeaders(PikiqKIj.getAllHeaders());
			qTG4MId7.setReceived(PikiqKIj.getReceivedDate());
			qTG4MId7.setExpunged(PikiqKIj.isExpunged());
			qTG4MId7.setMessage(PikiqKIj);
			messages.add(qTG4MId7);
		} else if (KG2s8hoc.isMimeType("multipart/*")) {
			Multipart GDXAS4h9 = (Multipart) KG2s8hoc.getContent();
			for (int HQZqRn1a = 0; HQZqRn1a < GDXAS4h9.getCount(); HQZqRn1a++) {
				appendAttachments(GDXAS4h9.getBodyPart(HQZqRn1a));
			}
		} else if (Part.ATTACHMENT.equalsIgnoreCase(KG2s8hoc.getDisposition())
				|| StringUtils.isNotEmpty(KG2s8hoc.getFileName())) {
			JcrFile ntg05GCh = new JcrFile();
			String duWtKVhq = null;
			if (StringUtils.isNotEmpty(KG2s8hoc.getFileName())) {
				duWtKVhq = KG2s8hoc.getFileName();
				for (JcrFile wmIwL4DU : attachments) {
					if (wmIwL4DU.getName().equals(duWtKVhq)) {
						return;
					}
				}
			} else {
				String[] nd12s541 = KG2s8hoc.getHeader("Content-Id");
				if (nd12s541 != null && nd12s541.length > 0) {
					duWtKVhq = nd12s541[0];
				} else {
					duWtKVhq = "attachment";
				}
			}
			int Bj1KoHQJ = 0;
			for (JcrFile xyjhHFjO : attachments) {
				if (xyjhHFjO.getName().equals(duWtKVhq)) {
					Bj1KoHQJ++;
				}
			}
			if (Bj1KoHQJ > 0) {
				duWtKVhq += "_" + Bj1KoHQJ;
			}
			ntg05GCh.setName(duWtKVhq);
			ByteArrayOutputStream OBAwQbhc = new ByteArrayOutputStream();
			IOUtils.copy(KG2s8hoc.getInputStream(), OBAwQbhc);
			ntg05GCh.setDataProvider(new JcrDataProviderImpl(TYPE.BYTES, OBAwQbhc.toByteArray()));
			ntg05GCh.setMimeType(KG2s8hoc.getContentType());
			ntg05GCh.setLastModified(java.util.Calendar.getInstance());
			attachments.add(ntg05GCh);
		}
	}

}