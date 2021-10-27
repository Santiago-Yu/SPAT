class n11333342 {
	public AssessmentItemType getAssessmentItemType(String eMN34mxx) {
		if (eMN34mxx.contains(" ") && (System.getProperty("os.name").contains("Windows"))) {
			File kP290cfd = new File(eMN34mxx);
			String iDJrpC1v = System.getenv("TEMP");
			File eBJ7chzD = new File(iDJrpC1v + "/temp.xml");
			MQMain.logger.info("Importing from " + eBJ7chzD.getAbsolutePath());
			FileChannel fJRrHNzk = null, Oy3TZEk2 = null;
			try {
				fJRrHNzk = new FileInputStream(kP290cfd).getChannel();
				Oy3TZEk2 = new FileOutputStream(eBJ7chzD).getChannel();
				long xGA2mDjr = fJRrHNzk.size();
				MappedByteBuffer Dc3RoYth = fJRrHNzk.map(FileChannel.MapMode.READ_ONLY, 0, xGA2mDjr);
				Oy3TZEk2.write(Dc3RoYth);
			} catch (Exception PZiJPAti) {
				PZiJPAti.printStackTrace();
			} finally {
				if (fJRrHNzk != null)
					try {
						fJRrHNzk.close();
					} catch (IOException gaR2eOwU) {
						gaR2eOwU.printStackTrace();
					}
				if (Oy3TZEk2 != null)
					try {
						Oy3TZEk2.close();
					} catch (IOException sKqdgqCn) {
						sKqdgqCn.printStackTrace();
					}
				eMN34mxx = iDJrpC1v + "/temp.xml";
			}
		}
		AssessmentItemType OXC2nFNH = null;
		JAXBElement<?> sDv4Foql = null;
		try {
			XMLReader DBVVVk2u = XMLReaderFactory.createXMLReader();
			ChangeNamespace MfydbWtB = new ChangeNamespace(DBVVVk2u, "http://www.imsglobal.org/xsd/imsqti_v2p0",
					"http://www.imsglobal.org/xsd/imsqti_v2p1");
			SAXSource O3EGQNb7 = null;
			try {
				FileInputStream QQbbyMQs = new FileInputStream(eMN34mxx);
				InputStreamReader sCDWOCFx = null;
				try {
					sCDWOCFx = new InputStreamReader(QQbbyMQs, "UTF-8");
				} catch (UnsupportedEncodingException oXKDUorh) {
				}
				InputSource pqgcAx8d = new InputSource(sCDWOCFx);
				O3EGQNb7 = new SAXSource(MfydbWtB, pqgcAx8d);
			} catch (FileNotFoundException mkZA9UXi) {
				MQMain.logger.error("SAX/getAssessmentItemType/file not found");
			}
			sDv4Foql = (JAXBElement<?>) MQModel.qtiCf.unmarshal(MQModel.imsqtiUnmarshaller, O3EGQNb7);
			OXC2nFNH = (AssessmentItemType) sDv4Foql.getValue();
		} catch (JAXBException D4aMdKNN) {
			MQMain.logger.error("JAX/getAssessmentItemType", D4aMdKNN);
		} catch (SAXException LOFCsSVs) {
			MQMain.logger.error("SAX/getAssessmentItemType", LOFCsSVs);
		}
		return OXC2nFNH;
	}

}