import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;

public class Artist {
 private String ID;
 private String Name;
 private String Address;
 private String Birthdate;
 private String Bio;
 private ArrayList<String> Occupations;
 private ArrayList<String> Genres;
 private ArrayList<String> Awards;
 
 //Constructor to take parameters and set the values
 public Artist(String id, String name, String address, String birthdate, String bio,
		       ArrayList<String> occupations, ArrayList<String> genres, ArrayList<String> awards)
 {
	 ID = id;
	 Name = name;
	 Address = address;
	 Birthdate = birthdate;
	 Bio = bio;
	 Occupations = occupations;
	 Genres = genres;
	 Awards = awards;
 }
 
 //Empty constructor to instantiate an object
 public Artist()
 {
	 
 }
 

 //Method to add an artist to a file. The method takes all the details of the artist as parameters
 //and performs validation before adding to the file. If success, the method returns true, else false
public boolean addArtist(String id, String name, String address, String birthdate, String bio,
	       ArrayList<String> occupations, ArrayList<String> genres, ArrayList<String> awards)
 {
	 try
	 {
		 boolean Status = true;
		 
		 //File handler
		 FileWriter out = null;
  
  //File handle to write artist details to file
  out = new FileWriter("C:\\Users\\Asus\\eclipse-workspace\\SEAssignment4\\src\\artists.txt",true);
  
  //Checking format for ArtistID
  int sub_cond1 = id.length();
  
  //To check if first three numbers are between 5-9
  String regex_1 = "[5-9]+";
  
  //To check if characters 4-8 are uppercase letters
  String regex_2 = "[A-Z]+";
  
  //To check if last two characters are special characters
  String regex_3 = "[^a-zA-Z0-9]+";
  
  if(sub_cond1 == 10 &&
	 Pattern.compile(regex_1).matcher(id.substring(0, 3)).matches() && 
     Pattern.compile(regex_2).matcher(id.substring(3,8)).matches() && 
     Pattern.compile(regex_3).matcher(id.substring(id.length() - 2 ,id.length())).matches())
   {
	  Status = true;
   }
   else
   {
	  return false;
   }
  
   //Checking date format. Throws exception if not in correct format
  Date Convertedbirthdate=new SimpleDateFormat("dd-MM-yyyy").parse(birthdate);  
  
  //Checking address format
  for(int i =0;i<address.split("\\|").length;i++)
  {
	  if(address.split("\\|")[i].trim() == "")
	  {
		  return false;
	  }
	  else
	  {
		  Status = true;
	  }
	  
  }
  
  //Checking if there are three elements in the address
  if(address.split("\\|").length == 3)
  {
	  Status = true;
  }
  else
  {
    return false;
  }
  
  //Checking word count of bio (>=10 and <=30)
  if(bio.split(" ").length >= 10 && bio.split(" ").length <= 30)
  {
	  Status = true;
  }
  else
  {
	  return false;
  }
  
  //Checking occupations count (between 1-5)
  if(occupations.size() >= 1 && occupations.size() <= 5)
  {
	  Status = true;
  }
  else
  {
	  return false;
  }
  
  //Checking awards count(<=3) and in the format of year,title
  if(awards.size() <= 3)
  {
	  for(int i =0;i<awards.size();i++)
	  {
		  String[] award = awards.get(i).split(",");
		  
		  //Year should be a valid integer
		  int year = Integer.parseInt(award[0]); 
		  if(award[1].split(" ").length >= 4 && award[1].split(" ").length <= 10)
		  {
			  Status = true;
		  }
		  else
		  {
			  return false;
		  }
	  }
  }
  else
  {
	  return false;
  }
  
  //Checking genres list (between 2 and 5 and no pop and rock for the same aritst)
  if(genres.size() >= 2 && genres.size() <= 5)
  {
	  if(genres.stream().map(x->x.toLowerCase()).toList().contains("pop") && genres.stream().map(x->x.toLowerCase()).toList().contains("rock"))
	  {
		  return false;
	  }
	  else
	  {
		  Status = true;
	  }
  }
  else
  {
	  return false;
  }
     
     //Writing the content to the file with ~ as the separator
     out.write(id + "~"+ name + "~" + address + "~" + birthdate + "~" + bio + "~" +
  	           String.join(",", occupations) + "~" + String.join(",", genres) + "~" + String.join(",", awards) + "\n");
     out.close();
     return true;
	 }
	 catch(Exception ex)
	 {
		 return false;
	 }
 }
 
//Method to update the data in the file. The entity, id and value are taken as parameters.
 public boolean UpdateFile(String entity, String id, String value) throws IOException
 {
	 //File handles
	 FileReader in = null;
	 FileWriter out = null;
	 BufferedReader Reader = null;
	 String ReadLine;
	 
	 try
	 {
	 //Reading the source file
	 in = new FileReader("C:\\Users\\Asus\\eclipse-workspace\\SEAssignment4\\src\\artists.txt");
	 Reader = new BufferedReader(in);
	 
	 //Initiating a temp file to write the edited data
	 out = new FileWriter("C:\\Users\\Asus\\eclipse-workspace\\SEAssignment4\\src\\temp.txt");
	 
	 //Reading all lines to get the artists with the given ID. If not there, the line is written to file
	 //If found the necessary editings are done and then written to temp file
	 while((ReadLine=Reader.readLine()) != null)
	 {
	   //If the read ID does not match the supplied ID, write the last as it is to temp file
	   if(ReadLine.split("~")[0].equals(id) == false)
	   {
		   out.write(ReadLine);
	   }
	   else
	   {   
		   //If the entity for editing is address
		   if(entity == "address")
		   {
			   String[] Splitted = ReadLine.split("~");
			   Splitted[2] = value;
			   out.write(String.join("~",Splitted));
		   }
		   
		   //If the entity for editing is birthdate
		   else if(entity == "birthdate")
		   {
			   String[] Splitted = ReadLine.split("~");
			   Splitted[3] = value;
			   out.write(String.join("~",Splitted));
		   }
		   
		   //If the entity for editing is bio
		   else if(entity == "bio")
		   {
			   String[] Splitted = ReadLine.split("~");
			   Splitted[4] = value;
			   out.write(String.join("~",Splitted));
		   }
		   
		   //If the entity for editing is occupations
		   else if(entity == "occupations")
		   {
			   String[] Splitted = ReadLine.split("~");
			   Splitted[5] = value;
			   out.write(String.join("~",Splitted));
		   }
		   
		   //If the entity for editing is genres
		   else if(entity == "genres")
		   {
			   String[] Splitted = ReadLine.split("~");
			   Splitted[6] = value;
			   out.write(String.join("~",Splitted));
		   }
		   
		   //If the entity for editing is awards
		   else if(entity == "awards")
		   {
			   String[] Splitted = ReadLine.split("~");
			   Splitted[7] = value;
			   out.write(String.join("~",Splitted));
		   }
		   
		   //Closing all streams and open files
		   in.close();
		   out.close();
		   Reader.close();
		   
		   //Reading the source file
		   File TempFile = new File("C:\\Users\\Asus\\eclipse-workspace\\SEAssignment4\\src\\temp.txt");
		   
		   //Deleting the source file since changes are written to temp file
		   Files.deleteIfExists(Paths.get("C:\\Users\\Asus\\eclipse-workspace\\SEAssignment4\\src\\artists.txt"));
		   
		   //Renaming temp file to source file name
		   Files.move(Paths.get("C:\\Users\\Asus\\eclipse-workspace\\SEAssignment4\\src\\temp.txt"), Paths.get("C:\\Users\\Asus\\eclipse-workspace\\SEAssignment4\\src\\artists.txt"),REPLACE_EXISTING);
		   
	   }
	 }
	   return true; 
	 }
	 catch(Exception E)
	 {
		 return false;
	 }
	 finally
	 {
		   in.close();
		   out.close();
		   Reader.close();
	 }
 }
 
 
 //Method to update the artist details. Required parameters are passed or as null if not required
 public boolean updateArtist(String id , String name, String address, String birthdate, String bio,
	       ArrayList<String> occupations, ArrayList<String> genres, ArrayList<String> awards, int awardno)
 {
	 try
	 {
	 boolean Status = true;
	 
	 //There should be a valid ID to perform an updation
	 if(id == null)
	 {
		 return false;
	 }
	 
	 //If there is an ID supplied, check if it is a valid one
	 else
	 {
		 //Reading the source file
		 FileReader in = new FileReader("D:\\Personal\\SE\\Assignment 4\\artists.txt");
		 BufferedReader Reader = new BufferedReader(in);
		 String line;
		 
		 //Reading each line in the file
		 while((line = Reader.readLine()) != null)
		 {
			 //If there is an artist with the given ID
			 if(line.split("~")[0].strip().trim().toUpperCase().equals(id.strip().trim().toUpperCase()))
			 {
				 
				 //Update address if all conditions are met
				 if(address != null)
				 { 
				   //Checking address format
				  for(int i =0;i<address.split("\\|").length;i++)
				  {
					  if(address.split("\\|")[i].trim() == "")
					 {
						  return false;
					  }
					  else
					  {
						  Status = true;
					  }
					  
				  }
				  
				  //Checking if there are three elements in the address
				  if(address.split("\\|").length == 3)
				  {
					  Status = true;
				  }
				  else
				  {
				    return false;
				  }
				 
				 //Calling update file with the data
				 UpdateFile("address",id,address);
				 }
				 
				 //Update date of birth if format is correct
				 if(birthdate != null)
				 {		 
			     SimpleDateFormat SimpleDate = new SimpleDateFormat("dd-MM-yyyy");
			     SimpleDate.setLenient(false);
				 Date Convertedbirthdate=SimpleDate.parse(birthdate);
				 
				 //Calling update file with the data
				 UpdateFile("birthdate",id,birthdate);
				 }
				 
				 //Update bio if all conditions are met
				 if(bio != null)
				 {
					//Checking word count of bio (>=10 and <=30)
					  if(bio.split(" ").length >= 10 && bio.split(" ").length <= 30)
					  {
						  //Calling update file with the data
						  UpdateFile("bio",id,bio);
					  }
					  else
					  {
						  return false;
					  }
				 }
				 
				 //Update occupations if all conditions are met
				 if(occupations != null)
				 {
					  if(occupations.size() >= 1 && occupations.size() <= 5)
					  {
						  //Calling update file with the data
						  UpdateFile("occupations",id,String.join(",", occupations));
					  }
					  
					  else
					  {
						  return false;
					  }
				 }
				 
				 //Update genres if all conditions are met
				 if(genres != null)
				 {
					 if(genres.size() >= 2 && genres.size() <= 5)
					  {
						 //Genres should not contain pop and rock at the same time
						  if(genres.stream().map(x->x.toLowerCase()).toList().contains("pop") && genres.stream().map(x->x.toLowerCase()).toList().contains("rock"))
						  {
							  return false;
						  }
						  else
						  {
							  //Calling update file with the data
							  UpdateFile("genres",id,String.join(",", genres));
						  }
					  }
					  else
					  {
						  return false;
					  }
				 }
				 
				 //Update awards if all conditions are met
				 if(awards != null)
				 {
				 //Splitting awards line into array
				 String[] awards_line = line.split("~")[line.split("~").length-1].split(",");
				 ArrayList<String> awards_file = new ArrayList<String>();
				 
				 //Joining year and title of awards in comma separated format
				 for(int i = 0;i<awards_line.length;i+=2)
				 {
				   	 awards_file.add(awards_line[i] + "," + awards_line[i+1]);
				 }
				 
				 //If award year is less than 2000, then editing is not allowed
				 if(Integer.parseInt(awards_file.get(awardno).split(",")[0]) < 2000)
				 {
					 return false;
				 }
				 else
				 {
					 //Update the awards data
					 awards_file.set(awardno, awards.get(0));
					 
					 //Calling update file with the data
					 UpdateFile("awards",id,String.join(",", awards_file));
				 }
				 }
				  
			 }
			 else
			 {
				 return false;
			 }
		 }
	 }
	 return true;
	 }
	 catch(Exception E)
	 {
		 return false;
	 }
 }
}

