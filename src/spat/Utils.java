package spat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ChildListPropertyDescriptor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.text.edits.UndoEdit;

public class Utils {
	public static int maxTrans;
	//read file content into a string
	public static String readFileToString(String filePath) throws IOException {
		StringBuilder fileData = new StringBuilder(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
 
		char[] buf = new char[10];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			//System.out.println(numRead);
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
 
		reader.close();
 
		return  fileData.toString();	
	}
	
	public static File[] folderMethod(String path, String outputDir) {
        int fileNum = 0, folderNum = 0;
        File file = new File(path);
        LinkedList<File> list = new LinkedList<>();
        ArrayList<File> res = new ArrayList<File>();
        if (file.exists()) {
            if (null == file.listFiles()) {
                return res.toArray(new File[res.size()]);
            }
            list.addAll(Arrays.asList(file.listFiles()));
            while (!list.isEmpty()) {
            	File thisfile = list.removeFirst();
                File[] files = thisfile.listFiles();
                if (null == files) {//Maybe a file
                	if (thisfile.getName().split("\\.")[1].equals("java")) {
                    	int ender = path.length();
                		String newDirPath = outputDir + thisfile.getAbsolutePath().substring(ender);
                		mkfatherdir(newDirPath);
                    	res.add(thisfile);
                    }
                    fileNum++;
                    continue;
                }
                for (File f : files) {
                    if (f.isDirectory()) {
                        //System.out.println("filefolder:" + f.getAbsolutePath());
                        list.add(f);
                        folderNum++;
                    } else {
                        if (f.getName().split("\\.")[1].equals("java")) {
                        	//System.out.println("file:" + f.getAbsolutePath());
                        	//Create the dirs
                        	int ender = path.length();
                    		String newDirPath = outputDir + f.getAbsolutePath().substring(ender);
                    		mkfatherdir(newDirPath);
                    		
                        	res.add(f);
                        }
                        fileNum++;
                    }
                }
            }
        } else {
            System.out.println("Root does not exist!");
        }
        System.out.println("filefolder number:" + folderNum + ",file number:" + fileNum);
        return res.toArray(new File[res.size()]);
    }
	
	//generating random string
	public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";
	     String head = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     int number=random.nextInt(52);
	     sb.append(head.charAt(number));
	     for(int i=1;i<length;i++){
	       number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
	
	public static String [] SingleStr2priList(String t) {
		ArrayList<String> tmp = new ArrayList<String>();
		tmp.add(t);
		return ArryStr2priStrList(tmp);
	}
	
	
	public static String [] ArryStr2priStrList(ArrayList<String> t) {
		int sizer=t.size();  
		String[] arrString = (String[])t.toArray(new String[sizer]) ;
		return arrString;
	}
	
	
	public static String FromCompilationUnit2ClassName(CompilationUnit node) {
		return ((TypeDeclaration)node.types().get(0)).getName().getIdentifier();
	}
	
	public static Statement father2AStatement(ASTNode node) {
		while(!(node.getParent() instanceof  Statement)) {
			return father2AStatement(node.getParent());
		}
		return (Statement) node.getParent();
		
	}
	
	public static ExpressionStatement father2AExpressionStatement(ASTNode node) {
		while(!(node.getParent() instanceof  Statement)) {
			return father2AExpressionStatement(node.getParent());
		}
		if(node.getParent().getNodeType() != ASTNode.EXPRESSION_STATEMENT) {
			return null;
		}
		return (ExpressionStatement) node.getParent();
		
	}
	

	 public static void mkfatherdir(String path) {
	        File f;
	        try {
	            f = new File(path);
	            f = f.getParentFile();
	            if (!f.exists()) {
	                boolean i = f.mkdirs();
	                if (i) {
	                    //log.info("层级文件夹创建成功！");
	                } else {
	                    System.out.println("Dir make failed!");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	public static void applyRewrite(CompilationUnit node, TextEdit edits, Document document, String outputDirPath) {
		//Code below is to reformat the transfered codes.
		@SuppressWarnings("unused")
		UndoEdit undo = null;
		 try {
		     undo = edits.apply(document);
		 } catch(MalformedTreeException e) {
		     e.printStackTrace();
		 } catch(BadLocationException e) {
		     e.printStackTrace();
		 }
		 
		 
		 String code = document.get();
		 
		 IDocument formatteddoc = new Document(code);
		 try {
			 	CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(null, ToolFactory.M_FORMAT_EXISTING);
			 	TextEdit textEdit = codeFormatter.format(CodeFormatter.K_COMPILATION_UNIT, code, 0, code.length(), 0, "\n");
				textEdit.apply(formatteddoc);
			} catch (MalformedTreeException e) {
				e.printStackTrace();
			} catch (BadLocationException e) {
				e.printStackTrace();
			} catch (IndexOutOfBoundsException e) {
				
//				e.printStackTrace();
//				System.out.println(code);
			}
		String newcode = formatteddoc.get();
		
		
		// TODO Auto-generated method stub
		
		try {
			//String classname = FromCompilationUnit2ClassName(node);
			String filepath = outputDirPath;
			FileWriter writer = new FileWriter(filepath);
			writer.write(newcode);
            writer.flush();
            writer.close();
            System.out.println(filepath + "	reWrited successfully!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			
		}
	}

	
	public static Set<IBinding> resolveAlluseddVarNames(ASTNode node){
		//System.out.println(node.toString());
		class varNameRecording extends ASTVisitor{
			public Set<IBinding> res = new HashSet<IBinding> ();
			public boolean visit(SimpleName namer) {
				//if(namer.isVar()) {
					res.add(namer.resolveBinding());
				//}
				return true;
			}
			
		};
		varNameRecording varC = new varNameRecording();
		node.accept(varC);
		//System.out.println(varC.res.toString());
		return varC.res;
	}
	
	
	public static InfixExpression father2AInfixExpression(Expression node) {
		if(!(node.getParent() instanceof  Expression)) {
			return null;
		}
		if(!(node.getParent() instanceof InfixExpression)) {
			return father2AInfixExpression( (Expression) node.getParent());
		}
		return (InfixExpression) node.getParent();
	}

	public static Statement father2AListRewriterForStatementInserting(ASTNode node, ASTRewrite rewriter) {
		if(node == null) {
			return null;
		}
		if(node.getNodeType() == ASTNode.FOR_STATEMENT || node.getNodeType() == ASTNode.WHILE_STATEMENT 
				|| node.getNodeType() == ASTNode.DO_STATEMENT || node.getNodeType() == ASTNode.ENHANCED_FOR_STATEMENT) {
			return null;  // It has no meaning insert before a loop statement.
		}
		
		if(! (node instanceof Statement)) {
			return father2AListRewriterForStatementInserting(node.getParent(), rewriter);
		}
		try {
			@SuppressWarnings("unused")
			ListRewrite lrt = rewriter.getListRewrite(node.getParent(), (ChildListPropertyDescriptor) node.getLocationInParent());
			return (Statement) node;
		}catch (Exception e) {
			return father2AListRewriterForStatementInserting(node.getParent(), rewriter);
		}
	}

	public static String sublizeOutput(String filePath, String dirPath, String outputdir) {
		// TODO Auto-generated method stub
		int ender = dirPath.length();
		String [] parts = filePath.split("\\\\");
		String newDirPath = outputdir + parts[parts.length-1];
		//mkfatherdir(newDirPath);
		return newDirPath;
	}
}
