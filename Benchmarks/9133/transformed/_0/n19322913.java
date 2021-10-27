class n19322913 {
	@Test
	public void test_blueprintTypeByTypeName() throws Exception {
		URL YqP8Q9zP = new URL(baseUrl + "/blueprintTypeByTypeName/Obelisk+Blueprint");
		HttpURLConnection K3RQTxcz = (HttpURLConnection) YqP8Q9zP.openConnection();
		K3RQTxcz.setRequestMethod("GET");
		K3RQTxcz.setRequestProperty("Accept", "application/json");
		assertThat(K3RQTxcz.getResponseCode(), equalTo(200));
		assertThat(getResponse(K3RQTxcz), equalTo(
				"{\"blueprintTypeID\":20188,\"blueprintTypeName\":\"Obelisk Blueprint\",\"productTypeID\":20187,\"productTypeName\":\"Obelisk\",\"productCategoryID\":6,\"techLevel\":1,\"productionTime\":1280000,\"researchProductivityTime\":7680000,\"researchMaterialTime\":5120000,\"researchCopyTime\":2560000,\"researchTechTime\":500000,\"productivityModifier\":256000,\"wasteFactor\":10,\"maxProductionLimit\":1,\"productVolume\":\"17550000\",\"productPortionSize\":1,\"dumpVersion\":\"cru16\"}"));
		assertThat(K3RQTxcz.getHeaderField("Content-Type"), equalTo("application/json; charset=utf-8"));
		K3RQTxcz = (HttpURLConnection) YqP8Q9zP.openConnection();
		K3RQTxcz.setRequestMethod("GET");
		K3RQTxcz.setRequestProperty("Accept", "application/xml");
		assertThat(K3RQTxcz.getResponseCode(), equalTo(200));
		assertThat(getResponse(K3RQTxcz), equalTo(
				"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><invBlueprintTypeDto><blueprintTypeID>20188</blueprintTypeID><blueprintTypeName>Obelisk Blueprint</blueprintTypeName><dumpVersion>cru16</dumpVersion><maxProductionLimit>1</maxProductionLimit><productCategoryID>6</productCategoryID><productPortionSize>1</productPortionSize><productTypeID>20187</productTypeID><productTypeName>Obelisk</productTypeName><productVolume>17550000</productVolume><productionTime>1280000</productionTime><productivityModifier>256000</productivityModifier><researchCopyTime>2560000</researchCopyTime><researchMaterialTime>5120000</researchMaterialTime><researchProductivityTime>7680000</researchProductivityTime><researchTechTime>500000</researchTechTime><techLevel>1</techLevel><wasteFactor>10</wasteFactor></invBlueprintTypeDto>"));
		assertThat(K3RQTxcz.getHeaderField("Content-Type"), equalTo("application/xml; charset=utf-8"));
		YqP8Q9zP = new URL(baseUrl + "/blueprintTypeByTypeName/Obelisk%20Blueprint");
		K3RQTxcz = (HttpURLConnection) YqP8Q9zP.openConnection();
		K3RQTxcz.setRequestMethod("GET");
		K3RQTxcz.setRequestProperty("Accept", "application/json");
		assertThat(K3RQTxcz.getResponseCode(), equalTo(200));
		assertThat(getResponse(K3RQTxcz), equalTo(
				"{\"blueprintTypeID\":20188,\"blueprintTypeName\":\"Obelisk Blueprint\",\"productTypeID\":20187,\"productTypeName\":\"Obelisk\",\"productCategoryID\":6,\"techLevel\":1,\"productionTime\":1280000,\"researchProductivityTime\":7680000,\"researchMaterialTime\":5120000,\"researchCopyTime\":2560000,\"researchTechTime\":500000,\"productivityModifier\":256000,\"wasteFactor\":10,\"maxProductionLimit\":1,\"productVolume\":\"17550000\",\"productPortionSize\":1,\"dumpVersion\":\"cru16\"}"));
		assertThat(K3RQTxcz.getHeaderField("Content-Type"), equalTo("application/json; charset=utf-8"));
		K3RQTxcz = (HttpURLConnection) YqP8Q9zP.openConnection();
		K3RQTxcz.setRequestMethod("GET");
		K3RQTxcz.setRequestProperty("Accept", "application/xml");
		assertThat(K3RQTxcz.getResponseCode(), equalTo(200));
		assertThat(getResponse(K3RQTxcz), equalTo(
				"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><invBlueprintTypeDto><blueprintTypeID>20188</blueprintTypeID><blueprintTypeName>Obelisk Blueprint</blueprintTypeName><dumpVersion>cru16</dumpVersion><maxProductionLimit>1</maxProductionLimit><productCategoryID>6</productCategoryID><productPortionSize>1</productPortionSize><productTypeID>20187</productTypeID><productTypeName>Obelisk</productTypeName><productVolume>17550000</productVolume><productionTime>1280000</productionTime><productivityModifier>256000</productivityModifier><researchCopyTime>2560000</researchCopyTime><researchMaterialTime>5120000</researchMaterialTime><researchProductivityTime>7680000</researchProductivityTime><researchTechTime>500000</researchTechTime><techLevel>1</techLevel><wasteFactor>10</wasteFactor></invBlueprintTypeDto>"));
		assertThat(K3RQTxcz.getHeaderField("Content-Type"), equalTo("application/xml; charset=utf-8"));
		YqP8Q9zP = new URL(baseUrl + "/blueprintTypeByTypeName/Obelisk Blueprint");
		K3RQTxcz = (HttpURLConnection) YqP8Q9zP.openConnection();
		K3RQTxcz.setRequestMethod("GET");
		K3RQTxcz.setRequestProperty("Accept", "application/json");
		assertThat(K3RQTxcz.getResponseCode(), equalTo(400));
		K3RQTxcz = (HttpURLConnection) YqP8Q9zP.openConnection();
		K3RQTxcz.setRequestMethod("GET");
		K3RQTxcz.setRequestProperty("Accept", "application/xml");
		assertThat(K3RQTxcz.getResponseCode(), equalTo(400));
	}

}