class n19925085 {
	public static void main(String[] J0SCVpjE) {
		JFileChooser jCEhCCE4 = new JFileChooser();
		jCEhCCE4.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jCEhCCE4.setMultiSelectionEnabled(false);
		int TF4kc98b = jCEhCCE4.showOpenDialog(null);
		if (TF4kc98b == JFileChooser.CANCEL_OPTION) {
			System.exit(TF4kc98b);
		}
		File WzYsJigf = jCEhCCE4.getSelectedFile();
		ArrayList<File> FH5yaLOk = new ArrayList<File>();
		goThrough(WzYsJigf, FH5yaLOk);
		SearchClient FBghT5O6 = new SearchClient("VZFo5W5i");
		MyID3 O0lQwADS = new MyID3();
		for (File qx5uqQj6 : FH5yaLOk) {
			try {
				MusicMetadataSet VkNfIJfL = O0lQwADS.read(qx5uqQj6);
				IMusicMetadata yLnwjapu = VkNfIJfL.getSimplified();
				String Ov5qlBOE = qx5uqQj6.getName();
				if (yLnwjapu.getAlbum() != null) {
					Ov5qlBOE = yLnwjapu.getAlbum();
				} else if (yLnwjapu.getArtist() != null) {
					Ov5qlBOE = yLnwjapu.getArtist();
				}
				if (Ov5qlBOE.length() > 2) {
					ImageSearchRequest wMZZHt3G = new ImageSearchRequest(Ov5qlBOE);
					ImageSearchResults VpVG085Z = FBghT5O6.imageSearch(wMZZHt3G);
					if (VpVG085Z.getTotalResultsAvailable().doubleValue() > 1) {
						System.out.println("Downloading " + VpVG085Z.listResults()[0].getUrl());
						URL I6Aw6ApR = new URL(VpVG085Z.listResults()[0].getUrl());
						URLConnection VrH2YKYr = I6Aw6ApR.openConnection();
						VrH2YKYr.setConnectTimeout(10000);
						int tPfJZi6d = VrH2YKYr.getContentLength();
						if (tPfJZi6d > 0) {
							String ubagtLEQ = VrH2YKYr.getContentType();
							InputStream JdrQaPdL = VrH2YKYr.getInputStream();
							byte[] MvbWOown = new byte[tPfJZi6d];
							for (int z17eOQ4M = 0; z17eOQ4M < tPfJZi6d; z17eOQ4M++) {
								JdrQaPdL.read(MvbWOown, z17eOQ4M, 1);
							}
							JdrQaPdL.close();
							ImageData M1GNDUhF = new ImageData(MvbWOown, ubagtLEQ, Ov5qlBOE, 0);
							yLnwjapu.addPicture(M1GNDUhF);
							File AGOknP97 = File.createTempFile("tempsong", "mp3");
							O0lQwADS.write(qx5uqQj6, AGOknP97, VkNfIJfL, yLnwjapu);
							FileChannel HLAEv2qb = new FileInputStream(AGOknP97).getChannel();
							FileChannel zG895vOr = new FileOutputStream(qx5uqQj6).getChannel();
							try {
								HLAEv2qb.transferTo(0, HLAEv2qb.size(), zG895vOr);
							} catch (IOException dG7scVHp) {
								throw dG7scVHp;
							} finally {
								if (HLAEv2qb != null)
									HLAEv2qb.close();
								if (zG895vOr != null)
									zG895vOr.close();
							}
							AGOknP97.delete();
						}
					}
				}
			} catch (ID3ReadException dXBzK17Z) {
			} catch (MalformedURLException Xu8p2sRN) {
			} catch (UnsupportedEncodingException zd2VBtah) {
			} catch (ID3WriteException r3Oc4JO4) {
			} catch (IOException sfiBLJ38) {
			} catch (SearchException a9vgQuWd) {
			}
		}
	}

}