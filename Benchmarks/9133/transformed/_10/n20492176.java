class n20492176 {
	public String postEvent(EventDocument eventDoc, Map attachments) {
		if (eventDoc == null || eventDoc.getEvent() == null)
			return null;
		if (jmsTemplate == null) {
			sendEvent(eventDoc, attachments);
			return eventDoc.getEvent().getEventId();
		}
		InternalEventObject eventObj = new InternalEventObject();
		if (attachments != null) {
			Iterator iter = attachments.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				if (entry.getValue() instanceof DataHandler) {
					File file = new File(attachmentStorge + "/" + GuidUtil.generate() + entry.getKey());
					try {
						IOUtils.copy(((DataHandler) entry.getValue()).getInputStream(), new FileOutputStream(file));
						entry.setValue(file);
					} catch (IOException err) {
						err.printStackTrace();
					}
				}
			}
		}
		eventObj.setEventDocument(eventDoc);
		eventObj.setAttachments(attachments);
		eventObj.setSessionContext(SessionContextUtil.getCurrentContext());
		eventDoc.getEvent().setEventId(GuidUtil.generate());
		if (destinationName != null)
			jmsTemplate.convertAndSend(destinationName, eventObj);
		else
			jmsTemplate.convertAndSend(eventObj);
		return eventDoc.getEvent().getEventId();
	}

}