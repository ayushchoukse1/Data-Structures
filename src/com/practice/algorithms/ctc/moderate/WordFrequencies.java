package com.practice.algorithms.ctc.moderate;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class WordFrequencies {
	public int frequency(String paragraph, String word) {
		if (paragraph == null || word == null) {
			return 0;
		}
		HashMap<String, Integer> map = getDictionary(paragraph);
		if (map.get(word) == null)
			return 0;
		else
			return map.get(word);

	}

	private HashMap<String, Integer> getDictionary(String paragraph) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		StringTokenizer tokenizer = new StringTokenizer(paragraph, " ");
		while (tokenizer.hasMoreElements()) {
			String token = tokenizer.nextToken();
			if (map.containsKey(token))
				map.put(token, map.get(token) + 1);
			else
				map.put(token, 1);
		}
		return map;
	}

	public static void main(String[] args) {
		String paragraph = "The Eurasian rock pipit (nominated by Jimfbleak) is a small species of "
				+ "passerine bird that breeds in western Europe on rocky coasts. "
				+ "It has streaked greyish-brown upperparts and buff underparts, and is similar in appearance to"
				+ " other European pipits. It is territorial at least in the breeding season, and year-round where it"
				+ " is resident. Eurasian rock pipits construct a cup nest under coastal vegetation or in cliff crevices "
				+ "and lay four to six speckled pale grey eggs which hatch in about two weeks with a further 16 days to fledging."
				+ " Although insects are occasionally caught in flight, the pipits feed mainly on small invertebrates picked"
				+ " off the rocks or from shallow water. It is evaluated as a species of least concern by the International"
				+ " Union for Conservation of Nature.Allen Walker (nominated by Tintor2) is a fictional character who "
				+ "appears as the protagonist of the manga D.Gray-man by Katsura Hoshino. In the series, set on 19th-century"
				+ " Earth, Allen Walker is a teenager who joins the Black Order, a group of soldiers known as "
				+ "Exorcists. As an Exorcist, Allen is able to use a mysterious object known as Innocence to fight "
				+ "demons known as Akuma. Allen's Innocence takes the form of a giant left arm initially, but evolves"
				+ " over time and gives him new abilities. Over the course of the series, Allen uses these powers to "
				+ "fight the Millennium Earl, who created the army of Akuma to destroy the world, and his super-human"
				+ " followers, the Noah Family. During his adventures, Allen learns he is connected to the Noah and might "
				+ "turn into one of them. Allen has been very popular with D.Gray-man readers, usually ranking in the top"
				+ " three in the series' popularity polls. Reactions to him have also been generally positive in manga and "
				+ "anime publications and other media. His character design has been highly praised,"
				+ " critics noting characteristics atypical of a shōnen protagonist, such as his calm demeanor and mysterious"
				+ " origin.O. G. S. Crawford (nominated by Midnightblueowl) (1886–1957) was a British archaeologist who "
				+ "specialised in the study of prehistoric Britain and the archaeology of Sudan. Working for most of his"
				+ " career as the archaeological officer of the Ordnance Survey, he wrote a range of books on archaeological"
				+ " subjects and was a keen proponent of aerial archaeology.The World Before the Flood (nominated by Iridescent)"
				+ " is an oil painting on canvas by English artist William Etty, first exhibited in 1828 and currently in the"
				+ "Southampton City Art Gallery. When first exhibited at the Royal Academy Summer Exhibition the painting "
				+ "attracted large crowds, and strongly divided critical opinion. It was greatly praised by many critics,"
				+ " who counted it among the finest works of art in the country. Other reviewers condemned it as crude, "
				+ "tasteless, offensive and poorly executed.Taylor Swift (nominated by FrB.TG and IndianBio) (born 1989) "
				+ "is an American singer-songwriter. One of the most popular contemporary female recording artists, she is"
				+ " known for narrative songs about her personal life, which has received much media attention.Sabrina "
				+ "Sidney (nominated by Worm That Turned and Staceydolxx) (1757–1843) was a British foundling girl taken"
				+ " in when she was twelve by author Thomas Day, who wanted to mould her into his perfect wife. Day had been"
				+ " struggling to find a wife who would share his ideology and had been rejected by several women. Inspired "
				+ "by Jean-Jacques Rousseau's book Emile, or On Education, he decided to educate two girls without any "
				+ "frivolities, using his own concepts.Hands Across Hawthorne (nominated by Another Believer) was a rally "
				+ "held at the Hawthorne Bridge in Portland, Oregon, in 2011, in response to an attack on a gay male couple"
				+ " one week earlier for holding hands while walking across the bridge. The assault was condemned by "
				+ "Portland's gay mayor, Sam Adams, and its police chief, Mike Reese, and news of the attack spread "
				+ "throughout the United States. The attack prompted volunteers from the Q Center to form street patrols"
				+ " as a means of monitoring Portland's downtown area. Several LGBT and human rights organizations "
				+ "sponsored Hands Across Hawthorne in response to the attack, with the purpose of linking hands across "
				+ "the entire span of the Hawthorne Bridge to show solidarity. More than 4,000 people attended the rally, "
				+ "which had been publicized on a single Facebook page 72 hours previously. The event received attention"
				+ " throughout the United States.Ghost Stories (nominated by Mike Christie) was an American pulp magazine "
				+ "that published 64 issues between 1926 and 1932. It was one of the earliest competitors to Weird Tales,"
				+ " and a companion magazine to True Story and True Detective Stories, and focused almost entirely on stories"
				+ " about ghosts, many of which were written by staff writers but presented under pseudonyms as true c"
				+ "onfessions. These were often accompanied by faked photographs to make the stories appear more believable. "
				+ "The magazine was initially successful, but began to lose readers, and in 1930 was sold to Harold Hersey. "
				+ "Hersey was unable to reverse the magazine's decline, and Ghost Stories ceased publication at the start of"
				+ " 1932.Featured listsTwo featured lists were promoted.Ben Affleck (born 1972) is an American actor and "
				+ "filmmaker. His filming career (nominated by Renamed user henga2423) began in 1981 with a minor part in "
				+ "the independent film The Dark End of the Street. Since then, he has appeared in 47 further films, 2 "
				+ "television films and 39 television episodes. Affleck has also directed six films and wrote the screenplay "
				+ "for four films and a television series.Slovenia first participated as an independent nation at the Olympic "
				+ "Games (nominated by Tone) at the 1992 Winter Olympics in Albertville, France, and the country has sent "
				+ "athletes to compete at every Games since then. The Slovenian Olympic Committee was established in 1991"
				+ " and was recognised by the International Olympic Committee in 1992. Athletes representing Slovenia have "
				+ "won a total of 23 medals at the Summer Olympic Games and another 15 at the Winter Olympic Games. Slovenia"
				+ "'s most successful Summer Olympics as of 2016 have been the 2000 Summer Olympics where they won two gold "
				+ "medals and the 2008 Summer Olympics where they won five medals overall, including one gold. "
				+ "The most successful winter games were the 2014 Winter Olympics, where Slovenian athletes won a record "
				+ "eight medals, including two gold";
		WordFrequencies wf = new WordFrequencies();
		System.out.println(wf.frequency(paragraph, "ayush"));
	}

}
