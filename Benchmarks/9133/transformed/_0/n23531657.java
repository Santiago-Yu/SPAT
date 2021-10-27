class n23531657 {
	public void imagesParserAssesmentItem(int EFDKurtD, int gq83lcLh, Resource bAAy6mg4) {
		NodeList mkc80gUn = null;
		Node wu6OkWwv = null;
		NamedNodeMap coyU4pbL = null;
		Node kLxnLnL7 = null;
		URL s2k1pM5o = null;
		String OFMjrStY = "";
		String gJbBbW6d = "";
		int oHPygSsR;
		String MvJXHqP3 = "";
		try {
			if (EFDKurtD == 1) {
				mkc80gUn = doc.getElementsByTagName("img");
			} else {
				mkc80gUn = doc_[gq83lcLh].getElementsByTagName("img");
			}
			for (int V0aztuQR = 0; V0aztuQR < mkc80gUn.getLength(); V0aztuQR++) {
				wu6OkWwv = mkc80gUn.item(V0aztuQR);
				coyU4pbL = wu6OkWwv.getAttributes();
				kLxnLnL7 = coyU4pbL.getNamedItem("src");
				String lTeqxxXm = kLxnLnL7.getTextContent();
				s2k1pM5o = new URL("file", "localhost", lTeqxxXm);
				MvJXHqP3 = s2k1pM5o.getPath();
				MvJXHqP3 = MvJXHqP3.replace('/', File.separatorChar);
				int ue0o113a = MvJXHqP3.indexOf(File.separatorChar);
				String dVGP8UFV = MvJXHqP3.substring(ue0o113a + 1);
				oHPygSsR = MvJXHqP3.lastIndexOf(File.separatorChar);
				OFMjrStY = MvJXHqP3.substring(oHPygSsR + 1);
				gJbBbW6d = this.sTempLocation + OFMjrStY;
				FileChannel FcyADowh = null;
				FileChannel HvTVsTH0 = null;
				try {
					FcyADowh = new FileInputStream(dVGP8UFV).getChannel();
					HvTVsTH0 = new FileOutputStream(gJbBbW6d).getChannel();
					long svowrr5f = FcyADowh.size();
					MappedByteBuffer vtkS5z4z = FcyADowh.map(FileChannel.MapMode.READ_ONLY, 0, svowrr5f);
					HvTVsTH0.write(vtkS5z4z);
				} finally {
					if (FcyADowh != null)
						FcyADowh.close();
					if (HvTVsTH0 != null)
						HvTVsTH0.close();
				}
				if (EFDKurtD == 1) {
					sXml = sXml.replace(kLxnLnL7.getTextContent(), OFMjrStY);
				} else {
					sXml_[gq83lcLh] = sXml_[gq83lcLh].replace(kLxnLnL7.getTextContent(), OFMjrStY);
				}
				lsImages.add(OFMjrStY);
				bAAy6mg4.addFile(OFMjrStY);
			}
		} catch (MalformedURLException RlCwARya) {
			RlCwARya.printStackTrace();
		} catch (IOException v5Uh0XlV) {
			v5Uh0XlV.printStackTrace();
		}
	}

}