class n2632928 {
	public DicomData load(String QSr3F13U) {
		dicomData = new DicomData();
		try {
			URL eOATiZSg = new URL(QSr3F13U);
			BufferedInputStream DOMqin8x = new BufferedInputStream(eOATiZSg.openStream());
			DataInputStream c8xPaPHT = new DataInputStream(DOMqin8x);
			int jXL4BbHg;
			byte[] l2JkEuS3 = new byte[2];
			byte[] Vi7NjX2P = new byte[4];
			String etcemNy1;
			String GQES2Qmp;
			String t722hY9u;
			String ESsvl2B7;
			int T3FyC43l;
			byte[] ngrVCOfD;
			while (c8xPaPHT.read(l2JkEuS3) != -1) {
				jXL4BbHg = readInt2(l2JkEuS3);
				etcemNy1 = Integer.toString((jXL4BbHg & 0x0000f000) >> 12, 16);
				etcemNy1 += Integer.toString((jXL4BbHg & 0x00000f00) >> 8, 16);
				etcemNy1 += Integer.toString((jXL4BbHg & 0x000000f0) >> 4, 16);
				etcemNy1 += Integer.toString((jXL4BbHg & 0x0000000f), 16);
				c8xPaPHT.readFully(l2JkEuS3);
				jXL4BbHg = readInt2(l2JkEuS3);
				GQES2Qmp = Integer.toString((jXL4BbHg & 0x0000f000) >> 12, 16);
				GQES2Qmp += Integer.toString((jXL4BbHg & 0x00000f00) >> 8, 16);
				GQES2Qmp += Integer.toString((jXL4BbHg & 0x000000f0) >> 4, 16);
				GQES2Qmp += Integer.toString((jXL4BbHg & 0x0000000f), 16);
				t722hY9u = ("(" + etcemNy1 + "," + GQES2Qmp + ")");
				if (debug_level > 3)
					System.out.println("currentTag is : " + t722hY9u);
				dicomData.setTag(t722hY9u);
				containDic = dicomDic.isContain(t722hY9u);
				if (vrType && !VReqSQ) {
					StringBuffer Xq6Mvhs3 = new StringBuffer(2);
					c8xPaPHT.readFully(l2JkEuS3);
					for (int erb40NXw = 0; erb40NXw < 2; erb40NXw++)
						Xq6Mvhs3.append((char) l2JkEuS3[erb40NXw]);
					dicomData.setVR(t722hY9u, Xq6Mvhs3.toString());
					if (Xq6Mvhs3.toString().equals("OB") || Xq6Mvhs3.toString().equals("OW")
							|| Xq6Mvhs3.toString().equals("SQ")) {
						c8xPaPHT.skip(2);
						c8xPaPHT.readFully(Vi7NjX2P);
						T3FyC43l = readInt4(Vi7NjX2P);
					} else {
						c8xPaPHT.readFully(l2JkEuS3);
						T3FyC43l = readInt2(l2JkEuS3);
					}
				} else {
					if (containDic)
						dicomData.setVR(t722hY9u, dicomDic.getVR(t722hY9u));
					else
						dicomData.setVR(t722hY9u, "na");
					c8xPaPHT.readFully(Vi7NjX2P);
					T3FyC43l = readInt4(Vi7NjX2P);
				}
				if (t722hY9u.equals("(fffe,e0dd)"))
					VReqSQ = false;
				ESsvl2B7 = dicomData.getVR(t722hY9u);
				if (debug_level > 3)
					System.out.println("currentVR is : " + ESsvl2B7);
				if (debug_level > 3)
					System.out.println("currentLength: " + T3FyC43l);
				if (T3FyC43l == -1) {
					VReqSQ = true;
					T3FyC43l = 0;
				}
				ngrVCOfD = new byte[T3FyC43l];
				c8xPaPHT.readFully(ngrVCOfD);
				dicomData.setValue(t722hY9u, ngrVCOfD);
				if (containDic) {
					dicomData.setName(t722hY9u, dicomDic.getName(t722hY9u));
					dicomData.setVM(t722hY9u, dicomDic.getVM(t722hY9u));
					dicomData.setVersion(t722hY9u, dicomDic.getVersion(t722hY9u));
				} else {
					dicomData.setName(t722hY9u, "NotContainedInDICOMDictionary");
					dicomData.setVM(t722hY9u, "na");
					dicomData.setVersion(t722hY9u, "na");
				}
				if (debug_level > 3)
					System.out.println("currentName is : " + dicomData.getName(t722hY9u));
				this.analyzer(t722hY9u, ESsvl2B7);
			}
			c8xPaPHT.close();
			DOMqin8x.close();
		} catch (EOFException iQ7Xahjw) {
			System.out.println("DicomFile.EOFException: " + iQ7Xahjw.getMessage());
		} catch (IOException DvdRJDCL) {
			System.out.println("DicomFile.IOException: " + DvdRJDCL.getMessage());
		} catch (Exception XNIG7Cuw) {
			System.out.println("DicomFile.Exception: " + XNIG7Cuw.getMessage());
		}
		if (patientPrivacy) {
			String ihH0sDPb;
			ihH0sDPb = dicomData.getAnalyzedValue("(0010,0010)");
			StringBuffer V1M9BaEJ = new StringBuffer(ihH0sDPb);
			for (int NWckoXvL = 0; NWckoXvL < ihH0sDPb.length(); NWckoXvL++) {
				if (NWckoXvL % 2 == 1)
					V1M9BaEJ.setCharAt(NWckoXvL, '*');
			}
			dicomData.setAnalyzedValue("(0010,0010)", V1M9BaEJ.toString());
		}
		return dicomData;
	}

}