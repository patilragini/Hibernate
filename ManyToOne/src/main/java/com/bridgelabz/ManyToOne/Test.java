package com.bridgelabz.ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	private static SessionFactory factory;       
    public static void main(String args[])
    {
       Configuration cfg = new Configuration().configure();
       factory = cfg.buildSessionFactory();
       
       Session session = factory.openSession();
       Transaction tx = session.beginTransaction();

       Stadium stadium = new Stadium();
      
       stadium.setCapacity(100);
       stadium.setCountry("india");
       stadium.setName("Wankhede");
       CricketMatch match = new CricketMatch();

       match.setTeam1("bangladesh");
       match.setTeam2("england");
       match.setType("ODI");
       match.setUmpire("billy");
       match.setStadium(stadium);

       session.save(stadium);
       int matchId = (Integer)session.save(match);

       tx.commit();
       session.close();

       getMatchDetails(matchId);

       factory.close();        
   }

   private static void getMatchDetails(int id)
   {
       Session session = factory.openSession();        
       CricketMatch match = (CricketMatch)session.get(CricketMatch.class,id);        
       Stadium stadium = match.getStadium();
       System.out.println(match);
       System.out.println(stadium);
   }
}
