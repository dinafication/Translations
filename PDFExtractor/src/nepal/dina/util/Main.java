package nepal.dina.util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import nepal.dina.data.json.translated.WordTranslation;
import nepal.dina.data.json.translated.WordTranslationList;
import nepal.dina.io.FileIO;
import nepal.dina.io.JsonIO;
import nepal.dina.io.XMLWriter1;
import nepal.dina.parsers.English_pre_intermediate;
import nepal.dina.parsers.NewEnglisFilePreIntermediateWordlist;
import nepal.dina.parsers.Parser;
import nepal.dina.parsers.total_english_pre_intermediate_eng_fra;
import nepal.dina.transalation.GlodsyTranslator;

import org.xml.sax.SAXException;

import com.memetix.mst.language.Language;


public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		
		try {
			
			HashSet<String> ret = new HashSet<String>();
			
//			Parser parser = new English_pre_intermediate("res\\levels\\PI\\prevedno\\English_pre_intermediate.pdf");
//			ArrayList<String> ret1 = parser.extract(11,2);
//			parser.close();
//			ret.addAll(ret1);
//			
//			Parser parser2 = new NewEnglisFilePreIntermediateWordlist("res\\levels\\PI\\prevedno\\New English File Pre-Intermediate Wordlist.pdf");
//			ArrayList<String> ret2 = parser2.extract(7,2);
//			parser.close();
//			ret.addAll(ret2);
//			
//			Parser parser3 = new total_english_pre_intermediate_eng_fra("res\\levels\\PI\\prevedno\\total-english-pre-intermediate-eng-fra.pdf");
//			ArrayList<String> ret3 = parser3.extract(5,2);
//			parser3.close();
//			ret.addAll(ret3);
//			
			
			
			//FileIO.writeInFile("res\\levels\\PI\\PI", ret);
			//FileIO.writeInFile("res\\wordLists\\PI", ret);
			
			HashSet<String> words = FileIO.readFromFile("res\\wordlists\\PI_1");
			//HashSet<String> words = FileIO.readFromFile("res\\levels\\PI\\PI_1");
			
			
			Language from = Language.ENGLISH;
			Language dest = Language.GERMAN;
			GlodsyTranslator gt = new GlodsyTranslator(from, dest);
			HashMap<String, HashSet<String>> wordsNTranslations = gt.translateAll(words);
			JsonIO jio = new JsonIO();
			String jios = null;
			
			
			WordTranslationList list = new WordTranslationList();
			for(String word:wordsNTranslations.keySet()){
				list.addWT(new WordTranslation(word, wordsNTranslations.get(word)));
			}
			
			jios = jio.getString(list);
			
			FileIO.appendFile("res\\translations\\PI_eng_ger", jios);
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
