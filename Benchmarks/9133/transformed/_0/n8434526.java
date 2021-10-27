class n8434526 {
	private ZipOutputStream copyOOXMLContent(String zBmuT4Vi, OutputStream mEdS5B3I)
			throws IOException, ParserConfigurationException, SAXException, TransformerConfigurationException,
			TransformerFactoryConfigurationError, TransformerException {
		ZipOutputStream sIHjjTce = new ZipOutputStream(mEdS5B3I);
		ZipInputStream yh7OaZ9L = new ZipInputStream(this.getOfficeOpenXMLDocumentURL().openStream());
		ZipEntry h6I1gTDy;
		boolean bPX7fXbW = false;
		while (null != (h6I1gTDy = yh7OaZ9L.getNextEntry())) {
			LOG.debug("copy ZIP entry: " + h6I1gTDy.getName());
			ZipEntry taOpy6Fm = new ZipEntry(h6I1gTDy.getName());
			sIHjjTce.putNextEntry(taOpy6Fm);
			if ("[Content_Types].xml".equals(h6I1gTDy.getName())) {
				Document vvFXm5H2 = loadDocumentNoClose(yh7OaZ9L);
				Element LKBNgDuE = vvFXm5H2.getDocumentElement();
				Element BtYvzye5 = vvFXm5H2
						.createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", "Override");
				BtYvzye5.setAttribute("PartName", "/" + zBmuT4Vi);
				BtYvzye5.setAttribute("ContentType",
						"application/vnd.openxmlformats-package.digital-signature-xmlsignature+xml");
				LKBNgDuE.appendChild(BtYvzye5);
				Element ihvuBspz = vvFXm5H2.createElement("ns");
				ihvuBspz.setAttributeNS(Constants.NamespaceSpecNS, "xmlns:tns",
						"http://schemas.openxmlformats.org/package/2006/content-types");
				NodeList LjaNmfsj = XPathAPI.selectNodeList(vvFXm5H2, "/tns:Types/tns:Default[@Extension='sigs']",
						ihvuBspz);
				if (0 == LjaNmfsj.getLength()) {
					Element zCDokaWP = vvFXm5H2
							.createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", "Default");
					zCDokaWP.setAttribute("Extension", "sigs");
					zCDokaWP.setAttribute("ContentType",
							"application/vnd.openxmlformats-package.digital-signature-origin");
					LKBNgDuE.appendChild(zCDokaWP);
				}
				writeDocumentNoClosing(vvFXm5H2, sIHjjTce, false);
			} else if ("_rels/.rels".equals(h6I1gTDy.getName())) {
				Document jRYqzcoI = loadDocumentNoClose(yh7OaZ9L);
				Element HwT80nUG = jRYqzcoI.createElement("ns");
				HwT80nUG.setAttributeNS(Constants.NamespaceSpecNS, "xmlns:tns",
						"http://schemas.openxmlformats.org/package/2006/relationships");
				NodeList NczHt3jG = XPathAPI.selectNodeList(jRYqzcoI,
						"/tns:Relationships/tns:Relationship[@Target='_xmlsignatures/origin.sigs']", HwT80nUG);
				if (0 == NczHt3jG.getLength()) {
					Element dDXU6mLU = jRYqzcoI.createElementNS(
							"http://schemas.openxmlformats.org/package/2006/relationships", "Relationship");
					dDXU6mLU.setAttribute("Id", "rel-id-" + UUID.randomUUID().toString());
					dDXU6mLU.setAttribute("Type",
							"http://schemas.openxmlformats.org/package/2006/relationships/digital-signature/origin");
					dDXU6mLU.setAttribute("Target", "_xmlsignatures/origin.sigs");
					jRYqzcoI.getDocumentElement().appendChild(dDXU6mLU);
				}
				writeDocumentNoClosing(jRYqzcoI, sIHjjTce, false);
			} else if ("_xmlsignatures/_rels/origin.sigs.rels".equals(h6I1gTDy.getName())) {
				bPX7fXbW = true;
				Document voxEMlzs = loadDocumentNoClose(yh7OaZ9L);
				Element GhLnmEh9 = voxEMlzs.createElementNS(
						"http://schemas.openxmlformats.org/package/2006/relationships", "Relationship");
				String ljIIm5TV = "rel-" + UUID.randomUUID().toString();
				GhLnmEh9.setAttribute("Id", ljIIm5TV);
				GhLnmEh9.setAttribute("Type",
						"http://schemas.openxmlformats.org/package/2006/relationships/digital-signature/signature");
				String Gl4PzRLB = FilenameUtils.getName(zBmuT4Vi);
				LOG.debug("target: " + Gl4PzRLB);
				GhLnmEh9.setAttribute("Target", Gl4PzRLB);
				voxEMlzs.getDocumentElement().appendChild(GhLnmEh9);
				writeDocumentNoClosing(voxEMlzs, sIHjjTce, false);
			} else {
				IOUtils.copy(yh7OaZ9L, sIHjjTce);
			}
		}
		if (false == bPX7fXbW) {
			addOriginSigsRels(zBmuT4Vi, sIHjjTce);
			addOriginSigs(sIHjjTce);
		}
		yh7OaZ9L.close();
		return sIHjjTce;
	}

}