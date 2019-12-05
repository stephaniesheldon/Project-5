# Project-5

Main


start(Stage primaryStage)

This method is where the scene is added to the stage. Here all buttons, sliders, text fields are initialized.The layout that is used for this scene is gridpane.This method includes all event handlers for buttons and ssliders.


showStationPress()

This method is called on when the show station button is pressed. First two values are retrieved from the graphic, the slider value and the station in the the combo box. Calls HDStationList which return an arrayList of the stations that have the hamming distance selected, which is displayed in the Text Area.


calcHDPress()

This method is called on when the calculate HD button is pressed.  First two values are retrieved from the graphic, the slider value and the station in the the combo box. It calls checkNumberDistances to return a hashmap with a key of speciified distance and values of how many stations at those distances. This is displayed in corresponding text fields.


addStationPress()

This method is called when add station is pressed. This method gets the string the user inputs in the text field and checks of it is four characters long. If it is, it calls addStation and updates the combo box holding all of the stations.


showCombinatinos()

This mthod is called when the show combinations button is pressed. Calls fidCombinations from Combinations class which returns an arrayList of all strings. Then the text area for the combinations is updated.






StationList

private ArrayList<String> stationList - original arrayList from file
private HashSet<String> stationSet - original arrayList and stations that are added
ashSet<String> stationSet - holds the same stations as the hashset



public StationList()

This is the constructor for the class. Calls on read to parse the file.


public void read()

This method reads from the Mesonet.txt file and parses it for stations. The stations are added to an arrayList and sorted.


public ArrayList<String> HDStationList(int hd, String id)

Returns a list of stations that are the hamming distance away from the input hd of the stirng id.


public Boolean sameHD(int hd, String station, String userStation)

checks if the hamming distance between to stations is the same as the hamming distance specified.


public HashMap<Integer,Integer> checkNumberDistances(String id)

Creates and returns a hashmap of distances and number of stations at that distance.


public int NumOfStations(int distance, String id)

Returns the total number of stations that are distaance away from id.


public ArrayList<String> getStationList()

returns StationLIst


public HashSet<String> getStationSet()

return stationSet


public ArrayList<String> getSetToList()

retuens setToList

public void addStation(String newStation)

Adds the newStation to the set so no duplicates occur then clears the setToList and adds the hashSet to it and the sorts the setToList.





Combinations

public static ArrayList<String> findCombinations(String station)

This method takes the input string and finds all possible combinations, excluding repeats, of its characters. It returns a sorted array list of all these strings.
