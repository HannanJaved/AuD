//-----------------------------------------------------------------//
public class Food {
  //---------------------------------------------------------------//
  // TODO: attributes and constructor
  String Oberbegriff;
  String Bezeichnung;

	public Food(String Oberbegriff, String Bezeichnung) {
		this.Oberbegriff = Oberbegriff;
		this.Bezeichnung = Bezeichnung;
	}

  //---------------------------------------------------------------//
  public int hashCode() {
    // TODO: implementation
    return Oberbegriff.hashCode() + Bezeichnung.hashCode();
   }

  //---------------------------------------------------------------//
   public String toString() {
      // TODO: implementation
	  return Oberbegriff + " : " + Bezeichnung;
   }

}