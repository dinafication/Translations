package nepal.dina.transalation;

import java.util.HashMap;
import java.util.HashSet;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

public abstract class Translator {
	
	protected Language from;
	protected Language to;	
	
	
	public Translator(Language from, Language to){
		
		this.from = from;
		this.to = to;
				
	}
	
	public abstract HashSet<String> translate(String word) throws Exception;
	
	public abstract HashMap<String, HashSet<String>> translateAll(HashSet<String> words) throws Exception;
}
