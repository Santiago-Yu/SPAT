class n13940142 {
	private void generateDocFile(String BjMuMIAc, String XYTWdswe, String syk8olBL) {
		try {
			ZipFile Mx6rArGI = new ZipFile(new File(BjMuMIAc));
			ZipEntry ukUleSdu = Mx6rArGI.getEntry("word/document.xml");
			DocumentBuilderFactory FcSUObXA = DocumentBuilderFactory.newInstance();
			InputStream mdGHBvPA = Mx6rArGI.getInputStream(ukUleSdu);
			Document Fb6Nshfr = FcSUObXA.newDocumentBuilder().parse(mdGHBvPA);
			Transformer D1Ss22wV = TransformerFactory.newInstance().newTransformer();
			ByteArrayOutputStream KKurp6x7 = new ByteArrayOutputStream();
			D1Ss22wV.transform(new DOMSource(Fb6Nshfr), new StreamResult(KKurp6x7));
			ZipOutputStream R7p0Z4uH = new ZipOutputStream(new FileOutputStream(syk8olBL));
			Enumeration<ZipEntry> g3sE8kHo = (Enumeration<ZipEntry>) Mx6rArGI.entries();
			while (g3sE8kHo.hasMoreElements()) {
				ZipEntry wsbGBAj5 = g3sE8kHo.nextElement();
				if (wsbGBAj5.getName().equals("word/document.xml")) {
					R7p0Z4uH.putNextEntry(new ZipEntry(wsbGBAj5.getName()));
					byte[] e7qOS3Dy = XYTWdswe.getBytes("UTF-8");
					R7p0Z4uH.write(e7qOS3Dy, 0, e7qOS3Dy.length);
					R7p0Z4uH.closeEntry();
				} else if (wsbGBAj5.getName().equals("word/media/image1.png")) {
					InputStream OSHXmZei = new FileInputStream("c:/aaa.jpg");
					byte[] gncIM9wF = new byte[OSHXmZei.available()];
					int XEXdJXkk = OSHXmZei.read(gncIM9wF, 0, gncIM9wF.length);
					R7p0Z4uH.putNextEntry(new ZipEntry(wsbGBAj5.getName()));
					R7p0Z4uH.write(gncIM9wF, 0, XEXdJXkk);
					R7p0Z4uH.closeEntry();
				} else {
					InputStream P6QbW7EN = Mx6rArGI.getInputStream(wsbGBAj5);
					byte[] k9VlmzI1 = new byte[P6QbW7EN.available()];
					int FjoVLdz1 = P6QbW7EN.read(k9VlmzI1, 0, k9VlmzI1.length);
					R7p0Z4uH.putNextEntry(new ZipEntry(wsbGBAj5.getName()));
					R7p0Z4uH.write(k9VlmzI1, 0, FjoVLdz1);
					R7p0Z4uH.closeEntry();
				}
			}
			R7p0Z4uH.close();
		} catch (Exception ZKOjpqPQ) {
		}
	}

}