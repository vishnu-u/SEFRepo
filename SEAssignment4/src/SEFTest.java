import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SEFTest {

	private Artist artist;
	
	//Running variable initialization before each test method
	@BeforeEach
	void setUp() throws Exception {
	  artist = new Artist();
	}
	
	@BeforeClass
	void createFile()
	{
		Artist.createFile();
	}
	
	//Test method to add an artist with valid IDs
	@Test
	void TestAdddArtist_ID_Valid() {
		
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
	
	
	//Test method to add an artist with invalid IDs
	@Test
	void TestAddArtist_ID_Invalid()
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
		boolean Result_TD1 = artist.addArtist("469MMMRR_%", "Vishnu", "Melbourne|VIC|AU", "03-09-1999", "bio bio bio bio bio bio bio bio bio bio bio bio ", Occupations, Genres, Awards);

				
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
		assertEquals(Result_TD1 && Result_TD2,false);
	}
	
	
	//Test Method to add an artist with valid address format
	@Test
	void TestAddArtist_Address_Valid()
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
	
	//Test Method to add an artist with an invalid address
	@Test
	void TestAddArtist_Address_Invalid()
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
		assertEquals(Result_TD1 && Result_TD2,false);	
	}
	
	//Test Method to add an artist with a valid bio
	@Test
	void TestAddArtist_Bio_Valid()
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
	
	//Test Method to add an artist with an invalid bio
	@Test
	void TestAddArtist_Bio_Invalid()
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
		assertEquals(Result_TD1 && Result_TD2,false);
	}
	
	//Test Method to add an artist with valid occupations
	@Test
	void TestAddArtist_Occupations_Valid()
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
	
	//Test Method to add an artist with invalid occupations
	@Test
	void TestAddArtist_Occupations_Invalid()
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
		assertEquals(Result_TD1 && Result_TD2,false);
	}
	
	//Test Method to update the address of an artist with a valid address format
	@Test
	void TestUpdateArtist_Address_Valid()
	{
		boolean Result_TD1 = artist.updateArtist("569MMMRR_%", null, "Sydney|NSW|AU", null, null, null, null, null,0);
		boolean Result_TD2 = artist.updateArtist("678ACDFG_%", null, "Brisbane|QLD|AU", null, null, null, null, null,0);
		assertEquals(Result_TD1,true);
	}
	
	//Test Method to update the birthdate of an artist with a valid birthdate
	@Test
	void TestUpdateArtist_Birthdate_Valid()
	{
		boolean Result_TD1 = artist.updateArtist("569MMMRR_%", null, null, "03-09-1998", null, null, null, null,-1);
		boolean Result_TD2 = artist.updateArtist("678ACDFG_%", null, null, "05-06-1999", null, null, null, null,-1);
		assertEquals(Result_TD1 && Result_TD2,true);
	}
	
	//Test Method to update the birthdate of an artist with invalid birthdate
	@Test
	void TestUpdateArtist_Birthdate_InValid()
	{
		boolean Result_TD1 = artist.updateArtist("569MMMRR_%", null, null, "03-19-1998", null, null, null, null,-1);
		boolean Result_TD2 = artist.updateArtist("678ACDFG_%", null, null, "1999-06-05", null, null, null, null,-1);
	    assertEquals(Result_TD1 && Result_TD2,false);
	}
	
	
	//Test Method to update the occupations of an artist with valid occupations list
	@Test
	void TestUpdateArtist_Occupations_Valid()
	{
		//Filling in test data
		ArrayList<String> Occupations = new ArrayList<String>();
		Occupations.add("Author");
		Occupations.add("Writer");
		Occupations.add("Dancer");
		boolean Result_TD1 = artist.updateArtist("569MMMRR_%", null, null, null, null, Occupations, null, null,-1);
	
		//Clearing old data
		Occupations.clear();
		
		//Filling in new test data
		Occupations.add("Singer");
		Occupations.add("Investor");
		Occupations.add("Businessman");
		Occupations.add("Author");
		boolean Result_TD2 = artist.updateArtist("678ACDFG_%", null, null, null, null, Occupations, null, null,-1);
		assertEquals(Result_TD1 && Result_TD2,true);
	}
	
	//Test Method to update the occupations of an artist with invalid occupations list
	@Test
	void TestUpdateArtist_Occupations_InValid()
	{
		//Preparing test data
		ArrayList<String> Occupations = new ArrayList<String>();;
		boolean Result_TD1 = artist.updateArtist("569MMMRR_%", null, null, null, null, Occupations, null, null,-1);
	
		//Clearing old test data
		Occupations.clear();
		
		//Filling in new test data
		Occupations.add("Singer");
		Occupations.add("Investor");
		Occupations.add("Businessman");
		Occupations.add("Author");
		Occupations.add("Activist");
		boolean Result_TD2 = artist.updateArtist("678ACDFG_%", null, null, null, null, Occupations, null, null,-1);
		assertEquals(Result_TD1 && Result_TD2,false);
	}
	
	

}
