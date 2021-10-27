class n12048547 {
	public static void importDB(String cjExT409, String sPoQlTfW) {
		try {
			Class.forName("org.sqlite.JDBC");
			String ctUveTDt = sPoQlTfW + File.separator + G.databaseName;
			File Cw52wsNt = new File(ctUveTDt);
			if (!Cw52wsNt.exists()) {
				G.conn = DriverManager.getConnection("jdbc:sqlite:" + ctUveTDt);
				createTablesDB();
			} else
				G.conn = DriverManager.getConnection("jdbc:sqlite:" + ctUveTDt);
			long Jq5nVmui = System.currentTimeMillis();
			String cOmgOm2h = cjExT409 + File.separator;
			File Wbv8G2AV = new File(cOmgOm2h);
			String[] wEosrrW5 = Wbv8G2AV.list();
			File g6xjE7bS = new File(cjExT409 + File.separator + G.imagesName);
			if (!g6xjE7bS.exists()) {
				JOptionPane.showMessageDialog(null, "No se encuentra el fichero XML", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				SAXBuilder YTEIaTib = new SAXBuilder(false);
				Document zXotDwra = YTEIaTib.build(g6xjE7bS);
				Element IImh5Zzs = zXotDwra.getRootElement();
				List EzKqgi1C = IImh5Zzs.getChildren("image");
				Iterator s4YEqFpN = EzKqgi1C.iterator();
				List<Element> hJ3X37y4 = IImh5Zzs.getChild("languages").getChildren("language");
				Iterator<Element> sSPRR8Eq = hJ3X37y4.iterator();
				HashMap<String, Integer> Ywp6m0GN = new HashMap<String, Integer>();
				HashMap<String, Integer> M7AbxyqT = new HashMap<String, Integer>();
				Element T2IMUD07;
				int UPKPDGrD = 0;
				int qxZjqEfw = 0;
				int mWge2b4l = 0;
				while (sSPRR8Eq.hasNext()) {
					T2IMUD07 = sSPRR8Eq.next();
					Ywp6m0GN.put(T2IMUD07.getText(), UPKPDGrD);
					PreparedStatement qQmjzH0I = G.conn
							.prepareStatement("INSERT OR IGNORE INTO language (id,name) VALUES (?,?)");
					qQmjzH0I.setInt(1, UPKPDGrD);
					qQmjzH0I.setString(2, T2IMUD07.getText());
					qQmjzH0I.executeUpdate();
					qQmjzH0I.close();
					UPKPDGrD++;
				}
				G.conn.setAutoCommit(false);
				while (s4YEqFpN.hasNext()) {
					Element Alt2KYcq = (Element) s4YEqFpN.next();
					String Vv0PXoPR = Alt2KYcq.getAttributeValue("id");
					List VOp5oK7U = Alt2KYcq.getChildren("language");
					Iterator qtOQmYmF = VOp5oK7U.iterator();
					if (exists(wEosrrW5, Vv0PXoPR)) {
						String gG8VPnmK = cOmgOm2h.concat(Vv0PXoPR);
						String oKbMnrlf = sPoQlTfW + File.separator + Vv0PXoPR.substring(0, 1).toUpperCase()
								+ File.separator;
						String xa4ogKcU = sPoQlTfW + File.separator + Vv0PXoPR.substring(0, 1).toUpperCase();
						String wXkvhlWC = oKbMnrlf.concat(Vv0PXoPR);
						String jX9viJSZ = Vv0PXoPR;
						File G1DQ7lje = new File(wXkvhlWC);
						int uMbZR1e3 = 1;
						while (G1DQ7lje.exists()) {
							jX9viJSZ = Vv0PXoPR.substring(0, Vv0PXoPR.lastIndexOf('.')) + '_' + uMbZR1e3
									+ Vv0PXoPR.substring(Vv0PXoPR.lastIndexOf('.'), Vv0PXoPR.length());
							wXkvhlWC = oKbMnrlf + jX9viJSZ;
							G1DQ7lje = new File(wXkvhlWC);
							uMbZR1e3++;
						}
						oKbMnrlf = wXkvhlWC;
						Vv0PXoPR = jX9viJSZ;
						File N0KhDjKv = new File(xa4ogKcU);
						if (!N0KhDjKv.exists()) {
							N0KhDjKv.mkdirs();
						}
						try {
							FileChannel Z3JOyFJd = new FileInputStream(gG8VPnmK).getChannel();
							FileChannel dHViE9Tx = new FileOutputStream(oKbMnrlf).getChannel();
							dHViE9Tx.transferFrom(Z3JOyFJd, 0, Z3JOyFJd.size());
							Z3JOyFJd.close();
							dHViE9Tx.close();
						} catch (IOException hoIbjk3H) {
							System.out.println(hoIbjk3H.toString());
						}
						while (qtOQmYmF.hasNext()) {
							Element JoXITPYn = (Element) qtOQmYmF.next();
							String BltV4j83 = JoXITPYn.getAttributeValue("id");
							List FfTbvits = JoXITPYn.getChildren("word");
							Iterator Qt3qz7L5 = FfTbvits.iterator();
							while (Qt3qz7L5.hasNext()) {
								Element NUqiNgEd = (Element) Qt3qz7L5.next();
								String c0jWK7ja = NUqiNgEd.getAttributeValue("type");
								if (!M7AbxyqT.containsKey(c0jWK7ja)) {
									M7AbxyqT.put(c0jWK7ja, qxZjqEfw);
									PreparedStatement aGU85FBj = G.conn
											.prepareStatement("INSERT OR IGNORE INTO type (id,name) VALUES (?,?)");
									aGU85FBj.setInt(1, qxZjqEfw);
									aGU85FBj.setString(2, c0jWK7ja);
									aGU85FBj.executeUpdate();
									aGU85FBj.close();
									qxZjqEfw++;
								}
								PreparedStatement UakgfHCP = G.conn.prepareStatement(
										"INSERT OR IGNORE INTO main (word, idL, idT, name, nameNN) VALUES (?,?,?,?,?)");
								UakgfHCP.setString(1, NUqiNgEd.getText().toLowerCase());
								UakgfHCP.setInt(2, Ywp6m0GN.get(BltV4j83));
								UakgfHCP.setInt(3, M7AbxyqT.get(c0jWK7ja));
								UakgfHCP.setString(4, Vv0PXoPR);
								UakgfHCP.setString(5, Vv0PXoPR);
								UakgfHCP.executeUpdate();
								UakgfHCP.close();
								if (mWge2b4l == 5000) {
									G.conn.commit();
									mWge2b4l = 0;
								} else
									mWge2b4l++;
							}
						}
					} else {
					}
				}
				G.conn.setAutoCommit(true);
				G.conn.close();
				long iCxOuQA9 = System.currentTimeMillis() - Jq5nVmui;
				System.out.println("El tiempo total es :" + iCxOuQA9 / 1000 + " segundos");
			}
		} catch (Exception BL6Qi01i) {
			BL6Qi01i.printStackTrace();
		}
	}

}