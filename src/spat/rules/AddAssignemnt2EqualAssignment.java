package spat.rules;

import java.util.ArrayList;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.ParenthesizedExpression;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

import spat.Utils;

public class AddAssignemnt2EqualAssignment extends ASTVisitor{
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	ArrayList<Assignment> addAsses = new ArrayList<Assignment>();
	
	public AddAssignemnt2EqualAssignment(CompilationUnit cu_, Document document_, String outputDirPath_) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
	}
	
	
	public boolean visit(Assignment node) {
		try {
			String theOp = node.getOperator().toString();
			if(theOp == "+=" || theOp == "-=" || theOp == "*=" || theOp == "/=") {
				addAsses.add(node);
			}
		}catch (Exception e) {
			return true;
		}
		return true;
	}
	
	public void endVisit(CompilationUnit node) {
		
		if (addAsses.size() == 0) {
			return;
		}
		
		AST ast = cu.getAST();
		ASTRewrite rewriter = ASTRewrite.create(ast);
		for(Assignment addAss: addAsses){
//			System.out.println("find one:");
//			System.out.println(addAss.toString());
			Assignment newAss = ast.newAssignment();
			newAss.setOperator(Assignment.Operator.toOperator("="));
			newAss.setLeftHandSide((Expression) ASTNode.copySubtree(ast, addAss.getLeftHandSide()));
			
			Expression exp = (Expression) ASTNode.copySubtree(ast, addAss.getRightHandSide());
			ParenthesizedExpression theRightOftheRight = ast.newParenthesizedExpression();
			theRightOftheRight.setExpression(exp);
			
			Expression theLeftOftheRight = (Expression) ASTNode.copySubtree(ast, addAss.getLeftHandSide());
			
			InfixExpression theNewRight = ast.newInfixExpression();
			theNewRight.setLeftOperand(theLeftOftheRight);
			theNewRight.setRightOperand(theRightOftheRight);
			
			String theaddTyep = addAss.getOperator().toString();
			theNewRight.setOperator(InfixExpression.Operator.toOperator(theaddTyep.substring(0,1)));
			
			newAss.setRightHandSide(theNewRight);
			rewriter.replace(addAss, newAss, null);
		}
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(node, edits, document,outputDirPath);
	}
}
