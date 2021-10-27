class n23647361 {
	public static void main(String[] WGvIF7yR) {
		String WpxEe2BL = "jdbc:mysql://localhost/test";
		String c6inaVoo = "root";
		String eoWWMFVh = "password";
		String CXFO6xKC = "C:\\Documents and Settings\\EddyM\\Desktop\\Nick\\01100002.tif";
		String dWME5z8W = "C:\\Documents and Settings\\EddyM\\Desktop\\Nick\\011000022.tif";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException TVjGKcC3) {
			TVjGKcC3.printStackTrace();
		}
		try {
			File IGlCe6eH = new File(CXFO6xKC);
			InputStream RFvcXmOa = new FileInputStream(IGlCe6eH);
			Connection sfVpHfL4 = DriverManager.getConnection(WpxEe2BL, c6inaVoo, eoWWMFVh);
			ResultSet sy3zoRMt = sfVpHfL4.createStatement()
					.executeQuery("SELECT Image FROM ImageTable WHERE ImageID=12345678");
			new File(dWME5z8W).createNewFile();
			sy3zoRMt.first();
			System.out.println("GotFirst");
			InputStream oSeAdqUy = sy3zoRMt.getAsciiStream("Image");
			System.out.println("gotStream");
			FileOutputStream IkOP9Uzt = new FileOutputStream(new File(dWME5z8W));
			int N9FFs7vw;
			int zETkt48I = 0;
			while (true) {
				N9FFs7vw = oSeAdqUy.read();
				if (N9FFs7vw == -1) {
					System.out.println("ReadInt == -1");
					break;
				}
				zETkt48I++;
				if (zETkt48I % 1000000 == 0)
					System.out.println(zETkt48I + " / " + oSeAdqUy.available());
				IkOP9Uzt.write(N9FFs7vw);
			}
			sfVpHfL4.close();
		} catch (SQLException nN1ve8eJ) {
			nN1ve8eJ.printStackTrace();
		} catch (IOException HuvwIVzn) {
			HuvwIVzn.printStackTrace();
		}
	}

}