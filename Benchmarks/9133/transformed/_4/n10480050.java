class n10480050 {
	public static SearchItem loadRecord(String id, boolean isContact) {
		String line = null;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(isContact ? URL_RECORD_CONTACT : URL_RECORD_COMPANY);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(6);
			nameValuePairs.add(new BasicNameValuePair("format", "xml"));
			nameValuePairs.add(new BasicNameValuePair("token", Common.token));
			nameValuePairs.add(new BasicNameValuePair("id", id));
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpClient.execute(httpPost);
			line = EntityUtils.toString(response.getEntity());
			Document document = XMLfunctions.XMLfromString(line);
			NodeList nodes = document.getElementsByTagName("response");
			Element e = (Element) nodes.item(0);
			String Name__Last__First_ = XMLfunctions.getValue(e, isContact ? "Name__Last__First_" : "Name");
			String phone = "";
			phone = (!isContact) ? XMLfunctions.getValue(e, "Phone") : phone;
			String Email1 = XMLfunctions.getValue(e, isContact ? "Personal_Email" : "Email");
			String Home_Fax = XMLfunctions.getValue(e, isContact ? "Home_Fax" : "Fax1");
			String Address1 = XMLfunctions.getValue(e, "Address1");
			String Address2 = XMLfunctions.getValue(e, "Address2");
			String City = XMLfunctions.getValue(e, "City");
			String State = XMLfunctions.getValue(e, "State");
			String Zip = XMLfunctions.getValue(e, "Zip");
			String Country = XMLfunctions.getValue(e, "Country");
			String Profile = XMLfunctions.getValue(e, "Profile");
			String success = XMLfunctions.getValue(e, "success");
			String error = XMLfunctions.getValue(e, "error");
			SearchItem item = new SearchItem();
			item.set(1, Name__Last__First_);
			item.set(2, phone);
			item.set(3, phone);
			item.set(4, Email1);
			item.set(5, Home_Fax);
			item.set(6, Address1);
			item.set(7, Address2);
			item.set(8, City);
			item.set(9, State);
			item.set(10, Zip);
			item.set(11, Profile);
			item.set(12, Country);
			item.set(13, success);
			item.set(14, error);
			return item;
		} catch (Exception e) {
			line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
			line = null;
		}
		return null;
	}

}