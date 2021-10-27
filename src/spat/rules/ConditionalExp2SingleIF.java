package spat.rules;

import java.util.ArrayList;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTMatcher;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.ChildListPropertyDescriptor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ConditionalExpression;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.Assignment.Operator;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

import spat.Utils;

public class ConditionalExp2SingleIF extends ASTVisitor{
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	ArrayList<ConditionalExpression> conditionalExps = new ArrayList<ConditionalExpression>();
	ArrayList<ConditionalExpression> conditionalDecs = new ArrayList<ConditionalExpression>();
	
	public ConditionalExp2SingleIF(CompilationUnit cu_, Document document_, String outputDirPath_) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
	}
	

	
	
	public boolean visit(ConditionalExpression node) {
		Statement father = null;
		try {
			father = Utils.father2AStatement(node);
		}catch(Exception e) {
			return true;
		}
		if (father.getNodeType() == ASTNode.EXPRESSION_STATEMENT) {
			//if(((ExpressionStatement)father).getExpression().getNodeType() == ASTNode.ASSIGNMENT) {
			conditionalExps.add(node);
			//}
		}
		else if(father.getNodeType() == ASTNode.VARIABLE_DECLARATION_STATEMENT) {//only consider one fragments.
			if(((VariableDeclarationStatement)father).fragments().size() == 1) {
				conditionalDecs.add(node);
			}
		}
		return true;
	}
	
	
	private IfStatement cond2IF(ExpressionStatement father, AST ast, 
			ConditionalExpression conditionalExp, ASTRewrite rewriter) {
		//System.out.println(father.toString());
		Expression conditionExp = (Expression) ASTNode.copySubtree(ast, conditionalExp.getExpression());
		Expression thenExp = (Expression) ASTNode.copySubtree(ast, conditionalExp.getThenExpression());
		Expression elseExp = (Expression) ASTNode.copySubtree(ast, conditionalExp.getElseExpression());
		
		//conditionalExp.getParent().setStructuralProperty(conditionalExp.getLocationInParent(), thenExp);
		ExpressionStatement thenState = (ExpressionStatement) ASTNode.copySubtree(ast, father);
		//thenExp.getParent().setStructuralProperty(thenExp.getLocationInParent(), elseExp);
		ExpressionStatement elseState = (ExpressionStatement) ASTNode.copySubtree(ast, father);
		
		ConditionalExpression toReplace_then = findtheCondition(thenState, conditionalExp);
		rewriter.replace(toReplace_then, thenExp, null);
		
		ConditionalExpression toReplace_else = findtheCondition(elseState, conditionalExp);
		rewriter.replace(toReplace_else, elseExp, null);
		
		IfStatement newIF = ast.newIfStatement();
		newIF.setExpression(conditionExp);
		newIF.setThenStatement(thenState);
		newIF.setElseStatement(elseState);
		//System.out.println("AfterWords:\n" +newIF.toString());
		
		rewriter.replace(father, newIF, null);	
		return newIF;
	}
	
	
	public void endVisit(CompilationUnit node) {
		
		if (conditionalExps.size() == 0 && conditionalDecs.size() == 0) {
			return;
		}
		
		AST ast = cu.getAST();
		ASTRewrite rewriter = ASTRewrite.create(ast);
		
		for(ConditionalExpression conditionalExp : conditionalExps) {
			ExpressionStatement father = (ExpressionStatement) Utils.father2AStatement(conditionalExp);
			cond2IF(father, ast, conditionalExp, rewriter);
		}
		
		for(ConditionalExpression conditionalDec : conditionalDecs) {
			VariableDeclarationStatement father = (VariableDeclarationStatement) Utils.father2AStatement(conditionalDec);
			VariableDeclarationStatement predeclaration = (VariableDeclarationStatement) ASTNode.copySubtree(ast, father);
			VariableDeclarationFragment fra = (VariableDeclarationFragment) predeclaration.fragments().get(0);
			
			Assignment assignment = ast.newAssignment();
			assignment.setLeftHandSide((Expression) ASTNode.copySubtree(ast, fra.getName()));
			assignment.setRightHandSide((Expression) ASTNode.copySubtree(ast, fra.getInitializer()));
			assignment.setOperator(Operator.toOperator("="));
			
			ExpressionStatement newfather = ast.newExpressionStatement(assignment);
			
			fra.setInitializer(null);//previous-declaration
			
			
			ListRewrite lrt = rewriter.getListRewrite(father.getParent(), (ChildListPropertyDescriptor) father.getLocationInParent());
			lrt.insertBefore(predeclaration, father, null);
			
			rewriter.replace(father, newfather, null);
			cond2IF(newfather, ast, conditionalDec, rewriter);
		}
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(node, edits, document,outputDirPath);
		
	}


	private ConditionalExpression findtheCondition(ExpressionStatement thenState,
			ConditionalExpression conditionalExp) {
		//seach
		ConditionalExpression res = null;
		
		
		class SpecASTVisitor extends ASTVisitor{
			public ConditionalExpression transer = null;
			public boolean visit(ConditionalExpression node) {
				if(node.subtreeMatch(new ASTMatcher(), conditionalExp)) {
					transer = node;
				}
				return true;
			}
		}
		SpecASTVisitor theVistor = new SpecASTVisitor();
		
		thenState.accept(theVistor);
		res = theVistor.transer;
		if (res == null) {
			System.out.println("Error!	" + "can't find the conditional Expression in the copy statement");
			System.exit(8);
		}
		return res;
	}
}