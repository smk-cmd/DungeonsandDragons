import java.io.*;
import java.util.*;

public class Map
{
    private static Map instance;
    private char[][]map;
    private boolean [][]revealed;

    /* A private map constructor that initializes the map and the boolean revealed array
     */
    private Map()
    {
        map = new char[5][5];
        revealed = new boolean[5][5];
    }

    /* Creates an instance of a map if there isn't one already
     * @return The instance of the map
     */
    public static Map getInstance()
    {
        if (instance == null)
        {
            instance = new Map();
        }

        return instance;
    }

    /* This will load the map from a text file depending on the Hero's level and fill the revealed map with false values
     * @param mapNum The int value of the Hero's current level
     */
    public void loadMap(int mapNum)
    {
        try
        {
            String mapString = Integer.toString(mapNum);
            String input = "Map" + mapString + ".txt";

            Scanner read = new Scanner(new File(input));

            while (read.hasNextLine())
            {
                for(int i = 0; i < 5; i++)
                {
                    String line = read.nextLine();
                    String[]locations = line.split(" ");
                    for(int j = 0; j < 5; j++)
                    {
                        map[i][j] = locations[j].charAt(0);
                    }
                }
            }
            read.close();
        }

        catch(FileNotFoundException fnf)
        {
            System.out.println("File was not found");
        }

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                revealed[i][j] = false;
            }
        }
    }

    /* Used to return the char value on a specific coordinate on the map
     * @param p The point object carrying the coordinates of a location on the map
     * @return The char value at the give coordinate point
     */
    public char getCharAtLoc(Point p)
    {
        return map[p.x][p.y];
    }

    /* Transfers the contents of the map onto a string
     * @param p The point object carrying the coordinates of the Hero's current location
     * @return The String containing the revealed and unrevealed locations of the map. Also contains the Hero's location
     */
    public String mapToString(Point p)
    {
        String mapString = "";
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (i == p.x && j == p.y)
                {
                    mapString = mapString + "* ";
                }

                else if (revealed[i][j] == false)
                {
                    mapString = mapString + "x ";
                }

                else
                {
                    mapString = mapString + map[i][j] + " ";
                }
            }
            mapString = mapString + "\n";
        }

        return mapString;
    }

    /* Finds the location of where the Hero should start on each level
     * @return The Point coordinates of the Hero's starting position
     */
    public Point findStart()
    {
        Point start = new Point();
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (map[i][j] == 's')
                {
                    start = new Point(i,j);
                    break;
                }
            }
        }
        return start;
    }

    /* Reveals the Hero's location by converting the boolean value in the revealed array to true.
     * @param p The Hero's current location
     */
    public void reveal(Point p)
    {
        int x = p.x;
        int y = p.y;

        revealed[x][y] = true;
    }

    /* Converts the discovered areas to rooms with nothing except the start and the floor exits (to prevent softlocks).
     * @param p The Hero's current coordinate location
     */
    public void removeCharAtLoc(Point p)
    {
        if (map[p.x][p.y] != 'f' && map[p.x][p.y] != 's')
        {
            map[p.x][p.y] = 'n';
        }
    }
}