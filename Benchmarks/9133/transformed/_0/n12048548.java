class n12048548 {
	public static void exportDB(String YRgn9mB7, String r9YJm46C) {
		try {
			Class.forName("org.sqlite.JDBC");
			String Z4ZTYmOM = YRgn9mB7 + File.separator + G.databaseName;
			File uDMmwZi3 = new File(Z4ZTYmOM);
			if (!uDMmwZi3.exists()) {
				JOptionPane.showMessageDialog(null, "No se encuentra el fichero DB", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				G.conn = DriverManager.getConnection("jdbc:sqlite:" + Z4ZTYmOM);
				HashMap<Integer, String> tL33wecn = new HashMap<Integer, String>();
				HashMap<Integer, String> j7yWruyf = new HashMap<Integer, String>();
				long GxBrhcaQ = System.currentTimeMillis();
				Element qTRFb8xK = new Element("database");
				Element JpdpeWB9 = new Element("languages");
				Statement NZkhRAgl = G.conn.createStatement();
				ResultSet jPqArkCU = NZkhRAgl.executeQuery("select * from language order by id");
				while (jPqArkCU.next()) {
					int IuIHOEc0 = jPqArkCU.getInt("id");
					String Q09bZEYs = jPqArkCU.getString("name");
					tL33wecn.put(IuIHOEc0, Q09bZEYs);
					Element RlxdDECa = new Element("language");
					RlxdDECa.setText(Q09bZEYs);
					JpdpeWB9.addContent(RlxdDECa);
				}
				qTRFb8xK.addContent(JpdpeWB9);
				jPqArkCU = NZkhRAgl.executeQuery("select * from type order by id");
				while (jPqArkCU.next()) {
					int zxWmwhQs = jPqArkCU.getInt("id");
					String XPAQvQI7 = jPqArkCU.getString("name");
					j7yWruyf.put(zxWmwhQs, XPAQvQI7);
				}
				jPqArkCU = NZkhRAgl.executeQuery("select distinct name from main order by name");
				while (jPqArkCU.next()) {
					String NWPA3jcL = jPqArkCU.getString("name");
					Element hkA765HW = new Element("image");
					hkA765HW.setAttribute("id", NWPA3jcL);
					Statement OQ64PlRN = G.conn.createStatement();
					ResultSet qZp9xMY2 = OQ64PlRN.executeQuery(
							"select distinct idL from main where name = \"" + NWPA3jcL + "\" order by idL");
					while (qZp9xMY2.next()) {
						int siTyyA8Z = qZp9xMY2.getInt("idL");
						Element YbyBM2a6 = new Element("language");
						YbyBM2a6.setAttribute("id", tL33wecn.get(siTyyA8Z));
						Statement XJ8Ro1x8 = G.conn.createStatement();
						ResultSet xbUVCZLp = XJ8Ro1x8.executeQuery("select * from main where name = \"" + NWPA3jcL
								+ "\" and idL = " + siTyyA8Z + " order by idT");
						while (xbUVCZLp.next()) {
							int z3ttwCrJ = xbUVCZLp.getInt("idT");
							String B9in7vvQ = xbUVCZLp.getString("word");
							Element Quloo0yl = new Element("word");
							Quloo0yl.setAttribute("type", j7yWruyf.get(z3ttwCrJ));
							Quloo0yl.setText(B9in7vvQ);
							YbyBM2a6.addContent(Quloo0yl);
							String bYnDueMi = YRgn9mB7 + File.separator + NWPA3jcL.substring(0, 1).toUpperCase()
									+ File.separator + NWPA3jcL;
							String Uo0LyUk4 = r9YJm46C + File.separator + NWPA3jcL;
							try {
								FileChannel PXP7YMCd = new FileInputStream(bYnDueMi).getChannel();
								FileChannel EtOEXSbn = new FileOutputStream(Uo0LyUk4).getChannel();
								EtOEXSbn.transferFrom(PXP7YMCd, 0, PXP7YMCd.size());
								PXP7YMCd.close();
								EtOEXSbn.close();
							} catch (IOException eUEktAzs) {
								System.out.println(eUEktAzs.getMessage());
								System.out.println(eUEktAzs.toString());
							}
						}
						xbUVCZLp.close();
						XJ8Ro1x8.close();
						hkA765HW.addContent(YbyBM2a6);
					}
					qZp9xMY2.close();
					OQ64PlRN.close();
					qTRFb8xK.addContent(hkA765HW);
				}
				jPqArkCU.close();
				NZkhRAgl.close();
				XMLOutputter s5QZLtEu = new XMLOutputter(Format.getPrettyFormat());
				FileOutputStream y9GYSVjp = new FileOutputStream(r9YJm46C + File.separator + G.imagesName);
				s5QZLtEu.output(qTRFb8xK, y9GYSVjp);
				y9GYSVjp.flush();
				y9GYSVjp.close();
				long SU2nmWxh = System.currentTimeMillis() - GxBrhcaQ;
				System.out.println("El tiempo total es :" + SU2nmWxh / 1000 + " segundos");
			}
		} catch (Exception YIFd64wu) {
			YIFd64wu.printStackTrace();
		}
	}

}