class n6008880 {
	protected void updateJava2ScriptProject(String auFTzo8n, String jSdRNF86) {
		try {
			File dNq4swB8 = new File(auFTzo8n, ".classpath");
			FileInputStream kml79wSX = new FileInputStream(dNq4swB8);
			String M8bYtOgh = J2SLaunchingUtil.readAFile(kml79wSX);
			if (M8bYtOgh != null) {
				boolean nAKIWqpb = false;
				if (M8bYtOgh.indexOf("ECLIPSE_SWT") == -1 && M8bYtOgh.indexOf("SWT_LIBRARY") == -1
						&& M8bYtOgh.indexOf("eclipse.swt") == -1) {
					int fBcsKBHe = M8bYtOgh.lastIndexOf("<");
					M8bYtOgh = M8bYtOgh.substring(0, fBcsKBHe)
							+ "\t<classpathentry kind=\"var\" path=\"ECLIPSE_SWT\"/>\r\n"
							+ M8bYtOgh.substring(fBcsKBHe);
					nAKIWqpb = true;
				}
				if (M8bYtOgh.indexOf("AJAX_SWT") == -1 && M8bYtOgh.indexOf("ajaxswt.jar") == -1) {
					int OdNi2gCI = M8bYtOgh.lastIndexOf("<");
					M8bYtOgh = M8bYtOgh.substring(0, OdNi2gCI)
							+ "\t<classpathentry sourcepath=\"AJAX_SWT_SRC\" kind=\"var\" path=\"AJAX_SWT\"/>\r\n"
							+ M8bYtOgh.substring(OdNi2gCI);
					nAKIWqpb = true;
				}
				if (M8bYtOgh.indexOf("AJAX_RPC") == -1 && M8bYtOgh.indexOf("ajaxrpc.jar") == -1) {
					int EgXSyPJF = M8bYtOgh.lastIndexOf("<");
					M8bYtOgh = M8bYtOgh.substring(0, EgXSyPJF)
							+ "\t<classpathentry sourcepath=\"AJAX_RPC_SRC\" kind=\"var\" path=\"AJAX_RPC\"/>\r\n"
							+ M8bYtOgh.substring(EgXSyPJF);
					nAKIWqpb = true;
				}
				if (M8bYtOgh.indexOf("AJAX_PIPE") == -1 && M8bYtOgh.indexOf("ajaxpipe.jar") == -1) {
					int mBeA6Sm7 = M8bYtOgh.lastIndexOf("<");
					M8bYtOgh = M8bYtOgh.substring(0, mBeA6Sm7)
							+ "\t<classpathentry sourcepath=\"AJAX_PIPE_SRC\" kind=\"var\" path=\"AJAX_PIPE\"/>\r\n"
							+ M8bYtOgh.substring(mBeA6Sm7);
					nAKIWqpb = true;
				}
				if (nAKIWqpb) {
					try {
						FileOutputStream VPvVG1OZ = new FileOutputStream(dNq4swB8);
						VPvVG1OZ.write(M8bYtOgh.getBytes("utf-8"));
						VPvVG1OZ.close();
					} catch (FileNotFoundException SoM8g79C) {
						SoM8g79C.printStackTrace();
					} catch (IOException l1AvJ6kR) {
						l1AvJ6kR.printStackTrace();
					}
				}
			}
			File VeFZvxyx = new File(auFTzo8n, "WEB-INF");
			VeFZvxyx.mkdir();
			new File(VeFZvxyx, "classes").mkdir();
			File XslBCipn = new File(VeFZvxyx, "lib");
			XslBCipn.mkdir();
			IPath yV5TtllZ = null;
			URL DUc1S4qP = AjaxPlugin.getDefault().getBundle().getEntry(File.separator);
			String O6SaSpbm = ".";
			try {
				O6SaSpbm = Platform.asLocalURL(DUc1S4qP).getFile();
			} catch (IOException t87nAyhE) {
				t87nAyhE.printStackTrace();
			}
			yV5TtllZ = Path.fromPortableString(O6SaSpbm + "/ajaxrpc.jar");
			File sypx3Pu8 = new File(yV5TtllZ.toOSString());
			try {
				FileInputStream VVankzH1 = new FileInputStream(sypx3Pu8);
				FileOutputStream V08vfk1Q = new FileOutputStream(new File(XslBCipn, "ajaxrpc.jar"));
				byte[] Lj27OSa4 = new byte[1024];
				int yvKTlrlw = -1;
				while ((yvKTlrlw = VVankzH1.read(Lj27OSa4)) != -1) {
					V08vfk1Q.write(Lj27OSa4, 0, yvKTlrlw);
				}
				V08vfk1Q.close();
				VVankzH1.close();
			} catch (IOException XLJsIdFO) {
				XLJsIdFO.printStackTrace();
			}
			yV5TtllZ = Path.fromPortableString(O6SaSpbm + "/ajaxpipe.jar");
			File PUQiR3GG = new File(yV5TtllZ.toOSString());
			try {
				FileInputStream TtJSFI1j = new FileInputStream(PUQiR3GG);
				FileOutputStream TbVvEelb = new FileOutputStream(new File(XslBCipn, "ajaxpipe.jar"));
				byte[] NNTBiiTX = new byte[1024];
				int q2NqEVgg = -1;
				while ((q2NqEVgg = TtJSFI1j.read(NNTBiiTX)) != -1) {
					TbVvEelb.write(NNTBiiTX, 0, q2NqEVgg);
				}
				TbVvEelb.close();
				TtJSFI1j.close();
			} catch (IOException X2QlAqBE) {
				X2QlAqBE.printStackTrace();
			}
			StringBuffer gAkii1IU = new StringBuffer();
			gAkii1IU.append("<?xml version=\"1.0\"?>\r\n");
			gAkii1IU.append("<project name=\"java2script.servlet.pack\" default=\"pack.war\" basedir=\".\">\r\n");
			gAkii1IU.append("    <description>Pack Java2Script Servlet Application</description>\r\n");
			gAkii1IU.append("\r\n");
			String qpN1fhwn = new File(auFTzo8n).getName();
			gAkii1IU.append("	<property name=\"java2script.app.name\" value=\"" + qpN1fhwn + "\"/>\r\n");
			gAkii1IU.append("	<property name=\"bin.folder\" value=\"${basedir}/../" + jSdRNF86 + "\"/>\r\n");
			gAkii1IU.append("\r\n");
			gAkii1IU.append("    <target name=\"pack.war\" depends=\"pack.jar\">\r\n");
			gAkii1IU.append("        <tstamp>\r\n");
			gAkii1IU.append("            <format property=\"now\" pattern=\"yyyy-MM-dd-HH-mm-ss\"/>\r\n");
			gAkii1IU.append("        </tstamp>\r\n");
			gAkii1IU.append("        <delete file=\"${basedir}/../${java2script.app.name}.war\" quiet=\"true\"/>\r\n");
			gAkii1IU.append("        <zip destfile=\"${basedir}/../${java2script.app.name}.${now}.war\">\r\n");
			gAkii1IU.append("            <fileset dir=\"${basedir}/../\">\r\n");
			gAkii1IU.append("                <exclude name=\"src/**\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"META-INF/**\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"WEB-INF/**\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.java\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.class\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.swp\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.swo\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.jar\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.war\"/>\r\n");
			gAkii1IU.append("                <exclude name=\".classpath\"/>\r\n");
			gAkii1IU.append("                <exclude name=\".project\"/>\r\n");
			gAkii1IU.append("                <exclude name=\".j2s\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"web.xml\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"build.xml\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"build.properties\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"plugin.xml\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"plugin.properties\"/>\r\n");
			gAkii1IU.append("            </fileset>\r\n");
			gAkii1IU.append("            <fileset dir=\"${basedir}/..\">\r\n");
			gAkii1IU.append("                <include name=\"WEB-INF/**\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"WEB-INF/build.xml\"/>\r\n");
			gAkii1IU.append("            </fileset>\r\n");
			gAkii1IU.append("        </zip>\r\n");
			gAkii1IU.append("        <copy file=\"${basedir}/../${java2script.app.name}.${now}.war\"\r\n");
			gAkii1IU.append("                tofile=\"${basedir}/../${java2script.app.name}.war\"/>\r\n");
			gAkii1IU.append("    </target>\r\n");
			gAkii1IU.append("\r\n");
			gAkii1IU.append("    <target name=\"pack.jar\">\r\n");
			gAkii1IU.append("        <delete file=\"${basedir}/lib/${java2script.app.name}.jar\" quiet=\"true\"/>\r\n");
			gAkii1IU.append("        <zip destfile=\"${basedir}/lib/${java2script.app.name}.jar\">\r\n");
			gAkii1IU.append("            <fileset dir=\"${bin.folder}\">\r\n");
			gAkii1IU.append("                <exclude name=\"WEB-INF/**\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.html\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.js\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.css\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.bmp\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.gif\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.png\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.jpg\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.jpeg\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.swp\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.swo\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.jar\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"**/*.war\"/>\r\n");
			gAkii1IU.append("                <exclude name=\".classpath\"/>\r\n");
			gAkii1IU.append("                <exclude name=\".project\"/>\r\n");
			gAkii1IU.append("                <exclude name=\".j2s\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"web.xml\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"build.xml\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"build.properties\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"plugin.xml\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"plugin.properties\"/>\r\n");
			gAkii1IU.append("            </fileset>\r\n");
			gAkii1IU.append("        </zip>\r\n");
			gAkii1IU.append("    </target>\r\n");
			gAkii1IU.append("\r\n");
			DUc1S4qP = AjaxPlugin.getDefault().getBundle().getEntry(File.separator);
			O6SaSpbm = ".";
			try {
				O6SaSpbm = Platform.asLocalURL(DUc1S4qP).getFile();
			} catch (IOException RxqU5Ukh) {
				RxqU5Ukh.printStackTrace();
			}
			yV5TtllZ = Path.fromPortableString(O6SaSpbm);
			String yIzBPIgi = yV5TtllZ.toOSString();
			String vgw0YT0m = "net.sf.j2s.ajax";
			int HCVEmLSP = yIzBPIgi.lastIndexOf(vgw0YT0m);
			if (HCVEmLSP != -1) {
				yIzBPIgi = yIzBPIgi.substring(0, HCVEmLSP) + "net.sf.j2s.lib"
						+ yIzBPIgi.substring(HCVEmLSP + vgw0YT0m.length());
			}
			File p4nbqjHF = new File(yIzBPIgi);
			String EA2O0NTc = FileUtil.toRelativePath(p4nbqjHF.getAbsolutePath(), VeFZvxyx.getAbsolutePath());
			if (EA2O0NTc.length() > 0 && !EA2O0NTc.endsWith("/")) {
				EA2O0NTc += "/";
			}
			int XKFbuBGn = EA2O0NTc.lastIndexOf('/', EA2O0NTc.length() - 2);
			String vjKbhtVk = EA2O0NTc.substring(0, XKFbuBGn);
			String GlJR8lbJ = EA2O0NTc.substring(XKFbuBGn + 1, EA2O0NTc.length() - 1);
			gAkii1IU.append("    <target name=\"pack.plugins.j2slib.war\">\r\n");
			gAkii1IU.append("        <delete file=\"${basedir}/../plugins.war\" quiet=\"true\"/>\r\n");
			gAkii1IU.append("        <zip destfile=\"${basedir}/../plugins.war\">\r\n");
			gAkii1IU.append("            <fileset dir=\"${basedir}/" + vjKbhtVk + "/\">\r\n");
			gAkii1IU.append("                <include name=\"" + GlJR8lbJ + "/**\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"" + GlJR8lbJ + "/library.jar\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"" + GlJR8lbJ + "/plugin.xml\"/>\r\n");
			gAkii1IU.append("                <exclude name=\"" + GlJR8lbJ + "/META-INF/**\"/>\r\n");
			gAkii1IU.append("            </fileset>\r\n");
			gAkii1IU.append("        </zip>\r\n");
			gAkii1IU.append("    </target>\r\n");
			gAkii1IU.append("\r\n");
			gAkii1IU.append("</project>\r\n");
			try {
				FileOutputStream AkPBlnte = new FileOutputStream(new File(VeFZvxyx, "build.xml"));
				AkPBlnte.write(gAkii1IU.toString().getBytes());
				AkPBlnte.close();
			} catch (FileNotFoundException pJlRMfMO) {
				pJlRMfMO.printStackTrace();
			} catch (IOException Ll13VZIf) {
				Ll13VZIf.printStackTrace();
			}
			StringBuffer eXmvC17y = new StringBuffer();
			eXmvC17y.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\r\n");
			eXmvC17y.append("<!DOCTYPE web-app\r\n");
			eXmvC17y.append("    PUBLIC \"-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN\"\r\n");
			eXmvC17y.append("    \"http://java.sun.com/dtd/web-app_2_3.dtd\">\r\n");
			eXmvC17y.append("<web-app>\r\n");
			eXmvC17y.append("    <display-name>Java2Script</display-name>\r\n");
			eXmvC17y.append("    <description>Java2Script application</description>\r\n");
			eXmvC17y.append(genereateServlet("simplerpc", "net.sf.j2s.ajax.SimpleRPCHttpServlet"));
			eXmvC17y.append(genereateServlet("piperpc", "net.sf.j2s.ajax.CompoundPipeRPCHttpServlet"));
			eXmvC17y.append("    <servlet>\r\n");
			eXmvC17y.append("        <servlet-name>simplepipe</servlet-name>\r\n");
			eXmvC17y.append("        <servlet-class>net.sf.j2s.ajax.SimplePipeHttpServlet</servlet-class>\r\n");
			eXmvC17y.append("        <init-param>\r\n");
			eXmvC17y.append("            <param-name>simple.pipe.query.timeout</param-name>\r\n");
			eXmvC17y.append("            <param-value>20000</param-value>\r\n");
			eXmvC17y.append("        </init-param>\r\n");
			eXmvC17y.append("        <init-param>\r\n");
			eXmvC17y.append("            <param-name>simple.pipe.script.breakout</param-name>\r\n");
			eXmvC17y.append("            <param-value>1200000</param-value>\r\n");
			eXmvC17y.append("        </init-param>\r\n");
			eXmvC17y.append("        <init-param>\r\n");
			eXmvC17y.append("            <param-name>simple.pipe.max.items.per.query</param-name>\r\n");
			eXmvC17y.append("            <param-value>60</param-value>\r\n");
			eXmvC17y.append("        </init-param>\r\n");
			eXmvC17y.append("    </servlet>\r\n");
			eXmvC17y.append("    <servlet-mapping>\r\n");
			eXmvC17y.append("        <servlet-name>simplerpc</servlet-name>\r\n");
			eXmvC17y.append("        <url-pattern>/simplerpc</url-pattern>\r\n");
			eXmvC17y.append("    </servlet-mapping>\r\n");
			eXmvC17y.append("    <servlet-mapping>\r\n");
			eXmvC17y.append("        <servlet-name>piperpc</servlet-name>\r\n");
			eXmvC17y.append("        <url-pattern>/piperpc</url-pattern>\r\n");
			eXmvC17y.append("    </servlet-mapping>\r\n");
			eXmvC17y.append("    <servlet-mapping>\r\n");
			eXmvC17y.append("        <servlet-name>simplepipe</servlet-name>\r\n");
			eXmvC17y.append("        <url-pattern>/simplepipe</url-pattern>\r\n");
			eXmvC17y.append("    </servlet-mapping>\r\n");
			eXmvC17y.append("</web-app>\r\n");
			try {
				FileOutputStream MehAG0n9 = new FileOutputStream(new File(VeFZvxyx, "web.xml"));
				MehAG0n9.write(eXmvC17y.toString().getBytes());
				MehAG0n9.close();
			} catch (FileNotFoundException w6ZruMZ5) {
				w6ZruMZ5.printStackTrace();
			} catch (IOException jL8X51Fj) {
				jL8X51Fj.printStackTrace();
			}
		} catch (FileNotFoundException nUYJ6zRI) {
			nUYJ6zRI.printStackTrace();
		}
	}

}