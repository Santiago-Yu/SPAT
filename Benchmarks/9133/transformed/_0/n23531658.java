class n23531658 {
	public void objectParserAssesmentItem(int YLWeZxER, int DuTWKv8G, Resource PWb8ja3Z) {
		NodeList kluzbCzm = null;
		Node nvvLmAFB = null;
		NamedNodeMap UnGFkwU9 = null;
		Node RAwXiXrx = null;
		URL MM4SaJWH = null;
		String IukSAWFO = "";
		String aYM8Dmek = "";
		int xVyoqqIh;
		String iEcncrQ0 = "";
		try {
			if (YLWeZxER == 1) {
				kluzbCzm = doc.getElementsByTagName("object");
			} else {
				kluzbCzm = doc_[DuTWKv8G].getElementsByTagName("object");
			}
			for (int VwLuzk9p = 0; VwLuzk9p < kluzbCzm.getLength(); VwLuzk9p++) {
				nvvLmAFB = kluzbCzm.item(VwLuzk9p);
				UnGFkwU9 = nvvLmAFB.getAttributes();
				RAwXiXrx = UnGFkwU9.getNamedItem("data");
				String sZWZJwPa = RAwXiXrx.getTextContent();
				MM4SaJWH = new URL("file", "localhost", sZWZJwPa);
				iEcncrQ0 = MM4SaJWH.getFile();
				iEcncrQ0 = iEcncrQ0.replace('/', File.separatorChar);
				xVyoqqIh = iEcncrQ0.lastIndexOf(File.separatorChar);
				String bBsqKOBX = iEcncrQ0;
				IukSAWFO = iEcncrQ0.substring(xVyoqqIh + 1);
				aYM8Dmek = this.sTempLocation + IukSAWFO;
				FileChannel K64lTSUm = null;
				FileChannel d5GyUGxA = null;
				try {
					K64lTSUm = new FileInputStream(bBsqKOBX).getChannel();
					d5GyUGxA = new FileOutputStream(aYM8Dmek).getChannel();
					long UK47MxEr = K64lTSUm.size();
					MappedByteBuffer eP74bMm6 = K64lTSUm.map(FileChannel.MapMode.READ_ONLY, 0, UK47MxEr);
					d5GyUGxA.write(eP74bMm6);
				} finally {
					if (K64lTSUm != null)
						K64lTSUm.close();
					if (d5GyUGxA != null)
						d5GyUGxA.close();
				}
				if (YLWeZxER == 1) {
					sXml = sXml.replace(RAwXiXrx.getTextContent(), IukSAWFO);
				} else {
					sXml_[DuTWKv8G] = sXml_[DuTWKv8G].replace(RAwXiXrx.getTextContent(), IukSAWFO);
				}
				lsImages.add(IukSAWFO);
				PWb8ja3Z.addFile(IukSAWFO);
			}
		} catch (MalformedURLException zB7LYOUE) {
			zB7LYOUE.printStackTrace();
		} catch (IOException J61YJ51t) {
			J61YJ51t.printStackTrace();
		}
	}

}