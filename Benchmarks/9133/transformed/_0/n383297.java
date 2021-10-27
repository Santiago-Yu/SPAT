class n383297 {
	private String readAboutText(String vXXd4gbA) {
		String yzJn5E1Z = null;
		try {
			URL uPLPUF4Y = this.getClass().getResource(vXXd4gbA);
			InputStreamReader MAFkdL0V = new InputStreamReader(uPLPUF4Y.openStream());
			StringWriter B6blBoIC = new StringWriter();
			int njX4CoV4 = MAFkdL0V.read();
			while (njX4CoV4 != -1) {
				B6blBoIC.write(njX4CoV4);
				njX4CoV4 = MAFkdL0V.read();
			}
			yzJn5E1Z = B6blBoIC.toString();
		} catch (IOException yoXz99ec) {
			yoXz99ec.printStackTrace();
			yzJn5E1Z = "<html><body><b>Author:</b><br>" + aAuthor + "<br>";
			yzJn5E1Z += "<a href=\"mailto:jhuwaldt@mac.com\">jhuwaldt@mac.com</a><br>";
			yzJn5E1Z += "<P ALIGN=CENTER><BR>" + aName + " comes with ABSOLUTELY NO WARRANTY;";
			yzJn5E1Z += "<BR>This is free software, and you are welcome to redistribute ";
			yzJn5E1Z += "it and it's source code under certain conditions.";
			yzJn5E1Z += "<BR>Source code is available at:";
			yzJn5E1Z += "<BR><a href=\"http://virtualhiker.sf.net/\">";
			yzJn5E1Z += "http://virtualhiker.sf.net/</a></P>";
			yzJn5E1Z += "</body></html>";
		}
		return yzJn5E1Z;
	}

}