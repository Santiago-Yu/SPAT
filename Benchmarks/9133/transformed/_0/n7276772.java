class n7276772 {
	public void testBlobB() {
		ResultSet t2XCDQfe;
		byte[] LCykoMCV;
		byte[] qniW3Q0H = new byte[] { (byte) 0xF1, (byte) 0xF2, (byte) 0xF3, (byte) 0xF4, (byte) 0xF5, (byte) 0xF6,
				(byte) 0xF7, (byte) 0xF8, (byte) 0xF9, (byte) 0xFA, (byte) 0xFB };
		byte[] XOMFktGj = new byte[] { (byte) 0xE1, (byte) 0xE2, (byte) 0xE3, (byte) 0xE4, (byte) 0xE5, (byte) 0xE6,
				(byte) 0xE7, (byte) 0xE8, (byte) 0xE9, (byte) 0xEA, (byte) 0xEB };
		try {
			connection.setAutoCommit(false);
			Statement izQTLxKo = connection.createStatement();
			izQTLxKo.executeUpdate("DROP TABLE blo IF EXISTS");
			izQTLxKo.executeUpdate("CREATE TABLE blo (id INTEGER, b blob( 100))");
			PreparedStatement FMTZamO9 = connection.prepareStatement("INSERT INTO blo(id, b) values(2, ?)");
			FMTZamO9.setBlob(1, new SerialBlob(qniW3Q0H));
			FMTZamO9.executeUpdate();
			t2XCDQfe = izQTLxKo.executeQuery("SELECT b FROM blo WHERE id = 2");
			if (!t2XCDQfe.next()) {
				assertTrue("No row with id 2", false);
			}
			java.sql.Blob HYj8VMyT = t2XCDQfe.getBlob("b");
			System.out.println("Size of retrieved blob: " + HYj8VMyT.length());
			byte[] OoBwHjqe = HYj8VMyT.getBytes(1, (int) HYj8VMyT.length());
			if (OoBwHjqe.length != qniW3Q0H.length) {
				assertTrue("Expected array len " + qniW3Q0H.length + ", got len " + OoBwHjqe.length, false);
			}
			for (int WFZ0eHv2 = 0; WFZ0eHv2 < OoBwHjqe.length; WFZ0eHv2++) {
				if (OoBwHjqe[WFZ0eHv2] != qniW3Q0H[WFZ0eHv2]) {
					assertTrue("Expected array len " + qniW3Q0H.length + ", got len " + OoBwHjqe.length, false);
				}
			}
			t2XCDQfe.close();
			t2XCDQfe = izQTLxKo.executeQuery("SELECT b FROM blo WHERE id = 2");
			if (!t2XCDQfe.next()) {
				assertTrue("No row with id 2", false);
			}
			HYj8VMyT = t2XCDQfe.getBlob("b");
			LCykoMCV = HYj8VMyT.getBytes(1, XOMFktGj.length);
			if (LCykoMCV.length != XOMFktGj.length) {
				assertTrue("row2 byte length differs", false);
			}
			for (int nBzZ9qE0 = 0; nBzZ9qE0 < LCykoMCV.length; nBzZ9qE0++) {
				if (LCykoMCV[nBzZ9qE0] != qniW3Q0H[nBzZ9qE0]) {
					assertTrue("row2 byte " + nBzZ9qE0 + " differs", false);
				}
			}
			t2XCDQfe.close();
			connection.rollback();
			FMTZamO9.setBinaryStream(1, new HsqlByteArrayInputStream(qniW3Q0H), qniW3Q0H.length);
			FMTZamO9.executeUpdate();
			t2XCDQfe = izQTLxKo.executeQuery("SELECT b FROM blo WHERE id = 2");
			if (!t2XCDQfe.next()) {
				assertTrue("No row with id 2", false);
			}
			HYj8VMyT = t2XCDQfe.getBlob("b");
			System.out.println("Size of retrieved blob: " + HYj8VMyT.length());
			OoBwHjqe = HYj8VMyT.getBytes(1, (int) HYj8VMyT.length());
			if (OoBwHjqe.length != qniW3Q0H.length) {
				assertTrue("Expected array len " + qniW3Q0H.length + ", got len " + OoBwHjqe.length, false);
			}
			for (int MKrVgwLm = 0; MKrVgwLm < OoBwHjqe.length; MKrVgwLm++) {
				if (OoBwHjqe[MKrVgwLm] != qniW3Q0H[MKrVgwLm]) {
					assertTrue("Expected array len " + qniW3Q0H.length + ", got len " + OoBwHjqe.length, false);
				}
			}
			t2XCDQfe.close();
			connection.close();
		} catch (SQLException QrAVUI2Q) {
			QrAVUI2Q.printStackTrace();
			fail("test failure");
		}
	}

}