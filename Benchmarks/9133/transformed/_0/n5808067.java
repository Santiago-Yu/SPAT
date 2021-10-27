class n5808067 {
	@Override
	public void action(String fkbp4Ua2, String ZPbQ3pfZ, Gateway RwiDYdjA) throws Exception {
		String E8gIfEWb = "成都";
		if (fkbp4Ua2.indexOf("#") != -1) {
			E8gIfEWb = fkbp4Ua2.substring(fkbp4Ua2.indexOf("#") + 1);
		}
		String CyrKobGO = "http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theCityCode={city}&theUserID=";
		CyrKobGO = CyrKobGO.replace("{city}", URLEncoder.encode(E8gIfEWb, "UTF8"));
		HttpURLConnection PXfMGHSl = (HttpURLConnection) new URL(CyrKobGO).openConnection();
		if (PXfMGHSl.getResponseCode() == 200) {
			SAXBuilder YoXMRi0v = new SAXBuilder();
			Document oZt8nBVl = YoXMRi0v.build(PXfMGHSl.getInputStream());
			List KzRq7lcC = oZt8nBVl.getRootElement().getChildren();
			String[] VfY7O9eZ = getText(KzRq7lcC.get(6)).split("\n");
			StringBuffer qmxX5yRl = new StringBuffer();
			qmxX5yRl.append("欢迎使用MapleSMS的天气服务！\n");
			qmxX5yRl.append("你查询的是 " + getText(KzRq7lcC.get(1)) + "的天气。\n");
			qmxX5yRl.append(getText(KzRq7lcC.get(4)) + "。\n");
			qmxX5yRl.append(getText(KzRq7lcC.get(5)) + "。\n");
			qmxX5yRl.append(VfY7O9eZ[0] + "\n");
			qmxX5yRl.append(VfY7O9eZ[1] + "\n");
			qmxX5yRl.append(VfY7O9eZ[7] + "\n");
			qmxX5yRl.append("感谢你使用MapleSMS的天气服务！祝你愉快！");
			RwiDYdjA.sendSMS(ZPbQ3pfZ, qmxX5yRl.toString());
		} else {
			RwiDYdjA.sendSMS(ZPbQ3pfZ, "对不起，你输入的城市格式有误，请检查后再试~");
		}
	}

}