package br.com.desafiobase2.utils;

import java.text.Normalizer;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.MaskFormatter;

public class StringUtils {

	private StringUtils() {
		throw new IllegalStateException("StringUtils class");
	}

	public static String[] dividir(String string, String separator) {
		String[] array = null;

		if (string != null) {
			array = string.split(separator);
		}

		return array;
	}

	public static String retornarPrimeiraOcorrencia(String pattern, String value) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(value);

		String group = null;
		while (m.find()) {
			group = m.group(1);
			if (group != null) {
				return group;
			}
		}
		return null;
	}

	public static String[] retornarTodasOcorrencias(String pattern, String value) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(value);
		String[] groups = new String[m.groupCount()];
		while (m.find()) {
			for (int i = 1; i <= m.groupCount(); i++) {
				groups[i - 1] = m.group(i);
			}
		}
		return groups;
	}

	public static String removerCaracteresEspeciais(String value) {
		return Normalizer.normalize(value, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	public static String leftPad(String str, int size, char padChar) {
		return org.apache.commons.lang3.StringUtils.leftPad(str, size, padChar);
	}

	public static String rightPad(String str, int size, char padChar) {
		return org.apache.commons.lang3.StringUtils.rightPad(str, size, padChar);
	}
	
	public static boolean iguaisIgnorandoCaracteresEspeciais(String val1, String val2) {
		return removerCaracteresEspeciais(val1).equals(removerCaracteresEspeciais(val2));
	}
	
	/**
	 * <p>
	 * Retorna uma substring que corresponda à primeira ocorrência da expressão regular informada
	 * </p>
	 * @param origem - String de origem
	 * @param regex - Expressão regular para definir a substring
	 * @return String correspondendo ao trecho da String de origem que corresponde à primeira ocorrência da expressão regular ou <b>null</b> caso não encontre nenhuma ocorrência
	 */
	public static String substringByRegex(String origem, String regex) {
		return substringByRegex(origem, regex, 0);
	}
	
	/**
	 * <p>
	 * Retorna uma substring que corresponda à primeira ocorrência da expressão regular informada
	 * </p>
	 * @param origem - String de origem
	 * @param regex - Expressão regular para definir a substring
	 * @param grupo - Grupo da regex com a string desejada 
	 * @return String correspondendo ao trecho da String de origem que corresponde à primeira ocorrência da expressão regular ou <b>null</b> caso não encontre nenhuma ocorrência
	 */
	public static String substringByRegex(String origem, String regex, int grupo) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(origem);
		if(matcher.find())
			return matcher.group(grupo);
		return null;
	}
	
	/**
	 * <p>
	 * Retorna String com todas as substrings que correspondam a todas as ocorrências da expressão regular informada
	 * </p>
	 * @param origem - String de origem
	 * @param regex - Expressão regular para definir as substrings
	 * @return String com todas as substrings que correspondam a todas as ocorrências da expressão regular informada ou <b>null</b> caso não encontre nenhuma ocorrência
	 */
	public static String substringsByRegex(String origem, String regex) {
		String origemAux = origem.replace(" ", "~");
		Pattern pattern = Pattern.compile("(" + regex + "|\\~)");
		Matcher matcher = pattern.matcher(origemAux);
		StringBuilder r  = new StringBuilder();
		while(matcher.find()) {
			r.append(matcher.group(0));
		}
		return r.toString().isEmpty() ? null : r.toString().replace("~", " ");
	}
	
	
	
	/**
	 * <p>
	 * Retorna a string contendo um número passada como valor formatada de acordo com o pattern, utilizando a classe {@link MaskFormatter}.
	 * </p>
	 * @see MaskFormatter
	 * @param valor - String contendo o número para ser formatada (somente números)
	 * @param pattern - pattern da máscara desejada
	 * @return O valor formatado de acordo com a máscara informada
	 */
	public static String formatarStringNumerica(String valor, String pattern) {
		return formatarStringNumerica(valor, pattern, false);
	}
	
	/**
	 * <p>
	 * Retorna a string contendo um número passada como valor formatada de acordo com o pattern, 
	 * utilizando a classe {@link MaskFormatter}.
	 * </p>
	 * @see MaskFormatter
	 * @param valor - String contendo o número para ser formatada (somente números)
	 * @param pattern - pattern da máscara desejada
	 * @param possuiCaractereLiteral - informa se o valor possui caracter literal
	 * @return O valor formatado de acordo com a máscara informada
	 */
	public static String formatarStringNumerica(String valor, String pattern, boolean possuiCaractereLiteral) {
		MaskFormatter maskF;
		try {
			maskF = new MaskFormatter(pattern);
			maskF.setValueContainsLiteralCharacters(possuiCaractereLiteral);
			return maskF.valueToString(valor);
		} catch (ParseException ex) {
            return null;
        }
	}
	
	/**
	 * <p>
	 * Formata uma string no padrão camelCase
	 * </p>
	 * @param str - String para formatação
	 * @return String no padrão camelCase
	 */
	public static String toCamelCase(String str) {
		return toCamelCase(str, ' ');
	}
	
	/**
	 * <p>
	 * Formata uma string no padrão camelCase
	 * </p>
	 * @param str - String para formatação
	 * @param separator - Caractere separador das palavras na String
	 * @return String no padrão camelCase
	 */
	public static String toCamelCase(String str, char separator) {
		StringBuilder strBuilder = new StringBuilder(str);
		boolean anteriorFoiSeparador = true;
		for(int i = 0; i < strBuilder.length(); i++) {
			char ch = strBuilder.charAt(i);
			if(anteriorFoiSeparador && Character.isLetter(ch)) {
				strBuilder.setCharAt(i, String.valueOf(ch).toUpperCase().charAt(0));
				anteriorFoiSeparador = false;
			}
			else if(!anteriorFoiSeparador && Character.isLetter(ch)) {
				strBuilder.setCharAt(i, String.valueOf(ch).toLowerCase().charAt(0));
				anteriorFoiSeparador = false;
			}
			else if(ch != separator)
				anteriorFoiSeparador = false;
			else
				anteriorFoiSeparador = true;
		}
		return strBuilder.toString();
	}
	
	/**
	 * <p>
	 * Conta a quantidade de ocorrências de uma substring em uma string
	 * </p>
	 * @param str - String para verificação
	 * @param findStr - Substring para contagem
	 * @return Total de ocorrências da substring
	 */
	public static int contaOcorrencias(String str, String findStr) {
		int lastIndex = 0;
		int count = 0;

		while(lastIndex != -1) {
		    lastIndex = str.indexOf(findStr,lastIndex);
		    if(lastIndex != -1) {
		        count ++;
		        lastIndex += findStr.length();
		    }
		}
		return count;
	}
}