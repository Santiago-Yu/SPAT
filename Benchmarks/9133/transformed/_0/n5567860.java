class n5567860 {
	public String getClass(EmeraldjbBean SuJd1UXr) throws EmeraldjbException {
		Entity DiknkjHk = (Entity) SuJd1UXr;
		StringBuffer S9323gsp = new StringBuffer();
		String l4PbPe5R = getPackageName(SuJd1UXr);
		S9323gsp.append("package " + l4PbPe5R + ";\n");
		S9323gsp.append("\n");
		DaoValuesGenerator jOkQTlJD = new DaoValuesGenerator();
		String wMo0w5Bm = jOkQTlJD.getClassName(DiknkjHk);
		S9323gsp.append("\n");
		List OW9kSkjR = new Vector();
		OW9kSkjR.add("java.io.FileOutputStream;");
		OW9kSkjR.add("java.io.FileInputStream;");
		OW9kSkjR.add("java.io.DataInputStream;");
		OW9kSkjR.add("java.io.DataOutputStream;");
		OW9kSkjR.add("java.io.IOException;");
		OW9kSkjR.add("java.sql.Date;");
		OW9kSkjR.add(jOkQTlJD.getPackageName(SuJd1UXr) + "." + wMo0w5Bm + ";");
		Iterator MjuzyLZf = OW9kSkjR.iterator();
		while (MjuzyLZf.hasNext()) {
			String xRP79zxF = (String) MjuzyLZf.next();
			S9323gsp.append("import " + xRP79zxF + "\n");
		}
		S9323gsp.append("\n");
		String W3W1mCuL = DiknkjHk.getPatternValue(GeneratorConst.PATTERN_STREAM_PROTO_VERSION, "1");
		String aJFF4h8z = getClassName(DiknkjHk);
		S9323gsp.append("public class " + aJFF4h8z + "\n");
		S9323gsp.append("{" + "\n  public static final int PROTO_VERSION=" + W3W1mCuL + ";");
		S9323gsp.append("\n\n");
		StringBuffer gNq6eBnc = new StringBuffer();
		StringBuffer ysmRm77v = new StringBuffer();
		boolean KPUSiqOU = false;
		boolean tW8lap8A = false;
		MjuzyLZf = DiknkjHk.getMembers().iterator();
		while (MjuzyLZf.hasNext()) {
			Member W7BTi2Kq = (Member) MjuzyLZf.next();
			String urZDbJSh = W7BTi2Kq.getName();
			String zVMdSh5n = "obj." + methodGenerator.getMethodName(DaoGeneratorUtils.METHOD_GET, W7BTi2Kq);
			String HT28XyXi = "obj." + methodGenerator.getMethodName(DaoGeneratorUtils.METHOD_SET, W7BTi2Kq);
			String FY0ZCeIX = "    ";
			JTypeBase SCQ3TRXv = EmdFactory.getJTypeFactory().getJavaType(W7BTi2Kq.getType());
			gNq6eBnc.append(SCQ3TRXv.getToBinaryCode(FY0ZCeIX, "dos", zVMdSh5n + "()"));
			ysmRm77v.append(SCQ3TRXv.getFromBinaryCode(FY0ZCeIX, "din", HT28XyXi));
		}
		String ZtGBF870 = "";
		S9323gsp.append("\n  public static void writeToFile(String file_nm, " + wMo0w5Bm + " obj) throws IOException"
				+ "\n  {"
				+ "\n    if (file_nm==null || file_nm.length()==0) throw new IOException(\"Bad file name (null or zero length)\");"
				+ "\n    if (obj==null) throw new IOException(\"Bad value object parameter, cannot write null object to file\");"
				+ "\n    FileOutputStream fos = new FileOutputStream(file_nm);"
				+ "\n    DataOutputStream dos = new DataOutputStream(fos);" + "\n    writeStream(dos, obj);"
				+ "\n    fos.close();" + "\n  } // end of writeToFile" + "\n"
				+ "\n  public static void readFromFile(String file_nm, " + wMo0w5Bm + " obj) throws IOException"
				+ "\n  {"
				+ "\n    if (file_nm==null || file_nm.length()==0) throw new IOException(\"Bad file name (null or zero length)\");"
				+ "\n    if (obj==null) throw new IOException(\"Bad value object parameter, cannot write null object to file\");"
				+ "\n    FileInputStream fis = new FileInputStream(file_nm);"
				+ "\n    DataInputStream dis = new DataInputStream(fis);" + "\n    readStream(dis, obj);"
				+ "\n    fis.close();" + "\n  } // end of readFromFile" + "\n"
				+ "\n  public static void writeStream(DataOutputStream dos, " + wMo0w5Bm + " obj) throws IOException"
				+ "\n  {" + "\n    dos.writeByte(PROTO_VERSION);" + "\n    " + gNq6eBnc + "\n  } // end of writeStream"
				+ "\n" + "\n  public static void readStream(DataInputStream din, " + wMo0w5Bm
				+ " obj) throws IOException" + "\n  {" + "\n    int proto_version = din.readByte();"
				+ "\n    if (proto_version==" + W3W1mCuL + ") readStreamV1(din,obj);" + "\n  } // end of readStream"
				+ "\n" + "\n  public static void readStreamV1(DataInputStream din, " + wMo0w5Bm
				+ " obj) throws IOException" + "\n  {" + ZtGBF870 + ysmRm77v + "\n  } // end of readStreamV1" + "\n"
				+ "\n} // end of classs" + "\n\n" + "\n//**************" + "\n// End of file" + "\n//**************");
		return S9323gsp.toString();
	}

}