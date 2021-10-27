class n14918000 {
	public void invoke(MessageContext ETu4ktYL) throws AxisFault {
		log.debug("Enter: MD5AttachHandler::invoke");
		try {
			Message dA8wSx1f = ETu4ktYL.getRequestMessage();
			SOAPConstants NMH1bEAI = ETu4ktYL.getSOAPConstants();
			org.apache.axis.message.SOAPEnvelope RYPqpkDH = (org.apache.axis.message.SOAPEnvelope) dA8wSx1f
					.getSOAPEnvelope();
			org.apache.axis.message.SOAPBodyElement PjiamVk7 = RYPqpkDH.getFirstBody();
			org.w3c.dom.Element OINxSQsy = PjiamVk7.getAsDOM();
			org.w3c.dom.Node teNySdQ6 = OINxSQsy.getFirstChild();
			for (; teNySdQ6 != null && !(teNySdQ6 instanceof org.w3c.dom.Element); teNySdQ6 = teNySdQ6.getNextSibling())
				;
			org.w3c.dom.Element hyv83yMC = (org.w3c.dom.Element) teNySdQ6;
			String ZZwmrHmY = hyv83yMC.getAttribute(NMH1bEAI.getAttrHref());
			org.apache.axis.Part uAmCypiV = dA8wSx1f.getAttachmentsImpl().getAttachmentByReference(ZZwmrHmY);
			javax.activation.DataHandler Ucf6qjyN = org.apache.axis.attachments.AttachmentUtils
					.getActivationDataHandler(uAmCypiV);
			org.w3c.dom.Node qPuUzIc2 = hyv83yMC.getFirstChild();
			long soEpoZPD = -1;
			if (qPuUzIc2 != null && qPuUzIc2 instanceof org.w3c.dom.Text) {
				String QTjrjvbd = ((org.w3c.dom.Text) qPuUzIc2).getData();
				soEpoZPD = Long.parseLong(QTjrjvbd);
			}
			long va3mPkDL = System.currentTimeMillis();
			long VFUdthxs = -1;
			if (soEpoZPD > 0)
				VFUdthxs = va3mPkDL - soEpoZPD;
			String RQ6kICRU = VFUdthxs + "";
			java.security.MessageDigest fCOkPoSN = java.security.MessageDigest.getInstance("MD5");
			java.io.InputStream IIAK2W1w = Ucf6qjyN.getInputStream();
			int Y0QTDrbR = 0;
			byte[] oVQrj6QX = new byte[64 * 1024];
			do {
				Y0QTDrbR = IIAK2W1w.read(oVQrj6QX);
				if (Y0QTDrbR > 0) {
					fCOkPoSN.update(oVQrj6QX, 0, Y0QTDrbR);
				}
			} while (Y0QTDrbR > -1);
			IIAK2W1w.close();
			oVQrj6QX = null;
			String qQI307ic = Ucf6qjyN.getContentType();
			if (qQI307ic != null && qQI307ic.length() != 0) {
				fCOkPoSN.update(qQI307ic.getBytes("US-ASCII"));
			}
			PjiamVk7 = RYPqpkDH.getFirstBody();
			OINxSQsy = PjiamVk7.getAsDOM();
			teNySdQ6 = OINxSQsy.getFirstChild();
			for (; teNySdQ6 != null && !(teNySdQ6 instanceof org.w3c.dom.Element); teNySdQ6 = teNySdQ6.getNextSibling())
				;
			hyv83yMC = (org.w3c.dom.Element) teNySdQ6;
			String AHrNCJht = org.apache.axis.encoding.Base64.encode(fCOkPoSN.digest());
			String qSrv1Hdx = " elapsedTime=" + RQ6kICRU + " MD5=" + AHrNCJht;
			hyv83yMC.appendChild(hyv83yMC.getOwnerDocument().createTextNode(qSrv1Hdx));
			PjiamVk7 = new org.apache.axis.message.SOAPBodyElement(OINxSQsy);
			RYPqpkDH.clearBody();
			RYPqpkDH.addBodyElement(PjiamVk7);
			dA8wSx1f = new Message(RYPqpkDH);
			ETu4ktYL.setResponseMessage(dA8wSx1f);
		} catch (Exception Ktyx7hMH) {
			log.error(Messages.getMessage("exception00"), Ktyx7hMH);
			throw AxisFault.makeFault(Ktyx7hMH);
		}
		log.debug("Exit: MD5AttachHandler::invoke");
	}

}