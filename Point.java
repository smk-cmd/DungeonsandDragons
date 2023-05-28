public class Point
{
    public int x;
    public int y;

    public Point()
    {
        x = 0;
        y = 0;
    }

    /* Constructs a point with coordinate values
     * @param row The row coordinate value
     * @param col The column coordinate value
     */
    public Point(int row, int col)
    {
        x = row;
        y = col;
    }

    /* Increments and decrements the x value of the point object
     * @param dx The amount to increment or decrement
     */
    public void addX(int dx)
    {
        x = x + dx;
        if (x < 0)
        {
            x = 0;
        }

        if (x > 4)
        {
            x = 4;
        }
    }

    /* Increments and decrements the y value of the point object
     * @param dy The amount to increment or decrement
     */
    public void addY(int dy)
    {
        y = y + dy;
        if (y < 0)
        {
            y = 0;
        }

        if (y > 4)
        {
            y = 4;
        }
    }
}
