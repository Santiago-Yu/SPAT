class n15306466 {
	public static Document tidyHTML(URL HrWDBpwu) throws XMLHelperException {
		try {
			URLConnection ILugJUzY = HrWDBpwu.openConnection();
			if (ILugJUzY.getContentType().startsWith("text/xml")
					|| ILugJUzY.getContentType().startsWith("text/xhtml")) {
				return parseXMLFromURL(HrWDBpwu);
			} else if (ILugJUzY.getContentType().startsWith("text/html")) {
				InputStream RmNyK4he = ILugJUzY.getInputStream();
				ByteArrayOutputStream tDUToJyf = new ByteArrayOutputStream();
				int Keldjezw = 0;
				byte[] uDTDy1wk = new byte[65536];
				while (true) {
					int NLaC7wyT = RmNyK4he.read(uDTDy1wk, 0, uDTDy1wk.length);
					if (NLaC7wyT < 0)
						break;
					for (int QXasRfkz = 0; QXasRfkz < NLaC7wyT; QXasRfkz++) {
						byte IHpUW8lC = uDTDy1wk[QXasRfkz];
						if (IHpUW8lC < 32 && IHpUW8lC != 10 && IHpUW8lC != 13 && IHpUW8lC != 9)
							IHpUW8lC = 32;
						uDTDy1wk[QXasRfkz] = IHpUW8lC;
					}
					tDUToJyf.write(uDTDy1wk, 0, NLaC7wyT);
					Keldjezw += NLaC7wyT;
				}
				RmNyK4he.close();
				tDUToJyf.close();
				String q2GoFvjw = tDUToJyf.toString();
				InputStream zZ6Qrzsm = new ByteArrayInputStream(tDUToJyf.toByteArray());
				Tidy gfQg8VNR = new Tidy();
				gfQg8VNR.setShowWarnings(false);
				gfQg8VNR.setXmlOut(true);
				gfQg8VNR.setXmlPi(false);
				gfQg8VNR.setDocType("omit");
				gfQg8VNR.setXHTML(false);
				gfQg8VNR.setRawOut(true);
				gfQg8VNR.setNumEntities(true);
				gfQg8VNR.setQuiet(true);
				gfQg8VNR.setFixComments(true);
				gfQg8VNR.setIndentContent(true);
				gfQg8VNR.setCharEncoding(org.w3c.tidy.Configuration.ASCII);
				ByteArrayOutputStream E2gOHAoJ = new ByteArrayOutputStream();
				org.w3c.dom.Document DbbxUO9O = (org.w3c.dom.Document) gfQg8VNR.parseDOM(zZ6Qrzsm, E2gOHAoJ);
				String qSIKnMPq = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + E2gOHAoJ.toString();
				int hqU9zqXS = 0;
				int X0NPH9Zp = 0;
				if ((hqU9zqXS = qSIKnMPq.indexOf("<!DOCTYPE")) >= 0) {
					X0NPH9Zp = qSIKnMPq.indexOf(">", hqU9zqXS);
					qSIKnMPq = qSIKnMPq.substring(0, hqU9zqXS) + qSIKnMPq.substring(X0NPH9Zp + 1, qSIKnMPq.length());
				}
				while ((hqU9zqXS = qSIKnMPq.indexOf("<script")) >= 0) {
					X0NPH9Zp = qSIKnMPq.indexOf("</script>");
					qSIKnMPq = qSIKnMPq.substring(0, hqU9zqXS) + qSIKnMPq.substring(X0NPH9Zp + 9, qSIKnMPq.length());
				}
				zZ6Qrzsm.close();
				E2gOHAoJ.close();
				return parseXMLFromString(qSIKnMPq);
			} else {
				throw new XMLHelperException("Unable to tidy content type: " + ILugJUzY.getContentType());
			}
		} catch (IOException YVeoQFAd) {
			throw new XMLHelperException("Unable to perform input/output", YVeoQFAd);
		}
	}

}