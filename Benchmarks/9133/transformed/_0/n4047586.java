class n4047586 {
	public static void toValueSAX(Property gZfxSrmj, Value Qa5vESiQ, int F058LCPE, ContentHandler ZIuxc9dT,
			AttributesImpl MzmRmTgx, Context N6LPiv0A) throws SAXException, RepositoryException {
		MzmRmTgx.clear();
		String Lu3SdrXQ = null;
		switch (F058LCPE) {
		case PropertyType.DATE:
			DateFormat HqRpGA7o = new SimpleDateFormat(BackupFormatConstants.DATE_FORMAT_STRING);
			HqRpGA7o.setTimeZone(Qa5vESiQ.getDate().getTimeZone());
			Lu3SdrXQ = HqRpGA7o.format(Qa5vESiQ.getDate().getTime());
			break;
		case PropertyType.BINARY:
			String U6yW96d3 = gZfxSrmj.getParent().getPath() + "/" + gZfxSrmj.getName();
			OutputStream VIod9c1t = null;
			InputStream jHyUh1Sl = null;
			try {
				VIod9c1t = N6LPiv0A.getPersistenceManager().getOutResource(U6yW96d3, true);
				jHyUh1Sl = Qa5vESiQ.getStream();
				IOUtils.copy(jHyUh1Sl, VIod9c1t);
				VIod9c1t.flush();
			} catch (Exception eQXue7Ea) {
				throw new SAXException("Could not backup binary value of property [" + gZfxSrmj.getName() + "]",
						eQXue7Ea);
			} finally {
				if (null != jHyUh1Sl) {
					try {
						jHyUh1Sl.close();
					} catch (IOException gb718a38) {
						gb718a38.printStackTrace();
					}
				}
				if (null != VIod9c1t) {
					try {
						VIod9c1t.close();
					} catch (IOException EYLhhl4k) {
						EYLhhl4k.printStackTrace();
					}
				}
			}
			MzmRmTgx.addAttribute("", ATTACHMENT, (NAMESPACE.length() > 0 ? NAMESPACE + ":" : "") + ATTACHMENT,
					"string", U6yW96d3);
			break;
		case PropertyType.REFERENCE:
			Lu3SdrXQ = Qa5vESiQ.getString();
			break;
		default:
			Lu3SdrXQ = Qa5vESiQ.getString();
		}
		ZIuxc9dT.startElement("", VALUE, (NAMESPACE.length() > 0 ? NAMESPACE + ":" : "") + VALUE, MzmRmTgx);
		if (null != Lu3SdrXQ)
			ZIuxc9dT.characters(Lu3SdrXQ.toCharArray(), 0, Lu3SdrXQ.length());
		ZIuxc9dT.endElement("", VALUE, (NAMESPACE.length() > 0 ? NAMESPACE + ":" : "") + VALUE);
	}

}