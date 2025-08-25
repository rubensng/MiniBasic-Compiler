// Generated from c:/Users/olesn/Desktop/curso 3/Compiladores/pl2/PL3_Compiladores/parte2/GMiniBParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GMiniBParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LET=1, OPSUM=2, OPRES=3, OPMUL=4, OPDIV=5, OPMOD=6, OPBLT=7, OPBGT=8, 
		OPBLE=9, OPBGE=10, IPAREN=11, DPAREN=12, SSEPARADOR=13, OPASIG=14, OPEQ=15, 
		OPNEQ=16, END=17, PRINT=18, INPUT=19, FOR=20, TO=21, IF=22, ELSE=23, THEN=24, 
		CONTINUE=25, NEXT=26, EXIT=27, FUNC=28, VAL=29, LEN=30, ISNAN=31, WHILE=32, 
		REPEAT=33, UNTIL=34, STEP=35, REM=36, ID=37, STRING=38, ENTERO=39, INTRO=40, 
		WS=41, FINAL_COMENTARIO_NL=42, FINAL_COMENTARIO_EOF=43, TEXTO_COMENTARIO=44;
	public static final int
		RULE_fichero = 0, RULE_bloque = 1, RULE_declaracion = 2, RULE_comentario = 3, 
		RULE_asignacion = 4, RULE_bucleWhile = 5, RULE_bucleFor = 6, RULE_sentIF = 7, 
		RULE_repetir = 8, RULE_funcion = 9, RULE_concatenar = 10, RULE_printStatement = 11, 
		RULE_inputStatement = 12, RULE_expr = 13, RULE_llamadasFuncion = 14, RULE_valorGenerico = 15, 
		RULE_cadena = 16, RULE_identificador = 17, RULE_entero = 18, RULE_texto = 19, 
		RULE_controlFlujo = 20, RULE_token_repeat = 21, RULE_token_for = 22, RULE_token_if = 23, 
		RULE_token_to = 24, RULE_token_else = 25, RULE_token_next = 26, RULE_token_then = 27, 
		RULE_token_until = 28, RULE_token_step = 29, RULE_token_comentario = 30, 
		RULE_token_asignacion = 31, RULE_token_igual = 32, RULE_token_print = 33, 
		RULE_token_input = 34, RULE_token_end = 35, RULE_token_while = 36, RULE_token_funcion = 37, 
		RULE_operador = 38, RULE_cond1 = 39, RULE_exprCond = 40, RULE_func = 41, 
		RULE_parametros = 42, RULE_llamadaFuncCreada = 43;
	private static String[] makeRuleNames() {
		return new String[] {
			"fichero", "bloque", "declaracion", "comentario", "asignacion", "bucleWhile", 
			"bucleFor", "sentIF", "repetir", "funcion", "concatenar", "printStatement", 
			"inputStatement", "expr", "llamadasFuncion", "valorGenerico", "cadena", 
			"identificador", "entero", "texto", "controlFlujo", "token_repeat", "token_for", 
			"token_if", "token_to", "token_else", "token_next", "token_then", "token_until", 
			"token_step", "token_comentario", "token_asignacion", "token_igual", 
			"token_print", "token_input", "token_end", "token_while", "token_funcion", 
			"operador", "cond1", "exprCond", "func", "parametros", "llamadaFuncCreada"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'LET'", "'+'", "'-'", "'*'", "'/'", "'MOD'", "'<'", "'>'", "'<='", 
			"'>='", "'('", "')'", "','", "'='", "'=='", "'!='", null, null, "'INPUT'", 
			"'FOR'", "'TO'", null, null, null, "'CONTINUE'", "'NEXT'", "'EXIT'", 
			"'FUNC'", "'VAL'", "'LEN'", "'ISNAN'", "'WHILE'", "'REPEAT'", "'UNTIL'", 
			"'STEP'", "'REM '", null, null, null, null, "' '", "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LET", "OPSUM", "OPRES", "OPMUL", "OPDIV", "OPMOD", "OPBLT", "OPBGT", 
			"OPBLE", "OPBGE", "IPAREN", "DPAREN", "SSEPARADOR", "OPASIG", "OPEQ", 
			"OPNEQ", "END", "PRINT", "INPUT", "FOR", "TO", "IF", "ELSE", "THEN", 
			"CONTINUE", "NEXT", "EXIT", "FUNC", "VAL", "LEN", "ISNAN", "WHILE", "REPEAT", 
			"UNTIL", "STEP", "REM", "ID", "STRING", "ENTERO", "INTRO", "WS", "FINAL_COMENTARIO_NL", 
			"FINAL_COMENTARIO_EOF", "TEXTO_COMENTARIO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GMiniBParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GMiniBParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FicheroContext extends ParserRuleContext {
		public FicheroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fichero; }
	 
		public FicheroContext() { }
		public void copyFrom(FicheroContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FichContext extends FicheroContext {
		public List<DeclaracionContext> declaracion() {
			return getRuleContexts(DeclaracionContext.class);
		}
		public DeclaracionContext declaracion(int i) {
			return getRuleContext(DeclaracionContext.class,i);
		}
		public List<ComentarioContext> comentario() {
			return getRuleContexts(ComentarioContext.class);
		}
		public ComentarioContext comentario(int i) {
			return getRuleContext(ComentarioContext.class,i);
		}
		public List<TerminalNode> INTRO() { return getTokens(GMiniBParser.INTRO); }
		public TerminalNode INTRO(int i) {
			return getToken(GMiniBParser.INTRO, i);
		}
		public FichContext(FicheroContext ctx) { copyFrom(ctx); }
	}

	public final FicheroContext fichero() throws RecognitionException {
		FicheroContext _localctx = new FicheroContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_fichero);
		int _la;
		try {
			_localctx = new FichContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1318997196802L) != 0)) {
				{
				setState(91);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LET:
				case PRINT:
				case INPUT:
				case FOR:
				case IF:
				case CONTINUE:
				case EXIT:
				case FUNC:
				case WHILE:
				case REPEAT:
				case ID:
					{
					setState(88);
					declaracion();
					}
					break;
				case REM:
					{
					setState(89);
					comentario();
					}
					break;
				case INTRO:
					{
					setState(90);
					match(INTRO);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BloqueContext extends ParserRuleContext {
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
	 
		public BloqueContext() { }
		public void copyFrom(BloqueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BloqContext extends BloqueContext {
		public List<DeclaracionContext> declaracion() {
			return getRuleContexts(DeclaracionContext.class);
		}
		public DeclaracionContext declaracion(int i) {
			return getRuleContext(DeclaracionContext.class,i);
		}
		public List<TerminalNode> INTRO() { return getTokens(GMiniBParser.INTRO); }
		public TerminalNode INTRO(int i) {
			return getToken(GMiniBParser.INTRO, i);
		}
		public BloqContext(BloqueContext ctx) { copyFrom(ctx); }
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bloque);
		try {
			int _alt;
			_localctx = new BloqContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(98); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(98);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LET:
					case PRINT:
					case INPUT:
					case FOR:
					case IF:
					case CONTINUE:
					case EXIT:
					case FUNC:
					case WHILE:
					case REPEAT:
					case ID:
						{
						setState(96);
						declaracion();
						}
						break;
					case INTRO:
						{
						setState(97);
						match(INTRO);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(100); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionContext extends ParserRuleContext {
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
	 
		public DeclaracionContext() { }
		public void copyFrom(DeclaracionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionForContext extends DeclaracionContext {
		public BucleForContext bucleFor() {
			return getRuleContext(BucleForContext.class,0);
		}
		public DeclaracionForContext(DeclaracionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionFuncContext extends DeclaracionContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public DeclaracionFuncContext(DeclaracionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionIfContext extends DeclaracionContext {
		public SentIFContext sentIF() {
			return getRuleContext(SentIFContext.class,0);
		}
		public DeclaracionIfContext(DeclaracionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionWhileContext extends DeclaracionContext {
		public BucleWhileContext bucleWhile() {
			return getRuleContext(BucleWhileContext.class,0);
		}
		public DeclaracionWhileContext(DeclaracionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionLlamadaContext extends DeclaracionContext {
		public LlamadaFuncCreadaContext llamadaFuncCreada() {
			return getRuleContext(LlamadaFuncCreadaContext.class,0);
		}
		public DeclaracionLlamadaContext(DeclaracionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionAsignacionContext extends DeclaracionContext {
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public DeclaracionAsignacionContext(DeclaracionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionControlFlujoContext extends DeclaracionContext {
		public ControlFlujoContext controlFlujo() {
			return getRuleContext(ControlFlujoContext.class,0);
		}
		public DeclaracionControlFlujoContext(DeclaracionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionRepeatContext extends DeclaracionContext {
		public RepetirContext repetir() {
			return getRuleContext(RepetirContext.class,0);
		}
		public DeclaracionRepeatContext(DeclaracionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionFuncionContext extends DeclaracionContext {
		public FuncionContext funcion() {
			return getRuleContext(FuncionContext.class,0);
		}
		public DeclaracionFuncionContext(DeclaracionContext ctx) { copyFrom(ctx); }
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracion);
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new DeclaracionAsignacionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				asignacion();
				}
				break;
			case 2:
				_localctx = new DeclaracionWhileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				bucleWhile();
				}
				break;
			case 3:
				_localctx = new DeclaracionRepeatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				repetir();
				}
				break;
			case 4:
				_localctx = new DeclaracionFuncionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(105);
				funcion();
				}
				break;
			case 5:
				_localctx = new DeclaracionForContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(106);
				bucleFor();
				}
				break;
			case 6:
				_localctx = new DeclaracionIfContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(107);
				sentIF();
				}
				break;
			case 7:
				_localctx = new DeclaracionControlFlujoContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(108);
				controlFlujo();
				}
				break;
			case 8:
				_localctx = new DeclaracionFuncContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(109);
				func();
				}
				break;
			case 9:
				_localctx = new DeclaracionLlamadaContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(110);
				llamadaFuncCreada();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComentarioContext extends ParserRuleContext {
		public Token_comentarioContext token_comentario() {
			return getRuleContext(Token_comentarioContext.class,0);
		}
		public TerminalNode FINAL_COMENTARIO_NL() { return getToken(GMiniBParser.FINAL_COMENTARIO_NL, 0); }
		public TerminalNode FINAL_COMENTARIO_EOF() { return getToken(GMiniBParser.FINAL_COMENTARIO_EOF, 0); }
		public List<TextoContext> texto() {
			return getRuleContexts(TextoContext.class);
		}
		public TextoContext texto(int i) {
			return getRuleContext(TextoContext.class,i);
		}
		public ComentarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comentario; }
	}

	public final ComentarioContext comentario() throws RecognitionException {
		ComentarioContext _localctx = new ComentarioContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_comentario);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			token_comentario();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TEXTO_COMENTARIO) {
				{
				{
				setState(114);
				texto();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
			_la = _input.LA(1);
			if ( !(_la==FINAL_COMENTARIO_NL || _la==FINAL_COMENTARIO_EOF) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AsignacionContext extends ParserRuleContext {
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
	 
		public AsignacionContext() { }
		public void copyFrom(AsignacionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsignContext extends AsignacionContext {
		public IdentificadorContext var;
		public ValorGenericoContext valor;
		public EnteroContext valorInt;
		public Token_igualContext token_igual() {
			return getRuleContext(Token_igualContext.class,0);
		}
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public Token_asignacionContext token_asignacion() {
			return getRuleContext(Token_asignacionContext.class,0);
		}
		public ValorGenericoContext valorGenerico() {
			return getRuleContext(ValorGenericoContext.class,0);
		}
		public EnteroContext entero() {
			return getRuleContext(EnteroContext.class,0);
		}
		public AsignContext(AsignacionContext ctx) { copyFrom(ctx); }
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_asignacion);
		int _la;
		try {
			_localctx = new AsignContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(122);
				token_asignacion();
				}
			}

			setState(125);
			((AsignContext)_localctx).var = identificador();
			setState(126);
			token_igual();
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(127);
				((AsignContext)_localctx).valor = valorGenerico();
				}
				break;
			case 2:
				{
				setState(128);
				((AsignContext)_localctx).valorInt = entero();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BucleWhileContext extends ParserRuleContext {
		public BucleWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bucleWhile; }
	 
		public BucleWhileContext() { }
		public void copyFrom(BucleWhileContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends BucleWhileContext {
		public Cond1Context condicion;
		public BloqueContext cuerpo;
		public Token_whileContext token_while() {
			return getRuleContext(Token_whileContext.class,0);
		}
		public Token_endContext token_end() {
			return getRuleContext(Token_endContext.class,0);
		}
		public Cond1Context cond1() {
			return getRuleContext(Cond1Context.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public WhileContext(BucleWhileContext ctx) { copyFrom(ctx); }
	}

	public final BucleWhileContext bucleWhile() throws RecognitionException {
		BucleWhileContext _localctx = new BucleWhileContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bucleWhile);
		try {
			_localctx = new WhileContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			token_while();
			setState(132);
			((WhileContext)_localctx).condicion = cond1(0);
			setState(133);
			((WhileContext)_localctx).cuerpo = bloque();
			setState(134);
			token_end();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BucleForContext extends ParserRuleContext {
		public BucleForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bucleFor; }
	 
		public BucleForContext() { }
		public void copyFrom(BucleForContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForContext extends BucleForContext {
		public IdentificadorContext var;
		public ExprContext inicio;
		public ExprContext limite;
		public ExprContext paso;
		public BloqueContext cuerpo;
		public Token_forContext token_for() {
			return getRuleContext(Token_forContext.class,0);
		}
		public Token_igualContext token_igual() {
			return getRuleContext(Token_igualContext.class,0);
		}
		public Token_toContext token_to() {
			return getRuleContext(Token_toContext.class,0);
		}
		public Token_nextContext token_next() {
			return getRuleContext(Token_nextContext.class,0);
		}
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public Token_stepContext token_step() {
			return getRuleContext(Token_stepContext.class,0);
		}
		public ForContext(BucleForContext ctx) { copyFrom(ctx); }
	}

	public final BucleForContext bucleFor() throws RecognitionException {
		BucleForContext _localctx = new BucleForContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bucleFor);
		int _la;
		try {
			_localctx = new ForContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			token_for();
			setState(137);
			((ForContext)_localctx).var = identificador();
			setState(138);
			token_igual();
			setState(139);
			((ForContext)_localctx).inicio = expr(0);
			setState(140);
			token_to();
			setState(141);
			((ForContext)_localctx).limite = expr(0);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STEP) {
				{
				setState(142);
				token_step();
				setState(143);
				((ForContext)_localctx).paso = expr(0);
				}
			}

			setState(147);
			((ForContext)_localctx).cuerpo = bloque();
			setState(148);
			token_next();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SentIFContext extends ParserRuleContext {
		public SentIFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentIF; }
	 
		public SentIFContext() { }
		public void copyFrom(SentIFContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends SentIFContext {
		public Cond1Context condicion;
		public BloqueContext cuerpoVerdadero;
		public BloqueContext cuerpoFalso;
		public Token_ifContext token_if() {
			return getRuleContext(Token_ifContext.class,0);
		}
		public Token_thenContext token_then() {
			return getRuleContext(Token_thenContext.class,0);
		}
		public TerminalNode INTRO() { return getToken(GMiniBParser.INTRO, 0); }
		public Token_endContext token_end() {
			return getRuleContext(Token_endContext.class,0);
		}
		public Cond1Context cond1() {
			return getRuleContext(Cond1Context.class,0);
		}
		public List<BloqueContext> bloque() {
			return getRuleContexts(BloqueContext.class);
		}
		public BloqueContext bloque(int i) {
			return getRuleContext(BloqueContext.class,i);
		}
		public Token_elseContext token_else() {
			return getRuleContext(Token_elseContext.class,0);
		}
		public IfContext(SentIFContext ctx) { copyFrom(ctx); }
	}

	public final SentIFContext sentIF() throws RecognitionException {
		SentIFContext _localctx = new SentIFContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sentIF);
		int _la;
		try {
			_localctx = new IfContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			token_if();
			setState(151);
			((IfContext)_localctx).condicion = cond1(0);
			setState(152);
			token_then();
			setState(153);
			((IfContext)_localctx).cuerpoVerdadero = bloque();
			setState(154);
			match(INTRO);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(155);
				token_else();
				setState(156);
				((IfContext)_localctx).cuerpoFalso = bloque();
				}
			}

			setState(160);
			token_end();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RepetirContext extends ParserRuleContext {
		public RepetirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repetir; }
	 
		public RepetirContext() { }
		public void copyFrom(RepetirContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RepeatUntilContext extends RepetirContext {
		public BloqueContext cuerpo;
		public Cond1Context condicion;
		public Token_repeatContext token_repeat() {
			return getRuleContext(Token_repeatContext.class,0);
		}
		public Token_untilContext token_until() {
			return getRuleContext(Token_untilContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public Cond1Context cond1() {
			return getRuleContext(Cond1Context.class,0);
		}
		public RepeatUntilContext(RepetirContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RepeatContext extends RepetirContext {
		public Cond1Context condicion;
		public Token_repeatContext token_repeat() {
			return getRuleContext(Token_repeatContext.class,0);
		}
		public Cond1Context cond1() {
			return getRuleContext(Cond1Context.class,0);
		}
		public RepeatContext(RepetirContext ctx) { copyFrom(ctx); }
	}

	public final RepetirContext repetir() throws RecognitionException {
		RepetirContext _localctx = new RepetirContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_repetir);
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new RepeatUntilContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(162);
				token_repeat();
				setState(163);
				((RepeatUntilContext)_localctx).cuerpo = bloque();
				setState(164);
				token_until();
				setState(165);
				((RepeatUntilContext)_localctx).condicion = cond1(0);
				}
				}
				break;
			case 2:
				_localctx = new RepeatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				token_repeat();
				setState(168);
				((RepeatContext)_localctx).condicion = cond1(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncionContext extends ParserRuleContext {
		public FuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcion; }
	 
		public FuncionContext() { }
		public void copyFrom(FuncionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncionPrintContext extends FuncionContext {
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public FuncionPrintContext(FuncionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncionConcatenarContext extends FuncionContext {
		public ConcatenarContext concatenar() {
			return getRuleContext(ConcatenarContext.class,0);
		}
		public FuncionConcatenarContext(FuncionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncionInputContext extends FuncionContext {
		public InputStatementContext inputStatement() {
			return getRuleContext(InputStatementContext.class,0);
		}
		public FuncionInputContext(FuncionContext ctx) { copyFrom(ctx); }
	}

	public final FuncionContext funcion() throws RecognitionException {
		FuncionContext _localctx = new FuncionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcion);
		try {
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new FuncionConcatenarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				concatenar();
				}
				break;
			case 2:
				_localctx = new FuncionPrintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				printStatement();
				}
				break;
			case 3:
				_localctx = new FuncionInputContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				inputStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConcatenarContext extends ParserRuleContext {
		public ConcatenarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concatenar; }
	 
		public ConcatenarContext() { }
		public void copyFrom(ConcatenarContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintConcatenarContext extends ConcatenarContext {
		public CadenaContext primerCadena;
		public CadenaContext valorCadena;
		public EnteroContext valorEntero;
		public EnteroContext primerEntero;
		public Token_printContext token_print() {
			return getRuleContext(Token_printContext.class,0);
		}
		public List<TerminalNode> OPSUM() { return getTokens(GMiniBParser.OPSUM); }
		public TerminalNode OPSUM(int i) {
			return getToken(GMiniBParser.OPSUM, i);
		}
		public List<CadenaContext> cadena() {
			return getRuleContexts(CadenaContext.class);
		}
		public CadenaContext cadena(int i) {
			return getRuleContext(CadenaContext.class,i);
		}
		public List<EnteroContext> entero() {
			return getRuleContexts(EnteroContext.class);
		}
		public EnteroContext entero(int i) {
			return getRuleContext(EnteroContext.class,i);
		}
		public PrintConcatenarContext(ConcatenarContext ctx) { copyFrom(ctx); }
	}

	public final ConcatenarContext concatenar() throws RecognitionException {
		ConcatenarContext _localctx = new ConcatenarContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_concatenar);
		int _la;
		try {
			int _alt;
			_localctx = new PrintConcatenarContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			token_print();
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(178);
				((PrintConcatenarContext)_localctx).primerCadena = cadena();
				setState(184); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(179);
					match(OPSUM);
					setState(182);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case STRING:
						{
						setState(180);
						((PrintConcatenarContext)_localctx).valorCadena = cadena();
						}
						break;
					case ENTERO:
						{
						setState(181);
						((PrintConcatenarContext)_localctx).valorEntero = entero();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(186); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==OPSUM );
				}
				break;
			case ENTERO:
				{
				setState(188);
				((PrintConcatenarContext)_localctx).primerEntero = entero();
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(189);
						match(OPSUM);
						setState(190);
						((PrintConcatenarContext)_localctx).valorEntero = entero();
						}
						} 
					}
					setState(195);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				setState(196);
				match(OPSUM);
				setState(197);
				((PrintConcatenarContext)_localctx).valorCadena = cadena();
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OPSUM) {
					{
					{
					setState(198);
					match(OPSUM);
					setState(201);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case STRING:
						{
						setState(199);
						((PrintConcatenarContext)_localctx).valorCadena = cadena();
						}
						break;
					case ENTERO:
						{
						setState(200);
						((PrintConcatenarContext)_localctx).valorEntero = entero();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(207);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatementContext extends ParserRuleContext {
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
	 
		public PrintStatementContext() { }
		public void copyFrom(PrintStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintFuncContext extends PrintStatementContext {
		public ValorGenericoContext primerElemento;
		public OperadorContext operador;
		public List<OperadorContext> op = new ArrayList<OperadorContext>();
		public ValorGenericoContext valorGenerico;
		public List<ValorGenericoContext> siguienteElemento = new ArrayList<ValorGenericoContext>();
		public Token_printContext token_print() {
			return getRuleContext(Token_printContext.class,0);
		}
		public List<ValorGenericoContext> valorGenerico() {
			return getRuleContexts(ValorGenericoContext.class);
		}
		public ValorGenericoContext valorGenerico(int i) {
			return getRuleContext(ValorGenericoContext.class,i);
		}
		public List<OperadorContext> operador() {
			return getRuleContexts(OperadorContext.class);
		}
		public OperadorContext operador(int i) {
			return getRuleContext(OperadorContext.class,i);
		}
		public PrintFuncContext(PrintStatementContext ctx) { copyFrom(ctx); }
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_printStatement);
		int _la;
		try {
			_localctx = new PrintFuncContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			token_print();
			setState(211);
			((PrintFuncContext)_localctx).primerElemento = valorGenerico();
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 100348L) != 0)) {
				{
				{
				setState(212);
				((PrintFuncContext)_localctx).operador = operador();
				((PrintFuncContext)_localctx).op.add(((PrintFuncContext)_localctx).operador);
				setState(213);
				((PrintFuncContext)_localctx).valorGenerico = valorGenerico();
				((PrintFuncContext)_localctx).siguienteElemento.add(((PrintFuncContext)_localctx).valorGenerico);
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InputStatementContext extends ParserRuleContext {
		public InputStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputStatement; }
	 
		public InputStatementContext() { }
		public void copyFrom(InputStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InputFuncContext extends InputStatementContext {
		public CadenaContext mensaje;
		public IdentificadorContext variable;
		public Token_inputContext token_input() {
			return getRuleContext(Token_inputContext.class,0);
		}
		public CadenaContext cadena() {
			return getRuleContext(CadenaContext.class,0);
		}
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public InputFuncContext(InputStatementContext ctx) { copyFrom(ctx); }
	}

	public final InputStatementContext inputStatement() throws RecognitionException {
		InputStatementContext _localctx = new InputStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_inputStatement);
		try {
			_localctx = new InputFuncContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			token_input();
			setState(221);
			((InputFuncContext)_localctx).mensaje = cadena();
			setState(222);
			((InputFuncContext)_localctx).variable = identificador();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OperacionMultDivModContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPMUL() { return getToken(GMiniBParser.OPMUL, 0); }
		public TerminalNode OPDIV() { return getToken(GMiniBParser.OPDIV, 0); }
		public TerminalNode OPMOD() { return getToken(GMiniBParser.OPMOD, 0); }
		public OperacionMultDivModContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OperacionComparacionContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPBLT() { return getToken(GMiniBParser.OPBLT, 0); }
		public TerminalNode OPBGT() { return getToken(GMiniBParser.OPBGT, 0); }
		public TerminalNode OPBGE() { return getToken(GMiniBParser.OPBGE, 0); }
		public TerminalNode OPBLE() { return getToken(GMiniBParser.OPBLE, 0); }
		public TerminalNode OPEQ() { return getToken(GMiniBParser.OPEQ, 0); }
		public TerminalNode OPNEQ() { return getToken(GMiniBParser.OPNEQ, 0); }
		public OperacionComparacionContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionParentesisContext extends ExprContext {
		public ExprContext inner;
		public TerminalNode IPAREN() { return getToken(GMiniBParser.IPAREN, 0); }
		public TerminalNode DPAREN() { return getToken(GMiniBParser.DPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpresionParentesisContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OperacionSumaRestaContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPSUM() { return getToken(GMiniBParser.OPSUM, 0); }
		public TerminalNode OPRES() { return getToken(GMiniBParser.OPRES, 0); }
		public OperacionSumaRestaContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionVariableContext extends ExprContext {
		public IdentificadorContext referencia;
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public ExpresionVariableContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionEnteroContext extends ExprContext {
		public EnteroContext valor;
		public EnteroContext entero() {
			return getRuleContext(EnteroContext.class,0);
		}
		public ExpresionEnteroContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumeroNegContext extends ExprContext {
		public EnteroContext factor;
		public TerminalNode OPRES() { return getToken(GMiniBParser.OPRES, 0); }
		public EnteroContext entero() {
			return getRuleContext(EnteroContext.class,0);
		}
		public NumeroNegContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OperacionIgualContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode OPASIG() { return getToken(GMiniBParser.OPASIG, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OperacionIgualContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new ExpresionVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(225);
				((ExpresionVariableContext)_localctx).referencia = identificador();
				}
				break;
			case OPRES:
				{
				_localctx = new NumeroNegContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				match(OPRES);
				setState(227);
				((NumeroNegContext)_localctx).factor = entero();
				}
				break;
			case IPAREN:
				{
				_localctx = new ExpresionParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				match(IPAREN);
				setState(229);
				((ExpresionParentesisContext)_localctx).inner = expr(0);
				setState(230);
				match(DPAREN);
				}
				break;
			case ENTERO:
				{
				_localctx = new ExpresionEnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				((ExpresionEnteroContext)_localctx).valor = entero();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(249);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(247);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new OperacionIgualContext(new ExprContext(_parentctx, _parentState));
						((OperacionIgualContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(235);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(236);
						match(OPASIG);
						setState(237);
						((OperacionIgualContext)_localctx).right = expr(9);
						}
						break;
					case 2:
						{
						_localctx = new OperacionMultDivModContext(new ExprContext(_parentctx, _parentState));
						((OperacionMultDivModContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(238);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(239);
						((OperacionMultDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 112L) != 0)) ) {
							((OperacionMultDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(240);
						((OperacionMultDivModContext)_localctx).right = expr(7);
						}
						break;
					case 3:
						{
						_localctx = new OperacionSumaRestaContext(new ExprContext(_parentctx, _parentState));
						((OperacionSumaRestaContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(241);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(242);
						((OperacionSumaRestaContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OPSUM || _la==OPRES) ) {
							((OperacionSumaRestaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(243);
						((OperacionSumaRestaContext)_localctx).right = expr(6);
						}
						break;
					case 4:
						{
						_localctx = new OperacionComparacionContext(new ExprContext(_parentctx, _parentState));
						((OperacionComparacionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(244);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(245);
						((OperacionComparacionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 100224L) != 0)) ) {
							((OperacionComparacionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(246);
						((OperacionComparacionContext)_localctx).right = expr(5);
						}
						break;
					}
					} 
				}
				setState(251);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LlamadasFuncionContext extends ParserRuleContext {
		public LlamadasFuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamadasFuncion; }
	 
		public LlamadasFuncionContext() { }
		public void copyFrom(LlamadasFuncionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LlamadaFuncionContext extends LlamadasFuncionContext {
		public Token_funcionContext nombreFuncion;
		public ValorGenericoContext argumento;
		public TerminalNode IPAREN() { return getToken(GMiniBParser.IPAREN, 0); }
		public TerminalNode DPAREN() { return getToken(GMiniBParser.DPAREN, 0); }
		public Token_funcionContext token_funcion() {
			return getRuleContext(Token_funcionContext.class,0);
		}
		public ValorGenericoContext valorGenerico() {
			return getRuleContext(ValorGenericoContext.class,0);
		}
		public LlamadaFuncionContext(LlamadasFuncionContext ctx) { copyFrom(ctx); }
	}

	public final LlamadasFuncionContext llamadasFuncion() throws RecognitionException {
		LlamadasFuncionContext _localctx = new LlamadasFuncionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_llamadasFuncion);
		try {
			_localctx = new LlamadaFuncionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			((LlamadaFuncionContext)_localctx).nombreFuncion = token_funcion();
			setState(253);
			match(IPAREN);
			setState(254);
			((LlamadaFuncionContext)_localctx).argumento = valorGenerico();
			setState(255);
			match(DPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValorGenericoContext extends ParserRuleContext {
		public ValorGenericoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valorGenerico; }
	 
		public ValorGenericoContext() { }
		public void copyFrom(ValorGenericoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValorExprContext extends ValorGenericoContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ValorExprContext(ValorGenericoContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValorFuncionContext extends ValorGenericoContext {
		public LlamadasFuncionContext llamadasFuncion() {
			return getRuleContext(LlamadasFuncionContext.class,0);
		}
		public ValorFuncionContext(ValorGenericoContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValorCadenaContext extends ValorGenericoContext {
		public CadenaContext cadena() {
			return getRuleContext(CadenaContext.class,0);
		}
		public ValorCadenaContext(ValorGenericoContext ctx) { copyFrom(ctx); }
	}

	public final ValorGenericoContext valorGenerico() throws RecognitionException {
		ValorGenericoContext _localctx = new ValorGenericoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_valorGenerico);
		try {
			setState(260);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPRES:
			case IPAREN:
			case ID:
			case ENTERO:
				_localctx = new ValorExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				expr(0);
				}
				break;
			case VAL:
			case LEN:
			case ISNAN:
				_localctx = new ValorFuncionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				llamadasFuncion();
				}
				break;
			case STRING:
				_localctx = new ValorCadenaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(259);
				cadena();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CadenaContext extends ParserRuleContext {
		public CadenaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cadena; }
	 
		public CadenaContext() { }
		public void copyFrom(CadenaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StrContext extends CadenaContext {
		public Token valor;
		public TerminalNode STRING() { return getToken(GMiniBParser.STRING, 0); }
		public StrContext(CadenaContext ctx) { copyFrom(ctx); }
	}

	public final CadenaContext cadena() throws RecognitionException {
		CadenaContext _localctx = new CadenaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_cadena);
		try {
			_localctx = new StrContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			((StrContext)_localctx).valor = match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentificadorContext extends ParserRuleContext {
		public IdentificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identificador; }
	 
		public IdentificadorContext() { }
		public void copyFrom(IdentificadorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends IdentificadorContext {
		public Token nombre;
		public TerminalNode ID() { return getToken(GMiniBParser.ID, 0); }
		public VarContext(IdentificadorContext ctx) { copyFrom(ctx); }
	}

	public final IdentificadorContext identificador() throws RecognitionException {
		IdentificadorContext _localctx = new IdentificadorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_identificador);
		try {
			_localctx = new VarContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			((VarContext)_localctx).nombre = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnteroContext extends ParserRuleContext {
		public EnteroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entero; }
	 
		public EnteroContext() { }
		public void copyFrom(EnteroContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends EnteroContext {
		public Token valor;
		public TerminalNode ENTERO() { return getToken(GMiniBParser.ENTERO, 0); }
		public IntContext(EnteroContext ctx) { copyFrom(ctx); }
	}

	public final EnteroContext entero() throws RecognitionException {
		EnteroContext _localctx = new EnteroContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_entero);
		try {
			_localctx = new IntContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			((IntContext)_localctx).valor = match(ENTERO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextoContext extends ParserRuleContext {
		public TextoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_texto; }
	 
		public TextoContext() { }
		public void copyFrom(TextoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextoComentarioContext extends TextoContext {
		public Token contenido;
		public List<TerminalNode> TEXTO_COMENTARIO() { return getTokens(GMiniBParser.TEXTO_COMENTARIO); }
		public TerminalNode TEXTO_COMENTARIO(int i) {
			return getToken(GMiniBParser.TEXTO_COMENTARIO, i);
		}
		public TextoComentarioContext(TextoContext ctx) { copyFrom(ctx); }
	}

	public final TextoContext texto() throws RecognitionException {
		TextoContext _localctx = new TextoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_texto);
		try {
			int _alt;
			_localctx = new TextoComentarioContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(269); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(268);
					((TextoComentarioContext)_localctx).contenido = match(TEXTO_COMENTARIO);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(271); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ControlFlujoContext extends ParserRuleContext {
		public ControlFlujoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlFlujo; }
	 
		public ControlFlujoContext() { }
		public void copyFrom(ControlFlujoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContinueContext extends ControlFlujoContext {
		public TerminalNode CONTINUE() { return getToken(GMiniBParser.CONTINUE, 0); }
		public ContinueContext(ControlFlujoContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExitContext extends ControlFlujoContext {
		public TerminalNode EXIT() { return getToken(GMiniBParser.EXIT, 0); }
		public ExitContext(ControlFlujoContext ctx) { copyFrom(ctx); }
	}

	public final ControlFlujoContext controlFlujo() throws RecognitionException {
		ControlFlujoContext _localctx = new ControlFlujoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_controlFlujo);
		try {
			setState(275);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXIT:
				_localctx = new ExitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				match(EXIT);
				}
				break;
			case CONTINUE:
				_localctx = new ContinueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
				match(CONTINUE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_repeatContext extends ParserRuleContext {
		public TerminalNode REPEAT() { return getToken(GMiniBParser.REPEAT, 0); }
		public Token_repeatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_repeat; }
	}

	public final Token_repeatContext token_repeat() throws RecognitionException {
		Token_repeatContext _localctx = new Token_repeatContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_token_repeat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(REPEAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_forContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(GMiniBParser.FOR, 0); }
		public Token_forContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_for; }
	}

	public final Token_forContext token_for() throws RecognitionException {
		Token_forContext _localctx = new Token_forContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_token_for);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(FOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_ifContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(GMiniBParser.IF, 0); }
		public Token_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_if; }
	}

	public final Token_ifContext token_if() throws RecognitionException {
		Token_ifContext _localctx = new Token_ifContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_token_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(IF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_toContext extends ParserRuleContext {
		public TerminalNode TO() { return getToken(GMiniBParser.TO, 0); }
		public Token_toContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_to; }
	}

	public final Token_toContext token_to() throws RecognitionException {
		Token_toContext _localctx = new Token_toContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_token_to);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(TO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_elseContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(GMiniBParser.ELSE, 0); }
		public Token_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_else; }
	}

	public final Token_elseContext token_else() throws RecognitionException {
		Token_elseContext _localctx = new Token_elseContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_token_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(ELSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_nextContext extends ParserRuleContext {
		public TerminalNode NEXT() { return getToken(GMiniBParser.NEXT, 0); }
		public Token_nextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_next; }
	}

	public final Token_nextContext token_next() throws RecognitionException {
		Token_nextContext _localctx = new Token_nextContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_token_next);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(NEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_thenContext extends ParserRuleContext {
		public TerminalNode THEN() { return getToken(GMiniBParser.THEN, 0); }
		public Token_thenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_then; }
	}

	public final Token_thenContext token_then() throws RecognitionException {
		Token_thenContext _localctx = new Token_thenContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_token_then);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(THEN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_untilContext extends ParserRuleContext {
		public TerminalNode UNTIL() { return getToken(GMiniBParser.UNTIL, 0); }
		public Token_untilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_until; }
	}

	public final Token_untilContext token_until() throws RecognitionException {
		Token_untilContext _localctx = new Token_untilContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_token_until);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(UNTIL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_stepContext extends ParserRuleContext {
		public TerminalNode STEP() { return getToken(GMiniBParser.STEP, 0); }
		public Token_stepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_step; }
	}

	public final Token_stepContext token_step() throws RecognitionException {
		Token_stepContext _localctx = new Token_stepContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_token_step);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(STEP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_comentarioContext extends ParserRuleContext {
		public TerminalNode REM() { return getToken(GMiniBParser.REM, 0); }
		public Token_comentarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_comentario; }
	}

	public final Token_comentarioContext token_comentario() throws RecognitionException {
		Token_comentarioContext _localctx = new Token_comentarioContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_token_comentario);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(REM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_asignacionContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(GMiniBParser.LET, 0); }
		public Token_asignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_asignacion; }
	}

	public final Token_asignacionContext token_asignacion() throws RecognitionException {
		Token_asignacionContext _localctx = new Token_asignacionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_token_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(LET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_igualContext extends ParserRuleContext {
		public TerminalNode OPASIG() { return getToken(GMiniBParser.OPASIG, 0); }
		public Token_igualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_igual; }
	}

	public final Token_igualContext token_igual() throws RecognitionException {
		Token_igualContext _localctx = new Token_igualContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_token_igual);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(OPASIG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_printContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(GMiniBParser.PRINT, 0); }
		public Token_printContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_print; }
	}

	public final Token_printContext token_print() throws RecognitionException {
		Token_printContext _localctx = new Token_printContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_token_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(PRINT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_inputContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(GMiniBParser.INPUT, 0); }
		public Token_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_input; }
	}

	public final Token_inputContext token_input() throws RecognitionException {
		Token_inputContext _localctx = new Token_inputContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_token_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(INPUT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_endContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(GMiniBParser.END, 0); }
		public Token_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_end; }
	}

	public final Token_endContext token_end() throws RecognitionException {
		Token_endContext _localctx = new Token_endContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_token_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_whileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(GMiniBParser.WHILE, 0); }
		public Token_whileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_while; }
	}

	public final Token_whileContext token_while() throws RecognitionException {
		Token_whileContext _localctx = new Token_whileContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_token_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(WHILE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Token_funcionContext extends ParserRuleContext {
		public Token_funcionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_funcion; }
	 
		public Token_funcionContext() { }
		public void copyFrom(Token_funcionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncionIsNanContext extends Token_funcionContext {
		public TerminalNode ISNAN() { return getToken(GMiniBParser.ISNAN, 0); }
		public FuncionIsNanContext(Token_funcionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncionLenContext extends Token_funcionContext {
		public TerminalNode LEN() { return getToken(GMiniBParser.LEN, 0); }
		public FuncionLenContext(Token_funcionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncionValContext extends Token_funcionContext {
		public TerminalNode VAL() { return getToken(GMiniBParser.VAL, 0); }
		public FuncionValContext(Token_funcionContext ctx) { copyFrom(ctx); }
	}

	public final Token_funcionContext token_funcion() throws RecognitionException {
		Token_funcionContext _localctx = new Token_funcionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_token_funcion);
		try {
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAL:
				_localctx = new FuncionValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				match(VAL);
				}
				break;
			case LEN:
				_localctx = new FuncionLenContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				match(LEN);
				}
				break;
			case ISNAN:
				_localctx = new FuncionIsNanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(311);
				match(ISNAN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperadorContext extends ParserRuleContext {
		public TerminalNode OPMUL() { return getToken(GMiniBParser.OPMUL, 0); }
		public TerminalNode OPDIV() { return getToken(GMiniBParser.OPDIV, 0); }
		public TerminalNode OPMOD() { return getToken(GMiniBParser.OPMOD, 0); }
		public TerminalNode OPSUM() { return getToken(GMiniBParser.OPSUM, 0); }
		public TerminalNode OPRES() { return getToken(GMiniBParser.OPRES, 0); }
		public TerminalNode OPBLT() { return getToken(GMiniBParser.OPBLT, 0); }
		public TerminalNode OPBGT() { return getToken(GMiniBParser.OPBGT, 0); }
		public TerminalNode OPBGE() { return getToken(GMiniBParser.OPBGE, 0); }
		public TerminalNode OPBLE() { return getToken(GMiniBParser.OPBLE, 0); }
		public TerminalNode OPEQ() { return getToken(GMiniBParser.OPEQ, 0); }
		public TerminalNode OPNEQ() { return getToken(GMiniBParser.OPNEQ, 0); }
		public OperadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operador; }
	}

	public final OperadorContext operador() throws RecognitionException {
		OperadorContext _localctx = new OperadorContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_operador);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 100348L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Cond1Context extends ParserRuleContext {
		public Cond1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond1; }
	 
		public Cond1Context() { }
		public void copyFrom(Cond1Context ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Condicion1Context extends Cond1Context {
		public Cond1Context left;
		public Token op;
		public Cond1Context right;
		public List<Cond1Context> cond1() {
			return getRuleContexts(Cond1Context.class);
		}
		public Cond1Context cond1(int i) {
			return getRuleContext(Cond1Context.class,i);
		}
		public TerminalNode OPBLT() { return getToken(GMiniBParser.OPBLT, 0); }
		public TerminalNode OPBLE() { return getToken(GMiniBParser.OPBLE, 0); }
		public TerminalNode OPBGE() { return getToken(GMiniBParser.OPBGE, 0); }
		public TerminalNode OPBGT() { return getToken(GMiniBParser.OPBGT, 0); }
		public TerminalNode OPASIG() { return getToken(GMiniBParser.OPASIG, 0); }
		public TerminalNode OPEQ() { return getToken(GMiniBParser.OPEQ, 0); }
		public TerminalNode OPNEQ() { return getToken(GMiniBParser.OPNEQ, 0); }
		public Condicion1Context(Cond1Context ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValorExprCondContext extends Cond1Context {
		public ExprCondContext exprCond() {
			return getRuleContext(ExprCondContext.class,0);
		}
		public ValorExprCondContext(Cond1Context ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValorFuncionCondContext extends Cond1Context {
		public LlamadasFuncionContext llamadasFuncion() {
			return getRuleContext(LlamadasFuncionContext.class,0);
		}
		public ValorFuncionCondContext(Cond1Context ctx) { copyFrom(ctx); }
	}

	public final Cond1Context cond1() throws RecognitionException {
		return cond1(0);
	}

	private Cond1Context cond1(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Cond1Context _localctx = new Cond1Context(_ctx, _parentState);
		Cond1Context _prevctx = _localctx;
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_cond1, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPRES:
			case IPAREN:
			case ID:
			case ENTERO:
				{
				_localctx = new ValorExprCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(317);
				exprCond();
				}
				break;
			case VAL:
			case LEN:
			case ISNAN:
				{
				_localctx = new ValorFuncionCondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(318);
				llamadasFuncion();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(326);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Condicion1Context(new Cond1Context(_parentctx, _parentState));
					((Condicion1Context)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_cond1);
					setState(321);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(322);
					((Condicion1Context)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 116608L) != 0)) ) {
						((Condicion1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(323);
					((Condicion1Context)_localctx).right = cond1(4);
					}
					} 
				}
				setState(328);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprCondContext extends ParserRuleContext {
		public ExprCondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprCond; }
	 
		public ExprCondContext() { }
		public void copyFrom(ExprCondContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionVariableCondContext extends ExprCondContext {
		public IdentificadorContext referencia;
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public ExpresionVariableCondContext(ExprCondContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionParentesisCondContext extends ExprCondContext {
		public ExprContext inner;
		public TerminalNode IPAREN() { return getToken(GMiniBParser.IPAREN, 0); }
		public TerminalNode DPAREN() { return getToken(GMiniBParser.DPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpresionParentesisCondContext(ExprCondContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumeroNegCondContext extends ExprCondContext {
		public EnteroContext factor;
		public TerminalNode OPRES() { return getToken(GMiniBParser.OPRES, 0); }
		public EnteroContext entero() {
			return getRuleContext(EnteroContext.class,0);
		}
		public NumeroNegCondContext(ExprCondContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionEnteroCondContext extends ExprCondContext {
		public EnteroContext valor;
		public EnteroContext entero() {
			return getRuleContext(EnteroContext.class,0);
		}
		public ExpresionEnteroCondContext(ExprCondContext ctx) { copyFrom(ctx); }
	}

	public final ExprCondContext exprCond() throws RecognitionException {
		ExprCondContext _localctx = new ExprCondContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_exprCond);
		try {
			setState(337);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new ExpresionVariableCondContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(329);
				((ExpresionVariableCondContext)_localctx).referencia = identificador();
				}
				break;
			case OPRES:
				_localctx = new NumeroNegCondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(330);
				match(OPRES);
				setState(331);
				((NumeroNegCondContext)_localctx).factor = entero();
				}
				break;
			case IPAREN:
				_localctx = new ExpresionParentesisCondContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(332);
				match(IPAREN);
				setState(333);
				((ExpresionParentesisCondContext)_localctx).inner = expr(0);
				setState(334);
				match(DPAREN);
				}
				break;
			case ENTERO:
				_localctx = new ExpresionEnteroCondContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(336);
				((ExpresionEnteroCondContext)_localctx).valor = entero();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncContext extends ParserRuleContext {
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
	 
		public FuncContext() { }
		public void copyFrom(FuncContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DefFuncContext extends FuncContext {
		public TerminalNode FUNC() { return getToken(GMiniBParser.FUNC, 0); }
		public TerminalNode ID() { return getToken(GMiniBParser.ID, 0); }
		public TerminalNode IPAREN() { return getToken(GMiniBParser.IPAREN, 0); }
		public TerminalNode DPAREN() { return getToken(GMiniBParser.DPAREN, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public TerminalNode END() { return getToken(GMiniBParser.END, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public DefFuncContext(FuncContext ctx) { copyFrom(ctx); }
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_func);
		int _la;
		try {
			_localctx = new DefFuncContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(FUNC);
			setState(340);
			match(ID);
			setState(341);
			match(IPAREN);
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 687194769416L) != 0)) {
				{
				setState(342);
				parametros();
				}
			}

			setState(345);
			match(DPAREN);
			setState(346);
			bloque();
			setState(347);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametrosContext extends ParserRuleContext {
		public List<ExprCondContext> exprCond() {
			return getRuleContexts(ExprCondContext.class);
		}
		public ExprCondContext exprCond(int i) {
			return getRuleContext(ExprCondContext.class,i);
		}
		public List<TerminalNode> SSEPARADOR() { return getTokens(GMiniBParser.SSEPARADOR); }
		public TerminalNode SSEPARADOR(int i) {
			return getToken(GMiniBParser.SSEPARADOR, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			exprCond();
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SSEPARADOR) {
				{
				{
				setState(350);
				match(SSEPARADOR);
				setState(351);
				exprCond();
				}
				}
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LlamadaFuncCreadaContext extends ParserRuleContext {
		public LlamadaFuncCreadaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamadaFuncCreada; }
	 
		public LlamadaFuncCreadaContext() { }
		public void copyFrom(LlamadaFuncCreadaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LlamadaFuncContext extends LlamadaFuncCreadaContext {
		public TerminalNode ID() { return getToken(GMiniBParser.ID, 0); }
		public TerminalNode IPAREN() { return getToken(GMiniBParser.IPAREN, 0); }
		public TerminalNode DPAREN() { return getToken(GMiniBParser.DPAREN, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public LlamadaFuncContext(LlamadaFuncCreadaContext ctx) { copyFrom(ctx); }
	}

	public final LlamadaFuncCreadaContext llamadaFuncCreada() throws RecognitionException {
		LlamadaFuncCreadaContext _localctx = new LlamadaFuncCreadaContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_llamadaFuncCreada);
		int _la;
		try {
			_localctx = new LlamadaFuncContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			match(ID);
			setState(358);
			match(IPAREN);
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 687194769416L) != 0)) {
				{
				setState(359);
				parametros();
				}
			}

			setState(362);
			match(DPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 39:
			return cond1_sempred((Cond1Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean cond1_sempred(Cond1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001,\u016d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000\\\b\u0000\n\u0000\f\u0000_\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0004\u0001c\b\u0001\u000b\u0001\f\u0001d\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002p\b\u0002\u0001\u0003\u0001\u0003\u0005"+
		"\u0003t\b\u0003\n\u0003\f\u0003w\t\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0003\u0004|\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004\u0082\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0092"+
		"\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u009f\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00ab\b\b\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00b0\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00b7"+
		"\b\n\u0004\n\u00b9\b\n\u000b\n\f\n\u00ba\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u00c0\b\n\n\n\f\n\u00c3\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0003\n\u00ca\b\n\u0005\n\u00cc\b\n\n\n\f\n\u00cf\t\n\u0003\n\u00d1\b"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u00d8\b\u000b\n\u000b\f\u000b\u00db\t\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u00ea\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00f8\b\r\n\r\f\r\u00fb"+
		"\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0105\b\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0004"+
		"\u0013\u010e\b\u0013\u000b\u0013\f\u0013\u010f\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u0114\b\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001"+
		"$\u0001%\u0001%\u0001%\u0003%\u0139\b%\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"\'\u0003\'\u0140\b\'\u0001\'\u0001\'\u0001\'\u0005\'\u0145\b\'\n\'\f\'"+
		"\u0148\t\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0003"+
		"(\u0152\b(\u0001)\u0001)\u0001)\u0001)\u0003)\u0158\b)\u0001)\u0001)\u0001"+
		")\u0001)\u0001*\u0001*\u0001*\u0005*\u0161\b*\n*\f*\u0164\t*\u0001+\u0001"+
		"+\u0001+\u0003+\u0169\b+\u0001+\u0001+\u0001+\u0000\u0002\u001aN,\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJLNPRTV\u0000\u0006\u0001\u0000*+\u0001\u0000"+
		"\u0004\u0006\u0001\u0000\u0002\u0003\u0002\u0000\u0007\n\u000f\u0010\u0002"+
		"\u0000\u0002\n\u000f\u0010\u0002\u0000\u0007\n\u000e\u0010\u0171\u0000"+
		"]\u0001\u0000\u0000\u0000\u0002b\u0001\u0000\u0000\u0000\u0004o\u0001"+
		"\u0000\u0000\u0000\u0006q\u0001\u0000\u0000\u0000\b{\u0001\u0000\u0000"+
		"\u0000\n\u0083\u0001\u0000\u0000\u0000\f\u0088\u0001\u0000\u0000\u0000"+
		"\u000e\u0096\u0001\u0000\u0000\u0000\u0010\u00aa\u0001\u0000\u0000\u0000"+
		"\u0012\u00af\u0001\u0000\u0000\u0000\u0014\u00b1\u0001\u0000\u0000\u0000"+
		"\u0016\u00d2\u0001\u0000\u0000\u0000\u0018\u00dc\u0001\u0000\u0000\u0000"+
		"\u001a\u00e9\u0001\u0000\u0000\u0000\u001c\u00fc\u0001\u0000\u0000\u0000"+
		"\u001e\u0104\u0001\u0000\u0000\u0000 \u0106\u0001\u0000\u0000\u0000\""+
		"\u0108\u0001\u0000\u0000\u0000$\u010a\u0001\u0000\u0000\u0000&\u010d\u0001"+
		"\u0000\u0000\u0000(\u0113\u0001\u0000\u0000\u0000*\u0115\u0001\u0000\u0000"+
		"\u0000,\u0117\u0001\u0000\u0000\u0000.\u0119\u0001\u0000\u0000\u00000"+
		"\u011b\u0001\u0000\u0000\u00002\u011d\u0001\u0000\u0000\u00004\u011f\u0001"+
		"\u0000\u0000\u00006\u0121\u0001\u0000\u0000\u00008\u0123\u0001\u0000\u0000"+
		"\u0000:\u0125\u0001\u0000\u0000\u0000<\u0127\u0001\u0000\u0000\u0000>"+
		"\u0129\u0001\u0000\u0000\u0000@\u012b\u0001\u0000\u0000\u0000B\u012d\u0001"+
		"\u0000\u0000\u0000D\u012f\u0001\u0000\u0000\u0000F\u0131\u0001\u0000\u0000"+
		"\u0000H\u0133\u0001\u0000\u0000\u0000J\u0138\u0001\u0000\u0000\u0000L"+
		"\u013a\u0001\u0000\u0000\u0000N\u013f\u0001\u0000\u0000\u0000P\u0151\u0001"+
		"\u0000\u0000\u0000R\u0153\u0001\u0000\u0000\u0000T\u015d\u0001\u0000\u0000"+
		"\u0000V\u0165\u0001\u0000\u0000\u0000X\\\u0003\u0004\u0002\u0000Y\\\u0003"+
		"\u0006\u0003\u0000Z\\\u0005(\u0000\u0000[X\u0001\u0000\u0000\u0000[Y\u0001"+
		"\u0000\u0000\u0000[Z\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000"+
		"][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^\u0001\u0001\u0000"+
		"\u0000\u0000_]\u0001\u0000\u0000\u0000`c\u0003\u0004\u0002\u0000ac\u0005"+
		"(\u0000\u0000b`\u0001\u0000\u0000\u0000ba\u0001\u0000\u0000\u0000cd\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000"+
		"e\u0003\u0001\u0000\u0000\u0000fp\u0003\b\u0004\u0000gp\u0003\n\u0005"+
		"\u0000hp\u0003\u0010\b\u0000ip\u0003\u0012\t\u0000jp\u0003\f\u0006\u0000"+
		"kp\u0003\u000e\u0007\u0000lp\u0003(\u0014\u0000mp\u0003R)\u0000np\u0003"+
		"V+\u0000of\u0001\u0000\u0000\u0000og\u0001\u0000\u0000\u0000oh\u0001\u0000"+
		"\u0000\u0000oi\u0001\u0000\u0000\u0000oj\u0001\u0000\u0000\u0000ok\u0001"+
		"\u0000\u0000\u0000ol\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000"+
		"on\u0001\u0000\u0000\u0000p\u0005\u0001\u0000\u0000\u0000qu\u0003<\u001e"+
		"\u0000rt\u0003&\u0013\u0000sr\u0001\u0000\u0000\u0000tw\u0001\u0000\u0000"+
		"\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vx\u0001\u0000"+
		"\u0000\u0000wu\u0001\u0000\u0000\u0000xy\u0007\u0000\u0000\u0000y\u0007"+
		"\u0001\u0000\u0000\u0000z|\u0003>\u001f\u0000{z\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0003\"\u0011\u0000"+
		"~\u0081\u0003@ \u0000\u007f\u0082\u0003\u001e\u000f\u0000\u0080\u0082"+
		"\u0003$\u0012\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0080\u0001"+
		"\u0000\u0000\u0000\u0082\t\u0001\u0000\u0000\u0000\u0083\u0084\u0003H"+
		"$\u0000\u0084\u0085\u0003N\'\u0000\u0085\u0086\u0003\u0002\u0001\u0000"+
		"\u0086\u0087\u0003F#\u0000\u0087\u000b\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0003,\u0016\u0000\u0089\u008a\u0003\"\u0011\u0000\u008a\u008b\u0003"+
		"@ \u0000\u008b\u008c\u0003\u001a\r\u0000\u008c\u008d\u00030\u0018\u0000"+
		"\u008d\u0091\u0003\u001a\r\u0000\u008e\u008f\u0003:\u001d\u0000\u008f"+
		"\u0090\u0003\u001a\r\u0000\u0090\u0092\u0001\u0000\u0000\u0000\u0091\u008e"+
		"\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0003\u0002\u0001\u0000\u0094\u0095"+
		"\u00034\u001a\u0000\u0095\r\u0001\u0000\u0000\u0000\u0096\u0097\u0003"+
		".\u0017\u0000\u0097\u0098\u0003N\'\u0000\u0098\u0099\u00036\u001b\u0000"+
		"\u0099\u009a\u0003\u0002\u0001\u0000\u009a\u009e\u0005(\u0000\u0000\u009b"+
		"\u009c\u00032\u0019\u0000\u009c\u009d\u0003\u0002\u0001\u0000\u009d\u009f"+
		"\u0001\u0000\u0000\u0000\u009e\u009b\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1"+
		"\u0003F#\u0000\u00a1\u000f\u0001\u0000\u0000\u0000\u00a2\u00a3\u0003*"+
		"\u0015\u0000\u00a3\u00a4\u0003\u0002\u0001\u0000\u00a4\u00a5\u00038\u001c"+
		"\u0000\u00a5\u00a6\u0003N\'\u0000\u00a6\u00ab\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0003*\u0015\u0000\u00a8\u00a9\u0003N\'\u0000\u00a9\u00ab"+
		"\u0001\u0000\u0000\u0000\u00aa\u00a2\u0001\u0000\u0000\u0000\u00aa\u00a7"+
		"\u0001\u0000\u0000\u0000\u00ab\u0011\u0001\u0000\u0000\u0000\u00ac\u00b0"+
		"\u0003\u0014\n\u0000\u00ad\u00b0\u0003\u0016\u000b\u0000\u00ae\u00b0\u0003"+
		"\u0018\f\u0000\u00af\u00ac\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000"+
		"\u0000\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00b0\u0013\u0001\u0000"+
		"\u0000\u0000\u00b1\u00d0\u0003B!\u0000\u00b2\u00b8\u0003 \u0010\u0000"+
		"\u00b3\u00b6\u0005\u0002\u0000\u0000\u00b4\u00b7\u0003 \u0010\u0000\u00b5"+
		"\u00b7\u0003$\u0012\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b9\u0001\u0000\u0000\u0000\u00b8\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00b8"+
		"\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00d1"+
		"\u0001\u0000\u0000\u0000\u00bc\u00c1\u0003$\u0012\u0000\u00bd\u00be\u0005"+
		"\u0002\u0000\u0000\u00be\u00c0\u0003$\u0012\u0000\u00bf\u00bd\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u0002"+
		"\u0000\u0000\u00c5\u00cd\u0003 \u0010\u0000\u00c6\u00c9\u0005\u0002\u0000"+
		"\u0000\u00c7\u00ca\u0003 \u0010\u0000\u00c8\u00ca\u0003$\u0012\u0000\u00c9"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cc\u0001\u0000\u0000\u0000\u00cb\u00c6\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd"+
		"\u00ce\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf"+
		"\u00cd\u0001\u0000\u0000\u0000\u00d0\u00b2\u0001\u0000\u0000\u0000\u00d0"+
		"\u00bc\u0001\u0000\u0000\u0000\u00d1\u0015\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d3\u0003B!\u0000\u00d3\u00d9\u0003\u001e\u000f\u0000\u00d4\u00d5\u0003"+
		"L&\u0000\u00d5\u00d6\u0003\u001e\u000f\u0000\u00d6\u00d8\u0001\u0000\u0000"+
		"\u0000\u00d7\u00d4\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000"+
		"\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000"+
		"\u0000\u00da\u0017\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000"+
		"\u0000\u00dc\u00dd\u0003D\"\u0000\u00dd\u00de\u0003 \u0010\u0000\u00de"+
		"\u00df\u0003\"\u0011\u0000\u00df\u0019\u0001\u0000\u0000\u0000\u00e0\u00e1"+
		"\u0006\r\uffff\uffff\u0000\u00e1\u00ea\u0003\"\u0011\u0000\u00e2\u00e3"+
		"\u0005\u0003\u0000\u0000\u00e3\u00ea\u0003$\u0012\u0000\u00e4\u00e5\u0005"+
		"\u000b\u0000\u0000\u00e5\u00e6\u0003\u001a\r\u0000\u00e6\u00e7\u0005\f"+
		"\u0000\u0000\u00e7\u00ea\u0001\u0000\u0000\u0000\u00e8\u00ea\u0003$\u0012"+
		"\u0000\u00e9\u00e0\u0001\u0000\u0000\u0000\u00e9\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e9\u00e4\u0001\u0000\u0000\u0000\u00e9\u00e8\u0001\u0000\u0000"+
		"\u0000\u00ea\u00f9\u0001\u0000\u0000\u0000\u00eb\u00ec\n\b\u0000\u0000"+
		"\u00ec\u00ed\u0005\u000e\u0000\u0000\u00ed\u00f8\u0003\u001a\r\t\u00ee"+
		"\u00ef\n\u0006\u0000\u0000\u00ef\u00f0\u0007\u0001\u0000\u0000\u00f0\u00f8"+
		"\u0003\u001a\r\u0007\u00f1\u00f2\n\u0005\u0000\u0000\u00f2\u00f3\u0007"+
		"\u0002\u0000\u0000\u00f3\u00f8\u0003\u001a\r\u0006\u00f4\u00f5\n\u0004"+
		"\u0000\u0000\u00f5\u00f6\u0007\u0003\u0000\u0000\u00f6\u00f8\u0003\u001a"+
		"\r\u0005\u00f7\u00eb\u0001\u0000\u0000\u0000\u00f7\u00ee\u0001\u0000\u0000"+
		"\u0000\u00f7\u00f1\u0001\u0000\u0000\u0000\u00f7\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u001b\u0001\u0000\u0000"+
		"\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u00fd\u0003J%\u0000\u00fd"+
		"\u00fe\u0005\u000b\u0000\u0000\u00fe\u00ff\u0003\u001e\u000f\u0000\u00ff"+
		"\u0100\u0005\f\u0000\u0000\u0100\u001d\u0001\u0000\u0000\u0000\u0101\u0105"+
		"\u0003\u001a\r\u0000\u0102\u0105\u0003\u001c\u000e\u0000\u0103\u0105\u0003"+
		" \u0010\u0000\u0104\u0101\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000"+
		"\u0000\u0000\u0104\u0103\u0001\u0000\u0000\u0000\u0105\u001f\u0001\u0000"+
		"\u0000\u0000\u0106\u0107\u0005&\u0000\u0000\u0107!\u0001\u0000\u0000\u0000"+
		"\u0108\u0109\u0005%\u0000\u0000\u0109#\u0001\u0000\u0000\u0000\u010a\u010b"+
		"\u0005\'\u0000\u0000\u010b%\u0001\u0000\u0000\u0000\u010c\u010e\u0005"+
		",\u0000\u0000\u010d\u010c\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000"+
		"\u0000\u0000\u010f\u010d\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000"+
		"\u0000\u0000\u0110\'\u0001\u0000\u0000\u0000\u0111\u0114\u0005\u001b\u0000"+
		"\u0000\u0112\u0114\u0005\u0019\u0000\u0000\u0113\u0111\u0001\u0000\u0000"+
		"\u0000\u0113\u0112\u0001\u0000\u0000\u0000\u0114)\u0001\u0000\u0000\u0000"+
		"\u0115\u0116\u0005!\u0000\u0000\u0116+\u0001\u0000\u0000\u0000\u0117\u0118"+
		"\u0005\u0014\u0000\u0000\u0118-\u0001\u0000\u0000\u0000\u0119\u011a\u0005"+
		"\u0016\u0000\u0000\u011a/\u0001\u0000\u0000\u0000\u011b\u011c\u0005\u0015"+
		"\u0000\u0000\u011c1\u0001\u0000\u0000\u0000\u011d\u011e\u0005\u0017\u0000"+
		"\u0000\u011e3\u0001\u0000\u0000\u0000\u011f\u0120\u0005\u001a\u0000\u0000"+
		"\u01205\u0001\u0000\u0000\u0000\u0121\u0122\u0005\u0018\u0000\u0000\u0122"+
		"7\u0001\u0000\u0000\u0000\u0123\u0124\u0005\"\u0000\u0000\u01249\u0001"+
		"\u0000\u0000\u0000\u0125\u0126\u0005#\u0000\u0000\u0126;\u0001\u0000\u0000"+
		"\u0000\u0127\u0128\u0005$\u0000\u0000\u0128=\u0001\u0000\u0000\u0000\u0129"+
		"\u012a\u0005\u0001\u0000\u0000\u012a?\u0001\u0000\u0000\u0000\u012b\u012c"+
		"\u0005\u000e\u0000\u0000\u012cA\u0001\u0000\u0000\u0000\u012d\u012e\u0005"+
		"\u0012\u0000\u0000\u012eC\u0001\u0000\u0000\u0000\u012f\u0130\u0005\u0013"+
		"\u0000\u0000\u0130E\u0001\u0000\u0000\u0000\u0131\u0132\u0005\u0011\u0000"+
		"\u0000\u0132G\u0001\u0000\u0000\u0000\u0133\u0134\u0005 \u0000\u0000\u0134"+
		"I\u0001\u0000\u0000\u0000\u0135\u0139\u0005\u001d\u0000\u0000\u0136\u0139"+
		"\u0005\u001e\u0000\u0000\u0137\u0139\u0005\u001f\u0000\u0000\u0138\u0135"+
		"\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0137"+
		"\u0001\u0000\u0000\u0000\u0139K\u0001\u0000\u0000\u0000\u013a\u013b\u0007"+
		"\u0004\u0000\u0000\u013bM\u0001\u0000\u0000\u0000\u013c\u013d\u0006\'"+
		"\uffff\uffff\u0000\u013d\u0140\u0003P(\u0000\u013e\u0140\u0003\u001c\u000e"+
		"\u0000\u013f\u013c\u0001\u0000\u0000\u0000\u013f\u013e\u0001\u0000\u0000"+
		"\u0000\u0140\u0146\u0001\u0000\u0000\u0000\u0141\u0142\n\u0003\u0000\u0000"+
		"\u0142\u0143\u0007\u0005\u0000\u0000\u0143\u0145\u0003N\'\u0004\u0144"+
		"\u0141\u0001\u0000\u0000\u0000\u0145\u0148\u0001\u0000\u0000\u0000\u0146"+
		"\u0144\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u0147"+
		"O\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0149\u0152"+
		"\u0003\"\u0011\u0000\u014a\u014b\u0005\u0003\u0000\u0000\u014b\u0152\u0003"+
		"$\u0012\u0000\u014c\u014d\u0005\u000b\u0000\u0000\u014d\u014e\u0003\u001a"+
		"\r\u0000\u014e\u014f\u0005\f\u0000\u0000\u014f\u0152\u0001\u0000\u0000"+
		"\u0000\u0150\u0152\u0003$\u0012\u0000\u0151\u0149\u0001\u0000\u0000\u0000"+
		"\u0151\u014a\u0001\u0000\u0000\u0000\u0151\u014c\u0001\u0000\u0000\u0000"+
		"\u0151\u0150\u0001\u0000\u0000\u0000\u0152Q\u0001\u0000\u0000\u0000\u0153"+
		"\u0154\u0005\u001c\u0000\u0000\u0154\u0155\u0005%\u0000\u0000\u0155\u0157"+
		"\u0005\u000b\u0000\u0000\u0156\u0158\u0003T*\u0000\u0157\u0156\u0001\u0000"+
		"\u0000\u0000\u0157\u0158\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000"+
		"\u0000\u0000\u0159\u015a\u0005\f\u0000\u0000\u015a\u015b\u0003\u0002\u0001"+
		"\u0000\u015b\u015c\u0005\u0011\u0000\u0000\u015cS\u0001\u0000\u0000\u0000"+
		"\u015d\u0162\u0003P(\u0000\u015e\u015f\u0005\r\u0000\u0000\u015f\u0161"+
		"\u0003P(\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0161\u0164\u0001\u0000"+
		"\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0162\u0163\u0001\u0000"+
		"\u0000\u0000\u0163U\u0001\u0000\u0000\u0000\u0164\u0162\u0001\u0000\u0000"+
		"\u0000\u0165\u0166\u0005%\u0000\u0000\u0166\u0168\u0005\u000b\u0000\u0000"+
		"\u0167\u0169\u0003T*\u0000\u0168\u0167\u0001\u0000\u0000\u0000\u0168\u0169"+
		"\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016a\u016b"+
		"\u0005\f\u0000\u0000\u016bW\u0001\u0000\u0000\u0000 []bdou{\u0081\u0091"+
		"\u009e\u00aa\u00af\u00b6\u00ba\u00c1\u00c9\u00cd\u00d0\u00d9\u00e9\u00f7"+
		"\u00f9\u0104\u010f\u0113\u0138\u013f\u0146\u0151\u0157\u0162\u0168";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}