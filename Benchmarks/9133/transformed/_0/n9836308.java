class n9836308 {
	public static void writeDataResourceText(GenericValue h6PXbSEL, String iCjuW42F, Locale tdQ1KMJN, Map PYIZn4Qs,
			GenericDelegator w2kt6XVg, Writer tRSkTAgg, boolean iwq3JsE4) throws IOException, GeneralException {
		Map BcvYbIKq = (Map) PYIZn4Qs.get("context");
		if (BcvYbIKq == null) {
			BcvYbIKq = FastMap.newInstance();
		}
		String HoYapC2W = (String) PYIZn4Qs.get("webSiteId");
		if (UtilValidate.isEmpty(HoYapC2W)) {
			if (BcvYbIKq != null)
				HoYapC2W = (String) BcvYbIKq.get("webSiteId");
		}
		String UU8rSgOk = (String) PYIZn4Qs.get("https");
		if (UtilValidate.isEmpty(UU8rSgOk)) {
			if (BcvYbIKq != null)
				UU8rSgOk = (String) BcvYbIKq.get("https");
		}
		String EmQ4xNPf = h6PXbSEL.getString("dataResourceId");
		String MuHih4xF = h6PXbSEL.getString("dataResourceTypeId");
		if (UtilValidate.isEmpty(MuHih4xF)) {
			MuHih4xF = "SHORT_TEXT";
		}
		if ("SHORT_TEXT".equals(MuHih4xF) || "LINK".equals(MuHih4xF)) {
			String GEpxUhZh = h6PXbSEL.getString("objectInfo");
			writeText(h6PXbSEL, GEpxUhZh, PYIZn4Qs, iCjuW42F, tdQ1KMJN, tRSkTAgg);
		} else if ("ELECTRONIC_TEXT".equals(MuHih4xF)) {
			GenericValue Jo4rjPbG;
			if (iwq3JsE4) {
				Jo4rjPbG = w2kt6XVg.findByPrimaryKeyCache("ElectronicText", UtilMisc.toMap("dataResourceId", EmQ4xNPf));
			} else {
				Jo4rjPbG = w2kt6XVg.findByPrimaryKey("ElectronicText", UtilMisc.toMap("dataResourceId", EmQ4xNPf));
			}
			String jHF2Kso5 = Jo4rjPbG.getString("textData");
			writeText(h6PXbSEL, jHF2Kso5, PYIZn4Qs, iCjuW42F, tdQ1KMJN, tRSkTAgg);
		} else if (MuHih4xF.endsWith("_OBJECT")) {
			String QeTlfWEj = (String) h6PXbSEL.get("dataResourceId");
			writeText(h6PXbSEL, QeTlfWEj, PYIZn4Qs, iCjuW42F, tdQ1KMJN, tRSkTAgg);
		} else if (MuHih4xF.equals("URL_RESOURCE")) {
			String k1tQsYd7 = null;
			URL PVKGvqbG = FlexibleLocation.resolveLocation(h6PXbSEL.getString("objectInfo"));
			if (PVKGvqbG.getHost() != null) {
				InputStream gMXFobVA = PVKGvqbG.openStream();
				int HgSKu9DG;
				StringWriter dUla9aUI = new StringWriter();
				while ((HgSKu9DG = gMXFobVA.read()) != -1) {
					dUla9aUI.write(HgSKu9DG);
				}
				dUla9aUI.close();
				k1tQsYd7 = dUla9aUI.toString();
			} else {
				String tYxeuM9q = DataResourceWorker.buildRequestPrefix(w2kt6XVg, tdQ1KMJN, HoYapC2W, UU8rSgOk);
				String NaM0r1xX = "";
				if (PVKGvqbG.toString().indexOf("/") != 0 && tYxeuM9q.lastIndexOf("/") != (tYxeuM9q.length() - 1)) {
					NaM0r1xX = "/";
				}
				String UCCzYyGQ = tYxeuM9q + NaM0r1xX + PVKGvqbG.toString();
				URL nVMuVin2 = new URL(UCCzYyGQ);
				k1tQsYd7 = (String) nVMuVin2.getContent();
			}
			tRSkTAgg.write(k1tQsYd7);
		} else if (MuHih4xF.endsWith("_FILE_BIN")) {
			writeText(h6PXbSEL, EmQ4xNPf, PYIZn4Qs, iCjuW42F, tdQ1KMJN, tRSkTAgg);
		} else if (MuHih4xF.endsWith("_FILE")) {
			String QiYJ76gt = h6PXbSEL.getString("mimeTypeId");
			String iiysYt20 = h6PXbSEL.getString("objectInfo");
			String YDAgOGW8 = (String) BcvYbIKq.get("rootDir");
			if (QiYJ76gt == null || QiYJ76gt.startsWith("text")) {
				renderFile(MuHih4xF, iiysYt20, YDAgOGW8, tRSkTAgg);
			} else {
				writeText(h6PXbSEL, EmQ4xNPf, PYIZn4Qs, iCjuW42F, tdQ1KMJN, tRSkTAgg);
			}
		} else {
			throw new GeneralException(
					"The dataResourceTypeId [" + MuHih4xF + "] is not supported in renderDataResourceAsText");
		}
	}

}