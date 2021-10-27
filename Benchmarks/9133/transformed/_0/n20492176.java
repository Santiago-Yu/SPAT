class n20492176 {
	public String postEvent(EventDocument M935sSOp, Map Ez7bQLbk) {
		if (M935sSOp == null || M935sSOp.getEvent() == null)
			return null;
		if (jmsTemplate == null) {
			sendEvent(M935sSOp, Ez7bQLbk);
			return M935sSOp.getEvent().getEventId();
		}
		if (Ez7bQLbk != null) {
			Iterator IAWxfeVG = Ez7bQLbk.entrySet().iterator();
			while (IAWxfeVG.hasNext()) {
				Map.Entry KlWZgdAC = (Map.Entry) IAWxfeVG.next();
				if (KlWZgdAC.getValue() instanceof DataHandler) {
					File HlutlU0l = new File(attachmentStorge + "/" + GuidUtil.generate() + KlWZgdAC.getKey());
					try {
						IOUtils.copy(((DataHandler) KlWZgdAC.getValue()).getInputStream(),
								new FileOutputStream(HlutlU0l));
						KlWZgdAC.setValue(HlutlU0l);
					} catch (IOException CeqZWPCx) {
						CeqZWPCx.printStackTrace();
					}
				}
			}
		}
		InternalEventObject N3adsMuh = new InternalEventObject();
		N3adsMuh.setEventDocument(M935sSOp);
		N3adsMuh.setAttachments(Ez7bQLbk);
		N3adsMuh.setSessionContext(SessionContextUtil.getCurrentContext());
		M935sSOp.getEvent().setEventId(GuidUtil.generate());
		if (destinationName != null)
			jmsTemplate.convertAndSend(destinationName, N3adsMuh);
		else
			jmsTemplate.convertAndSend(N3adsMuh);
		return M935sSOp.getEvent().getEventId();
	}

}