class n10480051 {
	public static RecordResponse loadRecord(RecordRequest bcVkh9g1) {
		RecordResponse NnZP3T7k = new RecordResponse();
		try {
			DefaultHttpClient KJiVuwuk = new DefaultHttpClient();
			HttpPost TSmYIyRn = new HttpPost(bcVkh9g1.isContact() ? URL_RECORD_CONTACT : URL_RECORD_COMPANY);
			List<NameValuePair> d3EWUQSE = new ArrayList<NameValuePair>(6);
			d3EWUQSE.add(new BasicNameValuePair("format", "xml"));
			d3EWUQSE.add(new BasicNameValuePair("token", bcVkh9g1.getToken()));
			d3EWUQSE.add(new BasicNameValuePair("id", bcVkh9g1.getId()));
			TSmYIyRn.setEntity(new UrlEncodedFormEntity(d3EWUQSE));
			TSmYIyRn.setEntity(new UrlEncodedFormEntity(d3EWUQSE));
			HttpResponse Ag9yYx3i = KJiVuwuk.execute(TSmYIyRn);
			String I6kMrjMj = EntityUtils.toString(Ag9yYx3i.getEntity());
			Document uWZhNodQ = XMLfunctions.XMLfromString(I6kMrjMj);
			NodeList o5EEqcX0 = uWZhNodQ.getElementsByTagName("response");
			Element MdAnbleB = (Element) o5EEqcX0.item(0);
			String pZvlodVW = XMLfunctions.getValue(MdAnbleB, bcVkh9g1.isContact() ? "Name__Last__First_" : "Name");
			String EKY9Qx5Q = "";
			if (!bcVkh9g1.isContact())
				EKY9Qx5Q = XMLfunctions.getValue(MdAnbleB, "Phone");
			String n68znmmU = XMLfunctions.getValue(MdAnbleB, bcVkh9g1.isContact() ? "Personal_Email" : "Email");
			String PgMVQ6QL = XMLfunctions.getValue(MdAnbleB, bcVkh9g1.isContact() ? "Home_Fax" : "Fax1");
			String szWDV8QU = XMLfunctions.getValue(MdAnbleB, "Address1");
			String a9wUeWiS = XMLfunctions.getValue(MdAnbleB, "Address2");
			String nFQHsWO1 = XMLfunctions.getValue(MdAnbleB, "City");
			String y55HIEcC = XMLfunctions.getValue(MdAnbleB, "State");
			String MoLWkMcr = XMLfunctions.getValue(MdAnbleB, "Zip");
			String dAo48ifQ = XMLfunctions.getValue(MdAnbleB, "Country");
			String zlObAbxR = XMLfunctions.getValue(MdAnbleB, "Profile");
			String OuWxD5HI = XMLfunctions.getValue(MdAnbleB, "success");
			String grFiwuF1 = XMLfunctions.getValue(MdAnbleB, "error");
			NnZP3T7k.setName(pZvlodVW);
			NnZP3T7k.setPhone(EKY9Qx5Q);
			NnZP3T7k.setEmail(n68znmmU);
			NnZP3T7k.setHomeFax(PgMVQ6QL);
			NnZP3T7k.setAddress1(szWDV8QU);
			NnZP3T7k.setAddress2(a9wUeWiS);
			NnZP3T7k.setCity(nFQHsWO1);
			NnZP3T7k.setState(y55HIEcC);
			NnZP3T7k.setZip(MoLWkMcr);
			NnZP3T7k.setProfile(zlObAbxR);
			NnZP3T7k.setCountry(dAo48ifQ);
			NnZP3T7k.setSuccess(OuWxD5HI);
			NnZP3T7k.setError(grFiwuF1);
		} catch (Exception jtbGLgkC) {
		}
		return NnZP3T7k;
	}

}