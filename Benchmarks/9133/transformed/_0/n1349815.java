class n1349815 {
	public String getClass(EmeraldjbBean qiDK59hn) throws EmeraldjbException {
		Entity xxl2qfkJ = (Entity) qiDK59hn;
		StringBuffer st0zKL8a = new StringBuffer();
		String mndM3y21 = getPackageName(qiDK59hn);
		st0zKL8a.append("package " + mndM3y21 + ";\n");
		st0zKL8a.append("\n");
		DaoValuesGenerator mTeXh3u0 = new DaoValuesGenerator();
		String tvSeEYej = mTeXh3u0.getClassName(xxl2qfkJ);
		st0zKL8a.append("\n");
		List LEKb3qm2 = new Vector();
		LEKb3qm2.add("java.io.*;");
		LEKb3qm2.add("java.sql.Date;");
		LEKb3qm2.add("com.emeraldjb.runtime.patternXmlObj.*;");
		LEKb3qm2.add("javax.xml.parsers.*;");
		LEKb3qm2.add("java.text.ParseException;");
		LEKb3qm2.add("org.xml.sax.*;");
		LEKb3qm2.add("org.xml.sax.helpers.*;");
		LEKb3qm2.add(mTeXh3u0.getPackageName(qiDK59hn) + "." + tvSeEYej + ";");
		Iterator dAeKP537 = LEKb3qm2.iterator();
		while (dAeKP537.hasNext()) {
			String EbFW5SST = (String) dAeKP537.next();
			st0zKL8a.append("import " + EbFW5SST + "\n");
		}
		st0zKL8a.append("\n");
		String CrwoJvJz = xxl2qfkJ.getPatternValue(GeneratorConst.PATTERN_STREAM_PROTO_VERSION, "1");
		boolean Hg994Dpt = xxl2qfkJ.getPatternBooleanValue(GeneratorConst.PATTERN_STREAM_XML_SHORT, false);
		StringBuffer FtUaoZu7 = new StringBuffer();
		StringBuffer Dz4f3163 = new StringBuffer();
		StringBuffer aTlIg2F6 = new StringBuffer();
		StringBuffer dSaloO2q = new StringBuffer();
		StringBuffer Hm3vmPRY = new StringBuffer();
		StringBuffer RagJsE5Q = new StringBuffer();
		boolean DrHrUjJu = false;
		Dz4f3163.append("\n  public static final String EL_CLASS_TAG=\"" + tvSeEYej + "\";");
		FtUaoZu7.append("\n    xos.print(\"<!-- This format is optimised for space, below are the column mappings\");");
		boolean la48gMHB = false;
		boolean s2Uxegzi = false;
		dAeKP537 = xxl2qfkJ.getMembers().iterator();
		int VnajVS1A = 0;
		while (dAeKP537.hasNext()) {
			VnajVS1A++;
			Member Nw5PcSwc = (Member) dAeKP537.next();
			String Y1tQsiFG = Nw5PcSwc.getName();
			FtUaoZu7.append("\n    xos.print(\"c" + VnajVS1A + " = " + Y1tQsiFG + "\");");
			String P11ZzsAR = Y1tQsiFG;
			String qw42HenJ = "c" + VnajVS1A;
			String K4hUhvdj = Y1tQsiFG.toUpperCase();
			if (Nw5PcSwc.getColLen() > 0 || !Nw5PcSwc.isNullAllowed()) {
				DrHrUjJu = true;
			}
			String dHb516H2 = "EL_" + K4hUhvdj;
			String AQXibl7s = "EL_" + K4hUhvdj + "_SHORT";
			Dz4f3163.append("\n  public static final String " + dHb516H2 + "=\"" + P11ZzsAR + "\";"
					+ "\n  public static final String " + AQXibl7s + "=\"" + qw42HenJ + "\";");
			String COGmfH1Y = "obj." + methodGenerator.getMethodName(DaoGeneratorUtils.METHOD_GET, Nw5PcSwc);
			String EXLvT8WP = "values_." + methodGenerator.getMethodName(DaoGeneratorUtils.METHOD_SET, Nw5PcSwc);
			String Q3BLllbj = "    ";
			JTypeBase Nqfc0Yzo = EmdFactory.getJTypeFactory().getJavaType(Nw5PcSwc.getType());
			aTlIg2F6.append(Nqfc0Yzo.getToXmlCode(Q3BLllbj, dHb516H2, COGmfH1Y + "()"));
			dSaloO2q.append(Nqfc0Yzo.getToXmlCode(Q3BLllbj, AQXibl7s, COGmfH1Y + "()"));
			RagJsE5Q.append(Nqfc0Yzo.getFromXmlCode(Q3BLllbj, dHb516H2, EXLvT8WP));
			RagJsE5Q.append("\n    //and also the short version");
			RagJsE5Q.append(Nqfc0Yzo.getFromXmlCode(Q3BLllbj, AQXibl7s, EXLvT8WP));
		}
		FtUaoZu7.append("\n    xos.print(\"-->\");");
		String iK0sY1E2 = aTlIg2F6.toString();
		String g7NA8xIS = FtUaoZu7.toString() + dSaloO2q.toString();
		String jVQaasKm = "";
		String xC6k0Ktl = getClassName(xxl2qfkJ);
		st0zKL8a.append("public class " + xC6k0Ktl + "  extends DefaultHandler implements TSParser\n");
		st0zKL8a.append("{" + Dz4f3163 + "\n  public static final int PROTO_VERSION=" + CrwoJvJz + ";"
				+ "\n  private transient StringBuffer cdata_=new StringBuffer();"
				+ "\n  private transient String endElement_;" + "\n  private transient TSParser parentParser_;"
				+ "\n  private transient XMLReader theReader_;\n" + "\n  private " + tvSeEYej + " values_;");
		st0zKL8a.append("\n\n");
		st0zKL8a.append("\n  /**" + "\n   * This is really only here as an example.  It is very rare to write a single"
				+ "\n   * object to a file - far more likely to have a collection or object graph.  "
				+ "\n   * in which case you can write something similar - maybe using the writeXmlShort"
				+ "\n   * version instread." + "\n   */" + "\n  public static void writeToFile(String file_nm, "
				+ tvSeEYej + " obj) throws IOException" + "\n  {"
				+ "\n    if (file_nm==null || file_nm.length()==0) throw new IOException(\"Bad file name (null or zero length)\");"
				+ "\n    if (obj==null) throw new IOException(\"Bad value object parameter, cannot write null object to file\");"
				+ "\n    FileOutputStream fos = new FileOutputStream(file_nm);"
				+ "\n    XmlOutputFilter xos = new XmlOutputFilter(fos);"
				+ "\n    xos.openElement(\"FILE_\"+EL_CLASS_TAG);" + "\n    writeXml(xos, obj);"
				+ "\n    xos.closeElement();" + "\n    fos.close();" + "\n  } // end of writeToFile" + "\n"
				+ "\n  public static void readFromFile(String file_nm, " + tvSeEYej
				+ " obj) throws IOException, SAXException" + "\n  {"
				+ "\n    if (file_nm==null || file_nm.length()==0) throw new IOException(\"Bad file name (null or zero length)\");"
				+ "\n    if (obj==null) throw new IOException(\"Bad value object parameter, cannot write null object to file\");"
				+ "\n    FileInputStream fis = new FileInputStream(file_nm);"
				+ "\n    DataInputStream dis = new DataInputStream(fis);" + "\n    marshalFromXml(dis, obj);"
				+ "\n    fis.close();" + "\n  } // end of readFromFile" + "\n"
				+ "\n  public static void writeXml(XmlOutputFilter xos, " + tvSeEYej + " obj) throws IOException"
				+ "\n  {" + "\n    xos.openElement(EL_CLASS_TAG);" + iK0sY1E2 + "\n    xos.closeElement();"
				+ "\n  } // end of writeXml" + "\n" + "\n  public static void writeXmlShort(XmlOutputFilter xos, "
				+ tvSeEYej + " obj) throws IOException" + "\n  {" + "\n    xos.openElement(EL_CLASS_TAG);" + g7NA8xIS
				+ "\n    xos.closeElement();" + "\n  } // end of writeXml" + "\n" + "\n  public " + xC6k0Ktl + "("
				+ tvSeEYej + " obj) {" + "\n    values_ = obj;" + "\n  } // end of ctor" + "\n");
		String C4hjqPGz = addXmlFunctions(xC6k0Ktl, tvSeEYej, DrHrUjJu, RagJsE5Q, Hm3vmPRY);
		String UCjeBnMx = "\n" + "\n} // end of classs" + "\n\n" + "\n//**************" + "\n// End of file"
				+ "\n//**************";
		return st0zKL8a.toString() + C4hjqPGz + UCjeBnMx;
	}

}