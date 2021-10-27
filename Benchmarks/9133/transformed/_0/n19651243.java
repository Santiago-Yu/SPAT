class n19651243 {
	private static void testTidy() {
		try {
			String GRfClK6v = "http://groups.google.com/group/dengues/files";
			java.io.InputStream movqeNml = new java.net.URL(GRfClK6v).openStream();
			org.w3c.dom.Document OUeJXgHF = dengues.system.HTMLWebHelper.parseDOM(movqeNml);
			org.w3c.dom.NodeList UVgwHEpu = OUeJXgHF.getElementsByTagName("td");
			org.w3c.dom.Element XD7IKIB5 = null;
			for (int LkLqvQ3i = 0; LkLqvQ3i < UVgwHEpu.getLength(); LkLqvQ3i++) {
				org.w3c.dom.Node yWLgs8ax = UVgwHEpu.item(LkLqvQ3i);
				String GcSpe0zW = dengues.system.HTMLWebHelper.getContent(yWLgs8ax);
				String VFdi4Kss = dengues.system.HTMLWebHelper.convert(GcSpe0zW);
				if (VFdi4Kss.equals("zDevil")) {
					XD7IKIB5 = (org.w3c.dom.Element) yWLgs8ax.getParentNode().getParentNode();
					break;
				}
			}
			if (XD7IKIB5 != null) {
				org.w3c.dom.NodeList m0rNSWHs = XD7IKIB5.getElementsByTagName("tr");
				for (int yXoZjgiI = 0; yXoZjgiI < m0rNSWHs.getLength(); yXoZjgiI++) {
					org.w3c.dom.NodeList Dh2cq2lB = m0rNSWHs.item(yXoZjgiI).getChildNodes();
					if (Dh2cq2lB.getLength() > 2) {
						org.w3c.dom.Node Bd47NoYf = Dh2cq2lB.item(0);
						org.w3c.dom.Node tbtBfrDQ = Dh2cq2lB.item(1);
						String tJb0lFf8 = dengues.system.HTMLWebHelper.getContent(Bd47NoYf);
						String vOWb2Fsv = dengues.system.HTMLWebHelper.convert(tJb0lFf8);
						tJb0lFf8 = dengues.system.HTMLWebHelper.getContent(tbtBfrDQ);
						String j3IIpzag = dengues.system.HTMLWebHelper.convert(tJb0lFf8);
						if (!"".equals(vOWb2Fsv)) {
							System.out.println(vOWb2Fsv + " => " + j3IIpzag);
						}
					}
				}
			}
			movqeNml.close();
		} catch (java.net.MalformedURLException z42rzLO4) {
			z42rzLO4.printStackTrace();
		} catch (java.io.IOException Cb2cetol) {
			Cb2cetol.printStackTrace();
		}
	}

}