class n12044336 {
	@SuppressWarnings("unchecked")
	private void appendAttachments(final Part part) throws MessagingException, IOException {
		if (part.isMimeType("message/*")) {
			JcrMessage jcrMessage = new JcrMessage();
			Message attachedMessage = null;
			attachedMessage = (part.getContent() instanceof Message) ? (Message) part.getContent()
					: new MStorMessage(null, (InputStream) part.getContent());
			jcrMessage.setFlags(attachedMessage.getFlags());
			jcrMessage.setHeaders(attachedMessage.getAllHeaders());
			jcrMessage.setReceived(attachedMessage.getReceivedDate());
			jcrMessage.setExpunged(attachedMessage.isExpunged());
			jcrMessage.setMessage(attachedMessage);
			messages.add(jcrMessage);
		} else if (part.isMimeType("multipart/*")) {
			Multipart multi = (Multipart) part.getContent();
			for (int i = 0; i < multi.getCount(); i++) {
				appendAttachments(multi.getBodyPart(i));
			}
		} else if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())
				|| StringUtils.isNotEmpty(part.getFileName())) {
			JcrFile attachment = new JcrFile();
			String name = null;
			if (StringUtils.isNotEmpty(part.getFileName())) {
				name = part.getFileName();
				for (JcrFile attach : attachments) {
					if (attach.getName().equals(name)) {
						return;
					}
				}
			} else {
				String[] contentId = part.getHeader("Content-Id");
				name = (contentId != null && contentId.length > 0) ? contentId[0] : "attachment";
			}
			int count = 0;
			for (JcrFile attach : attachments) {
				if (attach.getName().equals(name)) {
					count++;
				}
			}
			name = (count > 0) ? "_" + count : name;
			attachment.setName(name);
			ByteArrayOutputStream pout = new ByteArrayOutputStream();
			IOUtils.copy(part.getInputStream(), pout);
			attachment.setDataProvider(new JcrDataProviderImpl(TYPE.BYTES, pout.toByteArray()));
			attachment.setMimeType(part.getContentType());
			attachment.setLastModified(java.util.Calendar.getInstance());
			attachments.add(attachment);
		}
	}

}