class n17229913 {
	private void process(int YGZ7pXPM, String YjPQnHKv[]) throws IOException, XMLStreamException {
		final int F1upCPMo = 500;
		final QName TXDzwDck = new QName("title");
		final QName hfTMOztz = new QName("sroffset");
		String YrKwWsWE = null;
		String fW8AdisU = null;
		if (!this.srnamespaces.isEmpty()) {
			StringBuilder AU24xZzh = new StringBuilder();
			for (Integer v58zAw3l : this.srnamespaces) {
				if (AU24xZzh.length() > 0)
					AU24xZzh.append("|");
				AU24xZzh.append(String.valueOf(v58zAw3l));
			}
			fW8AdisU = AU24xZzh.toString();
		}
		StringBuilder Xc2ZAkOP = new StringBuilder();
		while (YGZ7pXPM < YjPQnHKv.length) {
			if (Xc2ZAkOP.length() > 0)
				Xc2ZAkOP.append(" ");
			Xc2ZAkOP.append(YjPQnHKv[YGZ7pXPM++]);
		}
		while (true) {
			String HkH7uvLq = this.base_api + "?action=query" + "&list=search" + "&format=xml" + "&srsearch="
					+ URLEncoder.encode(Xc2ZAkOP.toString(), "UTF-8")
					+ (fW8AdisU != null ? "&srnamespace=" + fW8AdisU : "")
					+ (YrKwWsWE == null ? "" : "&sroffset=" + YrKwWsWE) + "&srlimit=" + F1upCPMo
					+ "&srwhat=text&srprop=timestamp";
			YrKwWsWE = null;
			LOG.info(HkH7uvLq);
			XMLEventReader MS6tdF8g = this.xmlInputFactory.createXMLEventReader(openStream(HkH7uvLq));
			while (MS6tdF8g.hasNext()) {
				XMLEvent ukSopz94 = MS6tdF8g.nextEvent();
				if (ukSopz94.isStartElement()) {
					StartElement Dvs9tuvx = ukSopz94.asStartElement();
					String Qoi2or1C = Dvs9tuvx.getName().getLocalPart();
					Attribute cwp5q9V7 = null;
					if (Qoi2or1C.equals("p") && (cwp5q9V7 = Dvs9tuvx.getAttributeByName(TXDzwDck)) != null) {
						System.out.println(cwp5q9V7.getValue());
					} else if (Qoi2or1C.equals("search")
							&& (cwp5q9V7 = Dvs9tuvx.getAttributeByName(hfTMOztz)) != null) {
						YrKwWsWE = cwp5q9V7.getValue();
					}
				}
			}
			MS6tdF8g.close();
			if (YrKwWsWE == null)
				break;
		}
	}

}