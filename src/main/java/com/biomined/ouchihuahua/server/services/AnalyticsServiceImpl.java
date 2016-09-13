package com.biomined.ouchihuahua.server.services;

import com.biomined.ouchihuahua.shared.model.PainEvent;
import com.google.gwt.thirdparty.guava.common.base.Throwables;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.util.Version;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by scole on 8/22/14.
 */
public class AnalyticsServiceImpl implements AnalyticsService {

//    private final PainEventDao painEventDao = new PainEventDaoImpl();
    private static final Logger LOG = Logger.getLogger(AnalyticsServiceImpl.class.getName());

    /*
        1. For each event, create a list of space delimited words.
        2. create a map <word,word_count>
        3. for each event list from 1, add all words to the map from 2.

         maybe transform the list to <Integer, ArrayList<String>> to order the frequencies
                                      (frequency, words)


        build arraylist of all terms, remove stop words, build term frequency map


     */

    @Override
    public TreeMap<Integer, List<String>> getWordFrequency(String userId) {

        ArrayList<PainEvent> painEvents = null; //painEventDao.findAllByUserId(Long.valueOf(userId));

        try {
            StringBuilder terms = getTerms(painEvents);


        } catch (Exception e) {
            LOG.log(Level.SEVERE, Throwables.getStackTraceAsString(e));
        }

        return null;
    }

    private StringBuilder getTerms(ArrayList<PainEvent> painEvents) throws Exception {

        StringBuilder sb = new StringBuilder();

        for (PainEvent painEvent : painEvents) {

            String notes = painEvent.getNotes();

            if (notes != null && !notes.isEmpty()) {
                sb.append(removeStopWords(notes));
            }
        }
        return sb;
    }

    @Override
    public TreeMap<Integer, List<String>> getWordFrequency(String userId, Date startDate, Date endDate) {
        return null;
    }

    private StringBuilder removeStopWords(String textFile) throws Exception {
        CharArraySet stopWords = EnglishAnalyzer.getDefaultStopSet();
        TokenStream tokenStream = new StandardTokenizer(Version.LUCENE_48, new StringReader(textFile.trim()));

        tokenStream = new StopFilter(Version.LUCENE_48, tokenStream, stopWords);
        StringBuilder sb = new StringBuilder();
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        tokenStream.reset();
        while (tokenStream.incrementToken()) {
            String term = charTermAttribute.toString();
            sb.append(term + " ");
        }
        return sb;
    }
}
