package Monopoly;

import java.util.Vector;

public class Board {
private Vector<Field> fields = new Vector<>();

    public Board()
   {
      fields.add(new Field("start",0));
      fields.add(new Field("Tower",250));
      fields.add(new Field("Crater",-100));
      fields.add(new Field("Palace Gates",100));
      fields.add(new Field("Cold Desert",-20));
      fields.add(new Field("Walled City",100));
      fields.add(new Field("Monastery",0));
      fields.add(new Field("Black Cave",-70));
      fields.add(new Field("Huts In The Mountain",60));
       fields.add(new Field("The Warewall, You Get A Extra Turn",80));
       fields.add(new Field("The Pit",-50));
       fields.add(new Field("Goldmine",650));
       fields.add(new Field("Iceland",10));
       fields.add(new Field("You Have a Punkture",-100));
       fields.add(new Field("Desert",-30));
       fields.add(new Field("Blue City",75));
       fields.add(new Field("The Market",-55));
       fields.add(new Field("Happy Birthday",300));
       fields.add(new Field("Kindergarden",-90));
       fields.add(new Field("School",-75));
       fields.add(new Field("You Got Drunk",-200));
       fields.add(new Field("Medical", -400));
       fields.add(new Field("USA",250));
       fields.add(new Field("You Played Football",-100));
       fields.add(new Field("Red Light",69));
       fields.add(new Field("You Won The Lottery",1000));
       fields.add(new Field("Stopped By The Police",-95));
       fields.add(new Field("Liberary",100));
       fields.add(new Field("Date Night",-200));
       fields.add(new Field("Hometown",85));
       fields.add(new Field("You Found Some Money On The Street",35));
       fields.add(new Field("You Got a Kid",-600));
       fields.add(new Field("Your Car Crashed",-1000));
       fields.add(new Field("Go To Field Nr. 40",0));
       fields.add(new Field("Amsterdam",50));
       fields.add(new Field("Greenland",-30));
       fields.add(new Field("Wall Street",95));
       fields.add(new Field("Mexico Boarder",-250));
       fields.add(new Field("Dubaii",100));
       fields.add( new Field("Paradise",750));
   }
  public Field getField(int location)
   {
       return fields.get(location);
   }
   }
