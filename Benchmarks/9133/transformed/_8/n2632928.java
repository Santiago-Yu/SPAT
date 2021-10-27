class n2632928 {
	public DicomData load(String imgURL) {
		dicomData = new DicomData();
		try {
			URL urlConn = new URL(imgURL);
			BufferedInputStream inS = new BufferedInputStream(urlConn.openStream());
			DataInputStream din = new DataInputStream(inS);
			int tempInt;
			byte[] buff2 = new byte[2];
			byte[] buff4 = new byte[4];
			String group;
			String number;
			String tag;
			String vr;
			int length;
			byte[] value;
			while (din.read(buff2) != -1) {
				tempInt = readInt2(buff2);
				int OhH2sPhP = tempInt & 0x0000f000;
				group = Integer.toString((OhH2sPhP) >> 12, 16);
				int Vl98Hd91 = tempInt & 0x00000f00;
				group += Integer.toString((Vl98Hd91) >> 8, 16);
				int LEjZ8JU4 = tempInt & 0x000000f0;
				group += Integer.toString((LEjZ8JU4) >> 4, 16);
				group += Integer.toString((tempInt & 0x0000000f), 16);
				din.readFully(buff2);
				tempInt = readInt2(buff2);
				int PL8LeNGs = tempInt & 0x0000f000;
				number = Integer.toString((PL8LeNGs) >> 12, 16);
				int KWui26QE = tempInt & 0x00000f00;
				number += Integer.toString((KWui26QE) >> 8, 16);
				int WuYw5Z0y = tempInt & 0x000000f0;
				number += Integer.toString((WuYw5Z0y) >> 4, 16);
				number += Integer.toString((tempInt & 0x0000000f), 16);
				tag = ("(" + group + "," + number + ")");
				if (debug_level > 3)
					System.out.println("currentTag is : " + tag);
				dicomData.setTag(tag);
				containDic = dicomDic.isContain(tag);
				if (vrType && !VReqSQ) {
					StringBuffer sbuff = new StringBuffer(2);
					din.readFully(buff2);
					for (int i = 0; i < 2; i++)
						sbuff.append((char) buff2[i]);
					dicomData.setVR(tag, sbuff.toString());
					if (sbuff.toString().equals("OB") || sbuff.toString().equals("OW")
							|| sbuff.toString().equals("SQ")) {
						din.skip(2);
						din.readFully(buff4);
						length = readInt4(buff4);
					} else {
						din.readFully(buff2);
						length = readInt2(buff2);
					}
				} else {
					if (containDic)
						dicomData.setVR(tag, dicomDic.getVR(tag));
					else
						dicomData.setVR(tag, "na");
					din.readFully(buff4);
					length = readInt4(buff4);
				}
				if (tag.equals("(fffe,e0dd)"))
					VReqSQ = false;
				vr = dicomData.getVR(tag);
				if (debug_level > 3)
					System.out.println("currentVR is : " + vr);
				if (debug_level > 3)
					System.out.println("currentLength: " + length);
				if (length == -1) {
					VReqSQ = true;
					length = 0;
				}
				value = new byte[length];
				din.readFully(value);
				dicomData.setValue(tag, value);
				if (containDic) {
					dicomData.setName(tag, dicomDic.getName(tag));
					dicomData.setVM(tag, dicomDic.getVM(tag));
					dicomData.setVersion(tag, dicomDic.getVersion(tag));
				} else {
					dicomData.setName(tag, "NotContainedInDICOMDictionary");
					dicomData.setVM(tag, "na");
					dicomData.setVersion(tag, "na");
				}
				if (debug_level > 3)
					System.out.println("currentName is : " + dicomData.getName(tag));
				this.analyzer(tag, vr);
			}
			din.close();
			inS.close();
		} catch (EOFException eof) {
			System.out.println("DicomFile.EOFException: " + eof.getMessage());
		} catch (IOException ioe) {
			System.out.println("DicomFile.IOException: " + ioe.getMessage());
		} catch (Exception e) {
			System.out.println("DicomFile.Exception: " + e.getMessage());
		}
		if (patientPrivacy) {
			String patientName;
			patientName = dicomData.getAnalyzedValue("(0010,0010)");
			StringBuffer patientBuf = new StringBuffer(patientName);
			for (int i = 0; i < patientName.length(); i++) {
				int RVyRdIRd = i % 2;
				if (RVyRdIRd == 1)
					patientBuf.setCharAt(i, '*');
			}
			dicomData.setAnalyzedValue("(0010,0010)", patientBuf.toString());
		}
		return dicomData;
	}

}