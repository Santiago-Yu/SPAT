class n1244216 {
	public String postEvent(EventDocument Cx0kd5Ln, Map zOWCIaJx) {
		if (Cx0kd5Ln == null || Cx0kd5Ln.getEvent() == null)
			return null;
		if (queue == null) {
			sendEvent(Cx0kd5Ln, zOWCIaJx);
			return Cx0kd5Ln.getEvent().getEventId();
		}
		if (zOWCIaJx != null) {
			Iterator JVxzkIN9 = zOWCIaJx.entrySet().iterator();
			while (JVxzkIN9.hasNext()) {
				Map.Entry QKmMMp1b = (Map.Entry) JVxzkIN9.next();
				if (QKmMMp1b.getValue() instanceof DataHandler) {
					File SGAXCnfs = new File(attachmentStorge + "/" + GuidUtil.generate() + QKmMMp1b.getKey());
					try {
						IOUtils.copy(((DataHandler) QKmMMp1b.getValue()).getInputStream(),
								new FileOutputStream(SGAXCnfs));
						QKmMMp1b.setValue(SGAXCnfs);
					} catch (IOException XLPALPKl) {
						XLPALPKl.printStackTrace();
					}
				}
			}
		}
		InternalEventObject gSGdIpxr = new InternalEventObject();
		gSGdIpxr.setEventDocument(Cx0kd5Ln);
		gSGdIpxr.setAttachments(zOWCIaJx);
		gSGdIpxr.setSessionContext(SessionContextUtil.getCurrentContext());
		Cx0kd5Ln.getEvent().setEventId(GuidUtil.generate());
		getQueue().post(gSGdIpxr);
		return Cx0kd5Ln.getEvent().getEventId();
	}

}