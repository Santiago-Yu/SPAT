class n8235223 {
	private ShaderProgram loadShaderProgram() {
		String vertexProgram = null;
		ShaderProgram sp = null;
		Shader[] shaders = new Shader[2];
		String fragmentProgram = null;
		try {
			ClassLoader cl = this.getClass().getClassLoader();
			URL url = cl.getResource("Shaders/ivory.vert");
			System.out.println("url " + url);
			Reader reader = null;
			InputStream inputSteam = cl.getResourceAsStream("Shaders/ivory.vert");
			char[] buffer = new char[10000];
			if (inputSteam != null) {
				reader = new InputStreamReader(inputSteam);
			} else {
				File file = new File("lib");
				URL url2 = new URL(
						"jar:file:" + file.getAbsolutePath() + "/j3d-vrml97-i3mainz.jar!/Shaders/ivory.vert");
				InputStream inputSteam2 = url2.openStream();
				reader = new InputStreamReader(inputSteam2);
			}
			int len = reader.read(buffer);
			vertexProgram = new String(buffer);
			vertexProgram = vertexProgram.substring(0, len);
		} catch (Exception e) {
			System.err.println("could'nt load ivory.vert");
			e.printStackTrace();
		}
		try {
			ClassLoader cl = this.getClass().getClassLoader();
			URL url = cl.getResource("Shaders/ivory.frag");
			System.out.println("url " + url);
			Reader reader = null;
			InputStream inputSteam = cl.getResourceAsStream("Shaders/ivory.frag");
			char[] buffer = new char[10000];
			if (inputSteam != null) {
				reader = new InputStreamReader(inputSteam);
			} else {
				File file = new File("lib");
				URL url2 = new URL(
						"jar:file:" + file.getAbsolutePath() + "/j3d-vrml97-i3mainz.jar!/Shaders/ivory.frag");
				InputStream inputSteam2 = url2.openStream();
				reader = new InputStreamReader(inputSteam2);
			}
			int len = reader.read(buffer);
			fragmentProgram = new String(buffer);
			fragmentProgram = fragmentProgram.substring(0, len);
		} catch (Exception e) {
			System.err.println("could'nt load ivory.frag");
			e.printStackTrace();
		}
		if (vertexProgram != null && fragmentProgram != null) {
			shaders[0] = new SourceCodeShader(Shader.SHADING_LANGUAGE_GLSL, Shader.SHADER_TYPE_VERTEX, vertexProgram);
			sp = new GLSLShaderProgram();
			shaders[1] = new SourceCodeShader(Shader.SHADING_LANGUAGE_GLSL, Shader.SHADER_TYPE_FRAGMENT,
					fragmentProgram);
			sp.setShaders(shaders);
		}
		return sp;
	}

}