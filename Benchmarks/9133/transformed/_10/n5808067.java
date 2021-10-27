class n5808067 {
	@Override
	public void action(String msg, String uri, Gateway gateway) throws Exception {
		String city = "成都";
		String url = "http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theCityCode={city}&theUserID=";
		if (msg.indexOf("#") != -1) {
			city = msg.substring(msg.indexOf("#") + 1);
		}
		url = url.replace("{city}", URLEncoder.encode(city, "UTF8"));
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		if (conn.getResponseCode() == 200) {
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(conn.getInputStream());
			List strings = doc.getRootElement().getChildren();
			StringBuffer buffer = new StringBuffer();
			String[] sugguestions = getText(strings.get(6)).split("\n");
			buffer.append("欢迎使用MapleSMS的天气服务！\n");
			buffer.append("你查询的是 " + getText(strings.get(1)) + "的天气。\n");
			buffer.append(getText(strings.get(4)) + "。\n");
			buffer.append(getText(strings.get(5)) + "。\n");
			buffer.append(sugguestions[0] + "\n");
			buffer.append(sugguestions[1] + "\n");
			buffer.append(sugguestions[7] + "\n");
			buffer.append("感谢你使用MapleSMS的天气服务！祝你愉快！");
			gateway.sendSMS(uri, buffer.toString());
		} else {
			gateway.sendSMS(uri, "对不起，你输入的城市格式有误，请检查后再试~");
		}
	}

}