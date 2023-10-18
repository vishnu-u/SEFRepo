import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SEFTest {

	private Artist artist;
	
	//Running variable initialization before each test method
	@BeforeEach
	void setUp() throws Exception {
	  artist = new Artist();
	 
	}
	
	//Test method for testing ID validity with valid IDs
	@Test
	void TestID_Valid() {
		
		//Setting arrays
		ArrayList<String> Occupations  = new ArrayList<String>();
		ArrayList<String> Genres  = new ArrayList<String>();
		ArrayList<String> Awards  = new ArrayList<String>();
		
		//Filling in data
		Occupations.add("Singer");
		Occupations.add("Writer");
		Occupations.add("Dancer");
		
		Genres.add("Jazz");
		Genres.add("Rock");
		Genres.add("KPop");
		
		Awards.add("2005,2k prime awards winner");
		Awards.add("2001,2k prime awards winner");
		Awards.add("2020,2k prime awards winner");
		
		//Running test with Test data 1
		boolean Result_TD1 = artist.addArtist("569MMMRR_%", "Vishnu", "Melbourne|VIC|AU", "03-09-1999", "bio bio bio bio bio bio bio bio bio bio bio bio ", Occupations, Genres, Awards);
		
		//Clearning old test data
		Occupations.clear();
		Genres.clear();
		Awards.clear();
		
		//FIlling in new test data
		Occupations.add("Singer");
		Occupations.add("Investor");
		Occupations.add("Businessman");
		
		Genres.add("Jazz");
		Genres.add("Blues");
		Genres.add("Hiphop");
		
		Awards.add("2008,Best Song of the Year Award");
	    
		//Running test with Test data 2
		boolean Result_TD2 = artist.addArtist("678ASRTY_%", "Harish", "Melbourne|VIC|AU", "03-05-1997", "bio bio bio bio bio bio bio bio bio bio bio bio ", Occupations, Genres, Awards);
		
        //Performing assertion with results of two test datas
		assertEquals(Result_TD1 && Result_TD2,true);
	}
	
	//Test method for checking ID validity with invalid IDs
	@Test
	void TestID_Invalid()
	{
		//Setting arrays
		ArrayList<String> Occupations  = new ArrayList<String>();
		ArrayList<String> Genres  = new ArrayList<String>();
		ArrayList<String> Awards  = new ArrayList<String>();
				
		//Filling in data
		Occupations.add("Singer");
		Occupations.add("Writer");
		Occupations.add("Dancer");
				
		Genres.add("Jazz");
		Genres.add("Rock");
		Genres.add("KPop");
				
		Awards.add("2005,2k prime awards winner");
		Awards.add("2001,2k prime awards winner");
		Awards.add("2020,2k prime awards winner");
				
		//Running test with Test data 1
		boolean Result_TD1 = artist.addArtist("869MMMRR_%", "Vishnu", "Melbourne|VIC|AU", "03-09-1999", "bio bio bio bio bio bio bio bio bio bio bio bio ", Occupations, Genres, Awards);

				
		//Clearning old test data
		Occupations.clear();
		Genres.clear();
		Awards.clear();
				
		//FIlling in new test data
		Occupations.add("Singer");
		Occupations.add("Investor");
		Occupations.add("Businessman");
				
		Genres.add("Jazz");
		Genres.add("Blues");
		Genres.add("Hiphop");
				
		Awards.add("2008,Best Song of the Year Award");
			    
		//Running test with Test data 2
		boolean Result_TD2 = artist.addArtist("678Asrty_%", "Harish", "Melbourne|VIC|AU", "03-05-1997", "bio bio bio bio bio bio bio bio bio bio bio bio ", Occupations, Genres, Awards);

		//Performing assertion with results of two test datas
		assertEquals(Result_TD1 && Result_TD2,true);
	}
	
	//Method to check address validity with valid address format
	@Test
	void TestAddress_Valid()
	{
		//Setting arrays
		ArrayList<String> Occupations  = new ArrayList<String>();
		ArrayList<String> Genres  = new ArrayList<String>();
		ArrayList<String> Awards  = new ArrayList<String>();
				
		//Filling in data
		Occupations.add("Singer");
		Occupations.add("Writer");
		Occupations.add("Dancer");
				
		Genres.add("Jazz");
		Genres.add("Rock");
		Genres.add("KPop");
				
		Awards.add("2005,2k prime awards winner");
		Awards.add("2001,2k prime awards winner");
		Awards.add("2020,2k prime awards winner");
				
		//Running test with Test data 1
		boolean Result_TD1 = artist.addArtist("569MMMRR_%", "Vishnu", "Melbourne|VIC|AU", "03-09-1999", "bio bio bio bio bio bio bio bio bio bio bio bio ", Occupations, Genres, Awards);
				
		//Clearning old test data
		Occupations.clear();
		Genres.clear();
		Awards.clear();
				
		//FIlling in new test data
		Occupations.add("Singer");
		Occupations.add("Investor");
		Occupations.add("Businessman");
				
		Genres.add("Jazz");
		Genres.add("Blues");
		Genres.add("Hiphop");
				
		Awards.add("2008,Best Song of Year Award");
			    
		//Running test with Test data 2
		boolean Result_TD2 = artist.addArtist("678ACDFG_%", "Harish", "Sydney|NSW|AU", "03-05-1997", "bio bio bio bio bio bio bio bio bio bio bio bio ", Occupations, Genres, Awards);

	    //Performing assertion with results of two test datas
		assertEquals(Result_TD1 && Result_TD2,true);
	}
	
	@Test
	void TestAddress_Invalid()
	{
		//Setting arrays
		ArrayList<String> Occupations  = new ArrayList<String>();
		ArrayList<String> Genres  = new ArrayList<String>();
		ArrayList<String> Awards  = new ArrayList<String>();
						
		//Filling in data
		Occupations.add("Singer");
		Occupations.add("Writer");
		Occupations.add("Dancer");
						
		Genres.add("Jazz");
		Genres.add("Rock");
		Genres.add("KPop");
						
		Awards.add("2005,2k prime awards winner");
		Awards.add("2001,2k prime awards winner");
		Awards.add("2020,2k prime awards winner");
						
		//Running test with Test data 1
		boolean Result_TD1 = artist.addArtist("569MMMRR_%", "Vishnu", "Melbourne,VIC,AU", "03-09-1999", "bio bio bio bio bio bio bio bio bio bio bio bio ", Occupations, Genres, Awards);

						
		//Clearning old test data
		Occupations.clear();
	    Genres.clear();
		Awards.clear();
						
		//FIlling in new test data
		Occupations.add("Singer");
		Occupations.add("Investor");
		Occupations.add("Businessman");
						
		Genres.add("Jazz");
		Genres.add("Blues");
		Genres.add("Hiphop");
						
		Awards.add("2008,Best Song of the Year Award");
					    
		//Running test with Test data 2
		boolean Result_TD2 = artist.addArtist("678ACDFG_%", "Harish", "Sydney|NSW,AU", "03-05-1997", "bio bio bio bio bio bio bio bio bio bio bio bio ", Occupations, Genres, Awards);

		//Performing assertion with results of two test datas
		assertEquals(Result_TD1 && Result_TD2,true);	
	}
	
	@Test
	void TestBio_Valid()
	{
		//Setting arrays
		ArrayList<String> Occupations  = new ArrayList<String>();
		ArrayList<String> Genres  = new ArrayList<String>();
		ArrayList<String> Awards  = new ArrayList<String>();
						
		//Filling in data
		Occupations.add("Singer");
		Occupations.add("Writer");
		Occupations.add("Dancer");
						
		Genres.add("Jazz");
		Genres.add("Rock");
		Genres.add("KPop");
						
		Awards.add("2005,2k prime awards winner");
		Awards.add("2001,2k prime awards winner");
		Awards.add("2020,2k prime awards winner");
						
		//Running test with Test data 1
		boolean Result_TD1 = artist.addArtist("569MMMRR_%", "Vishnu", "Melbourne|VIC|AU", "03-09-1999", "bio bio bio bio bio bio bio bio bio bio bio bio ", Occupations, Genres, Awards);
						
		//Clearning old test data
		Occupations.clear();
		Genres.clear();
		Awards.clear();
						
		//FIlling in new test data
		Occupations.add("Singer");
		Occupations.add("Investor");
		Occupations.add("Businessman");
						
		Genres.add("Jazz");
		Genres.add("Blues");
		Genres.add("Hiphop");
						
		Awards.add("2008,Best Song of the Year Award");
					    
		//Running test with Test data 2
		boolean Result_TD2 = artist.addArtist("678ACDFG_%", "Harish", "Melbourne|VIC|AU", "03-05-1997", "bio bio bio bio bio bio bio bio bio bio bio bio ", Occupations, Genres, Awards);

        //Performing assertion with results of two test datas
		assertEquals(Result_TD1 && Result_TD2,true);	
	}
	
	@Test
	void TestBio_Invalid()
	{
		//Setting arrays
		ArrayList<String> Occupations  = new ArrayList<String>();
		ArrayList<String> Genres  = new ArrayList<String>();
		ArrayList<String> Awards  = new ArrayList<String>();
								
		//Filling in data
		Occupations.add("Singer");
		Occupations.add("Writer");
		Occupations.add("Dancer");
								
		Genres.add("Jazz");
		Genres.add("Rock");
		Genres.add("KPop");
								
		Awards.add("2005,2k prime awards winner");
		Awards.add("2001,2k prime awards winner");
		Awards.add("2020,2k prime awards winner");
								
		//Running test with Test data 1
		boolean Result_TD1 = artist.addArtist("569MMMRR_%", "Vishnu", "Melbourne|VIC|AU", "03-09-1999", "bio bio bio bio bio", Occupations, Genres, Awards);

								
		//Clearning old test data
		Occupations.clear();
	    Genres.clear();
		Awards.clear();
								
		//FIlling in new test data
		Occupations.add("Singer");
		Occupations.add("Investor");
		Occupations.add("Businessman");
								
		Genres.add("Jazz");
		Genres.add("Blues");
		Genres.add("Hiphop");
								
		Awards.add("2008,Best Song of the Year Award");
							    
		//Running test with Test data 2
		boolean Result_TD2 = artist.addArtist("678ACDFG_%", "Harish", "Melbourne|VIC|AU", "03-05-1997", "bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio ", Occupations, Genres, Awards);

		//Performing assertion with results of two test datas
		assertEquals(Result_TD1 && Result_TD2,true);
	}
	
	@Test
	void TestOccupations_Valid()
	{
		//Setting arrays
		ArrayList<String> Occupations  = new ArrayList<String>();
		ArrayList<String> Genres  = new ArrayList<String>();
		ArrayList<String> Awards  = new ArrayList<String>();
								
	    //Filling in data
		Occupations.add("Singer");
		Occupations.add("Writer");
		Occupations.add("Dancer");
								
		Genres.add("Jazz");
		Genres.add("Rock");
		Genres.add("KPop");
								
		Awards.add("2005,2k prime awards winner");
		Awards.add("2001,2k prime awards winner");
		Awards.add("2020,2k prime awards winner");
								
		//Running test with Test data 1
		boolean Result_TD1 = artist.addArtist("569MMMRR_%", "Vishnu", "Melbourne|VIC|AU", "03-09-1999", "bio bio bio bio bio bio bio bio bio bio bio bio ", Occupations, Genres, Awards);
								
		//Clearning old test data
		Occupations.clear();
		Genres.clear();
		Awards.clear();
								
		//FIlling in new test data
		Occupations.add("Singer");
		Occupations.add("Investor");
		Occupations.add("Businessman");
								
		Genres.add("Jazz");
		Genres.add("Blues");
		Genres.add("Hiphop");
								
		Awards.add("2008,Best Song of the Year Award");
							    
		//Running test with Test data 2
		boolean Result_TD2 = artist.addArtist("678ACDFG_%", "Harish", "Melbourne|VIC|AU", "03-05-1997", "bio bio bio bio bio bio bio bio bio bio bio bio ", Occupations, Genres, Awards);

		//Performing assertion with results of two test datas
		assertEquals(Result_TD1 && Result_TD2,true);	
	}
	
	@Test
	void TestOccupations_Invalid()
	{
		//Setting arrays
		ArrayList<String> Occupations  = new ArrayList<String>();
		ArrayList<String> Genres  = new ArrayList<String>();
		ArrayList<String> Awards  = new ArrayList<String>();
										
		//Filling in data
										
		Genres.add("Jazz");
		Genres.add("Rock");
		Genres.add("KPop");
										
		Awards.add("2005,2k prime awards winner");
		Awards.add("2001,2k prime awards winner");
		Awards.add("2020,2k prime awards winner");
										
		//Running test with Test data 1
		boolean Result_TD1 = artist.addArtist("569MMMRR_%", "Vishnu", "Melbourne|VIC|AU", "03-09-1999", "bio bio bio bio bio", Occupations, Genres, Awards);

										
		//Clearning old test data
		Occupations.clear();
		Genres.clear();
		Awards.clear();
										
		//FIlling in new test data
		Occupations.add("Singer");
		Occupations.add("Investor");
		Occupations.add("Businessman");
		Occupations.add("Philanthrophist");
		Occupations.add("Activist");
		Occupations.add("Author");
										
		Genres.add("Jazz");
		Genres.add("Blues");
		Genres.add("Hiphop");
										
		Awards.add("2008,Best Song of the Year Award");
									    
		//Running test with Test data 2
		boolean Result_TD2 = artist.addArtist("678ACDFG_%", "Harish", "Melbourne|VIC|AU", "03-05-1997", "bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio bio ", Occupations, Genres, Awards);

		//Performing assertion with results of two test datas
		assertEquals(Result_TD1 && Result_TD2,true);
	}
	

}
