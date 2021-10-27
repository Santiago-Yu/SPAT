package spat.rules;

import java.util.ArrayList;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

import spat.Utils;

public class PP2AddAssignment extends ASTVisitor{
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	ArrayList<PostfixExpression> postes = new ArrayList<PostfixExpression>();
	
	public PP2AddAssignment(CompilationUnit cu_, Document document_, String outputDirPath_) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
	}
	
	
	public boolean visit(PostfixExpression node) {
		try {
			Statement staFather = (Statement) node.getParent();
			if(staFather.getNodeType() == ASTNode.EXPRESSION_STATEMENT) {
				postes.add(node);
			}
		}catch (Exception e) {
			return true;
		}
		return true;
	}
	
	public void endVisit(CompilationUnit node) {
		
		if (postes.size() == 0) {
			return;
		}
		
		AST ast = cu.getAST();
		ASTRewrite rewriter = ASTRewrite.create(ast);
		for(PostfixExpression poste: postes){
			//System.out.println("find one:");
			//Statement staFather = (Statement) poste.getParent();
			//System.out.println(staFather.toString());
			Assignment ass = ast.newAssignment(); 
			Expression thename = (Expression) ASTNode.copySubtree(ast, poste.getOperand());
			ass.setLeftHandSide(thename);
			ass.setRightHandSide(ast.newNumberLiteral("1"));
			if(poste.getOperator().toString() == "++") {
				ass.setOperator(Assignment.Operator.toOperator("+="));
			}
			else if (poste.getOperator().toString() == "--") {
				ass.setOperator(Assignment.Operator.toOperator("-="));
			}
			else {
				System.out.println("postExpression has an operator other than ++ and --");
				return;
			}
			
			
			rewriter.replace(poste, ass, null);
		}
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(node, edits, document,outputDirPath);
	}
}
